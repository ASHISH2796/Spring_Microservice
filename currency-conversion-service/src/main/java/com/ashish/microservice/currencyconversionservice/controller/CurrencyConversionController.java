/**
 * 
 */
package com.ashish.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ashish.microservice.currencyconversionservice.bean.CurrencyConversion;
import com.ashish.microservice.currencyconversionservice.feignProxy.CurrencyExchangeProxy;

/**
 * @author Ashish Gupta
 *
 */

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retriveCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		Map<String,String> uriVariables = new HashMap();
		uriVariables.put("from",from );
		uriVariables.put("to",to );
		ResponseEntity<CurrencyConversion> response= new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
		CurrencyConversion objCurrencyConversion =response.getBody();
		objCurrencyConversion.setQuantity(quantity);
		BigDecimal calculatedAmount = objCurrencyConversion.getConversionMultiple().multiply(objCurrencyConversion.getQuantity());
		objCurrencyConversion.setTotalCalculatedAmount(calculatedAmount);
		return objCurrencyConversion;
	}
	
	@GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retriveCurrencyConversionUsingFeignClient(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		CurrencyConversion objCurrencyConversion =currencyExchangeProxy.retriveExchangeValue(from, to);
		objCurrencyConversion.setQuantity(quantity);
		BigDecimal calculatedAmount = objCurrencyConversion.getConversionMultiple().multiply(objCurrencyConversion.getQuantity());
		objCurrencyConversion.setTotalCalculatedAmount(calculatedAmount);
		return objCurrencyConversion;
	}
}
