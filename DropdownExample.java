package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;

public class DropdownExample 
{

	WebDriver driver;
	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.testyou.in/Login.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void dropdowntest()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin"));
		username.sendKeys("rrajidivi4499@gmail.com");

		WebElement password = driver.findElement(By.name("ctl00$CPHContainer$txtPassword"));
		password.sendKeys("rajidivi@4499");

		WebElement loginbtn = driver.findElement(By.name("ctl00$CPHContainer$btnLoginn"));
		loginbtn.click();

		driver.findElement(By.xpath("//div[@class='edit_link']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;


		//WebDriverWait wait=new WebDriverWait(driver, 15);
		//WebElement drop=wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("//select[@id='ctl00_CPHContainer_ddlSecurityQuestion']"), null);
		//WebElement drop=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='ctl00_CPHContainer_ddlSecurityQuestion']")));
		//WebElement drop=driver.findElement(By.xpath("//*[@id='ctl00_CPHContainer_ddlSecurityQuestion']/div/input[1]"));
		//drop.click();

		//Actions mousehover=new Actions(driver);
		//mousehover.moveToElement(drop).build().perform();
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		WebElement drop=driver.findElement(By.xpath("//select[@id='ctl00_CPHContainer_ddlSecurityQuestion']"));

        js.executeScript("arguments[0].scrollIntoView();", drop);

		//wait.until(ExpectedConditions.visibilityOf(drop));
		// WebElement drop =driver.findElement(By.xpath("//select[@id='ctl00_CPHContainer_ddlSecurityQuestion']"));
		//drop.click();
		Select select = new Select(drop);
		select.selectByIndex(1);

		WebElement answer=driver.findElement(By.id("ctl00_CPHContainer_txtSecurtityAnswer"));
		answer.sendKeys("RajiDivi");
	}

}
