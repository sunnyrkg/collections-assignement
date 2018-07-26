package com.training.assignment1;

public class Calculator {
	public int submission(int n1,int n2)
	{
		return n1+n2;
	}
	public double division(int n1,int n2) throws MyException
	{
		try
		{
			if(n2==0)
				throw new MyException();
			return n1/n2;
		}
		catch(ArithmeticException e)
		{
			System.err.print(e.getMessage());
			return 99999;
		}
	}
}
