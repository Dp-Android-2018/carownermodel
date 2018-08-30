package findandfix.view.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tbruyelle.rxpermissions2.RxPermissions;

import findandfix.R;
import findandfix.databinding.ActivityRequestDetailsBinding;
import findandfix.model.global.BaseModel;
import findandfix.model.global.Conv.ConversationHistory;
import findandfix.model.global.Conv.ConversationsLocation;
import findandfix.model.global.Conv.WorkshopFire;
import findandfix.model.global.RequestOfferObj;
import findandfix.model.global.UserData;
import findandfix.model.request.NormalRequestDetailObject;
import findandfix.model.response.ActiveNormalRequestResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.utils.SharedPrefrenceUtils;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class RequestDetailActivity extends BaseActivity implements BaseInterface {

    private ActivityRequestDetailsBinding binding;
    private RequestOfferObj requestOfferObj = null;
    private NormalRequestDetailObject requestDetailObject=null;
    private int requestId=0;
    private RxPermissions rxPermissions;
    private UserData userData;
    private DatabaseReference reference;
    private String deviceToken=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_request_details);
        binding = DataBindingUtil.setContentView(RequestDetailActivity.this, R.layout.activity_request_details);
        userData=CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
        getExtraFromIntents();
        setUpToolBar();
        rxPermissions = new RxPermissions(this);
        deviceToken=requestOfferObj.getWorkshop().getDeviceToken();
        binding.tvDistanceContent.setText(requestOfferObj.getDistance() == null ? " 0 " + getString(R.string.km) : String.valueOf(requestOfferObj.getDistance()) + getString(R.string.km));
        binding.tvNormalRequestNumContent.setText(String.valueOf(requestOfferObj.getNormalRequestsCount()));
        binding.tvUrgentRequestNumContent.setText(String.valueOf(requestOfferObj.getUrgentRequestsCount()));
        binding.tvDistanceContent.setText(requestOfferObj.getDistance()==null? " 0 " +getString(R.string.km):String.valueOf(requestOfferObj.getDistance())+getString(R.string.km));
        binding.tvPriceValueContent.setText(String.valueOf(requestOfferObj.getCostFrom()) + ":" + String.valueOf(requestOfferObj.getCostTo()));
        binding.tvAvgTimeValueContent.setText(String.valueOf(requestOfferObj.getDurationFrom()) + ":" + String.valueOf(requestOfferObj.getDurationTo()));
        binding.tvOfferTimeValueContent.setText(requestOfferObj.getDate());
        binding.tvDescContent.setText(requestOfferObj.getDescription()!=null? getString(R.string.no_desc):requestOfferObj.getDescription());
        if (requestOfferObj.getRate()!=null){
            binding.ratingContent.setRating(Float.parseFloat(requestOfferObj.getRate()));
            binding.tvRateValueContent.setText("("+requestOfferObj.getRate()+") "+getString(R.string.rate_label));
        }


        binding.btnCall.setOnClickListener(v -> CustomUtils.getInstance().requirePhonePermission(rxPermissions, RequestDetailActivity.this));
        // binding.tvDistanceContent.set

        binding.btnChat.setOnClickListener(v -> {
            CustomUtils.getInstance().showProgressDialog(RequestDetailActivity.this);
            addUserToFirebase();
        });
    }

    public void setUpToolBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(RequestDetailActivity.this, ConfigurationFile.Constants.HANDLE_REQUEST_DETAIL_TOOLBAR));
    }

    public void getExtraFromIntents() {
        requestOfferObj = (RequestOfferObj) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.WORKSHOP_OFFER_OBJ);
        if (getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.REQUESt_DETAIL_OBJ)!=null){
        requestDetailObject=(NormalRequestDetailObject)getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.REQUESt_DETAIL_OBJ);
        updateView(requestDetailObject);}
        else {
           getCarOwnerActiveRequests();
        }

    }

    @Override
    public void updateUi(int code) {
        System.out.println("CallBack Code :"+code);
        if (code == ConfigurationFile.Constants.PERMISSION_GRANTED_PHONE_CALL)
            makeCall();
        else if (code == ConfigurationFile.Constants.PERMISSION_DENIED_PHONE_CALL)
            Snackbar.make(binding.llParent, getString(R.string.permission_denied), Snackbar.LENGTH_LONG).show();
    }

    public void makeCall() {
        System.out.println("CallBack Code Calling");
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        String workShopPhone = "tel:" + requestOfferObj.getWorkshop().getMobile();
        callIntent.setData(Uri.parse(workShopPhone));
        /*if (ActivityCompat.checkSelfPermission(RequestDetailActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }*/
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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



    public void getCarOwnerActiveRequests(){


        if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
           // binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(RequestDetailActivity.this);
            ApiClient.getClient().create(EndPoints.class).getCarOwnerActiveRequests(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(activeNormalRequestResponseResponse -> {
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Message Of Request Details CODE :"+activeNormalRequestResponseResponse.code());
                       // binding.progressBar.setVisibility(View.GONE);

                        if (activeNormalRequestResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){
                              System.out.println("Message Of Request Details CODE Active"+activeNormalRequestResponseResponse.body());
                            ActiveNormalRequestResponse activeNormalRequestResponse=activeNormalRequestResponseResponse.body();
                            NormalRequestDetailObject normalRequestDetailObject=activeNormalRequestResponse.getData();

                            if (normalRequestDetailObject!=null) {
                               updateView(normalRequestDetailObject);
                            }

                        } else if (activeNormalRequestResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                activeNormalRequestResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                            Snackbar.make(binding.llParent, R.string.unuthenticated, Snackbar.LENGTH_LONG).show();
                            CustomUtils.getInstance().endSession(RequestDetailActivity.this);
                        } else if (activeNormalRequestResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(binding.llParent, R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                     //   binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(binding.llParent,getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }


    public void updateView(NormalRequestDetailObject requestDetailObject){
        if (requestDetailObject!=null){
            String specializeText="";
            for (BaseModel specialize:requestDetailObject.getSpecializations())
                specializeText=specializeText+specialize.getName();
            binding.tvRequestDetailsType.setText(specializeText);
            binding.tvRequestDetailsModel.setText(requestDetailObject.getBrand()+"-"+requestDetailObject.getModel()+"-"+requestDetailObject.getYear());
            binding.tvRequestDetailsLocation.setText(requestDetailObject.getAddress());
            binding.tvRequestDetailsCalender.setText(requestDetailObject.getDate());
            binding.progress1.setProgress((int)requestDetailObject.getPercentage());
            binding.tvPercentage.setText(((int)requestDetailObject.getPercentage())+" %");
        }
    }

    public void addUserToFirebase(){
        reference= FirebaseDatabase.getInstance().getReference("users/carowner-"+userData.getId());
        WorkshopFire workshopFire=new WorkshopFire();
        workshopFire.device_token=requestOfferObj.getWorkshop().getDeviceToken();
        workshopFire.location="FAF"+requestOfferObj.getWorkshop().getId()+"-"+userData.getId();
        workshopFire.sender_name=requestOfferObj.getWorkshop().getName();
        reference.child("conversations/workshop-"+requestOfferObj.getWorkshop().getId()).setValue(workshopFire).addOnCompleteListener(task -> addWorkshopConv());
    }

    public void addWorkshopConv(){
        reference= FirebaseDatabase.getInstance().getReference("users/workshop-"+requestOfferObj.getWorkshop().getId());
        WorkshopFire workshopFire=new WorkshopFire();
        workshopFire.device_token=userData.getToken();
        workshopFire.location="FAF"+requestOfferObj.getWorkshop().getId()+"-"+userData.getId();
        workshopFire.sender_name=userData.getFirstName()+" "+userData.getLastName();
        reference.child("conversations/carowner-"+userData.getId()).setValue(workshopFire).addOnCompleteListener(task -> {
            CustomUtils.getInstance().cancelDialog();
            ConversationsLocation conversationsLocation=new ConversationsLocation();
            conversationsLocation.setSecondUserUrl("workshop-"+requestOfferObj.getWorkshop().getId());
            conversationsLocation.sender_name=requestOfferObj.getWorkshop().getName();
            conversationsLocation.location="FAF"+requestOfferObj.getWorkshop().getId()+"-"+userData.getId();

            ConversationHistory conversationHistory=new ConversationHistory(null,conversationsLocation);
            Intent i=new Intent(getApplicationContext(),ChatActivity.class);
            i.putExtra("Conversation_Id",conversationHistory);
            i.putExtra(ConfigurationFile.IntentsConstants.DEVICE_TOKEN,deviceToken);
            startActivity(i);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(RequestDetailActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
