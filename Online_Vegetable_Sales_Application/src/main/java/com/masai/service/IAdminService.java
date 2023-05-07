package com.masai.service;

import com.masai.entity.Admin;

public interface IAdminService {
	
	public Admin addAdmin(Admin admin);
	
	public void updateAdminPassword(Admin admin,String newPass);
	
	public void updateAdminContactInfo(Admin admin,String newContact);
	
	public void updateAdminEmail(Admin admin,String newEmail);
	
	public void updateAdminName(Admin admin,String newName);
	
	public void removeAdmin(Admin admin);
	
	public Admin viewAdmin(String userId);
	
	public String approveAdmin(Admin admin);
}
