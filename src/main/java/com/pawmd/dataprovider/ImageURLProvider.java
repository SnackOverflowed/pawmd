package com.pawmd.dataprovider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.client.RestTemplate;

public class ImageURLProvider {

	private String URL;
	
	public String getBreedImageURL(String breedName) {
		String[] words = breedName.split("\\s+");
		if (words.length > 1) {
			breedName = words[1] + "-" + words[0];
		}
		String APIcall = "https://dog.ceo/api/breed/" + breedName + "/images/random";
		
		return parseJsonForURL(APIcall);
	}
	
	private String parseJsonForURL(String APIcall) {
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
