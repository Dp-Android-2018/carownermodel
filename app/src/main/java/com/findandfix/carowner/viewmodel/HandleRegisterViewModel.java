package com.findandfix.carowner.viewmodel;

import android.app.Activity;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.google.android.gms.internal.zzahn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.findandfix.carowner.model.global.Conv.User;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.request.RegisterRequest;
import com.findandfix.carowner.model.response.LoginRegisterResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.notification.MyFirebaseInstanceIdService;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.utils.SharedPrefrenceUtils;
import com.findandfix.carowner.ui.callback.BaseInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by DELL on 12/06/2018.
 */

public class HandleRegisterViewModel {

    private Activity context;
    public ObservableField<Integer>progressDialog;
    private String token=null;
    private BaseInterface callback;
    private DatabaseReference reference;
    public HandleRegisterViewModel(Activity context, BaseInterface callback) {
        this.context=context;
        this.callback=callback;
        progressDialog=new ObservableField<>(View.GONE);
        token=getFirebaseToken();
        System.out.println("FireBase Token :"+token);
    }

    public String getFirebaseToken(){
        final MyFirebaseInstanceIdService mfs= new MyFirebaseInstanceIdService();
        FirebaseApp.initializeApp(context);
        zzahn.runOnUiThread(() -> mfs.onTokenRefresh());
        System.out.println("User Token :"+ MyFirebaseInstanceIdService.TOKEN);
        return MyFirebaseInstanceIdService.TOKEN;
    }

    public void register(RegisterRequest registerRequest) {

        registerRequest.setDeviceToken(token);
        System.out.println("Register Request Data :"+registerRequest.getEmail());

        if (NetWorkConnection.isConnectingToInternet(context)) {
            System.out.println("Register Request Connected");

           // progressDialog.set(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog((Activity)context);
            Disposable disposable = ApiClient.getClient().create(EndPoints.class).register(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(context), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, registerRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(registerResponseResponse -> {
                        //progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Register Request Response :"+registerResponseResponse.code());
                        if (registerResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_REGISTRATION) {
                            System.out.println("Handle Register :" + registerResponseResponse.code());
                            LoginRegisterResponse registerResponse = registerResponseResponse.body();
                            UserData data = registerResponse.getData();
                            addUserToFirebase(data);
                            SharedPrefrenceUtils pref = new SharedPrefrenceUtils(context);
                            pref.saveObjectToSharedPreferences(ConfigurationFile.SharedPrefConstants.PREF_CAR_OWNER_OBJ_DATA, data);
                            callback.updateUi(ConfigurationFile.Constants.MOVE_TO_MAIN_ACT);
                            (context).finishAffinity();
                          //
                           /* callback.updateUi(ConfigurationFile.Constants.MOVE_TO_MAIN_ACT);
                            ((Activity)context).finishAffinity();*/
                        } else if (registerResponseResponse.code() == ConfigurationFile.Constants.INVALID_DATA) {
                            System.out.println("Handle Register :" + registerResponseResponse.code()+registerResponseResponse.message());
                            callback.updateUi(ConfigurationFile.Constants.INVALID_DATA);
                        }
                    }, throwable -> {
                       // progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                    });

        }else {
            System.out.println("Register Request DisConnected ");
            callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
        }
    }

    public void addUserToFirebase(UserData data){
        reference= FirebaseDatabase.getInstance().getReference("users/carowner-"+data.getId());
        User user=new User();
        user.email=data.getEmail();
        user.name=data.getFirstName()+" "+data.getLastName();
        user.profilePicLink=data.getImage();
        reference.child("credentials").setValue(user).addOnCompleteListener(task -> {
           /* callback.updateUi(ConfigurationFile.Constants.MOVE_TO_MAIN_ACT);
            (context).finishAffinity();*/
        });
    }
}
