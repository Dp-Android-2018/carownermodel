package findandfix.viewmodel;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.abdeveloper.library.MultiSelectDialog;
import com.abdeveloper.library.MultiSelectModel;

import java.util.ArrayList;
import java.util.List;

import findandfix.R;
import findandfix.model.global.BaseModel;
import findandfix.model.global.RequestOfferObj;
import findandfix.model.global.WenshTypes;
import findandfix.model.response.SpecializationResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.ConstantsCallsUtils;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.view.ui.activities.ActivityAddUrgentRequestWinchType;
import findandfix.view.ui.activities.AddRequestProblemActivity;
import findandfix.view.ui.adapters.SpecializeAdapter;
import findandfix.view.ui.adapters.SubSpecilaizeAdapter;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.view.ui.callback.NetworkCallback;
import findandfix.view.ui.callback.RecycleItemClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DELL on 16/08/2018.
 */

public class FilterViewModel extends BaseObservable {
    private BaseInterface callback;
    private Activity activity;
    private Dialog serviceTypeDialog=null;
    private Dialog dialog=null;
    private Dialog subSpecializeDialog=null;
    public ObservableField<String>fields;
    public ObservableInt selectedValue;
    private List<BaseModel> specializationItems;
    private List<BaseModel>subSpecializationItems;
    private ArrayList<Integer> subSpecializeIds;
    private RecyclerView spinnerRecycleView;
    private int selectedSpecializeId=ConfigurationFile.Constants.EMPTY_VALUE;
    private int selectedSubSpecializeId=ConfigurationFile.Constants.EMPTY_VALUE;
    private String selectedSubSpecialization="";
    public ObservableField<String>specializationText;
    public ObservableField<String>subSpecializationfields;
    public ObservableField<String>Wenshfields;
    private List<WenshTypes> wt;
    ArrayList<MultiSelectModel> WinchtypesSelector= new ArrayList<>();
    ArrayList<Integer> selectedIds;
    public FilterViewModel(Activity activity, BaseInterface callback) {
        this.callback=callback;
        this.activity=activity;
        wt=new ArrayList<>();
        fields=new ObservableField<>();
        selectedIds=new ArrayList<>();
        subSpecializationfields=new ObservableField<>();
        subSpecializeIds=new ArrayList<>();
        Wenshfields=new ObservableField<>();
        selectedValue=new ObservableInt(-1);
        specializationText=new ObservableField<>(activity.getResources().getString(R.string.select_specialization));
    }
////////////////////////////cHOOSE Service Type //////////////////////////////////////////////
    public void showserviceTypeDialog(View view) {
        serviceTypeDialog = new Dialog(activity);
        serviceTypeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        serviceTypeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(activity);
        final View serviceTypeDialogView = factory.inflate(R.layout.dialog_service_type_layout, null);
        TextView titleTextView = serviceTypeDialogView.findViewById(R.id.tv_spinner_title);
        TextView tvWinch = serviceTypeDialogView.findViewById(R.id.tv_winch);
        TextView tvNormalWinch = serviceTypeDialogView.findViewById(R.id.tv_service_provider);
        tvWinch.setOnClickListener(v -> {
            selectedValue.set(2);
            fields.set(activity.getResources().getString(R.string.wensh));
            serviceTypeDialog.dismiss();
        });

        tvNormalWinch.setOnClickListener(v -> {
            selectedValue.set(3);
            fields.set(activity.getResources().getString(R.string.service_provider));
            serviceTypeDialog.dismiss();
        });

        titleTextView.setText(activity.getString(R.string.service_type));
        serviceTypeDialog.setContentView(serviceTypeDialogView);
        serviceTypeDialog.show();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void getSpecialization(View view){
        if(specializationItems!=null){
            setSpecializationList();
        }else {
            if (NetWorkConnection.isConnectingToInternet(activity)) {
                // binding.progressBar.setVisibility(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog(activity);
                ConstantsCallsUtils.getInstance().getSpecialization(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                        //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            SpecializationResponse specializationResponse=(SpecializationResponse) data;
                            specializationItems = specializationResponse.getData();

                            setSpecializationList();
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        CustomUtils.getInstance().cancelDialog();
                        //binding.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession(activity);
                    }
                },CustomUtils.getInstance().getAppLanguage(activity));
            } else {
                 callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
               // Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
            }
        }
    }



    public void setSpecializationList(){
        SpecializeAdapter specializeAdapter = new SpecializeAdapter(activity,specializationItems);
        setDialog(activity.getString(R.string.select_specialization),R.layout.dialog_spinner);
        spinnerRecycleView.setAdapter(specializeAdapter);
        specializeAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                BaseModel specializemodel=specializationItems.get(position);
                selectedSpecializeId = specializationItems.get(position).getId();
                specializationText.set(specializationItems.get(position).getName());
                subSpecializationItems=null;
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        }); }



    private void setDialog(String title,int layout){
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(activity);
        final View dialogView = factory.inflate(layout, null);
        TextView titleTextView = dialogView.findViewById(R.id.tv_spinner_title);
        titleTextView.setText(title);
        spinnerRecycleView = dialogView.findViewById(R.id.rv_spinner_collections);
        spinnerRecycleView.setLayoutManager(new LinearLayoutManager(activity));
        dialog.setContentView(dialogView);
        dialog.show();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
public void getSubSpecialization(View view){
        if (selectedSpecializeId!=ConfigurationFile.Constants.EMPTY_VALUE) {
            if (subSpecializationItems != null) {
                setSubSpecializationList();
            } else {
                if (NetWorkConnection.isConnectingToInternet(activity)) {
                    //binding.progressBar.setVisibility(View.VISIBLE);
                    CustomUtils.getInstance().showProgressDialog(activity);
                    ConstantsCallsUtils.getInstance().getSubSpecializations(new NetworkCallback() {
                        @Override
                        public <E> void onSuccess(Object data, int code) {
                            //   binding.progressBar.setVisibility(View.GONE);
                            CustomUtils.getInstance().cancelDialog();
                            if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                                SpecializationResponse specializationResponse = (SpecializationResponse) data;
                                subSpecializationItems = specializationResponse.getData();
                                setSubSpecializationList();
                            }
                        }

                        @Override
                        public void onFailure(Throwable throwable) {
                            //  binding.progressBar.setVisibility(View.GONE);
                            CustomUtils.getInstance().cancelDialog();
                        }

                        @Override
                        public <E> void onUnUthenticated(int code) {
                            CustomUtils.getInstance().endSession(activity);
                        }
                    }, selectedSpecializeId, CustomUtils.getInstance().getAppLanguage(activity));
                } else {
                     callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
                    // Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
                }

            }
        }else callback.updateUi(ConfigurationFile.Constants.EMPTY_SPECIALIZATION);
}

    public void setSubSpecializationList(){
        SubSpecilaizeAdapter subSpecilaizeAdapter = new SubSpecilaizeAdapter(activity,subSpecializationItems);
        setSubSpecializeDialog(activity.getString(R.string.select_your_problem));
        spinnerRecycleView.setAdapter(subSpecilaizeAdapter);
        subSpecilaizeAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                BaseModel specializemodel=subSpecializationItems.get(position);
                selectedSubSpecializeId = subSpecializationItems.get(position).getId();
                subSpecializeIds.add(selectedSubSpecializeId);
                selectedSubSpecialization=selectedSubSpecialization+" "+subSpecializationItems.get(position).getName();}

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });

        subSpecilaizeAdapter.setUnSelectedListener(position -> {
            subSpecializeIds.remove(subSpecializeIds.indexOf(subSpecializationItems.get(position).getId()));
            selectedSubSpecialization.replace(subSpecializationItems.get(position).getName(),"");
        });
    }



    private void setSubSpecializeDialog(String title){
        subSpecializeDialog = new Dialog(activity);
        subSpecializeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        subSpecializeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(activity);
        final View dialogView = factory.inflate(R.layout.dialog_sub_specialize_layout, null);
        TextView titleTextView = dialogView.findViewById(R.id.tv_spinner_title);
        titleTextView.setText(title);
        Button submit=(Button)dialogView.findViewById(R.id.btn_ok);
        Button cancel=(Button)dialogView.findViewById(R.id.btn_cancel);
        submit.setOnClickListener(v -> {
            subSpecializeDialog.cancel();
            subSpecializationfields.set(selectedSubSpecialization);
            subSpecializeDialog.cancel();
        });

        cancel.setOnClickListener(v -> {
            subSpecializeDialog.cancel();
            subSpecializeIds.clear();
            subSpecializeDialog.cancel();
        });
        spinnerRecycleView = dialogView.findViewById(R.id.rv_spinner_collections);
        spinnerRecycleView.setLayoutManager(new LinearLayoutManager(activity));
        subSpecializeDialog.setContentView(dialogView);
        selectedSubSpecialization="";
        subSpecializeIds.clear();
        subSpecializeDialog.show();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////Get Winch Types ////////////////////////////////////////////////////////////////////////////
    public void getWenshTypes(View view){
        if (wt.size()==0) {
            if (NetWorkConnection.isConnectingToInternet(activity)) {
                CustomUtils.getInstance().showProgressDialog(activity);
                ApiClient.getClient().create(EndPoints.class).getWinchTypes(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(activity), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(winshResponseResponse -> {
                            CustomUtils.getInstance().cancelDialog();
                            if (winshResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                                //  showWenshDialog(winshResponseResponse.body().getData());
                                initalizeList(winshResponseResponse.body().getData());
                                wt.addAll(winshResponseResponse.body().getData());
                            }else if (winshResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                                CustomUtils.getInstance().endSession(activity);
                            }

                        }, throwable -> {
                            System.out.println("throwable :" + throwable.getMessage());
                            CustomUtils.getInstance().cancelDialog();
                        });
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            //    Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
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
                .title(activity.getString(R.string.wensh_types)) //setting title for dialog
                .titleSize(25)

                .positiveText(activity.getString(R.string.done))
                .negativeText(activity.getResources().getString(R.string.cancel))
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
                        Wenshfields.set(types);

                    }

                    @Override
                    public void onCancel() {
                        // Log.d(TAG,"Dialog cancelled");
                    }


                });

        if (!multiSelectDialog.isVisible())
            multiSelectDialog.show(((AppCompatActivity)activity).getSupportFragmentManager(), "multiSelectDialog");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void validate(View view){
        if(selectedIds.size()!=0){
            Intent intent=new Intent();
            intent.putExtra(ConfigurationFile.IntentsConstants.WENSH_TYPES,selectedIds);
            activity.setResult(ConfigurationFile.Constants.REQUEST_CODE,intent);
            activity.finish();//finishing activity
        }else if (subSpecializeIds.size()!=0){
            Intent intent=new Intent();
            intent.putExtra(ConfigurationFile.IntentsConstants.SPECIALIZATION_TYPES,subSpecializeIds);
            activity.setResult(ConfigurationFile.Constants.REQUEST_CODE,intent);
            activity.finish();//finishing activity
        }else {
            callback.updateUi(ConfigurationFile.Constants.EMPTY_VALUE);
        }
    }
}
