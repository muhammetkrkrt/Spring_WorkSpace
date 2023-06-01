package com.muhammet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muhammet.Repository.ICityRepository;
import com.muhammet.entities.City;

@Service
public class CityService implements ICityService{
	
	private ICityRepository cityRepository;
	
	@Autowired
	public CityService(ICityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Transactional
	public List<City> getAll() {
		
		return this.cityRepository.getAll();
	}

	@Override
	public void add(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(City city) {
		// TODO Auto-generated method stub
		
	}

}
