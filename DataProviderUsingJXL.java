package Framwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bsh.commands.dir;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProviderUsingJXL
{
	WebDriver driver;
	Object[][] data = null;
	
	public Object[][] getexceldata() throws IOException, BiffException
	{
		FileInputStream file = new FileInputStream("E:\\Drivers\\dataprovider.xls");
		
		Workbook workbook = Workbook.getWorkbook(file);
		
		Sheet sheet = workbook.getSheet(1);
		
		int rowcount=sheet.getRows();
		System.out.println(rowcount);
		
		int columncount = sheet.getColumns();
		System.out.println(columncount);
		
		Object testdata [] [] = new Object [rowcount-1] [columncount];
		
		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				testdata [i-1] [j] =sheet.getCell(j,i).getContents();
			}
			workbook.close();
		}
		return testdata;
		
	}

	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.close();
		
	}
	
	 
	@Test(dataProvider = "login data")
	public void login(String uname,String pword)
	{ 
		 driver.navigate().to("http://www.testyou.in/Login.aspx");
			
		WebElement username = driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin"));
		username.sendKeys(uname);
		
		WebElement password = driver.findElement(By.name("ctl00$CPHContainer$txtPassword"));
		password.sendKeys(pword);
		
		WebElement loginbtn = driver.findElement(By.name("ctl00$CPHContainer$btnLoginn"));
		loginbtn.click();
		
	}
	
	@DataProvider(name="login data")
	public Object[][] logindataprovider() throws BiffException, IOException
	{
		data = getexceldata();
		return data;
	}
}
