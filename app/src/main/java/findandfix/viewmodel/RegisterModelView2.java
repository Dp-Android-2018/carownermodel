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
import android.widget.Toast;

import com.example.dp.findandfix.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import findandfix.model.request.RegisterRequest;
import findandfix.model.response.BrandItem;
import findandfix.model.response.BrandsResponse;
import findandfix.model.response.CitiesResponse;
import findandfix.model.response.CityItem;
import findandfix.model.response.CountriesResponse;
import findandfix.model.response.CountryItem;
import findandfix.model.response.ModelItem;
import findandfix.model.response.ModelsResponse;
import findandfix.model.response.YearItem;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.ConstantCodes;
import findandfix.utils.IntentConstants;
import findandfix.utils.NetWorkConnection;
import findandfix.view.ui.activities.UploadImageActivity;
import findandfix.view.ui.adapters.BrandsAdapter;
import findandfix.view.ui.adapters.CitiesAdapter;
import findandfix.view.ui.adapters.CountriesAdapter;
import findandfix.view.ui.adapters.ModelsAdapter;
import findandfix.view.ui.adapters.YearsAdapter;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.view.ui.callback.RecycleItemClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class RegisterModelView2 extends Observable {

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
    private CompositeDisposable compositeDisposable;
    List<CountryItem>countryItems ;
    List<CityItem>cityItems ;
    List<BrandItem>brandItems;
    List<ModelItem>modelItems;
    List<YearItem>yearItems;

     Dialog dialog=null;
    int selectedCountry=-1 , selectedCity = -1 ,selectedBrand = -1 , selectedModel = -1 ,selectedYear=-1;
    RecyclerView spinnerRecycleView;

    public RegisterModelView2(Context context, BaseInterface callback) {
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
        RegisterRequest registerRequest = (RegisterRequest)((Activity)context).getIntent().getSerializableExtra(IntentConstants.REGISTER_MODEL);

        registerRequest.setFirstName(firstName.get());
        registerRequest.setLastName(lastName.get());
        registerRequest.setMobile(phoneNumber.get());
        registerRequest.setCountryId(selectedCountry);
        registerRequest.setCityId(selectedCity);
        registerRequest.setBrandId(selectedBrand);
        registerRequest.setModelId(selectedModel);
        registerRequest.setYear(selectedYear);
        Intent intent = new Intent(context, UploadImageActivity.class);
        intent.putExtra(IntentConstants.REGISTER_MODEL,registerRequest);
        context.startActivity(intent);
    }


    public void showCountries(final View view) {
        if(countryItems!=null) {
            setCountriesList();
        }
        else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
                progressDialog.set(View.VISIBLE);
                Disposable disposable = ApiClient.getClient().create(EndPoints.class).getCountries(ConfigurationFile.Constants.API_KEY, "EN", ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Response<CountriesResponse>>() {
                            @Override
                            public void accept(Response<CountriesResponse> countriesResponseResponse) throws Exception {
                                progressDialog.set(View.GONE);
                                if (countriesResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                                    countryItems = countriesResponseResponse.body().getData();
                                    setCountriesList();
                                }
                            }

                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                                progressDialog.set(View.GONE);
                            }
                        });

                compositeDisposable.add(disposable);
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
        });
    }



    public void showCities(final View view) {
        if(selectedCountry==-1){
            callback.updateUi(ConstantCodes.SELECT_COUNTRY);
        }
        else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
                progressDialog.set(View.VISIBLE);
                Disposable disposable = ApiClient.getClient().create(EndPoints.class).getCities(ConfigurationFile.Constants.API_KEY, "EN", ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, selectedCountry)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Response<CitiesResponse>>() {
                            @Override
                            public void accept(Response<CitiesResponse> citiesResponseResponse) throws Exception {
                                progressDialog.set(View.GONE);
                                if (citiesResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                                    cityItems = citiesResponseResponse.body().getData();
                                    setCitiesList();
                                }
                            }

                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                                progressDialog.set(View.GONE);
                            }
                        });

                compositeDisposable.add(disposable);
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
        });
    }


    public void showCarBrands(final View view) {
        if(brandItems!=null){
            setBrandsList();
        }else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
                progressDialog.set(View.VISIBLE);
                Disposable disposable = ApiClient.getClient().create(EndPoints.class).getBrands(ConfigurationFile.Constants.API_KEY, "EN", ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Response<BrandsResponse>>() {
                            @Override
                            public void accept(Response<BrandsResponse> brandsResponseResponse) throws Exception {
                                progressDialog.set(View.GONE);
                                if (brandsResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                                    brandItems = brandsResponseResponse.body().getData();
                                    setBrandsList();
                                }
                            }

                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                                progressDialog.set(View.GONE);
                            }
                        });

                compositeDisposable.add(disposable);
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
        });
    }




    public void showModels(final View view) {
            if (NetWorkConnection.isConnectingToInternet(context)) {
                progressDialog.set(View.VISIBLE);
                Disposable disposable = ApiClient.getClient().create(EndPoints.class).getModels(ConfigurationFile.Constants.API_KEY, "EN", ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, selectedBrand)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Response<ModelsResponse>>() {
                            @Override
                            public void accept(Response<ModelsResponse> modelsResponseResponse) throws Exception {
                                progressDialog.set(View.GONE);
                                if (modelsResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                                    modelItems = modelsResponseResponse.body().getData();
                                    setModelList();
                                }
                            }

                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                                progressDialog.set(View.GONE);
                            }
                        });

                compositeDisposable.add(disposable);
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
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

}
