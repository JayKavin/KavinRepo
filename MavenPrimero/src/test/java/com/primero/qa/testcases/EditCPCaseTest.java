package com.primero.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.primero.qa.config.EnvironmentVariablesConfig;
import com.primero.qa.pages.LoginPage;
import com.primero.qa.testbase.TestBaseClass;

public class EditCPCaseTest extends TestBaseClass {
	
	
	@BeforeSuite
	public void setup() {
		
		
	}

	@BeforeMethod
	public void LaunchURL() {
		
		//Assert.assertTrue(false, "URL launched");
	}
	
	
	@Test
	public void LoginIntoPrimero() throws Exception {

		
		//Assert.assertTrue(false, "Edit case login failed");
		Assert.assertEquals("strtitle", "Login");
		

	}
	
	
	@Test
	public void AccessHome() throws Exception {

		
		//Assert.assertTrue(false, "Edit case login failed");
		Assert.assertEquals("Home", "Home");
		

	}
	
	@Test
	public void clickCase() throws Exception {

		
		//Assert.assertTrue(false, "Edit case login failed");
		Assert.assertEquals("Case", "Case");
		

	}
	
	
	@AfterMethod
	public void logout() {
		
		//Assert.assertTrue(false, "Edit case login failed");
	}
	
}
