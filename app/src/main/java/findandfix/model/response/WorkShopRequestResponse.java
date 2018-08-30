package findandfix.model.response;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import findandfix.model.global.Links;
import findandfix.model.global.RequestData;
import findandfix.model.global.RequestMeta;

/**
 * Created by DELL on 27/03/2018.
 */

public class WorkShopRequestResponse {

    @SerializedName("data")
    private List<RequestData> data;

    @SerializedName("links")
    private Links links;

    @SerializedName("meta")
    private RequestMeta meta;

    public List<RequestData> getData() {
        return data;
    }

    public Links getLinks() {
        return links;
    }

    public RequestMeta getMeta() {
        return meta;
    }
}
