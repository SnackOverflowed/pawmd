package com.pawmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pawmd.dataprovider.BreedListProvider;
import com.pawmd.dataprovider.ImageURLProvider;
import com.pawmd.dataprovider.MongoDataProvider;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App 
{
	
	@Bean
	public BreedListProvider breedListProvider() {
		BreedListProvider breedListProvider = new BreedListProvider();
		return breedListProvider;
	}
	
	@Bean
	public ImageURLProvider imageURLProvider() {
		ImageURLProvider imageURLProvider = new ImageURLProvider();
		return imageURLProvider;
	}
	
	@Bean
	public MongoDataProvider mongoDataProvider() {
		MongoDataProvider mongoDataProvider = new MongoDataProvider();
		return mongoDataProvider;
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
