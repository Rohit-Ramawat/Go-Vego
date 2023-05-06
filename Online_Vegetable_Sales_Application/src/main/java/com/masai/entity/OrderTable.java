package com.masai.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OrderTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Embedded
	@ElementCollection
	private Set<Vegetable> vegetableList; 
	@Column(nullable = false)
	private double totalAmount;
	@Column(nullable = false, length = 50)
	private String status;
	
	@OneToMany(mappedBy = "order")
    private List<BillingDetails> billingDetailsList = new ArrayList<>();

	public OrderTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderTable(Customer customer, Set<Vegetable> vegetableList, double totalAmount, String status,
			List<BillingDetails> billingDetailsList) {
		super();
		this.customer = customer;
		this.vegetableList = vegetableList;
		this.totalAmount = totalAmount;
		this.status = status;
		this.billingDetailsList = billingDetailsList;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Vegetable> getVegetableList() {
		return vegetableList;
	}

	public void setVegetableList(Set<Vegetable> vegetableList) {
		this.vegetableList = vegetableList;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BillingDetails> getBillingDetailsList() {
		return billingDetailsList;
	}

	public void setBillingDetailsList(List<BillingDetails> billingDetailsList) {
		this.billingDetailsList = billingDetailsList;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", vegetableList=" + vegetableList
				+ ", totalAmount=" + totalAmount + ", status=" + status + ", billingDetailsList=" + billingDetailsList
				+ "]";
	}
	
}
