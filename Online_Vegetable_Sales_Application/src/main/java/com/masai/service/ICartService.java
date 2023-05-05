package com.masai.service;

import java.util.List;

import com.masai.entity.Cart;
import com.masai.entity.Vegetable;

public interface ICartService {
	
	public Vegetable addtoCart(Vegetable veg);
	public Cart increaseVegQuantity(int vegId, int quantity);
	public Cart decreaseVegQuantity(int vegId, int quantity);
	public Cart removeVegetable(int vegId);
	public Cart removeAllVegetables();
	public List<Vegetable> viewAllItems();
}
