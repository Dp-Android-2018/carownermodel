package com.findandfix.carowner.ui.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.google.gson.Gson;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityAddRequestNotesBinding;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.request.AddNormalRequest;
import com.findandfix.carowner.model.response.AddUrgentRequestResponse;
import com.findandfix.carowner.model.response.DefaultResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class AddRequestNotesActivity extends BaseActivity {
    ActivityAddRequestNotesBinding binding;
    private AddNormalRequest addNormalRequest;
    private UserData userData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(AddRequestNotesActivity.this, R.layout.activity_add_request_notes);
        setUpToolBar();
        getExtraFromIntents();
        getUserData();
        binding.btnNext.setOnClickListener(v -> AddNormalRequest());

    }
    public void getExtraFromIntents(){
        addNormalRequest=(AddNormalRequest)getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ);
    }

    public void getUserData() {
        userData= CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
    }
    public void setUpToolBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(AddRequestNotesActivity.this, ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_SECONDARY_TOOLBAR));
    }

    @SuppressLint("CheckResult")
    public void AddNormalRequest(){


            if (NetWorkConnection.isConnectingToInternet(AddRequestNotesActivity.this)) {
             //   binding.progressBar.setVisibility(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog(AddRequestNotesActivity.this);
                addNormalRequest.setNotes(((binding.rlAddRequestNotes.getText().toString().trim()==null)||((binding.rlAddRequestNotes.getText().toString().trim().equals(""))))?null:binding.rlAddRequestNotes.getText().toString().trim());
                addNormalRequest.setWinch(0);
                addNormalRequest.setCityId(userData.getCity().getId());
                System.out.println("Message Of Request 1 :"+new Gson().toJson(addNormalRequest));
                ApiClient.getClient().create(EndPoints.class).addNormalRequest(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),addNormalRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(defaultResponseResponse -> {
                            System.out.println("Message Of Request CODE :"+defaultResponseResponse.code());
                          //  binding.progressBar.setVisibility(View.GONE);
                            CustomUtils.getInstance().cancelDialog();
                            if (defaultResponseResponse.code()==ConfigurationFile.Constants.NORMAL_REQUEST_ADDED_SUCCESSFULLY)
                                moveToNextAct(defaultResponseResponse.body().getId());
                            else if (defaultResponseResponse.code()==ConfigurationFile.Constants.UNEXPECTED_ERROR)
                                Snackbar.make(binding.getRoot(), R.string.server_error,Snackbar.LENGTH_LONG).show();
                            else if (defaultResponseResponse.code()==422)
                                System.out.println("Message Of Request:"+defaultResponseResponse.body().getMessage());
                            else if (defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE)
                                CustomUtils.getInstance().endSession(AddRequestNotesActivity.this);
                        }, throwable -> {
                          //  binding.progressBar.setVisibility(View.GONE);
                            CustomUtils.getInstance().cancelDialog();
                            System.out.println("Ex :"+throwable.getMessage());
                        });

            }else {
                Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
            }

    }

    public void moveToNextAct(int id){
        Intent i=new Intent(AddRequestNotesActivity.this,FindRequestsActivity.class);
        i.putExtra(ConfigurationFile.IntentsConstants.NORMAL_REQUEST_ID,id);
        startActivity(i);
        finish();
        finishAffinity();
    }
}
