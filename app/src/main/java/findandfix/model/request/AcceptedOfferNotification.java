package findandfix.model.request;

import com.google.gson.annotations.SerializedName;

import findandfix.model.global.Notification;

public class AcceptedOfferNotification {
    @SerializedName("notification")
    private Notification notification;

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
