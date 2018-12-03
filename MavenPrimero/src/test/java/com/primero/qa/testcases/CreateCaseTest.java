package com.primero.qa.testcases;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primero.qa.config.EnvironmentVariablesConfig;
import com.primero.qa.pages.CaseListPage;
import com.primero.qa.pages.Homepage;
import com.primero.qa.pages.LoginPage;
import com.primero.qa.pages.NewCasePage;
import com.primero.qa.testbase.TestBaseClass;
import com.primero.qa.testdata.ReadWriteExcelData;
import com.primero.qa.util.ExcelUtil;

public class CreateCaseTest extends TestBaseClass {

	Homepage objHome;
	CaseListPage objCaseListPage;
	NewCasePage objNewCasePage;
	LoginPage objlogin;
	public int iCnt=0;
	
	/*public CreateCaseTest() {
		super();
		// checkIfBrowserExists(false);
		// this constructor is called without child class new keyword, as
		// testng uses reflection internally which triggers class instantiation
		// internally.
	}*/

	
	@BeforeSuite
	public void setup() {
		
		try {
			// Property Initialization;
			InitializeProperties();

			EnvironmentVariablesConfig.setTestScenarioName("CreateNewChildCase");
			// Browser Initialization;
			//checkIfBrowserExists(false);
			//set excel workbook to read data table
			setExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block //
			e.printStackTrace();
		}
	}

	@BeforeTest 
	public void LaunchBrowser() {
		
		try {

			// Browser Initialization;
			checkIfBrowserExists(false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@BeforeMethod
	public void LoginIntoPrimero() throws Exception {

		iCnt++;
		objlogin = new LoginPage();
		
		String strtitle = objlogin.checkLoginPageTitle();
		Assert.assertEquals(strtitle, "Login");

		objlogin.login(prop.getProperty("Username"), prop.getProperty("Password"));
		objHome = objlogin.loginClick();
		Thread.sleep(1000);
		Assert.assertEquals(objHome.checkLoggedInUsername(prop.getProperty("Username")), true);

		customHTMLReport( "TestId "+ iCnt , "Login into Primero", "Login is successful",  "", "Passed", "Logged in username is "+prop.getProperty("Username"));
		
		objCaseListPage = objHome.tabSelect("CASES");
		Thread.sleep(1000);
		
		objNewCasePage = objCaseListPage.pNavigatenewCPCaseForm();
		Assert.assertTrue(objNewCasePage.checkNewcaseFormLoaded(), "Form loaded successfully");
		customHTMLReport( "TestId "+ iCnt, "New case Form Load", "Form loaded successfully",  "", "Passed", "");

	}

	/*@BeforeMethod
	public void CreateNewCaseForm() throws Exception {
		try {

			objNewCasePage = objCaseListPage.pNavigatenewCPCaseForm();
			Assert.assertTrue(objNewCasePage.checkNewcaseFormLoaded(), "Form loaded successfully");
			customHTMLReport( "TestId1", "New case Form Load", "Form loaded successfully",  "", "Passed", "");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

/*	   @DataProvider

	    public Iterator<Object[]> dp(){

	        return ReadWriteExcelData.

	    }*/
	
	@Test(dataProvider="getTableArray",dataProviderClass=ReadWriteExcelData.class)
	public void FeedDatatoNewCaseForm(String[] strArray) throws Exception
	{
/*	System.out.println(strArray[0]+"first iter");
	System.out.println(strArray[1]+"first iter");*/
	objNewCasePage.fillcpcaseform1(strArray);
	
	String strCaseId = objNewCasePage.SaveaCase();
	Thread.sleep(2000);
	boolean blnCaseFalg =false;
	if(strCaseId!=null)
	{
	
	  blnCaseFalg = true;
	  objCaseListPage=  objHome.tabSelect("CASES");
	}
	Assert.assertTrue(blnCaseFalg, "Case"+strCaseId+"Created Successfully");
	customHTMLReport( "TestId "+ iCnt, "Create New Case", "New Case created successfully",  "", "Passed", "Case Id "+strCaseId);
	//Assert.assertTrue(driver.getTitle().matches(".*TST-\\d{5}.*"));
	
	}
	
	
	@AfterMethod
	public void Logout() throws Exception {

		objlogin = objCaseListPage.Logout();
		//objlogin = new LoginPage();
		
		String strtitle = objlogin.checkLoginPageTitle();
		Assert.assertEquals(strtitle, "Login");
		customHTMLReport( "TestId "+ iCnt, "Logout from Primero", "Logout successful",  "", "Passed", "");
		
		
	}
	
	/*@AfterClass
	public void CloseBrowser() throws IOException {


		driver.close();
	}*/
	
	@AfterTest
	public void DeleteCookies() {


		//driver.close();
	}
	
	@AfterSuite
	public void teardown() {


		//driver.close();
	}
}




