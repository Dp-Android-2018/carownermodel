package findandfix.view.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.tbruyelle.rxpermissions2.RxPermissions;

import findandfix.R;
import findandfix.databinding.ActivityAddUrgentRequestLocationBinding;
import findandfix.model.global.UrgentRequest;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.ToolbarViewModel;
public class ActivityAddUrgentRequestLocation extends BaseActivity implements BaseInterface{

    private ActivityAddUrgentRequestLocationBinding binding;
    private RxPermissions rxPermissions;
    private  int PLACE_PICKER_REQUEST = 1;
    private UrgentRequest urgentRequest=null;
    private double lat=ConfigurationFile.Constants.EMPTY_VALUE, lang=ConfigurationFile.Constants.EMPTY_VALUE;
   // private double lat=30.11043750000001, lang=31.37803515624999;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_add_urgent_request_location);
        rxPermissions=new RxPermissions(this);
        setUpActionBar();
        binding.btnNext.setVisibility(View.VISIBLE);
        binding.ivPinLocation.setOnClickListener(v -> CustomUtils.getInstance().requireLocationPermission(rxPermissions,ActivityAddUrgentRequestLocation.this));


        binding.btnNext.setOnClickListener(v -> {
           if (lat!= ConfigurationFile.Constants.EMPTY_VALUE && lang!=ConfigurationFile.Constants.EMPTY_VALUE &&
                   lat!=0.0 && lang!=0.0 && !binding.tvAddUrgentRequestAddress.getText().equals("")){
                       moveToNextAct();
            }else {
                Snackbar.make(binding.getRoot(),R.string.label_pic_location,Snackbar.LENGTH_LONG).show();
            }
        });

    }


    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(ActivityAddUrgentRequestLocation.this, ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_TOOLBAR)); }

    public void moveToNextAct(){

        urgentRequest=new UrgentRequest();
        urgentRequest.setLat(String.valueOf(lat));
        urgentRequest.setLng(String.valueOf(lang));
        Intent i=new Intent(ActivityAddUrgentRequestLocation.this,ActivityAddUrgentRequestType.class);
        i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_URGENT_REQUEST_OBJ,urgentRequest);
        startActivity(i);
    }

    public void startPlacePicker(){
        try {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(ActivityAddUrgentRequestLocation.this),
                    ConfigurationFile.Constants.PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUi(int code) {

        if (code==ConfigurationFile.Constants.PERMISSION_GRANTED_LOCATION)
            startPlacePicker();
        else if (code==ConfigurationFile.Constants.PERMISSION_DENIED)
            Snackbar.make(binding.getRoot(),R.string.permission_denied,Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, getApplicationContext());
                //  location.set(String.format("Place: %s", place.getAddress()));
                binding.tvAddUrgentRequestSplitter.setVisibility(View.VISIBLE);
                binding.tvAddUrgentRequestAddress.setVisibility(View.VISIBLE);
                binding.tvAddUrgentRequestAddress.setText(String.format("Place: %s", place.getAddress()));
                binding.btnNext.setVisibility(View.VISIBLE);
                LatLng lng = place.getLatLng();
                lat = lng.latitude;
                lang = lng.longitude;


            }
        }
    }
}
