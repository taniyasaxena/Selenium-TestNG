package Practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Mutual_Fund_Test 
{
	Mutual_Fund_Practice_PageObject mf;
	
  @BeforeTest
  public void beforeTest() 
  {
	  mf= new Mutual_Fund_Practice_PageObject();
	  mf.openBrowser("Chrome");
	  mf.callPageFactoryElements_mf();
	  
	  
  }
  @Test (priority=0,description="TestCase to Verify the Username and Password ")
  public void UsernamePassword () throws Exception 
  {
	  mf.OpenApplication();
	  mf.HandleTextBox(mf.usernameTextBox, "admin");
	  mf.HandleTextBox(mf.passwordTextBox, "admin");
	  mf.HandleClickEvent(mf.loginclickbtn);
	  mf.wait(2);
	 
//	  Assert assert1 = new Assert();
//	assert1.equals(mf.loginclickbtn);
	  
  }
  @AfterTest
  public void afterTest() 
  {
	  mf.closeBrowser();
  }

}
