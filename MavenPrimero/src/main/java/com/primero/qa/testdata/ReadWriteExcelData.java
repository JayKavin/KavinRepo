package com.primero.qa.testdata;

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
	

}
