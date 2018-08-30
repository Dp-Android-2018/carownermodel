package findandfix.view.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import findandfix.R;
import findandfix.databinding.ActivityAddUrgentRequestTypeBinding;
import findandfix.model.global.UrgentRequest;
import findandfix.utils.ConfigurationFile;
import findandfix.viewmodel.ToolbarViewModel;

public class ActivityAddUrgentRequestType extends BaseActivity {
    private UrgentRequest urgentRequest=null;
    private ActivityAddUrgentRequestTypeBinding biniding;
    private int typedId= ConfigurationFile.Constants.EMPTY_VALUE;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        biniding= DataBindingUtil.setContentView(this, R.layout.activity_add_urgent_request_type);
        setUpActionBar();
        urgentRequest=getExtraFromIntent();
        biniding.ivBattery.setOnClickListener(v -> {
                typedId=3;
            biniding.ivBattery.setImageResource(R.drawable.img_colored_battery);
            biniding.ivGas.setImageResource(R.drawable.img_un_colored_gas);
            biniding.ivTowed.setImageResource(R.drawable.img_un_colored_towed);
            biniding.ivTire.setImageResource(R.drawable.img_un_colored_tire);
            biniding.btnNext.setBackground(getResources().getDrawable(R.drawable.btn_red_border_background));
        });

        biniding.ivGas.setOnClickListener(v -> {
            typedId=2;
            biniding.ivGas.setImageResource(R.drawable.img_colored_gas);

            biniding.ivTire.setImageResource(R.drawable.img_un_colored_tire);
            biniding.ivTowed.setImageResource(R.drawable.img_un_colored_towed);
            biniding.ivBattery.setImageResource(R.drawable.img_un_colored_battery);
            biniding.btnNext.setBackground(getResources().getDrawable(R.drawable.btn_red_border_background));
        });

        biniding.ivTire.setOnClickListener(v -> {
                typedId=1;
            biniding.ivTire.setImageResource(R.drawable.img_colored_tire);

            biniding.ivGas.setImageResource(R.drawable.img_un_colored_gas);
            biniding.ivTowed.setImageResource(R.drawable.img_un_colored_towed);
            biniding.ivBattery.setImageResource(R.drawable.img_un_colored_battery);
            biniding.btnNext.setBackground(getResources().getDrawable(R.drawable.btn_red_border_background));
        });

        biniding.ivTowed.setOnClickListener(v -> {
            typedId=4;
            biniding.ivTowed.setImageResource(R.drawable.img_colored_towed);
            biniding.ivGas.setImageResource(R.drawable.img_un_colored_gas);
            biniding.ivTire.setImageResource(R.drawable.img_un_colored_tire);
            biniding.ivBattery.setImageResource(R.drawable.img_un_colored_battery);
            biniding.btnNext.setBackground(getResources().getDrawable(R.drawable.btn_red_border_background));
        });

        biniding.btnNext.setOnClickListener(v -> {
            if (typedId==ConfigurationFile.Constants.EMPTY_VALUE)
                Snackbar.make(findViewById(R.id.rl_parent),getString(R.string.choose_your_problem),Snackbar.LENGTH_LONG).show();
            else moveTOnextAct();
        });
    }


    public UrgentRequest getExtraFromIntent(){
        return (UrgentRequest) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_URGENT_REQUEST_OBJ);
    }

    public void setUpActionBar(){
        setSupportActionBar( biniding.toolbar.toolbar);
        biniding.toolbar.setViewmodel(new ToolbarViewModel(ActivityAddUrgentRequestType.this, ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_SECONDARY_TOOLBAR)); }


    public void moveTOnextAct(){

        urgentRequest.setTypeId(typedId);
        if (typedId==4){
            Intent i=new Intent(getApplicationContext(),ActivityAddUrgentRequestWinchType.class) ;
            i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_URGENT_REQUEST_OBJ,urgentRequest);
            startActivity(i);
        }else {

            Intent i=new Intent(getApplicationContext(),ActivityUrgentRequestNotesActivity.class) ;
            i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_URGENT_REQUEST_OBJ,urgentRequest);
            startActivity(i);
        }

    }
}
