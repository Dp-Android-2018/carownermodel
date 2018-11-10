package com.findandfix.carowner.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import com.findandfix.carowner.model.global.BaseModel;


public class CitiesResponse{

	@SerializedName("data")
	private List<BaseModel> data;

	public void setData(List<BaseModel> data){
		this.data = data;
	}

	public List<BaseModel> getData(){
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