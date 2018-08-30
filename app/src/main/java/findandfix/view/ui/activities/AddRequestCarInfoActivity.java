package findandfix.view.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import findandfix.R;
import findandfix.databinding.ActivityAddRequestLayoutBinding;
import findandfix.model.global.UserData;
import findandfix.model.request.AddNormalRequest;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.viewmodel.ToolbarViewModel;

public class AddRequestCarInfoActivity extends BaseActivity {

    private ActivityAddRequestLayoutBinding binding;
    private UserData userData;
    private AddNormalRequest addNormalRequest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(AddRequestCarInfoActivity.this, R.layout.activity_add_request_layout);
        setUpActionBar();
        getExtraFromIntents();
        getUserData();
        setDataToUi();
    }

    public void getExtraFromIntents(){
        addNormalRequest=(AddNormalRequest)getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ);
    }

    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(AddRequestCarInfoActivity.this, ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_SECONDARY_TOOLBAR));}

    public void getUserData(){
        userData= CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
    }
    public void setDataToUi(){
        binding.tvCarInfo.setText(userData.getGarages().get(0).getBrand().getName()+"-"+userData.getGarages().get(0).getModel().getName()+"-"+userData.getGarages().get(0).getYear());
        binding.btnLoginAnother.setOnClickListener(v -> {
            Intent i=new Intent(AddRequestCarInfoActivity.this,AddGarageActivity.class);
            startActivity(i);
        });

        binding.btnLoginEnter.setOnClickListener(v -> {
            addNormalRequest.setGarageId(userData.getGarages().get(0).getId());
            Intent i=new Intent(AddRequestCarInfoActivity.this,AddRequestProblemActivity.class);
            i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ,addNormalRequest);
            startActivity(i);
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
