package TestNGLearning;

import org.testng.annotations.Test;

public class GroupingExample {
	public void vivo() 
	{
		System.out.println("vivo");
	}

	@Test(groups = "mobile")
	public void oppo() 
	{
		System.out.println("oppo");
	}

	@Test(groups = "fruits")
	public void apple() 
	{
		System.out.println("apple");
	}


	@Test(groups = "fruits")
	public void orange() 
	{
		System.out.println("orange");
	}

	@Test(groups = "meats")
	public void chicken() 
	{
		System.out.println("chicken");
	}

	@Test(groups = "meats")
	public void mutton() 
	{
		System.out.println("mutton");
	}

	@Test(groups = "cloths")
	public void pant() 
	{
		System.out.println("pants");
	}

	@Test(groups = "cloths")
	public void shirt() 
	{
		System.out.println("shirts");
	}




}
