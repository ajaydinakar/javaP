import java.util.Scanner;

class WaterBottle
{

    static boolean empty=false,overflow=false,exit=false;
    static int BottleCapacity;
    static int BottleQuantity;
    static int WatertoDrink;

    static void fillwater(int fill_liters)
    {
    BottleQuantity=BottleQuantity+fill_liters;
    if(BottleQuantity>BottleCapacity)
        {
        System.out.println("Bottle overflow occured");
        BottleQuantity=BottleCapacity;
        }
    }
    static void drinkwater(int sip_liters)
        {
	   BottleQuantity=BottleQuantity-sip_liters;
	   if(BottleQuantity<=0)
            {
            System.out.println("Bottle is empty");
            BottleQuantity=0;
            empty=true;
            }
   	
}
static void emptybottle()
{
	BottleQuantity=0;
}


	public static void main(String[] args)
	 {
    Scanner in=new Scanner(System.in);
    System.out.print("Enter the capacity that the  water bottle can hold");
    BottleCapacity=in.nextInt();
    int choice=0;

    while(!exit)
        {
        System.out.println("Bottle Quantity is :"+BottleQuantity);

        System.out.println("|-------------------------|");	
        System.out.println("|     Enter your Choice   |");
        System.out.println("|-------------------------|");
        System.out.println("| 1:Fill the Bottle       |");
        System.out.println("| 2:Sip water             |");
        System.out.println("| 3:Empty the Bottle      |");
        System.out.println("| 4:Exit Application      |");
        System.out.println("|-------------------------|");
        choice=in.nextInt();
        switch(choice)
            {
            case 1:
                System.out.print("Enter how many liters  you like to fill :");
                int fillQuantity=in.nextInt();
                if(fillQuantity>0)
                    empty=false;
                fillwater(fillQuantity);
                break;
            case 2:
                System.out.print("Enter how many liters you like to drink :");
                int sipQuantity=in.nextInt();
                drinkwater(sipQuantity);
                break;
            case 3:
                if(empty==true)
                    System.out.println("Bottle already Empty");
                else
                    emptybottle();
                break;
            case 4:
                exit=true;
                System.out.println("|------------------------------------------|");
                System.out.println("Application exiting");
                break;
            default:
                System.out.println("Wrong choice! give choice only from the list");
                break;

            }		
        }
	}
}