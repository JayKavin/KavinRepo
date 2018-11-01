package com.primero.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.primero.qa.pages.Homepage;
import com.primero.qa.pages.LoginPage;
import com.primero.qa.testbase.TestBaseClass;

public class Obselete_LoginPageTest extends TestBaseClass {
	Homepage objHome ;

	LoginPage objlogin;

	public Obselete_LoginPageTest()
	{
		super();
		
	}
	
	//@BeforeMethod
	@Test(priority =1)
	public void LaunchURL()
	{
		
		//intialization();
	checkIfBrowserExists(false);
	objlogin = new LoginPage();
	}
	
	@Test(priority =2)
	public void LoginPageTitle()
	{
	
	String strtitle =objlogin.checkLoginPageTitle();
	Assert.assertEquals(strtitle, "Login");
	
	}
	
	@Test(priority =3)
	public void enterloginAccount() throws Exception
	{
		 objlogin.login(prop.getProperty("Username"),prop.getProperty("Password"));
		objHome = objlogin.loginClick();
		Thread.sleep(5000);
		Assert.assertEquals(objHome.checkLoggedInUsername(prop.getProperty("Username")), true);
	}
	
	
	
	//@AfterMethod
	
	
}
