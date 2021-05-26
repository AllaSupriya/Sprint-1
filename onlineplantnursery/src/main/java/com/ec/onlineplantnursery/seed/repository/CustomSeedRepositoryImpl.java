package com.ec.onlineplantnursery.seed.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.seed.entity.Seed;



public class CustomSeedRepositoryImpl implements CustomSeedRepository{
	@Autowired
	EntityManager entityManager; // Session of Hibernate
	
	
	@Override
	public Seed getSeedByCommonName(String commonName) {
		
		Query q = entityManager.createQuery("from Seed where commonName=:commonName");
		q.setParameter("commonName", commonName);
		Seed s = (Seed) q.getSingleResult();
		return s;
	}

	@Override
	public List<Seed> getSeedsByTypeOfSeed(String ts) {
		
		Query q = entityManager.createQuery("from Seed where typeOfSeeds=:seeds");
		q.setParameter("seeds", ts);
		return q.getResultList();
		
	}
} 