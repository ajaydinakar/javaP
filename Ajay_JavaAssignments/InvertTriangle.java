import java.util.Scanner;
class InvertTriangle
{
	public static void main(String[] args)
	 {
	 	Scanner in =new Scanner(System.in);
	 	System.out.println("Enter your max number");
	 	int num=in.nextInt();
	 for (int i=num;i>0 ;i-- )
	  {
	  	for (int j=i;j>0 ;j-- )
	  	{
	  		System.out.print(i);
	  	}
	 	System.out.println("");
	 }
	}

}