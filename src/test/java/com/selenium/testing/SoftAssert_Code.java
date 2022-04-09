package com.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert_Code
{
	WebDriver w;
   SoftAssert st;
   
	@BeforeTest
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");

		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Test case to verify that login funcationality with 'Admin'user", groups = "LoginModule")
	public void LoginAdmin() throws Exception 
	{
		 st= new SoftAssert();
		w.get("http://altoromutual.com:8080/login.jsp");

		WebElement signInButton = w.findElement(By.id("LoginLink"));
		st.assertTrue(signInButton.isDisplayed(), "Sign In Link is not displayed");

		String pageTitle = w.getTitle();
		String pageURL = w.getCurrentUrl();

		Assert.assertEquals(pageTitle, "Altoro Mutual");
		st.assertTrue(pageURL.contains("login.jsp"), "Page URL is diffrent");

		WebElement pageLable = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String pageLableText = pageLable.getText();

		st.assertTrue(pageLableText.contains("Login"), "Page lable doesn't contains login");

		w.findElement(By.id("uid")).sendKeys("admin");

		w.findElement(By.name("passw")).sendKeys("admin");

		w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();

		Thread.sleep(3000);
		
	    st.assertAll();

	}

	@Test(priority = 1, description = "Test case to verify that Logoutfuncationality with 'Admin'user", groups = "LoginModule")
	public void LogOut() throws Exception

	{
		Thread.sleep(3000);
		String pageTitle = w.getTitle();
		String pageURL = w.getCurrentUrl();

		st.assertTrue(pageURL.contains("main.jsp"), "URL is Mismatch");

		WebElement pageLable = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		String pageLableText = pageLable.getText();

		st.assertTrue(pageLableText.contains("Admin"), "Page lable doesn't contains Admin");

		w.findElement(By.linkText("Sign Off")).click();
		 st.assertAll();

		Reporter.log("Admin test case executed!!", true);
	}

	@AfterTest
	public void postCondition() {
		w.close();
	}
}
