package com.muhammet.Repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.muhammet.entities.City;

import jakarta.persistence.EntityManager;



//JPA ORM 
@Repository
public class HibernateCityRepository implements ICityRepository {

	private EntityManager entityManager;
	
	@Autowired
	public HibernateCityRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
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
