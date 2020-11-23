package Framwork;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DDTpoi 
{
	static List<String> uname=new ArrayList<String>();
	static List<String> pword=new ArrayList<String>();
	static WebDriver driver;
	public static void main(String[] args) throws IOException
	{
		DDTpoi ddTusingPOI=new DDTpoi();
		ddTusingPOI.dataexcelread();
		
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		//System.out.println("RAJIDIVI");
		 System.out.println("username :"+uname); 
		 System.out.println("password :"+pword);
		 ddTusingPOI.test();

	}
	
	  public void dataexcelread() throws IOException
	  {
	  
	  FileInputStream fileInputStream=new FileInputStream("E:\\\\Drivers\\\\dataprovider.xls");
	  // XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream); 
	 
	  HSSFWorkbook hssfWorkbook=new HSSFWorkbook(fileInputStream); 
	  
	  HSSFSheet hssfSheet=hssfWorkbook.getSheetAt(1); 
	  
	  Iterator<Row> rowiterator = hssfSheet.iterator();
	  
	  while(rowiterator.hasNext())
	  { 
		  Row rowvalue=rowiterator.next();
	  
		  Iterator<Cell> columniterator=rowvalue.iterator();
		  
		  int i=2;
		  
		  while(columniterator.hasNext())
		  {
		  if(i%2==0)
		  	{
			  uname.add(columniterator.next().toString());
		  	}
		  else
		  	{
			  pword.add(columniterator.next().toString());
	  		}
		  i++;
	  }
  }
	 }
	  
	  public void login(String uname,String pword)
		{ 
		  
			 driver.navigate().to("http://www.testyou.in/Login.aspx");
				
			WebElement username = driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin"));
			username.sendKeys(uname);
			
			WebElement password = driver.findElement(By.name("ctl00$CPHContainer$txtPassword"));
			password.sendKeys(pword);
			
			WebElement loginbtn = driver.findElement(By.name("ctl00$CPHContainer$btnLoginn"));
			loginbtn.click();
			
			driver.close();
			
		}
	  public void test()
	  {
		  for(int i=0;i<uname.size();i++)
		  {
			  login(uname.get(i),pword.get(i));
		  }
	  }
	 }


