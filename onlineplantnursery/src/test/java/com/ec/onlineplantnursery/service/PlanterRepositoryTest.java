package com.ec.onlineplantnursery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.IPlanterRepository;
import com.ec.onlineplantnursery.planter.service.IPlanterServiceImpl;
import com.ec.onlineplantnursery.seed.entity.Seed;

@SpringBootTest
public class PlanterRepositoryTest {

	IPlanterRepository pRepo;
	private static IPlanterServiceImpl pService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit()
	{
		pRepo = mock(IPlanterRepository.class); // test through approach 2
		pService = new  IPlanterServiceImpl(pRepo); 	// Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}

	@Test
	@DisplayName("Test-Save Planter with Seed Name")
	void testSavePlanterBySeed() {
		Seed sinput = new Seed(101,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",200,300,2000);
		
		Planter input = new Planter(1,12,3,2,23,"Round",45,30,sinput);
		Planter savedPlanter = new Planter(1,12,3,2,23,"Round",45,30,sinput);

		when(pRepo.save(input)).thenReturn(savedPlanter);
		pService.addPlanter(input);
		verify(pRepo).save(input);

	}
	@Test
	@DisplayName("Test-Save Planter with Plant Name")
	void testSavePlanterByPlant() {
		Plant sinput = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);
		
		Planter input = new Planter(1,12,3,2,23,"Round",45,30,sinput);
		Planter savedPlanter = new Planter(1,12,3,2,23,"Round",45,30,sinput);

		when(pRepo.save(input)).thenReturn(savedPlanter);
		pService.addPlanter(input);
		verify(pRepo).save(input);

	}
	
	@Test
	@DisplayName("Test-Save Planter with Both Plant and Seed Name")
	void testSavePlanterByBoth() {
		
		Seed sinput = new Seed(101,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",200,300,2000);
		Plant pinput = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);
		
		Planter input = new Planter(1,12,3,2,23,"Round",45,30,pinput,sinput);
		Planter savedPlanter = new Planter(1,12,3,2,23,"Round",45,30,pinput,sinput);

		when(pRepo.save(input)).thenReturn(savedPlanter);
		pService.addPlanter(input);
		verify(pRepo).save(input);

	}
	
	@Test
	@DisplayName("Test-Save Planter without  Plant and Seed Name")
	void testSavePlanter() {
		
		Planter input = new Planter(1,12,3,2,23,"Round",45,30);
		Planter savedPlanter = new Planter(1,12,3,2,23,"Round",45,30);

		when(pRepo.save(input)).thenReturn(savedPlanter);
		pService.addPlanter(input);
		verify(pRepo).save(input);

	}


	@Test
	@DisplayName("Test-Get All Planters , Args:- No Args to pass")
	void testGetAllPlanters() {


		List<Planter> pList = mock(List.class); 
		//when() and 	//thenReturn()
		when(pRepo.findAll()).thenReturn(pList);
		//call the actual method 
		pService.viewAllPlanters();
		//verify
		verify(pRepo).findAll();

	}

	@Test
	@DisplayName("Test-Get Planter by Id , Args:- No Args to pass")
	void testViewPlanterById() throws ResourceNotFoundException{


		Optional<Planter> s = Optional.empty();
		//when() and 	//thenReturn()
		when(pRepo.findById(2)).thenReturn(s);
		Executable executable = ()->pService.viewPlanter(2);
		assertThrows(ResourceNotFoundException.class, executable);

	}

	@Test
	@DisplayName("Test-Get Planter by Planter Shape , Args:- No Args to pass")
	void testViewPlanterByShape() throws ResourceNotFoundException {


		String planterShape = "square";
		Optional<Planter> s = Optional.empty();
		when(pRepo.getPlanterByPlanterShape(planterShape)).thenReturn(s);
		Executable executable = ()->pService.viewPlanter(planterShape);
		assertThrows(ResourceNotFoundException.class, executable);

	}

	@Test
	@DisplayName("Test-Get Planter by range , Args:- No Args to pass")
	void testViewPlanterByRange() throws ResourceNotFoundException {


		double minCost = 50;
		double maxCost = 100;
		Optional<List<Planter>> pList = Optional.empty(); 
		when(pRepo.getPlantersByRange(minCost,maxCost)).thenReturn(pList);
		//call the actual method 
		Executable executable = ()->pService.viewAllPlanters(minCost,maxCost);
		assertThrows(ResourceNotFoundException.class, executable);

	}

	@Test
	@DisplayName("Test-Delete Planter , Args:- No Args to pass")
	void testDeletePlanter() {

		Seed sinput = new Seed(1,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		
		Planter input = new Planter(1,12,3,2,23,"Round",45,30,sinput);
		Planter savedPlanter = new Planter(1,12,3,2,23,"Round",45,30,sinput);

		doNothing().
		 when(pRepo).deleteById(input.getPlanterId());;

		pService.deletePlanter(input.getPlanterId());

		verify(pRepo).deleteById(input.getPlanterId());;
		assertEquals(input,savedPlanter);
	}

	@Test
	@Disabled
	@DisplayName("Test-Update Planter , Args:- No Args to pass")
	void testUpdatePlanter() throws ResourceNotFoundException {
		Seed sinput = new Seed(1,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		Planter input = new Planter(1,12,3,2,23,"Round",45,30,sinput);
		Planter savedPlanter = new Planter(1,12,3,2,23,"Round",45,30,sinput);

		when(pRepo.save(input)).thenReturn(savedPlanter);
		pService.updatePlanter(input);
		verify(pRepo).save(input);

	}

}
