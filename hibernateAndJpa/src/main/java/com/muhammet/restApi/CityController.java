package com.muhammet.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammet.entities.City;
import com.muhammet.service.ICityService;

@RestController
@RequestMapping("/api")
public class CityController {

	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	} 
	
	@GetMapping("/cities")
	public List<City> get(){
		
		return cityService.getAll();
	}
}
