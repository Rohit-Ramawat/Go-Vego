package com.masai.dao;

import java.util.Iterator;
import java.util.List;

import com.masai.entity.OrderTable;
import com.masai.exception.OrderException;
import com.masai.exception.OrderNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

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
		
		if(order == null || (!order.getStatus().equalsIgnoreCase("Cancelled"))) {
			throw new OrderNotFoundException("order with this id is not available");
		}
		
		em.close();
		return order;
	}

	@Override
	public List<OrderTable> viewAllOrderDB(String id) throws OrderNotFoundException, OrderException {
		EntityManager em = EmUtils.getEntityManager();
		List<OrderTable> orderList;
		try {
			
			Query query = em.createNamedQuery("orderByCustomerID");
			query.setParameter(1, id);
			orderList = query.getResultList();
			
			if(orderList.isEmpty() || orderList == null) {
				throw new OrderNotFoundException("No any order is placed by this customer");
			}
			
			
			Iterator<OrderTable> iterator = orderList.iterator();
	        while(iterator.hasNext()) {
	            OrderTable o = iterator.next();
	            if (o.getStatus().equalsIgnoreCase("Cancelled")) {  //<---checking if order is cancelled or not
	                iterator.remove();
	            }
	        }
	        
			return orderList;
			
		} catch (PersistenceException e) {
			throw new OrderException("Unable to process request try again");
		} finally {
			em.close();
		}
		
	}

	@Override
	public void cancelOrderDB(int orderId) throws OrderNotFoundException, OrderException {
		EntityManager em = EmUtils.getEntityManager();
	    EntityTransaction et = em.getTransaction();
	    try {
	        et.begin();
	        OrderTable order = em.find(OrderTable.class, orderId);
	        if (order == null) {
	            throw new OrderNotFoundException("Order not found.");
	        }
	        order.setStatus("Cancelled");
	        em.merge(order);
	        et.commit();
	    } catch (PersistenceException e) {
	        et.rollback();
	        throw new OrderException("Unable to process request. Please try again.");
	    } finally {
	        em.close();
	    }
		
	}

}
