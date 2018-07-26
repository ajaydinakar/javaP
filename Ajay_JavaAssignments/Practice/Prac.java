interface A
{
void dun();
}
interface B
{
void fun();
}
public interface C extends A,B
{
void cun();
}
class Prac implements C
{
	void dun()
	{

	}
	void fun(){}
	void cun(){}
	public static void main(String[] args) {
		
	}
}