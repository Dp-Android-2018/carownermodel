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
import findandfix.databinding.ActivityAddRequestLocationBinding;
import findandfix.model.request.AddNormalRequest;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.ToolbarViewModel;

public class AddRequestLocationActivity extends BaseActivity implements BaseInterface{
    ActivityAddRequestLocationBinding binding;
    private  int PLACE_PICKER_REQUEST = 1;
   //private double lat=ConfigurationFile.Constants.EMPTY_VALUE, lang=ConfigurationFile.Constants.EMPTY_VALUE;
   private double lat=30.11043750000001, lang=31.37803515624999;
    private RxPermissions rxPermissions;
    private AddNormalRequest addNormalRequest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(AddRequestLocationActivity.this, R.layout.activity_add_request_location);
        rxPermissions=new RxPermissions(this);
        setUpActionBar();
        getExtraFromIntents();
        binding.btnChooseLocation.setOnClickListener(v -> CustomUtils.getInstance().requireLocationPermission(rxPermissions,AddRequestLocationActivity.this));

        binding.btnNext.setOnClickListener(v -> {
            if (lat!=ConfigurationFile.Constants.EMPTY_VALUE && lang!=ConfigurationFile.Constants.EMPTY_VALUE &&
                    lat!=0.0 && lang!=0.0){
                moveToNextAct();
            }else {
                Snackbar.make(binding.getRoot(),R.string.label_pic_location,Snackbar.LENGTH_LONG).show();
            }
        });
    }


    public void getExtraFromIntents(){
        addNormalRequest=(AddNormalRequest)getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ);
    }

    public void moveToNextAct(){
        addNormalRequest.setLat(lat);
        addNormalRequest.setLng(lang);
        Intent i=new Intent(AddRequestLocationActivity.this,AddRequestMediaActivity.class);
        i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ,addNormalRequest);
        startActivity(i);
    }

    public void startPlacePicker(){
        try {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(AddRequestLocationActivity.this),
                    ConfigurationFile.Constants.PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(AddRequestLocationActivity.this, ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_SECONDARY_TOOLBAR)); }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, getApplicationContext());
              //  location.set(String.format("Place: %s", place.getAddress()));
                binding.etCarOwnerLocation.setVisibility(View.VISIBLE);
                binding.etCarOwnerLocation.setText(String.format("Place: %s", place.getAddress()));
                LatLng lng = place.getLatLng();
                lat = lng.latitude;
                lang = lng.longitude;

            }
        }
    }

    @Override
    public void updateUi(int code) {
        if (code==ConfigurationFile.Constants.PERMISSION_GRANTED_LOCATION)
            startPlacePicker();
        else if (code==ConfigurationFile.Constants.PERMISSION_DENIED)
            Snackbar.make(binding.getRoot(),R.string.permission_denied,Snackbar.LENGTH_LONG).show();
    }
}
