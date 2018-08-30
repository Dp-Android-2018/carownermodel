package findandfix.view.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.google.firebase.FirebaseApp;

import java.util.Observable;
import java.util.Observer;

import findandfix.R;
import findandfix.databinding.ActivityFirstStepRegisterLayoutBinding;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.FirstStepRegisterValidation;
import findandfix.viewmodel.RegisterViewModel;


public class FirstStepRegister extends BaseActivity implements Observer, BaseInterface {

    private ActivityFirstStepRegisterLayoutBinding activityRegisterBinding;
    private RegisterViewModel registerModelView;
    private   FirstStepRegisterValidation validation;
    private FirstStepRegisterValidation firstStepRegisterValidation;

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerModelView.reset();
    }

    public void initBinding() {
        validation=new FirstStepRegisterValidation(getApplicationContext());
        registerModelView = new RegisterViewModel(FirstStepRegister.this, this,validation);
        activityRegisterBinding = DataBindingUtil.setContentView(FirstStepRegister.this, R.layout.activity_first_step_register_layout);
        activityRegisterBinding.setRegisterModelView(registerModelView);
        activityRegisterBinding.setValidator(validation);
    }

    public void subscribe() {
        registerModelView.addObserver(this);
    }


    @Override
    public void onBackPressed() {
        Intent i=new Intent(FirstStepRegister.this,LoginActivity.class);
        startActivity(i);
        finishAffinity();
    }
}
