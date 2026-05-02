package edu.qs.spring_data_jpa_demo.web_client.web_client.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService {

	@Autowired
	WebClient client;
	
	
	public List<User> getAllUsers(){
		return client
				.get() //method type is get
				.uri("https://jsonplaceholder.typicode.com/users") // the api link
				.retrieve() // basically it is like send command of postman
				.bodyToFlux(User.class) // we are getting many properties so we use flux if single data is there we can use mono
				.collectList() //to collecting all the data
				.block();// this will stop the furthur execution until the 3rd part api returns the response
	}
}
