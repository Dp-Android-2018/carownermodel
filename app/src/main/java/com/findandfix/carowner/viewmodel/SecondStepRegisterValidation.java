package com.findandfix.carowner.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.findandfix.carowner.R;

import com.findandfix.carowner.utils.ConfigurationFile;

/**
 * Created by DELL on 11/06/2018.
 */

public class SecondStepRegisterValidation extends BaseObservable{

    public ObservableField<String> fnameError;
    public ObservableField<String>lnameError;
    public ObservableField<String>phoneError;
    public ObservableField<String>countryError;
    public ObservableField<String>cityError;
    public ObservableField<String>brandError;
    public ObservableField<String>modelError;
    public ObservableField<String>yearError;
    private Context context;

    public void setPhoneError(String phone) {
        phoneError.set(phone);
    }

    public SecondStepRegisterValidation(Context context) {
        this.context=context;
        fnameError=new ObservableField<>();
        lnameError=new ObservableField<>();
        phoneError=new ObservableField<>();
        countryError=new ObservableField<>();
        cityError=new ObservableField<>();
        brandError=new ObservableField<>();
        modelError=new ObservableField<>();
        yearError=new ObservableField<>();
    }

    public Boolean validate(ObservableField<String>fname,ObservableField<String>lname,ObservableField<String>phone,int country,int city ,int brand , int model ,int year){
        if (fname.get()!=null){
            fnameError.set("");
            if (lname.get()!=null){
                lnameError.set("");
                if (phone.get()!=null){
                    phoneError.set("");
                    if (country!= ConfigurationFile.Constants.EMPTY_VALUE){
                        countryError.set("");
                        if (city!=ConfigurationFile.Constants.EMPTY_VALUE){
                            cityError.set("");
                            if (brand!=ConfigurationFile.Constants.EMPTY_VALUE){
                                brandError.set("");
                                if (model!=ConfigurationFile.Constants.EMPTY_VALUE){
                                    modelError.set("");
                                    if (year!=ConfigurationFile.Constants.EMPTY_VALUE){
                                        yearError.set("");
                                        return true;
                                    }else yearError.set(context.getString(R.string.required_field));
                                }else modelError.set(context.getString(R.string.required_field));
                            }else brandError.set(context.getString(R.string.required_field));
                        }else cityError.set(context.getString(R.string.required_field));

                    }else countryError.set(context.getString(R.string.required_field));
                }else phoneError.set(context.getString(R.string.required_field));
            }else lnameError.set(context.getString(R.string.required_field));
        }else fnameError.set(context.getString(R.string.required_field));

        return false;
    }
}
