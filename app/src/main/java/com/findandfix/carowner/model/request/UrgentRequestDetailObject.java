package com.findandfix.carowner.model.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import com.findandfix.carowner.model.global.CarOwner;

public class UrgentRequestDetailObject implements Serializable{

    @SerializedName("id")
    private int id;

    @SerializedName("lat")
    private String latitude;

    @SerializedName("lng")
    private String longitude;

    @SerializedName("notes")
    private String notes;


    @SerializedName("brand")
    private String brand;

    @SerializedName("model")
    private String model;

    @SerializedName("year")
    private String year;

    @SerializedName("address")
    private String address;

    @SerializedName("type")
    private UrgentRequestType type;

    @SerializedName("date")
    private String date;


    @SerializedName("molbile")
    private String mobile;

    @SerializedName("winch_type")
    private String winchType;


    @SerializedName("voice_notes")
    private String voiceNotes;


    @SerializedName("carowner")
    private CarOwner carOwner;

    public int getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getNotes() {
        return notes;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getAddress() {
        return address;
    }

    public UrgentRequestType getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWinchType() {
        return winchType;
    }

    public String getVoiceNotes() {
        return voiceNotes;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }
}
