class OverloadConstructor
{
OverloadConstructor()
{
	System.out.println("Constructor created");
}
OverloadConstructor(int i)
{
	System.out.println("Constructor created and initialized with value" + i);
}

	public static void main(String[] args) {
		System.out.println("Before object creation");

		Constructor C= new Constructor();
			System.out.println("after object creation");
	}
}