package com.spring.rest.consume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class ServiceController {

	@Autowired
	RestTemplate restTemplate;

	
	@Value("${operations.restURL}")
	String serviceURL;


	//Consuming a service by GET method
	@GetMapping("/availableOperations")
	String getAvailableOperations() {
		return restTemplate.getForObject(serviceURL, String.class);
	}

	/**
	 Consuming a service by postForObject method, this method is exposed as a get operation if user doesn't
	 post a request object we will create a new request and post it to the URL/service endpoint
	 */
	@GetMapping("/availability")
	String getAvailability() {
		return restTemplate.postForObject(serviceURL, createAvailabilityRequest(), String.class);
	}

	/**
	 Consuming a service by postForEntity method, this method is exposed as a post operation if user 
	 post a request object(JSON) it will be automatically mapped to Request parameter.
	 */
	@PostMapping("/availability")
	public String postAvailability(@RequestBody Availability availabilityRequest) {
		
		ResponseEntity<String> response = restTemplate.postForEntity(serviceURL, availabilityRequest,
				String.class);
		return response.getBody();
	}

	 

	private Object createAvailabilityRequest() {
		AddOnAvailability addOnAvailability = new AddOnAvailability();
		addOnAvailability.setCheckInDate("09/14/2017");
		addOnAvailability.setCheckOutDate("09/16/2017");
		addOnAvailability.setItemCode("");
		addOnAvailability.setAddOnCategory("10");
		return addOnAvailability;
	}

	 
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

}
