package com.ec.onlineplantnursery.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.ec.onlineplantnursery.customer.entity.Address;
import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.customer.repository.ICustomerRepository;
import com.ec.onlineplantnursery.customer.service.ICustomerServiceImpl;
import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.order.repository.IOrderRepository;
import com.ec.onlineplantnursery.order.service.IOrderServiceImpl;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.IPlanterRepository;
import com.ec.onlineplantnursery.planter.service.IPlanterServiceImpl;
import com.ec.onlineplantnursery.seed.entity.Seed;

@SpringBootTest
public class OrderRepositoryTest {
	
	IOrderRepository orderRepo;
	ICustomerRepository custRepo;
	IPlanterRepository planterRepo;

	private static IOrderServiceImpl orderService;
	private static ICustomerServiceImpl customerService;
	private static IPlanterServiceImpl planterSevice;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit() {
		orderRepo = mock(IOrderRepository.class);
		custRepo = mock(ICustomerRepository.class);
		planterRepo = mock(IPlanterRepository.class);
		
		orderService = new IOrderServiceImpl(orderRepo);
		customerService = new ICustomerServiceImpl(custRepo);
		planterSevice = new IPlanterServiceImpl(planterRepo);
		
		ac = MockitoAnnotations.openMocks(this);
		
	}
	@AfterEach
	public void doEnd() throws Exception{
		ac.close();
	}
	
	@Test
	void testSaveOrder() throws ResourceNotFoundException {
		Address address = new Address(20, "8-90", "Yusufguda", "Hyderabad", "Telangana", 500045);
		Customer cust = new Customer(1, "Suhana", "suhana123@gmail.com", "suhana2268", "123456", address);
		Seed seed = new Seed(1, "mango", "10 days", "twicw a day", "hard", "30 degrees", "dry", "Mango seed", 20 , 70.0, 2);
		Plant plant = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);

		Planter p1 = new Planter(1, 2.3f, 4, 3, 1, "round", 46, 25, plant, seed);
		LocalDate date = LocalDate.now();
		Order input = new Order(101, date, "online", 1, 20.00, 1, 1);
		Order savedOrder = new Order(101, date, "online", 1, 20.00, 1, 1);
		
		try{
			when(orderRepo.save(input)).thenReturn(savedOrder);
			
			orderService.addOrder(input);

			assertEquals(input,savedOrder);
		}
		catch(ResourceNotFoundException e) {
			
		}
//		Customer cust = mock(Customer.class);
//		Planter p = mock(Planter.class);
//
//		Address address = new Address(20, "8-90", "Yusufguda", "Hyderabad", "Telangana", 500045);
//		Customer customer = new Customer(1, "Suhana", "suhana123@gmail.com", "suhana2268", "123456", address);
//		custRepo.save(customer);
//		
//		Seed seed = new Seed(1, "mango", "10 days", "twicw a day", "hard", "30 degrees", "dry", "Mango seed", 20 , 70.0, 2);
//		Plant plant = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
//				"fruit","This is a mango plant",380,3000);
//
//		Planter p1 = new Planter(1, 2.3f, 4, 3, 1, "round", 46, 25, plant, seed);
//		planterRepo.save(p1);
//		
//		LocalDate date = LocalDate.now();
//		Order input = new Order(101, date, "online", 1, 20.00, p1, customer);
//		Order savedOrder = new Order(101, date, "online", 1, 20.00, p1, customer);
//		
//		when(orderRepo.save(input)).thenReturn(savedOrder);
//		orderService.addOrder(input);
//		verify(orderRepo).save(input);
//		assertEquals(input,savedOrder);
	
	}
	
	@Test
	void testGetOrderById() throws OrderIdNotFoundException {
		int input = 101;
		Order order = mock(Order.class);
		Optional<Order> optional = Optional.of(order);
		
		
		when(orderRepo.findById(input)).thenReturn(optional);
		orderService.viewOrder(input);
		verify(orderRepo).findById(input);
	}
	
	@Test
	@DisplayName("Test-Delete Order , Args:- No Args to pass")
	void testDeletePlant() {

		LocalDate date = LocalDate.now();
		Order input = new Order(101, date, "online", 1, 20.00, 1, 1);
		Order savedOrder = new Order(101, date, "online", 1, 20.00, 1, 1);

		doNothing().
		 when(orderRepo).deleteById(input.getBookingOrderId());

		orderService.deleteOrder(input.getBookingOrderId());

		verify(orderRepo).deleteById(input.getBookingOrderId());
		assertEquals(input,savedOrder);
		  
	}
	
	@Test
	@DisplayName("Test-Get All Orders, Args:- No Args to pass")
	void testGetAllOrders() {
		List<Order> orderList = mock(List.class);
		when(orderRepo.findAll()).thenReturn(orderList);
		orderService.viewAllOrders();
		verify(orderRepo).findAll();
	}
	
	
	@Test
	void testUpdateOrder() throws ResourceNotFoundException { 
		Address address = new Address(20, "8-90", "Yusufguda", "Hyderabad", "Telangana", 500045);
		Customer cust = new Customer(1, "Suhana", "suhana123@gmail.com", "suhana2268", "123456", address);
		Seed seed = new Seed(1, "mango", "10 days", "twicw a day", "hard", "30 degrees", "dry", "Mango seed", 20 , 70.0, 2);
		Plant plant = new Plant(123,12,"high","Mango","Once a day","medical","moderate","32",
				"fruit","This is a mango plant",380,3000);

		Planter p1 = new Planter(1, 2.3f, 4, 3, 1, "round", 46, 25, plant, seed);
		LocalDate date = LocalDate.now();
		Order input = new Order(101, date, "online", 1, 20.00, 1, 1);
		Order savedOrder = new Order(101, date, "online", 1, 20.00, 1, 1);
		
		try{
			when(orderRepo.save(input)).thenReturn(savedOrder);
			
			orderService.updateOrder(input);

			assertEquals(input,savedOrder);
		}
		catch(ResourceNotFoundException e) {
			
		}
		
	}

}