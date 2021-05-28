package com.ec.onlineplantnursery.customer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.customer.repository.ICustomerRepository;


@Service
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository custRep;
	
	

	public ICustomerServiceImpl(ICustomerRepository custRep) {
		super();
		this.custRep = custRep;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		custRep.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer tenant) {
		// TODO Auto-generated method stub
		int id = tenant.getCustomerId();
		Optional<Customer> cs = custRep.findById(id);
		if(cs.isPresent()) {
			Customer cst = cs.get();
			cst.setAddress(tenant.getAddress());
		    cst.setCustomerEmail(tenant.getCustomerEmail());
		    cst.setCustomerId(tenant.getCustomerId());
		    cst.setCustomerName(tenant.getCustomerName());
		    cst.setPassword(tenant.getPassword());
		    cst.setUsername(tenant.getUsername());
		   
			return custRep.save(cst);
		}
		return null;
	}

	@Override
	public Customer deleteCustomer(int tenant) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		Customer c1 = null;
		List<Customer> cList = viewAllCustomers();
		for(Customer customer : cList) {
			if(customer.getCustomerId() == tenant) {
				isDeleted = true;
				c1 = customer;
			}
		}
		custRep.delete(c1);
		return c1;
	}

	@Override
	public Customer viewCustomer(int customerId) {
		// TODO Auto-generated method stub
		return custRep.findById(customerId).get();
	}

	@Override
	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return custRep.findAll();
	}

	@Override
	public boolean validateCustomer(String userName, String password) {
		// TODO Auto-generated method stub
		List<Customer> cList = custRep.findAll();
		for(Customer cust:cList) {
			if(cust.getUsername().equalsIgnoreCase(userName) && cust.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	
}
