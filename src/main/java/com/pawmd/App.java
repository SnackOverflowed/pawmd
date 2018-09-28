package com.pawmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pawmd.dataprovider.BreedListProvider;


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
	
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
