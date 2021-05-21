package com.ec.onlineplantnursery.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.order.repository.IOrderRepository;

@Service
public class IOrderServiceImpl implements IOrderService{
	
	@Autowired
	IOrderRepository repo;

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		repo.save(order);
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order viewOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> viewAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
