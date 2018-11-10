package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import com.findandfix.carowner.model.global.AdvData;
import com.findandfix.carowner.model.global.Links;
import com.findandfix.carowner.model.global.RequestMeta;

public class OffersResponse {

    @SerializedName("data")
    private List<AdvData> data;


    @SerializedName("meta")
    private RequestMeta meta;

    @SerializedName("links")
    private Links links;

    public RequestMeta getMeta() {
        return meta;
    }

    public Links getLinks() {
        return links;
    }

    public List<AdvData> getData() {
        return data;
    }
}
