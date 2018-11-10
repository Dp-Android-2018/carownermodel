package com.findandfix.carowner.ui.activities;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.WindowManager;

import com.google.firebase.FirebaseApp;

import java.util.Observable;
import java.util.Observer;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivitySecondStepRegisterLayoutBinding;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.viewmodel.RegisterViewModel;
import com.findandfix.carowner.viewmodel.SecondStepRegisterValidation;
import com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel;


public class SecondStepRegister extends BaseActivity implements Observer, BaseInterface {

    private ActivitySecondStepRegisterLayoutBinding activityRegister2Binding;
    private SecondStepRegisterViewModel registerModelView2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        initBinding();
        subscribe();
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof RegisterViewModel) {

        }
    }

    @Override
    public void updateUi(int code) {
        if(code== ConfigurationFile.Constants.CHOOSE_COUNTRY){
           showSnackBar(getResources().getString(R.string.msg_select_country));
        }else if (code== ConfigurationFile.Constants.CHOOSE_BRANDS){
            showSnackBar(getString(R.string.choose_brands));
        }else if (code== ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE){
            showSnackBar(getString(R.string.msg_internet_connection));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerModelView2.reset();
    }

    public void initBinding() {
        SecondStepRegisterValidation validation=new SecondStepRegisterValidation(getApplicationContext());
        registerModelView2 = new SecondStepRegisterViewModel(SecondStepRegister.this, this,validation);
        activityRegister2Binding = DataBindingUtil.setContentView(SecondStepRegister.this, R.layout.activity_second_step_register_layout);
        activityRegister2Binding.setRegisterModelView2(registerModelView2);
        activityRegister2Binding.setValidation(validation);
    }

    public void subscribe() {
        registerModelView2.addObserver(this);
    }
    public void showSnackBar(String title){
        Snackbar.make(activityRegister2Binding.rlParent,title,Snackbar.LENGTH_LONG).show();
    }



}
