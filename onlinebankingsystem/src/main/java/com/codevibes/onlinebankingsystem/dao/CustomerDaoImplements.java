package com.codevibes.onlinebankingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codevibes.onlinebankingsystem.databaseconnection.DatabaseConnection;
import com.codevibes.onlinebankingsystem.entity.Customer;
import com.codevibes.onlinebankingsystem.exception.CustomerException;

public class CustomerDaoImplements implements CustomerDao {

	@Override
	public Customer LoginCustomer(String customerUsername, String customerPassword, int customerAccountNumber)
			throws CustomerException {
		
		
		Customer customer = null;
		try(Connection conn = DatabaseConnection.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on i.cid = a.cid where customerName = ? and customerPassword = ? and customerAccountNumber = ?  ");
			
			ps.setString(1, customerUsername);
			ps.setString(2, customerPassword);
			ps.setInt(3, customerAccountNumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int ac = rs.getInt("customerAccountNumber");
				String n = rs.getString("customerName");
				int b = rs.getInt("customerBalance");
				String e = rs.getString("customerMail");
				String p = rs.getString("customerPassword");
				String m = rs.getString("customerMobile");
				String ad = rs.getString("customerAddress");
				
				customer = new Customer(ac,n,b,e,p,m,ad);
				
			}
			
			else {
				throw new CustomerException("Invalid Customer Name and Password !!!!!!! Please Try Again!!!!!");
			}
		}
		catch(SQLException e) {
			throw new CustomerException(e.getMessage());
			
		}
		
		
		return customer;
	}

	@Override
	public int viewBalance(int customerAccountNumber) throws CustomerException {
		
		
		int b = -1;
		try(Connection conn = DatabaseConnection.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select customerBalance from account where customerAccountNumber = ? ");
			
			
			ps.setInt(1, customerAccountNumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				b = rs.getInt("customerBalance");
			}
			
		}
		catch(SQLException e)
		{
			throw new CustomerException(e.getMessage());
		}
		return b;
	}

	@Override
	public int Deposite(int customerAccountNumber, int amount) throws CustomerException {
		
		
		int b = -1;
				
		try(Connection conn = DatabaseConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update account set customerBalance =  customerBalance + ?  where customerAccountNumber = ? ");
			
			ps.setInt(1, amount);
			ps.setInt(2, customerAccountNumber);
			int rs = ps.executeUpdate();
			
			
			
		}
		catch(SQLException e)
		{
			throw new CustomerException(e.getMessage());
		}
		return b;
	}

	@Override
	public int withdraw(int customerAccountNumber, int amount) throws CustomerException {
		
		
		
		int vb = viewBalance(customerAccountNumber);
		
		if(vb > amount) {
			try(Connection conn = DatabaseConnection.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement(" update account set  customerBalance =  customerBalance - ? where customerAccountNumber = ?");
				
				ps.setInt(1, amount);
				ps.setInt(2, customerAccountNumber);
				
				
				int rs = ps.executeUpdate();
				
			}
			catch(SQLException e) {
				throw new CustomerException(e.getMessage());
				
			}
		}
			
			else {
				throw new CustomerException("Insufficient Balance"); 
			}
			
		
		
		return vb + amount;
	}

	@Override
	public int Transfer(int customerAccountNumber, int amount, int customerAccountNumber2) throws CustomerException {
		
		
		int vb = viewBalance(customerAccountNumber);
		
		if(vb > amount && checkAccount(customerAccountNumber2)) {
			
			int wit = withdraw(customerAccountNumber, amount);
			int dep = Deposite(customerAccountNumber2, amount);
			
		}
		else {
			throw new CustomerException("Insufficient Balance");
		}
			
		return 0;
	}

	private boolean checkAccount(int customerAccountNumber) {
		
		
		try(Connection conn = DatabaseConnection.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from account where customerAccountNumber = ? ");
			
			ps.setInt(1, customerAccountNumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}
		
		return false;
	}
	
	
	
	

}
