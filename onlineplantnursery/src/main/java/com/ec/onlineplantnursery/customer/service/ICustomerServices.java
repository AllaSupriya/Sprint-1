package com.ec.onlineplantnursery.customer.service;

import java.util.List;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;

public interface ICustomerServices {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer tenant) throws ResourceNotFoundException;

	Customer deleteCustomer(int cid);

	Customer viewCustomer(int customerId) throws ResourceNotFoundException;

	List<Customer> viewAllCustomers();

	boolean validateCustomer(String userName, String password);
}
