package com.psksoft.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConverionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionMultiple;
	private BigDecimal totalAmmountAfterCalcualtion;
	private int port;
	
	protected CurrencyConverionBean() {
		
	}
	
	public CurrencyConverionBean(long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			BigDecimal totalAmmountAfterCalcualtion, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple= conversionMultiple;
		this.totalAmmountAfterCalcualtion = totalAmmountAfterCalcualtion;
		this.port = port;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalAmmountAfterCalcualtion() {
		return totalAmmountAfterCalcualtion;
	}
	public void setTotalAmmountAfterCalcualtion(BigDecimal totalAmmountAfterCalcualtion) {
		this.totalAmmountAfterCalcualtion = totalAmmountAfterCalcualtion;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
	
	
}
