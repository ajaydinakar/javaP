import java.util.Random;
class  RandomNum
{
	public static void main(String[] args) {


Random rand = new Random();

for(int i=0;i<5;i++)
{
System.out.print( rand.nextInt(100) + 1 +"\t");
}
		
	}

}