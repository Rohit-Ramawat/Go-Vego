package com.masai.entity;

import java.util.List;

public class Order {
	
	private int orderNo;
	private int customerId;
	private List<Vegetable> vegetableList; 
	private double totalAmount;
	private String status;
}
