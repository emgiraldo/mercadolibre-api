package com.emgiraldo.mercadolibre.service.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:mercadolibre.properties")
public class PropertiesService {
	
	@Autowired
	private Environment env;		
	
	public String getMercadolibreCategoriesUrl(){
		return env.getProperty(CATEGORIES_URL);
	}
	
	final String CATEGORIES_URL = "mercadolibre.url.categories";

}
