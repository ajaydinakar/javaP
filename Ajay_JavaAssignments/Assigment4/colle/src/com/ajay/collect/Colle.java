package com.ajay.collect;

public class Colle {
	
	
	class Inner 
	{
		static int a;
		Inner()
		{
			System.out.println("this is inner class");
		}
	}
	public static void main (String [] args)
	{
		Colle.Inner i=new Colle().new Inner();
		System.out.println("hello world ");
		Colle.Inner j=new Colle().new Inner();
	}

}
































































9