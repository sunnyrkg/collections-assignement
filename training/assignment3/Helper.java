package com.training.assignment3;


public class Helper {
	public static Account getAccountByHolderName(String holderName,int branchCode)
	{
		return Branch.getBranchByCode(branchCode).getAccountByHolder(holderName);
	}
}
