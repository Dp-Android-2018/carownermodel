package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

public class CheckCodeResponse {

    @SerializedName("checker")
    private int checker;

    public int getChecker() {
        return checker;
    }
}
