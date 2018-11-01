package com.primero.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primero.qa.testbase.TestBaseClass;

public class LoginPage extends TestBaseClass {
	
//Page Factory
	@FindBy(id="user_name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement login;
	
	//Initialization of page elements
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Validations
	public String checkLoginPageTitle()
	{
		return driver.getTitle();
	
	}
	
	
	public void login(String user,String pwd)
	{
		username.sendKeys(user);
		password.sendKeys(pwd);		
	}
	
	public Homepage loginClick()
	{

		login.click();
		
		return new  Homepage();
	}
	
}
