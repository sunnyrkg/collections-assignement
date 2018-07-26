package com.training.assignment2;

public class SalaryAccount extends Account implements BankTransaction {

	
	
	public SalaryAccount(String accNo, String branchCode) {
		super(accNo, branchCode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void withdrawal(int amount) {
		// TODO Auto-generated method stub
		try
		{
		if(amount>getBalance())
			throw new TransactionDeclinedException("You can't witdraw more than owned amount");
		setBalance(getBalance()-amount);
		}
		catch(TransactionDeclinedException tde)
		{
			System.err.println(tde.getMessage());
		}

	}

	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		setBalance(getBalance()+amount);
	}

	@Override
	public String toString() {
		return super.toString() + "SalaryAccount []";
	}
	
	
}
