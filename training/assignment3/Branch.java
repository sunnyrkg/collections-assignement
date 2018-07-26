package com.training.assignment3;
import com.training.assignment3.Account;
import java.util.*;
import java.util.stream.Collectors;

public class Branch {
	public static List<Branch> BRANCHES = new LinkedList<>();
	private Map<Integer,Account> allAccounts;
	private int branchCode;
	private String bankName;
	public Branch(int branchCode, String bankName) {
		super();
		this.branchCode = branchCode;
		this.bankName = bankName;
		this.allAccounts = new HashMap<>();
	}
	public static Branch getBranchByCode(int branchCode)
	{
		try
		{
			return BRANCHES.stream().filter((branch)->branch.getBranchCode()==branchCode).findFirst().get();
		}
		catch(NoSuchElementException exep)
		{
			System.err.println("Invalid BranchCode Passed");
			return null;
		}
		
	}
	
	public static void addNewBranch(Branch branch)
	{
		BRANCHES.add(branch);
	}
	
	public static void addNewBranch(int branchCode, String bankName)
	{
		Branch branch = new Branch(branchCode, bankName);
		if(BRANCHES.contains(branch))
		{
			throw new RuntimeException("This branch code is already available!");
		}
		else
		{
			BRANCHES.add(branch);
		}
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
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public List<Account> getAll()
	{
		List<Account> list = new LinkedList<>();
		this.allAccounts.forEach((k,v)->list.add(v));
		return list;
	}
	public void addNewAccount(Account account)
	{
		this.allAccounts.put(account.getAccountNumber(), account);		
	}
	public Account getAccount(int accNo)
	{
		if(this.allAccounts.containsKey(accNo))
		return this.allAccounts.get(accNo);
		else
		throw new RuntimeException("Account not found in branch");
	}
	public Account getAccountByHolder(String name)
	{
		try {
		return this.allAccounts.entrySet().stream().filter((entrySet)->entrySet.getValue().getAccountHolder().compareTo(name)==0).findFirst().get().getValue();
		}
		catch(NoSuchElementException nse)
		{
			System.err.println("Invalid Holder Name");
			return null;
		}
	}
	public void openNewAccount(String name)
	{
		Account newAccount = new Account(Account.newAccountNumberGenerator(),branchCode, name,Account.ACTIVE,0);
		allAccounts.put(newAccount.getAccountNumber(),newAccount);
	}
	public void closeAccount(int accountNo)
	{
		this.getAccount(accountNo).closeAccount();
	}
	public List<Account> findByAccountHolderName(String holderName)
	{
		try
		{
			return getAll().stream().filter((account)->account.getAccountHolder().equals(holderName)).collect(Collectors.toList());}
		catch(NoSuchElementException nse)
		{
			System.err.println("Invalid Holder Name");
			return null;
		}
	}
	
	public Transaction getTransactionOperations()
	{
		return new Transaction(this);
	}
	@Override
	public String toString() {
		return "Branch [branchCode=" + branchCode + ", bankName=" + bankName + "]\n";
	}
	
}
