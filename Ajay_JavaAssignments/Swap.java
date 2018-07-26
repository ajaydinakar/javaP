import java.util.Scanner;


class Swap
{
	void SwapWithTemp(int a,int b)
	{
		System.out.println("before swap first num is :"+a+"and second number  is : "+b);
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println("after swap first num is :"+a+"and second number  is : "+b);

	}
    void SwapWithoutTemp(int a,int b)
	{
		System.out.println(" swapbefore first num is :"+a+"and second number  is : "+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("after swap first num is :"+a+"and second number  is : "+b);
	}
public static void main(String[] args)
 {
	Scanner in=new Scanner(System.in);
	System.out.print("Enter first Number :");
	int num1=in.nextInt();
	System.out.print("Enter Second Number :");
	int num2=in.nextInt();
	Swap object=new Swap();
	System.out.println("This is swap with temporary variable");
	object.SwapWithTemp(num1,num2);
	System.out.println("This is swap with out temporary variable");
	object.SwapWithoutTemp(num1,num2);
}
}