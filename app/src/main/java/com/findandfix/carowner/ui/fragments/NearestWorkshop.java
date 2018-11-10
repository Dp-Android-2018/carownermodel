package com.findandfix.carowner.ui.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;
import com.ramotion.foldingcell.FoldingCell;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityWorkshopOffersLayoutBinding;
import com.findandfix.carowner.databinding.FragmentAboutLayoutBinding;
import com.findandfix.carowner.databinding.FragmentNearestWorkshopLayoutBinding;
import com.findandfix.carowner.model.global.RequestOfferObj;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.global.WorkshopSearchObj;
import com.findandfix.carowner.model.response.WorkshopSearchResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.ui.activities.ActivityAddUrgentRequestLocation;
import com.findandfix.carowner.ui.activities.FilterActivity;
import com.findandfix.carowner.ui.activities.WorkShopAchievmentActivity;
import com.findandfix.carowner.ui.adapters.FoldingCellListAdapter;
import com.findandfix.carowner.ui.adapters.FoldingCellWorkshopSearchAdapter;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.ui.callback.PhoneCallListener;
import com.findandfix.carowner.ui.callback.RecycleItemClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by DELL on 15/08/2018.
 */

public class NearestWorkshop extends Fragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener ,BaseInterface{

    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private double currentLatitude;
    private double currentLongitude;
    private UserData userData;
    private List<WorkshopSearchObj>workshops;
    private ArrayList<Integer>selectedWensh=null;
    private ArrayList<Integer>selectedIds=null;
    private FragmentNearestWorkshopLayoutBinding binding;
    FoldingCellWorkshopSearchAdapter adapter=null;
    private RxPermissions rxPermissions;
    private static int checker=1;
    private String phone=null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_nearest_workshop_layout,container,false);
        View view=binding.getRoot();
        userData=CustomUtils.getInstance().getSaveUserObject(getActivity());
        workshops=new ArrayList<>();
        makeFilterAction();
        rxPermissions=new RxPermissions(getActivity());
        statusCheck();
        System.out.println("User Data Code :"+userData.getId()+" "+userData.getToken());
        //Define a request code to send to Google Play services
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                // The next two lines tell the new client that “this” current class will handle connection stuff
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                //fourth line adds the LocationServices API endpoint from GooglePlayServices
                .addApi(LocationServices.API)
                .build();

        // Create the LocationRequest object
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1 * 1000); // 1 second, in milliseconds

        return view;
    }


    public void makeFilterAction(){
        Toolbar toolbar=(Toolbar)((AppCompatActivity)getActivity()).findViewById(R.id.toolbar);
        ImageView ivFilter=toolbar.findViewById(R.id.iv_toolbar_filter);
        ivFilter.setOnClickListener(v -> {
            Intent intent=new Intent(getActivity(),FilterActivity.class);
            startActivityForResult(intent, ConfigurationFile.Constants.REQUEST_CODE);
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        mGoogleApiClient.connect();


    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(this.getClass().getSimpleName(), "onPause()");

        //Disconnect from API onPause()
        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity()

                , Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

        } else {
            //If everything went fine lets get latitude and longitude
            currentLatitude = location.getLatitude();
            currentLongitude = location.getLongitude();
            System.out.println("Data Code Loc :"+currentLatitude+" "+currentLongitude);
            if (checker==1) {
                checker=2;
                findNearestWorkshop(selectedWensh, selectedIds);
            }
           // Toast.makeText(getActivity().getApplicationContext(), currentLatitude + " WORKS 1:" + currentLongitude + "", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
 /*
             * Google Play services can resolve some errors it detects.
             * If the error has a resolution, try sending an Intent to
             * start a Google Play services activity that can resolve
             * error.
             */
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(getActivity(), CONNECTION_FAILURE_RESOLUTION_REQUEST);
                    /*
                     * Thrown if Google Play services canceled the original
                     * PendingIntent
                     */
            } catch (IntentSender.SendIntentException e) {
                // Log the error
                e.printStackTrace();
            }
        } else {
                /*
                 * If no resolution is available, display a dialog to the
                 * user with the error.
                 */
            Log.e("Error", "Location services connection failed with code " + connectionResult.getErrorCode());
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        currentLatitude = location.getLatitude();
        currentLongitude = location.getLongitude();
      //  findNearestWorkshop(selectedWensh,selectedIds);
       // Toast.makeText(getActivity(), currentLatitude + " WORKS 2:" + currentLongitude + "", Toast.LENGTH_LONG).show();
    }

    public void findNearestWorkshop(ArrayList<Integer>selectedWensh,ArrayList<Integer>selectedIds){
        if (selectedWensh!=null)
        System.out.println("Result Result 3 :"+selectedWensh.size());
        else if (selectedIds!=null)
        System.out.println("Result Result 4 :"+selectedIds.size());

        System.out.println("Result Result 3 Latitude  :"+currentLatitude);
        System.out.println("Result Result 3Langtiude  :"+currentLongitude);
        if (workshops.size()==0) {
            if (NetWorkConnection.isConnectingToInternet(getActivity().getApplicationContext())) {
                System.out.println("Code cONNECTING");
                System.out.println("Token of User :" + userData.getToken());
                CustomUtils.getInstance().showProgressDialog(getActivity());
                ApiClient.getClient().create(EndPoints.class).findNearestWorkshop(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(getActivity()), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, "Bearer " + userData.getToken(), currentLatitude, currentLongitude, selectedWensh, selectedIds)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Response<WorkshopSearchResponse>>() {
                            @Override
                            public void accept(Response<WorkshopSearchResponse> workshopSearchResponseResponse) throws Exception {

                                CustomUtils.getInstance().cancelDialog();
                                int code = workshopSearchResponseResponse.code();
                                System.out.println("Data Code :" + code);
                                if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                                    System.out.println("Data Code Data :" + workshopSearchResponseResponse.body().getData().size());
                                    workshops.addAll(workshopSearchResponseResponse.body().getData());
                                    setAdapter(workshops);
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                System.out.println("Ex :" + throwable.getMessage());
                            }
                        });
            } else {

            }
        }
    }



    public void setAdapter(List<WorkshopSearchObj> objList){
        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        adapter = new FoldingCellWorkshopSearchAdapter(getActivity(), objList);

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(v -> Toast.makeText(getActivity(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show());

        // set elements to adapter
        binding.mainListView.setAdapter(adapter);

        // set on click event listener to list view
        binding.mainListView.setOnItemClickListener((adapterView, view, pos, l) -> {
            System.out.println("Toggled");
            // toggle clicked cell state
            ((FoldingCell) view).toggle(false);
            // \\register in adapter that state for selected cell is toggled
            adapter.registerToggle(pos);
        });



        adapter.setAchievmentItemClickListener(workshopId -> {
                    Intent i=new Intent(getActivity(),WorkShopAchievmentActivity.class);
                    i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_ID,workshopId);
                    startActivity(i);
                }

        );

        adapter.setPhoneCallListener(new PhoneCallListener() {
            @Override
            public void onPhoneCall(String phoneNumber) {
                phone=phoneNumber;
                CustomUtils.getInstance().requirePhonePermission(rxPermissions,NearestWorkshop.this);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==ConfigurationFile.Constants.REQUEST_CODE && data!=null){
            if (data.getSerializableExtra(ConfigurationFile.IntentsConstants.WENSH_TYPES)!=null){
                selectedIds=null;
                selectedWensh=new ArrayList<>();
                selectedWensh=(ArrayList<Integer>)data.getSerializableExtra(ConfigurationFile.IntentsConstants.WENSH_TYPES);
                System.out.println("Result 1 :"+selectedWensh.size());
                for (int i=0;i<selectedWensh.size();i++){
                    System.out.println("Result 1 Detail :"+selectedWensh.get(i));
                }
            }else if (data.getSerializableExtra(ConfigurationFile.IntentsConstants.SPECIALIZATION_TYPES)!=null){
                selectedWensh=null;
                selectedIds=new ArrayList<>();
                selectedIds= (ArrayList<Integer>) data.getSerializableExtra(ConfigurationFile.IntentsConstants.SPECIALIZATION_TYPES);
                System.out.println("Result 2 :"+selectedIds.size());
                for (int i=0;i<selectedIds.size();i++){
                    System.out.println("Result 2 Detail :"+selectedIds.get(i));
                }
            }

                    workshops.clear();
                findNearestWorkshop(selectedWensh,selectedIds);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        checker=1;
    }

    @Override
    public void updateUi(int code) {
         if (code==ConfigurationFile.Constants.PERMISSION_DENIED)
            Snackbar.make(binding.getRoot(),R.string.permission_denied,Snackbar.LENGTH_LONG).show();

       else if (code == ConfigurationFile.Constants.PERMISSION_GRANTED_PHONE_CALL)
            makeCall();

    }

    public void statusCheck() {
        final LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }



    public void makeCall() {
        System.out.println("CallBack Code Calling");
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        String workShopPhone = "tel:" + phone;
        callIntent.setData(Uri.parse(workShopPhone));
        /*if (ActivityCompat.checkSelfPermission(RequestDetailActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }*/
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            return;
        }
        startActivity(callIntent);

    }

}
