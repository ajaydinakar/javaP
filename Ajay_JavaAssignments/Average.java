import java.util.Scanner;
class Average
{
	static int sum;
	void AverageofEven(int N)
	{
		sum=0;
		for (int i=1;i<=(2*N);i++)
		{
			if((i%2)==0)
			sum=sum+i;
		}
		System.out.println("sum of first "+N+"consecutive even numbers is " +sum );

	}
	void AverageofOdd(int N)
	{
		sum=0;
		for (int i=1;i<=(2*N);i++) 
		{
            if((i%2)!=0)
         	sum=sum+i;
			
		}
		System.out.println("sum of first "+N+"consecutive odd numbers is " +sum );
	}
	public static void main(String[] args) 
	{
	Scanner in=new Scanner(System.in);
  	System.out.println("Enter N value: ");
  	int input =in.nextInt();
  	Average object=new Average();
  	object.AverageofEven(input);
  	object.AverageofOdd(input);

		
	}
}