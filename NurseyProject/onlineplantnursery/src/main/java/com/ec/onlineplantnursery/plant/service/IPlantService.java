package com.ec.onlineplantnursery.plant.service;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;

public interface IPlantService {
	Plant addPlant(Plant plant);

	Plant updatePlant(Plant plant) throws ResourceNotFoundException;

	Optional<Plant> deletePlant(int pid);

	Optional<Plant> viewPlantById(int plantId) throws ResourceNotFoundException;

	Optional<Plant> viewPlant(String commonName) throws ResourceNotFoundException;

	List<Plant> viewAllPlants();

	Optional<List<Plant>> viewAllPlants(String typeOfPlant) throws ResourceNotFoundException;
}
