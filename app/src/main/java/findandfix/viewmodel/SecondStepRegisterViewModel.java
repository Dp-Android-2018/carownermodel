package findandfix.viewmodel;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import findandfix.R;
import findandfix.model.global.BaseModel;
import findandfix.model.global.RequestOfferObj;
import findandfix.model.request.MobileRequest;
import findandfix.model.request.RegisterRequest;
import findandfix.model.response.BrandItem;
import findandfix.model.response.BrandsResponse;
import findandfix.model.response.CitiesResponse;
import findandfix.model.response.CountriesResponse;
import findandfix.model.response.ModelItem;
import findandfix.model.response.ModelsResponse;
import findandfix.model.response.YearItem;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.ConstantsCallsUtils;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.view.ui.activities.UploadImageActivity;
import findandfix.view.ui.adapters.BrandsAdapter;
import findandfix.view.ui.adapters.CitiesAdapter;
import findandfix.view.ui.adapters.CountriesAdapter;
import findandfix.view.ui.adapters.ModelsAdapter;
import findandfix.view.ui.adapters.YearsAdapter;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.view.ui.callback.NetworkCallback;
import findandfix.view.ui.callback.RecycleItemClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class SecondStepRegisterViewModel extends Observable {

    public ObservableField<String> firstName;
    public ObservableField<String> lastName;
    public ObservableField<String> phoneNumber;
    public ObservableField<String> country;
    public ObservableField<String> city;
    public ObservableField<String> brand;
    public ObservableField<String> model;
    public ObservableField<String> year;
    public ObservableInt progressDialog;
    private Context context;
    private BaseInterface callback;
    private SecondStepRegisterValidation validation;
    private CompositeDisposable compositeDisposable;
    List<findandfix.model.global.CountryItem>countryItems ;
    List<BaseModel>cityItems ;
    List<BrandItem>brandItems;
    List<ModelItem>modelItems;
    List<YearItem>yearItems;

     Dialog dialog=null;
    int selectedCountry=ConfigurationFile.Constants.EMPTY_VALUE , selectedCity = ConfigurationFile.Constants.EMPTY_VALUE ,selectedBrand = ConfigurationFile.Constants.EMPTY_VALUE , selectedModel = ConfigurationFile.Constants.EMPTY_VALUE ,selectedYear=ConfigurationFile.Constants.EMPTY_VALUE;
    RecyclerView spinnerRecycleView;

    public SecondStepRegisterViewModel(Context context, BaseInterface callback,SecondStepRegisterValidation validation) {
        this.validation=validation;
        this.context = context;
        this.callback = callback;
        initializeVariables();
    }

    public void initializeVariables() {
        firstName = new ObservableField<>();
        lastName = new ObservableField<>();
        phoneNumber = new ObservableField<>();
        country = new ObservableField<>();
        city = new ObservableField<>();
        brand = new ObservableField<>();
        model = new ObservableField<>();
        year = new ObservableField<>();
        progressDialog = new ObservableInt(View.GONE);
        compositeDisposable = new CompositeDisposable();
    }


    public void next(final View view) {

        if (validation.validate(firstName,lastName,phoneNumber,selectedCountry,selectedCity,selectedBrand,selectedModel,selectedYear)) {

            checkeMobile(new NetworkCallback() {
                @Override
                public <E> void onSuccess(Object data, int code) {


                    if (((Integer)data)==0) {

                        RegisterRequest registerRequest = (RegisterRequest) ((Activity) context).getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_REGISTER_REQUEST_OBJ);

                        registerRequest.setFirstName(firstName.get());
                        registerRequest.setLastName(lastName.get());
                        registerRequest.setMobile(phoneNumber.get());
                        registerRequest.setCountryId(selectedCountry);
                        registerRequest.setCityId(selectedCity);
                        registerRequest.setBrandId(selectedBrand);
                        registerRequest.setModelId(selectedModel);
                        registerRequest.setYear(selectedYear);
                        Intent intent = new Intent(context, UploadImageActivity.class);
                        intent.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_REGISTER_REQUEST_OBJ, registerRequest);
                        context.startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Throwable throwable) {

                }

                @Override
                public <E> void onUnUthenticated(int code) {
                    CustomUtils.getInstance().endSession((Activity)context);
                }
            });

        }
    }


    public void showCountries(final View view) {
        if(countryItems!=null) {
            setCountriesList();
        }
        else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
               // progressDialog.set(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog((Activity)context);
                ConstantsCallsUtils.getInstance().getCountries(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                      //  progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            CountriesResponse countriesResponseResponse=(CountriesResponse)data;
                            countryItems = countriesResponseResponse.getData();
                            setCountriesList();
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        //progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession((Activity)context);
                    }
                }, CustomUtils.getInstance().getAppLanguage(context));
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }
    }

    private void setCountriesList(){
        CountriesAdapter countriesAdapter = new CountriesAdapter(context,countryItems);
        setDialog(context.getResources().getString(R.string.label_choose_country));
        spinnerRecycleView.setAdapter(countriesAdapter);
        countriesAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedCountry = countryItems.get(position).getId();
                country.set(countryItems.get(position).getName());
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }



    public void showCities(final View view) {
        if(selectedCountry==ConfigurationFile.Constants.EMPTY_VALUE){
            callback.updateUi(ConfigurationFile.Constants.CHOOSE_COUNTRY);
        }
        else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
              //  progressDialog.set(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog((Activity)context);
                ConstantsCallsUtils.getInstance().getCities(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                        CustomUtils.getInstance().cancelDialog();
                      //  progressDialog.set(View.GONE);
                        CitiesResponse citiesResponse=(CitiesResponse)data;
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            cityItems = citiesResponse.getData();
                            setCitiesList();
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable)
                    {
                        CustomUtils.getInstance().cancelDialog();
                       // progressDialog.set(View.GONE);
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession((Activity)context);
                    }
                },selectedCountry,CustomUtils.getInstance().getAppLanguage(context));
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }


    }

    private void setCitiesList(){
        CitiesAdapter citiesAdapter = new CitiesAdapter(context,cityItems);
        setDialog(context.getResources().getString(R.string.label_choose_city));
        spinnerRecycleView.setAdapter(citiesAdapter);
        citiesAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedCity = cityItems.get(position).getId();
                city.set(cityItems.get(position).getName());
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }


    public void showCarBrands(final View view) {
        if(brandItems!=null){
            setBrandsList();
        }else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
                //progressDialog.set(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog((Activity)context);
                ConstantsCallsUtils.getInstance().getBrands(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                       // progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            BrandsResponse brandsResponse=(BrandsResponse)data;
                            brandItems = brandsResponse.getData();
                            setBrandsList();
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        CustomUtils.getInstance().cancelDialog();
                        //progressDialog.set(View.GONE);
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession((Activity)context);
                    }
                },CustomUtils.getInstance().getAppLanguage(context));
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }
    }

    private void setBrandsList(){
        BrandsAdapter brandsAdapter = new BrandsAdapter(context,brandItems);
        setDialog(context.getResources().getString(R.string.label_choose_brand));
        spinnerRecycleView.setAdapter(brandsAdapter);
        brandsAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedBrand = brandItems.get(position).getId();
                brand.set(brandItems.get(position).getName());
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }




    public void showModels(final View view) {
        if (selectedBrand==ConfigurationFile.Constants.EMPTY_VALUE){
            callback.updateUi(ConfigurationFile.Constants.CHOOSE_BRANDS);
        }else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
              //  progressDialog.set(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog((Activity)context);
                ConstantsCallsUtils.getInstance().getModels(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                       // progressDialog.set(View.GONE);
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
                        //progressDialog.set(View.GONE);
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession((Activity)context);
                    }
                }, selectedBrand,CustomUtils.getInstance().getAppLanguage(context));
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }



    }

    private void setModelList(){
        ModelsAdapter modelsAdapter = new ModelsAdapter(context,modelItems);
        setDialog(context.getResources().getString(R.string.label_choose_model));
        spinnerRecycleView.setAdapter(modelsAdapter);
        modelsAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedModel = modelItems.get(position).getId();
                model.set(modelItems.get(position).getName());
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }



    public void showYears(final View view) {

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
        YearsAdapter yearsAdapter = new YearsAdapter(context,yearItems);
        setDialog(context.getResources().getString(R.string.label_choose_year));
        spinnerRecycleView.setAdapter(yearsAdapter);
        yearsAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedYear = yearItems.get(position).getId();
                year.set(yearItems.get(position).getName());
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }

    public void reset() {
        context = null;
    }


    private void setDialog(String title){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater factory = LayoutInflater.from(context);
        final View dialogView = factory.inflate(R.layout.dialog_spinner, null);
        TextView titleTextView = dialogView.findViewById(R.id.tv_spinner_title);
        titleTextView.setText(title);
        spinnerRecycleView = dialogView.findViewById(R.id.rv_spinner_collections);
        spinnerRecycleView.setLayoutManager(new LinearLayoutManager(context));
        dialog.setContentView(dialogView);
        dialog.show();
    }

    public void checkeMobile(NetworkCallback calling) {
        if(NetWorkConnection.isConnectingToInternet(context)) {
            CustomUtils.getInstance().showProgressDialog((Activity)context);
            MobileRequest mobileRequest = new MobileRequest(phoneNumber.get());
            Disposable disposable = ApiClient.getClient().create(EndPoints.class).checkMobile(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(context), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, mobileRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(integerResponse -> {
                        if (integerResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                            System.out.println("Code code :" + integerResponse.body().toString());
                            if (integerResponse.body() == 0) {
                                CustomUtils.getInstance().cancelDialog();
                                System.out.println("Code Phone Success");
                                validation.setPhoneError("");
                                calling.onSuccess(integerResponse.body(),integerResponse.code());
                            } else {
                                CustomUtils.getInstance().cancelDialog();
                                System.out.println("Code PHONE Failed");
                                calling.onSuccess(integerResponse.body(),integerResponse.code());
                                validation.setPhoneError(context.getString(R.string.invalid_phone_number));
                            }
                        }else if (integerResponse.code() == ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                            calling.onUnUthenticated(ConfigurationFile.Constants.UNUTHENTICATED_CODE);
                        }

                    }, throwable -> {
                        CustomUtils.getInstance().cancelDialog();
                        calling.onFailure(throwable);
                    });
            compositeDisposable.add(disposable);
        }else {
            callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
        }

    }

}
