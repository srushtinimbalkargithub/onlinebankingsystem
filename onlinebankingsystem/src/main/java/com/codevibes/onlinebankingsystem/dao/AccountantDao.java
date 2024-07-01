package com.codevibes.onlinebankingsystem.dao;

import com.codevibes.onlinebankingsystem.entity.Accountant;
import com.codevibes.onlinebankingsystem.entity.Customer;
import com.codevibes.onlinebankingsystem.exception.AccountantException;
import com.codevibes.onlinebankingsystem.exception.CustomerException;

public interface AccountantDao {
	
	public Accountant LoginAccountant(String accountantUsername , String accountantPassword )throws AccountantException;
	
	public int addCustomer(String customerName , String customerMail , String customerPassword, String customerMobile , String customerAddress)throws CustomerException;
	
	public String addAccount(int customerBalance , int cid)throws CustomerException;
	
	public String updateCustomer(int customerAccountNumber , String customerAddress)throws CustomerException;
	
	public String deleteAccount (int customerAccountNumber ) throws CustomerException;
	
	public Customer viewCustomer(String customerAccountNumber )throws CustomerException;
	
	public Customer viewAllCustomer() throws CustomerException;

}
