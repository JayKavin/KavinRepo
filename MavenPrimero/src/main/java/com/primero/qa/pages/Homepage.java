package com.primero.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primero.qa.testbase.TestBaseClass;

public class Homepage extends TestBaseClass{

	//Page Factory
/*		@FindBy(id="user_name")
		WebElement username;
		
		@FindBy(id="password")
		WebElement password;*/
		

		
		//Initialization of page elements
		public Homepage()
		{
			PageFactory.initElements(driver, this);
			  
		}
		
		//Validations
		public boolean checkLoggedInUsername( String strLoggedinUser)
		{
			return driver.findElement(By.xpath("//li[contains(text(),'Logged in as: "+strLoggedinUser+"')]")).isDisplayed();
			
		
		}
		
		//Validations
		public CaseListPage tabSelect( String tabname)
		{
			//return driver.findElement(By.xpath("//li[contains(text(),'Logged in as: "+strLoggedinUser+"')]")).isDisplayed();
			
		driver.findElement(By.linkText(""+tabname+"")).click();
		return new  CaseListPage();
		
		}
		

}
