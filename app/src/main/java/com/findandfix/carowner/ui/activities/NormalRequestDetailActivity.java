package com.findandfix.carowner.ui.activities;

/**
 * Created by DELL on 04/08/2018.
 */

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityCompletedRequestDetailActivityBinding;
import com.findandfix.carowner.model.global.RequestData;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.viewmodel.CompletedRequestDetailViewModel;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;
import ss.com.bannerslider.events.OnBannerClickListener;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;



import ss.com.bannerslider.events.OnBannerClickListener;

/**
 * Created by DELL on 12/03/2018.
 */

public class NormalRequestDetailActivity extends BaseActivity implements BaseInterface {

    private ActivityCompletedRequestDetailActivityBinding binding;
    private CompletedRequestDetailViewModel viewModel=null;
    private RequestData requestData=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBinding();
        setUpToolBar();
    }

    @Override
    public void updateUi(int code) {

    }

    public void initBinding(){
        binding= DataBindingUtil.setContentView(NormalRequestDetailActivity.this, R.layout.activity_completed_request_detail_activity);
        viewModel=new CompletedRequestDetailViewModel(NormalRequestDetailActivity.this,getExtrasFromIntent(),getRequestType(),this);
        binding.setRequestDetailViewModel(viewModel);

        binding.bannerSlider1.setOnBannerClickListener(position -> {
            requestData = getExtrasFromIntent();

            if (requestData.getVideos() != null && requestData.getVideos().size()>0) {
                if ((!requestData.getVideos().get(0).equals("")) && position == requestData.getImage().size()) {

                    Intent i = new Intent(getApplicationContext(), PlayingVideoActivity.class);
                    i.putExtra(ConfigurationFile.IntentsConstants.VIDEO_URL, requestData.getVideos().get(0).getPath());
                    startActivity(i);

                }
            }
        });}

    public void setUpToolBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(NormalRequestDetailActivity.this, ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_DETAIL_TOOLBAR));

    }

    public RequestData getExtrasFromIntent(){
        RequestData requestData=(RequestData) getIntent().getSerializableExtra(ConfigurationFile.SharedPrefConstants.PREF_REQUEST_OBJECT);
        return requestData;
    }

    public int getRequestType(){
        return  getIntent().getIntExtra(ConfigurationFile.Constants.REQUEST_TYPE,0);
    }

    public void showSnackBar(int message){
        Snackbar.make(binding.svParent, message,Snackbar.LENGTH_LONG).show();
    }


}

