package MustJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.devtools.browser.Browser;

public class PropertyFileExample 
{
	static Properties prop =new Properties();
	static String browser=null;
	
	public static void readpropertyfile()
	{
		
		
		try 
		{
			InputStream input = new FileInputStream("config.properties");
			prop.load(input);
			browser=prop.getProperty("BrowserName");
			System.out.println(browser);
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public static void writepropertyfile()
	{
		try
		{
			OutputStream output=new FileOutputStream("config.properties");
			prop.setProperty("rajesh", "divya");
			prop.setProperty("opengoogletest", "pass");
			prop.store(output, "Rajidivi");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		readpropertyfile();
		writepropertyfile();
	}

}
