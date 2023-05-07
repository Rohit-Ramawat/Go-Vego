package com.masai.dao;

import com.masai.entity.Admin;
import com.masai.exception.AdminAlreadyExistException;
import com.masai.exception.AdminException;
import com.masai.exception.AdminNotFoundException;

public interface AdminDAO {
	
	public Admin addAdminToDB(Admin admin) throws AdminException, AdminAlreadyExistException;
	
	public Admin viewAdminDB(String userId) throws AdminNotFoundException;
	
	public void approveAdminDB(Admin admin) throws AdminException;
	
	public void updateAdminPasswordDB(Admin admin,String newPass) throws AdminException;
	
	public void updateAdminContactInfoDB(Admin admin,String newContact)throws AdminException;
	
	public void updateAdminEmailDB(Admin admin,String newEmail)throws AdminException;
	
	public void updateAdminNameDB(Admin admin,String newName)throws AdminException;
	
	public void removeAdminDB(Admin admin) throws AdminException;
}
