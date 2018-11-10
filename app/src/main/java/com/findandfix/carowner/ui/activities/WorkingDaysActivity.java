package com.findandfix.carowner.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityWorkshopWorkingTimeLayoutBinding;
import com.findandfix.carowner.model.global.WorkDayItems;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;
import com.findandfix.carowner.viewmodel.WorkingDaysViewModel;

/**
 * Created by DELL on 13/08/2018.
 */

public class WorkingDaysActivity extends BaseActivity implements BaseInterface{
    ActivityWorkshopWorkingTimeLayoutBinding binding;
    Map<String,WorkDayItems> map = new HashMap<String,WorkDayItems>();
    private WorkingDaysViewModel viewModel;
    ArrayList<WorkDayItems> workdays;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_workshop_working_time_layout);
        setUpActionBar();
        workdays= (ArrayList<WorkDayItems>) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.WORKING_DAYS_TAG);
        if (workdays!=null)
        System.out.println("Working Days Size :"+workdays.size());
        viewModel=new WorkingDaysViewModel(getApplicationContext(),this,workdays);
       binding.setViewModel(viewModel);

    }

    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(WorkingDaysActivity.this, ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_TOOLBAR));}
    @Override
    public void updateUi(int code) {

    }
}
