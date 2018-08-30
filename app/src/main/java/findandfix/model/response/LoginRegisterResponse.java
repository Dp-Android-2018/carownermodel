package findandfix.model.response;

import com.google.gson.annotations.SerializedName;

import findandfix.model.global.UserData;

/**
 * Created by DELL on 12/06/2018.
 */

public class LoginRegisterResponse {

    @SerializedName("data")
    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
