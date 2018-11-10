package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import com.findandfix.carowner.model.global.Links;
import com.findandfix.carowner.model.global.RequestData;
import com.findandfix.carowner.model.global.RequestMeta;
import com.findandfix.carowner.model.global.WorkshopSearchObj;

/**
 * Created by DELL on 15/08/2018.
 */

public class WorkshopSearchResponse {

    @SerializedName("data")
    private List<WorkshopSearchObj> data;

    @SerializedName("links")
    private Links links;

    @SerializedName("meta")
    private RequestMeta meta;

    public List<WorkshopSearchObj> getData() {
        return data;
    }

    public Links getLinks() {
        return links;
    }

    public RequestMeta getMeta() {
        return meta;
    }
}
