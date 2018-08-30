package findandfix.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import findandfix.model.global.Links;
import findandfix.model.global.RequestMeta;
import findandfix.model.global.RequestOfferObj;

public class RequestOfferResponse {

    @SerializedName("data")
    private ArrayList<RequestOfferObj> data;


    @SerializedName("links")
    private Links links;

    @SerializedName("meta")
    private RequestMeta meta;

    public ArrayList<RequestOfferObj> getData() {
        return data;
    }

    public Links getLinks() {
        return links;
    }

    public RequestMeta getMeta() {
        return meta;
    }
}
