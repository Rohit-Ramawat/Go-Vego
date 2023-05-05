package com.masai.service;

import java.util.List;

import com.masai.entity.Vegetable;

public interface IVegetableMgmtService {
	
	public Vegetable addVegetable(Vegetable veg);
	public Vegetable updateVegetable(Vegetable veg);
	public Vegetable removeVegetable(Vegetable veg);
	public List<Vegetable> viewAllVegetavles();
	public List<Vegetable> viewVegetableList(String category);
	public List<Vegetable> viewAllVegetablesByName(String name);
	
}
