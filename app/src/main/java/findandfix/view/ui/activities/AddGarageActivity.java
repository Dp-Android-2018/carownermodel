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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import findandfix.R;
import findandfix.databinding.ActivityAddGarageLayoutBinding;
import findandfix.model.global.RequestOfferObj;
import findandfix.model.global.UserData;
import findandfix.model.request.AddGarageRequest;
import findandfix.model.request.AddNormalRequest;
import findandfix.model.response.AddGarageResponse;
import findandfix.model.response.BrandItem;
import findandfix.model.response.BrandsResponse;
import findandfix.model.response.ModelItem;
import findandfix.model.response.ModelsResponse;
import findandfix.model.response.YearItem;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.ConstantsCallsUtils;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.view.ui.adapters.BrandsAdapter;
import findandfix.view.ui.adapters.ModelsAdapter;
import findandfix.view.ui.adapters.YearsAdapter;
import findandfix.view.ui.callback.NetworkCallback;
import findandfix.view.ui.callback.RecycleItemClickListener;
import findandfix.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class AddGarageActivity extends BaseActivity {
    private ActivityAddGarageLayoutBinding binding;
    List<BrandItem> brandItems;
    List<ModelItem>modelItems;
    List<YearItem>yearItems;
    Dialog dialog=null;
    int selectedBrand = ConfigurationFile.Constants.EMPTY_VALUE , selectedModel = ConfigurationFile.Constants.EMPTY_VALUE ,selectedYear=ConfigurationFile.Constants.EMPTY_VALUE;
    RecyclerView spinnerRecycleView;
    private UserData userData;
    private int garageId;
    private AddNormalRequest addNormalRequest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(AddGarageActivity.this, R.layout.activity_add_garage_layout);
        addNormalRequest=new AddNormalRequest();
       // initializeData();
        setUpToolBar();
        setActions();
        getUserData();
    }
   /* public void initializeData(){
        brandItems=new ArrayList<>();
        modelItems=new ArrayList<>();
        yearItems=new ArrayList<>();
    }*/


    public void setUpToolBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(AddGarageActivity.this, ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_SECONDARY_TOOLBAR));
    }

    public void setActions(){
        binding.tvBrand.setOnClickListener(v -> getCarBrands());

        binding.tvModel.setOnClickListener(v -> getModels());

        binding.tvYear.setOnClickListener(v -> getYears());

        binding.btnNext.setOnClickListener(v -> addGarage());
    }

    public void getUserData() {
        userData= CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
    }

    public void getCarBrands(){
        if(brandItems!=null){
            setBrandsList();
        }else {
            if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
               // binding.progressBar.setVisibility(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog(AddGarageActivity.this);
                ConstantsCallsUtils.getInstance().getBrands(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                       // binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            BrandsResponse brandsResponse=(BrandsResponse)data;
                            brandItems = brandsResponse.getData();
                            setBrandsList();
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                      //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession(AddGarageActivity.this);
                    }
                },CustomUtils.getInstance().getAppLanguage(getApplicationContext()));
            } else {
               // callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
                Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
            }
        }
    }

    private void setBrandsList(){
        BrandsAdapter brandsAdapter = new BrandsAdapter(getApplicationContext(),brandItems);
        setDialog(getResources().getString(R.string.label_choose_brand));
        spinnerRecycleView.setAdapter(brandsAdapter);
        brandsAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedBrand = brandItems.get(position).getId();
                selectedModel=ConfigurationFile.Constants.EMPTY_VALUE;
                binding.tvModel.setText(getResources().getString(R.string.model));
                binding.tvBrand.setText(brandItems.get(position).getName());
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void getModels() {
        if (selectedBrand==ConfigurationFile.Constants.EMPTY_VALUE){
            Snackbar.make(binding.getRoot(),getResources().getString(R.string.choose_brands),Snackbar.LENGTH_LONG).show();
        }else {
            if (NetWorkConnection.isConnectingToInternet(getApplicationContext())) {
              //  binding.progressBar.setVisibility(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog(AddGarageActivity.this);
                ConstantsCallsUtils.getInstance().getModels(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                       // binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            ModelsResponse modelsResponseResponse = (ModelsResponse) data;
                            modelItems = modelsResponseResponse.getData();
                            setModelList();
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        CustomUtils.getInstance().cancelDialog();
                        //binding.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession(AddGarageActivity.this);
                    }
                }, selectedBrand,CustomUtils.getInstance().getAppLanguage(getApplicationContext()));
            } else {
                Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
            }
        }



    }

    private void setModelList(){
        ModelsAdapter modelsAdapter = new ModelsAdapter(getApplicationContext(),modelItems);
        setDialog(getResources().getString(R.string.label_choose_model));
        spinnerRecycleView.setAdapter(modelsAdapter);
        modelsAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedModel = modelItems.get(position).getId();
                binding.tvModel.setText(modelItems.get(position).getName());
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void getYears() {

    if(yearItems==null){
        yearItems = new ArrayList<>();
        for(int i=0; i<71; i++){
            YearItem yearItem = new YearItem();
            yearItem.setId(i+1);
            yearItem.setName(""+(1980+i));
            yearItems.add(yearItem);
        }
    }

    setYearsList();
}


    private void setYearsList(){
        YearsAdapter yearsAdapter = new YearsAdapter(getApplicationContext(),yearItems);
        setDialog(getResources().getString(R.string.label_choose_year));
        spinnerRecycleView.setAdapter(yearsAdapter);
        yearsAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedYear = Integer.parseInt(yearItems.get(position).getName());
                binding.tvYear.setText(yearItems.get(position).getName());
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void setDialog(String title){
        dialog = new Dialog(AddGarageActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(getApplicationContext());
        final View dialogView = factory.inflate(R.layout.dialog_spinner, null);
        TextView titleTextView = dialogView.findViewById(R.id.tv_spinner_title);
        titleTextView.setText(title);
        spinnerRecycleView = dialogView.findViewById(R.id.rv_spinner_collections);
        spinnerRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        dialog.setContentView(dialogView);
        dialog.show();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addGarage(){
        if (validate()){
            if (NetWorkConnection.isConnectingToInternet(AddGarageActivity.this)) {
                AddGarageRequest garageRequest=new AddGarageRequest(selectedBrand,selectedModel,selectedYear);
              //  binding.progressBar.setVisibility(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog(AddGarageActivity.this);
                ApiClient.getClient().create(EndPoints.class).addGarage(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),garageRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(garageResponseResponse -> {
                            System.out.println("Offers CODE :"+garageResponseResponse.code());
                          //  binding.progressBar.setVisibility(View.GONE);
                            CustomUtils.getInstance().cancelDialog();
                            if (garageResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_GARAGE) {
                                AddGarageResponse response=garageResponseResponse.body();
                                moveToNextAct(response.getData().getId());

                            }else if (garageResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                                    CustomUtils.getInstance().endSession(AddGarageActivity.this);
                            }
                        }, throwable -> {
                            binding.progressBar.setVisibility(View.GONE);
                           // System.out.println("Ex :"+throwable.getMessage());
                            CustomUtils.getInstance().cancelDialog();
                        });

            }else {
                Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
            }
        }else {
            Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_fill_data),Snackbar.LENGTH_LONG).show();
        }
    }

    public boolean validate(){
        if (selectedBrand!=ConfigurationFile.Constants.EMPTY_VALUE && selectedModel!=ConfigurationFile.Constants.EMPTY_VALUE && selectedYear!=ConfigurationFile.Constants.EMPTY_VALUE)
            return true;
        else return false;
    }

    public void moveToNextAct(int garageId){
        System.out.println("Garage Id :"+garageId);
        addNormalRequest.setGarageId(garageId);
        Intent intent=new Intent(getApplicationContext(),AddRequestProblemActivity.class);
        intent.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ,addNormalRequest);
        startActivity(intent);
    }
}


