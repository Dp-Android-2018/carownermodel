package findandfix.view.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.WindowManager;

import com.google.firebase.FirebaseApp;

import findandfix.R;
import findandfix.databinding.ActivityRegister3Binding;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.HandleRegisterViewModel;
import findandfix.viewmodel.UploadImageModelView;

/**
 * Created by DELL on 10/03/2018.
 */

public class UploadImageActivity extends BaseActivity implements BaseInterface {

    private ActivityRegister3Binding activityRegister3Binding;
    private UploadImageModelView uploadImageModelView;
    public ObservableInt progressDialog;
    private HandleRegisterViewModel registerViewModel;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        initBinding();
    }


    @Override
    public void updateUi(int code) {
        if(code== ConfigurationFile.Constants.SHOW_DIALOG_CODE)
            CustomUtils.getInstance().showDialog(UploadImageActivity.this,uploadImageModelView);

        else if(code==ConfigurationFile.Constants.PERMISSION_DENIED)
            showSnackBar(getString(R.string.permission_denied));
        else if(code==ConfigurationFile.Constants.PERMISSION_GRANTED_CAMERA)
            CustomUtils.getInstance().openCamera(UploadImageActivity.this);
        else if(code==ConfigurationFile.Constants.PERMISSION_GRANTED_GALLERY)
            CustomUtils.getInstance().openGallery(UploadImageActivity.this,false);

        else if (code==ConfigurationFile.Constants.CHOOSE_IMAGE_FROM_GALLERY)
            showSnackBar(getString(R.string.choose_image));

        else if (code==ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE)
            showSnackBar(getString(R.string.msg_internet_connection));

        else if(code== ConfigurationFile.Constants.INVALID_DATA)
            showSnackBar(getString(R.string.invalid_data));
        else if(code== ConfigurationFile.Constants.MOVE_TO_MAIN_ACT)
            MoveToNextActivity(new Intent(this,MainActivity.class));
    }

    public void MoveToNextActivity(Intent I){
        I.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(I);
        finishAffinity();
    }

    public void showSnackBar(String message){
        Snackbar.make(activityRegister3Binding.rlParent,message,Snackbar.LENGTH_LONG).show();
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
         registerViewModel=new HandleRegisterViewModel(UploadImageActivity.this,this);
        uploadImageModelView = new UploadImageModelView(this, this,registerViewModel);
        activityRegister3Binding = DataBindingUtil.setContentView(UploadImageActivity.this, R.layout.activity_register_3);
        activityRegister3Binding.setUploadImageModelView(uploadImageModelView);
        activityRegister3Binding.setRegisterviewmodel(registerViewModel);


    }




}
