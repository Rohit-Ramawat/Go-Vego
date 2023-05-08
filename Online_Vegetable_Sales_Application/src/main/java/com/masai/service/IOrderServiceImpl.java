package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.dao.OrderDAO;
import com.masai.dao.OrderDAOImpl;
import com.masai.entity.OrderTable;
import com.masai.exception.OrderException;
import com.masai.exception.OrderNotFoundException;

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
	public List<OrderTable> viewAllOrders(int customerId) {
		// TODO Auto-generated method stub
		return null;
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
	public OrderTable cancelOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
