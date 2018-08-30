package findandfix.model.response;

import com.google.gson.annotations.SerializedName;

import findandfix.model.request.NormalRequestDetailObject;

public class ActiveNormalRequestResponse {

    @SerializedName("data")
    private NormalRequestDetailObject data;

    public NormalRequestDetailObject getData() {
        return data;
    }
}
