package com.ec.onlineplantnursery.plant.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.plant.entity.Plant;

public class CustomPlantRepositoryImpl implements CustomPlantRepository{

	@Autowired
	EntityManager entityManager; // Session of Hibernate
	
	
	@Override
	public Optional<Plant> getPlantByCommonName(String commonName) {
		
		Query q = entityManager.createQuery("from Plant where commonName=:commonName");
		q.setParameter("commonName", commonName);
		Plant s = (Plant) q.getSingleResult();
		Optional<Plant> s1 = Optional.of(s);
		return s1;
	}

	@Override
	public Optional<List<Plant>> getPlantsByTypeOfPlants(String ts) {
		
		Query q = entityManager.createQuery("from Plant where typeOfPlant=:plant");
		q.setParameter("plant", ts);
		return Optional.of(q.getResultList());
		
	}
}
