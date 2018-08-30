package findandfix.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import findandfix.model.global.Links;
import findandfix.model.global.RequestMeta;
import findandfix.model.global.UrgentRequestOfferObj;

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
