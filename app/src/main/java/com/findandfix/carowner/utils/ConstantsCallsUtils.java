package com.findandfix.carowner.utils;

import com.findandfix.carowner.model.response.BrandsResponse;
import com.findandfix.carowner.model.response.CitiesResponse;
import com.findandfix.carowner.model.response.CountriesResponse;
import com.findandfix.carowner.model.response.ModelsResponse;
import com.findandfix.carowner.model.response.SpecializationResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.ui.callback.NetworkCallback;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by DELL on 04/04/2018.
 */

public class ConstantsCallsUtils {

    private static ConstantsCallsUtils constantsCallsUtils;
    private BrandsResponse brandsResponse=null;

    private ConstantsCallsUtils(){}
    public static ConstantsCallsUtils getInstance(){
        if (constantsCallsUtils==null)
            constantsCallsUtils=new ConstantsCallsUtils();
        return constantsCallsUtils;
    }

    public void getCountries(final NetworkCallback callback,String lang){
        ApiClient.getClient().create(EndPoints.class).getCountries(ConfigurationFile.Constants.API_KEY,lang,ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(countryResponseResponse -> {
                    System.out.println("Countries CODE :"+countryResponseResponse.code());
                    if (countryResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                        CountriesResponse response=countryResponseResponse.body();
                        callback.onSuccess(response,ConfigurationFile.Constants.SUCCESS_CODE);
                    }else if (countryResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                        callback.onUnUthenticated(ConfigurationFile.Constants.UNUTHENTICATED_CODE);
                    }
                }, throwable -> {
                    System.out.println("Ex :"+throwable.getMessage());
                    callback.onFailure(throwable);
                });

    }



    public void getCities(final NetworkCallback callback,int countryId,String lang){
        ApiClient.getClient().create(EndPoints.class).getCities(ConfigurationFile.Constants.API_KEY,lang,ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,countryId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(citiesResponseResponse -> {
                    System.out.println("Countries CODE :"+citiesResponseResponse.code());
                    if (citiesResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                        CitiesResponse response=citiesResponseResponse.body();
                        callback.onSuccess(response,ConfigurationFile.Constants.SUCCESS_CODE);
                    }else if (citiesResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                        callback.onUnUthenticated(ConfigurationFile.Constants.UNUTHENTICATED_CODE);
                    }
                }, throwable -> {
                    System.out.println("Ex :"+throwable.getMessage());
                    callback.onFailure(throwable);
                });

    }

    public void getBrands(final NetworkCallback callback,String lang){
        ApiClient.getClient().create(EndPoints.class).getBrands(ConfigurationFile.Constants.API_KEY,lang,ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(brandsResponseResponse -> {
                    System.out.println("Countries CODE :"+brandsResponseResponse.code());
                    if (brandsResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                        BrandsResponse response=brandsResponseResponse.body();
                        callback.onSuccess(response,ConfigurationFile.Constants.SUCCESS_CODE);
                    }else if (brandsResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                        callback.onUnUthenticated(ConfigurationFile.Constants.UNUTHENTICATED_CODE);
                    }
                }, throwable -> {
                    System.out.println("Ex :"+throwable.getMessage());
                    callback.onFailure(throwable);
                });
    }


    public void getModels(final NetworkCallback callback,int brandId,String lang){
        ApiClient.getClient().create(EndPoints.class).getModels(ConfigurationFile.Constants.API_KEY,lang,ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,brandId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(modelsResponseResponse -> {
                    System.out.println("Countries CODE :"+modelsResponseResponse.code());
                    if (modelsResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                        ModelsResponse response=modelsResponseResponse.body();
                        callback.onSuccess(response,ConfigurationFile.Constants.SUCCESS_CODE);
                    }else if (modelsResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                        callback.onUnUthenticated(ConfigurationFile.Constants.UNUTHENTICATED_CODE);
                    }
                }, throwable -> {
                    System.out.println("Ex :"+throwable.getMessage());
                    callback.onFailure(throwable);
                });

    }


    public void getSpecialization(final NetworkCallback callback,String lang){
        ApiClient.getClient().create(EndPoints.class).getSpecializations(ConfigurationFile.Constants.API_KEY,lang,ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(specializationResponseResponse -> {
                    System.out.println("Countries CODE :"+specializationResponseResponse.code());
                    if (specializationResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                        SpecializationResponse response=specializationResponseResponse.body();
                        callback.onSuccess(response,ConfigurationFile.Constants.SUCCESS_CODE);
                    }else if (specializationResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                        callback.onUnUthenticated(ConfigurationFile.Constants.UNUTHENTICATED_CODE);
                    }
                }, throwable -> {
                    System.out.println("Ex :"+throwable.getMessage());
                    callback.onFailure(throwable);
                });
    }



    public void getSubSpecializations(final NetworkCallback callback,int parentId,String lang){
        ApiClient.getClient().create(EndPoints.class).getSubSpecializations(ConfigurationFile.Constants.API_KEY,lang,ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,parentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(specializationResponseResponse -> {
                    System.out.println("Countries CODE :"+specializationResponseResponse.code());
                    if (specializationResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                        SpecializationResponse response=specializationResponseResponse.body();
                        callback.onSuccess(response,ConfigurationFile.Constants.SUCCESS_CODE);
                    }else if (specializationResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                        callback.onUnUthenticated(ConfigurationFile.Constants.UNUTHENTICATED_CODE);
                    }
                }, throwable -> {
                    System.out.println("Ex :"+throwable.getMessage());
                    callback.onFailure(throwable);
                });

    }





}
