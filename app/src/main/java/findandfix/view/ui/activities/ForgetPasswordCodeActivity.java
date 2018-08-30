package findandfix.view.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.text.InputType;
import android.view.View;

import findandfix.R;
import findandfix.databinding.ActivityForgotPasswordLayoutBinding;
import findandfix.model.request.CheckCode;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ForgetPasswordCodeActivity extends BaseActivity {
    ActivityForgotPasswordLayoutBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_forgot_password_layout);
        binding.etMobile.setHint(R.string.please_enter_code);
        binding.etMobile.setInputType(InputType.TYPE_CLASS_TEXT);
        binding.btnLoginEnter.setOnClickListener(v -> {
            if (binding.etMobile.getText().toString().trim().equals("")){
                Snackbar.make(findViewById(R.id.rl_parent), R.string.please_enter_data,Snackbar.LENGTH_LONG).show();
            }else {
               checkCode();
            }
        });
    }

    @SuppressLint("CheckResult")
    public void checkCode(){

        if (NetWorkConnection.isConnectingToInternet(ForgetPasswordCodeActivity.this)) {
            CustomUtils.getInstance().showProgressDialog(ForgetPasswordCodeActivity.this);
            CheckCode checkCode=new CheckCode(binding.etMobile.getText().toString().trim());
            ApiClient.getClient().create(EndPoints.class).hasRestToken(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,checkCode)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(defaultResponseResponse -> {
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Code Code  :"+defaultResponseResponse.code());
                        System.out.println("Code Code  Value:"+defaultResponseResponse.body());
                        if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {

                            if (defaultResponseResponse.body()==1) {
                                Intent i = new Intent(ForgetPasswordCodeActivity.this, RestPasswordActivity.class);
                                i.putExtra(ConfigurationFile.IntentsConstants.USER_CODE, binding.etMobile.getText().toString().trim());
                                startActivity(i);
                            }else if (defaultResponseResponse.body()==0){
                                Snackbar.make(findViewById(R.id.rl_parent), R.string.invalid_code,Snackbar.LENGTH_LONG).show();
                            }
                        }else if (defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                            CustomUtils.getInstance().endSession(ForgetPasswordCodeActivity.this);
                        } else if (defaultResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(findViewById(R.id.rl_parent), R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                        CustomUtils.getInstance().cancelDialog();
                        //  binding.progressBar.setVisibility(View.GONE);
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(findViewById(R.id.rl_parent),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }
    }
}
