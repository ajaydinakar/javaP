
import java.util.Scanner;

class NumbertoWord
{
	void word(int num)//non static method called by convert method
	{

switch(num)  //switch logic for printing number in word
{
	case 1:
	System.out.print("one"+" ");
	break;
	case 2:
	System.out.print("two"+" ");
	break;
	case 3:
	System.out.print("three"+" ");
	break;
	case 4:
	System.out.print("four"+" ");
	break;
	case 5:
	System.out.print("five"+" ");
	break;
	case 6:
	System.out.print("six"+" ");
	break;
	case 7:
	System.out.print("seven"+" ");
	break;
	case 8:
	System.out.print("eight"+" ");
	break;
	case 9:
	System.out.print("nine"+" ");
	break;
	case 0:
	System.out.print("zero"+" ");
	break;
}



	}
	

	 void convert(int num) //this function sents each digit to method word using recursion
	{                      //this function called accessed by static main through object reference
		int digit=0;
		if(num!=0)
		{
			digit = num % 10;
            num = num / 10; 
         
        convert(num) ;  //recursive call
        word(digit);
		}
		else
			return ;

	}

	public static void main(String[] args)
	 {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter your number to be converted to words  : ");
		int num=in.nextInt();
		NumbertoWord sum=new NumbertoWord();
		sum.convert(num);

	}
}