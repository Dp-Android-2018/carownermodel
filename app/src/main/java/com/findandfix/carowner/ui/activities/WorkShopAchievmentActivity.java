package com.findandfix.carowner.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityWorkshopAchievmentLayoutBinding;
import com.findandfix.carowner.model.global.AchievmentObj;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.response.AchievmentResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.ui.adapters.AchievmentAdapter;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class WorkShopAchievmentActivity extends BaseActivity {
    ActivityWorkshopAchievmentLayoutBinding binding;
    private UserData userData;
    private List<AchievmentObj> achievmentObjs;
    private boolean loading = false;
    private String next = null;
    private int pageId = 0;
    private int pos = 0;
    private int workShopId=-1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_workshop_achievment_layout);
        setUpActionBar();
        initializeRecycler();
        achievmentObjs=new ArrayList<>();
        getUserData();
        workShopId=getIntent().getExtras().getInt(ConfigurationFile.IntentsConstants.WORKSHOP_ID,0);
        loading = true;
        getAchievments();
    }

    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(WorkShopAchievmentActivity.this, ConfigurationFile.Constants.HANDLE_WORKSHOP_ACHIEVMENTS_TOOLBAR)); }
    public void initializeRecycler() {

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvAchievments.setLayoutManager(mLayoutManager);
        binding.rvAchievments.setItemAnimator(new DefaultItemAnimator());
        binding.rvAchievments.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (((LinearLayoutManager) binding.rvAchievments.getLayoutManager()).findLastVisibleItemPosition() == achievmentObjs.size() - 1) {
                    if (next != null && loading == false) {
                        loading = true;
                        System.out.println("Load More Data Success ");
                        getAchievments();
                    }

                }
            }
        });

    }


    public void getUserData(){
        userData= CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
    }


    public void getAchievments() {
        if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
         //   binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(WorkShopAchievmentActivity.this);
            System.out.println("Offers Token :" + userData.getToken());
            ApiClient.getClient().create(EndPoints.class).getAchievments(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(getApplicationContext()), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, "Bearer " + userData.getToken(),workShopId,pageId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(achievmentResponseResponse -> {
                        System.out.println("Offers CODE :" + achievmentResponseResponse.code());
                       // binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        loading=false;
                        if (achievmentResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                            AchievmentResponse response = achievmentResponseResponse.body();
                            pos=achievmentObjs.size();
                            achievmentObjs.addAll(response.getData());
                            next=response.getLinks().getNext();
                            if (next!=null)
                                pageId=Integer.parseInt(next.substring(next.length()-1));

                            System.out.println("Load More Data List Size:"+achievmentObjs.size());
                            System.out.println("Load More Data next:"+next);
                            System.out.println("Load More Data Page Id : "+pageId);
                            setAdapter();
                        }else if (achievmentResponseResponse.code() == ConfigurationFile.Constants.UNUTHENTICATED_CODE)
                            CustomUtils.getInstance().endSession(WorkShopAchievmentActivity.this);
                        else if (achievmentResponseResponse.code() == ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(findViewById(R.id.rl_parent), getResources().getString(R.string.cant_complete_your_request), Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                      //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        loading=false;
                        System.out.println("Ex :" + throwable.getMessage());
                    });

        } else {
            Snackbar.make(findViewById(R.id.rl_parent), getResources().getString(R.string.msg_internet_connection), Snackbar.LENGTH_LONG).show();
        }
    }


    public void setAdapter(){
        //  achievmentObjs.clear();
        if (achievmentObjs.size()>0) {

            binding.rlNoItems.setVisibility(View.GONE);
            binding.rvAchievments.setVisibility(View.VISIBLE);

            AchievmentAdapter achievmentAdapter = new AchievmentAdapter(achievmentObjs);
            binding.rvAchievments.setAdapter(achievmentAdapter);
            binding.rvAchievments.scrollToPosition(pos);
        }else {
            binding.rlNoItems.setVisibility(View.VISIBLE);
            binding.rvAchievments.setVisibility(View.GONE);

        }

    }
}

