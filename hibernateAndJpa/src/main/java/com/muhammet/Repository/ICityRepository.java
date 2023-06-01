package com.muhammet.Repository;

import java.util.List;

import com.muhammet.entities.City;

public interface ICityRepository {
	
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	
}
