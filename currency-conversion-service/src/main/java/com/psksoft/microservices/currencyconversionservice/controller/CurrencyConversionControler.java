package com.psksoft.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.psksoft.microservices.currencyconversionservice.CuurencyExchangeProxy;
import com.psksoft.microservices.currencyconversionservice.bean.CurrencyConverionBean;

@RestController
public class CurrencyConversionControler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CuurencyExchangeProxy Proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		/*Feign makes rest_calls  easy*/
		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);

		ResponseEntity<CurrencyConverionBean> ResponseEntity = new RestTemplate().getForEntity(
				"http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConverionBean.class,
				uriVariable);
		CurrencyConverionBean responseFromCurrencyExchange = ResponseEntity.getBody();
		logger.info("******"+responseFromCurrencyExchange.getConversionMultiple());
		return new CurrencyConverionBean(responseFromCurrencyExchange.getId(), from, to, quantity,
				responseFromCurrencyExchange.getConversionMultiple(),
				quantity.multiply(responseFromCurrencyExchange.getConversionMultiple()),
				responseFromCurrencyExchange.getPort());
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		/*Feign makes rest_calls  easy*/
		CurrencyConverionBean responseFromCurrencyExchange = Proxy.retriveExchangeValue(from, to);
		logger.info("******"+responseFromCurrencyExchange.toString());
		return new CurrencyConverionBean(responseFromCurrencyExchange.getId(), from, to, quantity,
				responseFromCurrencyExchange.getConversionMultiple(),
				quantity.multiply(responseFromCurrencyExchange.getConversionMultiple()),
				responseFromCurrencyExchange.getPort());
	}
}
