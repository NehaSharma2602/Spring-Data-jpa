package edu.qs.spring_data_jpa_demo.web_client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	public WebClient getWebClient() {
		 return WebClient.builder().build(); // retrun the object of class which implementing webclient
	}
}
