package com.kishore.controller;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.models.CarBrands;

@RestController
public class BrandController {

	@Autowired
	private ProducerTemplate producerTemplate;

	@GetMapping(value = "/brand")
	public List<CarBrands> getAllBrands() {
		@SuppressWarnings("unchecked")
		List<CarBrands> brands = producerTemplate.requestBody("direct:select", null, List.class);
		return brands;
	}

}
