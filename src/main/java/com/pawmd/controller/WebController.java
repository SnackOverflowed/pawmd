package com.pawmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pawmd.data.BreedInfo;
import com.pawmd.data.BreedNameAndURL;
import com.pawmd.dataprovider.BreedListProvider;
import com.pawmd.dataprovider.ImageURLProvider;
import com.pawmd.dataprovider.MongoDataProvider;
import com.pawmd.data.BreedSearchItem;

@RestController
public class WebController {
	
	@Autowired
	private BreedListProvider breedListProvider;
	@Autowired
	private ImageURLProvider imageURLProvider;
	@Autowired
	private MongoDataProvider mongoDataProvider;
	
	
	@RequestMapping(value = "/home/{breedName}", method = RequestMethod.GET)
	BreedInfo retrieveBreedInfo(@PathVariable("breedName") String breedName) {
		return mongoDataProvider.getBreedInfo(breedName);
		//return new BreedInfo();
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	List<BreedSearchItem> searchBreed() {
		return breedListProvider.getBreedList();
	}

	@RequestMapping(value = "/breedImageURL/{breedName}", method = RequestMethod.GET)
	BreedNameAndURL breedImageURL(@PathVariable("breedName") String breedName) {
		return imageURLProvider.getBreedImageURL(breedName);
	}
}
