package com.ec.onlineplantnursery.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;
import org.junit.jupiter.api.function.Executable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;
import com.ec.onlineplantnursery.plant.service.IPlantServiceImpl;

@SpringBootTest
class PlantRepositoryTest {

	IPlantRepository plantRepo;
	private static IPlantServiceImpl plantService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit()
	{
		plantRepo = mock(IPlantRepository.class); // test through approach 2
		plantService = new  IPlantServiceImpl(plantRepo); 	// Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}

	@Test
	void testSavePlant() {
		Plant input = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);
		Plant savedPlant = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);

		when(plantRepo.save(input)).thenReturn(savedPlant);
		plantService.addPlant(input);
		verify(plantRepo).save(input);

	}


	@Test
	@DisplayName("Test-Get All Plants , Args:- No Args to pass")
	void testGetAllPlants() {


		List<Plant> plantList = mock(List.class); 
		//when() and 	//thenReturn()
		when(plantRepo.findAll()).thenReturn(plantList);
		//call the actual method 
		plantService.viewAllPlants();
		//verify
		verify(plantRepo).findAll();

	}

	@Test
	@DisplayName("Test-Get Seed by Id , Args:- No Args to pass")
	void testViewPlantById() throws ResourceNotFoundException{


		Optional<Plant> s = Optional.empty();
		//when() and 	//thenReturn()
		when(plantRepo.findById(2)).thenReturn(s);
		Executable executable = ()->plantService.viewPlantById(2);
		assertThrows(ResourceNotFoundException.class, executable);

	}

	@Test
	@DisplayName("Test-Get Plant by common Name , Args:- No Args to pass")
	void testViewPlantByName() throws ResourceNotFoundException {


		String commonName = "abcd";
		Optional<Plant> s = Optional.empty();
		when(plantRepo.getPlantByCommonName(commonName)).thenReturn(s);
		Executable executable = ()->plantService.viewPlant(commonName);
		assertThrows(ResourceNotFoundException.class, executable);

	}

	@Test
	@DisplayName("Test-Get Plant by type of plant , Args:- No Args to pass")
	void testViewPlantByTypeOfPlant() throws ResourceNotFoundException {


		String typeOfPlant = "Flower";
		Optional<List<Plant>> plantList = Optional.empty(); 
		//when() and 	//thenReturn()
		when(plantRepo.getPlantsByTypeOfPlants(typeOfPlant)).thenReturn(plantList);
		//call the actual method 
		Executable executable = ()->plantService.viewAllPlants(typeOfPlant);
		assertThrows(ResourceNotFoundException.class, executable);

	}

	@Test
	@DisplayName("Test-Delete plant , Args:- No Args to pass")
	void testDeletePlant() {

		Plant input = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);
		Plant savedPlant = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);

		doNothing().
		 when(plantRepo).deleteById(input.getPlantId());;

		plantService.deletePlant(input.getPlantId());

		verify(plantRepo).deleteById(input.getPlantId());;
		assertEquals(input,savedPlant);
		  
	}

	@Test
	@DisplayName("Test-Update plant , Args:- No Args to pass")
	void testUpdatePlant() throws ResourceNotFoundException {
		Plant input = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);
		Plant savedPlant = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);

		when(plantRepo.save(input)).thenReturn(savedPlant);
		plantService.updatePlant(input);
		verify(plantRepo).save(input);
		assertEquals(input,savedPlant);

	}


}