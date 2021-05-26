package com.ec.onlineplantnursery.customer.service;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.customer.repository.ICustomerRepository;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;

@Service
public class ICustomerServiceImpl implements ICustomerServices {
	
	@Autowired
	ICustomerRepository crepo;
	
	@Autowired
	EntityManager em;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return crepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer tenant) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> oc = crepo.findById(tenant.getCustomerId());
		Customer c = crepo.findById(tenant.getCustomerId()).get();
		if(oc.isEmpty()) throw new ResourceNotFoundException();
		c.setAddress(tenant.getAddress());
		c.setCustomerEmail(tenant.getCustomerEmail());
		c.setCustomerName(tenant.getCustomerName());
		c.setPassword(tenant.getPassword());
		c.setUsername(tenant.getUsername());
		return crepo.save(c);
	}

	@Override
	public Customer deleteCustomer(int tenant) {
		// TODO Auto-generated method stub
		Customer c = crepo.findById(tenant).get();
		crepo.delete(c);
		return c;
	}

	@Override
	public Customer viewCustomer(int customerId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> oc = crepo.findById(customerId);
		
		Customer c=  crepo.findById(customerId).get();
		if(oc.isEmpty()) throw new ResourceNotFoundException();
		
		return c;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	public boolean validateCustomer(String userName, String password) {
		// TODO Auto-generated method stub
		List<Customer> cList = crepo.findAll();
		for(Customer c:cList) {
			if(c.getUsername().equals(userName) && c.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

}
