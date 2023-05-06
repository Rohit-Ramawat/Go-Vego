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
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin removeAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
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
			aDAO.approveAdmin(admin);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		return "Admin account has been approved";
	}

}
