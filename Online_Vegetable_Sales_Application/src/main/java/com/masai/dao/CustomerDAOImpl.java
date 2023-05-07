package com.masai.dao;

import com.masai.entity.Customer;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;

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

}
