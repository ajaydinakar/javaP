package com.aj_feereport.main;

import java.util.Scanner;

import com.aj_feereport.student.dao.*;

public class AccountantMenu {
	public static void acountntMenu(){
		StudentDaoImpl accounts = new StudentDaoImpl();
		/* CourseDaoImpl courseDao=new CourseDaoImpl();
		 FeesDaoImpl feeDao=new FeesDaoImpl();*/

		Scanner sc = new Scanner(System.in);
		boolean logout=false;
		while (!logout) {
		System.out.println("----------------------------");
		System.out.println(" STUDENT Fee Report MANAGEMENT SYSTEM  ");
		System.out.println("----------------------------");
		System.out.println("|  1. Add STUDENT              |");
		System.out.println("|  2. View STUDENT             |");
		System.out.println("|  3. Edit STUDENT              |");
		System.out.println("|  4. Fee Due                 |");
		System.out.println("|  5. Logout                 |");
		System.out.println("----------------------------");
		System.out.println("Enter Your choice ?");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1: accounts.addStudent();
		        break;
		case 2:
			accounts.viewStudents();
			//System.out.println("Under Development");
		       break;
		       
		case 3:
			accounts.editStudent();
			//System.out.println("Under Development");
		       break;
		case 4:
			//feeDao.menu();
			//System.out.println("Under Development");
		       break;
		case 5:logout=true;
		FeeReportManagemntSystem.main(null);    
		       break;
		default:System.out.println("Please select choice range 1-4 only");       
		}
		
		}
	}

}
