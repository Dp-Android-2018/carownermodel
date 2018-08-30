package findandfix.model.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class AddNormalRequest implements Serializable{
    @SerializedName("garage_id")
    private int garageId;

    @SerializedName("city_id")
    private int cityId;

    @SerializedName("winch")
    private int winch;

    @SerializedName("lat")
    private double lat;

    @SerializedName("lng")
    private double lng;

    @SerializedName("notes")
    private String notes;

    @SerializedName("images")
    private ArrayList<String> images;

    @SerializedName("video")
    private String video;

    @SerializedName("specializations")
    private ArrayList<Integer> specializations;


    @SerializedName("fixation_paper")
    private String fixation_paper;

    public void setFixation_paper(String fixation_paper) {
        this.fixation_paper = fixation_paper;
    }

    public void setGarageId(int garageId) {
        this.garageId = garageId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setWinch(int winch) {
        this.winch = winch;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setSpecializations(ArrayList<Integer> specializations) {
        this.specializations = specializations;
    }
}
