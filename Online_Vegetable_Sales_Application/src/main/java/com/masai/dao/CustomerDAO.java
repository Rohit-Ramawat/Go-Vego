package com.masai.dao;

import com.masai.entity.Customer;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;

public interface CustomerDAO {
	public void addCustomerDB(Customer customer) throws CustomerAlreadyExistException, CustomerException;
}
