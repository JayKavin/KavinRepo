package com.primero.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	@FindBy(id="basic_identity_child_name_first")
	WebElement FirstName;
	
	@FindBy(id="basic_identity_child_name_middle")
	WebElement MiddleName;
	
	@FindBy(id="basic_identity_child_name_nickname")
	WebElement NickName;
	
	@FindBy(id="basic_identity_child_name_other")
	WebElement OtherName;
	
	@FindBy(id="basic_identity_child_assessment_due_date")
	WebElement AssessDueDate;
	
	@FindBy(id="basic_identity_child_physical_characteristics")
	WebElement PhysicalChar;
	
	
	
	@FindBy(id="basic_identity_child_ration_card_no")
	WebElement RationCarNo;
	
	@FindBy(id="basic_identity_child_icrc_ref_no")
	WebElement IRCRCNo;

	
	@FindBy(id="basic_identity_child_rc_id_no")
	WebElement RCIDNo;
	
	@FindBy(id="basic_identity_child_biometrics_id")
	WebElement Biometrics;
	
	@FindBy(id="basic_identity_child_unhcr_id_no")
	WebElement ProgID;
	
	@FindBy(id="basic_identity_child_unhcr_individual_no")
	WebElement PRogIDVID;
	
	
	@FindBy(id="basic_identity_child_un_no")
	WebElement UNNo;
	
	@FindBy(id="basic_identity_child_national_id_no")
	WebElement NationIdNo;
	
	@FindBy(id="basic_identity_child_other_id_type")
	WebElement OtherTypeDoc;
	
	
	@FindBy(id="basic_identity_child_other_id_no")
	WebElement OtherIDDocNo;
	
	@FindBy(id="basic_identity_child_other_agency_id")
	WebElement OtherAgencyId;
	
	@FindBy(id="basic_identity_child_other_agency_name")
	WebElement OtherAgencyName;
	
	@FindBy(id="basic_identity_child_documents_carried")
	WebElement DocCarried;
	
	@FindBy(id="basic_identity_child_occupation")
	WebElement Occupation;
	
	@FindBy(id="basic_identity_child_address_current")
	WebElement CurrentAddress;
	

	@FindBy(id="basic_identity_child_landmark_current")
	WebElement Landmark;
	
	
	@FindBy(id="basic_identity_child_address_is_permanent")
	WebElement IsPermanent;
	
	@FindBy(id="basic_identity_child_telephone_current")
	WebElement PhoneNo;
	
	
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

	

	public void fillcpcaseform1(String[] strArray) throws Exception 
	{
	
		//FristName	
				
		FirstName.sendKeys(strArray[2]);
			  
		//Child name
		//driver.findElement(By.cssSelector("input[id='basic_identity_child_name_first'][name='child[name_first]']")).sendKeys(strName);

		//MiddleName
		MiddleName.sendKeys(strArray[3]);

		//surname
		SurName.sendKeys(strArray[4]);

		
		//NickName
		NickName.sendKeys(strArray[5]);

		//OtherName
		OtherName.sendKeys(strArray[6]);
		

		//AfterSeperation

		if(strArray[7].equals("Yes"))
		{
		driver.findElement(By.xpath("//input[@id='basic_identity_child_name_given_post_separation'][@value='true']")).click();
		}
		else
		{
			driver.findElement(By.xpath("//input[@id='basic_identity_child_name_given_post_separation'][@value='false']")).click();
		}
		
		//DateReg 8
		
		
		//DateAssess
		AssessDueDate.sendKeys(strArray[9]);
		Thread.sleep(1000);
		AssessDueDate.sendKeys(Keys.ARROW_DOWN);
		AssessDueDate.sendKeys(Keys.ENTER);
		//Sex	10
		//Single select
		driver.findElement(By.xpath("//*[@id=\"basic_identity_child_sex_chosen\"]/a/span")).click();

		Thread.sleep(2000);

		//Single select
		driver.findElement(By.xpath("//div[@id='basic_identity_child_sex_chosen']//div//li[contains(text(),'"+strArray[10]+"')]")).click();	
		Thread.sleep(1000);
		
		//Age	11
		Age.sendKeys(strArray[11]);
		
		
		//DOB	12
		
		//AgeEstimated	13
		if(strArray[13].equals("Yes"))
		{
		IsEstimated.click();
		}
	
		
		//PhysicalChar	14
		PhysicalChar.sendKeys(strArray[14]);
		
		//RationCardNo	15
		RationCarNo.sendKeys(strArray[15]);
		//ICRCNo	16
		IRCRCNo.sendKeys(strArray[16]);
		//RCIDNo	17
		RCIDNo.sendKeys(strArray[17]);
	//	Biometrics	18
		Biometrics.sendKeys(strArray[18]);
		
		//ProgID	19
		ProgID.sendKeys(strArray[19]);
		
		//ProgIndID	20
		PRogIDVID.sendKeys(strArray[20]);
		Thread.sleep(1000);
		
		//UNNo	21
		UNNo.sendKeys(strArray[21]);
		Thread.sleep(1000);
		
		//NationalIDNo	22
		NationIdNo.sendKeys(strArray[22]);
		Thread.sleep(1000);
		
	//	OtheIDDocType	23
		OtherTypeDoc.sendKeys(strArray[23]);
		Thread.sleep(1000);
		
		//OtherIDNo	24
		OtherIDDocNo.sendKeys(strArray[24]);
		
		Thread.sleep(1000);
		
		//OtherAgencyID	25
		OtherAgencyId.sendKeys(strArray[25]);
		
		Thread.sleep(1000);
		
		//OtherAGName	26
		OtherAgencyName.sendKeys(strArray[26]);
		
		Thread.sleep(1000);
		
	//	DocumentsCarried	27
		DocCarried.sendKeys(strArray[27]);
		
	
		//	Nationality	28
		
		//MultiSelect'//
		WebElement nt= driver.findElement(By.xpath("//*[@id=\"basic_identity_child_nationality__chosen\"]/ul/li/input"));
		nt.click();		
		String[] arrSplit = strArray[28].split("\\|");
		for (String strval : arrSplit)
		{				
				nt.click();	
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"basic_identity_child_nationality__chosen\"]/div/ul/li[contains(text(),'"+strval+"')]")).click();
				
		}
		
		
		
		//MaritalStatus	29
		//Single select strMaritalStatus
		driver.findElement(By.xpath("//*[@id=\"basic_identity_child_maritial_status_chosen\"]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"basic_identity_child_maritial_status_chosen\"]/div/ul/li[contains(text(),'"+strArray[29]+"')]")).click();

		
		
		//Occupation	30
		Occupation.sendKeys(strArray[30]);
		
		//CurrentAddress	31
		CurrentAddress.sendKeys(strArray[31]);
		
		//LandMark	32
		Landmark.sendKeys(strArray[32]);
		
		//CurretnLocation	33
		
		//IsPermanent	34

		if(strArray[34].equals("Yes"))
		{
			IsPermanent.click();
		}
		
		//CurrentTelephone	35
		
		PhoneNo.sendKeys(strArray[35]);
		
		
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


	/*//public void fillcpcaseform(String strName, String strSurName, String strAge, String strSex,String strEstimatedFlag, String strNationality, String strMaritalStatus) {

//When u pass 2 diementional array - perforn foreach twice
//public void fillcpcaseform(String[][] obj1) throws InterruptedException {
	for (String[] objvalOuter : strArray)
		{
	for (String objval : objvalOuter) {
		System.out.println(objval);
	}
		}
	//FristName	
  FirstName.sendKeys(obj1[0].toString());


}

//When u pass 1 diementional array - perforn foreach once or directly assign value to the elements
public void fillcpcaseform(String[] obj1) throws InterruptedException {
	for (String objvalOuter : strArray)
		{
		FirstName.sendKeys(objvalOuter);
		}
	//FristName	
	//or directly assign
FirstName.sendKeys(objvalOuter[0].toString());


}*/
