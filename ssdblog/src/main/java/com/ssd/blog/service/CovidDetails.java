package com.ssd.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ssd.blog.model.Root;

@Service
public class CovidDetails {

	@Autowired
	private RestTemplate restTemplate;

	public Root getAllDetails() {

		String api = "https://api.publicapis.org/entries";
		
		Root dto = restTemplate.getForObject(api, Root.class);

		return dto;

	}

}
