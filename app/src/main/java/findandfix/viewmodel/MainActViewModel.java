package findandfix.viewmodel;

/**
 * Created by DELL on 05/06/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import findandfix.R;

import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.view.ui.callback.BaseInterface;


/**
 * Created by DELL on 17/04/2018.
 */

public class MainActViewModel  {

    private Activity activity;
    private BaseInterface callback;

    public MainActViewModel(Activity activity, BaseInterface callback) {
        this.callback=callback;
        this.activity=activity;}



    public NavigationView.OnNavigationItemSelectedListener handleNavigation(){
        return menuItem -> {
            menuItem.setChecked(true) ;
            //Closing drawer on item click
            callback.updateUi(ConfigurationFile.Constants.CLOSE_MENU_DRAWER);
            switch (menuItem.getItemId()){


                case R.id.home:

                {
                    if (CustomUtils.getInstance().getSaveUserObject(activity).getConfirmed()== ConfigurationFile.Constants.USER_ACTIVATED) {
                        callback.updateUi(ConfigurationFile.Constants.MOVE_TO_MAIN_FRAG);
                    }else  callback.updateUi(ConfigurationFile.Constants.MOVE_TO_ACTIVATION_FRAG);
                    return true;
                }

                case R.id.setting:
                {
                    callback.updateUi(ConfigurationFile.Constants.MOVE_TO_SETTING_FRAG);
                    return true;
                }


                case R.id.share: {
                    shareApp();
                    return true;
                }

                case R.id.rate: {
                    callback.updateUi(ConfigurationFile.Constants.HANDLE_APP_RATE);
                    return true;
                }

                case R.id.about: {
                    callback.updateUi(ConfigurationFile.Constants.MOVE_TO_ABOUT_FRAG);
                    return true;
                }

                case R.id.orders: {
                    callback.updateUi(ConfigurationFile.Constants.MY_ORDERS);
                    return true;
                } case R.id.nearest_workshop: {
                    callback.updateUi(ConfigurationFile.Constants.NEAREST_WORKSHOP_CODE);
                    return true;
                }





                default:
                    System.out.println("Something Wrong");
                    return true;

            }
        };
    }


    public void shareApp(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.example.dell.workshopmodule");
        sendIntent.setType("text/plain");
        activity.startActivity(Intent.createChooser(sendIntent,activity.getString(R.string.send_to)));}

  /*  public void logout(){
        Intent i=new Intent(activity,LoginActivity.class);
        sharedPrefrenceUtils.clearToken();
        activity.startActivity(i);
        activity.finishAffinity();
    }*/






}

