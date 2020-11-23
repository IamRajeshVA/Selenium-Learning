package TestNGLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterUsingDataProvider 
{
	WebDriver driver;
	/*
	 * Object [] [] data =
	 * {{"rajidivi@4499","rajidivi@gmail"},{"rrajidivi@4499","rajidivi@gmail"},{
	 * "rajidivi@gmail"
	 * ,"rajidivi@4499"},{"rrajidivi4499@gmail.com","rajidivi@4499"}};
	 */
	
	Object [] [] data = {{"rrajidivi4499@gmail.com","rajidivi@4499"}};
	
	@DataProvider(name = "login data")
	public Object[][] login()
	{
		return data;
	}
	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.navigate().to("http://www.testyou.in/Login.aspx");
	}
	@AfterTest
	public void aftertest()
	{
		//driver.quit();
	}
	
	@Test(dataProvider = "login data")
	public void login(String uname,String pword)
	{ 
		/*
		 * System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		 * driver = new FirefoxDriver();
		 * driver.navigate().to("http://www.testyou.in/Login.aspx");
		 */
		WebElement username = driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin"));
		username.sendKeys(uname);
		
		WebElement password = driver.findElement(By.name("ctl00$CPHContainer$txtPassword"));
		password.sendKeys(pword);
		
		WebElement loginbtn = driver.findElement(By.name("ctl00$CPHContainer$btnLoginn"));
		loginbtn.click();
		
		username.clear();
		password.clear();
		
		
	}


}
