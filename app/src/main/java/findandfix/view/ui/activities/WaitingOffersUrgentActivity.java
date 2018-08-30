package findandfix.view.ui.activities;

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

import java.sql.SQLOutput;

import findandfix.R;
import findandfix.databinding.ActivityWaitingOffersLayoutBinding;
import findandfix.model.global.UserData;
import findandfix.model.request.CheckCode;
import findandfix.model.response.DefaultResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class WaitingOffersUrgentActivity extends BaseActivity {

    ActivityWaitingOffersLayoutBinding binding;
    public static boolean active=false;
    private BroadcastReceiver broadcastReceiver=null;
    private  int uid;
    private UserData userData;
    @Override
    protected void onStart() {
        super.onStart();
        active=true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_waiting_offers_layout);
        uid=getIntent().getIntExtra(ConfigurationFile.IntentsConstants.URGENT_REQUEST_ID,0);
        userData=CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
        binding.btnCancelSearch.setOnClickListener(v -> cancelUrgergentRequest());
        setUpActionBar();
        registerReciever();
    }

    public void cancelUrgergentRequest(){
        System.out.println("User Data Token  :"+userData.getToken());
        if (NetWorkConnection.isConnectingToInternet(WaitingOffersUrgentActivity.this)) {
            CustomUtils.getInstance().showProgressDialog(WaitingOffersUrgentActivity.this);
            ApiClient.getClient().create(EndPoints.class).cancelUrgentRequest(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),uid)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(defaultResponseResponse -> {
                        System.out.println("Cancel Urgent Response :"+new Gson().toJson(defaultResponseResponse));
                        System.out.println("Cancel Urgent Code :"+defaultResponseResponse.code());

                        CustomUtils.getInstance().cancelDialog();
                        if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {

                            Intent i=new Intent(WaitingOffersUrgentActivity.this,MainActivity.class);
                            startActivity(i);
                            finish();
                        }else if (defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                            CustomUtils.getInstance().endSession(WaitingOffersUrgentActivity.this);
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

                Intent i=new Intent(WaitingOffersUrgentActivity.this,UrgentOffersActivity.class);
                i.putExtra(ConfigurationFile.IntentsConstants.REQUEST_ID,100);
                startActivity(i);
                finish();
            }
        };
        registerReceiver(broadcastReceiver, intentFilter);
    }
    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(WaitingOffersUrgentActivity.this, ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_OFFERS)); }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finishAffinity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        active=false;
        unregisterReceiver(broadcastReceiver);
    }
}

