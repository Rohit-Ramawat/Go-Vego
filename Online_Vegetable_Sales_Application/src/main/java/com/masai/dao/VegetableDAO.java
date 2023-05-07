package com.masai.dao;

import java.util.List;

import com.masai.entity.Vegetable;
import com.masai.exception.VegetableAlreadyExistException;
import com.masai.exception.VegetableException;
import com.masai.exception.VegetableNotFoundException;

public interface VegetableDAO {
	
	public String addVegetableDB(Vegetable vegetable) throws VegetableAlreadyExistException, VegetableException;
	
	public Vegetable viewVegitableByIdDB(int id) throws VegetableNotFoundException;

	public void updateVegetableNameDB(Vegetable vegetable, String name) throws VegetableException;

	public void updateVegetableTypeDB(Vegetable vegetable, String type) throws VegetableException;

	public void updateVegetablePriceDB(Vegetable vegetable, double price) throws VegetableException;

	public void updateVegetableQtyDB(Vegetable vegetable, int quantity) throws VegetableException;

	public void removeVegetableDB(Vegetable veg) throws VegetableException;

	public List<Vegetable> viewAllVegetableDB() throws VegetableException, VegetableNotFoundException;

	public List<Vegetable> viewAllVegetableByCategoryDB(String category)throws VegetableException, VegetableNotFoundException;

	public List<Vegetable> viewAllVegetableByNameDB(String name)throws VegetableException, VegetableNotFoundException;
}
