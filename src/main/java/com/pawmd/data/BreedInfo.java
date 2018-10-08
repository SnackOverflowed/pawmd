package com.pawmd.data;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class BreedInfo {
	
	@Id
	public ObjectId _id;
	
	private String breedName;
	private String foodType;
	private String walkTime;

	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getBreedName() {
		return breedName;
	}
	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}
	public String getWalkTime() {
		return walkTime;
	}
	public void setWalkTime(String walkTime) {
		this.walkTime = walkTime;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	

}
