package com.emgiraldo.mercadolibre.controller.categories;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emgiraldo.mercadolibre.controller.dto.Response;
import com.emgiraldo.mercadolibre.service.categories.CountryCodes;
import com.emgiraldo.mercadolibre.service.categories.ICategoriesService;
import com.emgiraldo.mercadolibre.service.categories.dto.CategoryDTO;
import com.emgiraldo.mercadolibre.service.exceptions.ServiceException;

@Controller
public class CategoriesController {
	
	@Autowired
	private ICategoriesService categoryService;
	
	private static final Logger logger = Logger.getLogger(CategoriesController.class);
	
	@RequestMapping(value = "/categories/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Object getListOfCategoriesByCountryId(
			@RequestParam(value = "countryId", required = true) String countryId){
		
		CountryCodes countryCode = null;
		
		if(countryId.equals(CountryCodes.COLOMBIA.getCountryCode())){
			countryCode = CountryCodes.COLOMBIA;
		}else if(countryId.equals(CountryCodes.ARGENTINA.getCountryCode())){
			countryCode = CountryCodes.ARGENTINA;
		}
		List<CategoryDTO> listOfCategories = new ArrayList<>();
		try{
			listOfCategories = categoryService.getListOfCategoriesByCountryCode(countryCode);
		}catch(ServiceException e){
			logger.error("Controller Exception caused by "+e.getMessage());
			return new Response(false, e.getMessage(), listOfCategories);
		}
		return new Response(false, "Successfull", listOfCategories);
	}

}
