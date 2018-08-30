package findandfix.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 21/04/2018.
 */

public class UpdateProfileRequest {

    @SerializedName("first_name")
    private String fname;

    @SerializedName("last_name")
    private String lname;

    @SerializedName("email")
    private String email;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("country_id")
    private int countryId;

    @SerializedName("city_id")
    private int cityId;

    @SerializedName("image")
    private String image;

    @SerializedName("brand_id")
    private int brandId;

    @SerializedName("model_id")
    private int modelId;

    @SerializedName("year")
    private String year;


    public UpdateProfileRequest(String fname, String lname, String email, String mobile, int countryId, int cityId, String image, int brandId, int modelId, String year) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobile = mobile;
        this.countryId = countryId;
        this.cityId = cityId;
        this.image = image;
        this.brandId = brandId;
        this.modelId = modelId;
        this.year = year;
    }
}
