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

	@Override
	public Order addOrder(Order order) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		//System.out.println("\n\n"+order+"\n\n");
		Customer cust= custRep.viewCustomer(order.getCid());
		order.setCustomer(cust);
		//System.out.println("\n\n"+order+"\n\n");
		Planter planter1;
		try {
			planter1 = planterRep.viewPlanter(order.getPid());
			order.setPlanters(planter1);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("\n\n"+order+"\n\n");
		repo.save(order);
		return order;
	}

	@Override
	public Order updateOrder(Order order) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		Order o = repo.findById(order.getBookingOrderId()).get();
		if(o==null) throw new ResourceNotFoundException();
		o.setBookingOrderId(order.getBookingOrderId());
		o.setOrderDate(order.getOrderDate());
		o.setQuantity(order.getQuantity());
		o.setTotalCost(order.getTotalCost());
		o.setTransactionMode(order.getTransactionMode());
		return repo.save(o);
	}

	@Override
	public Order deleteOrder(int orderId)  {
		// TODO Auto-generated method stub
		Order o = repo.findById(orderId).get();
		repo.delete(o);
		return o;
	}

	@Override
	public Order viewOrder(int orderId) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		Order o =  repo.findById(orderId).get();
		System.out.println("\n\n\n\n"+o+"\n\n\n\n");
		if(o==null) throw new OrderIdNotFoundException(orderId);
		return o;
	}

	@Override
	public List<Order> viewAllOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}