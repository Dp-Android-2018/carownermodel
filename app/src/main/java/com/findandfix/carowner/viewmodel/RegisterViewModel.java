package com.findandfix.carowner.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.text.Editable;
import android.view.View;

import java.util.Observable;

import com.findandfix.carowner.R;
import com.findandfix.carowner.model.request.EmailRequest;
import com.findandfix.carowner.model.request.RegisterRequest;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.utils.ValidationUtils;
import com.findandfix.carowner.ui.activities.SecondStepRegister;
import com.findandfix.carowner.ui.callback.BaseInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class RegisterViewModel extends Observable {

    public ObservableField<String> email;
    public ObservableField<String> password;
    public ObservableField<String> confirmPassword;
    public ObservableField<Integer> visibleprogress;
    private CompositeDisposable compositeDisposable;
    private Context context;
    private BaseInterface callback;
    private FirstStepRegisterValidation validation;

    public RegisterViewModel(Context context, BaseInterface callback, FirstStepRegisterValidation validation) {
        this.context = context;
        this.callback = callback;
        this.validation=validation;
        initializeVariables();
    }

    public void initializeVariables() {
        email = new ObservableField<>();
        password = new ObservableField<>();
        confirmPassword = new ObservableField<>();
        compositeDisposable=new CompositeDisposable();
        visibleprogress=new ObservableField<>(View.GONE);
    }





    public void validator(final View view){
            if (validation.validator(email,password,confirmPassword))
                    checkemail(email.get());
    }



    public void checkemail(String email) {

        if(NetWorkConnection.isConnectingToInternet(context)) {
          //  visibleprogress.set(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog((Activity)context);
            EmailRequest emailRequest = new EmailRequest(email);
            Disposable disposable = ApiClient.getClient().create(EndPoints.class).checkEmail(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(context), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, emailRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(integerResponse -> {
                        if (integerResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                            System.out.println("Code code :" + integerResponse.body().toString());
                            if (integerResponse.body() == 0) {
                                //visibleprogress.set(View.GONE);
                                CustomUtils.getInstance().cancelDialog();
                                System.out.println("Code MAIL Success");
                                moveToSecondActivity();

                            } else {
                               // visibleprogress.set(View.GONE);
                                CustomUtils.getInstance().cancelDialog();
                                System.out.println("Code MAIL Failed");
                                validation.setEmailError(context.getString(R.string.exist_email));
                            }
                        }else if (integerResponse.code() == ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                                CustomUtils.getInstance().endSession((Activity)context);
                        }

                    }, throwable -> CustomUtils.getInstance().cancelDialog());
            compositeDisposable.add(disposable);
        }else {
            callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
        }

    }




    public void reset() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed())
            compositeDisposable.dispose();
        compositeDisposable = null;
        context = null;
    }

    public void moveToSecondActivity(){
        System.out.println("Move To Second Step");
        RegisterRequest registerRequest=new RegisterRequest();
        registerRequest.setEmail(email.get());
        registerRequest.setPassword(password.get());
        registerRequest.setPasswordConfirmation(password.get());
        Intent i=new Intent(context,SecondStepRegister.class);
        i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_REGISTER_REQUEST_OBJ,registerRequest);
        context.startActivity(i);


    }


    public void onEmailChanged(Editable e) {
        if (ValidationUtils.isMail(e.toString())) {
            validation.setEmailError("");
        } else {
            validation.setEmailError(context.getString(R.string.invalid_email_format));
        }
    }

    public void onPasswordChanged(Editable e) {

        if (e.toString().length()>=ConfigurationFile.Constants.MINIMUM_PASSWORD_LENGTH) {
            validation.setPasswordError("");
        } else {
            validation.setPasswordError(context.getString(R.string.password_length));
        }
    }

    public void onConfirmPasswordChanged(Editable e) {

        if (e.toString().length()<ConfigurationFile.Constants.MINIMUM_PASSWORD_LENGTH) {
            validation.setConfirmPasswordError(context.getString(R.string.password_length));

        } else if(!e.toString().equals(password.get())){
            validation.setConfirmPasswordError(context.getString(R.string.password_confirm_not_match));
        }else {
            validation.setConfirmPasswordError("");
        }
    }

}
