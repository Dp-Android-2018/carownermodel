package com.findandfix.carowner.model.global;


import com.google.gson.annotations.SerializedName;


public class BrandItem extends BaseModel {

	@SerializedName("image")
	private String image;


	public String getImage() {
		return image;
	}
}