package com.primero.qa.TestngSuite;

import java.io.File;
import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.primero.qa.testbase.TestBaseClass;

public class XLSReader  {

    private final Fillo fillo;
    private final String filePath;
	public static String userDirector = System.getProperty("user.dir");
	public static String resultFile = userDirector + "//test-output//testng-suite.xml";

	//test-output//PrimeroCustomReport.html
	
    private Connection connection;
    public XLSReader(String filePath) {
        fillo = new Fillo();
        this.filePath = filePath;
    }

    public void getTests(String query)  throws FilloException {
        try {
            connection = fillo.getConnection(this.filePath);
            Recordset recordset = connection.executeQuery(query);
            this.createSuite(recordset);
        } catch (FilloException e) {
            e.printStackTrace();
        } /*finally {
            connection.close();*/
       // }
    }

    public void createSuite(Recordset recordset)  throws FilloException {
        XmlMapper xmlMapper = new XmlMapper();
        Suite suite = new Suite("PrimeroSuite");
        try {
            while (recordset.next()) {

                String testName = recordset.getField("TestCaseDescription");
                String className = recordset.getField("ClassName");
                String param = "Data";
                String paramValue = recordset.getField("Data");

                suite.addTest(testName, param, paramValue, className);
                
                
            }
            xmlMapper.writeValue(new File(resultFile), suite);

    		   		
    		
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
            recordset.close();
        }*/
		//return resultFile;
    }
	
}