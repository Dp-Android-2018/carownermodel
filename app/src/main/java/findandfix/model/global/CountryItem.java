package findandfix.model.global;

import com.google.gson.annotations.SerializedName;


public class CountryItem extends BaseModel {

	@SerializedName("image")
	private String image;

	public String getImage() {
		return image;
	}




}