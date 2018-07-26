package com.training.assignment2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalaryAccount salaryaccount = new SalaryAccount("1771","ANDB1731");
		SavingsAccount savingsaccount = new SavingsAccount("1992", "SBIN112");
		salaryaccount.deposit(1000); // Balance = 1000
		System.out.println(salaryaccount);
		salaryaccount.deposit(1000); //Balance = 2000
		System.out.println(salaryaccount);
		salaryaccount.withdrawal(1000);  //Balance = 1000
		System.out.println(salaryaccount);
		salaryaccount.withdrawal(1000);  //Balance = 0
		System.out.println(salaryaccount);
		salaryaccount.withdrawal(1000);  //Raise Exception
		System.out.println(salaryaccount);
		savingsaccount.deposit(10000);	//Balance = 10000
		System.out.println(savingsaccount);
		savingsaccount.withdrawal(2000);	//Balance = 8000
		System.out.println(savingsaccount);
		savingsaccount.withdrawal(2000);	//Balance = 6000
		System.out.println(savingsaccount);
		savingsaccount.withdrawal(2000);	//Balance = 4000
		System.out.println(savingsaccount);
		savingsaccount.withdrawal(2000);	//Balance = 2000
		System.out.println(savingsaccount);
		savingsaccount.withdrawal(2000);	//Raise Exception Here
	}

}
