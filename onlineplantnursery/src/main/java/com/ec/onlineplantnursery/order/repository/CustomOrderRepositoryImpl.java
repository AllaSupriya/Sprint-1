package com.ec.onlineplantnursery.order.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.planter.entity.Planter;



public class CustomOrderRepositoryImpl implements CustomOrderRepository{
	@Autowired
	EntityManager entityManager; // Session of Hibernate
	
	
	@Override
	public Optional<List<Planter>> getPlanterByOrderId(int idOrder) {
		Query q = entityManager.createQuery("select planters from Order as ord where ord.bookingOrderId =: b");
		q.setParameter("b", idOrder);
		return Optional.of(q.getResultList());
		
	}
} 