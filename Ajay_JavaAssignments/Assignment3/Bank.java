
import java.util.Scanner;
class Bank
{

	static int Amount=500;//stating balance
	static boolean exit=false;
	static Scanner in=new Scanner(System.in);

static void addDeposit()
{
System.out.print("Enter the amount to deposit : ");
int deposit=in.nextInt();
Amount=Amount+deposit;
}
static void withDraw()
{
System.out.print("Enter the amount to Withdraw : ");
int withdraw=in.nextInt();
Amount=Amount-withdraw;	
}

static void transfer()
{
System.out.print("Enter the amount to transfer : ");
int transferAmt=in.nextInt();
Amount=Amount-transferAmt;	
}
static void enquirey()
{
System.out.println("You Got "+Amount+"$ in your account");

}

	public static void main(String[] args)
	 {
		 
    System.out.println("|-------------------------------------------|");  
    System.out.println("|  Welcome to Simple Banking application    |");  
    System.out.println("|-------------------------------------------|");  

    int choice=0;

    while(!exit)
        {
        
        System.out.println("\n\n|-------------------------|");	
        System.out.println("|     Enter your Choice   |");
        System.out.println("|-------------------------|");
        System.out.println("  1:Add Deposit            ");
        System.out.println("  2:WithDraw amount        ");
        System.out.println("  3:Transfer money         ");
        System.out.println("  4:Balency Enguirey       ");
        System.out.println("  5.exit the application   ");
        System.out.println("|-------------------------|\n\n");
        System.out.print("choice :");
        choice=in.nextInt();
        switch(choice)
            {
            case 1:
                
                addDeposit();
                break;
            case 2:
                withDraw();
                break;
            case 3:
                transfer();
                break;

            case 4:
                enquirey();
                break;
                
            case 5:
                exit=true;
                 System.out.println("|-------------------------------------------|");  
                 System.out.println("|  Exiting  the  Banking application        |");  
                 System.out.println("|-------------------------------------------|");  
                break;
            default:
                System.out.println("Wrong choice! please choose 1-5");
                break;

            }		
        }
	}

	
}