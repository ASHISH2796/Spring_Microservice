/**
 * 
 */
package com.ashish.microservice.currencyexchangeservice.service;

import java.util.Optional;

import com.ashish.microservice.currencyexchangeservice.bean.CurrencyExchange;

/**
 * @author Ashish Gupta
 *
 */
public interface CurrencyExchangeService {
  
	Optional<CurrencyExchange> findByFromAndTo(String from , String to);
}
