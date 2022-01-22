/**
 * 
 */
package com.ashish.microservice.currencyexchangeservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.microservice.currencyexchangeservice.bean.CurrencyExchange;
import com.ashish.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.ashish.microservice.currencyexchangeservice.service.CurrencyExchangeService;

/**
 * @author Ashish Gupta
 *
 */
@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{

	@Autowired
	CurrencyExchangeRepository currencyExchangeRep;
	
	public Optional<CurrencyExchange> findByFromAndTo(String from, String to) {
		return currencyExchangeRep.findByFromAndTo(from, to);
	}

}
