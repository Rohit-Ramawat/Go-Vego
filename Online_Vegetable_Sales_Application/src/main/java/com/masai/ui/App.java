package com.masai.ui;

import java.util.Scanner;

public class App 
{	
	static void displayAdminMenu() {
		System.out.println("Press 0 for Logout");
	}
	
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
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
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
	
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        do {
        	System.out.println("1. Admin Login");
    		System.out.println("2. Customer Login");
    		System.out.println("3. Customer Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				adminLogin(sc);
    				break;
    			case 2:
    				CustomerUI.userLogin(sc);
    				break;
    			case 3:
    				CustomerUI.customerRegistration(sc);
    				break;
    			case 0:
    				System.out.println("Thankyou for using the our servies");
    				break;
    			default:
    				System.out.println("Invalid Selection : "+choice);
             }
        }while(choice != 0);
        
        sc.close();
      }  
}
