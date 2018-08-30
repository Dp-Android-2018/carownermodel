package findandfix.model.response;

import com.google.gson.annotations.SerializedName;

import findandfix.model.global.Garage;

public class AddGarageResponse {

    @SerializedName("data")
    private Garage data;

    public Garage getData() {
        return data;
    }
}
