package com.example.mohamedatef.findandfix.utils;

import com.example.mohamedatef.findandfix.model.response.BrandsResponse;
import com.example.mohamedatef.findandfix.model.response.CountryResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by DELL on 04/04/2018.
 */

public class ConstantsCallsUtils {

    private static ConstantsCallsUtils constantsCallsUtils;
    private CountryResponse countryResponse=null;
    private BrandsResponse brandsResponse=null;
    private SpecializationResponse specializationResponse=null;
    private UrgentRequestTypeResponse urgentRequestTypeResponse=null;
    private CityResponse cityResponse=null;
    private ConstantsCallsUtils(){}
    public static ConstantsCallsUtils getInstance(){
        if (constantsCallsUtils==null)
            constantsCallsUtils=new ConstantsCallsUtils();
        return constantsCallsUtils;
    }


    public void getCountries(final NetworkCallback callback){
        System.out.println("Countries Connecting");
         ApiClient.getClient().create(EndPoints.class).getCountries(ConfigurationFile.Constants.API_KEY,"EN",ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<CountryResponse>>() {
                    @Override
                    public void accept(Response<CountryResponse> countryResponseResponse) throws Exception {
                        System.out.println("Countries CODE :"+countryResponseResponse.code());
                        if (countryResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                            CountryResponse response=countryResponseResponse.body();
                            callback.onSuccess(response,ConfigurationFile.Constants.SUCCESS_CODE);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("Ex :"+throwable.getMessage());
                        callback.onFailure(throwable);
                    }
                });

    }


    public void getBrands(final NetworkCallback callback) {

        ApiClient.getClient().create(EndPoints.class).getBrands(ConfigurationFile.Constants.API_KEY, "EN", ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<BrandsResponse>>() {
                    @Override
                    public void accept(Response<BrandsResponse> brandsResponseResponse) throws Exception {
                        if (brandsResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE)
                                brandsResponse=brandsResponseResponse.body();
                                callback.onSuccess(brandsResponse,ConfigurationFile.Constants.SUCCESS_CODE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onFailure(throwable);
                    }
                });
    }

    public void getSpecializations(final NetworkCallback callback) {
        ApiClient.getClient().create(EndPoints.class).getSpecializations(ConfigurationFile.Constants.API_KEY, "EN", ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<SpecializationResponse>>() {
                    @Override
                    public void accept(Response<SpecializationResponse> specializationResponseResponse) throws Exception {

                        if (specializationResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE)
                                    specializationResponse=specializationResponseResponse.body();
                                    callback.onSuccess(specializationResponse,ConfigurationFile.Constants.SUCCESS_CODE);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onFailure(throwable);
                    }
                });


    }


    public void getUrgentRequestTypes(final NetworkCallback callback) {

        ApiClient.getClient().create(EndPoints.class).getUrgentTypes(ConfigurationFile.Constants.API_KEY, "EN", ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<UrgentRequestTypeResponse>>() {
                    @Override
                    public void accept(Response<UrgentRequestTypeResponse> urgentRequestTypeResponseResponse) throws Exception {
                        if (urgentRequestTypeResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE)
                                urgentRequestTypeResponse=urgentRequestTypeResponseResponse.body();
                                    callback.onSuccess(urgentRequestTypeResponse,ConfigurationFile.Constants.SUCCESS_CODE);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onFailure(throwable);
                    }
                });

    }



}
