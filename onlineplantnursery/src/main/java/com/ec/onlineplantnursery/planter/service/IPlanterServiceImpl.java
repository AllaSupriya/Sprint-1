package com.ec.onlineplantnursery.planter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;
import com.ec.onlineplantnursery.plant.service.IPlantServiceImpl;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.IPlanterRepository;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;
import com.ec.onlineplantnursery.seed.service.SeedServiceImpl;


@Service
public class IPlanterServiceImpl implements IPlanterService{

	@Autowired
	IPlanterRepository repo;

	@Override
	public Planter addPlanter(Planter planter) {
		repo.save(planter);

		return planter;
	}

	@Override
	public Planter updatePlanter(Planter planter) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		Optional<Planter> os = repo.findById(planter.getPlanterId());
		if(os.isEmpty()) {
			throw new ResourceNotFoundException();
		}

		Planter p = repo.findById(planter.getPlanterId()).get();
		p.setPlanterheight(planter.getPlanterheight());
		p.setPlanterCapacity(planter.getPlanterCapacity());
		p.setDrinageHoles(planter.getDrinageHoles());
		p.setPlanterColor(planter.getPlanterColor());
		p.setPlanterShape(planter.getPlanterShape());
		p.setPlanterStock(planter.getPlanterStock());
		p.setPlanterCost(planter.getPlanterCost());
		return repo.save(p);
	}

	@Override
	public Planter deletePlanter(int planter) {
		// TODO Auto-generated method stub
		Planter p = repo.findById(planter).get();
		repo.delete(p);
		return p;

	}

	@Override
	public Planter viewPlanter(int planterId) throws ResourceNotFoundException{
		Optional<Planter> p = repo.findById(planterId);
		if(p.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		// TODO Auto-generated method stub
		return repo.findById(planterId).get();
	}

	@Override
	public Planter viewPlanter(String planterShape)throws ResourceNotFoundException {
		List<Planter> plist = repo.findAll();
		for(Planter p : plist) {
			if(p.getPlanterShape().equalsIgnoreCase(planterShape)) {
				return p;
			}
		}
		throw new ResourceNotFoundException();
	}

	@Override
	public List<Planter> viewAllPlanters() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) throws ResourceNotFoundException {
		List<Planter> planter = new ArrayList<Planter>();
		List<Planter> plist = repo.findAll();
		for(Planter p : plist) {
			if(p.getPlanterCost() >= minCost && p.getPlanterCost() <= maxCost) {
				planter.add(p);
			}
		}
		if(planter.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		return planter;
	}



}
