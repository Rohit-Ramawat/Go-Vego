package com.masai.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmUtils {
	
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("vegetableConnect");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
