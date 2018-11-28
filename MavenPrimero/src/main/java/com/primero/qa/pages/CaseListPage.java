package com.primero.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primero.qa.testbase.TestBaseClass;
//import com.primero.qa.testcases.WebDriverWait;


public class CaseListPage extends TestBaseClass {

	
	@FindBy(xpath="//a[@data-toggle='modules-dropdown']//span[text()='New Case']")
	WebElement NewCase;
	
	@FindBy(xpath ="//a[contains(text(),'CP')]")
	WebElement CPCase;
	
	@FindBy(xpath ="//a[contains(text(),'Create New Case')]")
	WebElement CreateNewCPCase;
	
	@FindBy(linkText ="Logout")
	WebElement Logout;
	

	
	
	//Initialization of page elements
	public CaseListPage()
	{
		PageFactory.initElements(driver, this);
		  
	}

	
public NewCasePage pNavigatenewCPCaseForm() throws Exception
{
	NewCase.click();
	Thread.sleep(1000);
	if(CPCase.isDisplayed())
	{
		CPCase.click();
	
		if(CreateNewCPCase.isDisplayed())
		{
			CreateNewCPCase.click();
		}
		Thread.sleep(1000);
    }
	
	return new  NewCasePage();
}

public LoginPage Logout() throws Exception
{
	Logout.click();
	Thread.sleep(1000); 	

	
	return new  LoginPage();
}


}
	

	