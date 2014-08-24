package com.app.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.app.dao.CurrencyDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Currency;

public class ConverterServiceImpl implements ConverterService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
	    
	CurrencyDAO currencyDAO = (CurrencyDAO) context.getBean("currencyDAO");
	
	private Currency UAH = currencyDAO.findCurrencyByName("UAH");	
	private Currency USD = currencyDAO.findCurrencyByName("USD");	
	private Currency EUR = currencyDAO.findCurrencyByName("EUR");	
		
	private final double DOLLAR_BUY_RATE = USD.getBuyRate();
	private final double DOLLAR_SELL_RATE = USD.getSellRate();
	
	private final double EURO_BUY_RATE = EUR.getBuyRate();
	private final double EURO_SELL_RATE = EUR.getSellRate();
		
	private BigDecimal result;
	
	public double getUsdBuy(){
		
		return USD.getBuyRate();
		
	}
	
	public double getUsdSell(){
		
		return USD.getSellRate();
		
	}
	
	public double getEuroBuy(){
		
		return EUR.getBuyRate();
		
	}
	
	public double getEuroSell(){
		
		return EUR.getSellRate();
		
	}
		
	public ConverterServiceImpl() {
	}

	public BigDecimal UahToEuroConvert(Integer amount) {
		
		result = (BigDecimal.valueOf(amount / EURO_SELL_RATE).setScale(2, RoundingMode.UP));
		
		return result;
		
	}
	
	public BigDecimal UahToEuroConvert(BigDecimal amount) {
		
		result = amount.divide(BigDecimal.valueOf(EURO_SELL_RATE), 2, RoundingMode.UP);

		return result;
		
	}
	
	public BigDecimal UahToDollarConvert(Integer amount) {
		
		result = (BigDecimal.valueOf(amount / DOLLAR_SELL_RATE).setScale(2, RoundingMode.UP));
		
		return result;
		
	}
	
	public BigDecimal UahToDollarConvert(BigDecimal amount) {

		result = amount.divide(BigDecimal.valueOf(DOLLAR_SELL_RATE), 2, RoundingMode.UP);
		
		return result;
		
	}

	public BigDecimal DollarToEuroConvert(Integer amount) {

		BigDecimal resultOfBuy = DollarToUahConvert(amount);
		
		result = (UahToEuroConvert(resultOfBuy).setScale(2, RoundingMode.UP));
		
		return result;
		
	}

	public BigDecimal DollarToUahConvert(Integer amount) {

		result = (BigDecimal.valueOf(amount * DOLLAR_BUY_RATE).setScale(2, RoundingMode.UP));
		
		return result;
		
	}

	public BigDecimal EuroToDollarConvert(Integer amount) {
		
		BigDecimal resultOfBuy = EuroToUahConvert(amount);
		
		result = (UahToDollarConvert(resultOfBuy).setScale(2, RoundingMode.UP));
		
		return result;
		
	}

	public BigDecimal EuroToUahConvert(Integer amount) {

		result = (BigDecimal.valueOf(amount * EURO_BUY_RATE).setScale(2, RoundingMode.UP));
		
		return result;
		
	}

	@Override
	public BigDecimal convert(Integer amount, String currencyFrom,
			String currencyTo) {

		if (amount != null) {
			
			//from UAH to USD
			if (currencyFrom.equals(UAH.getName()) && currencyTo.equals(USD.getName())) {
				
				result = UahToDollarConvert(amount);
				
				return result;
			
			//from UAH to EUR
			} else if (currencyFrom.equals(UAH.getName()) && currencyTo.equals(EUR.getName())) {
				
				result = UahToEuroConvert(amount);
				
				return result;
			
			//from USD to EUR
			} else if (currencyFrom.equals(USD.getName()) && currencyTo.equals(EUR.getName())) {
				
				result = DollarToEuroConvert(amount);
				
				return result;
				
			//from USD to UAH
			} else if (currencyFrom.equals(USD.getName()) && currencyTo.equals(UAH.getName())) {
				
				result = DollarToUahConvert(amount);
				
				return result;
				
			//from EUR to USD
			} else if (currencyFrom.equals(EUR.getName()) && currencyTo.equals(USD.getName())) {
				
				result = EuroToDollarConvert(amount);
				
				return result;
				
			//from EUR to UAH		
			} else if (currencyFrom.equals(EUR.getName()) && currencyTo.equals(UAH.getName())) {
					
				result = EuroToUahConvert(amount);
				
				return result;

			} else if ((currencyFrom.equals(UAH.getName()) && currencyTo.equals(UAH.getName()))
					|| (currencyFrom.equals(USD.getName()) && currencyTo.equals(USD.getName()))
					|| (currencyFrom.equals(EUR.getName()) && currencyTo.equals(EUR.getName())))  { 
				
				result = BigDecimal.valueOf(amount);

				return result;
	
			
			}
		
		}
		
		return result;

	}
	
}
	
