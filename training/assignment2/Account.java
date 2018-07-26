package com.training.assignment2;

public abstract class Account {
	private String accNo;
	private String branchCode;
	private int balance;
	public Account(String accNo, String branchCode) {
		super();
		this.accNo = accNo;
		this.branchCode = branchCode;
		this.balance = 0;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccNo() {
		return accNo;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public int getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", branchCode=" + branchCode + ", balance=" + balance + "]";
	}
	

}
