package com.muhammet.service;

import java.util.List;

import com.muhammet.entities.City;

public interface ICityService {
	
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
}
