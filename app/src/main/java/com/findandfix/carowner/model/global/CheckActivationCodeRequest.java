package com.findandfix.carowner.model.global;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 14/08/2018.
 */

public class CheckActivationCodeRequest {

    @SerializedName("code")
    private String code;

    public CheckActivationCodeRequest(String code) {
        this.code = code;
    }
}
