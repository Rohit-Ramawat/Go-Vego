package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.entity.Order;



public interface IOrderService {
	
	public Order addOrder(Order order);
	public Order updateOrderDetails(Order order);
	public Order viewOrder(Order order);
	public List<Order> viewAllOrders(int customerId);
	public List<Order> viewAllOrders(LocalDate date);
	public List<Order> viewOrderList();
	public Order cancelOrder(int orderId);
}
