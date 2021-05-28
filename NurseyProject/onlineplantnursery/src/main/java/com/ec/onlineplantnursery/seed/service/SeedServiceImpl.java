package com.ec.onlineplantnursery.seed.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;

@Service
public class SeedServiceImpl implements ISeedService{

	
	@Autowired
	ISeedRepository srepo;
	
	public SeedServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SeedServiceImpl(ISeedRepository srepo) {
		// TODO Auto-generated constructor stub
		this.srepo = srepo;
	}

	@Override
	@Transactional
	public Seed addSeed(Seed seed) {
		srepo.save(seed);
		return seed;
	}

	@Override
	@Transactional
	public Seed updateSeed(Seed seed) throws ResourceNotFoundException {
		Optional<Seed> os = srepo.findById(seed.getSeedId());
		if(os.isEmpty()) {
	    	   throw new ResourceNotFoundException();
	    }
		
       Seed s = srepo.findById(seed.getSeedId()).get();
       
       s.setBloomTime(seed.getBloomTime());
       s.setCommonName(seed.getCommonName());
       s.setDifficultyLevel(seed.getDifficultyLevel());
       s.setSeedsCost(seed.getSeedsStock());
       s.setSeedsDescription(seed.getSeedsDescription());
       s.setSeedsPerPacket(seed.getSeedsPerPacket());
       s.setSeedsStock(seed.getSeedsStock());
       s.setTemparature(seed.getTemparature());
       s.setTypeOfSeeds(seed.getTypeOfSeeds());
       s.setWatering(seed.getWatering());

       
	   return srepo.save(s);
	}

	@Override
	@Transactional
	public Optional<Seed> deleteSeed(int seed) {
		// TODO Auto-generated method stub
		Optional<Seed> s = srepo.findById(seed);
		srepo.deleteById(seed);
		return s;
	}

	@Override
	public Optional<Seed> viewSeed(int seedId) throws SeedIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Seed> s = srepo.findById(seedId);
		if(s.isEmpty()) {
			throw new SeedIdNotFoundException(seedId);
		}
		return srepo.findById(seedId);
	}

	@Override
	public Optional<Seed> viewSeed(String commonName) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		Optional<Seed> s11 = srepo.getSeedByCommonName(commonName);
		
		if(s11.isEmpty()) throw new ResourceNotFoundException();
		
		return s11;
		
	}

	@Override
	public List<Seed> viewAllSeeds() {
		// TODO Auto-generated method stub
		return srepo.findAll();
	}

	@Override
	public Optional<List<Seed>> viewAllSeeds(String typeOfSeeds) throws ResourceNotFoundException{
		Optional<List<Seed>> s11 = srepo.getSeedsByTypeOfSeed(typeOfSeeds);
		Optional<List<Seed>> s = srepo.getSeedsByTypeOfSeed(typeOfSeeds);
		
		if(s.isEmpty()) throw new ResourceNotFoundException();
		
		return s11;
	}

}