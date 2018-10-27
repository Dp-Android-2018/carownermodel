package findandfix.view.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import findandfix.Application.MyApplication;
import findandfix.model.ConnectionReceiver;
import findandfix.utils.CustomUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BaseActivity extends AppCompatActivity  implements ConnectionReceiver.ConnectionReceiverListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //check the network connectivity when activity is created
        String lang=(CustomUtils.getInstance().getAppLanguage(getApplicationContext())!=null ? CustomUtils.getInstance().getAppLanguage(getApplicationContext()) : "en");
        CustomUtils.getInstance().saveAppLanguage(getApplicationContext(),lang);
        checkConnection();
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        if (SplashActivity.AppLang.equals("ar"))
              super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        else super.attachBaseContext(newBase);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if(!isConnected) {

            //show a No Internet Alert or Dialog
            Intent I=new Intent(BaseActivity.this,Testing.class);
            startActivity(I);
            finish();
            finishAffinity();

        }else{

            Intent I=new Intent(BaseActivity.this,MainActivity.class);
            startActivity(I);
            finish();
            finishAffinity();
            // dismiss the dialog or refresh the activity
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        MyApplication.getInstance().setConnectionListener(this);
    }


    private void checkConnection() {
        boolean isConnected = ConnectionReceiver.isConnected();
        if(!isConnected) {
            //show a No Internet Alert or Dialog
            Intent I=new Intent(BaseActivity.this,Testing.class);
            startActivity(I);
            finish();
            finishAffinity();
        }
    }
}
