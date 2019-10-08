package com.psksoft.microservices.limitsservice.bean;

public class LimitServiceBean {

	private String maxValue;
	private String minValue;
	
	
	protected LimitServiceBean() {
	}
	public LimitServiceBean(String maxValue, String minValue) {
		super();
		this.maxValue = maxValue;
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	
	
	
	
	
	
	
}
