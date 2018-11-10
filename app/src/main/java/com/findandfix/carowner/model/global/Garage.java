package com.findandfix.carowner.model.global;

import com.google.gson.annotations.SerializedName;

import com.findandfix.carowner.model.response.*;
import com.findandfix.carowner.model.response.BrandItem;

/**
 * Created by DELL on 12/06/2018.
 */

public class Garage {

    @SerializedName("id")
    private int id;


    @SerializedName("brand")
    private com.findandfix.carowner.model.response.BrandItem brand;

    @SerializedName("model")
    private ModelItem model;

    @SerializedName("year")
    private String year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BrandItem getBrand() {
        return brand;
    }

    public void setBrand(com.findandfix.carowner.model.response.BrandItem brand) {
        this.brand = brand;
    }

    public ModelItem getModel() {
        return model;
    }

    public void setModel(ModelItem model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
