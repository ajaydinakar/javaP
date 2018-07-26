import java.util.Scanner;
class AscendingTriangle
{

	public static void main(String[] args)
	 {
	 	Scanner in =new Scanner(System.in);
	 	System.out.println("Enter your max number");
	 	int num=in.nextInt();
	 for (int i=1;i<=num ;i++ )
	  {
	  	for (int j=1;j<=i ;j++ )
	  	{
	  		System.out.print(j);
	  	}
	 	System.out.println(i-1);
	 }
	}

}