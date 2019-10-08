package com.psksoft.microservices.currencyexchangeservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psksoft.microservices.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangeValueRepository extends 
JpaRepository<ExchangeValue, Long>{

	ExchangeValue findByFromAndTo(String from, String to);
	
}
