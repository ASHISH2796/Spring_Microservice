/**
 * 
 */
package com.ashish.microservice.currencyconversionservice.feignProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashish.microservice.currencyconversionservice.bean.CurrencyConversion;


/**
 * @author Ashish Gupta
 *
 */
//@FeignClient(name="currency-exchange-service",url="localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyConversion retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
