package findandfix.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.google.android.gms.internal.zzahn;
import com.google.firebase.FirebaseApp;

import java.util.Observable;

import findandfix.model.global.UserData;
import findandfix.model.request.LoginRequest;
import findandfix.model.response.LoginRegisterResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.notification.MyFirebaseInstanceIdService;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.utils.SharedPrefrenceUtils;
import findandfix.utils.ValidationUtils;
import findandfix.view.ui.callback.BaseInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class LoginViewModel extends Observable {

    public ObservableField<String> email;
    public  ObservableField<String> password;
    public ObservableField<String> phone;
    public ObservableInt progressDialog;
    private   CompositeDisposable compositeDisposable;
    private Context context;
    private BaseInterface callback;
    private SharedPrefrenceUtils pref;
    private String token;
    public LoginViewModel(Context context, BaseInterface callback) {
        this.context=context;
        this.callback=callback;
        initializeVariables();
        token=getFirebaseToken();
    }

    public void initializeVariables(){
        email=new ObservableField<>();
        password=new ObservableField<>();
        phone=new ObservableField<>();
        progressDialog=new ObservableInt(View.GONE);
        compositeDisposable=new CompositeDisposable();
    }

    public String getFirebaseToken(){
        final MyFirebaseInstanceIdService mfs=new MyFirebaseInstanceIdService();
        FirebaseApp.initializeApp(context);
        zzahn.runOnUiThread(() -> mfs.onTokenRefresh());
        System.out.println("User Token :"+ MyFirebaseInstanceIdService.TOKEN);
        return MyFirebaseInstanceIdService.TOKEN;
    }

    public void checkLogin(final View view){

        if(ValidationUtils.isEmpty(email.get()) || ValidationUtils.isEmpty(password.get())){
            callback.updateUi(ConfigurationFile.Constants.FILL_ALL_DATTA);
        }else {
            if(NetWorkConnection.isConnectingToInternet(context)) {
                if (!ValidationUtils.isMail(email.get()) && ValidationUtils.isPhone(email.get())) {
                    phone.set(email.get());
                    email.set(null);
                }
                System.out.println("Login FireBase Token :"+token);
             //   progressDialog.set(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog((Activity) context);
                final LoginRequest loginRequest = new LoginRequest(email.get(), phone.get(), password.get(), token);
                Disposable disposable = ApiClient.getClient().create(EndPoints.class).login(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(context), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, loginRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(loginResponseResponse -> {
                       //     progressDialog.set(View.GONE);
                            CustomUtils.getInstance().cancelDialog();
                            if (loginResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                                LoginRegisterResponse loginResponse = loginResponseResponse.body();
                                saveDataToPrefs(loginResponse.getData());
                                setChanged();
                                notifyObservers();
                            } else if (loginResponseResponse.code() == ConfigurationFile.Constants.INVALID_USERNAME_PASSWORD_LOGIN_CODE) {
                                callback.updateUi(ConfigurationFile.Constants.INVALID_USERNAME_PASSWORD_LOGIN_CODE);
                            } else if (loginResponseResponse.code() == ConfigurationFile.Constants.INVALID_DATA) {
                                callback.updateUi(ConfigurationFile.Constants.INVALID_DATA);
                            }
                        }, throwable -> {
                        //    progressDialog.set(View.GONE);
                            CustomUtils.getInstance().cancelDialog();
                        });

                compositeDisposable.add(disposable);
            }else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }
    }


    public void reset(){
        unSubScribe();
        compositeDisposable=null;
        context=null;
    }

    public void saveDataToPrefs(UserData data){
        pref=new SharedPrefrenceUtils(context);
        pref.saveObjectToSharedPreferences(ConfigurationFile.SharedPrefConstants.PREF_CAR_OWNER_OBJ_DATA,data);
    }

    public void unSubScribe(){
        if(compositeDisposable!=null && ! compositeDisposable.isDisposed())
            compositeDisposable.dispose();
    }

    public void moveToRegisterAct(View view){
        callback.updateUi(ConfigurationFile.Constants.MOVE_TO_REGISTER_ACTIVITY);
    }



}
