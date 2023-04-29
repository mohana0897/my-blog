package com.ssd.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class SsdblogApplication {

	@Bean
	public ModelMapper modelmaper() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate resttemplate() {
		
		return new RestTemplate();
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SsdblogApplication.class, args);
		
		
	}

}
