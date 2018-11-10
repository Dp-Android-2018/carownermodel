package com.findandfix.carowner.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityForgotPasswordLayoutBinding;
import com.findandfix.carowner.model.request.GetMobileCode;
import com.findandfix.carowner.model.response.DefaultResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ForgetPasswordMobileActivity extends BaseActivity {

    ActivityForgotPasswordLayoutBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_forgot_password_layout);
        binding.btnLoginEnter.setOnClickListener(v -> {
                if (binding.etMobile.getText().toString().trim().equals("")){
                    Snackbar.make(findViewById(R.id.rl_parent), R.string.please_enter_data,Snackbar.LENGTH_LONG).show();
                }else {
                    checkMobile();
                }
        });
    }

    public void checkMobile(){

        if (NetWorkConnection.isConnectingToInternet(ForgetPasswordMobileActivity.this)) {
            CustomUtils.getInstance().showProgressDialog(ForgetPasswordMobileActivity.this);
            GetMobileCode getMobileCode=new GetMobileCode(binding.etMobile.getText().toString().trim());
            ApiClient.getClient().create(EndPoints.class).getRestToken(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,getMobileCode)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(defaultResponseResponse -> {
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Mobile Code  :"+defaultResponseResponse.code());

                        if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {

                            Intent i=new Intent(ForgetPasswordMobileActivity.this,ForgetPasswordCodeActivity.class);
                            startActivity(i);
                        }else if (defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                            CustomUtils.getInstance().endSession(ForgetPasswordMobileActivity.this);
                        } else if (defaultResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
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
}
