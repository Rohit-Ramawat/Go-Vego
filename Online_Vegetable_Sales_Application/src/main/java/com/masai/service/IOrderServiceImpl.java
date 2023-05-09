package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.dao.OrderDAO;
import com.masai.dao.OrderDAOImpl;
import com.masai.entity.OrderTable;
import com.masai.exception.OrderException;
import com.masai.exception.OrderNotFoundException;

import jakarta.persistence.PersistenceException;

public class IOrderServiceImpl implements IOrderService {

	@Override
	public void addOrder(OrderTable order) throws OrderException {
		OrderDAO oDAO = new OrderDAOImpl();
		oDAO.addOrderDB(order);
	}

	@Override
	public OrderTable updateOrderDetails(OrderTable order) {
		
		return null;
	}

	@Override
	public OrderTable viewOrder(int orderId) {
		OrderDAO oDAO = new OrderDAOImpl();
		
		OrderTable order = null;
		try {
			order = oDAO.viewOrderByIdDB(orderId);
		} catch (OrderNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return order;
	}

	@Override
	public List<OrderTable> viewAllOrders(String customerId) {
		OrderDAO oDAO = new OrderDAOImpl();
		List<OrderTable> orderList = null;
		try {
			orderList = oDAO.viewAllOrderDB(customerId);
		} catch (OrderNotFoundException | OrderException e) {
			System.out.println(e.getMessage());
		}
		return orderList;
	}

	@Override
	public List<OrderTable> viewAllOrders(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderTable> viewOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelOrder(String userId, int orderId) throws OrderNotFoundException, OrderException {
		OrderDAO oDAO = new OrderDAOImpl();
	    try {
	        OrderTable order = oDAO.viewOrderByIdDB(orderId);
	        if (!order.getCustomer().getUserId().equals(userId)) {
	            throw new OrderNotFoundException("Order not found.");
	        }
	        if (!order.getStatus().equalsIgnoreCase("Pending")) {
	            throw new OrderException("Order cannot be cancelled.");
	        }
	        oDAO.cancelOrderDB(orderId);
	    } catch (PersistenceException e) {
	        throw new OrderException("Unable to process request. Please try again.");
	    }
		
	}

}
