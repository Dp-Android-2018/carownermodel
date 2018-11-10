package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

import com.findandfix.carowner.model.request.NormalRequestDetailObject;

public class ActiveNormalRequestResponse {

    @SerializedName("data")
    private NormalRequestDetailObject data;

    public NormalRequestDetailObject getData() {
        return data;
    }
}
