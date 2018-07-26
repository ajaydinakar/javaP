
import java.util.Scanner;

class Pallendrome
{
	static int convertReverse(int num)
	{
		int digit=0,reverse=0;
        while(num!=0)
		{
			digit = num%10;
            reverse = reverse*10 + digit;
            num /= 10;
		}
		return reverse;
	}
	public static void main(String[] args)
	 {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter your number to check it is Pallendrome number : ");
		int num=in.nextInt();
        int reverse=Pallendrome.convertReverse(num); 
		if(num==reverse)
			System.out.print(num +"  is Pallendrome ");
		else
			System.out.print(num +"  is not Pallendrome ");

	}
}