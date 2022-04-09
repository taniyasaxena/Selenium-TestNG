package com.selenium.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Login_Mutualfund
{
	WebDriver w;
  @BeforeTest
  public void preCondition() 
  {
System.setProperty("webdriver.chrome.driver",".\\Browser_Driver\\chromedriver.exe" );
      
    w = new ChromeDriver();  
  }
  @Test (priority = 0 ,description= "Test case to verify that login funcationality with 'Admin'user",groups="LoginModule",invocationCount=3,enabled=false)
  public void LoginAdmin() throws Exception 
  {
 w.get("http://altoromutual.com:8080/login.jsp");
      
      w.findElement(By.id("uid")).sendKeys("admin");
      
      w.findElement(By.name("passw")).sendKeys("admin");
      
      w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
      
      Thread.sleep(3000);
      
     w.findElement(By.linkText("Sign Off")).click();
     
     Reporter.log("Admin test case executed!!",true);
  }
  
  @Test (priority = 1 ,description= "Test case to verify that login funcationality with 'tuser'user",groups="LoginModule")
  public void LoginTuser() throws Exception 
  {
 w.get("http://altoromutual.com:8080/login.jsp");
      
      w.findElement(By.id("uid")).sendKeys("tuser");
      
      w.findElement(By.name("passw")).sendKeys("tuser");
      
      w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
      
      Thread.sleep(3000);
      
     w.findElement(By.linkText("Sign Off")).click();
  }
  @Test (priority = 2 ,description= "Test case to verify that login funcationality with 'jsmith'user",groups="LoginModule")
  public void LoginJsmith() throws Exception 
  {
 w.get("http://altoromutual.com:8080/login.jsp");
      
      w.findElement(By.id("uid")).sendKeys("jsmith");
      
      w.findElement(By.name("passw")).sendKeys("Demo1234");
      
      w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
      
      Thread.sleep(3000);
      
     w.findElement(By.linkText("Sign Off")).click();
  }
  @Test (priority = 3,description= "Test case to verify that login funcationality with 'Invalid'user",groups="LoginModule")
  public void LoginInvalidUser() throws Exception 
  {
 w.get("http://altoromutual.com:8080/login.jsp");
      
      w.findElement(By.id("uid")).sendKeys("Test");
      
      w.findElement(By.name("passw")).sendKeys("Test123");
      
      w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
      
      Thread.sleep(3000);
      
     
  }
  
  @AfterTest
  public void postCondition()
  {
	  w.close();
  }

}
