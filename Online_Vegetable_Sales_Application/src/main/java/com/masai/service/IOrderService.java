package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.entity.OrderTable;





public interface IOrderService {
	
	public OrderTable addOrder(OrderTable order);
	public OrderTable updateOrderDetails(OrderTable order);
	public OrderTable viewOrder(OrderTable order);
	public List<OrderTable> viewAllOrders(int customerId);
	public List<OrderTable> viewAllOrders(LocalDate date);
	public List<OrderTable> viewOrderList();
	public OrderTable cancelOrder(int orderId);
}
