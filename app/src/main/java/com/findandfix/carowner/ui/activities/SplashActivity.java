package com.findandfix.carowner.ui.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.eggheadgames.siren.ISirenListener;
import com.eggheadgames.siren.Siren;
import com.eggheadgames.siren.SirenAlertType;
import com.eggheadgames.siren.SirenVersionCheckType;

import java.util.Locale;
import java.util.concurrent.ExecutionException;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivitySplashLayoutBinding;
import com.findandfix.carowner.model.global.A;
import com.findandfix.carowner.model.global.B;
import com.findandfix.carowner.model.global.VersionChecker;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.viewmodel.SplashViewModel;

/**
 * Created by DELL on 04/04/2018.
 */

public class SplashActivity extends AppCompatActivity implements BaseInterface{
    private ActivitySplashLayoutBinding binding;
    private SplashViewModel viewModel;
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";
    public static  String AppLang;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        intitBinding();

    }

    public void intitBinding(){
        changeAppLanguage();
        binding= DataBindingUtil.setContentView(this, R.layout.activity_splash_layout);
        viewModel=new SplashViewModel(SplashActivity.this,SplashActivity.this);
        binding.setViewmodel(viewModel);

    }


    public void changeAppLanguage(){
        System.out.println("Lang App :"+CustomUtils.getInstance().getAppLanguage(getApplicationContext()));
        String lang=CustomUtils.getInstance().getAppLanguage(getApplicationContext())!=null ? CustomUtils.getInstance().getAppLanguage(getApplicationContext()) : "en";
        Locale locale = new Locale(lang);
        CustomUtils.getInstance().saveAppLanguage(getApplicationContext(),lang);
        AppLang=CustomUtils.getInstance().getAppLanguage(getApplicationContext());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

    @Override
    public void updateUi(int code) {
            if(code== ConfigurationFile.Constants.MOVE_TO_MAIN_ACT)
                    moveToNextAct(0);
            else if(code== ConfigurationFile.Constants.MOVE_TO_LOGIN_ACT)
                    moveToNextAct(1);

            else if(code== ConfigurationFile.Constants.MOVE_APP_INTRO_ACT)
                moveToNextAct(2);

            else if(code== ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                Snackbar.make(binding.rlLayout, R.string.cant_complete_request, Snackbar.LENGTH_LONG).show();
    }

    public void moveToNextAct(int code){
        Intent i=null;
        if(code==0)
            i=new Intent(getApplicationContext(),MainActivity.class);
        else if(code==1)
            i=new Intent(getApplicationContext(),LoginActivity.class);

        else if(code==2)
            i=new Intent(getApplicationContext(),IntroActivity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finishAffinity();
    }






}
