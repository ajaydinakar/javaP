class Constructor
{
Constructor()
{
	System.out.println("Constructor created");
}


	public static void main(String[] args) {
		System.out.println("Before object creation");

		Constructor C= new Constructor();
			System.out.println("after object creation");
	}
}