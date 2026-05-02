package edu.qs.spring_data_jpa_demo.web_client.web_client.get;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProductService {

	@Autowired
	WebClient client;
	
	
	public List<Products> getAllProducts(){
		List<Products> prod =  client
				.get() //method type is get
				.uri("https://fakestoreapi.com/products") // the api link
				.retrieve() // basically it is like send command of postman
				.bodyToFlux(Products.class) // we are getting many properties so we use flux if single data is there we can use mono
				.collectList() //to collecting all the data
				.block();// this will stop the furthur execution until the 3rd part api returns the response
		
		List<Products> filter = new ArrayList<>();

	    for (Products p : prod) {
	        if (p.getPrice() != null && p.getPrice() > 500) {
	            filter.add(p);
	        }
	    }

	    return filter;
		
		
			
			
				
	}
}
