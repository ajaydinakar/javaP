
import java.util.Scanner;

class Reverse
{

	public static void main(String[] args)
	 {
	 	System.out.println("This program prints reverse of a number");
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the number : ");
		int num=in.nextInt();
		int reverse=0,digit=0;
      while(num!=0)
		{
			digit = num%10;
            reverse = reverse*10 + digit;
            num /= 10;
		}
		System.out.println("Reverse of the given number is :" + reverse );

	}
}