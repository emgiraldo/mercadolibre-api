package com.emgiraldo.mercadolibre.service.categories;

public enum CountryCodes {
	
	COLOMBIA("MLC"), ARGENTINA("MLA");
	
	private String countryCode;
	
	CountryCodes(String countryCode){
		this.countryCode = countryCode;
	}
	
	public String getCountryCode(){
		return this.countryCode;
	}
}
