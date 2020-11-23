package MustJava;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenGoogleUsingLog4j 
{
	static WebDriver driver;
	static org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(OpenGoogleUsingLog4j.class);
	
	public static void open_Browser(String browserName)
	{
		try {
			if (browserName.equalsIgnoreCase("Firefox"))
			{
				logger.info("Open FireFox Browser");
				System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("FireFoxDriver selected");
			}
			else if (browserName.equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver",
						"D:/Jars/chromedriver.exe");
				driver = new ChromeDriver();
			} 
			else if (browserName.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver",
						"D:/Jars/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		} 
		catch (WebDriverException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public static void opengoogle()
	{
		logger.info("Navigate to URL");
		driver.navigate().to("https://www.google.com/");
		screenshot();
		logger.info("Closing browser");
		driver.close();
	}
	private static void screenshot()
	{
		// TODO Auto-generated method stub
		logger.info("Taking ScreenShot");
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File srcfile=screenshot.getScreenshotAs(OutputType.FILE);
		File destfile=new File("E://opengoogle.png");
		try {
			org.openqa.selenium.io.FileHandler.copy(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main (String []args)
	{
		//BasicConfigurator.configure();
		DOMConfigurator.configure("Log4j.properties.xml");
		//PropertyConfigurator.configure("log4j.properties");
		PropertyFileExample.readpropertyfile();
		String browserName = PropertyFileExample.browser;
		open_Browser(browserName);
		PropertyFileExample.writepropertyfile();
		opengoogle();
	}

}
