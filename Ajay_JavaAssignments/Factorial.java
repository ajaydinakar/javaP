import java.util.Scanner;

class Factorial
{
 
 int factorial(int num)
 {

if(num==0)
	return 1;
else
	return num*factorial(num-1);

 }

 public static void main(String[] args)
  {
  	Scanner in=new Scanner(System.in);
  	System.out.println("Enter a number to get Factorial : ");
  	int input =in.nextInt();
  	Factorial object=new Factorial();
  	System.out.print("Factorial of "+input + "is" +object.factorial(input));
		
  }	
}