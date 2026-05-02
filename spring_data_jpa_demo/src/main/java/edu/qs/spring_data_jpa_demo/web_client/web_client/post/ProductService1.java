package edu.qs.spring_data_jpa_demo.web_client.web_client.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
@Service
public class ProductService1 {

	@Autowired
	private WebClient client;
	
	// to post single product
	public Products addProduct(Products prod) {
		return client
				.post()
				.uri("https://fakestoreapi.com/products")
				.bodyValue(prod)  // we are passing the product object
				.retrieve()
				.bodyToMono(Products.class) // because it return single data
				.block();
	}
	
	// to get single product
	
	public Products findProductsById(int id) {
		return client
				.get()
				.uri(
						UriBuilder -> UriBuilder
						.scheme("https")
						.host("fakestoreapi.com")
						.path("/products/{id}")
						.build(id)
					)
				.retrieve()
				.bodyToMono(Products.class)
				.block();
	}
}

	
