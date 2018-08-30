package findandfix.model.request;

import com.google.gson.annotations.SerializedName;

public class RateRequest {

    @SerializedName("workshop_id")
    private int workshopId;

    @SerializedName("rate")
    private int rate;

    public RateRequest(int workshopId, int rate) {
        this.workshopId = workshopId;
        this.rate = rate;
    }
}
