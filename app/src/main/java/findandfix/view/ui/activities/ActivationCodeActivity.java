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
import findandfix.databinding.FragmentActiveAccountBinding;
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
    FragmentActiveAccountBinding binding;
    private ToolbarViewModel toolbarViewModel;
    private UserData userData;
    private SendActivationCodeRequest sendActivationCodeRequest;
    private CheckActivationCodeRequest checkActivationCodeRequest;
    private SharedPrefrenceUtils pref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.fragment_active_account);
        userData=CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
        setUpToolBar();}

    public void setUpToolBar() {
        setSupportActionBar(binding.toolbar.toolbar);
        toolbarViewModel = new ToolbarViewModel(ActivationCodeActivity.this, ConfigurationFile.Constants.HANDLE_ACTIVATION_CODE_TOOLBAR);
        binding.toolbar.setViewmodel(toolbarViewModel);
        if (CustomUtils.getInstance().getAppLanguage(ActivationCodeActivity.this).equals("ar")) {
            binding.toolbar.toolbar.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
    }




}
