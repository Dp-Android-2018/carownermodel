package com.findandfix.carowner.viewmodel;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.findandfix.carowner.BR;
import com.findandfix.carowner.R;
import com.findandfix.carowner.model.global.BaseModel;
import com.findandfix.carowner.model.global.RequestOfferObj;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.request.UpdateProfileRequest;
import com.findandfix.carowner.model.response.BrandItem;
import com.findandfix.carowner.model.response.BrandsResponse;
import com.findandfix.carowner.model.response.CitiesResponse;
import com.findandfix.carowner.model.response.CountriesResponse;
import com.findandfix.carowner.model.response.DefaultResponse;
import com.findandfix.carowner.model.response.ModelItem;
import com.findandfix.carowner.model.response.ModelsResponse;
import com.findandfix.carowner.model.response.YearItem;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.ConstantsCallsUtils;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.utils.SharedPrefrenceUtils;
import com.findandfix.carowner.ui.adapters.BrandsAdapter;
import com.findandfix.carowner.ui.adapters.CitiesAdapter;
import com.findandfix.carowner.ui.adapters.CountriesAdapter;
import com.findandfix.carowner.ui.adapters.ModelsAdapter;
import com.findandfix.carowner.ui.adapters.YearsAdapter;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.ui.callback.NetworkCallback;
import com.findandfix.carowner.ui.callback.RecycleItemClickListener;
import com.findandfix.carowner.ui.callback.TaskMonitor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * Created by DELL on 03/04/2018.
 */

public class EditProfileInfoViewModel extends BaseObservable {
    private UserData userData;
    private Context context;
    public ObservableField<String> fname;
    public ObservableField<String> lname;
    public ObservableField<String> phone;
    public ObservableField<String> email;
    public ObservableField<String> country;
    public ObservableField<String> city;
    public ObservableField<String> brand;
    public ObservableField<String> model;
    public ObservableField<String> year;
    public ObservableField<String> picUrl;
    private BaseInterface callback;
    List<com.findandfix.carowner.model.global.CountryItem> countryItems ;
    List<BaseModel>cityItems ;
    List<BrandItem>brandItems;
    List<ModelItem>modelItems;
    List<YearItem>yearItems;
    RecyclerView spinnerRecycleView;
    Uri selectedImageUri = null;
    Dialog dialog=null;
    private RxPermissions rxPermissions;
    StorageReference storageReference;
    private Bitmap selectedImageBitmap;
    public Bitmap picBitmap;
    private com.findandfix.carowner.model.global.CountryItem selectedCountry=new com.findandfix.carowner.model.global.CountryItem();
    private BaseModel selectedCity=new BaseModel();
    private BrandItem brandItem=new BrandItem();
    private ModelItem modelItem=new ModelItem();
   private YearItem yearItem=new YearItem();
    int selectedCountryId =ConfigurationFile.Constants.EMPTY_VALUE , selectedCityId = ConfigurationFile.Constants.EMPTY_VALUE , selectedBrandId = ConfigurationFile.Constants.EMPTY_VALUE , selectedModelId = ConfigurationFile.Constants.EMPTY_VALUE ;
    String selectedYear=null;
    public EditProfileInfoViewModel(Context context, BaseInterface callback) {
        userData= CustomUtils.getInstance().getSaveUserObject(context);
        rxPermissions = new RxPermissions((Activity) context);
        this.callback=callback;
        this.context=context;
        initializeVariables();
        setCarOwnerData();}

    public void initializeVariables(){
        fname=new ObservableField<>();
        lname=new ObservableField<>();
        phone=new ObservableField<>();
        email=new ObservableField<>();
        country=new ObservableField<>();
        city=new ObservableField<>();
        brand=new ObservableField<>();
        model=new ObservableField<>();
        year=new ObservableField<>();
        picUrl=new ObservableField<>();
        selectedCountryId =userData.getCountry().getId();
        selectedCityId =userData.getCity().getId();
        selectedBrandId =userData.getGarages().get(0).getBrand().getId();
        selectedModelId =userData.getGarages().get(0).getModel().getId();
        storageReference = FirebaseStorage.getInstance().getReference().child("app_photos");
        picUrl.set(userData.getImage());
    }

    public void displayDialog(View view) {

            callback.updateUi(ConfigurationFile.Constants.SHOW_DIALOG_CODE);

    }
    public void askForPermission(int checker) {
        CustomUtils.getInstance().requirePermission(rxPermissions,checker,callback);
    }

    public void setCarOwnerData(){
        selectedCountry=userData.getCountry();
        selectedCity=userData.getCity();
        brandItem=userData.getGarages().get(0).getBrand();
        modelItem=userData.getGarages().get(0).getModel();
        selectedYear=userData.getGarages().get(0).getYear();

        fname.set(userData.getFirstName());
        lname.set(userData.getLastName());
        phone.set(userData.getMobile());
        email.set(userData.getEmail());
        country.set(userData.getCountry().getName());
        city.set(userData.getCity().getName());
        brand.set(userData.getGarages().get(0).getBrand().getName());
        model.set(userData.getGarages().get(0).getModel().getName());
        year.set(userData.getGarages().get(0).getYear());
    }

    public void showCountries(final View view) {
        if(countryItems!=null) {
            setCountriesList();
        }
        else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
            //    progressDialog.set(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog((Activity)context);
                ConstantsCallsUtils.getInstance().getCountries(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                        //progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            CountriesResponse countriesResponseResponse=(CountriesResponse)data;
                            countryItems = countriesResponseResponse.getData();
                            setCountriesList();
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                       // progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                            CustomUtils.getInstance().endSession((Activity) context);
                    }
                },CustomUtils.getInstance().getAppLanguage(context));
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }
    }

    private void setCountriesList(){
        CountriesAdapter countriesAdapter = new CountriesAdapter(context,countryItems);

        if(dialog==null)
            setDialog(context.getResources().getString(R.string.label_choose_country));
         else if (!dialog.isShowing())
            setDialog(context.getResources().getString(R.string.label_choose_country));

        spinnerRecycleView.setAdapter(countriesAdapter);
        countriesAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedCountry=countryItems.get(position);
                selectedCountryId = countryItems.get(position).getId();
                country.set(countryItems.get(position).getName());
                selectedCityId =-1;
                city.set("");
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void showCities(final View view) {
        if(selectedCountryId ==ConfigurationFile.Constants.EMPTY_VALUE){
            callback.updateUi(ConfigurationFile.Constants.CHOOSE_COUNTRY);
        }
        else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
              //  progressDialog.set(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog((Activity)context);
                ConstantsCallsUtils.getInstance().getCities(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                   //     progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        CitiesResponse citiesResponse=(CitiesResponse)data;
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            cityItems = citiesResponse.getData();
                            setCitiesList();
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        CustomUtils.getInstance().cancelDialog();
                        //progressDialog.set(View.GONE);
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession((Activity) context);
                    }
                }, selectedCountryId,CustomUtils.getInstance().getAppLanguage(context));
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }


    }

    private void setCitiesList(){

        CitiesAdapter citiesAdapter = new CitiesAdapter(context,cityItems);
        if(dialog==null)
            setDialog(context.getResources().getString(R.string.label_choose_city));
        else if (!dialog.isShowing())
            setDialog(context.getResources().getString(R.string.label_choose_city));
        spinnerRecycleView.setAdapter(citiesAdapter);
        citiesAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedCity=cityItems.get(position);
                selectedCityId = cityItems.get(position).getId();
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
                      //  progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession((Activity) context);
                    }
                },CustomUtils.getInstance().getAppLanguage(context));
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }
    }

    private void setBrandsList(){
        BrandsAdapter brandsAdapter = new BrandsAdapter(context,brandItems);
        if (dialog==null)
            setDialog(context.getResources().getString(R.string.label_choose_brand));
        else if (!dialog.isShowing())
        setDialog(context.getResources().getString(R.string.label_choose_brand));
        spinnerRecycleView.setAdapter(brandsAdapter);
        brandsAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                brandItem= brandItems.get(position);
                selectedBrandId = brandItems.get(position).getId();
                brand.set(brandItems.get(position).getName());
                selectedModelId =-1;
                model.set("");
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }




    public void showModels(final View view) {
        if (selectedBrandId ==ConfigurationFile.Constants.EMPTY_VALUE){
            callback.updateUi(ConfigurationFile.Constants.CHOOSE_BRANDS);
        }else {
            if (NetWorkConnection.isConnectingToInternet(context)) {
              //  progressDialog.set(View.VISIBLE);
                CustomUtils.getInstance().showProgressDialog((Activity)context);
                ConstantsCallsUtils.getInstance().getModels(new NetworkCallback() {
                    @Override
                    public <E> void onSuccess(Object data, int code) {
                      //  progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            ModelsResponse modelsResponseResponse = (ModelsResponse) data;
                            modelItems = modelsResponseResponse.getData();
                            setModelList();
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                     //   progressDialog.set(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                    }

                    @Override
                    public <E> void onUnUthenticated(int code) {
                        CustomUtils.getInstance().endSession((Activity) context);
                    }
                }, selectedBrandId,CustomUtils.getInstance().getAppLanguage(context));
            } else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }



    }

    private void setModelList(){
        ModelsAdapter modelsAdapter = new ModelsAdapter(context,modelItems);
        if (dialog==null)
            setDialog(context.getResources().getString(R.string.label_choose_model));
        else if (!dialog.isShowing())
        setDialog(context.getResources().getString(R.string.label_choose_model));
        spinnerRecycleView.setAdapter(modelsAdapter);
        modelsAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                modelItem=modelItems.get(position);
                selectedModelId = modelItems.get(position).getId();
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
            }}

        setYearsList();
    }


    private void setYearsList(){
        YearsAdapter yearsAdapter = new YearsAdapter(context,yearItems);
        if (dialog==null)
            setDialog(context.getResources().getString(R.string.label_choose_year));
        else if (!dialog.isShowing())
        setDialog(context.getResources().getString(R.string.label_choose_year));
        spinnerRecycleView.setAdapter(yearsAdapter);
        yearsAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                yearItem=yearItems.get(position);
                selectedYear = yearItems.get(position).getName();
                year.set(yearItems.get(position).getName());
                dialog.cancel();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            convertImageToBase64(data.getData());
            selectedImageUri=data.getData();
        }}

    public void convertImageToBase64(Uri ImageUri) {
        try {
            final InputStream imageStream = context.getContentResolver().openInputStream(ImageUri);
            selectedImageBitmap = BitmapFactory.decodeStream(imageStream);
            String RealPicturePath = CustomUtils.getInstance().uriToFilename(ImageUri, context);
            selectedImageBitmap = CustomUtils.getInstance().modifyOrientation(selectedImageBitmap, RealPicturePath);
            setPicBitmap(selectedImageBitmap);
        //    encodedImage = CustomUtils.getInstance().encodeImage(selectedImageBitmap);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setPicBitmap(Bitmap picBitmap) {
        this.picBitmap = picBitmap;
        notifyPropertyChanged(BR.picBitmap);
    }

    @Bindable
    public Bitmap getPicBitmap() {
        return picBitmap;
    }

    public void validate(View view){

        if (selectedImageUri !=null){uploadToFireBase();}
        else if (validateData())updateProfile();
    }

    public void uploadToFireBase(){

        CustomUtils.getInstance().uploadFireBasePic(storageReference, selectedImageUri, photoUrl -> {
            System.out.println("Photo Url :"+photoUrl);
            picUrl.set(photoUrl);
            if (validateData())
                updateProfile();
        });}

    public void  updateProfile(){
        CustomUtils.getInstance().showProgressDialog((Activity)context);
        UpdateProfileRequest updateProfileRequest=new UpdateProfileRequest(fname.get(),lname.get(),email.get(),phone.get(), selectedCountryId, selectedCityId,picUrl.get(), selectedBrandId, selectedModelId,selectedYear);
        ApiClient.getClient().create(EndPoints.class).editProfile(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(context), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),updateProfileRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(defaultResponseResponse -> {
                 CustomUtils.getInstance().cancelDialog();
                    if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                        callback.updateUi(ConfigurationFile.Constants.SUCCESS_CODE);
                        saveUserData();

                    }else if(defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED){
                        callback.updateUi(ConfigurationFile.Constants.UNUTHENTICATED);
                    }else if(defaultResponseResponse.code()==ConfigurationFile.Constants.INVALID_DATA){
                        callback.updateUi(ConfigurationFile.Constants.INVALID_DATA);
                    }else if(defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                        callback.updateUi(ConfigurationFile.Constants.UNUTHENTICATED_CODE);
                    }
                }, throwable -> {
                    CustomUtils.getInstance().cancelDialog();
                    System.out.println(throwable.getMessage());
                });
    }

    public boolean validateData(){
        if (fname.get()==null || fname.get().equals("")|| lname.get()==null || lname.get().equals("")||phone.get()==null || phone.get().equals("")||email.get()==null || email.get().equals("")){
            callback.updateUi(ConfigurationFile.Constants.FILL_ALL_DATTA);
            return false;
        }else if (selectedCityId ==-1 || selectedModelId == -1){
            callback.updateUi(ConfigurationFile.Constants.DATA_ISNT_MATCH);
            return false;
        }else return true;
    }

    public void changePasswordAct(View view){
        callback.updateUi(ConfigurationFile.Constants.CHANGE_PASSWORD_ACT);
    }

    public void saveUserData(){
        userData.setFirstName(fname.get());
        userData.setLastName(lname.get());
        userData.setMobile(phone.get());
        userData.setEmail(email.get());
        userData.setCountry(selectedCountry);
        userData.setImage(picUrl.get());
       userData.setCity(selectedCity);
        userData.getGarages().get(0).setBrand(brandItem);
        userData.getGarages().get(0).setModel(modelItem);
        userData.getGarages().get(0).setYear(String.valueOf(selectedYear));
        SharedPrefrenceUtils pref=new SharedPrefrenceUtils(context);
        pref.saveObjectToSharedPreferences(ConfigurationFile.SharedPrefConstants.PREF_CAR_OWNER_OBJ_DATA,userData);
        System.out.println("User Data Id :"+userData.getCountry().getId());
    }

}
