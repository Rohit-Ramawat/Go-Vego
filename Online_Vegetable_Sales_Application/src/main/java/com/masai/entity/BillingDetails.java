package com.masai.entity;


import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class BillingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int billingId;
	
	@OneToOne
    @JoinColumn(name = "order_id")
    private OrderTable order;
	
	@Column(nullable = false, length = 50)
	private String transactionMode;
	@Column(nullable = false, length = 50)
	private LocalDateTime transactionDate;
	@Column(nullable = false, length = 50)
	private String transactionStatus;
	private Address billingAddress;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public BillingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BillingDetails(OrderTable order, String transactionMode, LocalDateTime transactionDate, String transactionStatus,
			Address billingAddress, Customer customer) {
		super();
		this.order = order;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
		this.billingAddress = billingAddress;
		this.customer = customer;
	}

	public int getBillingId() {
		return billingId;
	}

	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}

	public OrderTable getOrder() {
		return order;
	}

	public void setOrder(OrderTable order) {
		this.order = order;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
