package findandfix.model.global;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 14/08/2018.
 */

public class SendActivationCodeRequest {

    @SerializedName("mobile")
    private String mobile;

    public SendActivationCodeRequest(String mobile) {
        this.mobile = mobile;
    }
}
