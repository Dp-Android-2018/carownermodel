package findandfix.view.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;

import findandfix.R;
import findandfix.databinding.ActivityActivationCodeLayoutBinding;
import findandfix.model.global.CheckActivationCodeRequest;
import findandfix.model.global.SendActivationCodeRequest;
import findandfix.model.global.UserData;
import findandfix.model.response.DefaultResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.utils.SharedPrefrenceUtils;
import findandfix.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by DELL on 13/08/2018.
 */

public class ActivationCodeActivity extends AppCompatActivity {
    ActivityActivationCodeLayoutBinding binding;
    private ToolbarViewModel toolbarViewModel;
    private UserData userData;
    private SendActivationCodeRequest sendActivationCodeRequest;
    private CheckActivationCodeRequest checkActivationCodeRequest;
    private SharedPrefrenceUtils pref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_activation_code_layout);
        userData=CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
        setUpToolBar();
        getActivationCode();
        binding.btnActiveMobile.setOnClickListener(v -> {
                    if (!binding.etActivateCode.getText().toString().equals(""))
                        checkActivationCode();
                    else  Snackbar.make(binding.getRoot(), R.string.enter_code, Snackbar.LENGTH_LONG).show();
        });
    }

    public void setUpToolBar() {
        setSupportActionBar(binding.toolbar.toolbar);
        toolbarViewModel = new ToolbarViewModel(ActivationCodeActivity.this, ConfigurationFile.Constants.HANDLE_ACTIVATION_CODE_TOOLBAR);
        binding.toolbar.setViewmodel(toolbarViewModel);
        if (CustomUtils.getInstance().getAppLanguage(ActivationCodeActivity.this).equals("ar")) {
            binding.toolbar.toolbar.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
    }


    public void getActivationCode(){
        if(NetWorkConnection.isConnectingToInternet(ActivationCodeActivity.this)) {
            sendActivationCodeRequest=new SendActivationCodeRequest(userData.getMobile());
            CustomUtils.getInstance().showProgressDialog(ActivationCodeActivity.this);
            ApiClient.getClient().create(EndPoints.class).sendActivationCode(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(getApplicationContext()), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, "Bearer "+userData.getToken(),sendActivationCodeRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<DefaultResponse>>() {
                        @Override
                        public void accept(Response<DefaultResponse> defaultResponseResponse) throws Exception {
                            CustomUtils.getInstance().cancelDialog();
                            System.out.println("Code :"+defaultResponseResponse.code());
                            if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                                System.out.println("Activated Send Successfully");
                                Snackbar.make(binding.getRoot(), R.string.code_sent_success, Snackbar.LENGTH_LONG).show();
                            }

                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            CustomUtils.getInstance().cancelDialog();
                            System.out.println("ActivationCodeActivity Ex:"+throwable.getMessage());
                        }
                    });
        }else {
            Snackbar.make(binding.getRoot(), R.string.msg_internet_connection,Snackbar.LENGTH_LONG).show();
        }
    }


    public void checkActivationCode(){
        if(NetWorkConnection.isConnectingToInternet(ActivationCodeActivity.this)) {
            checkActivationCodeRequest=new CheckActivationCodeRequest(binding.etActivateCode.getText().toString());
            System.out.println("Request Data :"+new Gson().toJson(checkActivationCodeRequest));
            CustomUtils.getInstance().showProgressDialog(ActivationCodeActivity.this);
            ApiClient.getClient().create(EndPoints.class).checkActivationCode(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(getApplicationContext()), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, "Bearer "+userData.getToken(),checkActivationCodeRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<DefaultResponse>>() {
                        @Override
                        public void accept(Response<DefaultResponse> defaultResponseResponse) throws Exception {
                            CustomUtils.getInstance().cancelDialog();
                            System.out.println("Code :"+defaultResponseResponse.code());
                            System.out.println("Message :"+defaultResponseResponse.body().getMessage());
                            if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                               userData.setConfirmed(1);
                                saveDataToPrefs(userData);
                                Intent i=new Intent(getApplicationContext(),SplashActivity.class);
                                startActivity(i);
                            }else if (defaultResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                                Snackbar.make(binding.getRoot(), R.string.invalid_code_checker,Snackbar.LENGTH_LONG).show();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            CustomUtils.getInstance().cancelDialog();
                            System.out.println("ActivationCodeActivity Ex:"+throwable.getMessage());
                        }
                    });
        }else {
            Snackbar.make(binding.getRoot(), R.string.msg_internet_connection,Snackbar.LENGTH_LONG).show();
        }
    }

    public void saveDataToPrefs(UserData data){
        pref=new SharedPrefrenceUtils(getApplicationContext());
        pref.saveObjectToSharedPreferences(ConfigurationFile.SharedPrefConstants.PREF_CAR_OWNER_OBJ_DATA,data);
    }

}
