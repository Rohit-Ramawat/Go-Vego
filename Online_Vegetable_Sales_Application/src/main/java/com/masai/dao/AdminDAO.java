package com.masai.dao;

import com.masai.entity.Admin;
import com.masai.exception.AdminAlreadyExistException;
import com.masai.exception.AdminException;
import com.masai.exception.AdminNotFoundException;

public interface AdminDAO {
	
	public Admin addAdminToDB(Admin admin) throws AdminException, AdminAlreadyExistException;
	public Admin viewAdminDB(String userId) throws AdminNotFoundException;
	public void approveAdmin(Admin admin) throws AdminException;
}
