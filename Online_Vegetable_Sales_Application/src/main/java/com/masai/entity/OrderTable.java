package com.masai.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class OrderTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name = "order_vegetable",joinColumns = {@JoinColumn(referencedColumnName = "orderId")},
	                                    inverseJoinColumns = {@JoinColumn(referencedColumnName = "vegId")})
    private Set<Vegetable> vegetableList; 
	
	@Column(nullable = false)
	private double totalAmount;
	@Column(nullable = false, length = 50)
	private String status;
	
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private BillingDetails billingDetails;

	public OrderTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderTable(Customer customer, Set<Vegetable> vegetableList, double totalAmount, String status,
			BillingDetails billingDetails) {
		super();
		this.customer = customer;
		this.vegetableList = vegetableList;
		this.totalAmount = totalAmount;
		this.status = status;
		this.billingDetails = billingDetails;
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

	public BillingDetails getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", totalAmount=" + totalAmount + ", status=" + status;
	}
	
}
