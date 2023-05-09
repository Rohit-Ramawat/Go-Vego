package com.masai.ui;

import java.util.Scanner;

import com.masai.exception.AdminException;
import com.masai.exception.CustomerAccountDeactivatedException;

public class App 
{	
	
    public static void main( String[] args ) 
    {	
    	
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        do {
        	System.out.println(" --------------------------------------------");
        	System.out.println("|Welcome to Online Vegetable Sale Application|");
        	System.out.println(" --------------------------------------------");
        	System.out.println("|            1. Admin Login                  |");
            System.out.println("|            2. Adimn Registration           |");
            System.out.println("|            3. Adimn Approval               |");
    		System.out.println("|            4. Customer Login               |");
    		System.out.println("|            5. Customer Registration        |");
    		System.out.println("|            0. Exit                         |");
    		System.out.println(" --------------------------------------------");
    		System.out.print("|  Enter Selection : ");
    		choice = sc.nextInt();
    		System.out.println(" --------------------------------------------");
    		switch(choice) {
    			case 1:
    				try {
    					AdminUI.adminLoginUI(sc);
    				} catch (AdminException e) {
    					System.out.println(e.getMessage());
    				}
    				break;
    			case 2:
    				AdminUI.adminRegistrationUI(sc);
    				break;
    			case 3:
    				AdminUI.adminApprovalUI(sc);
    				break;	
    			case 4:
					try {
						CustomerUI.userLogin(sc);
					} catch (CustomerAccountDeactivatedException e) {
						System.out.println(e.getMessage());
					}
    				break;
    			case 5:
    				CustomerUI.customerRegistration(sc);
    				break;
    			case 0:
    				System.out.println("Thankyou for using our servies");
    				break;
    			default:
    				System.out.println("Invalid Selection : "+choice);
             }
        }while(choice != 0);
        
        
        sc.close();
      }  
}
