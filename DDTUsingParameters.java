package Framwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTUsingParameters 
{
	WebDriver driver;

	@Test(dataProvider = "TestData")
	public void login(String uname,String pword)
	{
		 WebElement username= driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin")); 
		 username.sendKeys(uname);
				  
		 WebElement password= driver.findElement(By.name("ctl00$CPHContainer$txtPassword"));
		 password.sendKeys(pword);
				  
		 WebElement loginbtn= driver.findElement(By.name("ctl00$CPHContainer$btnLoginn")); 
		 loginbtn.click();
		 
		 driver.close();
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.navigate().to("http://www.testyou.in/Login.aspx");
	}
	
	@DataProvider(name ="TestData")
	public Object[][] data()
	{
		Object[][] data = {
							{"rrajidivi4499@gmail.com","rajidivi@4499"},
							{"rajidivi@gmail", "rajidivi@4499"},
							{"rrajidivi@4499", "rajidivi@gmail"},
							{"rajidivi@4499","rajidivi@gmail"}
						};
		return data;
	}

}
