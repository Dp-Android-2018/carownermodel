package com.findandfix.carowner.ui.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.abdeveloper.library.MultiSelectDialog;
import com.abdeveloper.library.MultiSelectModel;

import java.util.ArrayList;
import java.util.List;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityAddUrgentRequestWinchTypeBinding;
import com.findandfix.carowner.model.global.UrgentRequest;
import com.findandfix.carowner.model.global.WenshTypes;
import com.findandfix.carowner.model.response.WinshResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ActivityAddUrgentRequestWinchType extends BaseActivity {

    ActivityAddUrgentRequestWinchTypeBinding binding;
    private Dialog dialog=null;
    private String winchType=null;
    private UrgentRequest urgentRequest=null;
    private List<WenshTypes> wt;
    public ObservableField<String> fields;
    public ObservableField<String>Wenshfields;
   ArrayList<MultiSelectModel> WinchtypesSelector= new ArrayList<>();
    ArrayList<Integer> selectedIds;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_add_urgent_request_winch_type);
        setUpActionBar();
        urgentRequest=getExtraFromIntent();
        wt=new ArrayList<>();
        Wenshfields=new ObservableField<>("");
        selectedIds=new ArrayList<>();
        fields=new ObservableField<>();
        binding.tvWinchType.setOnClickListener(v -> {
           // setDialog(getResources().getString(R.string.winch_type));
            getWenshTypes();
        });

        binding.btnNext.setOnClickListener(v -> {
            if (selectedIds.size()==0){
                Snackbar.make(findViewById(R.id.rl_parent),getString(R.string.select_winch_type),Snackbar.LENGTH_LONG).show();
            }else {
                urgentRequest.setWinchType(selectedIds);
                moveTOnextAct();
            }
        });
    }

    public void moveTOnextAct() {
        Intent i=new Intent(getApplicationContext(),ActivityUrgentRequestNotesActivity.class) ;
        i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_URGENT_REQUEST_OBJ,urgentRequest);
        startActivity(i);
    }
    public UrgentRequest getExtraFromIntent(){
        return (UrgentRequest) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_URGENT_REQUEST_OBJ);
    }

    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(ActivityAddUrgentRequestWinchType.this, ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_SECONDARY_TOOLBAR)); }



    private void setDialog(String title){
        dialog = new Dialog(ActivityAddUrgentRequestWinchType.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(getApplicationContext());
        final View dialogView = factory.inflate(R.layout.dialog_winch_layout, null);
        TextView titleTextView = dialogView.findViewById(R.id.tv_spinner_title);
        TextView tvWinch = dialogView.findViewById(R.id.tv_winch);
        TextView tvNormalWinch = dialogView.findViewById(R.id.tv_normal_winch);
        TextView tvHydrolicWinch = dialogView.findViewById(R.id.tv_hydrolic_winch);
        tvWinch.setOnClickListener(v -> {
            winchType=getString(R.string.winch);
            binding.tvWinchType.setText(winchType);
            dialog.dismiss();
        });

        tvNormalWinch.setOnClickListener(v -> {
            winchType=getString(R.string.normal_winch);
            binding.tvWinchType.setText(winchType);
            dialog.dismiss();
        });

        tvHydrolicWinch.setOnClickListener(v -> {
            winchType=getString(R.string.hydrolic_winch);
            binding.tvWinchType.setText(winchType);
            dialog.dismiss();
        });
        titleTextView.setText(title);
        dialog.setContentView(dialogView);
        dialog.show();
    }


    /////////////////////////////////Get Winch Types ////////////////////////////////////////////////////////////////////////////
    public void getWenshTypes(){
        if (wt.size()==0) {
            if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
                CustomUtils.getInstance().showProgressDialog(ActivityAddUrgentRequestWinchType.this);
                ApiClient.getClient().create(EndPoints.class).getWinchTypes(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(getApplicationContext()), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(winshResponseResponse -> {
                            CustomUtils.getInstance().cancelDialog();
                            if (winshResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                                //  showWenshDialog(winshResponseResponse.body().getData());
                                initalizeList(winshResponseResponse.body().getData());
                                wt.addAll(winshResponseResponse.body().getData());
                            }else if (winshResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                                CustomUtils.getInstance().endSession(ActivityAddUrgentRequestWinchType.this);
                            }

                        }, throwable -> {
                            System.out.println("throwable :" + throwable.getMessage());
                            CustomUtils.getInstance().cancelDialog();
                        });
            } else {
               // callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
                Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
            }
        }else initalizeList(wt);
    }



    public void initalizeList(List<WenshTypes>wenshTypes){
        if (WinchtypesSelector.size()==0) {
            for (int i = 0; i < wenshTypes.size(); i++) {
                WinchtypesSelector.add(new MultiSelectModel(wenshTypes.get(i).getId(), wenshTypes.get(i).getName()));
            }
        }
        showWenshDialog();
    }

    public void showWenshDialog(){
        MultiSelectDialog multiSelectDialog = new MultiSelectDialog()
                .title(getString(R.string.wensh_types)) //setting title for dialog
                .titleSize(25)

                .positiveText(getString(R.string.done))
                .negativeText(getResources().getString(R.string.cancel))
                .setMinSelectionLimit(1) //you can set minimum checkbox selection limit (Optional)
                .setMaxSelectionLimit(WinchtypesSelector.size()) //you can set maximum checkbox selection limit (Optional)
                .multiSelectList(WinchtypesSelector) // the multi select model list with ids and name
                .onSubmit(new MultiSelectDialog.SubmitCallbackListener() {
                    @Override
                    public void onSelected(ArrayList<Integer> selectedIdss, ArrayList<String> selectedNames, String dataString) {
                        //will return list of selected IDS
                       String types="";
                        selectedIds=selectedIdss;
                        for (int i = 0; i < selectedIdss.size(); i++) { types=types+" "+selectedNames.get(i);}
                        binding.tvWinchType.setText(types);

                    }

                    @Override
                    public void onCancel() {
                        // Log.d(TAG,"Dialog cancelled");
                    }


                });

        if (!multiSelectDialog.isVisible())
            multiSelectDialog.show(getSupportFragmentManager(), "multiSelectDialog");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
