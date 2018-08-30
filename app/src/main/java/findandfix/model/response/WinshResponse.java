package findandfix.model.response;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import findandfix.model.global.WenshTypes;

public class WinshResponse {

    @SerializedName("data")
    private List<WenshTypes> data;

    public List<WenshTypes> getData() {
        return data;
    }
}
