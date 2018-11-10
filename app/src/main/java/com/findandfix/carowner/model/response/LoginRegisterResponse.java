package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

import com.findandfix.carowner.model.global.UserData;

/**
 * Created by DELL on 12/06/2018.
 */

public class LoginRegisterResponse {

    @SerializedName("data")
    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
