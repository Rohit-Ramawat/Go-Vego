package com.masai.dao;

import com.masai.entity.OrderTable;
import com.masai.exception.OrderException;
import com.masai.exception.OrderNotFoundException;

public interface OrderDAO {
	
	public void addOrderDB(OrderTable order) throws OrderException;
	
	public OrderTable viewOrderByIdDB(int id) throws OrderNotFoundException;
}
