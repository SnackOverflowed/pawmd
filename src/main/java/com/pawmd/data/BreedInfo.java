package com.pawmd.data;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class BreedInfo {
	
	@Id
	public ObjectId _id;
	
	private String breedName;
	private String foodType;
	private String walkTime;
	private String feeding;
	private String health;
	private String lifespan;
	private String gromming; 
	private String breedSize;

	
	public String getFeeding() {
		return feeding;
	}
	public void setFeeding(String feeding) {
		this.feeding = feeding;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getLifespan() {
		return lifespan;
	}
	public void setLifespan(String lifespan) {
		this.lifespan = lifespan;
	}
	public String getGromming() {
		return gromming;
	}
	public void setGromming(String gromming) {
		this.gromming = gromming;
	}
	public String getBreedSize() {
		return breedSize;
	}
	public void setBreedSize(String breedSize) {
		this.breedSize = breedSize;
	}
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
