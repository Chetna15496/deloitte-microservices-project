package com.deloitte.currency.conversion.service.model;

public class ConversionBean {

	
	
	int id;
	String fromCur;
	String toCur;
	float exchangeValue;
	int port;
	float total;
	float quantity;
	
	public ConversionBean()
	{
		
	}
	
	public ConversionBean(int id, String fromCur, String toCur, float exchangeValue, int port, float total,
			float quantity) {
		super();
		this.id = id;
		this.fromCur = fromCur;
		this.toCur = toCur;
		this.exchangeValue = exchangeValue;
		this.port = port;
		this.total = total;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromCur() {
		return fromCur;
	}
	public void setFromCur(String fromCur) {
		this.fromCur = fromCur;
	}
	public String getToCur() {
		return toCur;
	}
	public void setToCur(String toCur) {
		this.toCur = toCur;
	}
	public float getExchangeValue() {
		return exchangeValue;
	}
	public void setExchangeValue(float exchangeValue) {
		this.exchangeValue = exchangeValue;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
	
}
