package com.codevibes.onlinebankingsystem.entity;

public class Accountant {
	
	private String accountantUsername;
	private String accountantEmail;
	private String accountantPassword;
	public Accountant(String accountantUsername, String accountantEmail, String accountantPassword) {
		super();
		this.accountantUsername = accountantUsername;
		this.accountantEmail = accountantEmail;
		this.accountantPassword = accountantPassword;
	}
	public Accountant() {
		super();
	}
	public String getAccountantUsername() {
		return accountantUsername;
	}
	public void setAccountantUsername(String accountantUsername) {
		this.accountantUsername = accountantUsername;
	}
	public String getAccountantEmail() {
		return accountantEmail;
	}
	public void setAccountantEmail(String accountantEmail) {
		this.accountantEmail = accountantEmail;
	}
	public String getAccountantPassword() {
		return accountantPassword;
	}
	public void setAccountantPassword(String accountantPassword) {
		this.accountantPassword = accountantPassword;
	}
	@Override
	public String toString() {
		return "Accountant [accountantUsername=" + accountantUsername + ", accountantEmail=" + accountantEmail
				+ ", accountantPassword=" + accountantPassword + "]";
	}


	


	
}
