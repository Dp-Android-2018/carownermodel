package findandfix.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import findandfix.model.global.AchievmentObj;
import findandfix.model.global.Links;
import findandfix.model.global.RequestMeta;

public class AchievmentResponse {

    @SerializedName("data")
    private List<AchievmentObj> data;

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

    public List<AchievmentObj> getData() {
        return data;
    }
}
