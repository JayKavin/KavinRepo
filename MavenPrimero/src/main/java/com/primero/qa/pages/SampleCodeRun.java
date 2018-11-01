package com.primero.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.base.Converter;
import com.primero.qa.util.ExcelUtil;

public class SampleCodeRun extends ExcelUtil {

	public SampleCodeRun() {
		super();
		//ArrayList<Object[]> arrcaseData = new ArrayList<Object[]>();
	}
	@Test(priority=1)
	public void setExcel() {
		
	String	strActual= "Case record 82d6e96 successfully created.";
		String actual=strActual.substring(12, 19);
		
		
		// TODO Auto-generated method stub
		//SampleCodeRun sr = new SampleCodeRun();

		//setExcelFile(prop.getProperty("Path_TestData") + prop.getProperty("File_TestData"), "CaseSheet");

	}

	
	@Test(priority=2)
	public void FeedDatatoNewCaseForm()
	{
		int iRow = getCellRowNum("CaseSheet", "Test_Id", "Test_1");
		Object[] obj1 = new Object[6];
		String strFlag = getCellData("CaseSheet", "RunFlag", iRow);
		String excelFlag ="Y";
		if ((strFlag.toUpperCase().trim()).equals(excelFlag)) {

			//String strName = getCellData("CaseSheet", "Name", iRow);
			obj1[0] = getCellData("CaseSheet", "Name", iRow);
			//String strAge = getCellData("CaseSheet", "Age", iRow);
			obj1[1] = getCellData("CaseSheet", "Age", iRow);
			//String strSex = getCellData("CaseSheet", "Sex", iRow);
			obj1[2] =getCellData("CaseSheet", "Sex", iRow);
			obj1[3]=  getCellData("CaseSheet", "AgeEstimated", iRow);
			//String strNationality = getCellData("CaseSheet", "Nationality", iRow);
			obj1[4] =getCellData("CaseSheet", "Nationality", iRow);
			//String strMaritalStatus = getCellData("CaseSheet", "MaritalStatus", iRow);

			obj1[5] =getCellData("CaseSheet", "MaritalStatus", iRow);
	
	System.out.println(obj1[0]);
	}

}
	}
// @DataProvider
/*
 * public Iterator<Object[]> getCaseTestData() { ArrayList<Object[]> testData =
 * ReadCaseDataFromExcel(); return testData.iterator(); }
 */

/*
 * @Test(priority=3) public void FeedDatatoNewCaseForm() {
 * 
 * //ArrayList<Object[]> objarr = ReadCaseDataFromExcel();
 * //System.out.println(ArrayList<Object[]> arrcaseData.get(0));
 * System.out.println(strName); System.out.println(strAge);
 * System.out.println(strSex);
 * 
 * System.out.println(strAgeEstimated); System.out.println(strNationality);
 * 
 * System.out.println(strMaritalStatus);
 */



