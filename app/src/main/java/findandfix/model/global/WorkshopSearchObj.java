package findandfix.model.global;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 15/08/2018.
 */

public class WorkshopSearchObj  {

    @SerializedName("country")
    private CountryItem country;

    @SerializedName("specializations_parent_id")
    private int parentId;

    @SerializedName("website")
    private String website;

    @SerializedName("brands")
    private List<BrandItem> brands;

    @SerializedName("specializations")
    private List<BaseModel> specializations;

    @SerializedName("city")
    private BaseModel city;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("token")
    private String token;

    @SerializedName("subscribed")
    private boolean subscribed;

    @SerializedName("workdays")
    private ArrayList<WorkDayItems> workdays;

    @SerializedName("urgent_request_types")
    private List<BaseModel> urgentRequestTypes;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("winch")
    private int winch;

    @SerializedName("suspended")
    private int suspended;

    @SerializedName("winch_types")
    private List<WenshTypes> wenshTypes;

    @SerializedName("active")
    private boolean active;

    @SerializedName("normal_requests_count")
    private int normalRequestCount;

    @SerializedName("urgent_requests_count")
    private int urgentRequestCount;

    @SerializedName("rate")
    private String rate;

    @SerializedName("device_token")
    private String deviceToken;

    @SerializedName("distance")
    private String distance;

    @SerializedName("social")
    private List<String> social;

    public int getNormalRequestCount() {
        return normalRequestCount;
    }

    public int getUrgentRequestCount() {
        return urgentRequestCount;
    }

    public String getRate() {
        return rate;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public String getDistance() {
        return distance;
    }

    public List<String> getSocial() {
        return social;
    }

    public CountryItem getCountry() {
        return country;
    }

    public int getParentId() {
        return parentId;
    }

    public String getWebsite() {
        return website;
    }

    public List<BrandItem> getBrands() {
        return brands;
    }

    public List<BaseModel> getSpecializations() {
        return specializations;
    }

    public BaseModel getCity() {
        return city;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getMobile() {
        return mobile;
    }

    public String getToken() {
        return token;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public ArrayList<WorkDayItems> getWorkdays() {
        return workdays;
    }

    public List<BaseModel> getUrgentRequestTypes() {
        return urgentRequestTypes;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLongitude() {
        return longitude;
    }

    public int getWinch() {
        return winch;
    }

    public int getSuspended() {
        return suspended;
    }

    public List<WenshTypes> getWenshTypes() {
        return wenshTypes;
    }

    public boolean isActive() {
        return active;
    }
}
