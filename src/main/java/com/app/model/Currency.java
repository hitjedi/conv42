package com.app.model;

public class Currency {

	private Integer id;
	private Double buyRate;
	
	private Double sellRate;
	private String name;
	
	public Currency() {
	}
	
	public Currency(Integer id, Double buyRate, Double sellRate, String name) {

		this.id = id;
		
		this.buyRate = buyRate;
		
		this.sellRate = sellRate;
		
		this.name = name;
		
	}
	
	public Double getSellRate() {
		return sellRate;
	}
	public void setSellRate(Double sellRate) {
		this.sellRate = sellRate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getBuyRate() {
		return buyRate;
	}
	public void setBuyRate(Double buyRate) {
		this.buyRate = buyRate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
