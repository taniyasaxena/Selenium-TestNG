package com.policyx.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test_Scanerio_1
{
	WebDriver w;
	 SoftAssert st;
  @BeforeTest
  public void preCondition()
  {
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");

		w = new ChromeDriver();
  
  }
  @Test (priority = 0, description= "To verify page lable and page title",groups= "Test_Scanerio_1" )
  
  public void TS001 () 
  {
	  st= new SoftAssert();
		w.get("https://www.policyx.com/"); 
		String pageTitle = w.getTitle();
		String pageURL = w.getCurrentUrl();
		
		WebElement pageLable = w.findElement(By.xpath("//*[@id=\"page1\"]/section[1]/div/div/div[2]/h1"));
		String pageLableText = pageLable.getText();

		st.assertTrue(pageLableText.contains("India's Most Trusted Insurance Portal"), "Page lable is diffrent ");
		
		st.assertEquals(pageTitle, "Insurance");
		st.assertTrue(pageURL.contains("policyx.com"), "Page URL is diffrent");
  }
@Test (priority = 1, description= "To verify claim button and page lable",groups= "Test_Scanerio_1" )
  
  public void TS002 () 
  {
	WebElement ClaimButton = w.findElement(By.xpath("//*[@id=\"page1\"]/header/div/div[4]/div[4]/a"));
	st.assertTrue(ClaimButton.isDisplayed(), "Claim Link is not displayed");  
	w.findElement(By.xpath("//*[@id=\"page1\"]/header/div/div[4]/div[4]/a")).click();
	
	WebElement pageLable1 = w.findElement(By.xpath("//*[@id=\"page1\"]/div[2]/div/div/div[1]/h1"));
	String pageLableText = pageLable1.getText();

	st.assertTrue(pageLableText.contains("CLAIM ASSISTANCE"), "Page lable is diffrent");
	
//	String pageTitle= w.getTitle();
//	st.assertEquals(pageTitle, "I");
	
  }
  @AfterTest
  public void afterTest() {
  }

}
