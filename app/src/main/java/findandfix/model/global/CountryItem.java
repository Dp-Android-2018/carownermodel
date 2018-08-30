package findandfix.model.global;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class CountryItem extends BaseModel implements Serializable {

	@SerializedName("image")
	private String image;

	public String getImage() {
		return image;
	}




}