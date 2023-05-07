package com.masai.service;

import java.util.List;

import com.masai.dao.CustomerDAO;
import com.masai.dao.CustomerDAOImpl;
import com.masai.entity.Customer;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;

public class ICustomerServiceImpl implements ICustomerService {

	@Override
	public void addCustomer(Customer customer) throws CustomerAlreadyExistException, CustomerException {
		CustomerDAO cDAO = new CustomerDAOImpl();
		cDAO.addCustomerDB(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomer(String loc) {
		// TODO Auto-generated method stub
		return null;
	}

}
