package PageObjectTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.LoginUsingPF;

public class LoginTestUsingPF 
{

	@Test
	public void Testlogin()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.testyou.in/Login.aspx");
		
		LoginUsingPF login=PageFactory.initElements(driver, LoginUsingPF.class);
		login.verifylogin("rrajidivi4499@gmail.com", "rajidivi@4499");
		
		driver.close();
	}
}
