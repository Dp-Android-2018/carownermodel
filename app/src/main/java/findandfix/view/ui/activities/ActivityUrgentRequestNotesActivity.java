package findandfix.view.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import cafe.adriel.androidaudiorecorder.AndroidAudioRecorder;
import cafe.adriel.androidaudiorecorder.model.AudioChannel;
import cafe.adriel.androidaudiorecorder.model.AudioSampleRate;
import cafe.adriel.androidaudiorecorder.model.AudioSource;
import findandfix.R;
import findandfix.databinding.ActivityAddUrgentNotesLayoutBinding;
import findandfix.model.global.UrgentRequest;
import findandfix.model.global.UserData;
import findandfix.model.request.AddUrgentRequest;
import findandfix.model.response.AddUrgentRequestResponse;
import findandfix.model.response.DefaultResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ActivityUrgentRequestNotesActivity extends BaseActivity implements BaseInterface{
    ActivityAddUrgentNotesLayoutBinding binding;
    private UrgentRequest urgentRequest=null;
    private RxPermissions rxPermissions;
    private StorageReference storageReference;
    private static final int REQUEST_RECORD_AUDIO = 0;
    Random random=new Random();
    private int num;
    private static  String AUDIO_FILE_PATH =
            Environment.getExternalStorageDirectory().getPath() + "/recorded_audio.wav";
    String soundUrl=null;
    private int soundChecker=ConfigurationFile.Constants.EMPTY_VALUE;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_urgent_notes_layout);
        setUpActionBar();
        num=random.nextInt(1000000);
        String FileName="/recorded_audio_"+num+".wav";
        AUDIO_FILE_PATH =
                Environment.getExternalStorageDirectory().getPath() + FileName;
        urgentRequest=getExtraFromIntent();
        storageReference = FirebaseStorage.getInstance().getReference().child("app_voices");
        rxPermissions=new RxPermissions(this);
        urgentRequest=getExtraFromIntent();
        binding.tvType.setOnClickListener(v -> notesLayoutAction());

        binding.tvVoiceNotes.setOnClickListener(v -> {
            voiceNotesAction();
            binding.tvVoiceNotes.setEnabled(false);
        });

        binding.layoutNotes.btnNext.setOnClickListener(v -> {
            voiceNotesAction();
            setNotes();
        });

        binding.layoutVoiceNotes.btnSend.setOnClickListener(v -> {
           // notesLayoutAction();
            setVoiceNotes();
        });

        binding.layoutVoiceNotes.llAddUrgentRequestMicrophoneHolder.setOnClickListener(v -> CustomUtils.getInstance().requireRecordSoundPermission(rxPermissions,ActivityUrgentRequestNotesActivity.this));
    }

    public UrgentRequest getExtraFromIntent(){
        return (UrgentRequest) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_URGENT_REQUEST_OBJ);
    }

    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(ActivityUrgentRequestNotesActivity.this, ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_SECONDARY_TOOLBAR)); }


    public void notesLayoutAction(){
        binding.tvType.setBackgroundResource(R.drawable.tv_rounded_red_corner);
        binding.tvVoiceNotes.setBackgroundResource(0);
        binding.layoutNotes.relativeLayout.setVisibility(View.VISIBLE);
        binding.layoutVoiceNotes.relativeLayout.setVisibility(View.GONE);
    }

    public void voiceNotesAction(){
        binding.tvType.setBackgroundResource(0);
        binding.tvVoiceNotes.setBackgroundResource(R.drawable.tv_rounded_red_corner);
        binding.layoutNotes.relativeLayout.setVisibility(View.GONE);
        binding.layoutVoiceNotes.relativeLayout.setVisibility(View.VISIBLE);
    }

    public void setNotes(){
          if(binding.layoutNotes.etNotes.getText().toString()!=null && !binding.layoutNotes.etNotes.getText().toString().equals(""))
              urgentRequest.setNotes(binding.layoutNotes.etNotes.getText().toString().trim());
    }

    public void setVoiceNotes(){
          if (soundChecker==1){
              uploadAudioTOFireBase();
          }else if (soundChecker==ConfigurationFile.Constants.EMPTY_VALUE)
              addUrgentRequest();
    }


    public void addUrgentRequest(){

        if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
           // binding.layoutVoiceNotes.progressBar.setVisibility(View.VISIBLE);
            HashMap<String,Object>fields=new HashMap<>();
            fields.put("lat",urgentRequest.getLat());
            fields.put("lng",urgentRequest.getLng());
            if (urgentRequest.getVoiceNotes()!=null)
                fields.put("voice_notes",urgentRequest.getVoiceNotes());
            if (urgentRequest.getWinchType()!=null)
                fields.put("winch_types",urgentRequest.getWinchType());
            if (urgentRequest.getTypeId()!=4)
                fields.put("type_id",urgentRequest.getTypeId());
            if (urgentRequest.getNotes()!=null)
                fields.put("notes",urgentRequest.getNotes());

            System.out.println("Map Data :"+new Gson().toJson(fields));
            CustomUtils.getInstance().showProgressDialog(ActivityUrgentRequestNotesActivity.this);
            UserData userData=CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
            System.out.println("Uploaded Media Request Obj :"+new Gson().toJson(urgentRequest));
            AddUrgentRequest addUrgentRequest=new AddUrgentRequest();
            addUrgentRequest.setFields(fields);
            ApiClient.getClient().create(EndPoints.class).addUrgentRequest(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(getApplicationContext()), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, "Bearer " + userData.getToken(),fields)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(defaultResponseResponse -> {
                        System.out.println("Urgent Request CODE :" + defaultResponseResponse.code());
                        System.out.println("Urgent Request CODE Response :"+new Gson().toJson(defaultResponseResponse));
                     //   binding.layoutVoiceNotes.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (defaultResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_GARAGE) {
                         //   Snackbar.make(findViewById(R.id.drawer), R.string.rate_added_successfully, Snackbar.LENGTH_LONG).show();
                                     moveToNextAct(defaultResponseResponse.body().getId());
                            }else if (defaultResponseResponse.code() == ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                defaultResponseResponse.code() == ConfigurationFile.Constants.UNUTHENTICATED_CODE)
                            CustomUtils.getInstance().endSession(ActivityUrgentRequestNotesActivity.this);
                        else if (defaultResponseResponse.code() == ConfigurationFile.Constants.UNEXPECTED_ERROR)
                            Snackbar.make(findViewById(R.id.ll_container), getResources().getString(R.string.cant_complete_your_request), Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                    //    binding.layoutVoiceNotes.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Ex :" + throwable.getMessage());
                    });

        } else {
            Snackbar.make(findViewById(R.id.ll_container), getResources().getString(R.string.msg_internet_connection), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void updateUi(int code) {
        if (code==ConfigurationFile.Constants.PERMISSION_GRANTED_RECORD_AUDIO){
                recordAudio();
        }else {
            Snackbar.make(findViewById(R.id.ll_container),getResources().getString(R.string.permission_denied),Snackbar.LENGTH_LONG).show();
        }

    }


    public void moveToNextAct(int urgentRequestId){
        Intent i=new Intent(this,WaitingOffersUrgentActivity.class);
        i.putExtra(ConfigurationFile.IntentsConstants.URGENT_REQUEST_ID,urgentRequestId);
        startActivity(i);
        finishAffinity();
    }


    public void recordAudio() {
        AndroidAudioRecorder.with(this)
                // Required
                .setFilePath(AUDIO_FILE_PATH)
                .setColor(ContextCompat.getColor(this, R.color.recorder_bg))
                .setRequestCode(REQUEST_RECORD_AUDIO)

                // Optional
                .setSource(AudioSource.MIC)
                .setChannel(AudioChannel.STEREO)
                .setSampleRate(AudioSampleRate.HZ_48000)
                .setAutoStart(false)
                .setKeepDisplayOn(true)

                // Start recording
                .record();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_RECORD_AUDIO) {
            if (resultCode == RESULT_OK) {
                soundChecker=1;
                System.out.println("Audio Path :"+AUDIO_FILE_PATH);
                Snackbar.make(findViewById(R.id.ll_container), R.string.audio_recorded_successfully,Snackbar.LENGTH_LONG).show();
               // uploadAudioTOFireBase();
            } else if (resultCode == RESULT_CANCELED) {
                soundChecker=ConfigurationFile.Constants.EMPTY_VALUE;
                Snackbar.make(findViewById(R.id.ll_container), R.string.audio_not_recorded,Snackbar.LENGTH_LONG).show();
            }
        }
    }



    ////////////////////////////Uploading Audio To Firebase ///////////////////////////////////////////////////////
    public void uploadAudioTOFireBase(){
        CustomUtils.getInstance().showProgressDialog(ActivityUrgentRequestNotesActivity.this);
        StorageMetadata metadata = new StorageMetadata.Builder()
                .setContentType("audio/mpeg")
                .build();
        UploadTask photoRef=storageReference.child(Uri.fromFile(new File(AUDIO_FILE_PATH)).getLastPathSegment()).putFile(Uri.fromFile(new File(AUDIO_FILE_PATH)),metadata);
        photoRef.addOnSuccessListener(taskSnapshot -> {
            CustomUtils.getInstance().cancelDialog();
            Uri videourl=taskSnapshot.getDownloadUrl();
             soundUrl=videourl.toString();

             if (soundUrl!=null)
                 urgentRequest.setVoiceNotes(soundUrl);
             addUrgentRequest();
            System.out.println("Uploaded Media Sound :"+soundUrl.toString());
        });


        photoRef.addOnProgressListener(taskSnapshot -> {
            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
            System.out.println("Upload is " + progress + "% done");
          /*  if ((int)progress<100)
                progressdialog.setProgress((int) progress);
            else
                progressdialog.setProgress(98);
           /*  if ((int)progress>=100){
                 progressdialog.dismiss();
                 moveTonextAct();
             }*/

        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
