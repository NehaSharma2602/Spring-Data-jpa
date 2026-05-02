package edu.qs.spring_data_jpa_demo.web_client.web_client.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebClientController {

	
	@Autowired
	UserService service;
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/webclient/client")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = service.getAllUsers();
		
		return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
	}
	
	
	
	@GetMapping("/webClient/products")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> product = pservice.getAllProducts();
		
		return new ResponseEntity<List<Products>>(product, HttpStatus.FOUND);
	}
}
