package com.findandfix.carowner.ui.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.FragmentHomeBinding;
import com.findandfix.carowner.model.global.RequestOfferObj;
import com.findandfix.carowner.model.global.UrgentRequestOfferObj;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.request.NormalRequestDetailObject;
import com.findandfix.carowner.model.request.UrgentRequestDetailObject;
import com.findandfix.carowner.model.response.ActiveNormalRequestResponse;
import com.findandfix.carowner.model.response.ActiveUrgentRequestResponse;
import com.findandfix.carowner.model.response.RequestOfferResponse;
import com.findandfix.carowner.model.response.UrgentRequestOfferResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.ui.activities.ActivityAddUrgentRequestLocation;
import com.findandfix.carowner.ui.activities.AddRequestCarInfoActivity;
import com.findandfix.carowner.ui.activities.EditProfileInfoActivity;
import com.findandfix.carowner.ui.activities.FindRequestsActivity;
import com.findandfix.carowner.ui.activities.FixationPaperActivity;
import com.findandfix.carowner.ui.activities.OffersActivity;
import com.findandfix.carowner.ui.activities.RequestDetailActivity;
import com.findandfix.carowner.ui.activities.UrgentOffersActivity;
import com.findandfix.carowner.ui.activities.UrgentRequestDetailActivity;
import com.findandfix.carowner.ui.activities.WaitingOffersUrgentActivity;
import com.findandfix.carowner.ui.activities.WorkShopOffersActivity;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.viewmodel.HomeFragViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


/**
 * Created by DELL on 12/03/2018.
 */

public class HomeFragment extends Fragment implements BaseInterface{
    FragmentHomeBinding binding;
    private HomeFragViewModel viewModel;
    private UserData userData;
    private boolean activeRequestLoading=false;
    private boolean activeUrgentLoading=false;
    MediaPlayer mp ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false);
        View v=binding.getRoot();
        mp=MediaPlayer.create(getActivity(),R.raw.a1);
        userData=CustomUtils.getInstance().getSaveUserObject(getActivity().getApplicationContext());
        viewModel=new HomeFragViewModel(getActivity(),this);
        binding.setViewModel(viewModel);
        handlAnimation();
        return v;}

    @Override
    public void updateUi(int code) {
        if(code== ConfigurationFile.Constants.COMPLETE_ANIMATION_CODE) {
            completeImage();
           try {
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(getActivity(), R.raw.a1);
                }mp.start();
            } catch(Exception e) {
                System.out.println(" Sound Ex :"+e.getMessage());
                e.printStackTrace(); }

        }else if(code== ConfigurationFile.Constants.NORMAL_REQUEST_ACTIVITY) {
            //  startActivity(new Intent(getActivity(),AddRequestCarInfoActivity.class));

            if (!activeRequestLoading) {
                getCarOwnerActiveRequests();
                activeRequestLoading = true;
            }
        } else if(code== ConfigurationFile.Constants.URGENT_REQUEST_ACTIVITY) {
               if(! activeUrgentLoading) {
                   getCarOwnerActiveUrgentRequests();
                  activeUrgentLoading=true;
               }
          /*  startActivity(new Intent(getActivity(), ActivityAddUrgentRequestLocation.class));
            System.out.println("Home Frag Urgent Request Act");*/
        } else if(code== ConfigurationFile.Constants.EDIT_PROFILE_ACTIVITY)
            startActivity(new Intent(getActivity(),EditProfileInfoActivity.class));
           // System.out.println("Home Frag Edit Profile Act");
        else if(code== ConfigurationFile.Constants.ADVERTISEMENT_ACTIVITY)
            startActivity(new Intent(getActivity(),OffersActivity.class));
    }

    public void handlAnimation(){
       binding.animationView.playAnimation();
        binding.animationView.setMaxProgress(0.3F);
    }

    public void completeImage(){
        binding.animationView.playAnimation();
        binding.animationView.setMinProgress(0.3F);
        binding.animationView.setMaxProgress(1.0F);}
/////////////////////////////////////////////////////////Normal Request /////////////////////////////////////////////////////////////////////

         public void getCarOwnerActiveRequests(){


        if (NetWorkConnection.isConnectingToInternet(getActivity())) {
           // binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(getActivity());
            ApiClient.getClient().create(EndPoints.class).getCarOwnerActiveRequests(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getActivity()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(activeNormalRequestResponseResponse -> {
                        System.out.println("Message Of Request Details CODE :"+activeNormalRequestResponseResponse.code());
                      //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (activeNormalRequestResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){
                          //  System.out.println("Message Of Request Details CODE SERVER ID:"+activeNormalRequestResponseResponse.body();
                            ActiveNormalRequestResponse activeNormalRequestResponse=activeNormalRequestResponseResponse.body();
                            NormalRequestDetailObject normalRequestDetailObject=activeNormalRequestResponse.getData();
                                if (normalRequestDetailObject!=null) {
                                    System.out.println("Message Of Request Details CODE Basic Id:"+normalRequestDetailObject.getId());
                                    getRequestOffers(normalRequestDetailObject.getId(),normalRequestDetailObject);
                            }else {
                                    activeRequestLoading=false;
                                Intent i=new Intent(getActivity(), FixationPaperActivity.class);
                                startActivity(i);
                            }

                        }
                        // moveToNextAct();
                        else if (activeNormalRequestResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                activeNormalRequestResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                            CustomUtils.getInstance().endSession(getActivity());
                        }
                        else if (activeNormalRequestResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(getActivity().findViewById(R.id.drawer), R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                      //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(getActivity().findViewById(R.id.drawer),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }





    public void getRequestOffers(int requestId,NormalRequestDetailObject normalRequestDetailObject){
        System.out.println("Message Of Request Details CODE Sent Id:"+requestId);

        if (NetWorkConnection.isConnectingToInternet(getActivity())) {
            //binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(getActivity());
            ApiClient.getClient().create(EndPoints.class).getRequestOffers(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getActivity()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),requestId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(requestOfferResponseResponse -> {
                        System.out.println("Message Of Request Details CODE Offers Response :"+new Gson().toJson(requestOfferResponseResponse));
                        System.out.println("Message Of Request Details CODE Offers :"+requestOfferResponseResponse.code());
                      //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (requestOfferResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){

                            RequestOfferResponse requestOfferResponse=requestOfferResponseResponse.body();
                            ArrayList<RequestOfferObj>items= requestOfferResponse.getData();
                            if (items.size()>0) {
                                if (items.get(0).getAccepted() == 1) {
                                    activeRequestLoading=false;
                                    System.out.println("Message Of Request Details CODE Offers Request Detail");
                                    Intent i = new Intent(getActivity(), RequestDetailActivity.class);
                                    i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_OFFER_OBJ, items.get(0));
                                    i.putExtra(ConfigurationFile.IntentsConstants.REQUESt_DETAIL_OBJ,normalRequestDetailObject);
                                    startActivity(i);
                                } else {
                                    activeRequestLoading=false;
                                    System.out.println("Message Of Request Details CODE Offers Offers");
                                    Intent i = new Intent(getActivity(), WorkShopOffersActivity.class);
                                    i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_OFFERS, items);
                                    i.putExtra(ConfigurationFile.IntentsConstants.REQUESt_DETAIL_OBJ,normalRequestDetailObject);
                                    startActivity(i);
                                }
                            }else {
                                activeRequestLoading=false;
                                System.out.println("Message Of Request Details CODE Offers New Act");
                                Intent i = new Intent(getActivity(), FindRequestsActivity.class);
                                i.putExtra(ConfigurationFile.IntentsConstants.NORMAL_REQUEST_ID,requestId);
                                startActivity(i);
                            }
                        }
                        // moveToNextAct();
                        else if (requestOfferResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE){
                           CustomUtils.getInstance().logout(getActivity());
                        } else if (requestOfferResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                            CustomUtils.getInstance().endSession(getActivity());
                        } else if (requestOfferResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(getActivity().findViewById(R.id.drawer), R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                        CustomUtils.getInstance().cancelDialog();
                       // binding.progressBar.setVisibility(View.GONE);
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(getActivity().findViewById(R.id.drawer),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////Urgent Request //////////////////////////////////////////////////////////////////////////////////

    public void getCarOwnerActiveUrgentRequests(){


        if (NetWorkConnection.isConnectingToInternet(getActivity())) {
            //binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(getActivity());
            ApiClient.getClient().create(EndPoints.class).getCarOwnerActiveUrgentRequest(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getActivity()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(activeUrgentRequestResponseResponse -> {
                        System.out.println("Message Of Request Details CODE :"+activeUrgentRequestResponseResponse.code());
                      //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (activeUrgentRequestResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){
                            //  System.out.println("Message Of Request Details CODE SERVER ID:"+activeNormalRequestResponseResponse.body();
                            ActiveUrgentRequestResponse activeUrgentRequest=activeUrgentRequestResponseResponse.body();
                            UrgentRequestDetailObject urgentRequestDetailObject=activeUrgentRequest.getData();
                            if (urgentRequestDetailObject!=null) {
                                System.out.println("Message Of Urgent Request Details CODE Basic Id:"+urgentRequestDetailObject.getId());
                                getUrgentRequestOffers(urgentRequestDetailObject.getId(),urgentRequestDetailObject);
                            }else {
                                activeUrgentLoading=false;
                                Intent i=new Intent(getActivity(), ActivityAddUrgentRequestLocation.class);
                                startActivity(i);
                            }

                        }
                        // moveToNextAct();
                        else if (activeUrgentRequestResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                activeUrgentRequestResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                           CustomUtils.getInstance().endSession(getActivity());
                        }
                        else if (activeUrgentRequestResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(getActivity().findViewById(R.id.drawer), R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                      //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(getActivity().findViewById(R.id.drawer),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }





    public void getUrgentRequestOffers(int urgentRequestId,UrgentRequestDetailObject urgentRequestDetailObject){
        System.out.println("Message Of Urgent  Request Details CODE Sent Id:"+urgentRequestId);

        if (NetWorkConnection.isConnectingToInternet(getActivity())) {
           // binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(getActivity());
            ApiClient.getClient().create(EndPoints.class).getUrgentRequestOffers(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getActivity()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(urgentRequestOfferResponseResponse -> {
                        System.out.println("Message Of Request Details CODE Offers :"+urgentRequestOfferResponseResponse.code());
                    //    binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (urgentRequestOfferResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){

                            UrgentRequestOfferResponse urgentRequestOfferResponse=urgentRequestOfferResponseResponse.body();
                            ArrayList<UrgentRequestOfferObj>items= urgentRequestOfferResponse.getData();
                            if (items.size()>0) {
                                activeUrgentLoading=false;
                                if (items.get(0).getAccepted() == 1) {
                                    System.out.println("Message Of Request Details CODE Offers Request Detail");
                                    Intent i = new Intent(getActivity(), UrgentRequestDetailActivity.class);
                                    i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_URGENT_OFFER, items.get(0));
                                    i.putExtra(ConfigurationFile.IntentsConstants.URGENT_REQUESt_DETAIL_OBJ,urgentRequestDetailObject);
                                    startActivity(i);
                                } else {
                                    System.out.println("Message Of Request Details CODE Offers Offers");
                                    Intent i = new Intent(getActivity(), UrgentOffersActivity.class);
                                    i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_URGENT_OFFERS, items);
                                    i.putExtra(ConfigurationFile.IntentsConstants.URGENT_REQUESt_DETAIL_OBJ,urgentRequestDetailObject);
                                    startActivity(i);
                                }
                            }else {
                                activeUrgentLoading=false;
                                System.out.println("Message Of Request Details CODE Offers New Act");
                                Intent i = new Intent(getActivity(), WaitingOffersUrgentActivity.class);
                                i.putExtra(ConfigurationFile.IntentsConstants.URGENT_REQUEST_ID,urgentRequestId);
                                startActivity(i);
                            }
                        }
                        // moveToNextAct();
                        else if (urgentRequestOfferResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                urgentRequestOfferResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                                CustomUtils.getInstance().endSession(getActivity());
                        }
                        else if (urgentRequestOfferResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(getActivity().findViewById(R.id.drawer), R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                       // binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(getActivity().findViewById(R.id.drawer),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
