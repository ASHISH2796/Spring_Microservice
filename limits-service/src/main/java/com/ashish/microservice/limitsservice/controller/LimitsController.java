package com.ashish.microservice.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.microservice.limitsservice.bean.Limits;
import com.ashish.microservice.limitsservice.configuration.LimitServiceConfig;

/**
 * @author Ashish Gupta
 *
 */
@RestController
public class LimitsController {

	@Autowired
	private LimitServiceConfig objLimitServiceConfig;
	
	@GetMapping("/limits")
	public Limits retriveLimits() {
		return new Limits(objLimitServiceConfig.getMinimum(),objLimitServiceConfig.getMaximum());
	}
}
