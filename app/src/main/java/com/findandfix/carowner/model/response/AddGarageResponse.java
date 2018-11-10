package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

import com.findandfix.carowner.model.global.Garage;

public class AddGarageResponse {

    @SerializedName("data")
    private Garage data;

    public Garage getData() {
        return data;
    }
}
