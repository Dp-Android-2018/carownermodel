package findandfix.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class CountriesResponse{

	@SerializedName("data")
	private List<CountryItem> data;

	public void setData(List<CountryItem> data){
		this.data = data;
	}

	public List<CountryItem> getData(){
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