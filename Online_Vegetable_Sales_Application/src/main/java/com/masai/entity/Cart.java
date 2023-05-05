package com.masai.entity;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int cartId;
	
	@Embedded
	@ElementCollection
	private Set<Vegetable> vegetableList;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Set<Vegetable> vegetableList, Customer customer) {
		super();
		this.vegetableList = vegetableList;
		this.customer = customer;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Set<Vegetable> getVegetableList() {
		return vegetableList;
	}

	public void setVegetableList(Set<Vegetable> vegetableList) {
		this.vegetableList = vegetableList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", vegetableList=" + vegetableList + ", customer=" + customer + "]";
	}
	
	
}
