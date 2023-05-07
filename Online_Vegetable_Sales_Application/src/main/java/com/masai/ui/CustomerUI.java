package com.masai.ui;

import java.util.Scanner;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;
import com.masai.service.ICustomerService;
import com.masai.service.ICustomerServiceImpl;

public class CustomerUI {

	public static void customerRegistration(Scanner sc) {
		System.out.print("Enter user id : ");
		String userId = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		System.out.print("Enter role as Customer : ");
		String role = sc.next();
		System.out.print("Enter customer id : ");
		int customerId = sc.nextInt();
		System.out.print("Enter name : ");
		String name = sc.next();
		System.out.print("Enter mobile number : ");
		String mobileNumber = sc.next();
		
		//Address fields
		System.out.print("Enter flatNo : ");
		String flatNo = sc.next();
		System.out.print("Enter buildingName : ");
		String buildingName = sc.next();
		System.out.print("Enter area : ");
		String area = sc.next();
		System.out.print("Enter city : ");
		String city = sc.next();
		System.out.print("Enter state : ");
		String state = sc.next();
		System.out.print("Enter pincode : ");
		String pincode = sc.next();
		
		Address address = new Address(flatNo, buildingName, area, city, state, pincode);
		
		System.out.print("Enter email : ");
		String email = sc.next();
		System.out.print("Enter email password : ");
		String emailpassword = sc.next();
		
		Customer customer = new Customer(userId, password, role, customerId, name, mobileNumber,
										 address, email, emailpassword, 0, null, null, null, null);
		
		ICustomerService iCus = new ICustomerServiceImpl();
		
		try {
			iCus.addCustomer(customer);
			System.out.println("Customer registered succefully");
		} catch (CustomerAlreadyExistException | CustomerException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public static void displayCustomerMenuUI() {
		System.out.println("Press 0 for Logout");
	}
	
	public static void customerMenuUI(Scanner sc) {
		int choice = 0;
		do {
			displayCustomerMenuUI();
			System.out.print("Enter selection : ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				
    				break;
    			case 2:
    				
    				break;
    			case 3:
    				
    				break;
    			case 4:
    				
    				break;	
    			case 5:
    				
    				break;
    			case 6:
    				
    				break;
    			case 7:
    				
    				break;	
    			case 8:
    				
    				break;
    			case 0:
    				System.out.println("Logged out");
    				break;
    			default:
    				System.out.println("Invalid Selection : "+ choice);
    		}
    	}while(choice != 0);	
	}

	public static void userLogin(Scanner sc) {
		
		
	}
}
