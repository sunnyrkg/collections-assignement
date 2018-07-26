package com.training.assignment3;

import java.util.*;

import com.training.assignment3.Branch;
public class Main {
	public static void main(String...arg)
	{
		Branch andhrabank = new Branch(1721,"Andhra Bank");
		Branch icicibank = new Branch(1802, "ICICI Bank");
		Branch paytmbanks = new Branch(1013,"PayTM Payments Bank");
		
		Branch.addNewBranch(andhrabank);
		Branch.addNewBranch(icicibank);
		Branch.addNewBranch(paytmbanks);
		
		
		andhrabank.openNewAccount("Risabh Gupta");
		andhrabank.openNewAccount("Kartik Gupta");
		andhrabank.openNewAccount("Aman Gupta");
		paytmbanks.openNewAccount("Saunak Gupta");
		icicibank.openNewAccount("Raunak Gupta");
		icicibank.openNewAccount("Megha Gupta");
		paytmbanks.openNewAccount("Shivam Gupta");
		paytmbanks.openNewAccount("Ankit Gupta");
		icicibank.openNewAccount("Dheeraj Gupta");
		/*
		 * Crediting amount in accounts
		 */
		Iterator<Account> it = Account.getAllAccounts().iterator();
		it.next().creditAmount(10000);
		it.next().creditAmount(20000);
		it.next().creditAmount(15000);
		it.next().creditAmount(12000);
		it.next().creditAmount(14000);
		it.next().creditAmount(2000);
		it.next().creditAmount(1000);
		it.next().creditAmount(5000);
		it.next().creditAmount(6000);
		
		
		/*
		 * 
		 */
		System.out.println("\n******SORTED AS PER BALANCES********\n");
		List<Account> sorted = Account.getAllAccounts();
		
		/*
		 * Operation for transfer amount
		 */
		Account a1 = Helper.getAccountByHolderName("Risabh Gupta",1721);
		Account a2 = Helper.getAccountByHolderName("Megha Gupta",1802);
		
		Transaction transactionAndhraBank = new Transaction(andhrabank);
		Transaction transactionIciciBank = new Transaction(icicibank);
		Transaction transactionPaytmBank = new Transaction(paytmbanks);
		
		transactionAndhraBank.depositAmount(1002, 1000);
		transactionIciciBank.depositAmount(1009, 3000);
		transactionAndhraBank.withDrawAmount(1003, 1000);
		transactionPaytmBank.withDrawAmount(1007, 2000);
		Transaction.transferAmount(a1.getAccountNumber(), a1.getBranchCode(), a2.getAccountNumber(), a2.getBranchCode(), 503);
		Transaction.transferAmount(1007, 1013, 1004, 1013, 500);
		/*
		 * Listing after transaction in descending order
		 */
		
		
		
		/*
		 * Closing Some Accounts
		 */
		Helper.getAccountByHolderName("Risabh Gupta",1721).closeAccount();
		Helper.getAccountByHolderName("Megha Gupta", 1802).closeAccount();
		
		System.out.println("\n******SORTED AS PER BALANCES********\n");
		sorted = Account.getAllAccounts();
		sorted.sort((account1,account2)->account2.getBalance()-account1.getBalance());
		System.out.println(sorted);

	}
}
