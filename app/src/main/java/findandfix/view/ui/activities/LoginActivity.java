package findandfix.view.ui.activities;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import com.example.dp.findandfix.R;
import com.example.dp.findandfix.databinding.ActivityLoginBinding;
import com.google.firebase.FirebaseApp;
import findandfix.utils.ConfigurationFile;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.LoginViewModel;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by DELL on 10/03/2018.
 */

public class LoginActivity extends AppCompatActivity implements Observer,BaseInterface{

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
                moveToNextActivity(0);
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
            moveToNextActivity(1);
        else if(code==ConfigurationFile.Constants.MOVE_TO_SUBSCRIBTION_ACTIVITY)
            moveToNextActivity(2);
        else if(code==ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE)
            Snackbar.make(activityLoginBinding.rlParent, R.string.msg_internet_connection,Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginViewModel.reset();
    }

    public void initBinding(){
        loginViewModel=new LoginViewModel(getApplicationContext(),this);
        activityLoginBinding = DataBindingUtil.setContentView(LoginActivity.this,R.layout.activity_login);
        activityLoginBinding.setLoginViewModel(loginViewModel);
    }

    public void subscribe(){
        loginViewModel.addObserver(this);
    }

    public void moveToNextActivity(int checker){

    }




}