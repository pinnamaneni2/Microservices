package com.psksoft.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.psksoft.microservices.currencyconversionservice.bean.CurrencyConverionBean;

/*@FeignClient(name="currency-exchange-service")*/
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CuurencyExchangeProxy {
	
	/*@GetMapping("/currency-exchange/from/{from}/to/{to}")*/
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConverionBean retriveExchangeValue(@PathVariable("from") String from, 
			@PathVariable("to") String to); 
}
