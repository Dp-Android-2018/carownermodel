package findandfix.model.response;

import com.google.gson.annotations.SerializedName;


public class RegisterResponse{

	@SerializedName("data")
	private RegisterItem data;

	public void setData(RegisterItem data){
		this.data = data;
	}

	public RegisterItem getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RegisterResponse{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}