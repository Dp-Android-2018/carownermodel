package com.findandfix.carowner.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.squareup.picasso.Picasso;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityAdvertisingDetailBinding;
import com.findandfix.carowner.model.global.AdvData;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;

public class OffersDetailActivity extends BaseActivity {

    private AdvData advData;
    private ActivityAdvertisingDetailBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(OffersDetailActivity.this, R.layout.activity_advertising_detail);
        setUpToolBar();
        getInentExtras();
        setDatatoUi();
    }

    public void setUpToolBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(OffersDetailActivity.this, ConfigurationFile.Constants.HANDLE_ADVERTISING_DETAIL_TOOLBAR));
    }

    public void getInentExtras(){
        advData=(AdvData)getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADV_OBJ);
    }
    public void setDatatoUi(){
        binding.textView.setText(advData.getTitle());
        binding.textView2.setText((advData.getDescription()==null || advData.getDescription().equals("")) ?getString(R.string.no_desc_available):advData.getDescription());
        if (advData.getImage()!=null && !(advData.getImage().equals("")))
        Picasso.with(getApplicationContext()).load(advData.getImage()).into(binding.ivAdv);
    }
}
