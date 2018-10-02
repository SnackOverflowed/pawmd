package com.pawmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pawmd.data.BreedInfo;
import com.pawmd.dataprovider.BreedListProvider;
import com.pawmd.dataprovider.ImageURLProvider;
import com.pawmd.data.BreedSearchItem;

@RestController
public class WebController {
	
	@Autowired
	private BreedListProvider breedListProvider;
	@Autowired
	private ImageURLProvider imageURLProvider;
	
	@RequestMapping(value = "/home/{breedName}", method = RequestMethod.GET)
	BreedInfo retrieveBreedInfo(@PathVariable("breedName") String breedName) {
		BreedInfo b = new BreedInfo();
		b.setBreedName("breed name: " + breedName);
		b.setFoodType("food type: orange chicken");
		b.setWalkTime("walk time: 25 hours a day");
		return b;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	List<BreedSearchItem> searchBreed() {
		return breedListProvider.getBreedList();
	}

	@RequestMapping(value = "/breedImageURL/{breedName}", method = RequestMethod.GET, produces="text/plain")
	String breedImageURL(@PathVariable("breedName") String breedName) {
		System.out.println(breedName);
		return imageURLProvider.getBreedImageURL(breedName);
	}
}
