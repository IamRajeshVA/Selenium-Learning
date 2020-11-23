package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObjects
{
	
WebDriver driver;
	
	By username=By.name("ctl00$CPHContainer$txtUserLogin");
	By password=By.name("ctl00$CPHContainer$txtPassword");
	By loginbtn=By.name("ctl00$CPHContainer$btnLoginn");

	public LoginPageObjects(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void loginpage(String uname,String pword)
	
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pword);
		driver.findElement(loginbtn).click();
	}
	
	/*
	 * public static WebElement username(WebDriver driver) { return
	 * driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin")); }
	 * 
	 * public static WebElement password(WebDriver driver) { return
	 * driver.findElement(By.name("ctl00$CPHContainer$txtPassword")); }
	 * 
	 * public static WebElement loginbtn(WebDriver driver) { return
	 * driver.findElement(By.name("ctl00$CPHContainer$btnLoginn")); }
	 */
	
}
