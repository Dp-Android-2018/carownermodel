package findandfix.view.ui.activities;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import com.example.dp.findandfix.R;
import com.example.dp.findandfix.databinding.ActivityRegister2Binding;
import com.google.firebase.FirebaseApp;
import java.util.Observable;
import java.util.Observer;
import findandfix.utils.ConstantCodes;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.RegisterModelView;
import findandfix.viewmodel.RegisterModelView2;


public class RegisterActivity2 extends AppCompatActivity implements Observer, BaseInterface {

    private ActivityRegister2Binding activityRegister2Binding;
    private RegisterModelView2 registerModelView2;

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
        if(code== ConstantCodes.SELECT_COUNTRY){
            Snackbar.make(activityRegister2Binding.rlParent,getResources().getString(R.string.msg_select_country),Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerModelView2.reset();
    }

    public void initBinding() {
        registerModelView2 = new RegisterModelView2(
                this, this);
        activityRegister2Binding = DataBindingUtil.setContentView(RegisterActivity2.this, R.layout.activity_register_2);
        activityRegister2Binding.setRegisterModelView2(registerModelView2);
    }

    public void subscribe() {
        registerModelView2.addObserver(this);
    }



}
