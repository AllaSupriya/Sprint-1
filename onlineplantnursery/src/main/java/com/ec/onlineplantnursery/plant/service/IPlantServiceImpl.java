package com.ec.onlineplantnursery.plant.service;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;

@Service
public class IPlantServiceImpl implements IPlantService {
	
	@Autowired
	IPlantRepository repo;

	@Transactional
	@Override
	public Plant addPlant(Plant plant) {
		repo.save(plant);
		return plant;
	}

	@Override
	public Plant updatePlant(Plant plant) throws ResourceNotFoundException {
		Optional<Plant> op = repo.findById(plant.getPlantId());
		if(op.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		
		
		Plant existingPlant = repo.findById(plant.getPlantId()).get();
		
        existingPlant.setPlantId(plant.getPlantId());
        existingPlant.setPlantCost(plant.getPlantCost());
        existingPlant.setPlantDescription(plant.getPlantDescription());
        existingPlant.setPlantHeight(plant.getPlantHeight());
        existingPlant.setPlantSpread(plant.getPlantSpread());
        existingPlant.setPlantsStock(plant.getPlantsStock());
        existingPlant.setTypeOfPlant(plant.getTypeOfPlant());
        existingPlant.setBloomTime(plant.getBloomTime());
        existingPlant.setCommonName(plant.getCommonName());
        existingPlant.setDifficultyLevel(plant.getDifficultyLevel());
        existingPlant.setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
        existingPlant.setTemparature(plant.getTemparature());
       
		return repo.save(existingPlant);
	}

	@Override
	public Plant deletePlant(int plant) {
		Plant p = repo.findById(plant).get();
		repo.delete(p);
		return p;
	}

	@Override
	public Plant viewPlantById(int plantId) throws ResourceNotFoundException {
		Optional<Plant> op = repo.findById(plantId);
		if(op.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		
		Plant p = repo.findById(plantId).get();
		return p;
	}

	@Override
	public Plant viewPlant(String commonName) throws ResourceNotFoundException{
		List<Plant> plist = repo.findAll();
		for(Plant p : plist) {
			if(p.getCommonName().equalsIgnoreCase(commonName)) {
				return p;
			}
		}
		throw new ResourceNotFoundException();
	}

	@Override
	public List<Plant> viewAllPlants() {
		
		return repo.findAll();
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant)throws ResourceNotFoundException {
		List<Plant> plant = new ArrayList<Plant>();
		List<Plant> plist = repo.findAll();
		for(Plant p : plist) {
			if(p.getTypeOfPlant().equalsIgnoreCase(typeOfPlant)) {
				plant.add(p);
			}
		}
		if(plant.isEmpty()) throw new ResourceNotFoundException();
		return plant;
	}

}
