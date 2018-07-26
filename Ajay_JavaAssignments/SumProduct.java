import java.util.Scanner;
class SumProduct
{
	void add(int a,int b)
	{
         System.out.println("Sum  of numbers is " + (a + b));
	}
	void multiply(int a,int b)
	{
         System.out.println("Product of  mumbers is " + (a * b));
	}




	public static void main(String[] args)
	 {
	 	Scanner in =new Scanner(System.in);
	 	System.out.println("Enter your first number : ");
	 	int firstNum=in.nextInt();
	 		System.out.println("Enter your first number : ");
	 	int SecondNum=in.nextInt();
	 	SumProduct A= new SumProduct();
	 	A.add(firstNum,SecondNum);
	 	A.multiply(firstNum,SecondNum);	 
	 	}	
}