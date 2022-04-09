package com.selenium.fd;

import org.testng.annotations.Test;

import com.selenium.testing.FixedDepositPageObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Fixed_Deposite_DataProvider {
	FixedDepositPageObject fd;
	WebDriver w;
 
  

@DataProvider
  public Object[][] dp() 
{
    return new Object[][] 
   {
      new Object[] { "100000", "8","5","Simple Interest" },
      new Object[] { "300000", "7","6","Simple Interest" },
      new Object[] { "700000", "5","3","Simple Interest" },
    };
  }
  @BeforeTest
  public void beforeTest()
  {
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();	  
  }
  @Test(dataProvider = "dp")
  
  public void f(String principle, String roi, String tenure,String frequency) throws Exception 
  {
	  w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		w.findElement(By.id("principal")).sendKeys(principle);
		
		w.findElement(By.name("interest")).sendKeys(roi);
		
		w.findElement(By.name("tenure")).sendKeys(tenure);
		
		
		Select drop_down_tenurePeriod=new Select(w.findElement(By.name("tenurePeriod")));
		drop_down_tenurePeriod.selectByVisibleText("year(s)");
		
		Select drop_down_frequency=new Select(w.findElement(By.name("frequency")));
		drop_down_frequency.selectByVisibleText(frequency);		
		
		
	
		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
		Thread.sleep(3000); 
		
		System.out.println("Principle : "+principle);

	
  }
  @AfterTest
  public void afterTest() 
  {
	  //w.close();
  }

}
