package findandfix.view.ui.activities;

import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import findandfix.R;
import findandfix.databinding.ActivityAddRequestProblemBinding;
import findandfix.model.global.BaseModel;
import findandfix.model.global.RequestOfferObj;
import findandfix.model.global.UserData;
import findandfix.model.request.AddNormalRequest;
import findandfix.model.response.SpecializationResponse;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.ConstantsCallsUtils;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.view.ui.adapters.SpecializeAdapter;
import findandfix.view.ui.adapters.SubSpecilaizeAdapter;
import findandfix.view.ui.callback.NetworkCallback;
import findandfix.view.ui.callback.RecycleItemClickListener;
import findandfix.view.ui.callback.RecyclerItemUnSelectedListener;
import findandfix.viewmodel.ToolbarViewModel;

public class AddRequestProblemActivity extends BaseActivity {
    private ActivityAddRequestProblemBinding binding;
    private UserData userData;
    private List<BaseModel>specializationItems;
    private List<BaseModel>subSpecializationItems;
    private Dialog dialog=null;
    private Dialog subSpecializeDialog=null;
    private RecyclerView spinnerRecycleView;
    private int selectedSpecializeId=ConfigurationFile.Constants.EMPTY_VALUE;
    private int selectedSubSpecializeId=ConfigurationFile.Constants.EMPTY_VALUE;
    private String selectedSubSpecialization="";
    private ArrayList<Integer>subSpecializeIds;
    private AddNormalRequest addNormalRequest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(AddRequestProblemActivity.this, R.layout.activity_add_request_problem);
        subSpecializeIds=new ArrayList<>();
        setUpActionBar();
        getExtraFromIntents();
        getUserData();
        setActions();
    }

    public void getExtraFromIntents(){
        addNormalRequest=(AddNormalRequest)getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ);
    }

    public void setActions(){
            binding.llProblems.setOnClickListener(v -> {

                if (selectedSpecializeId!=ConfigurationFile.Constants.EMPTY_VALUE)
                    getSubSpecialization();
                else Snackbar.make(binding.getRoot(),getString(R.string.select_specialize_first),Snackbar.LENGTH_LONG).show();
            });

            binding.etSpecialize.setOnClickListener(v -> getSpecialization());

            binding.btnNext.setOnClickListener(v -> {
                if (selectedSpecializeId!=ConfigurationFile.Constants.EMPTY_VALUE && subSpecializeIds.size()!=0){
                    addNormalRequest.setSpecializations(subSpecializeIds);
                    Intent i=new Intent(AddRequestProblemActivity.this,AddRequestLocationActivity.class);
                    i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ,addNormalRequest);
                    startActivity(i);
                }else {
                    Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_fill_data),Snackbar.LENGTH_LONG).show();
                }
            });
    }


    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(AddRequestProblemActivity.this, ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_SECONDARY_TOOLBAR)); }

    public void getUserData(){
        userData= CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void getSpecialization(){
        if(specializationItems!=null){
            setSpecializationList();
        }else {
            if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
              // binding.progressBar.setVisibility(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog(AddRequestProblemActivity.this);
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
                        CustomUtils.getInstance().endSession(AddRequestProblemActivity.this);
                    }
                },CustomUtils.getInstance().getAppLanguage(getApplicationContext()));
            } else {
                // callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
                Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
            }
        }
    }



    public void setSpecializationList(){
        SpecializeAdapter specializeAdapter = new SpecializeAdapter(getApplicationContext(),specializationItems);
        setDialog(getString(R.string.select_specialization),R.layout.dialog_spinner);
        spinnerRecycleView.setAdapter(specializeAdapter);
        specializeAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                BaseModel specializemodel=specializationItems.get(position);
                selectedSpecializeId = specializationItems.get(position).getId();
                binding.etSpecialize.setText(specializationItems.get(position).getName());
                subSpecializationItems=null;
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        }); }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void getSubSpecialization(){
        if(subSpecializationItems!=null){
            setSubSpecializationList();
        }else {
            if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
                   //binding.progressBar.setVisibility(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog(AddRequestProblemActivity.this);
                ConstantsCallsUtils.getInstance().getSubSpecializations(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                      //   binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            SpecializationResponse specializationResponse=(SpecializationResponse) data;
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
                        CustomUtils.getInstance().endSession(AddRequestProblemActivity.this);
                    }
                },selectedSpecializeId,CustomUtils.getInstance().getAppLanguage(AddRequestProblemActivity.this));
            } else {
                // callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
                Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
            }
        }
    }

    public void setSubSpecializationList(){
        SubSpecilaizeAdapter subSpecilaizeAdapter = new SubSpecilaizeAdapter(getApplicationContext(),subSpecializationItems);
        setSubSpecializeDialog(getString(R.string.select_your_problem));
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


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void setDialog(String title,int layout){
        dialog = new Dialog(AddRequestProblemActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(getApplicationContext());
        final View dialogView = factory.inflate(layout, null);
        TextView titleTextView = dialogView.findViewById(R.id.tv_spinner_title);
        titleTextView.setText(title);
        spinnerRecycleView = dialogView.findViewById(R.id.rv_spinner_collections);
        spinnerRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        dialog.setContentView(dialogView);
        dialog.show();
    }


    private void setSubSpecializeDialog(String title){
        subSpecializeDialog = new Dialog(AddRequestProblemActivity.this);
        subSpecializeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        subSpecializeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(getApplicationContext());
        final View dialogView = factory.inflate(R.layout.dialog_sub_specialize_layout, null);
        TextView titleTextView = dialogView.findViewById(R.id.tv_spinner_title);
        titleTextView.setText(title);
        Button submit=(Button)dialogView.findViewById(R.id.btn_ok);
        Button cancel=(Button)dialogView.findViewById(R.id.btn_cancel);
        submit.setOnClickListener(v -> {
            subSpecializeDialog.cancel();
            binding.tvProblem.setText(selectedSubSpecialization);
            subSpecializeDialog.cancel();
        });

        cancel.setOnClickListener(v -> {
            subSpecializeDialog.cancel();
            subSpecializeIds.clear();
            subSpecializeDialog.cancel();
        });
        spinnerRecycleView = dialogView.findViewById(R.id.rv_spinner_collections);
        spinnerRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subSpecializeDialog.setContentView(dialogView);
        selectedSubSpecialization="";
        subSpecializeIds.clear();
        subSpecializeDialog.show();
    }

}
