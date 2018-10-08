package com.pawmd.dataprovider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.client.RestTemplate;

import com.pawmd.data.BreedNameAndURL;

public class ImageURLProvider {
	
	public BreedNameAndURL getBreedImageURL(String breedName) {
		String[] words = breedName.split("\\s+");
		if (words.length > 1) {
			breedName = words[1] + "-" + words[0];
		}
		String APIcall = "https://dog.ceo/api/breed/" + breedName + "/images/random";
		
		BreedNameAndURL result = new BreedNameAndURL();
		result.setName("Image of " + breedName);
		result.setImageURL(parseJsonForURL(APIcall));
		return result;
	}
	
	private String parseJsonForURL(String APIcall) {
		String URL = "";
		RestTemplate restTemplate = new RestTemplate();
		String JSONresult = restTemplate.getForObject(APIcall, String.class);
		
		try {
			Object obj = new JSONParser().parse(JSONresult);
			JSONObject APIcallJsonObj = (JSONObject) obj;
			URL = (String) APIcallJsonObj.get("message");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return URL;
	}
}
