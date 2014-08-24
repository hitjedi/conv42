package com.app.dao;

import com.app.model.Currency;

public interface CurrencyDAO {
	
	public void insert(Currency customer);
	
	public Currency findCurrencyByName(String name);
	
}




