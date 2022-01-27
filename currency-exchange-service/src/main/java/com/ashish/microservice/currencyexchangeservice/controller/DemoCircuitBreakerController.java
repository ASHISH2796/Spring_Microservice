/**
 * 
 */
package com.ashish.microservice.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

/**
 * @author Ashish Gupta
 *
 */
@RestController
public class DemoCircuitBreakerController {

	private Logger log =LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/demo-api")
	//@Retry(name="default")
	@Retry(name="demo-api",fallbackMethod="defaultfallbackMethod")
	//@CircuitBreaker(name="default",fallbackMethod="defaultfallbackMethod")
	//@RateLimiter(name="default")
	//@Bulkhead(name="default")
	public String demoMethod() {
		
		log.info("inside demoMethod");
		ResponseEntity<String> response=new RestTemplate().getForEntity("http://localhost:8989/demo", String.class);
		
		return response.getBody();
	}
	
	private String defaultfallbackMethod(Exception exc) {
		return "default fallback response";	
	}
}
