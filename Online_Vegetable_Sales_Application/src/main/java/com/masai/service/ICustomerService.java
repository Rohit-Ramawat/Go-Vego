package com.masai.service;

import java.util.List;

import com.masai.entity.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(Customer customer);
	public Customer viewCustomer(Customer customer);
	public List<Customer> viewAllCustomer(String loc);
}
