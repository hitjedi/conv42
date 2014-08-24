package com.app.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.view.CurrencyViewModel;
import com.app.service.ConverterServiceImpl;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		ConverterServiceImpl converterServiceImpl = new ConverterServiceImpl();

		model.addAttribute("euroSell", converterServiceImpl.getEuroSell());
		
		model.addAttribute("euroBuy", converterServiceImpl.getEuroBuy());
		
		model.addAttribute("dollarSell", converterServiceImpl.getUsdSell());
		
		model.addAttribute("dollarBuy", converterServiceImpl.getUsdBuy());
		
		return "home";
	
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(CurrencyViewModel order, Model model, @RequestParam(required = true) Integer amount, @RequestParam("dropDownFrom") String currencyFrom, @RequestParam("dropDownTo") String currencyTo) {
		
		ConverterServiceImpl converterServiceImpl = new ConverterServiceImpl();
		
		BigDecimal result = converterServiceImpl.convert(amount, currencyFrom, currencyTo);
		
		model.addAttribute("euroSell", converterServiceImpl.getEuroSell());
		
		model.addAttribute("euroBuy", converterServiceImpl.getEuroBuy());
		
		model.addAttribute("dollarSell", converterServiceImpl.getUsdSell());
		
		model.addAttribute("dollarBuy", converterServiceImpl.getUsdBuy());
		
		model.addAttribute("amount", amount);
	
		model.addAttribute("result", result);
				
		model.addAttribute("order", order);
		
		return "home";
	}
	
	@ModelAttribute(value="order")
	public CurrencyViewModel buildInitialOrder() {
		
	    CurrencyViewModel order = new CurrencyViewModel();

	    return order;
	}
	
}
