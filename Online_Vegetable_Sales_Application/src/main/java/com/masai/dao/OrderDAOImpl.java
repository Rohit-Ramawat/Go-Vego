package com.masai.dao;

import com.masai.entity.OrderTable;
import com.masai.exception.OrderException;
import com.masai.exception.OrderNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void addOrderDB(OrderTable order) throws OrderException {
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EmUtils.getEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.persist(order);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new OrderException("Unable to process request try again");
		} finally {
			et.commit();
			em.close();
		}
		
	}

	@Override
	public OrderTable viewOrderByIdDB(int id) throws OrderNotFoundException {
		EntityManager em = EmUtils.getEntityManager();
		
		OrderTable order = em.find(OrderTable.class, id);
		
		if(order == null) {
			throw new OrderNotFoundException("order with this id is not available");
		}
		
		em.close();
		return order;
	}

}
