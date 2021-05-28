package com.ec.onlineplantnursery.plant.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;
import com.ec.onlineplantnursery.seed.entity.Seed;

@Service
public class IPlantServiceImpl implements IPlantService {

	@Autowired
	IPlantRepository repo;

	public IPlantServiceImpl(IPlantRepository repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}

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
	public Optional<Plant> deletePlant(int plant) {
		Optional<Plant> p = repo.findById(plant);
		repo.deleteById(plant);
		return p;
	}

	@Override
	public Optional<Plant> viewPlantById(int plantId) throws ResourceNotFoundException {
		Optional<Plant> op = repo.findById(plantId);
		if(op.isEmpty()) {
			throw new ResourceNotFoundException();
		}

		return op;
	}

	@Override
	public Optional<Plant> viewPlant(String commonName) throws ResourceNotFoundException{
		Optional<Plant> s11 = repo.getPlantByCommonName(commonName);

		if(s11.isEmpty()) throw new ResourceNotFoundException();

		return s11;
	}

	@Override
	public List<Plant> viewAllPlants() {

		return repo.findAll();
	}

	@Override
	public Optional<List<Plant>> viewAllPlants(String typeOfPlant)throws ResourceNotFoundException {
		Optional<List<Plant>> s11 = repo.getPlantsByTypeOfPlants(typeOfPlant);

		if(s11.isEmpty()) throw new ResourceNotFoundException();

		return s11;
	}

}
