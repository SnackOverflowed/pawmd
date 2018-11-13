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

		Document myDoc = collection.find(eq("breed-name", getCorrectNameFormat(breedName))).first();
		mongoClient.close();
		
		BreedInfo b = new BreedInfo();
		
		if (myDoc == null) {
			b.setBreedName(breedName + " could not be found in our database");
		}
		else {
			b.setBreedName("Breed name: " + myDoc.getString("breed-name"));
			b.setFoodType("Food type: " + myDoc.getString("food-type"));
			b.setWalkTime("Walk tips: " + myDoc.getString("walk-tips"));
			b.setFemaleWeight("Average female weight: " + myDoc.getString("female-weight"));
			b.setMaleWeight("Average male weight: " + myDoc.getString("male-weight"));
			b.setFeeding("Feeding frequency: " + myDoc.getString("feeding-frequency"));
			b.setGrooming("Grooming: " + myDoc.getString("grooming"));
			b.setHealth("Health concerns: " + myDoc.getString("health-concerns"));
			b.setLifespan("Average life-span: " + myDoc.getString("average-lifespan"));
		}

		return b;
	}
	
	private String getCorrectNameFormat(String name) {
		char ch[] = name.toCharArray(); 
        for (int i = 0; i < name.length(); i++) { 

            if (i == 0 && ch[i] != ' ' ||  ch[i] != ' ' && ch[i - 1] == ' ') { 
                if (ch[i] >= 'a' && ch[i] <= 'z') { 
                    ch[i] = (char)(ch[i] - 'a' + 'A'); 
                } 
            } 
            else if (ch[i] >= 'A' && ch[i] <= 'Z')  
                ch[i] = (char)(ch[i] + 'a' - 'A');             
        } 
  
        String st = new String(ch); 
        return st; 
	}

	

}
