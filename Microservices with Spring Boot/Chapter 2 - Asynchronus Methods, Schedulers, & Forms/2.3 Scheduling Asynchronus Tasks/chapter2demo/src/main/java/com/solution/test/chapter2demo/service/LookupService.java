package com.solution.test.chapter2demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.solution.test.chapter2demo.model.User;

import java.util.concurrent.CompletableFuture;

@Service
public class LookupService {

	private static final Logger logger = LoggerFactory.getLogger(LookupService.class);
	
	private static final String GITHUB_URL = "https://api.github.com/users/%s";
	
	private final RestTemplate restTemplate;
	
	public LookupService(RestTemplateBuilder restTemplateBuilder) {
		
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Async
	public CompletableFuture<User> findUser(String user) throws InterruptedException {
		
		logger.info("Looking up "+user);
		
		String url = String.format(GITHUB_URL, user);
		
		User results = restTemplate.getForObject(url, User.class);
		
		Thread.sleep(4000L);
		
		return CompletableFuture.completedFuture(results);			
	} 
	
}
