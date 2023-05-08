package com.masai.dao;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;
import com.masai.exception.CustomerNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void addCustomerDB(Customer customer) throws CustomerAlreadyExistException, CustomerException {
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EmUtils.getEntityManager();
			et = em.getTransaction();
			
			Customer cus = em.find(Customer.class, customer.getUserId());
			
			if(cus != null) {
				throw new CustomerAlreadyExistException("Customer with this user id is already registered");
			}
			
			et.begin();
			em.persist(customer);
			
		} catch (PersistenceException e) {
			throw new CustomerException("Unable to process request try again");
		} finally {
			et.commit();
			em.close();
		}

	}

	@Override
	public Customer viewCustomerDB(String userId) throws CustomerNotFoundException {
		EntityManager em = EmUtils.getEntityManager();
		
		Customer customer = em.find(Customer.class, userId);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer with this userId is not registered"); 
		}
		em.close();
		return customer;
	}

	@Override
	public void updateCustomerPasswordDB(Customer customer, String newPass) throws CustomerException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			customer.setPassword(newPass);
			em.merge(customer); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new CustomerException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCustomerMobileNumber(Customer customer, String newMobileNo) throws CustomerException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			customer.setMobileNumber(newMobileNo);
			em.merge(customer); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new CustomerException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCustomerEmail(Customer customer, String email) throws CustomerException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			customer.setEmailId(email);
			em.merge(customer); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new CustomerException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCustomerName(Customer customer, String name) throws CustomerException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			customer.setName(name);
			em.merge(customer); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new CustomerException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateAddress(Customer customer, Address address) throws CustomerException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			customer.setAddress(address);
			em.merge(customer); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new CustomerException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void deleteCustomerDB(Customer customer) throws CustomerException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			customer.setIsDeleted(1);
			em.merge(customer); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new CustomerException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}
	
	

}
