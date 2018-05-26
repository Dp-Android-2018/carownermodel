package findandfix.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class CitiesResponse{

	@SerializedName("data")
	private List<CityItem> data;

	public void setData(List<CityItem> data){
		this.data = data;
	}

	public List<CityItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"CitiesResponse{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}