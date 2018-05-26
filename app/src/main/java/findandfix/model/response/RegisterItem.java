package findandfix.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class RegisterItem {

	@SerializedName("country")
	private Country country;

	@SerializedName("image")
	private String image;

	@SerializedName("city")
	private City city;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("garage")
	private List<GarageItem> garage;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("confirmed")
	private int confirmed;

	@SerializedName("token")
	private String token;

	@SerializedName("device_token")
	private String deviceToken;

	@SerializedName("id")
	private int id;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;

	@SerializedName("longitude")
	private double longitude;

	public void setCountry(Country country){
		this.country = country;
	}

	public Country getCountry(){
		return country;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setGarage(List<GarageItem> garage){
		this.garage = garage;
	}

	public List<GarageItem> getGarage(){
		return garage;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setConfirmed(int confirmed){
		this.confirmed = confirmed;
	}

	public int getConfirmed(){
		return confirmed;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public void setDeviceToken(String deviceToken){
		this.deviceToken = deviceToken;
	}

	public String getDeviceToken(){
		return deviceToken;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"RegisterItem{" +
			"country = '" + country + '\'' + 
			",image = '" + image + '\'' + 
			",city = '" + city + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",mobile = '" + mobile + '\'' + 
			",garage = '" + garage + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",confirmed = '" + confirmed + '\'' + 
			",token = '" + token + '\'' + 
			",device_token = '" + deviceToken + '\'' + 
			",id = '" + id + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",email = '" + email + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}