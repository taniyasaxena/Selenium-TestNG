package com.zoopla.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test_Scenario_2 
{
	WebDriver w;
	 SoftAssert st;
  @BeforeTest
  public void preCondition() 
  {
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");

		w = new ChromeDriver();
  }
  @Test (priority = 0, description= "To verify page lable and page title",groups= "Test_Scanerio_2" )
  public void TC001() throws Exception 
  {
	  st= new SoftAssert();
		w.get("https://www.zoopla.co.uk/"); 
		String pageTitle = w.getTitle();
		String pageURL = w.getCurrentUrl();
		//st.assertEquals(pageTitle, "zoopla");  //title 
		st.assertTrue(pageURL.contains("https://www.zoopla.co.uk/"), "Page URL is diffrent"); // url
		
		w.findElement(By.xpath("//*[@id=\"__next\"]/main/div[1]/div[3]/div[2]/div/div[8]/button"));
		
        Thread.sleep(3000);
		
	    st.assertAll();
		
  }
  @Test (priority = 1, description= "To verify Search button funcutnality ",groups= "Test_Scanerio_2" )
  public void TC002() throws Exception 
  {
	w.findElement(By.id("header-location")).sendKeys("London"); 
	w.findElement(By.xpath("//*[@id=\"__next\"]/main/div[1]/div[3]/div[2]/div/div[8]/button")).click();
	
	String pageTitle = w.getTitle();
	String pageURL = w.getCurrentUrl();
	String pageLableText = pageTitle;
	st.assertTrue(pageLableText.contains("London"), "Page lable doesn't contains London"); //page title
	WebElement pageLable = w.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/main/div[1]/h1")); // page lable using text
	 Thread.sleep(3000);
		
	    st.assertAll();
  }
  @Test (priority = 2, description= "To verify Proparty details ",groups= "Test_Scanerio_2" )
  public void TC003() throws Exception 
  {
	w.findElement(By.xpath("//*[@id=\"listing_56254504\"]/div[1]/div[2]/div[2]/a[2]/div[1]/div/p[1]")).click();
	w.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div[1]/section[1]/div[1]/div[2]/span"));
	w.findElement(By.xpath("//*[@id=\"listing-summary-details-heading\"]/span[1]"));
	
  }
  @AfterTest
  public void PostCondition()
  {
	 w.close(); 
	 System.out.println("Test Execution Sucessfully done!!!");
  }

}
