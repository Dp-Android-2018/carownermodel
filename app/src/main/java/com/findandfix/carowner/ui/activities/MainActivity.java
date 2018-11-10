package com.findandfix.carowner.ui.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import com.findandfix.carowner.Application.MyApplication;
import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityMainBinding;
import com.findandfix.carowner.databinding.HeaderMenuLayoutBinding;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.request.RateRequest;
import com.findandfix.carowner.model.response.DefaultResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.utils.SharedPrefrenceUtils;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.ui.fragments.AboutFragment;
import com.findandfix.carowner.ui.fragments.ActivateMobileFragment;
import com.findandfix.carowner.ui.fragments.ActiveAccountFragment;
import com.findandfix.carowner.ui.fragments.CompletedRequestsFragment;
import com.findandfix.carowner.ui.fragments.HomeFragment;
import com.findandfix.carowner.ui.fragments.NearestWorkshop;
import com.findandfix.carowner.ui.fragments.SettingFragment;
import com.findandfix.carowner.viewmodel.MainActViewModel;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements BaseInterface{

    private ActivityMainBinding binding;
    private MainActViewModel mainViewModel;
    private ToolbarViewModel toolbarViewModel;
    private Dialog dialog=null;
    private int workShopId=0;
    private UserData userData;
    boolean doubleBackToExitPressedOnce = false;
    private BroadcastReceiver broadcastReceiver=null;
    private   android.support.v7.widget.Toolbar toolbar=null;
    private ImageView iv,iv2,iv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        setUpToolBar();
        handleNavigation();
        handleNavigationHeader();

        navigateBetweenFragments(null);
        if (getIntent()!=null){
            if (getIntent().getIntExtra(ConfigurationFile.IntentsConstants.WORKSHOP_ID,0)!=0) {
                workShopId=getIntent().getIntExtra(ConfigurationFile.IntentsConstants.WORKSHOP_ID,0);
                setDialog();
            }
        }

        registerReciever();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReciever();
    }

    public void registerReciever(){
        System.out.println("Notification Log 3");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("account_activated");
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                System.out.println("Notification Log 4");
                UserData userData=CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
                userData.setConfirmed(1);
                saveDataToPrefs(userData);
                activeAccount();
            }
        };
        registerReceiver(broadcastReceiver, intentFilter);
    }

    public void saveDataToPrefs(UserData data){
        SharedPrefrenceUtils pref;
        pref=new SharedPrefrenceUtils(getApplicationContext());
        pref.saveObjectToSharedPreferences(ConfigurationFile.SharedPrefConstants.PREF_CAR_OWNER_OBJ_DATA,data);
    }

    public void activeAccount(){
        Fragment fragment=null;
        if (CustomUtils.getInstance().getSaveUserObject(getApplicationContext()).getConfirmed()== ConfigurationFile.Constants.USER_ACTIVATED)
            fragment = new HomeFragment();
        else
            fragment=new ActivateMobileFragment();
        if (! isFinishing()) {
            //////////////////////////////////////////////////////////////////////////////////////////////
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////
    }



    public void initBinding(){
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        userData=CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
        mainViewModel=new MainActViewModel(MainActivity.this,this);

        binding.setViewModel(mainViewModel);}

    public void setUpToolBar() {
        setSupportActionBar(binding.toolbar.toolbar);
        toolbarViewModel = new ToolbarViewModel(MainActivity.this, ConfigurationFile.Constants.HANDLE_MAIN_TOOLBAR);
        binding.toolbar.setViewmodel(toolbarViewModel);
        if (CustomUtils.getInstance().getAppLanguage(MainActivity.this).equals("ar")) {
            binding.toolbar.toolbar.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        toolbar=(android.support.v7.widget.Toolbar) binding.toolbar.toolbar;
         iv=toolbar.findViewById(R.id.iv_toolbar_messages);
         iv2=toolbar.findViewById(R.id.iv_toolbar_notification);
        iv3=toolbar.findViewById(R.id.iv_toolbar_filter);
    }




    @Override
    public void updateUi(int code) {
       if(code== ConfigurationFile.Constants.CLOSE_MENU_DRAWER)
            binding.drawer.closeDrawers();
        else if(code== ConfigurationFile.Constants.MOVE_TO_MAIN_FRAG) {
           iconsVisibility();
           HomeFragment mainFragment=new HomeFragment();
            toolbarViewModel.handleToolbarBackground(getString(R.string.find_fix),R.color.colorPrimary);
            navigateBetweenFragments(mainFragment);
        }  else if(code== ConfigurationFile.Constants.MOVE_TO_ABOUT_FRAG) {
           iconsVisibility();
            AboutFragment aboutFragment=new AboutFragment();
            toolbarViewModel.handleToolbarBackground(getString(R.string.about),R.color.colorPrimary);
            navigateBetweenFragments(aboutFragment);
        } else if(code== ConfigurationFile.Constants.MOVE_TO_ACTIVATION_FRAG){
           iconsVisibility();
            ActivateMobileFragment activateMobileFragment=new ActivateMobileFragment();
            navigateBetweenFragments(activateMobileFragment);
        }else if(code== ConfigurationFile.Constants.MOVE_TO_SETTING_FRAG){
           iconsVisibility();
            SettingFragment settingFragment=new SettingFragment();
            navigateBetweenFragments(settingFragment);
        }else if(code== ConfigurationFile.Constants.MY_ORDERS){
           iconsVisibility();
           CompletedRequestsFragment completedRequestsFragment=new CompletedRequestsFragment();
           navigateBetweenFragments(completedRequestsFragment);
       }else if(code== ConfigurationFile.Constants.HANDLE_APP_RATE){
           iconsVisibility();
           rateApp();
       }else if(code== ConfigurationFile.Constants.NEAREST_WORKSHOP_CODE){
           filterVisibility();
           NearestWorkshop nearestWorkshop=new NearestWorkshop();
           navigateBetweenFragments(nearestWorkshop);
       }
    }
    public void iconsVisibility(){
        iv.setVisibility(View.VISIBLE);
        iv2.setVisibility(View.VISIBLE);
        iv3.setVisibility(View.GONE);
    }

    public void filterVisibility(){
        iv.setVisibility(View.GONE);
        iv2.setVisibility(View.GONE);
        iv3.setVisibility(View.VISIBLE);
    }

    private void navigateBetweenFragments(Fragment fragment){

        if(fragment==null) {
            if (CustomUtils.getInstance().getSaveUserObject(getApplicationContext()).getConfirmed()== ConfigurationFile.Constants.USER_ACTIVATED)
                    fragment = new HomeFragment();
            else fragment=new ActivateMobileFragment();

        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();}

    public void handleNavigation(){
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,binding.drawer,binding.toolbar.toolbar,R.string.open_drawer,R.string.close_drawer){
            @Override
            public void onDrawerClosed(View drawerView) {super.onDrawerClosed(drawerView);}
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }};
        binding.drawer.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();}

    public void handleNavigationHeader(){
        binding.navigationView.setItemIconTintList(null);
        View headerview=binding.navigationView.getHeaderView(0);
        HeaderMenuLayoutBinding headerMenuLayoutBinding=HeaderMenuLayoutBinding.bind(headerview);
        headerMenuLayoutBinding.tvWorkshopName.setText(userData.getFirstName()+" "+userData.getLastName());
        headerMenuLayoutBinding.tvWorkshopMail.setText(userData.getEmail());
        Picasso.with(getApplicationContext()).load(userData.getImage()).into(headerMenuLayoutBinding.ivUser);}


    private void setDialog(){
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(getApplicationContext());
        final View dialogView = factory.inflate(R.layout.dialog_rating_work_shop, null);
        TextView titleTextView = dialogView.findViewById(R.id.tv_rating_work_shop_name);
        RatingBar ratingBar = dialogView.findViewById(R.id.rb_rating_work_shop_rate);
        Button addRate = dialogView.findViewById(R.id.btn_rating_work_shop_done);
        addRate.setOnClickListener(v -> {
            RateRequest rateRequest=new RateRequest(workShopId,(int) ratingBar.getRating());
            addRate(rateRequest);
        });
        if (getIntent().getStringExtra(ConfigurationFile.IntentsConstants.WORKSHOP_NAME)!=null)
            titleTextView.setText(getIntent().getStringExtra(ConfigurationFile.IntentsConstants.WORKSHOP_NAME));
        dialog.setContentView(dialogView);
        dialog.show();
    }

    @SuppressLint("CheckResult")
    public void addRate(RateRequest rateRequest){
        if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
         //   binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(MainActivity.this);
            UserData userData=CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
            ApiClient.getClient().create(EndPoints.class).acceptWorkShopRate(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(getApplicationContext()), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, "Bearer " + userData.getToken(),rateRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(defaultResponseResponse -> {
                        if (dialog!=null)
                        dialog.dismiss();
                        System.out.println("Rate CODE :" + defaultResponseResponse.code());
                      //  binding.progressBar.setVisibility(View.GONE);
                                    CustomUtils.getInstance().cancelDialog();
                        if (defaultResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_GARAGE) {
                            Snackbar.make(findViewById(R.id.drawer), R.string.rate_added_successfully, Snackbar.LENGTH_LONG).show();

                        }else if (defaultResponseResponse.code() == ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                defaultResponseResponse.code() == ConfigurationFile.Constants.UNUTHENTICATED_CODE )
                            CustomUtils.getInstance().endSession(MainActivity.this);
                        else if (defaultResponseResponse.code() == ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(findViewById(R.id.drawer), getResources().getString(R.string.cant_complete_your_request), Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                        if (dialog!=null)
                            dialog.dismiss();
                    //    binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Ex :" + throwable.getMessage());
                    });

        } else {
            Snackbar.make(findViewById(R.id.drawer), getResources().getString(R.string.msg_internet_connection), Snackbar.LENGTH_LONG).show();
        }
    }


    public void rateApp(){
        Uri uri = Uri.parse("market://details?id="+getApplicationContext().getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName())));
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Snackbar.make(findViewById(R.id.drawer), R.string.press_again_to_exit, Snackbar.LENGTH_LONG).show();

        new Handler().postDelayed(() -> doubleBackToExitPressedOnce=false, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (broadcastReceiver !=null)
            unregisterReceiver(broadcastReceiver);
    }
}
