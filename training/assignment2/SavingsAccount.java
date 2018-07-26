package com.training.assignment2;

public class SavingsAccount extends Account implements BankTransaction {

	private final int WITHDRAWAL_LIMIT = 10000;
	private final int MIN_BALANCE = 1000;
	


	public SavingsAccount(String accNo, String branchCode) {
		super(accNo, branchCode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void withdrawal(int amount) {
		// TODO Auto-generated method stub
		if(amount>=WITHDRAWAL_LIMIT)
			throw new TransactionDeclinedException("Amount is greater than withdrawal limit");
		if(super.getBalance()-amount < MIN_BALANCE)
		{
			throw new TransactionDeclinedException("You need to carry minimum balance");
		}
		super.setBalance(super.getBalance()-amount);
			
	}

	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		setBalance(getBalance()+amount);
		
	}

	@Override
	public String toString() {
		return super.toString() +" SavingsAccount [WITHDRAWAL_LIMIT=" + WITHDRAWAL_LIMIT + ", MIN_BALANCE=" + MIN_BALANCE + "]";
	}
	
}
