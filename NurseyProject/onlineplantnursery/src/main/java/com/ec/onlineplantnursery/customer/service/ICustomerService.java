package com.ec.onlineplantnursery.customer.service;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.customer.entity.Customer;

public interface ICustomerService {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer tenant);

	Customer deleteCustomer(int cid);

	Customer viewCustomer(int customerId);

	List<Customer> viewAllCustomers();

	boolean validateCustomer(String userName, String password);
}
