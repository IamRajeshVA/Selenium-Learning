package TestNGLearning;

import org.testng.annotations.Test;

public class DependencyExample {
	@Test
	  public void username()
	  {
		  System.out.println("username");
	  }  
		//@Test(dependsOnMethods = "username")
		@Test(enabled = false)
	 public void password()
	 {
		 System.out.println("password");
	 }
		@Test(dependsOnMethods = "password")
	 public void login()
	 {
		 System.out.println("login");
	 }  

}
