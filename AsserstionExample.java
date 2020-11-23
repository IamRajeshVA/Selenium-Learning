package TestNGLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsserstionExample 
{
	@Test(priority = 0)
	public void softassertion(){
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		//Instantiation of driver object. To launch Firefox browser
		WebDriver driver = new FirefoxDriver();
		//To open the URL
		driver.get("https://www.softwaretestingmaterial.com");
		//Actual title is "Software Testing Material - A site for Software Testers" 
		//We took title as "Software Testing Material" to make the test fail
		String Title = "Software Testing Material";
		String GetTitle = driver.getTitle();
		System.out.println("Assertion starts here...");
		//Assert.assertEquals(Title, GetTitle);
		SoftAssert obj=new SoftAssert() ;
		obj.assertEquals(Title, GetTitle);
		System.out.println("A blog for Software Testers");
                driver.quit();		
	}
	
	@Test
	public void hardassertion()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		//Instantiation of driver object. To launch Firefox browser
		WebDriver driver = new FirefoxDriver();
		//To open the URL
		driver.get("https://www.softwaretestingmaterial.com");
		//Actual title is "Software Testing Material - A site for Software Testers" 
		//We took title as "Software Testing Material" to make the test fail
		String Title = "Software Testing Material";
		String GetTitle = driver.getTitle();
		System.out.println("Assertion starts here...");
		Assert.assertEquals(Title, GetTitle);
		//SoftAssert obj=new SoftAssert() ;
		//obj.assertEquals(Title, GetTitle);
		System.out.println("A blog for Software Testers");
                driver.quit();		
	}
}
