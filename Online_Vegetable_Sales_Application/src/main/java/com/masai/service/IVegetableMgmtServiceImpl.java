package com.masai.service;

import java.util.List;

import com.masai.dao.VegetableDAO;
import com.masai.dao.VegetableDAOImpl;
import com.masai.entity.Vegetable;
import com.masai.exception.VegetableAlreadyExistException;
import com.masai.exception.VegetableException;
import com.masai.exception.VegetableNotFoundException;

public class IVegetableMgmtServiceImpl implements IVegetableMgmtService {

	@Override
	public void addVegetable(Vegetable veg) {
		VegetableDAO vDAO = new VegetableDAOImpl();
		try {
			System.out.println(vDAO.addVegetableDB(veg));
		} catch (VegetableAlreadyExistException | VegetableException e) {
			System.out.println(e.getMessage()); 
		}
	}


	@Override
	public void removeVegetable(Vegetable veg) {
		VegetableDAO vDAO = new VegetableDAOImpl();
		try {
			vDAO.removeVegetableDB(veg);
		} catch (VegetableException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Vegetable details removed successfully");
	}

	@Override
	public List<Vegetable> viewAllVegetavles() throws VegetableException, VegetableNotFoundException {
	
		VegetableDAO vDAO = new VegetableDAOImpl();
		
		List<Vegetable> vegList = vDAO.viewAllVegetableDB();
		
		return vegList;
	}

	@Override
	public List<Vegetable> viewAllVegetableByCategory(String category) throws VegetableException, VegetableNotFoundException {
		
		VegetableDAO vDAO = new VegetableDAOImpl();
		
		List<Vegetable> vegList = vDAO.viewAllVegetableByCategoryDB(category);
		
		return vegList;
	}

	@Override
	public List<Vegetable> viewAllVegetablesByName(String name) throws VegetableException, VegetableNotFoundException {
		VegetableDAO vDAO = new VegetableDAOImpl();
		
		List<Vegetable> vegList = vDAO.viewAllVegetableByNameDB(name);
		
		return vegList;
	}
	
	@Override
	public Vegetable viewVegetableByName(String name) throws VegetableException, VegetableNotFoundException {
		VegetableDAO vDAO = new VegetableDAOImpl();
		
		Vegetable veg = vDAO.viewVegetableByNameDB(name);
		
		return veg;
	}
	
	@Override
	public Vegetable viewVegetableById(int vegId) {
		VegetableDAO vDAO = new VegetableDAOImpl();
		Vegetable vegetable = null;
		try {
			vegetable = vDAO.viewVegitableByIdDB(vegId);
		} catch (VegetableNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return vegetable;
	}

	@Override
	public void updateVegetableName(Vegetable vegetable, String name) {
		VegetableDAO vDAO = new VegetableDAOImpl();
		try {
			vDAO.updateVegetableNameDB(vegetable,name);
		} catch (VegetableException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Vegetable name updated");
	}

	@Override
	public void updateVegetableType(Vegetable vegetable, String type) {
		VegetableDAO vDAO = new VegetableDAOImpl();
		try {
			vDAO.updateVegetableTypeDB(vegetable,type);
		} catch (VegetableException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Vegetable type updated");
	}

	@Override
	public void updateVegetablePrice(Vegetable vegetable, double price) {
		VegetableDAO vDAO = new VegetableDAOImpl();
		try {
			vDAO.updateVegetablePriceDB(vegetable,price);
		} catch (VegetableException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Vegetable price updated");
	}

	@Override
	public void updateVegetableQty(Vegetable vegetable, int quantity) {
		VegetableDAO vDAO = new VegetableDAOImpl();
		try {
			vDAO.updateVegetableQtyDB(vegetable,quantity);
		} catch (VegetableException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Vegetable quantity updated");
	}


}
