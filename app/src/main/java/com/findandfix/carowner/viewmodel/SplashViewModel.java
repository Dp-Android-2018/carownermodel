package com.findandfix.carowner.viewmodel;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.databinding.BaseObservable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.concurrent.ExecutionException;

import com.findandfix.carowner.R;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.global.VersionChecker;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.SharedPrefrenceUtils;
import com.findandfix.carowner.ui.activities.ChatActivity;
import com.findandfix.carowner.ui.activities.MainActivity;
import com.findandfix.carowner.ui.activities.MyConversationsActivity;
import com.findandfix.carowner.ui.activities.SplashActivity;
import com.findandfix.carowner.ui.activities.UrgentOffersActivity;
import com.findandfix.carowner.ui.activities.WaitingOffersUrgentActivity;
import com.findandfix.carowner.ui.activities.WorkShopOffersActivity;
import com.findandfix.carowner.ui.callback.BaseInterface;


/**
 * Created by DELL on 04/04/2018.
 */

public class SplashViewModel extends BaseObservable {

    private Context context;
    private BaseInterface callback;
    private Dialog dialog=null;
    public SplashViewModel(Context context, BaseInterface callback) {
            this.context=context;
            this.callback=callback;
                secondaryDelay();
            //delay();
    }

    public void checkVersionUpdate(){
        VersionChecker versionChecker = new VersionChecker();
        try {
            String latestVersion = versionChecker.execute().get();
            System.out.println("Latest Version Data :"+latestVersion);
            getCurrentVersion(latestVersion);
        } catch (InterruptedException e) {
            e.printStackTrace();
            delay();
        } catch (ExecutionException e) {
            e.printStackTrace();
            delay();
        }
    }

    public void getCurrentVersion(String playStoreVersion){
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String version = pInfo.versionName;
            if (version.equalsIgnoreCase(playStoreVersion))
                delay();
            else showDialog();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showDialog(){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(context);
        final View dialogView = factory.inflate(R.layout.dialog_update_available_layout, null);
        Button btnCancel=dialogView.findViewById(R.id.btn_cancel);
        Button btnAccept=dialogView.findViewById(R.id.btn_deactivate);
        btnAccept.setOnClickListener(v -> {
            Uri uri = Uri.parse("market://details?id="+context.getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                context.startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                context.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id="+context.getPackageName())));
            }
        });
        dialog.setContentView(dialogView);
        dialog.show();
    }

    public void secondaryDelay(){
        new Handler().postDelayed(() -> checkVersionUpdate(), 500);
    }
    public void delay(){
        new Handler().postDelayed(() -> moveTonextActivity(), ConfigurationFile.Constants.SPLASH_TIME_OUT);
    }

    public void saveDataToPrefs(UserData data){
        SharedPrefrenceUtils pref;
        pref=new SharedPrefrenceUtils(context);
        pref.saveObjectToSharedPreferences(ConfigurationFile.SharedPrefConstants.PREF_CAR_OWNER_OBJ_DATA,data);
    }


    public void moveTonextActivity(){
        if (((Activity)context).getIntent().getExtras()!=null) {

            for (String key : ((Activity)context).getIntent().getExtras().keySet())
            {
                System.out.println(("Bundle Debug" + key +"  "+ ((Activity)context).getIntent().getExtras().get(key) ));
            }
            Intent i=null;
            System.out.println("Bundle Debug 2 :"+ ((Activity)context).getIntent().getExtras().get("key"));
            if (((Activity)context).getIntent().getExtras().containsKey("title")) {
                if (String.valueOf(((Activity)context).getIntent().getExtras().get("title")).equals("urgent-request-offer")) {
                    if (WaitingOffersUrgentActivity.active) {
                        Intent intent = new Intent("CLOSE_ALL");
                        context.sendBroadcast(intent);
                    } else {
                        i = new Intent(context, UrgentOffersActivity.class);
                        i.putExtra(ConfigurationFile.IntentsConstants.REQUEST_ID, 100);
                        context.startActivity(i);
                        ((Activity) context).finish();
                        ((Activity) context).finishAffinity();
                    }
                }else if (String.valueOf(((Activity)context).getIntent().getExtras().get("title")).equals("urgent-request-completed")){
                    i = new Intent(context, MainActivity.class);
                    context.startActivity(i);
                    ((Activity) context).finish();
                    ((Activity) context).finishAffinity();
                }else if (String.valueOf(((Activity)context).getIntent().getExtras().get("title")).equals("account-activated")){
                    UserData userData=CustomUtils.getInstance().getSaveUserObject(context);
                    userData.setConfirmed(1);
                    saveDataToPrefs(userData);

                    /////////////////////////////////////////////////////////////////////////////////////
                    if (CustomUtils.getInstance().getSaveUserObject(context) != null) {
                        callback.updateUi(ConfigurationFile.Constants.MOVE_TO_MAIN_ACT);
                    } else {
                        if (CustomUtils.getInstance().isFirstTime(context)==true)
                            callback.updateUi(ConfigurationFile.Constants.MOVE_TO_LOGIN_ACT);
                        else  { callback.updateUi(ConfigurationFile.Constants.MOVE_APP_INTRO_ACT);
                            CustomUtils.getInstance().saveisFirstTime(context,true);
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////////
                }

            }else if (((Activity)context).getIntent().getExtras().containsKey("noti_title")){

                if (String.valueOf(((Activity) context).getIntent().getExtras().get("noti_title")).equals("new_message")){
                    if (ChatActivity.active){

                    }else {
                        i = new Intent(context, MyConversationsActivity.class);
                        context.startActivity(i);
                        ((Activity) context).finish();
                        ((Activity) context).finishAffinity();
                    }
                }  else if (String.valueOf(((Activity) context).getIntent().getExtras().get("noti_title")).equals("new_offer")) {
                    i = new Intent(context, WorkShopOffersActivity.class);
                    i.putExtra(ConfigurationFile.IntentsConstants.REQUEST_ID, Integer.parseInt(String.valueOf(((Activity) context).getIntent().getExtras().get("request_id"))));
                    context.startActivity(i);
                    ((Activity) context).finish();
                    ((Activity) context).finishAffinity();
                } else if (String.valueOf(((Activity) context).getIntent().getExtras().get("noti_title")).equals("complete_fixing")) {
                    i = new Intent(context, MainActivity.class);
                    i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_ID, Integer.parseInt(String.valueOf(((Activity) context).getIntent().getExtras().get("workshop_id"))));
                    i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_NAME, String.valueOf(((Activity) context).getIntent().getExtras().get("workshop_name")));
                    context.startActivity(i);
                    ((Activity) context).finish();
                    ((Activity) context).finishAffinity();
                }

                ((Activity)context).getIntent().getExtras().clear();

            }else {
                if (CustomUtils.getInstance().getSaveUserObject(context) != null) {
                    callback.updateUi(ConfigurationFile.Constants.MOVE_TO_MAIN_ACT);
                } else {
                    if (CustomUtils.getInstance().isFirstTime(context)==true)
                    callback.updateUi(ConfigurationFile.Constants.MOVE_TO_LOGIN_ACT);
                    else  { callback.updateUi(ConfigurationFile.Constants.MOVE_APP_INTRO_ACT);
                    CustomUtils.getInstance().saveisFirstTime(context,true);
                    }
                }
            }

        }else {
            if (CustomUtils.getInstance().getSaveUserObject(context) != null) {
                callback.updateUi(ConfigurationFile.Constants.MOVE_TO_MAIN_ACT);
            } else {
                if (CustomUtils.getInstance().isFirstTime(context)==true)
                callback.updateUi(ConfigurationFile.Constants.MOVE_TO_LOGIN_ACT);
                else   {callback.updateUi(ConfigurationFile.Constants.MOVE_APP_INTRO_ACT);
                    CustomUtils.getInstance().saveisFirstTime(context,true);}
            }
        }

    }



}
