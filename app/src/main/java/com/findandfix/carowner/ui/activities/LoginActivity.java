package com.findandfix.carowner.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.FirebaseApp;

import java.util.Observable;
import java.util.Observer;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityLoginBinding;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.viewmodel.LoginViewModel;

/**
 * Created by DELL on 10/03/2018.
 */

public class LoginActivity extends BaseActivity implements Observer,BaseInterface{

    private ActivityLoginBinding activityLoginBinding;
    private LoginViewModel loginViewModel;

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
            if(o instanceof LoginViewModel) {
                moveToNextActivity(ConfigurationFile.Constants.MOVE_TO_MAIN_ACT);
            }
    }

    @Override
    public void updateUi(int code) {
        if(code== ConfigurationFile.Constants.FILL_ALL_DATTA)
            Snackbar.make(activityLoginBinding.rlParent, R.string.msg_fill_data,Snackbar.LENGTH_LONG).show();
        else if(code==ConfigurationFile.Constants.INVALID_USERNAME_PASSWORD_LOGIN_CODE)
            Snackbar.make(activityLoginBinding.rlParent, R.string.msg_invalid_email_password,Snackbar.LENGTH_LONG).show();
        else if(code==ConfigurationFile.Constants.INVALID_DATA)
            Snackbar.make(activityLoginBinding.rlParent, R.string.msg_invalid_data,Snackbar.LENGTH_LONG).show();
        else if(code==ConfigurationFile.Constants.MOVE_TO_REGISTER_ACTIVITY)
            moveToNextActivity(ConfigurationFile.Constants.MOVE_TO_REGISTER_ACTIVITY);

        else if(code==ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE)
            Snackbar.make(activityLoginBinding.rlParent, R.string.msg_internet_connection,Snackbar.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginViewModel.reset();
    }

    public void initBinding(){
        loginViewModel=new LoginViewModel(LoginActivity.this,this);
        activityLoginBinding = DataBindingUtil.setContentView(LoginActivity.this,R.layout.activity_login);
        activityLoginBinding.tvForgotPassword.setOnClickListener(v -> {
            Intent i=new Intent(LoginActivity.this,ForgetPasswordMobileActivity.class);
            startActivity(i);
        });
        activityLoginBinding.setLoginViewModel(loginViewModel);
    }

    public void subscribe(){
        loginViewModel.addObserver(this);
    }

    public void moveToNextActivity(int checker){
        Intent i=null;
        if (checker==ConfigurationFile.Constants.MOVE_TO_REGISTER_ACTIVITY) {
             i = new Intent(LoginActivity.this, FirstStepRegister.class);
        }else if (checker==ConfigurationFile.Constants.MOVE_TO_MAIN_ACT){
            i = new Intent(LoginActivity.this, MainActivity.class);
        }
        startActivity(i);
        finishAffinity();

    }




}
