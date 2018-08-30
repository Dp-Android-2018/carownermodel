package findandfix.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import findandfix.model.global.UserData;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.SharedPrefrenceUtils;
import findandfix.view.ui.activities.ActivationCodeActivity;
import findandfix.view.ui.activities.LoginActivity;
import findandfix.view.ui.activities.MainActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by DELL on 12/06/2018.
 */

public class ActivateAccountViewModel extends BaseObservable {

    private UserData userData;
    private Context context;
    public ActivateAccountViewModel(Context context) {
        this.context=context;
        userData= CustomUtils.getInstance().getSaveUserObject(context);
        checkActivation();
    }

    public void checkActivation(){
        CustomUtils.getInstance().showProgressDialog((Activity)context);
        ApiClient.getClient().create(EndPoints.class).checkUserActivation(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(context), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(defaultResponseResponse -> {
                        CustomUtils.getInstance().cancelDialog();
                    if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){

                        if(defaultResponseResponse.code()==1) {
                            userData.setConfirmed(ConfigurationFile.Constants.USER_ACTIVATED);
                            saveUserData();
                            Intent i = new Intent(context, MainActivity.class);
                            context.startActivity(i);
                            ((Activity) context).finish();
                        }}else if (defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                        CustomUtils.getInstance().endSession((Activity)context);
                    }else {
                        System.out.println("Car Owner UNUthenticated");
                    }
                }, throwable -> {
                    CustomUtils.getInstance().cancelDialog();
                    System.out.println(throwable.getMessage());
                });
    }

    public void saveUserData(){
        SharedPrefrenceUtils utils=new SharedPrefrenceUtils(context);
        utils.saveObjectToSharedPreferences(ConfigurationFile.SharedPrefConstants.PREF_CAR_OWNER_OBJ_DATA,userData);
    }
    public void activeByMobile(View view){
                 Intent i=new Intent(context, ActivationCodeActivity.class);
             context.startActivity(i);
    }
}
