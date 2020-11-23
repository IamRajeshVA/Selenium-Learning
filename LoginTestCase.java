package PageObjectTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;
import PageObjects.LoginPage_normal;

public class LoginTestCase 
{
	
		@Test
		public void verifylogin()
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.navigate().to("http://www.testyou.in/Login.aspx");

			LoginPageObjects login=new LoginPageObjects(driver);
			login.loginpage("rrajidivi4499@gmail.com", "rajidivi@4499");
			
			driver.close();
		}
		
	
}
