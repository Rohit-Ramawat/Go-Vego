package com.masai.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
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
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int cartId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Set<Vegetable> vegetableList;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(int cartId, Customer customer, Set<Vegetable> vegetableList) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.vegetableList = vegetableList;
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
