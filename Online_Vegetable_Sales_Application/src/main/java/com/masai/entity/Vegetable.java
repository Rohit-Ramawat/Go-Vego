package com.masai.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Vegetable {
	@Column(nullable = false)
	private int vegId;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 50)
	private String type;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private int quantity;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price, quantity, type, vegId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vegetable other = (Vegetable) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity
				&& Objects.equals(type, other.type) && vegId == other.vegId;
	}
	
	public Vegetable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vegetable(int vegId, String name, String type, double price, int quantity) {
		super();
		this.vegId = vegId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getVegId() {
		return vegId;
	}
	
	public void setVegId(int vegId) {
		this.vegId = vegId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Vegetable [vegId=" + vegId + ", name=" + name + ", type=" + type + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
	
}
