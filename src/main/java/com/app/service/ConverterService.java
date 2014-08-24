package com.app.service;

import java.math.BigDecimal;

public interface ConverterService {

	public BigDecimal convert(Integer amount, String currencyFrom, String currencyTo);
	
	public BigDecimal UahToEuroConvert(Integer amount);
	
	public BigDecimal UahToDollarConvert(Integer amount);
	
	public BigDecimal UahToEuroConvert(BigDecimal amount);
	
	public BigDecimal UahToDollarConvert(BigDecimal amount);
	
	public BigDecimal DollarToEuroConvert(Integer amount);
	
	public BigDecimal DollarToUahConvert(Integer amount);
	
	public BigDecimal EuroToDollarConvert(Integer amount);
	
	public BigDecimal EuroToUahConvert(Integer amount);

}
