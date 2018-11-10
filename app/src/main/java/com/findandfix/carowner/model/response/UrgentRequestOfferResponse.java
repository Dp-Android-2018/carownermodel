package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import com.findandfix.carowner.model.global.Links;
import com.findandfix.carowner.model.global.RequestMeta;
import com.findandfix.carowner.model.global.UrgentRequestOfferObj;

public class UrgentRequestOfferResponse {

    @SerializedName("data")
    private ArrayList<UrgentRequestOfferObj> data;


    @SerializedName("links")
    private Links links;

    @SerializedName("meta")
    private RequestMeta meta;

    public ArrayList<UrgentRequestOfferObj> getData() {
        return data;
    }

    public Links getLinks() {
        return links;
    }

    public RequestMeta getMeta() {
        return meta;
    }
}
