package findandfix.model.request;

import com.google.gson.annotations.SerializedName;

public class AddGarageRequest {

    @SerializedName("brand_id")
    private int brandId;

    @SerializedName("model_id")
    private int modelId;

    @SerializedName("year")
    private int year;

    public AddGarageRequest(int brandId, int modelId, int year) {
        this.brandId = brandId;
        this.modelId = modelId;
        this.year = year;
    }
}
