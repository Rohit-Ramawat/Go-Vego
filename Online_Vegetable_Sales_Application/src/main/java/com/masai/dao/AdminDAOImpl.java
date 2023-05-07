package com.masai.dao;

import com.masai.entity.Admin;
import com.masai.entity.User;
import com.masai.exception.AdminAlreadyExistException;
import com.masai.exception.AdminException;
import com.masai.exception.AdminNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public Admin addAdminToDB(Admin admin) throws AdminException, AdminAlreadyExistException {
		
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction(); 
		
		try { 
			
			User user = em.find(Admin.class, admin.getUserId());
			
			if(user != null) {
				throw new AdminAlreadyExistException("Admin with this userId had already registered"); 
			}
			
			et.begin();
			em.persist(admin);
			
			
		} catch ( PersistenceException e) {
			 throw new AdminException("Unable to process request try again");
		} finally {
			et.commit();
			em.close();
		}
		
		return admin;
	}

	@Override
	public Admin viewAdminDB(String userId) throws AdminNotFoundException {
		
		EntityManager em = EmUtils.getEntityManager();
		
		Admin user = em.find(Admin.class, userId);
		
		if(user == null) {
			throw new AdminNotFoundException("Admin with this userId is not registered"); 
		}
		em.close();
		return user;
	}

	@Override
	public void approveAdminDB(Admin admin) throws AdminException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			admin.setIsApproved(1);
			em.merge(admin); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new AdminException("Unable to process request try again"); 
		}finally {
			em.close();
		}
	}

	@Override
	public void updateAdminPasswordDB(Admin admin, String newPass) throws AdminException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			admin.setPassword(newPass);
			em.merge(admin); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new AdminException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateAdminContactInfoDB(Admin admin, String newContact) throws AdminException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			admin.setContactNumber(newContact);
			em.merge(admin); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new AdminException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateAdminEmailDB(Admin admin, String newEmail) throws AdminException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			admin.setEmailId(newEmail);
			em.merge(admin); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new AdminException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateAdminNameDB(Admin admin, String newName) throws AdminException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			admin.setName(newName);
			em.merge(admin); // persist changes to the database
			et.commit();
			
		} catch (PersistenceException e) {
			throw new AdminException("Unable to process request try again"); 
		}finally {
			em.close();
		}
		
	}

	@Override
	public void removeAdminDB(Admin admin) throws AdminException {
		EntityManager em = EmUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			if (!em.contains(admin)) {
				admin = em.merge(admin); // re-attach the entity to the persistence context
			}
			em.remove(admin);
			et.commit();
			
		} catch (PersistenceException e) {
			throw new AdminException("Unable to process request try again"); 
		}finally {
			em.close();
		}
	}
}
