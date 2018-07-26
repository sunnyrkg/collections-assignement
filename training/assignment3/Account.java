package com.training.assignment3;

import java.util.*;

public class Account {
		public final static int ACTIVE = 101;
		public final static int CLOSED = 111;
		private static int ACCOUNT_GENERATOR_UID = 1000;
		private int accountNumber;
		private int branchCode;
		private String accountHolder;
		private int status;
		private int balance;
		private Branch branch;
		
		public static int newAccountNumberGenerator()
		{
			return ++ACCOUNT_GENERATOR_UID;
		}
		public static List<Account> getAllAccounts()
		{
			List<Account> list = new LinkedList<>();
			Branch.BRANCHES.forEach((branch)->{
				list.addAll(branch.getAll());
			});
			return list;
		}
		/**
		 * @return the balance
		 */
		public int getBalance() {
			return balance;
		}
		/**
		 * @param balance the balance to set
		 */
		public void setBalance(int balance) {
			this.balance = balance;
		}
		public Account(int accountNumber, int branchCode, String accountHolder, int status, int balance) {
			super();
			this.accountNumber = accountNumber;
			this.branchCode = branchCode;
			this.accountHolder = accountHolder;
			this.status = status;
			this.balance = balance;
			this.branch = Branch.getBranchByCode(branchCode);
		}
		/**
		 * @return the accountNumber
		 */
		public int getAccountNumber() {
			return accountNumber;
		}
		/**
		 * @param accountNumber the accountNumber to set
		 */
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
		/**
		 * @return the branchCode
		 */
		public int getBranchCode() {
			return branchCode;
		}
		/**
		 * @param branchCode the branchCode to set
		 */
		public void setBranchCode(int branchCode) {
			this.branchCode = branchCode;
		}
		/**
		 * @return the accountHolder
		 */
		public String getAccountHolder() {
			return accountHolder;
		}
		/**
		 * @param accountHolder the accountHolder to set
		 */
		public void setAccountHolder(String accountHolder) {
			this.accountHolder = accountHolder;
		}
		/**
		 * @return the status
		 */
		public int getStatus() {
			return status;
		}
		/**
		 * @param status the status to set
		 */
		public void setStatus(int status) {
			this.status = status;
		}
		public String getStatusString()
		{
			return this.getStatus()==Account.CLOSED ? "Closed" : "Active";
		}
		
		public void closeAccount()
		{
			this.setStatus(Account.CLOSED);
		}
		public void activateAccount()
		{
			this.setStatus(Account.ACTIVE);
		}
		public void creditAmount(int amount)
		{
			this.setBalance(this.getBalance()+amount);
		}
		public void debitAmount(int amount)
		{
			if(this.getBalance()<amount)
				throw new RuntimeException("Insufficient amount to debit");
			else
				this.setBalance(this.getBalance()-amount);
		}
		
		
		/**
		 * @return the branch
		 */
		public Branch getBranch() {
			return branch;
		}
		
		@Override
		public String toString() {
			return stringifyAccountInFormat();
		}
		public String stringifyAccountInFormat()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("\nAccount No\t")
			.append(accountNumber)
			.append("\nAccount Holder\t")
			.append(getAccountHolder())
			.append("\nBalance\t\t")
			.append(getBalance())
			.append("\nStatus\t\t")
			.append(getStatusString())
			.append("\nBranch Code\t")
			.append(getBranchCode())
			.append("\nBranch Name\t")
			.append(getBranch().getBankName())
			.append("\n\n***************************\n");
			return sb.toString();
			
		}
		
}
