package com.primero.qa.TestngSuite;


import java.util.List;
import org.testng.TestNG;
import org.testng.collections.Lists;

import com.primero.qa.testbase.TestBaseClass;


public class TestDriverClass extends TestBaseClass {
	
	public static String userDirector = System.getProperty("user.dir");
	public static String resultFile =userDirector+"Mytestng-suite.xml";
	
	
	public static void main(String[] args) throws Exception {

		
			InitializeProperties();
			XLSReader suitefile = new XLSReader(prop.getProperty("Path_TestData") + prop.getProperty("File_TestData"));
			suitefile.getTests("Select * from TCDriver where module='CP'");
			
			TestNG testng = new TestNG();
		    List<String> suites = Lists.newArrayList();
		    suites.add(resultFile);
		    testng.setTestSuites(suites);
		    testng.run();
		   		
	}
}
