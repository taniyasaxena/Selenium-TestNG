package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Practice {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver",".\\Browser_Driver\\chromedriver.exe" );
	      
	      WebDriver w = new ChromeDriver();
	      
	      w.get("https://phptravels.net/api/supplier");
	      
	      w.findElement(By.xpath("//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/div/h1/strong"));
	      
	     // w.findElement(By.linkText("Administrator Users Only"));
	      
	      w.findElement(By.cssSelector("input[name='email']")).sendKeys("supplier@phptravels.com");
	      w.findElement(By.cssSelector("input[name='password']")).sendKeys("demosupplier");
	      
	      w.findElement(By.xpath("//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[3]/div/label")).click();
	     	      
	      Thread.sleep(3000);
	      
	      w.findElement(By.xpath("//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[4]/button/span[1]")).click();
	      
	      System.out.println("Test Done");

	}

}
