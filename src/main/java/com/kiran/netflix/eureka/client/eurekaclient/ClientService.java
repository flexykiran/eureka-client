package com.kiran.netflix.eureka.client.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("rest/eureka/client")
public class ClientService {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/sayHello")
	public String sayHello() {
		String url = "http://sample-server/rest/eureka/server/hello";
		return restTemplate.getForObject(url, String.class);
	}
}
