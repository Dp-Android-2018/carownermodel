package com.findandfix.carowner.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ModelsResponse{

	@SerializedName("data")
	private List<ModelItem> data;

	public void setData(List<ModelItem> data){
		this.data = data;
	}

	public List<ModelItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ModelsResponse{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}