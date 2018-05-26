package findandfix.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class BrandsResponse{

	@SerializedName("data")
	private List<BrandItem> data;

	public void setData(List<BrandItem> data){
		this.data = data;
	}

	public List<BrandItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"BrandsResponse{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}