package com.masai.dao;

import java.util.List;

import com.masai.entity.Vegetable;
import com.masai.exception.VegetableAlreadyExistException;
import com.masai.exception.VegetableException;
import com.masai.exception.VegetableNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class VegetableDAOImpl implements VegetableDAO {

	@Override
	public String addVegetableDB(Vegetable vegetable) throws VegetableAlreadyExistException, VegetableException {
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EmUtils.getEntityManager();
			
			Vegetable veg = em.find(Vegetable.class, vegetable.getVegId());
			
			if(veg != null ) {
				throw new VegetableAlreadyExistException("Vegitable with id already present");
			}else {
				
				et = em.getTransaction();
				et.begin();
				em.persist(vegetable);
				
			}
		} catch (PersistenceException e) {
			
			throw new VegetableException("An error occured please try again"); 
			
		} finally {
			et.commit();
			em.close();
		}
		
		return "Vegetable details successfully addedd";
	}

	@Override
	public Vegetable viewVegitableByIdDB(int id) throws VegetableNotFoundException {
		EntityManager em = EmUtils.getEntityManager();
		
		Vegetable vegetable = em.find(Vegetable.class, id);
		
		if(vegetable == null ) {
			throw new VegetableNotFoundException("No vegetable is present with this id");
		}
		em.close();
		return vegetable;
	}

	@Override
	public void updateVegetableNameDB(Vegetable vegetable, String name) throws VegetableException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			vegetable.setName(name);
			em.merge(vegetable); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new VegetableException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateVegetableTypeDB(Vegetable vegetable, String type) throws VegetableException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			vegetable.setType(type);
			em.merge(vegetable); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new VegetableException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateVegetablePriceDB(Vegetable vegetable, double price) throws VegetableException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			vegetable.setPrice(price);
			em.merge(vegetable); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new VegetableException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateVegetableQtyDB(Vegetable vegetable, int quantity) throws VegetableException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			vegetable.setQuantity(quantity);
			em.merge(vegetable); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new VegetableException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void removeVegetableDB(Vegetable veg) throws VegetableException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			if (!em.contains(veg)) {
				veg = em.merge(veg); // re-attach the entity to the persistence context
			}
			em.remove(veg);
			et.commit();
			
		} catch (PersistenceException e) {
			throw new VegetableException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Vegetable> viewAllVegetableDB() throws VegetableException, VegetableNotFoundException {
		EntityManager em = EmUtils.getEntityManager();
		List<Vegetable> vegList = null;
		try {
			
			String selectQuery = "SELECT v FROM Vegetable v";
			Query query = em.createQuery(selectQuery);
			vegList = query.getResultList();
			
			if(vegList.isEmpty()) {
				throw new VegetableNotFoundException("Vegetables list is empty");
			}
			
		} catch (PersistenceException e) {
			throw new VegetableException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
		return vegList;
	}

	@Override
	public List<Vegetable> viewAllVegetableByCategoryDB(String category) throws VegetableException, VegetableNotFoundException {
		EntityManager em = EmUtils.getEntityManager();
		List<Vegetable> vegList;
		try {
			
			String selectQuery = "SELECT v FROM Vegetable v WHERE v.type = :type";
			Query query = em.createQuery(selectQuery);
			query.setParameter("type", category);
			vegList = query.getResultList();
			
			if(vegList.isEmpty() ) {
				throw new VegetableNotFoundException("No any vegetables are available with this category");
			}
			
		} catch (PersistenceException e) {
			throw new VegetableException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
		return vegList;
	}

	@Override
	public List<Vegetable> viewAllVegetableByNameDB(String name) throws VegetableException, VegetableNotFoundException {
		EntityManager em = EmUtils.getEntityManager();
		List<Vegetable> vegList;
		try {
			
			String selectQuery = "SELECT v FROM Vegetable v WHERE v.name = :name";
			Query query = em.createQuery(selectQuery);
			query.setParameter("name", name);
			vegList = query.getResultList();
			
			if(vegList.isEmpty() ) {
				throw new VegetableNotFoundException("No any vegetables are available with this name");
			}
			
		} catch (PersistenceException e) {
			throw new VegetableException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
		return vegList;
	}

}
