package com.masai.service;

import java.util.List;

import com.masai.dao.CustomerDAO;
import com.masai.dao.CustomerDAOImpl;
import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;
import com.masai.exception.CustomerNotFoundException;

public class ICustomerServiceImpl implements ICustomerService {

	@Override
	public void addCustomer(Customer customer) throws CustomerAlreadyExistException, CustomerException {
		CustomerDAO cDAO = new CustomerDAOImpl();
		cDAO.addCustomerDB(customer);
	}

	@Override
	public void removeCustomer(Customer customer) {
		CustomerDAO cDAO = new CustomerDAOImpl();
		try {
			cDAO.deleteCustomerDB(customer);
		} catch (CustomerException e) {
			System.out.println("Customer account deleted");
		}
	}

	@Override
	public Customer viewCustomer(String userId) {
		CustomerDAO cDAO = new CustomerDAOImpl();
		Customer customer = null;
		try {
			customer = cDAO.viewCustomerDB(userId);
		} catch (CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}

	@Override
	public List<Customer> viewAllCustomer(String loc) {
		
		return null;
	}

	@Override
	public void updateCustomerPassword(Customer customer, String newPass) {
		CustomerDAO cDAO = new CustomerDAOImpl();
		try {
			cDAO.updateCustomerPasswordDB(customer, newPass);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Customer password updated successfully");
	}

	@Override
	public void updateCustomerMobileNumber(Customer customer, String newMobileNo) {
		CustomerDAO cDAO = new CustomerDAOImpl();
		try {
			cDAO.updateCustomerMobileNumber(customer, newMobileNo);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Customer mobile number updated successfully");
	}

	@Override
	public void updateCustomerEmail(Customer customer, String email) {
		CustomerDAO cDAO = new CustomerDAOImpl();
		try {
			cDAO.updateCustomerEmail(customer, email);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Customer email updated successfully");
	}

	@Override
	public void updateCustomerName(Customer customer, String name) {
		CustomerDAO cDAO = new CustomerDAOImpl();
		try {
			cDAO.updateCustomerName(customer, name);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Customer name updated successfully");
	}

	@Override
	public void updateAddress(Customer customer, Address address) {
		CustomerDAO cDAO = new CustomerDAOImpl();
		try {
			cDAO.updateAddress(customer, address);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Customer Address updated successfully");
	}

}
