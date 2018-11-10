package com.findandfix.carowner.model.request;

import com.google.gson.annotations.SerializedName;

import com.findandfix.carowner.model.global.Notification;

public class AcceptedOfferNotification {
    @SerializedName("notification")
    private Notification notification;

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
