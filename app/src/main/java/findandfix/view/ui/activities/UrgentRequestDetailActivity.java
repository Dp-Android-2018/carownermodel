package findandfix.view.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.chibde.visualizer.BarVisualizer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.IOException;

import findandfix.R;
import findandfix.databinding.ActivityUrgentRequstInfoBinding;
import findandfix.model.global.Conv.ConversationHistory;
import findandfix.model.global.Conv.ConversationsLocation;
import findandfix.model.global.Conv.WorkshopFire;
import findandfix.model.global.UrgentRequestOfferObj;
import findandfix.model.global.UserData;
import findandfix.model.request.UrgentRequestDetailObject;
import findandfix.model.response.ActiveUrgentRequestResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class UrgentRequestDetailActivity extends BaseActivity implements BaseInterface{
    ActivityUrgentRequstInfoBinding binding;
    private UserData userData;
    private RxPermissions rxPermissions;
    private UrgentRequestOfferObj offerObj=null;
    private UrgentRequestDetailObject urgentRequestDetailObject=null;
    private  BarVisualizer barVisualizer;
    private DatabaseReference reference;
    private boolean isSoundWork=false;
    private String deviceToken=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_urgent_requst_info);
         barVisualizer = findViewById(R.id.visualizer);
        //(com.chibde.audiovisulaizer.visualizer.BarVisualizer)binding.visualizer
        //binding.visualizer
        barVisualizer.setVisibility(View.GONE);
        setUpActionBar();
        userData= CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
        getExtraFromIntents();
        deviceToken=offerObj.getWorkshop().getDeviceToken();
        rxPermissions = new RxPermissions(this);
    }


    public void getExtraFromIntents() {
        System.out.println("Log Urgent Noti Details");
        offerObj = (UrgentRequestOfferObj) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.WORKSHOP_URGENT_OFFER);
        System.out.println("Log Urgent Noti Details :"+offerObj.getId());
        if (getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.URGENT_REQUESt_DETAIL_OBJ)!=null){
            urgentRequestDetailObject=(UrgentRequestDetailObject)getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.URGENT_REQUESt_DETAIL_OBJ);
            System.out.println("Log Urgent Noti Details Details:"+urgentRequestDetailObject.getNotes()+" "+urgentRequestDetailObject.getType().getId());
            updateView()
            ;}
        else {
           // getCarOwnerActiveRequests();
            getCarOwnerActiveUrgentRequests();
        }

    }



    public void getCarOwnerActiveUrgentRequests(){


        if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
            //binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(UrgentRequestDetailActivity.this);
            ApiClient.getClient().create(EndPoints.class).getCarOwnerActiveUrgentRequest(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(activeUrgentRequestResponseResponse -> {
                        System.out.println("Message Of Request Details CODE :"+activeUrgentRequestResponseResponse.code());
                        //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (activeUrgentRequestResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){
                            //  System.out.println("Message Of Request Details CODE SERVER ID:"+activeNormalRequestResponseResponse.body();
                            ActiveUrgentRequestResponse activeUrgentRequest=activeUrgentRequestResponseResponse.body();
                             urgentRequestDetailObject=activeUrgentRequest.getData();
                            if (urgentRequestDetailObject!=null) {
                               updateView();
                            }

                        }
                        // moveToNextAct();
                        else if (activeUrgentRequestResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                activeUrgentRequestResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE ){
                            CustomUtils.getInstance().endSession(UrgentRequestDetailActivity.this);
                        }
                        else if (activeUrgentRequestResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(binding.llParent, R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                        //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(binding.llParent,getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }


    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(UrgentRequestDetailActivity.this, ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_TOOLBAR)); }

    public void updateView(){
        binding.rbUrgentRequestRating.setRating(offerObj.getRate()==null? 0: Float.parseFloat(offerObj.getRate()));
             if (offerObj.getRate()!=null)
            binding.tvAddUrgentRequestTotal.setText("("+offerObj.getRate()+") "+getString(R.string.rate_label));

             binding.tvDate.setText(offerObj.getDate());
             binding.tvNormalRequestNum.setText(String.valueOf(offerObj.getNormalRequestsCount()));
             binding.tvUrgentRequestNum.setText(String.valueOf(offerObj.getUrgentRequestsCount()));
             binding.tvAddress.setText(urgentRequestDetailObject.getAddress());
             if (urgentRequestDetailObject.getType().getId()==1) {
                 binding.ivUrgentType.setImageResource(R.drawable.img_colored_tire);
                 binding.tvUrgentType.setText(urgentRequestDetailObject.getType().getName());
             }

        else if (urgentRequestDetailObject.getType().getId()==2) {
                 binding.ivUrgentType.setImageResource(R.drawable.img_colored_gas);
                 binding.tvUrgentType.setText(urgentRequestDetailObject.getType().getName());
             }else if (urgentRequestDetailObject.getType().getId()==3) {
                 binding.ivUrgentType.setImageResource(R.drawable.img_colored_battery);
                 binding.tvUrgentType.setText(urgentRequestDetailObject.getType().getName());
             }else if (urgentRequestDetailObject.getType().getId()==4) {
                 binding.ivUrgentType.setImageResource(R.drawable.img_colored_towed);
                 binding.tvUrgentType.setText(urgentRequestDetailObject.getType().getName()+" - "+urgentRequestDetailObject.getWinchType());
             }

             if (urgentRequestDetailObject.getNotes()==null) {
                 binding.tvDesc.setVisibility(View.GONE);
                 binding.view2.setVisibility(View.GONE);
             }
             else binding.tvDesc.setText(urgentRequestDetailObject.getNotes());

        binding.llCall.setOnClickListener(v -> CustomUtils.getInstance().requirePhonePermission(rxPermissions, UrgentRequestDetailActivity.this));

        if (urgentRequestDetailObject.getVoiceNotes()!=null){
            binding.tvRecord.setVisibility(View.VISIBLE);
         //   binding.progressBar.setVisibility(View.VISIBLE);
            //binding.seekBar.setVisibility(View.VISIBLE);
            barVisualizer.setVisibility(View.VISIBLE);
            binding.ivPlayRecord.setVisibility(View.VISIBLE);
            binding.view1.setVisibility(View.VISIBLE);
        }

        binding.ivPlayRecord.setOnClickListener(v -> {
            if (!isSoundWork) {
                isSoundWork=true;
                barVisualizer.setVisibility(View.VISIBLE);
               // playRecord();
                CustomUtils.getInstance().requireRecordSoundPermission(rxPermissions,UrgentRequestDetailActivity.this);
            }
        });

        binding.ivChat.setOnClickListener(v -> {
            CustomUtils.getInstance().showProgressDialog(UrgentRequestDetailActivity.this);
            addUserToFirebase();
        });
    }

    public void playRecord()  {

        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(urgentRequestDetailObject.getVoiceNotes());
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();

            barVisualizer.setColor(ContextCompat.getColor(this, R.color.colorYellow));

// define custom number of bars you want in the visualizer between (10 - 256).
            barVisualizer.setDensity(70);

// Set your media player to the visualizer.
            barVisualizer.setPlayer(mediaPlayer.getAudioSessionId());

            mediaPlayer.setOnCompletionListener(mp -> isSoundWork=false);
        }catch (IOException ex){
            System.out.println("Ex Record :"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void updateUi(int code) {
        System.out.println("CallBack Code :"+code);
        if (code == ConfigurationFile.Constants.PERMISSION_GRANTED_PHONE_CALL)
            makeCall();
        else if (code == ConfigurationFile.Constants.PERMISSION_DENIED_PHONE_CALL || code == ConfigurationFile.Constants.PERMISSION_DENIED_RECORD_AUDIO)
            Snackbar.make(binding.llParent, getString(R.string.permission_denied), Snackbar.LENGTH_LONG).show();
        else if (code == ConfigurationFile.Constants.PERMISSION_GRANTED_RECORD_AUDIO)
            playRecord();
    }


    public void makeCall() {
        System.out.println("CallBack Code Calling");
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        String workShopPhone = "tel:" + offerObj.getWorkshop().getMobile();
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


    public void addUserToFirebase(){
        reference= FirebaseDatabase.getInstance().getReference("users/carowner-"+userData.getId());
        WorkshopFire workshopFire=new WorkshopFire();
        workshopFire.device_token=offerObj.getWorkshop().getDeviceToken();
        workshopFire.location="FAF"+offerObj.getWorkshop().getId()+"-"+userData.getId();
        workshopFire.sender_name=offerObj.getWorkshop().getName();
        reference.child("conversations/workshop-"+offerObj.getWorkshop().getId()).setValue(workshopFire).addOnCompleteListener(task -> addWorkshopConv());
    }

    public void addWorkshopConv(){
        reference= FirebaseDatabase.getInstance().getReference("users/workshop-"+offerObj.getWorkshop().getId());
        WorkshopFire workshopFire=new WorkshopFire();
        workshopFire.device_token=userData.getToken();
        workshopFire.location="FAF"+offerObj.getWorkshop().getId()+"-"+userData.getId();
        workshopFire.sender_name=userData.getFirstName()+" "+userData.getLastName();
        reference.child("conversations/carowner-"+userData.getId()).setValue(workshopFire).addOnCompleteListener(task -> {
            CustomUtils.getInstance().cancelDialog();
            ConversationsLocation conversationsLocation=new ConversationsLocation();
            conversationsLocation.setSecondUserUrl("workshop-"+offerObj.getWorkshop().getId());
            conversationsLocation.sender_name=offerObj.getWorkshop().getName();
            conversationsLocation.location="FAF"+offerObj.getWorkshop().getId()+"-"+userData.getId();

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
        Intent i=new Intent(UrgentRequestDetailActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
