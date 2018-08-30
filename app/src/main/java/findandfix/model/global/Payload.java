package findandfix.model.global;

import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("noti_title")
    private String notificationTitle;

    @SerializedName("offer_id")
    private String offerId;

    @SerializedName("key")
    private int key;


    public void setKey(int key) {
        this.key = key;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }
}
