package findandfix.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class CountriesResponse{

	@SerializedName("data")
	private List<findandfix.model.global.CountryItem> data;

	public void setData(List<findandfix.model.global.CountryItem> data){
		this.data = data;
	}

	public List<findandfix.model.global.CountryItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"CountriesResponse{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}