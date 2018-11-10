package com.findandfix.carowner.model.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import com.findandfix.carowner.model.global.BaseModel;
import com.findandfix.carowner.model.global.Media;

public class NormalRequestDetailObject implements Serializable{
    @SerializedName("id")
    private int id;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("winch")
    private int winch;

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

    @SerializedName("specializations")
    private ArrayList<BaseModel> specializations;

    @SerializedName("images")
    private ArrayList<Media> images;

    @SerializedName("videos")
    private ArrayList<Media> videos;


    @SerializedName("date")
    private String date;


    @SerializedName("percentage")
    private float percentage;

    public int getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public int getWinch() {
        return winch;
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

    public ArrayList<BaseModel> getSpecializations() {
        return specializations;
    }

    public ArrayList<Media> getImages() {
        return images;
    }

    public ArrayList<Media> getVideos() {
        return videos;
    }

    public String getDate() {
        return date;
    }

    public float getPercentage() {
        return percentage;
    }
}
