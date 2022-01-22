/**
 * 
 */
package com.ashish.microservice.currencyexchangeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.microservice.currencyexchangeservice.bean.CurrencyExchange;

/**
 * @author Ashish Gupta
 *
 */
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	Optional<CurrencyExchange> findByFromAndTo(String from , String to);
}
