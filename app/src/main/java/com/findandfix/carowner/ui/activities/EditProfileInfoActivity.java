package com.findandfix.carowner.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityEditCarOwnerProfileLayoutBinding;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.viewmodel.EditProfileInfoViewModel;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;

/**
 * Created by DELL on 14/03/2018.
 */

public class EditProfileInfoActivity extends BaseActivity implements BaseInterface{

    private ActivityEditCarOwnerProfileLayoutBinding binding;
    private EditProfileInfoViewModel infoViewModel;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        setUpActionBar();}

    public void initBinding(){
        binding= DataBindingUtil.setContentView(EditProfileInfoActivity.this, R.layout.activity_edit_car_owner_profile_layout);
        infoViewModel=new EditProfileInfoViewModel(EditProfileInfoActivity.this,this);
        binding.setViewmodel(infoViewModel);}

    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(EditProfileInfoActivity.this, ConfigurationFile.Constants.HANDLE_EDIT_PROFILE_TOOLBAR));}

    @Override
    public void updateUi(int code) {
        if(code== ConfigurationFile.Constants.SHOW_DIALOG_CODE)
            CustomUtils.getInstance().showDialog(EditProfileInfoActivity.this,infoViewModel);
        else if(code==ConfigurationFile.Constants.PERMISSION_DENIED) {
            showSnackBar(getString(R.string.permission_denied));
        }else if(code==ConfigurationFile.Constants.PERMISSION_GRANTED_CAMERA)
            CustomUtils.getInstance().openCamera(EditProfileInfoActivity.this);
        else if(code==ConfigurationFile.Constants.PERMISSION_GRANTED_GALLERY)
            CustomUtils.getInstance().openGallery(EditProfileInfoActivity.this,false);
        else if (code==ConfigurationFile.Constants.CHOOSE_IMAGE_FROM_GALLERY)
            showSnackBar(getString(R.string.choose_image));
        else if (code==ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE)
            showSnackBar(getString(R.string.msg_internet_connection));
        else if (code == ConfigurationFile.Constants.SUCCESS_CODE)
            showSnackBar(getString(R.string.profile_update_successfully));

        else if (code == ConfigurationFile.Constants.UNUTHENTICATED || code == ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
            showSnackBar(getString(R.string.unauthenticated));
            CustomUtils.getInstance().endSession(EditProfileInfoActivity.this);
        }

        else if (code == ConfigurationFile.Constants.INVALID_DATA)
            showSnackBar(getResources().getString(R.string.invalid_data));

        else if (code == ConfigurationFile.Constants.FILL_ALL_DATTA)
            showSnackBar(getResources().getString(R.string.msg_fill_data));

        else if (code == ConfigurationFile.Constants.DATA_ISNT_MATCH)
            showSnackBar(getString(R.string.data_matches));

        else if (code == ConfigurationFile.Constants.CHANGE_PASSWORD_ACT)
            moveToChangePasswordAct();
    }


    public void moveToChangePasswordAct(){
        System.out.println("Clicked Data item 2");
        Intent i=new Intent(EditProfileInfoActivity.this,ChangePasswordActivity.class);
        startActivity(i);
    }

    public void showSnackBar(String message){
        Snackbar.make(binding.llContainer,message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        infoViewModel.onActivityResult(requestCode,resultCode,data);
    }
}
