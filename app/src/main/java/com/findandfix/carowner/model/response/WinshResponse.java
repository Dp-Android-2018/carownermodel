package com.findandfix.carowner.model.response;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import com.findandfix.carowner.model.global.WenshTypes;

public class WinshResponse {

    @SerializedName("data")
    private List<WenshTypes> data;

    public List<WenshTypes> getData() {
        return data;
    }
}
