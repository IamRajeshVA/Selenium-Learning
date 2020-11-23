package TestNGLearning;

import org.testng.annotations.Test;

public class PriorityExample {
	@Test(priority = 0)
	public void firstmethod()
	{
		System.out.println("first method");
	}
	@Test(priority = 1)
	public void secondmethod()
	{
		System.out.println("second method");
	}
	@Test(priority =2 )
	public void thirdmethod()
	{
		System.out.println("third method");
	}
	@Test(priority = 3)
	public void fourthmethod()
	{
		System.out.println("fourth method");
	}
	@Test(priority = 4)
	public void fifthmethod()
	{
		System.out.println("fifth method");
	}

}
