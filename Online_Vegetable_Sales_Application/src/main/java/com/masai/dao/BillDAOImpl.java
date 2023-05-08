package com.masai.dao;

import com.masai.entity.BillingDetails;
import com.masai.exception.BillException;
import com.masai.exception.OrderException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class BillDAOImpl implements BillDAO {

	@Override
	public void addBill(BillingDetails bill) throws BillException {
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EmUtils.getEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.persist(bill);
			
		} catch (PersistenceException e) {
			throw new BillException("Unable to process request try again");
		} finally {
			et.commit();
			em.close();
		}

	}

}
