package com.findandfix.carowner.ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.google.gson.Gson;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityFindRequestBinding;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.response.DefaultResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class FindRequestsActivity extends BaseActivity {
    ActivityFindRequestBinding binding;
    BroadcastReceiver broadcastReceiver=null;
    private int requestId=0;
    private UserData userData;
    public static boolean active=false;

    @Override
    protected void onStart() {
        super.onStart();
        active=true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(FindRequestsActivity.this, R.layout.activity_find_request);
        userData=CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
        requestId=getIntent().getIntExtra(ConfigurationFile.IntentsConstants.NORMAL_REQUEST_ID,0);
        binding.btnCancelSearch.setOnClickListener(v -> cancelNormalRequest());
        setUpToolBar();
        registerReciever();
        System.out.println();
        System.out.println("Message Of Request Details CODE Offers In");

    }


    public void cancelNormalRequest(){
        System.out.println("Request Id Data :"+requestId);
        if (NetWorkConnection.isConnectingToInternet(FindRequestsActivity.this)) {
            CustomUtils.getInstance().showProgressDialog(FindRequestsActivity.this);
            ApiClient.getClient().create(EndPoints.class).cancelNormalRequest(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),requestId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(defaultResponseResponse -> {
                        System.out.println("Cancel Urgent Response :"+new Gson().toJson(defaultResponseResponse));
                        System.out.println("Cancel Urgent Code :"+defaultResponseResponse.code());

                        CustomUtils.getInstance().cancelDialog();
                        if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {

                            Intent i=new Intent(FindRequestsActivity.this,MainActivity.class);
                            startActivity(i);
                            finish();
                        }else if (defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                            CustomUtils.getInstance().endSession(FindRequestsActivity.this);
                        }
                    }, throwable -> {
                        CustomUtils.getInstance().cancelDialog();
                        //  binding.progressBar.setVisibility(View.GONE);
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(findViewById(R.id.rl_parent),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }
    }



    public void registerReciever(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("CLOSE_ALL");
         broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // close activity
                System.out.println("Request Id Data :"+intent.getIntExtra(ConfigurationFile.IntentsConstants.REQUEST_ID,0));
                Intent i=new Intent(FindRequestsActivity.this,WorkShopOffersActivity.class);
                i.putExtra(ConfigurationFile.IntentsConstants.REQUEST_ID,intent.getIntExtra(ConfigurationFile.IntentsConstants.REQUEST_ID,0));
                startActivity(i);
                finish();
            }
        };
        registerReceiver(broadcastReceiver, intentFilter);
    }




    public void setUpToolBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(FindRequestsActivity.this, ConfigurationFile.Constants.HANDLE_FIND_REQUESTS_TOOLBAR));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(FindRequestsActivity.this,MainActivity.class);
        startActivity(i);
        finishAffinity();
    }

    @Override
    protected void onStop() {
        super.onStop();
        active=false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(broadcastReceiver);

    }
}

