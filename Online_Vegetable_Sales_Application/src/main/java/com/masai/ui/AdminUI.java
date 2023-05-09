package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.entity.Admin;
import com.masai.entity.Customer;
import com.masai.entity.Vegetable;
import com.masai.exception.AdminException;
import com.masai.exception.VegetableException;
import com.masai.exception.VegetableNotFoundException;
import com.masai.service.IAdminService;
import com.masai.service.IAdminServiceImpl;
import com.masai.service.ICustomerService;
import com.masai.service.ICustomerServiceImpl;
import com.masai.service.IVegetableMgmtService;
import com.masai.service.IVegetableMgmtServiceImpl;

public class AdminUI {
	
	public static void displayAdminMenuUI() {
		System.out.println(" ---------------------------------------------");
		System.out.println("|                 ADMIN MENU                  |");
		System.out.println(" ---------------------------------------------");
		System.out.println("|       1. Update details                     |");
		System.out.println("|       2. Delete your account                |");
		System.out.println("|       3. Add vegetable                      |");
		System.out.println("|       4. Update vegetable                   |");
		System.out.println("|       5. Remove vegetable                   |");
		System.out.println("|       6. View all vegetables                |");
		System.out.println("|       7. View all vegetables by category    |");
		System.out.println("|       8. View all vegetables by name        |");
		System.out.println("|       0. Logout                             |");
		System.out.println(" ---------------------------------------------");
	}
	
	public static void adminMenuUI(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenuUI();
			System.out.print("Enter selection : ");
			choice = sc.nextInt();
			System.out.println("---------------------------------------------");
    		switch(choice) {
    			case 1:
    				updateAdminUI(sc);
    				break;
    			case 2:
    				deleteAdminUI(sc);
    				break;
    			case 3:
    				addVegetableUI(sc);
    				break;
    			case 4:
    				updateVegetableUI(sc);
    				break;	
    			case 5:
    				removeVegetableUI(sc);
    				break;
    			case 6:
    				viewAllVegetableUI();
    				break;
    			case 7:
    				viewAllVegetableByCategoryUI(sc);
    				break;	
    			case 8:
    				viewAllVegetableByNameUI(sc);
    				break;
//    			case 9:
//    				viewAllCustomersUI();
//    				break;
    			case 0:
    				System.out.println("Logged out");
    				break;
    			default:
    				System.out.println("Invalid Selection : "+ choice);
    		}
    	}while(choice != 0);	
	}

	public static void adminRegistrationUI(Scanner sc) {
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
	
	public static void adminApprovalUI(Scanner sc) {
		System.out.print("Enter user id : ");
		String userId = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		
		IAdminService iAdmin = new IAdminServiceImpl();
		
		Admin admin = iAdmin.viewAdmin(userId);            //<----viewAdmin method calling
		
		if(admin != null && admin.getPassword().equals(password)) {
			
			System.out.print("Enter security code : ");
			String code = sc.next();
			System.out.print("Enter security password : ");
			String securityPass = sc.next();
			
			if(code.equals("admin") && securityPass.equals("admin")) {
				
				System.out.println(iAdmin.approveAdmin(admin));
				
			}else {
				System.out.println("Invalid Credentials");
			}
			
		}
	}
	
	public static void adminLoginUI(Scanner sc) throws AdminException {
		System.out.print("Enter userid : ");
		String userId = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		IAdminService iAdmin = new IAdminServiceImpl();
		Admin admin = iAdmin.viewAdmin(userId);
		
		if(admin != null && admin.getPassword().equals(password)) {
			if(admin.getIsApproved() == 1) {
				
				adminMenuUI(sc);
				
			}else {
				throw new AdminException("Admin is not approved yet");
			}
		}else {
			System.out.println("wrong password");
		}
	}
	
	public static void deleteAdminUI(Scanner sc) {
		System.out.print("Enter user id : ");
		String userId = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		
		IAdminService iAdmin = new IAdminServiceImpl();
		Admin admin = iAdmin.viewAdmin(userId);
		
		if(admin != null ) {
			if(admin.getPassword().equals(password)) {
				iAdmin.removeAdmin(admin);
				System.out.println("Admin details deleted successfully");
				System.exit(0);
			}else {
				System.out.println("Please enter correct password"); 
			}
		}
	}

	public static void updateAdminUI(Scanner sc) {
		System.out.print("Re-enter user id : ");
		String userId = sc.next();
		
		IAdminService iAdmin = new IAdminServiceImpl();
		Admin admin = iAdmin.viewAdmin(userId);
		
		if(admin != null ) {
			int choice = 0;
			do {
				System.out.println("----------------------------");
				System.out.println("1. To change password ");
				System.out.println("2. To change contact number ");
				System.out.println("3. To change email ");
				System.out.println("4. To change name ");
				System.out.println("0. for back ");
				System.out.println("----------------------------");
				System.out.print("Enter your choice : ");
				choice = sc.nextInt();
				System.out.println("----------------------------");
				
				switch (choice) {
				case 1: 
					System.out.print("Enter new password : ");
					String newPass = sc.next();
					iAdmin.updateAdminPassword(admin, newPass);
					break;
				case 2: 
					System.out.print("Enter new contact number : ");
					String newContact = sc.next();
					iAdmin.updateAdminContactInfo(admin, newContact);
					break;
				case 3: 
					System.out.print("Enter new email : ");
					String email = sc.next();
					iAdmin.updateAdminEmail(admin, email);
					break;
				case 4: 
					System.out.print("Enter new name : ");
					String name = sc.next();
					iAdmin.updateAdminName(admin, name);
					break;
				case 0: 
					break;	
				default:
					throw new IllegalArgumentException("Invalid Selection : " + choice);
				}
			}while(choice != 0);
			
		}
		
	}
	
	public static void addVegetableUI(Scanner sc) {
		
		System.out.print("Enter vegetable name : ");
		String name = sc.next();
		System.out.print("Enter vegetable type : ");
		String type = sc.next();
		System.out.print("Enter vegetable price : ");
		double price = sc.nextDouble();
		System.out.print("Enter vegetable Quantity : ");
		int quantity = sc.nextInt();
		
		Vegetable vegetable = new Vegetable(name, type, price, quantity);
		
		IVegetableMgmtService iVeg = new IVegetableMgmtServiceImpl();
		
		iVeg.addVegetable(vegetable);
	}
	
	public static void updateVegetableUI(Scanner sc) {
		System.out.print("Enter vegetable id : ");
		int vegId = sc.nextInt();
		
		IVegetableMgmtService iVeg = new IVegetableMgmtServiceImpl();
		Vegetable vegetable = iVeg.viewVegetableById(vegId);
		
		if(vegetable != null ) {
			int choice = 0;
			do {
				System.out.println("-----------------------");
				System.out.println("1. To change name ");
				System.out.println("2. To change type ");
				System.out.println("3. To change price ");
				System.out.println("4. To change quantity ");
				System.out.println("0. for back ");
				System.out.println("-----------------------");
				System.out.print("Enter your choice : ");
				choice = sc.nextInt();
				System.out.println("-----------------------");
				
				switch (choice) {
				case 1: 
					System.out.print("Enter new name : ");
					String name = sc.next();
					iVeg.updateVegetableName(vegetable,name);
					break;
				case 2: 
					System.out.print("Enter new type : ");
					String type = sc.next();
					iVeg.updateVegetableType(vegetable,type);
					break;
				case 3: 
					System.out.print("Enter new price : ");
					double price = sc.nextDouble();
					iVeg.updateVegetablePrice(vegetable,price);
					break;
				case 4: 
					System.out.print("Enter new quantity : ");
					int quantity = sc.nextInt();
					iVeg.updateVegetableQty(vegetable,quantity);
					break;
				case 0: 
					break;	
				default:
					throw new IllegalArgumentException("Invalid Selection : " + choice);
				}
			}while(choice != 0);
		}	
	}
	
	public static void removeVegetableUI(Scanner sc) {
		System.out.print("Enter vegetable id : ");
		int vegId = sc.nextInt();
		
		IVegetableMgmtService iVeg = new IVegetableMgmtServiceImpl();
		Vegetable vegetable = iVeg.viewVegetableById(vegId);
		
		if(vegetable != null) {
			iVeg.removeVegetable(vegetable);
		}
		
	}

	public static void viewAllVegetableUI() {
		IVegetableMgmtService iVeg = new IVegetableMgmtServiceImpl();
		List<Vegetable> vegetableList;
		try {
			vegetableList = iVeg.viewAllVegetavles();
			System.out.println("-----------------------------------------------------------------------------");
			for(Vegetable v : vegetableList) {
				System.out.println("| Vegetable Name : "+v.getName()+"  Type : "+v.getType()+
								 "  Price : "+v.getPrice()+" /-Kg"+"  Quantity : "+v.getQuantity()+" Kg      ");		
			}
			System.out.println("-----------------------------------------------------------------------------");
		} catch (VegetableException | VegetableNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void viewAllVegetableByCategoryUI(Scanner sc) {
		System.out.print("Enter Category name : ");
		String category = sc.next();
		
		IVegetableMgmtService iVeg = new IVegetableMgmtServiceImpl();
		List<Vegetable> vegetableList;
		try {
			vegetableList = iVeg.viewAllVegetableByCategory(category);
			System.out.println("-----------------------------------------------------------------------------");
			for(Vegetable v : vegetableList) {
				System.out.println("| Vegetable Name : "+v.getName()+"  Type : "+v.getType()+
								 "  Price : "+v.getPrice()+" /-Kg"+"  Quantity : "+v.getQuantity()+" Kg      ");		
			}
			System.out.println("-----------------------------------------------------------------------------");
		} catch (VegetableException | VegetableNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
	}

	public static void viewAllVegetableByNameUI(Scanner sc) {
		System.out.print("Enter  name : ");
		String name = sc.next();
		
		IVegetableMgmtService iVeg = new IVegetableMgmtServiceImpl();
		List<Vegetable> vegetableList;
		try {
			vegetableList = iVeg.viewAllVegetablesByName(name);
			System.out.println("-----------------------------------------------------------------------------");
			for(Vegetable v : vegetableList) {
				System.out.println("| Vegetable Name : "+v.getName()+"  Type : "+v.getType()+
								 "  Price : "+v.getPrice()+" /-Kg"+"  Quantity : "+v.getQuantity()+" Kg      ");		
			}
			System.out.println("-----------------------------------------------------------------------------");
		} catch (VegetableException | VegetableNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
//	public static void viewAllCustomersUI() {
//		ICustomerService iCust = new ICustomerServiceImpl();
//	 	List<Customer> customers = iCust.viewAllCustomer();
//	 	
//	 	if(customers != null) {
//	 		for(Customer c : customers) {
//	 			System.out.println(c);
//	 		}
//	 	}
//	}
}


