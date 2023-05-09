package com.masai.dao;

import java.util.List;

import com.masai.entity.OrderTable;
import com.masai.exception.OrderException;
import com.masai.exception.OrderNotFoundException;

public interface OrderDAO {
	
	public void addOrderDB(OrderTable order) throws OrderException;
	
	public OrderTable viewOrderByIdDB(int id) throws OrderNotFoundException;
	
	public List<OrderTable> viewAllOrderDB(String id) throws OrderNotFoundException, OrderException;

	public void cancelOrderDB(int orderId) throws OrderNotFoundException, OrderException;
}
