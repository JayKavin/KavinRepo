package com.primero.qa.testdata;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primero.qa.testbase.TestBaseClass;
import com.primero.qa.util.ExcelUtil;


public class ReadWriteExcelData extends TestBaseClass {
	

	//Read new case details.
	@DataProvider 
	public Object[][] getExcelCaseData()
	{
		int iRow = ExcelUtil.getCellRowNum("CaseSheet", "Test_Id", "Test_1");
		Object[] obj1 = new Object[7];
		String strFlag = ExcelUtil.getCellData("CaseSheet", "RunFlag", iRow);
		String excelFlag = "Y";
		if ((strFlag.toUpperCase().trim()).equals(excelFlag)) {

			// String strName = getCellData("CaseSheet", "Name", iRow);
			obj1[0] = ExcelUtil.getCellData("CaseSheet", "Name", iRow);
			
			obj1[1] = ExcelUtil.getCellData("CaseSheet", "Name", iRow);
			// String strAge = getCellData("CaseSheet", "Age", iRow);
			obj1[2] = ExcelUtil.getCellData("CaseSheet", "Age", iRow);
			// String strSex = getCellData("CaseSheet", "Sex", iRow);
			obj1[3] = ExcelUtil.getCellData("CaseSheet", "Sex", iRow);
			obj1[4] = ExcelUtil.getCellData("CaseSheet", "AgeEstimated", iRow);
			// String strNationality = getCellData("CaseSheet", "Nationality", iRow);
			obj1[5] = ExcelUtil.getCellData("CaseSheet", "Nationality", iRow);
			// String strMaritalStatus = getCellData("CaseSheet", "MaritalStatus", iRow);

			obj1[6] = ExcelUtil.getCellData("CaseSheet", "MaritalStatus", iRow);
	}
		return new Object[][] {obj1};
		
	}
	


	
	//Read new case details.
	@DataProvider 
	public Object[][] getTableArray() 
	{
		
		Object[][] obj1 = null;
		try {
			obj1 = ExcelUtil.getTableArray(prop.getProperty("Path_TestData") + prop.getProperty("File_TestData"), "CaseSheet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return   obj1;

		
	}
	/*
	@DataProvider 
	public Iterator<Object[]> getTableArray() 
	{
		
		Object[] obj1 = null;
		try {
			obj1 = ExcelUtil.getTableArray(prop.getProperty("Path_TestData") + prop.getProperty("File_TestData"), "CaseSheet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Object[][] {obj1};

		
	}*/
	
}
