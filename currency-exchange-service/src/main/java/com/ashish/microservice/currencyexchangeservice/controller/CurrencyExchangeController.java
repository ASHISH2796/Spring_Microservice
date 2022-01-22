/**
 * 
 */
package com.ashish.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.microservice.currencyexchangeservice.bean.CurrencyExchange;

/**
 * @author Ashish Gupta
 *
 */
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to ) {
		CurrencyExchange currencyExchange = new CurrencyExchange(1001L, from, to, BigDecimal.valueOf(75));
		currencyExchange.setEnvironment(env.getProperty("local.server.port"));
		return currencyExchange;
	}
}
