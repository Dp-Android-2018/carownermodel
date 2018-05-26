package findandfix.view.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import com.example.dp.findandfix.R;
import com.example.dp.findandfix.databinding.ActivityRegister3Binding;
import com.google.firebase.FirebaseApp;
import java.util.Observable;
import java.util.Observer;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.LoginViewModel;
import findandfix.viewmodel.UploadImageModelView;

/**
 * Created by DELL on 10/03/2018.
 */

public class UploadImageActivity extends AppCompatActivity implements Observer, BaseInterface {

    private ActivityRegister3Binding activityRegister3Binding;
    private UploadImageModelView uploadImageModelView;
    public ObservableInt progressDialog;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        initBinding();
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof LoginViewModel) {
        }
    }

    @Override
    public void updateUi(int code) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        uploadImageModelView.onActivityResult(requestCode,resultCode,data);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        uploadImageModelView.reset();
    }

    public void initBinding() {
        uploadImageModelView = new UploadImageModelView(this, this);
        activityRegister3Binding = DataBindingUtil.setContentView(UploadImageActivity.this, R.layout.activity_register_3);
        activityRegister3Binding.setUploadImageModelView(uploadImageModelView);
    }




}
