package com.codevibes.onlinebankingsystem;

import java.util.Scanner;

import com.codevibes.onlinebankingsystem.dao.AccountantDao;
import com.codevibes.onlinebankingsystem.dao.AccountantDaoImplementation;
import com.codevibes.onlinebankingsystem.dao.CustomerDao;
import com.codevibes.onlinebankingsystem.dao.CustomerDaoImplements;
import com.codevibes.onlinebankingsystem.entity.Accountant;
import com.codevibes.onlinebankingsystem.entity.Customer;
import com.codevibes.onlinebankingsystem.exception.AccountantException;
import com.codevibes.onlinebankingsystem.exception.CustomerException;

public class App 
{
    public static void main( String[] args )
    {
       
    	Scanner sc = new Scanner(System.in);
    	
    	boolean f = true;
    	
    	while(f) {
    		System.out.println("-------------WELCOME TO ONLINE BANKING SYSTEM------------");
    		System.out.println("------------------------------------------");
    		System.out.println("1. ADMIN LOGIN PORTAL\r\n" + "2. Customer");
    		
    		
    		System.out.println("Choose your Option: ");
    		int choice = sc.nextInt();
    		
    		switch(choice) {
    		
    		case 1: 
    			System.out.println("Admin Login Credentials---------------Accountant");
    			System.out.println("Enter Username: ");
    			String username = sc.next();
    			System.out.println("Enter password: ");
    			String pass = sc.next();
    			
    			
    			
    			AccountantDao ad = new AccountantDaoImplementation();
    			
    			try {
    				Accountant a = ad.LoginAccountant(username, pass);
    				if(a==null)
    				{
    					System.out.println("Wrong Credentials");
    					break;
    				}
    				System.out.println("Login Successful!!!!");
    				
    				System.out.println("Welcome to : "+a.getAccountantUsername() + " as Admin of Online Banking System");
    				
    				
    				boolean y = true;
    				
    				while(y) {
    					System.out.println("-------------------\r\n" 
    				+ " 1. Add New Customer Account \r\n" 
    				+ " 2. Update Customer Address \r\n"
    				+ " 4.View Particular Account Details by Given Account Number  \r\n"
    				+ " 3. Remove/Delete Account by Account Number  \r\n"
    				+ " 5. View All Account/Customer List  \r\n"
    				+ " 6. Account LogOut  \r\n" );
    					
    					
    					int x = sc.nextInt();
    					
    					if(x==1) {
    						System.out.println("------New Account-------");
    						System.out.println("Enter CustomerName: ");
    						String a1 = sc.next();
    						
    						
    						System.out.println("Enter Account Opening Balance: ");
    						int a2 = sc.nextInt();
    						
    						System.out.println("Enter CustomerMail: ");
    						String a3 = sc.next();
    						System.out.println("Enter Customer Password: ");
    						String a4 = sc.next();
    						System.out.println("Enter Customer Mobile Number: ");
    						String a5 = sc.next();
    						System.out.println("Enter Customer Address: ");
    						String a6 = sc.next();
    						
    						int s1 = -1;
    						
    						try {
    							s1 = ad.addCustomer(a1, a3, a4, a5, a6);
    							
    							try {
    								
    								ad.addAccount(a2, s1);
    							}
    							catch(CustomerException e) {
    								e.printStackTrace();
    							}
    						}
    						catch(CustomerException e) {
    							System.out.println(e.getMessage());
    						}
    						System.out.println("Customer Added Successfully");
    						System.out.println("---------------");
    					}
    					
    					if(x==2) {
    						System.out.println("Udate Customer Address.......");
    						System.out.println("Enter Customer Account Number: ");
    						int u = sc.nextInt();
    						System.out.println("Enter new Address: ");
    						String u2 = sc.next();
    						
    						try {
    							String mes = ad.updateCustomer(u, u2);
    						}
    						catch(CustomerException e) {
    							e.printStackTrace();
    						}
    					}
    					
    					if(x == 3) {
    						System.out.println("---------Remove Account--------------");
    						System.out.println("Enter Account Number: ");
    						int ac = sc.nextInt();
    						String s = null;
    						try {
    							
    							s = ad.deleteAccount(ac);
    							
    						}
    						catch(CustomerException e) {
    							
    							e.printStackTrace();
    							
    						}
    						
    						if(s!=null) {
    							System.out.println(s);
    						}
    					}
    					
    					
    					
    					if(x == 4) {
    						
    						System.out.println("-----------------Customer Details-------------------");
    						System.out.println("Enter Customer Account Number: ");
    						String ac = sc.next();
    						
    						
    						
    						try {
    							
    							Customer cus = ad.viewCustomer(ac);
    							
    							if(cus != null) {
    								System.out.println("*******************************");
    								System.out.println("Account Number : " + cus.getCustomerAccountNumber());
    								System.out.println("Name : " + cus.getCustomerName());
    								System.out.println("Balance : " + cus.getCustomerBalance());
    								System.out.println("Email : " + cus.getCustomerMail());
    								System.out.println("Password : " + cus.getCustomerPassword());
    								System.out.println("Mobile Number : " + cus.getCustomerMobile());
    								System.out.println("Address :" + cus.getCustomerAddress());
    								System.out.println("--------------------------------------");
    							}
    							else {
    								System.out.println("Account Does Not Exist....");
    								System.out.println("---------------------------");
    							}
    							
    						}
    						catch(CustomerException e) {
    							e.printStackTrace();
    						
    							
    						}
    					}
    					
    					if(x == 5) {
    						
    						try {
    							System.out.println("----------------------All Customer Lists-------------------");
    							
    							Customer cus = ad.viewAllCustomer();
    						}
    						catch(CustomerException e) {
    							e.printStackTrace();
    							
    						}
    					}
    					
    					if(x == 6) {
    						System.out.println("-------------------Account Logout Successfully!!!!!-----------------");
    						y=false;
    					}
    					
    				}
    				break;
    			}
    			catch(AccountantException e)
    			{
    				System.out.println(e.getMessage());
    			}
    			
    			break;
    			
    			//case 2 start customer Part
    			
    		case 2:
    			System.out.println("LOGIN <<------------------>>  CUSTOMER");
    			System.out.println("-----------------------------");
    			System.out.println("Enter User Name : ");
    			String customerUsername = sc.next();
    			System.out.println("Enter Password : ");
    			String customerPassword = sc.next();
    			System.out.println("Enter Account Number : ");
    			int accountNumber = sc.nextInt();
    			
    			CustomerDao cd = new CustomerDaoImplements();
    			
    			try {
    				
    				Customer cus = cd.LoginCustomer(customerUsername, customerPassword, accountNumber);
    				System.out.println("Welcome :  " + cus.getCustomerName());
    				
    				
    				
    				boolean m = true;
    				
    				while(m) {
    					
    					System.out.println("------------------------\r\n"
    							+ " 1. View Balance \r\n"
    							+ " 2. Deposite Money \r\n"
    							+ " 3. Withdraw Money \r\n"
    							+ " 4. Tranfer Money \r\n"
    							+ " 5. LOGOUT \r\n");
    					
    					
    					
    					int x = sc.nextInt();
    					
    					if(x == 1 ) {
    						System.out.println("-----------------Balance------------------");
    						System.out.println("Current Account Balance : ");
    						System.out.println(cd.viewBalance(accountNumber));
    						System.out.println("--------------------------------");
    					}
    					
    					if(x == 2) {
    						System.out.println("---------------DEPOSITE----------------");
    						System.out.println("Enter Amount to Deposite : ");
    						int am = sc.nextInt();
    						cd.Deposite(accountNumber, am);
    						System.out.println("Your Balance After Deposite : ");
    						
    						
    						System.out.println(cd.viewBalance(accountNumber));
    						System.out.println("------------------------------------");
    					}
    					
    					
    					if(x == 3) {
    						System.out.println("------------------WITHDRAW MONEY------------------------");
    						System.out.println("Enter Withdrawal Amount : ");
    						int am = sc.nextInt();
    						
    						
    						try {
    							
    							cd.withdraw(accountNumber, am);
    							System.out.println("Your Balance After Withdrawal ...........");
    							System.out.println(cd.viewBalance(accountNumber));
    							System.out.println("---------------------------------------");
    							
    						}
    						catch(CustomerException e) {
    							System.out.println(e.getMessage());
    							
    						}
    					}
    					
    					if(x == 4) {
    						System.out.println("---------------AMOUNT TRANSFER------------------");
    						System.out.println("Enter Amount To Transfer : ");
    						int t = sc.nextInt();
    						System.out.println("Enter Account Number To Transfer Amount.......");
    						int ac = sc.nextInt();
    						
    						
    						try {
    							cd.Transfer(accountNumber, t, ac);
    							System.out.println("Amount Transfered Successfully.....!!!!");
    							System.out.println("-----------------------------------------");
    							
    						}
    						catch(Exception e) {
    							System.out.println(e.getMessage());
    							
    						}
    					}
    					
    					//LOGOUT ACTION 
    					if(x == 5) {
    						System.out.println("Customer LOGOUT Successfully!!!");
    						System.out.println("Thank You for using our Banking Services......!!!!!");
    						m = false;
    					}
    					
    				}
    				break;
    				
    			}
    			catch(CustomerException e)
    			{
    				System.out.println(e.getMessage());
    			}
    			
    			
    			
    		}
    		
    	}
    }
}
