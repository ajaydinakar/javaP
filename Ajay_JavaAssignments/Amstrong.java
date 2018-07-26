
import java.util.Scanner;

class Amstrong
{
	static int calculate(int num)
	{
		int sum=0,digit=0;
		while(num!=0)
		{
			digit = num % 10;
            sum= sum + (int)Math.pow(digit, 3);
            num = num / 10;
		}
		return sum;
	}
	public static void main(String[] args)
	 {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter your number to check it is Amstrong number : ");
		int num=in.nextInt();
		int sum=Amstrong.calculate(num);
		if(num==sum)
			System.out.print(num +"  is Amstrong number");
		else
			System.out.print(num +"  is not Amstrong number");

	}
}