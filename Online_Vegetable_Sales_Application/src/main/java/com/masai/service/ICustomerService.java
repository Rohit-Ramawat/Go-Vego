package com.masai.service;

import java.util.List;

import com.masai.entity.Customer;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;

public interface ICustomerService {
	public void addCustomer(Customer customer) throws CustomerAlreadyExistException, CustomerException;
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(Customer customer);
	public Customer viewCustomer(Customer customer);
	public List<Customer> viewAllCustomer(String loc);
}
