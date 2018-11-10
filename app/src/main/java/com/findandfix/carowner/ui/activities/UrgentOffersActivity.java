package com.findandfix.carowner.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityWorkshopOffersLayoutBinding;
import com.findandfix.carowner.model.global.Notification;
import com.findandfix.carowner.model.global.Payload;
import com.findandfix.carowner.model.global.RequestOfferObj;
import com.findandfix.carowner.model.global.UrgentRequestOfferObj;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.request.AcceptedOfferNotification;
import com.findandfix.carowner.model.request.UrgentRequestDetailObject;
import com.findandfix.carowner.model.response.DefaultResponse;
import com.findandfix.carowner.model.response.UrgentRequestOfferResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.ui.adapters.FoldingUrgentCellListAdapter;
import com.findandfix.carowner.ui.callback.AchievmentItemClickListener;
import com.findandfix.carowner.ui.callback.RecycleItemClickListener;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class UrgentOffersActivity extends BaseActivity {
    private ProgressBar progressBar;
    private UserData userData;
    ArrayList<UrgentRequestOfferObj> items=null;
    private UrgentRequestOfferObj urgentRequestOfferObj=null;
    private FoldingUrgentCellListAdapter adapter=null;
    private int urgentrequestid=0;
    private ActivityWorkshopOffersLayoutBinding binding;
    private UrgentRequestDetailObject urgentRequestDetailObject=null;

    /////////////////////////////////////////////////////
    private boolean loading=false;
    private String next=null;
    private int pageId=0;
    private int pos=0;

    ////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_workshop_offers_layout);
        // get our list view
        setUpActionBar();
        userData= CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
        // prepare elements to display
        items = new ArrayList<>();
        loading=true;
        getUrgentOffersData();
        //  getRequestOffers();

        // get our list view


    }

    public void getUrgentOffersData(){
        if (getIntent()!=null) {
            if (getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.WORKSHOP_URGENT_OFFERS)!=null) {
                items = (ArrayList<UrgentRequestOfferObj>) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.WORKSHOP_URGENT_OFFERS);
                urgentRequestDetailObject=(UrgentRequestDetailObject) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.URGENT_REQUESt_DETAIL_OBJ);
                setAdapter();
            }else if (getIntent().getIntExtra(ConfigurationFile.IntentsConstants.REQUEST_ID,0)!=0){

                ////////////////////////IN Notification CASE /////////////////////////////////////////////////////////
                urgentrequestid=getIntent().getIntExtra(ConfigurationFile.IntentsConstants.REQUEST_ID,0);


                System.out.println("Log Urgent Noti urgentrequestid :"+urgentrequestid);
                getUrgentRequestOffers();
            }
        }
    }


    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(UrgentOffersActivity.this, ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_DETAIL_TOOLBAR)); }
    public void getUrgentRequestOffers(){


        if (NetWorkConnection.isConnectingToInternet(UrgentOffersActivity.this)) {
         //   binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(UrgentOffersActivity.this);
            ApiClient.getClient().create(EndPoints.class).getUrgentRequestOffers(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(urgentRequestOfferResponseResponse -> {
                        System.out.println("Message Of Request CODE :"+urgentRequestOfferResponseResponse.code());
                       // binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (urgentRequestOfferResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){

                            UrgentRequestOfferResponse urgentRequestOfferResponse=urgentRequestOfferResponseResponse.body();
                            items= urgentRequestOfferResponse.getData();

                            setAdapter();
                        }
                        // moveToNextAct();
                        else if (urgentRequestOfferResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                urgentRequestOfferResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                           CustomUtils.getInstance().endSession(UrgentOffersActivity.this);
                        }
                        else if (urgentRequestOfferResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(findViewById(R.id.rl_parent), R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                        CustomUtils.getInstance().cancelDialog();
                      //  binding.progressBar.setVisibility(View.GONE);
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(findViewById(R.id.rl_parent),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }


    public void acceptWorkOffer(UrgentRequestOfferObj  offerObj){


        if (NetWorkConnection.isConnectingToInternet(UrgentOffersActivity.this)) {
          //  binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(UrgentOffersActivity.this);
            Notification notification=new Notification();
            notification.setKey(6);
            notification.setDeviceToken(offerObj.getWorkshop().getDeviceToken());
            Payload payload=new Payload();
            payload.setNotificationTitle("offer_accepted_urgent");
            payload.setOfferId(String.valueOf(offerObj.getId()));
            payload.setKey(6);
            notification.setData(payload);
            AcceptedOfferNotification acceptedOfferNotification=new AcceptedOfferNotification();
            acceptedOfferNotification.setNotification(notification);
            ApiClient.getClient().create(EndPoints.class).acceptUrgentWorkShopOffer(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),acceptedOfferNotification,offerObj.getId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(defaultResponseResponse -> {
                        System.out.println("Message Of Urgent Request CODE OFFERS WORKSHOP :"+defaultResponseResponse.code());
                        //binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){
                           Intent i=new Intent(getApplicationContext(),UrgentRequestDetailActivity.class);
                            i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_URGENT_OFFER,offerObj);
                            i.putExtra(ConfigurationFile.IntentsConstants.URGENT_REQUESt_DETAIL_OBJ,urgentRequestDetailObject);

                            startActivity(i);
                            finish();
                            finishAffinity();
                            System.out.println("Log Urgent Noti OfferObj:"+offerObj.getId());
                            System.out.println("Log Urgent Noti urgent request obj: "+urgentRequestDetailObject.getType().getName());
                            System.out.println("Message Of Urgent Request CODE OFFERS WORKSHOP Offers Accepted");

                        }
                        // moveToNextAct();
                        else if (defaultResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE ){
                            CustomUtils.getInstance().endSession(UrgentOffersActivity.this);
                        }
                        else if (defaultResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(findViewById(R.id.rl_parent), R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                        //binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(findViewById(R.id.rl_parent),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }

    public void setAdapter(){
        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        adapter = new FoldingUrgentCellListAdapter(this, items);

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(v -> Toast.makeText(getApplicationContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show());

        // set elements to adapter
        binding.mainListView.setAdapter(adapter);

        // set on click event listener to list view
        binding.mainListView.setOnItemClickListener((adapterView, view, pos, l) -> {
            // toggle clicked cell state
            ((FoldingCell) view).toggle(false);
            // \\register in adapter that state for selected cell is toggled
            adapter.registerToggle(pos);
        });

        adapter.setListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                System.out.println("Accept Urgent Position :"+position);
                acceptWorkOffer(items.get(position));
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {
              //  acceptWorkOffer(offerObj);
            }
        });

        adapter.setAchievmentItemClickListener(workshopId -> {
            Intent i=new Intent(getApplicationContext(),WorkShopAchievmentActivity.class);
            i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_ID,workshopId);
            startActivity(i);
        }

        );

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(UrgentOffersActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
