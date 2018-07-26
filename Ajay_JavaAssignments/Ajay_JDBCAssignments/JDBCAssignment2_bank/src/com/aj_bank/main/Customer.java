package com.aj_bank.main;

import java.util.Scanner;

import com.aj_bank.customer.dao.CustomerDaoImpl;

public class Customer {
public  int customerMenu(String nm,String pw)
{
	CustomerDaoImpl c=new CustomerDaoImpl();
	 Scanner in=new Scanner(System.in);
	    System.out.println("|-------------------------------------------|");  
	    System.out.println("|Welcome to Simple Banking application    |");  
	    System.out.println("|-------------------------------------------|");  
boolean exit=false;
	    int choice=0;
	    while(!exit)
	        {
	        
	        System.out.println("\n\n|-------------------------|");	
	        System.out.println("|     Enter your Choice   |");
	        System.out.println("|-------------------------|");
	        System.out.println("  1:Add Deposit            ");
	        System.out.println("  2:WithDraw amount        ");
	        System.out.println("  3:Transfer money         ");
	        System.out.println("  4:Balency Enguirey       ");
	        System.out.println("  5.exit the application   ");
	        System.out.println("|-------------------------|\n\n");
	        System.out.print("choice :");
	        choice=in.nextInt();
	        switch(choice)
	            {
	            case 1:
	                
	              c.addDeposit(nm, pw);
	                break;
	            case 2:
	                //withDraw();
	            	c.withdrawAmount(nm, pw);
	                break;
	            case 3:
	               // transfer();
	            	c.transferAmount(nm, pw);
	                break;

	            case 4:
	                c.enqiry(nm, pw);
	                break;
	                
	            case 5:
	                exit=true;
	                 System.out.println("|-------------------------------------------|");  
	                 System.out.println("|  Exiting  the  Banking application        |");  
	                 System.out.println("|-------------------------------------------|");  
	                break;
	            default:
	                System.out.println("Wrong choice! please choose 1-5");
	                break;

	            }		
	        }
	    return 0;

}
}
