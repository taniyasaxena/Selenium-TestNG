package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Base_Practice 
{
	WebDriver w;
	
	String application_url ="http://altoromutual.com:8080/login.jsp";
	
	public void openBrowser(String br) 
	{
		if (br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			w=new ChromeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
		}
		else if (br.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			w=new EdgeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		
	}
	public void closeBrowser()
	{
		w.close();
	}
	public void OpenApplication() 
	{
		w.get(application_url);
	}
	public void HandleTextBox(WebElement we,String se)
	{
		we.clear();
		we.sendKeys(se);
		
	}
	public void HandleClickEvent(WebElement we) 
	{
		we.click();
	}
	public void Waitsec (int sec) throws Exception
	{
		sec=sec*1000;
		Thread.sleep(sec);
	}
	

}
