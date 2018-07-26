
import java.util.Scanner;
class MaxofTwoConditional
{
	 public static void main(String[] args)
	 {
	System.out.println("hai");
	Scanner in =new Scanner(System.in);
	System.out.println("Enter first number");
	int a=in.nextInt();
	System.out.println("Enter second number");
	int b=in.nextInt();
	System.out.println("The maximum of two numbers is"+(a>b?a:b));

	}
}