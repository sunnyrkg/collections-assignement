package com.training.assignment1;

public class TestException1 {
	public static void main(String...arg)
	{
		try
		{
			mainfunction(arg);
		}
		catch(MyException me)
		{
			me.printStackTrace();
		}
	}
	public static void mainfunction(String...arg) throws MyException
	{
		Calculator calc = new Calculator();
		System.out.println(calc.division(45, 0));
		System.out.println(calc.submission(3, 5));
		System.out.println(calc.division(45, 8));
		System.out.println(calc.division(45, 0));
		System.out.println(calc.submission(3, 6));
	}
}
