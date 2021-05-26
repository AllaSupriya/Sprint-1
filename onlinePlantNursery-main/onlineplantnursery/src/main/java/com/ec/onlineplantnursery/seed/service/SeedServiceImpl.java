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
	ISeedRepository repo;
	
	@Override
	@Transactional
	public Seed addSeed(Seed seed) {
		repo.save(seed);
		return seed;
	}

	@Override
	public Seed updateSeed(Seed seed) throws ResourceNotFoundException {
       Seed s = repo.findById(seed.getSeedId()).get();
       if(s==null) {
    	   throw new ResourceNotFoundException();
       }
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

		return repo.save(s);
	}

	@Override
	public Seed deleteSeed(int seed) {
		// TODO Auto-generated method stub
		Seed s = repo.findById(seed).get();
		repo.delete(s);
		return s;
	}

	@Override
	public Seed viewSeed(int seedId) throws SeedIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Seed> s = repo.findById(seedId);
		if(s.isEmpty()) {
			throw new SeedIdNotFoundException(seedId);
		}
		return repo.findById(seedId).get();
	}

	@Override
	public Seed viewSeed(String commonName) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		List<Seed> slist = repo.findAll();
		for(Seed p : slist) {
			if(p.getCommonName().equalsIgnoreCase(commonName)) {
				return p;
			}
		}
		throw new ResourceNotFoundException();
	}

	@Override
	public List<Seed> viewAllSeeds() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) throws ResourceNotFoundException{
		List<Seed> seed = new ArrayList<Seed>();
		List<Seed> slist = repo.findAll();
		for(Seed p : slist) {
			if(p.getTypeOfSeeds().equalsIgnoreCase(typeOfSeed)) {
				seed.add(p);
			}
		}
		if(seed.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		return seed;
	}

}