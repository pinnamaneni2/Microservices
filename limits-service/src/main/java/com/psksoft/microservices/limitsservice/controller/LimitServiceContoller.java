package com.psksoft.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psksoft.microservices.limitsservice.bean.LimitServiceBean;
import com.psksoft.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitServiceContoller {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitServiceBean retrieveLimits() {
		
		return new LimitServiceBean(configuration.getMaximum(),configuration.getMinimum());
	}
}
