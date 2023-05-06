package com.masai.ui;

import java.util.Scanner;

import com.masai.exception.AdminException;

public class App 
{	
	
    public static void main( String[] args ) 
    {	
    	
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        do {
        	System.out.println("1. Admin Login");
            System.out.println("2. Adimn Registration");
            System.out.println("3. Adimn Approval");
    		System.out.println("4. Customer Login");
    		System.out.println("5. Customer Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				try {
    					AdminUI.adminLogin(sc);
    				} catch (AdminException e) {
    					System.out.println(e.getMessage());
    				}
    				break;
    			case 2:
    				AdminUI.adminRegistration(sc);
    				break;
    			case 3:
    				AdminUI.adminApproval(sc);
    				break;	
    			case 4:
    				CustomerUI.userLogin(sc);
    				break;
    			case 5:
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
