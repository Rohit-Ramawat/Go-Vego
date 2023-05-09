package com.masai.dao;

import java.util.List;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;
import com.masai.exception.CustomerNotFoundException;

public interface CustomerDAO {
	public void addCustomerDB(Customer customer) throws CustomerAlreadyExistException, CustomerException;

	public Customer viewCustomerDB(String userId) throws CustomerNotFoundException;
	
	public List<Customer> viewAllCustomerDB() throws CustomerNotFoundException, CustomerException;

	public void updateCustomerPasswordDB(Customer customer, String newPass) throws CustomerException;

	public void updateCustomerMobileNumber(Customer customer, String newMobileNo) throws CustomerException;

	public void updateCustomerEmail(Customer customer, String email) throws CustomerException;

	public void updateCustomerName(Customer customer, String name) throws CustomerException;

	public void updateAddress(Customer customer, Address address) throws CustomerException;

	public void deleteCustomerDB(Customer customer) throws CustomerException;
	
	
}
