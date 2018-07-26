

//super class
class SuperClass
{
static
{
	System.out.println("this is static block in super class");
}
{
	System.out.println("initialization block in super block");
}


	SuperClass()// superclass constructor
	{

System.out.println(" SuperClass Constructor created");
	}
	SuperClass(int i)//superclass parameterized constructor
	{
		
System.out.println(" SuperClass Constructor created with value "+i);
	}

	void fun()//non-static  overring function in super class
	{
	System.out.println(" SuperClass function executed");
	
	}

}




//sub class
class SubClass extends SuperClass //inheritence
{

{
	System.out.println("initialization block in subclass block");
}
SubClass()//sub-class constructor
{
	super();
	
	System.out.println("SubClass Constructor created");
}
void fun() //non-static overriding function in sub-class
	{
		//super.fun();
	System.out.println(" SubClass function created");
	super.fun();
	
	}


	public static void main(String[] args) {
		System.out.println("Before object creation");

		SuperClass A= new SuperClass();
		System.out.println("-----------------------------------");
		SuperClass B= new SubClass();
		System.out.println("-----------------------------------");
		SubClass C= new SubClass();
		System.out.println("-----------------------------------");
		//SubClass D= new SuperClass();    why this is error?
		System.out.println("-----------------------------------");
		C.fun();
		System.out.println("-----------------------------------");
		A.fun();
		System.out.println("-----------------------------------");
		B.fun();
			System.out.println("after object creation");
	}
}