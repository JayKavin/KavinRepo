package com.primero.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.primero.qa.testbase.TestBaseClass;

public class NewCasePage extends TestBaseClass{

	
	@FindBy(xpath="//label[@for='basic_identity_child_case_id_display']")
	WebElement NewCaseformlabel;
	
	
	@FindBy(name="child[age]")
	WebElement Age;
	
	@FindBy(id="basic_identity_child_estimated")
	WebElement IsEstimated;
	
	@FindBy(xpath="//*[@id=\"basic_identity_child_name_last\"]")
	WebElement SurName;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement SaveButton;
	
	@FindBy(xpath="//p[contains(text(),'Case record')]")
	WebElement CaseIDResult;
	
    public static String ResultCaseID;
	
	

	
	//Initialization of page elements
	public NewCasePage()
	{
		PageFactory.initElements(driver, this);
		  
	}
	
	public boolean checkNewcaseFormLoaded()
	{
	
		return NewCaseformlabel.isDisplayed();
			
	}

	

	public void fillcpcaseform(Object[] obj1) {
		for (Object objval : obj1) {
			System.out.println(objval);
		}
		
	}

	public void fillcpcaseform(String strName, String strSurName, String strAge, String strSex,String strEstimatedFlag, String strNationality, String strMaritalStatus) {
		try {
		
			
			
			
			
		//Child name
		driver.findElement(By.cssSelector("input[id='basic_identity_child_name_first'][name='child[name_first]']")).sendKeys(strName);
		//surname
		SurName.sendKeys(strSurName);
		//age
		Age.sendKeys(String.valueOf(strAge));
		
		//Checkbox'
		if(strEstimatedFlag.equals("Yes"))
		{
		IsEstimated.click();
		}
		
		//Single select
		driver.findElement(By.xpath("//*[@id=\"basic_identity_child_sex_chosen\"]/a/span")).click();
		
		Thread.sleep(2000);
	
		//Single select
		driver.findElement(By.xpath("//div[@id='basic_identity_child_sex_chosen']//div//li[contains(text(),'"+strSex+"')]")).click();	
		Thread.sleep(1000);
		

		//MultiSelect'//
		WebElement nt= driver.findElement(By.xpath("//*[@id=\"basic_identity_child_nationality__chosen\"]/ul/li/input"));
		nt.click();		
		String[] arrSplit = strNationality.split("\\|");
		for (String strval : arrSplit)
		{				
			nt.click();	
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"basic_identity_child_nationality__chosen\"]/div/ul/li[contains(text(),'"+strval+"')]")).click();
			
		}
		
		//Single select strMaritalStatus
		driver.findElement(By.xpath("//*[@id=\"basic_identity_child_maritial_status_chosen\"]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"basic_identity_child_maritial_status_chosen\"]/div/ul/li[contains(text(),'"+strMaritalStatus+"')]")).click();
		
		}
		 catch (InterruptedException e) {
		 
		// TODO Auto-generated catch block
					e.printStackTrace();
		 }
	}
	
	public  String SaveaCase() throws Exception 
	{
		
		
		SaveButton.click();
/*		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(CaseIDResult));
	*/	
		//p[contains(text(),'Case record')]
		
		
		//Thread.sleep(1000);
		if(CaseIDResult.isDisplayed())
		{
			String strActual = CaseIDResult.getText();
		    ResultCaseID =strActual.substring(12, 19);
		  
	    }
		return ResultCaseID;
	}
	
}

