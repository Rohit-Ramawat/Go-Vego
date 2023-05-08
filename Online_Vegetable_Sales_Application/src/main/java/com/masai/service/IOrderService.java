package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.entity.OrderTable;
import com.masai.exception.OrderException;





public interface IOrderService {
	
	public void addOrder(OrderTable order) throws OrderException;
	public OrderTable updateOrderDetails(OrderTable order);
	public OrderTable viewOrder(int orderId);
	public List<OrderTable> viewAllOrders(int customerId);
	public List<OrderTable> viewAllOrders(LocalDate date);
	public List<OrderTable> viewOrderList();
	public OrderTable cancelOrder(int orderId);
}
