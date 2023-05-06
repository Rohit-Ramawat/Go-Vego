package com.masai.ui;

import java.util.Scanner;

import com.masai.entity.Admin;
import com.masai.exception.AdminException;
import com.masai.service.IAdminService;
import com.masai.service.IAdminServiceImpl;

public class AdminUI {
	
	public static void adminRegistration(Scanner sc) {
		System.out.print("Enter user id : ");
		String userId = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		System.out.print("Enter role as Admin : ");
		String role = sc.next();
		System.out.print("Enter admin id : ");
		int adminId = sc.nextInt();
		System.out.print("Enter name : ");
		String name = sc.next();
		System.out.print("Enter contact number : ");
		String contactNumber = sc.next();
		System.out.print("Enter email : ");
		String email = sc.next();
		
		Admin admin = new Admin(userId, password, role,adminId, name, contactNumber, email); //Admin entity object
		
		IAdminService iAdmin = new IAdminServiceImpl();
		
		Admin returnedAdmin = iAdmin.addAdmin(admin);
		
	}
	
	public static void adminApproval(Scanner sc) {
		System.out.print("Enter user id : ");
		String userId = sc.next();
		
		IAdminService iAdmin = new IAdminServiceImpl();
		
		Admin admin = iAdmin.viewAdmin(userId);            //<----viewAdmin method calling
		
		if(admin != null) {
			
			System.out.print("Enter code : ");
			String code = sc.next();
			System.out.print("Enter password : ");
			String password = sc.next();
			
			if(code.equals("admin") && password.equals("admin")) {
				
				System.out.println(iAdmin.approveAdmin(admin));
				
			}else {
				System.out.println("Invalid Credentials");
			}
			
		}
	}
	
	public static void adminLogin(Scanner sc) throws AdminException {
		System.out.print("Enter userid : ");
		String userId = sc.next();
		
		IAdminService iAdmin = new IAdminServiceImpl();
		Admin admin = iAdmin.viewAdmin(userId);
		
		if(admin != null ) {
			if(admin.getIsApproved() == 1) {
				
				adminMenu(sc);
				
			}else {
				throw new AdminException("Admin is not approved yet");
			}
			
		}else {
			System.out.println("Invalid userId");
		}
	}
	
	public static void displayAdminMenu() {
		System.out.println("Press 1 for update details");
		System.out.println("Press 0 for Logout");
	}
	
	public static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection : ");
			choice = sc.nextInt();
    		switch(choice) {
    			
    			
    			case 0:
    				System.out.println("You Have Exited from system");
    				break;
    			default:
    				System.out.println("Invalid Selection : "+ choice);
    		}
    	}while(choice != 0);	
	}
	

}
