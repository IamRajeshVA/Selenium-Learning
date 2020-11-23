package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertExample 
{
	WebDriver driver;
	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void alert() throws InterruptedException
	{
		WebElement alertbox=driver.findElement(By.xpath("//*[@onclick='normalAlert()']"));
		alertbox.click();
		Thread.sleep(5000);
		Alert alertbox1=driver.switchTo().alert();
		alertbox1.accept();
		Thread.sleep(5000);
		
		WebElement confirmbox=driver.findElement(By.xpath("//*[@onclick='confirmAlert()']"));
		confirmbox.click();
		Thread.sleep(5000);
		Alert confirmalert =driver.switchTo().alert();
		confirmalert.dismiss();
		Thread.sleep(5000);
		
		WebElement promptbox=driver.findElement(By.xpath("//*[@onclick='confirmPrompt()']"));
		promptbox.click();
		Thread.sleep(5000);
		Alert promptalert =driver.switchTo().alert();
		promptalert.sendKeys("hai leafground ");
		Thread.sleep(5000);
		promptalert.accept();
		
		driver.close();
		
		
	
	}
}
