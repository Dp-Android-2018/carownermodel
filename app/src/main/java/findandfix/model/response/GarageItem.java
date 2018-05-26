package findandfix.model.response;

import com.google.gson.annotations.SerializedName;

public class GarageItem{

	@SerializedName("year")
	private String year;

	@SerializedName("model")
	private String model;

	@SerializedName("id")
	private int id;

	@SerializedName("brand")
	private String brand;

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setModel(String model){
		this.model = model;
	}

	public String getModel(){
		return model;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	@Override
 	public String toString(){
		return 
			"GarageItem{" + 
			"year = '" + year + '\'' + 
			",model = '" + model + '\'' + 
			",id = '" + id + '\'' + 
			",brand = '" + brand + '\'' + 
			"}";
		}
}