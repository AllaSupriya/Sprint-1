package com.ec.onlineplantnursery.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;
import com.ec.onlineplantnursery.seed.service.SeedServiceImpl;

@SpringBootTest
class SeedRepositoryTest {

	ISeedRepository seedRepo;
	private static SeedServiceImpl seedService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit()
	{
		seedRepo = mock(ISeedRepository.class); // test through approach 2
		seedService = new  SeedServiceImpl(seedRepo); 	// Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}

	@Test
	@Disabled
	void testSaveSeed() {
		Seed input = new Seed(101,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",200,300,2000);
		Seed savedSeed = new Seed(101,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",200,300,2000);

		when(seedRepo.save(input)).thenReturn(savedSeed);
		seedService.addSeed(input);
		verify(seedRepo).save(input);

	}


	@Test
	@Disabled
	@DisplayName("Test-Get All Seeds , Args:- No Args to pass")
	void testGetAllSeeds() {


		List<Seed> seedList = mock(List.class); 
		//when() and 	//thenReturn()
		when(seedRepo.findAll()).thenReturn(seedList);
		//call the actual method 
		seedService.viewAllSeeds();
		//verify
		verify(seedRepo).findAll();

	}

	@Test
	@Disabled
	@DisplayName("Test-Get Seed by Id , Args:- No Args to pass")
	void testViewSeedById(){


		Optional<Seed> s = Optional.empty();
		//when() and 	//thenReturn()
		when(seedRepo.findById(2)).thenReturn(s);
		//call the actual method 
		try {
			seedService.viewSeed(2);
		} catch (SeedIdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//verify
		verify(seedRepo).findById(2);

	}

	@Test
	@Disabled
	@DisplayName("Test-Get Seed by common Name , Args:- No Args to pass")
	void testViewSeedByName() throws ResourceNotFoundException {


		Seed s = mock(Seed.class);
		//when() and 	//thenReturn()
		when(seedRepo.getSeedByCommonName("Maize")).thenReturn(s);
		//call the actual method 
		seedService.viewSeed("Maize");
		//verify
		verify(seedRepo).getSeedByCommonName("Maize");

	}

	@Test
	@Disabled
	@DisplayName("Test-Get Seed by type of seed , Args:- No Args to pass")
	void testViewSeedByTypeOfSeed() throws ResourceNotFoundException {


		List<Seed> seedList = mock(List.class); 
		//when() and 	//thenReturn()
		when(seedRepo.getSeedsByTypeOfSeed("Monocotyledonous")).thenReturn(seedList);
		//call the actual method 
		seedService.viewAllSeeds("Monocotyledonous");
		//verify
		verify(seedRepo).getSeedsByTypeOfSeed("Monocotyledonous");

	}

	@Test
	@Disabled
	@DisplayName("Test-Delete seed , Args:- No Args to pass")
	void testDeleteSeed() {

		Seed input = new Seed(1,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		Seed savedSeed = new Seed(1,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);


		//when(seedRepo.delete(input)).thenThrow(savedSeed);

		/*//doThrow(new PersistenceException("Exception occured")).when(seedRepo).delete(input);
		//call the actual method 
		seedService.deleteSeed(input);
		//verify
		verify(seedRepo).delete(input);
		sut.deleteDose(doseId);

        // verify the mocks
        verify(doseRepository, times(1)).deleteById(eq(doseId));*/

		seedService.deleteSeed(input.getSeedId());
		verify(seedRepo).delete(input);
	}

	@Test
	@Disabled
	@DisplayName("Test-Update seed , Args:- No Args to pass")
	void testUpdateSeed() throws ResourceNotFoundException {
		Seed input = new Seed(1,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		Seed savedSeed = new Seed(1,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);

		when(seedRepo.save(input)).thenReturn(savedSeed);
		seedService.updateSeed(input);
		verify(seedRepo).save(input);

	}


}