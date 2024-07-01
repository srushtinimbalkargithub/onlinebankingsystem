package com.codevibes.onlinebankingsystem.dao;

import com.codevibes.onlinebankingsystem.entity.Customer;
import com.codevibes.onlinebankingsystem.exception.CustomerException;

public interface CustomerDao {
	
	
	public Customer LoginCustomer(String customerUsername , String customerPassword , int customerAccountNumber) 
			throws CustomerException;
	
	public int viewBalance(int customerAccountNumber)throws CustomerException;
	
	public int Deposite(int customerAccountNumber , int amount )throws CustomerException;
	
	public int withdraw(int customerAccountNumber , int amount )throws CustomerException;
	
	public int Transfer(int customerAccountNumber , int amount , int customerAccountNumber2 )throws CustomerException;

}
