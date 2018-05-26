package findandfix.view.ui.activities;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import com.example.dp.findandfix.R;
import com.example.dp.findandfix.databinding.ActivityRegisterBinding;
import com.google.firebase.FirebaseApp;
import java.util.Observable;
import java.util.Observer;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.RegisterModelView;


public class RegisterActivity extends AppCompatActivity implements Observer, BaseInterface {

    private ActivityRegisterBinding activityRegisterBinding;
    private RegisterModelView registerModelView;

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
        if (o instanceof RegisterModelView) {

        }
    }

    @Override
    public void updateUi(int code) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerModelView.reset();
    }

    public void initBinding() {
        registerModelView = new RegisterModelView(getApplicationContext(), this);
        activityRegisterBinding = DataBindingUtil.setContentView(RegisterActivity.this, R.layout.activity_register);
        activityRegisterBinding.setRegisterModelView(registerModelView);
    }

    public void subscribe() {
        registerModelView.addObserver(this);
    }



}
