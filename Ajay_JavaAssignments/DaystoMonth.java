import java.util.Scanner;
class DaystoMonth
{
	public static void main(String[] args)
	 {
		Scanner in =new Scanner(System.in);
	 	System.out.println("Enter number of days");
	 	int numdays=in.nextInt();
	 	int months=numdays/30;
	 	int days=numdays%30;
	 	System.out.print(numdays +" equal to " + months + "months and "+days +" days" );

	}
}