import java.util.Scanner;
class HarmonicSeries
{
	
	public static void main(String[] args) 
	{
	Scanner in =new Scanner(System.in);
	System.out.println("Enter a number to get Harmonic Series : ");
	int input=in.nextInt();
	double sum=0;
	for (double i=1;i<=input;i++)
	{
	sum=(sum+(1/i));
	if(i!=input){
	System.out.print("1/"+(int)i+" + ");
}
else
    System.out.print("1/"+(int)i);

	}
    System.out.print("= "+sum);
	}
}