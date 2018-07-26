package com.training.assignment3;
import com.training.assignment3.Branch;
public class Transaction {
	private Branch branch;

	public Transaction(Branch branch) {
		super();
		this.branch = branch;
	}

	/**
	 * @return the branch
	 */
	public Branch getBranch() 
	{
		return branch;
	}
	
	public void withDrawAmount(int accountNo , int amount)
	{
		try
		{
			branch.getAccount(accountNo).debitAmount(amount);
		}
		catch(RuntimeException re)
		{
			System.err.println(re.getMessage());
		}
	}
	public void depositAmount(int accountNo, int amount)
	{
		branch.getAccount(accountNo).creditAmount(amount);
	}
	public static void transferAmount(int accountNoSource,int branchCodeSource, int accountNoTarget, int branchTargetCode, int amount)
	{
		try
		{
			Branch sourceBranch = Branch.getBranchByCode(branchCodeSource);
			Branch targetBranch = Branch.getBranchByCode(branchTargetCode);
			sourceBranch.getTransactionOperations().withDrawAmount(accountNoSource, amount);
			targetBranch.getTransactionOperations().depositAmount(accountNoTarget, amount);
		}
		catch(RuntimeException re)
		{
			System.err.println(re.getMessage());
		}
	}
}
