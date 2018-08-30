package findandfix.model.global;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UrgentRequestOfferObj implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("description")
    private String description;

    @SerializedName("date")
    private String date;


    @SerializedName("distance")
    private String distance;


    @SerializedName("normal_requests_count")
    private int normalRequestsCount;

    @SerializedName("urgent_requests_count")
    private int urgentRequestsCount;


    @SerializedName("rate")
    private String rate;


    @SerializedName("accepted")
    private int accepted;


    @SerializedName("workshop")
    private WorkShopData workshop;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getDistance() {
        return distance;
    }

    public int getNormalRequestsCount() {
        return normalRequestsCount;
    }

    public int getUrgentRequestsCount() {
        return urgentRequestsCount;
    }

    public String getRate() {
        return rate;
    }

    public int getAccepted() {
        return accepted;
    }

    public WorkShopData getWorkshop() {
        return workshop;
    }
}
