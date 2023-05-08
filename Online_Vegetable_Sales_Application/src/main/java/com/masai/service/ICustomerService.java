package com.masai.service;

import java.util.List;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;

public interface ICustomerService {
	public void addCustomer(Customer customer) throws CustomerAlreadyExistException, CustomerException;
	public void removeCustomer(Customer customer);
	public Customer viewCustomer(String userId);
	public List<Customer> viewAllCustomer(String loc);
	public void updateCustomerPassword(Customer customer, String newPass);
	public void updateCustomerMobileNumber(Customer customer, String newContact);
	public void updateCustomerEmail(Customer customer, String email);
	public void updateCustomerName(Customer customer, String name);
	public void updateAddress(Customer customer, Address address);
}
