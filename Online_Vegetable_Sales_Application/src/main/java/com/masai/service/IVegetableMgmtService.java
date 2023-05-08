package com.masai.service;

import java.util.List;

import com.masai.entity.Vegetable;
import com.masai.exception.VegetableException;
import com.masai.exception.VegetableNotFoundException;

public interface IVegetableMgmtService {
	
	public void addVegetable(Vegetable veg);
	public void removeVegetable(Vegetable veg);
	public List<Vegetable> viewAllVegetavles() throws VegetableException, VegetableNotFoundException;
	public List<Vegetable> viewAllVegetableByCategory(String category) throws VegetableException, VegetableNotFoundException;
	public List<Vegetable> viewAllVegetablesByName(String name)throws VegetableException, VegetableNotFoundException;
	public Vegetable viewVegetableById(int vegId);
	public void updateVegetableName(Vegetable vegetable, String name);
	public void updateVegetableType(Vegetable vegetable, String type);
	public void updateVegetablePrice(Vegetable vegetable, double price);
	public void updateVegetableQty(Vegetable vegetable, int quantity);
	public Vegetable viewVegetableByName(String name)throws VegetableException, VegetableNotFoundException;
}
