package findandfix.model.global;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkShopData implements Serializable{

    @SerializedName("id")
    private int id;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("device_token")
    private String deviceToken;

    @SerializedName("name")
    private String name;


    @SerializedName("workdays")
    private ArrayList<WorkDayItems> workdays;


    public ArrayList<WorkDayItems> getWorkdays() {
        return workdays;
    }

    public int getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public String getName() {
        return name;
    }
}
