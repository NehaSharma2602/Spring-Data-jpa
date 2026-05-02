package edu.qs.spring_data_jpa_demo.web_client.web_client.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class WebClientController2 {

	@Autowired
	ProductService1 service;
	
	@PostMapping("/webclient2/products")
	public ResponseEntity<Products> addProducts(@RequestBody Products prod ){
		Products prod1  = service.addProduct(prod);
		
		return new ResponseEntity<Products>(prod1, HttpStatus.OK);
	}
	
	@GetMapping("/webclient2/getproductsbyid/{id}")
	public ResponseEntity<Products> findProductsById(@PathVariable int id){
		Products prod  = service.findProductsById(id);
		
		return new ResponseEntity<Products>(prod, HttpStatus.FOUND);
	}
}
