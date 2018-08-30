package findandfix.model.response;

import com.google.gson.annotations.SerializedName;

import findandfix.model.request.UrgentRequestDetailObject;

public class ActiveUrgentRequestResponse {

    @SerializedName("data")
    private UrgentRequestDetailObject data;

    public UrgentRequestDetailObject getData() {
        return data;
    }
}
