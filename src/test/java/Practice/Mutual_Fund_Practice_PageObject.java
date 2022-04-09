package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Mutual_Fund_Practice_PageObject extends Test_Base_Practice
{
	WebDriver w;
	
	@FindBy(id = "uid")
	public WebElement usernameTextBox;
	
	@FindBy(id = "passw")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")
	public WebElement loginclickbtn;
	
	public void callPageFactoryElements_mf()
	{
		
		PageFactory.initElements(w, this);
		
		
	}

	
} 
