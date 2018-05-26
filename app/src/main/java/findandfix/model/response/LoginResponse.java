package findandfix.model.response;


import findandfix.model.global.UserData;
import com.google.gson.annotations.SerializedName;


public class LoginResponse {

	@SerializedName("data")
	private UserData data;

	public void setData(UserData data){
		this.data = data;
	}

	public UserData getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponse{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}