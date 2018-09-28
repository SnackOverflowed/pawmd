package com.pawmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pawmd.data.BreedInfo;
import com.pawmd.dataprovider.BreedListProvider;
import com.pawmd.data.BreedSearchItem;

@RestController
public class WebController {
	
	@Autowired
	private BreedListProvider breedListProvider;
	
	@RequestMapping(value = "/home/{breedName}", method = RequestMethod.GET)
	BreedInfo retrieveBreedInfo(@PathVariable("breedName") String breedName) {
		BreedInfo b = new BreedInfo();
		b.setBreedName("breed name: " + breedName);
		b.setFoodType("food type: orange chicken");
		b.setWalkTime("walk time: 23 hours a day");
		return b;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	List<BreedSearchItem> searchBreed() {
		return breedListProvider.getBreedList();
	}

}
