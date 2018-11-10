package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 29/07/2018.
 */

public class AddUrgentRequestResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("id")
    private int id;

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }
}
