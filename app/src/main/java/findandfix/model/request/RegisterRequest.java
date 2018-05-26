package findandfix.model.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class RegisterRequest implements Serializable {

    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("country_id")
    private int countryId;
    @SerializedName("city_id")
    private int cityId;
    @SerializedName("brand_id")
    private int brandId;
    @SerializedName("model_id")
    private int modelId;
    @SerializedName("year")
    private int year;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;
    @SerializedName("password")
    private String password;
    @SerializedName("device_token")
    private String deviceToken;
    @SerializedName("image")
    private String image;

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getBrandId() {
        return brandId;
    }

    public int getCityId() {
        return cityId;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getModelId() {
        return modelId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getImage() {
        return image;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public int getYear() {
        return year;
    }
}


