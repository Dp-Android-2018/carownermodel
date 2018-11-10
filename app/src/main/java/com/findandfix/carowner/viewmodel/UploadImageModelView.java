package com.findandfix.carowner.viewmodel;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;
import android.databinding.ObservableInt;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;

import com.google.android.gms.internal.zzahn;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.findandfix.carowner.Application.MyApplication;
import com.findandfix.carowner.BR;
import com.findandfix.carowner.model.request.RegisterRequest;
import com.findandfix.carowner.notification.MyFirebaseInstanceIdService;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.ui.callback.TaskMonitor;
import io.reactivex.disposables.CompositeDisposable;

import static android.app.Activity.RESULT_OK;


public class UploadImageModelView extends BaseObservable {

    public ObservableField<String> email;
    public ObservableField<String> password;
    public ObservableField<String> phone;
    public ObservableInt progressDialog;
    private CompositeDisposable compositeDisposable;
    private Context context;
    private BaseInterface callback;
    private Bitmap picBitmap;
    private Bitmap selectedImageBitmap;
    StorageReference storageReference;
    Uri selectedImageUri = null;
    String encodedImage = "";
    private RxPermissions rxPermissions;
    public ObservableField<Integer> loading;
    public ObservableFloat progress;
    private String picUrl;
    private HandleRegisterViewModel registerViewModel;
    private RegisterRequest registerRequest;
    private String token;
    public UploadImageModelView(Context context, BaseInterface callback,HandleRegisterViewModel registerViewModel) {
        this.context = context;
        this.callback = callback;
        this.registerViewModel=registerViewModel;
        rxPermissions = new RxPermissions((Activity) context);
        initializeVariables();
        storageReference = FirebaseStorage.getInstance().getReference().child("app_photos");
        token=getFirebaseToken();
    }

    public String getFirebaseToken(){
        final MyFirebaseInstanceIdService mfs= new MyFirebaseInstanceIdService();
        FirebaseApp.initializeApp(context);
        zzahn.runOnUiThread(() -> mfs.onTokenRefresh());
        System.out.println("User Token :"+ MyFirebaseInstanceIdService.TOKEN);
        return MyFirebaseInstanceIdService.TOKEN;
    }

    public void initializeVariables() {
        progressDialog = new ObservableInt(View.GONE);
        loading=new ObservableField<>(View.GONE);
        progress=new ObservableFloat(0.3f);
    }

    public void displayDialog(View view) {
        callback.updateUi(ConfigurationFile.Constants.SHOW_DIALOG_CODE);
    }
    public void askForPermission(int checker) {
        CustomUtils.getInstance().requirePermission(rxPermissions,checker,callback);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            convertImageToBase64(data.getData());
            selectedImageUri=data.getData();}}

    public void convertImageToBase64(Uri ImageUri) {
        try {
            final InputStream imageStream = context.getContentResolver().openInputStream(ImageUri);
            selectedImageBitmap = BitmapFactory.decodeStream(imageStream);
            String RealPicturePath = CustomUtils.getInstance().uriToFilename(ImageUri, context);
            selectedImageBitmap = CustomUtils.getInstance().modifyOrientation(selectedImageBitmap, RealPicturePath);
            setPicBitmap(selectedImageBitmap);
            encodedImage = CustomUtils.getInstance().encodeImage(selectedImageBitmap);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void reset() {
        unSubScribe();
        compositeDisposable = null;
        context = null;
    }

    public void unSubScribe() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed())
            compositeDisposable.dispose();
    }

    public void setPicBitmap(Bitmap picBitmap) {
        this.picBitmap = picBitmap;
        notifyPropertyChanged(BR.picBitmap);
    }


    @Bindable
    public Bitmap getPicBitmap() {
        return picBitmap;
    }

    public void validate(View view){
        System.out.println("Validate Data ");

        if (selectedImageUri!=null){
            uploadToFireBase();
        }else {
            callback.updateUi(ConfigurationFile.Constants.CHOOSE_IMAGE_FROM_GALLERY);
        }
    }

    public void uploadToFireBase(){
        System.out.println("Upload Detail");
        loading.set(View.VISIBLE);
        CustomUtils.getInstance().uploadFireBasePic(storageReference, selectedImageUri, photoUrl -> {
            System.out.println("Photo Url :"+photoUrl);
            picUrl=photoUrl;
            progress.set(1.0f);
            registerRequest = (RegisterRequest) ((Activity) context).getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_REGISTER_REQUEST_OBJ);
            registerRequest.setImage(picUrl);
            registerRequest.setDeviceToken(token);
            registerViewModel.register(registerRequest);
        });
    }



    public Animator.AnimatorListener onAnimationEnd(){
        return new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                System.out.println("Animation End :"+(progress.get()));
                if (progress.get()==1.0f){
                    progress.set(0.3f);
                    loading.set(View.GONE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        };
    }





}
