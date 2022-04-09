package com.selenium.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Basic_WebObjects 
{
	WebDriver w;
  @BeforeTest
  public void PreCondition() 
  {
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");

		w = new ChromeDriver(); 
  }
  @Test (priority=0,description= "Test Case to handle TextBox")
  public void handleTextBox () throws Exception 
  {
	  w.get("http://demo.automationtesting.in/Register.html");
	  
	  WebElement firstname = w.findElement(By.cssSelector("input[ng-model='FirstName']"));
	  
	  firstname.clear();
	  firstname.sendKeys("Steve");
	  
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Johns");
	  Thread.sleep(3000);
	  
  }
  @Test (priority=1,description= "Test Case to handle TextBoxArea")
  public void handleTextBoxArea () throws Exception 
  {
	  
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("Sample Address");
	  
      w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).clear();
      w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).sendKeys("abc@gmail.com");
      
      w.findElement(By.cssSelector("input[ng-model='Phone']")).clear();
      w.findElement(By.cssSelector("input[ng-model='Phone']")).sendKeys("9876544554");
      Thread.sleep(3000);	  
  }
  
  @Test (priority=2,description= "Test Case to handle RadioButton")
  public void handleRadioButton() throws Exception 
  {
	  w.findElement(By.cssSelector("input[value='FeMale']")).click();
	  
	  Thread.sleep(3000);
  }
  @Test (priority=3,description= "Test Case to handle checkbox")
  public void handleCheckbox() 
  {
	  w.findElement(By.cssSelector("input[value='Cricket']")).click();
	  
	 }
  @Test (priority=4,description= "Test Case to handle drop-down list")
  public void handledropdownList() throws InterruptedException 
  {
	 WebElement Skills= w.findElement(By.id("Skills"));
	 
	 Select sel= new Select(Skills);
//	 
//	 sel.selectByIndex(4);
//	 sel.selectByValue("configratution");
	// sel.selectByVisibleText("Java");
	 
	 List<WebElement> dataDropDown =sel.getOptions();
	 int numberOfValuve=dataDropDown.size();
	 
	 System.out.println(":\n value Skiils drop down list");
	 
	 //Values in dropDown List 
	 //using for loop 
//	 for (int i=0;i<numberOfValuve;i++) 
//	 {
//		 System.out.println(dataDropDown.get(i).getText());
//	 }
	 //using loop 
	 for(WebElement data:dataDropDown ) 
	 {
		 System.out.println(data.getText());
	 }
	 //using Iterator 
//	ListIterator<WebElement> it=dataDropDown.iterator();
//	while(it.hasNext()) {
//		System.out.println(it.next().getText());
//	}
	
	 Thread.sleep(2000);
	 }
  @AfterTest
  public void afterTest() 
  {
	  w.close();
  }

}
