package com.ec.onlineplantnursery.order.service;

import java.util.List;

import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.order.entity.Order;

public interface IOrderService {
	//Order addOrder(Order order,int cid,int pid);
	Order addOrder(Order order) throws ResourceNotFoundException;
	Order updateOrder(Order order) throws ResourceNotFoundException;
	Order deleteOrder(int orderId);
	Order viewOrder(int  orderId) throws OrderIdNotFoundException;
	List<Order> viewAllOrders();
}
