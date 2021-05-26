package com.ec.onlineplantnursery.plant.service;

import java.util.List;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;

public interface IPlantService {
	Plant addPlant(Plant plant);

	Plant updatePlant(Plant plant) throws ResourceNotFoundException;

	Plant deletePlant(int pid);

	Plant viewPlantById(int plantId) throws ResourceNotFoundException;

	Plant viewPlant(String commonName) throws ResourceNotFoundException;

	List<Plant> viewAllPlants();

	List<Plant> viewAllPlants(String typeOfPlant) throws ResourceNotFoundException;
}
