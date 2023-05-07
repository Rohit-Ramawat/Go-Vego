package com.masai.service;

import com.masai.dao.AdminDAO;
import com.masai.dao.AdminDAOImpl;
import com.masai.entity.Admin;
import com.masai.exception.AdminAlreadyExistException;
import com.masai.exception.AdminException;
import com.masai.exception.AdminNotFoundException;

public class IAdminServiceImpl implements IAdminService {

	@Override
	public Admin addAdmin(Admin admin) {
		AdminDAO aDAO = new AdminDAOImpl();
		try {
			aDAO.addAdminToDB(admin);
		} catch (AdminException | AdminAlreadyExistException e) {
			System.out.println(e.getMessage());
		}
		
		return admin;
	}

	@Override
	public void removeAdmin(Admin admin) {
		AdminDAO aDAO = new AdminDAOImpl();
		
		try {
			aDAO.removeAdminDB(admin);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Admin viewAdmin(String userId) {
		
		Admin admin = null;
		
		AdminDAO aDAO = new AdminDAOImpl();
		
		try {
			admin = aDAO.viewAdminDB(userId);
			
		} catch (AdminNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return admin;
	}

	@Override
	public String approveAdmin(Admin admin) {
		AdminDAO aDAO = new AdminDAOImpl();
		try {
			aDAO.approveAdminDB(admin);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		return "Admin account has been approved";
	}



	@Override
	public void updateAdminPassword(Admin admin, String newPass) {
		AdminDAO aDAO = new AdminDAOImpl();
		try {
			aDAO.updateAdminPasswordDB(admin, newPass);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Admin password updated");
	}



	@Override
	public void updateAdminContactInfo(Admin admin, String newContact) {
		AdminDAO aDAO = new AdminDAOImpl();
		try {
			aDAO.updateAdminContactInfoDB(admin, newContact);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Admin contact number updated");
	}



	@Override
	public void updateAdminEmail(Admin admin, String newEmail) {
		AdminDAO aDAO = new AdminDAOImpl();
		try {
			aDAO.updateAdminEmailDB(admin, newEmail);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Admin email updated");
		
	}



	@Override
	public void updateAdminName(Admin admin, String newName) {
		AdminDAO aDAO = new AdminDAOImpl();
		try {
			aDAO.updateAdminNameDB(admin, newName);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Admin name updated");
		
	}

}
