package com.findandfix.carowner.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class CountriesResponse{

	@SerializedName("data")
	private List<com.findandfix.carowner.model.global.CountryItem> data;

	public void setData(List<com.findandfix.carowner.model.global.CountryItem> data){
		this.data = data;
	}

	public List<com.findandfix.carowner.model.global.CountryItem> getData(){
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