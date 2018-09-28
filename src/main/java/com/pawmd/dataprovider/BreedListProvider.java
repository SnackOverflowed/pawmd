package com.pawmd.dataprovider;

import org.springframework.web.client.RestTemplate;

import com.pawmd.data.BreedSearchItem;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class BreedListProvider {

	private final String uri = "https://dog.ceo/api/breeds/list/all";

	public List<BreedSearchItem> getBreedList() {

		List<BreedSearchItem> results = new ArrayList<>();

		RestTemplate restTemplate = new RestTemplate();
		String JSONresult = restTemplate.getForObject(uri, String.class);

		try {
			Object obj = new JSONParser().parse(JSONresult);
			JSONObject APIcallJsonObj = (JSONObject) obj;
			JSONObject messageJsonObj = (JSONObject) APIcallJsonObj.get("message");

			// printJsonObject(messageJsonObj, results);
			JsonObjectToList(messageJsonObj, results);
			// String s = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	private void JsonObjectToList(JSONObject jsonObj, List<BreedSearchItem> breedList) {
		for (Object key : jsonObj.keySet()) {
			String keyStr = (String) key;
			JSONArray keyvalue = (JSONArray) jsonObj.get(keyStr);

			if (keyvalue instanceof JSONArray && keyvalue.size() > 0) {
				for (int i = 0; i < keyvalue.size(); i++) {
					BreedSearchItem item = new BreedSearchItem();
					item.setBreedName(keyvalue.get(i) + " " + keyStr);
					breedList.add(item);
				}
			} else {
				BreedSearchItem item = new BreedSearchItem();
				item.setBreedName(keyStr);
				breedList.add(item);
			}

		}
	}

//	private void printJsonObject(JSONObject jsonObj, List<BreedSearchItem> breedList) {
//	    for (Object key : jsonObj.keySet()) {
//	        String keyStr = (String)key;
//	        Object keyvalue = jsonObj.get(keyStr);
//
//	        System.out.println("key: " + keyStr + " ---> value: " + keyvalue);	   
//		}
//	}
}
