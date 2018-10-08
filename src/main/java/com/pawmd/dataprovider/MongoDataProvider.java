package com.pawmd.dataprovider;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pawmd.data.BreedInfo;

import static com.mongodb.client.model.Filters.*;

public class MongoDataProvider {

	@Value("${spring.data.mongodb.uri}")
	private String UriConnection;
	
	@Value("${spring.data.mongodb.database}")
	private String databaseName;
	
	public BreedInfo getBreedInfo(String breedName) {

		MongoClientURI connectionString = new MongoClientURI(UriConnection);
		
		MongoClient mongoClient = new MongoClient(connectionString);
		
		MongoDatabase database = mongoClient.getDatabase(databaseName);
		
		MongoCollection<Document> collection = database.getCollection("breed");

		Document myDoc = collection.find(eq("breed-name", breedName)).first();
		mongoClient.close();
		
		BreedInfo b = new BreedInfo();
		
		if (myDoc == null) {
			b.setBreedName(breedName + " could not be found in our database");
		}
		else {
			b.setBreedName("breed name: " + myDoc.getString("breed-name"));
			b.setFoodType("food type: " + myDoc.getString("food-type"));
			b.setWalkTime("walk time: " + myDoc.getString("walk-time"));
		}

		return b;
	}
}
