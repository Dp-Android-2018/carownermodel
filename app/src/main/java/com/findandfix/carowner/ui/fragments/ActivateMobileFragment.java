package com.findandfix.carowner.ui.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityActivationCodeLayoutBinding;
import com.findandfix.carowner.model.global.CheckActivationCodeRequest;
import com.findandfix.carowner.model.global.SendActivationCodeRequest;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.response.DefaultResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.utils.SharedPrefrenceUtils;
import com.findandfix.carowner.ui.activities.ActivationCodeActivity;
import com.findandfix.carowner.ui.activities.SplashActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by DELL on 15/09/2018.
 */

public class ActivateMobileFragment extends Fragment {
    ActivityActivationCodeLayoutBinding binding;
    private UserData userData;
    private CheckActivationCodeRequest checkActivationCodeRequest;
    private SharedPrefrenceUtils pref;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.activity_activation_code_layout,container,false);
        View view=binding.getRoot();
         userData=CustomUtils.getInstance().getSaveUserObject(getActivity());
        binding.btnActiveMobile.setOnClickListener(v -> {
            if (!binding.etActivateCode.getText().toString().equals(""))
                checkActivationCode();
            else  Snackbar.make(binding.getRoot(), R.string.enter_code, Snackbar.LENGTH_LONG).show();
        });

        binding.btnActiveMail.setOnClickListener(v -> {
            sendActivationMail();
        });
        return view;
    }


    public void checkActivationCode(){
        if(NetWorkConnection.isConnectingToInternet(getActivity())) {
            checkActivationCodeRequest=new CheckActivationCodeRequest(binding.etActivateCode.getText().toString());
            System.out.println("Request Data :"+new Gson().toJson(checkActivationCodeRequest));
            CustomUtils.getInstance().showProgressDialog(getActivity());
            ApiClient.getClient().create(EndPoints.class).checkActivationCode(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(getActivity()), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, "Bearer "+userData.getToken(),checkActivationCodeRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<DefaultResponse>>() {
                        @Override
                        public void accept(Response<DefaultResponse> defaultResponseResponse) throws Exception {
                            CustomUtils.getInstance().cancelDialog();
                            System.out.println("Code :"+defaultResponseResponse.code());
                         //   System.out.println("Message :"+defaultResponseResponse.body().getMessage());
                            if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                                userData.setConfirmed(1);
                                saveDataToPrefs(userData);
                                Intent i=new Intent(getActivity(),SplashActivity.class);
                                startActivity(i);
                            }else if (defaultResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                                Snackbar.make(getActivity().findViewById(R.id.drawer), R.string.invalid_code_checker,Snackbar.LENGTH_LONG).show();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            CustomUtils.getInstance().cancelDialog();
                            System.out.println("ActivationCodeActivity Ex:"+throwable.getMessage());
                        }
                    });
        }else {
            Snackbar.make(binding.getRoot(), R.string.msg_internet_connection,Snackbar.LENGTH_LONG).show();
        }
    }


    public void sendActivationMail(){
        if(NetWorkConnection.isConnectingToInternet(getActivity())) {
            checkActivationCodeRequest=new CheckActivationCodeRequest(binding.etActivateCode.getText().toString());
            System.out.println("Request Data :"+new Gson().toJson(checkActivationCodeRequest));
            CustomUtils.getInstance().showProgressDialog(getActivity());
            ApiClient.getClient().create(EndPoints.class).sendActivationMail(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(getActivity()), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, "Bearer "+userData.getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<DefaultResponse>>() {
                        @Override
                        public void accept(Response<DefaultResponse> defaultResponseResponse) throws Exception {
                            CustomUtils.getInstance().cancelDialog();
                            System.out.println("Code :"+defaultResponseResponse.code());
                            //   System.out.println("Message :"+defaultResponseResponse.body().getMessage());
                            if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                                Intent i=new Intent(getActivity(),ActivationCodeActivity.class);
                                getActivity().startActivity(i);
                            }else if (defaultResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                                Snackbar.make(getActivity().findViewById(R.id.drawer), R.string.try_again_later,Snackbar.LENGTH_LONG).show();
                        }

                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            CustomUtils.getInstance().cancelDialog();
                            System.out.println("ActivationCodeActivity Ex:"+throwable.getMessage());
                        }
                    });
        }else {
            Snackbar.make(binding.getRoot(), R.string.msg_internet_connection,Snackbar.LENGTH_LONG).show();
        }
    }

    public void saveDataToPrefs(UserData data){
        pref=new SharedPrefrenceUtils(getActivity());
        pref.saveObjectToSharedPreferences(ConfigurationFile.SharedPrefConstants.PREF_CAR_OWNER_OBJ_DATA,data);
    }
}
