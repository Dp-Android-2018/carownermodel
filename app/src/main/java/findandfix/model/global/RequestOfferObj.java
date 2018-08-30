package findandfix.model.global;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RequestOfferObj implements Serializable {



    @SerializedName("id")
    private int id;

    @SerializedName("description")
    private String description;

    @SerializedName("country")
    private CountryItem country;

    @SerializedName("duration_from")
    private int durationFrom;

    @SerializedName("duration_to")
    private int durationTo;

    @SerializedName("cost_from")
    private int costFrom;

    @SerializedName("cost_to")
    private int costTo;

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

    public CountryItem getCountry() {
        return country;
    }

    public int getDurationFrom() {
        return durationFrom;
    }

    public int getDurationTo() {
        return durationTo;
    }

    public int getCostFrom() {
        return costFrom;
    }

    public int getCostTo() {
        return costTo;
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
