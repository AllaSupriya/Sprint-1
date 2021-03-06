package com.ec.onlineplantnursery.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.customer.service.ICustomerServiceImpl;
import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.order.repository.IOrderRepository;
import com.ec.onlineplantnursery.plant.service.IPlantServiceImpl;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.service.IPlanterServiceImpl;
import com.ec.onlineplantnursery.seed.service.SeedServiceImpl;

@Service
public class IOrderServiceImpl implements IOrderService{
	
	@Autowired
	IOrderRepository repo;
	
	@Autowired
	ICustomerServiceImpl custRep;
	
	@Autowired
	IPlanterServiceImpl planterRep;

	public IOrderServiceImpl(IOrderRepository repo) {
		super();
		this.repo = repo;
	}
	
	

	@Override
	public Order addOrder(Order order) throws ResourceNotFoundException {
		Customer cust= custRep.viewCustomer(order.getCid());
		order.setCustomer(cust);
		Optional<Planter> planter1 = planterRep.viewPlanter(order.getPid());
		order.setPlanters(planter1.get());
		repo.save(order);
		return order;
	}

	@Override
	public Order updateOrder(Order order) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		Optional<Order> op = repo.findById(order.getBookingOrderId());
		
		if(op.isEmpty()) throw new ResourceNotFoundException();
		
		Order o = repo.findById(order.getBookingOrderId()).get();
		
		o.setBookingOrderId(order.getBookingOrderId());
		o.setOrderDate(order.getOrderDate());
		o.setQuantity(order.getQuantity());
		o.setTotalCost(order.getTotalCost());
		o.setTransactionMode(order.getTransactionMode());
		return repo.save(o);
	}

	@Override
	public Optional<Order> deleteOrder(int orderId)  {
		// TODO Auto-generated method stub
		Optional<Order> o = repo.findById(orderId);
		repo.deleteById(orderId);
		return o;
	}

	@Override
	public Optional<Order> viewOrder(int orderId) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> op = repo.findById(orderId);
		
		if(op.isEmpty()) throw new OrderIdNotFoundException(orderId);
		
		return op;
	}

	@Override
	public List<Order> viewAllOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<List<Planter>> viewPlanterByOrderId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}