/**
 * 
 */
package com.ashish.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.microservice.currencyexchangeservice.bean.CurrencyExchange;
import com.ashish.microservice.currencyexchangeservice.service.CurrencyExchangeService;

/**
 * @author Ashish Gupta
 *
 */
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to ) {
		
		Optional<CurrencyExchange> currencyExchange = currencyExchangeService.findByFromAndTo(from, to);
		if(!currencyExchange.isPresent()) {
			throw new RuntimeException("Unable to get data for "+from+ " to "+ to);
		}
		currencyExchange.get().setEnvironment(env.getProperty("local.server.port"));
		return currencyExchange.get();
	}
}
