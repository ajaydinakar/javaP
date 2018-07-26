import java.util.Scanner;

class Fibonacci
{
 
  int fibonacci(int num)
 {
 int n1=0,n2=1;

  if (num < 1)
        return 0 ;
 
    for (int i = 1; i <= num; i++)
    {
      System.out.print(n2+" ");
        int temp = n1 + n2;
        n1 = n2;
        n2 = temp;
    }
return 0;
} 

 public static void main(String[] args)
  {
  	Scanner in=new Scanner(System.in);
  	System.out.println("Enter a number to get Fibonacci : ");
  	int input =in.nextInt();
    Fibonacci object=new Fibonacci();
  	System.out.println("Fibonacci series  of "+ input + "is" );
     object.fibonacci(input);

  }	
}