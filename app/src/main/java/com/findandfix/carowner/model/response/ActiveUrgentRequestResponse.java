package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

import com.findandfix.carowner.model.request.UrgentRequestDetailObject;

public class ActiveUrgentRequestResponse {

    @SerializedName("data")
    private UrgentRequestDetailObject data;

    public UrgentRequestDetailObject getData() {
        return data;
    }
}
