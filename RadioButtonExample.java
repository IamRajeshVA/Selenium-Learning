package selenium;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtonExample 
{
	WebDriver driver;
	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void radiobtn() throws InterruptedException
	{
		//click yes button
		WebElement radio_btn=driver.findElement(By.id("yes"));
		radio_btn.click();
		Thread.sleep(5000);
		
		//find default selected radiobtn
		WebElement checked=driver.findElement(By.xpath("//input[@value='1'][@name='news']"));
		WebElement unchecked=driver.findElement(By.xpath("//input[@value='0'][@name='news']"));
		
		Boolean checkedbox=checked.isSelected();
		
		if(checkedbox==true)
		{
			System.out.println("checked box is selected");
		}
		else
		{
			System.out.println("unchecked box is selected");	
		}
		Thread.sleep(5000);
		
		//select your group age
		WebElement below20years=driver.findElement(By.xpath("//input[@value='0'][@name='age']"));
		WebElement below40years=driver.findElement(By.xpath("//input[@value='1'][@name='age']"));
		WebElement above40years=driver.findElement(By.xpath("//input[@value='2'][@name='age']"));
		
		Scanner scanner=new Scanner(System.in);
		int age=scanner.nextInt();
		
		if(20<=age) 
		{
			below20years.click();
			System.out.println(" 0 to 20 years btn selected");
		}else if(20>age&&40<=age)
		{
			below40years.click();
			System.out.println("21  to 40 years btn selected");
		}
		else
		{
			above40years.click();
			System.out.println("above 40 years btn selected");
		}
		Thread.sleep(5000);
		
		
	}
}
