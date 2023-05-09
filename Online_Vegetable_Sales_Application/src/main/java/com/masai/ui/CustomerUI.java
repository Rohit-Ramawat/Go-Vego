package com.masai.ui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.masai.dao.VegetableDAO;
import com.masai.dao.VegetableDAOImpl;
import com.masai.entity.Address;
import com.masai.entity.BillingDetails;
import com.masai.entity.Customer;
import com.masai.entity.OrderTable;
import com.masai.entity.Vegetable;
import com.masai.exception.BillException;
import com.masai.exception.CustomerAccountDeactivatedException;
import com.masai.exception.CustomerAlreadyExistException;
import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.exception.OrderNotFoundException;
import com.masai.exception.VegetableException;
import com.masai.exception.VegetableNotFoundException;
import com.masai.service.IBillingService;
import com.masai.service.IBillingServiceImpl;
import com.masai.service.ICustomerService;
import com.masai.service.ICustomerServiceImpl;
import com.masai.service.IOrderService;
import com.masai.service.IOrderServiceImpl;
import com.masai.service.IVegetableMgmtService;
import com.masai.service.IVegetableMgmtServiceImpl;

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
		System.out.println(" ---------------------------------------------");
		System.out.println("|               CUSTOMER MENU                 |");
		System.out.println(" ---------------------------------------------");
		System.out.println("|     1. Update personal details              |");
		System.out.println("|     2. View personal details                |");
		System.out.println("|     3. Delete your account                  |");
		System.out.println("|     4. View all vegetables                  |");
		System.out.println("|     5. View all vegetables by category      |");
		System.out.println("|     6. View all vegetables by name          |");
		System.out.println("|     7. Place an order                       |");
		System.out.println("|     8. View order using id                  |");
		System.out.println("|     9. View all of your order               |");
		System.out.println("|    10. Cancel order                         |");
		System.out.println("|     0. Logout                               |");
		System.out.println(" ---------------------------------------------");
	}
	
	public static void customerMenuUI(Scanner sc) {
		int choice = 0;
		do {
			displayCustomerMenuUI();
			System.out.print("Enter selection : ");
			choice = sc.nextInt();
			System.out.println(" ---------------------------------------------");
    		switch(choice) {
    			case 1:
    				updateCustomerUI(sc);
    				break;
    			case 2:
					try {
						viewCustomerDetailsUI(sc);
					} catch (CustomerAccountDeactivatedException e) {
						System.out.println(e.getMessage());
					}
    				break;
    			case 3:
    				deleteCustomerUI(sc);
    				break;
    			case 4:
    				viewAllVegetableUI(sc);
    				break;	
    			case 5:
    				viewAllVegetableByCategoryUI(sc);
    				break;
    			case 6:
    				viewAllVegetableByNameUI(sc);
    				break;
    			case 7:
    				placeOrderUI(sc);
    				break;	
    			case 8:
    				viewOrderByIdUI(sc);
    				break;
    			case 9:
    				viewAllOrderUI(sc);
    				break;
    			case 10:
    				cancelOrderUI(sc);
    			case 0:
    				System.out.println("Logged out");
    				break;
    			default:
    				System.out.println("Invalid Selection : "+ choice);
    		}
    	}while(choice != 0);	
	}

	public static void userLogin(Scanner sc) throws CustomerAccountDeactivatedException {
		System.out.print("Enter userid : ");
		String userId = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		
		ICustomerService iCus = new ICustomerServiceImpl();
		Customer customer = iCus.viewCustomer(userId);
		
		if(customer != null && customer.getPassword().equals(password)) {	
			if(customer.getIsDeleted()==0) {
				customerMenuUI(sc);        //calling customer menu UI
			}else {
				throw new CustomerAccountDeactivatedException("Customer Account is Deactivated");
			}
		}else {
			System.out.println("wrong credentials");
		}
	}
	
	public static void updateCustomerUI(Scanner sc) {
		System.out.print("Re-enter user id : ");
		String userId = sc.next();
		System.out.print("Re-enter password : ");
		String password = sc.next();
		ICustomerService iCus = new ICustomerServiceImpl();
		Customer customer = iCus.viewCustomer(userId);
		
		if(customer != null && customer.getPassword().equals(password)) {
			int choice = 0;
			do {
				System.out.println("---------------------------");
				System.out.println("1. To change password ");
				System.out.println("2. To change mobile number ");
				System.out.println("3. To change email ");
				System.out.println("4. To change name ");
				System.out.println("5. To change address ");
				System.out.println("0. for back ");
				System.out.println("---------------------------");
				System.out.print("Enter your choice : ");
				choice = sc.nextInt();
				System.out.println("---------------------------");
				
				switch (choice) {
				case 1: 
					System.out.print("Enter new password : ");
					String newPass = sc.next();
					iCus.updateCustomerPassword(customer, newPass);
					break;
				case 2: 
					System.out.print("Enter new contact number : ");
					String newContact = sc.next();
					iCus.updateCustomerMobileNumber(customer, newContact);
					break;
				case 3: 
					System.out.print("Enter new email : ");
					String email = sc.next();
					iCus.updateCustomerEmail(customer, email);
					break;
				case 4: 
					System.out.print("Enter new name : ");
					String name = sc.next();
					iCus.updateCustomerName(customer, name);
					break;
				case 5:
					System.out.print("Enter new flatNo : ");
					String flatNo = sc.next();
					System.out.print("Enter new buildingName : ");
					String buildingName = sc.next();
					System.out.print("Enter new area : ");
					String area = sc.next();
					System.out.print("Enter new city : ");
					String city = sc.next();
					System.out.print("Enter new state : ");
					String state = sc.next();
					System.out.print("Enter new pincode : ");
					String pincode = sc.next();
					
					Address address = new Address(flatNo, buildingName, area, city, state, pincode);
					
					iCus.updateAddress(customer,address);
					
				case 0: 
					break;	
				default:
					throw new IllegalArgumentException("Invalid Selection : " + choice);
				}
			}while(choice != 0);
		}
	}
	
	public static void viewCustomerDetailsUI(Scanner sc) throws CustomerAccountDeactivatedException {
		System.out.print("Enter userid : ");
		String userId = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		
		ICustomerService iCus = new ICustomerServiceImpl();
		Customer customer = iCus.viewCustomer(userId);
		
		if(customer != null && customer.getPassword().equals(password)) {	
			if(customer.getIsDeleted()!=0) {
				throw new CustomerAccountDeactivatedException("Customer Account is Deactivated");
			}else {
				System.out.println("Customer Name    = "+customer.getName());
				System.out.println("Customer userId  = "+customer.getUserId());
				System.out.println("Customer mobile  = "+customer.getMobileNumber());
				System.out.println("Customer email   = "+customer.getEmailId());
				System.out.println("Customer Address = "+customer.getAddress());
						           
			}
		}else {
			System.out.println("wrong credentials");
		}
	}
	
	public static void deleteCustomerUI(Scanner sc) {
		System.out.print("Enter userid : ");
		String userId = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		
		ICustomerService iCus = new ICustomerServiceImpl();
		Customer customer = iCus.viewCustomer(userId);
		
		if(customer != null && customer.getPassword().equals(password)) {	
			iCus.removeCustomer(customer);
			System.exit(1);
		}else {
			System.out.println("wrong credentials");
		}
	}
	

	public static void viewAllVegetableByNameUI(Scanner sc) {
		System.out.print("Enter  name : ");
		String name = sc.next();
		
		IVegetableMgmtService iVeg = new IVegetableMgmtServiceImpl();
		List<Vegetable> vegetableList;
		System.out.println("-----------------------------------------------------------------------------");
		try {
			vegetableList = iVeg.viewAllVegetablesByName(name);
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
		System.out.println("-----------------------------------------------------------------------------");
		try {
			vegetableList = iVeg.viewAllVegetableByCategory(category);
			for(Vegetable v : vegetableList) {
				System.out.println("| Vegetable Name : "+v.getName()+"  Type : "+v.getType()+
						 "  Price : "+v.getPrice()+" /-Kg"+"  Quantity : "+v.getQuantity()+" Kg      ");		
			}
			System.out.println("-----------------------------------------------------------------------------");
		} catch (VegetableException | VegetableNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void viewAllVegetableUI(Scanner sc) {
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
	
	public static void placeOrderUI(Scanner sc) {
		System.out.print("Enter userid : ");
		String userId = sc.next();
		
		ICustomerService iCus = new ICustomerServiceImpl();
		Customer customer = iCus.viewCustomer(userId);
		
		if(customer != null) {
			List<Vegetable> vegetableList = getVegetableList(sc);
			Set<Vegetable> vegList = new HashSet<>(vegetableList);
			double total = 0;
			
			for(Vegetable v:vegList) {
				total+=v.getPrice()*v.getQuantity();
			}
			
			OrderTable order = new OrderTable(customer, vegList, total, "Pending", null);
			
			BillingDetails bill = new BillingDetails(order, "Online", LocalDateTime.now(), "Pending", customer.getAddress(), customer);
			
			order.setBillingDetails(bill);   //<-- setting BillingDetails object inside OrderTable object
			
			IOrderService iOrder = new IOrderServiceImpl();
			try {
				iOrder.addOrder(order);
				
				Set<Vegetable> vegSet = order.getVegetableList();  //<--for updating quantity in database vegetable table
				updateVegetableQtyUI(vegSet);
				
				//For customer
				System.out.println("order with id "+order.getOrderId()+" has been placed successfully");
				System.out.println("bill for the above order has been created with bill id "+bill.getBillingId());
			} catch (OrderException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
	public static List<Vegetable> getVegetableList(Scanner sc){
		IVegetableMgmtService iVeg = new IVegetableMgmtServiceImpl();
		
		System.out.print("Enter number of vegetables you want to purchase : ");
		int number = sc.nextInt();
		
		List<Vegetable> vegList = new ArrayList<>();
		
		while(number>0) {
			
			System.out.print("Enter vegetable name : ");
			String name = sc.next();
			
			System.out.print("Enter vegetable quantity(in Kg): ");
			int qty = sc.nextInt();
			
			Vegetable vegetable;
			try {
				vegetable = iVeg.viewVegetableByName(name);
				vegetable.setQuantity(qty);
				vegList.add(vegetable);
				number--;
			} catch (VegetableException | VegetableNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		return vegList;
	}
	
	public static void viewOrderByIdUI(Scanner sc) {
		System.out.print("Enter order id : ");
		int orderId = sc.nextInt();
		
		IOrderService iOrder = new IOrderServiceImpl();
		OrderTable order = iOrder.viewOrder(orderId);
		
		if(order != null) {
			System.out.println("Order id = "+order.getOrderId()+" | Customer name = "+order.getCustomer().getName()+
					" | Order status = "+order.getStatus()+" | Order total = "+order.getTotalAmount());
			
			Set<Vegetable> vegList = order.getVegetableList();
			
			for(Vegetable v : vegList) {
				System.out.println("Vegetable name = "+v.getName()+" | Price = "+v.getPrice());
			}
		}
	}

	public static void viewAllOrderUI(Scanner sc) {
		System.out.println("Re-Enter your user id");
		String userId = sc.next();
		IOrderService iOrder = new IOrderServiceImpl();
		List<OrderTable> orderList = iOrder.viewAllOrders(userId);
		
		for(OrderTable order : orderList) {
				
			System.out.println("Order id = "+order.getOrderId()+" | Customer name = "+order.getCustomer().getName()+
					" | Order status = "+order.getStatus()+" | Order total = "+order.getTotalAmount());
			
			Set<Vegetable> vegList = order.getVegetableList();
			
			for(Vegetable v : vegList) {
				System.out.println("Vegetable name = "+v.getName()+" | Price = "+v.getPrice());
			}

		}
		
	}
	
	//For Database Vegetable Quantity Synchronization after purchasing
	public static void updateVegetableQtyUI(Set<Vegetable> vegSet) {
		IVegetableMgmtService iVeg = new IVegetableMgmtServiceImpl();
		Vegetable vegetable;
		for(Vegetable v : vegSet) {
			try {
				vegetable = iVeg.viewVegetableByName(v.getName());      //<--fetching vegetable from DB
				
				int newQty = vegetable.getQuantity()-v.getQuantity();   //<--updated Qty
				
				iVeg.updateVegetableQty(v, newQty);                     //calling method to update Qty
				
			} catch (VegetableException | VegetableNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

	public static void cancelOrderUI(Scanner sc) {
		System.out.print("Enter your user id : ");
	    String userId = sc.next();

	    System.out.print("Enter the order id to cancel : ");
	    int orderId = sc.nextInt();

	    IOrderService iOrder = new IOrderServiceImpl();
	    try {
	        iOrder.cancelOrder(userId, orderId);
	        System.out.println("Order cancelled successfully.");
	    } catch (OrderNotFoundException | OrderException e) {
	        System.out.println(e.getMessage());
	    }
		
	}
}
