import java.util.Scanner;
class Greet
{

	public static void main(String[] args) 
	{
		Scanner in =new Scanner(System.in);
		int choice;
		boolean exit=false;
		while(!exit)

		{
			System.out.println("Enter 1 to continue");
			System.out.println("Enter 2 to exit");
			choice=in.nextInt();
		
		switch(choice)
		{
			case 1:
			System.out.println("Enter your marks");
			int marks=in.nextInt();
			if(marks>70)
				System.out.println("You have Passed");
			else
				System.out.println("You have Failed");
			break;

			case 2:
			System.out.println("Exiting the Program");
			exit=true;
			break;
			default:
			System.out.println("Wrong Choice! choice should be one or two");
			break;


		}
	    }

	}
}