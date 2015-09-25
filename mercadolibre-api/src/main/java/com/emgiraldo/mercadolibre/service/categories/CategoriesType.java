package com.emgiraldo.mercadolibre.service.categories;

public enum CategoriesType {
	
	COLOMBIA("MLC"), ARGENTINA("MLA");
	
	private String countryCode;
	
	CategoriesType(String countryCode){
		this.countryCode = countryCode;
	}
	
	public String getCountryCode(){
		return this.countryCode;
	}
}
