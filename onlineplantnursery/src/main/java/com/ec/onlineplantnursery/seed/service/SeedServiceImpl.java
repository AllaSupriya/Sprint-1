package com.ec.onlineplantnursery.seed.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;

@Service
public class SeedServiceImpl implements ISeedService{

	
	@Autowired
	ISeedRepository repo;
	
	public SeedServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public SeedServiceImpl(ISeedRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	@Transactional
	public Seed addSeed(Seed seed) {
		repo.save(seed);
		return seed;
	}

	@Override
	public Seed updateSeed(Seed seed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed deleteSeed(Seed seed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed viewSeed(int seedId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed viewSeed(String commonName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seed> viewAllSeeds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) {
		// TODO Auto-generated method stub
		return null;
	}

}