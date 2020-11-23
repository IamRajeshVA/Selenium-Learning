package selenium;

import java.util.List;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalenderExample 
{
	WebDriver driver;
	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.leafground.com/pages/Calendar.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void calender() throws InterruptedException
	{
		//noraml textbox method
		//WebElement datepicker=driver.findElement(By.id("datepicker"));
		//datepicker.sendKeys("11/10/2020");
		
		//dynamic way
		//current month date only you can select in this calender approach 
		//select 15/11/2020
		
		int date=15;
		
		WebElement datepicker=driver.findElement(By.id("datepicker"));
		datepicker.click();
		
		List <WebElement> dates=driver.findElements(By.xpath("//*[@class='ui-state-default']"));
		int size=dates.size();
		for(int i=0;i<size;i++)
		{
		    System.out.println(dates.get(i).getText());
		    dates.get(date-1).click();
		} 
			System.out.println(size);
		
		//List <WebElement> month =driver.findElements(by);
		WebElement month =driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"));
		System.out.println(month.getText());
		
		WebElement year=driver.findElement(By.className("ui-datepicker-year"));
		System.out.println(year.getText());
		
		Thread.sleep(5000);
		driver.close();
	}
	
}
