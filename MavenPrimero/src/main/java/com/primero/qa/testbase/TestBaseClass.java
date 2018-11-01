package com.primero.qa.testbase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.primero.qa.util.CommonUtil;
import com.primero.qa.util.ExcelUtil;


public class TestBaseClass  {

	public static WebDriver driver;
	public static Properties prop;
	public static String userDirector = System.getProperty("user.dir");
	public static String resultFile = userDirector + "//test-output//PrimeroCustomReport.html";

	
	public void InitializeProperties() {
		try {
			prop = new Properties();
			FileInputStream file;
			file = new FileInputStream(
					"C:\\Users\\jkasilingam\\eclipse-workspace\\MavenPrimero\\src\\main\\java\\com\\primero\\qa\\config\\config.properties");
			prop.load(file);
			DeleteCustomReportFile();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setExcel() {

		try {
			ExcelUtil.setExcelFile(prop.getProperty("Path_TestData") + prop.getProperty("File_TestData"), "CaseSheet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void checkIfBrowserExists(boolean blnBrowserExist) {
		if (blnBrowserExist != true) {
			/*
			 * public static void intialization() {
			 */
			String browserName = prop.getProperty("browser");
			if (browserName.equals("Chrome")) {
				System.setProperty(prop.getProperty("ChFile_DriverClass"), prop.getProperty("ChFile_DriverPath"));
				driver = new ChromeDriver();
			}

			if (browserName.equals("ie")) {
				System.setProperty(prop.getProperty("IEFile_DriverClass"), prop.getProperty("IEFile_DriverPath"));
				driver = new ChromeDriver();

			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(CommonUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("URL"));

			// }

		} else {
			/*
			 * //to run from existing browser. public static void RunFromOpenedBrowser() {
			 */String browserName = prop.getProperty("browser");
			if (browserName.equals("Chrome")) {

				System.setProperty(prop.getProperty("ChFile_DriverClass"), prop.getProperty("ChFile_DriverPath"));
				ChromeOptions cOption = new ChromeOptions();
				cOption.setExperimentalOption("debuggerAddress", prop.getProperty("File_LocalHost"));
				driver = new ChromeDriver(cOption);
			}

			if (browserName.equals("ie")) {
				ChromeOptions cOption = new ChromeOptions();
				cOption.setExperimentalOption("debuggerAddress", prop.getProperty("File_LocalHost"));
				driver = new ChromeDriver(cOption);
			}
			// not required.
			// driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(CommonUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

			// return driver;
		}

	}

	public static void customHTMLReport(String TestId, String StepName, String Actual, String NestedColor,
			String Status, String Comments) throws IOException

	{
		String StartDateTime = new SimpleDateFormat("MM-dd-yyyy_HH-mm").format(new GregorianCalendar().getTime());



		File file = new File(resultFile);
		System.out.println(file.exists());

		if (!file.exists()) {
			
			FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("<h2 align='CENTER'><font color='#003399'>UNICEF QA Test Report</font></h2>");
			bw.write("<h3 align='CENTER'><font color='#003399'>Test Name : CreateCaseTestTestName</font></h3>");
			bw.write(
					"<table border='1' bordercolor='#E6E6E6' bgcolor='#CCCCCC' cellpadding='2' cellspacing='0' width='90%' align='Center' borderwidth='1px' >");
			bw.write("<tr><font color='#003399'>Executed on ::   " + StartDateTime + " </font></tr>");
			bw.write("<tr>");
			// Add Table Headers
			bw.write("<th style=color:white;background-color:'#0099FF';>Test ID</th>");
			bw.write("<th style=color:white;background-color:'#0099FF';>StepName</th>");
			bw.write("<th style=color:white;background-color:'#0099FF';>Actual Result</th>");
			bw.write("<th style=color:white;background-color:'#0099FF';>Status</th>");
			bw.write("<th style=color:white;background-color:'#0099FF';>Comments</th>");

			bw.write("</tr>");
			bw.flush();
			bw.close();
		}
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(file, true));

		bw1.write("<tr>");

		// Add table data
		if (NestedColor == "Yellow") {
			bw1.write("<td align='Center' width='5%' bgcolor='Yellow'><font color='Black' >" + TestId + "</font></td>");
			bw1.write("<td align='Left' width='35%' bgcolor='Yellow'><font color='Black'>" + StepName + "</font></td>");
			bw1.write("<td align='Left' width='35%' bgcolor='Yellow'><font color='Black' >" + Actual + "</font></td>");

			if ((Status).toLowerCase().equals("failed")) {
				bw1.write("<td align='Center' width='10%' bgcolor='Yellow'><b><font color='Red' >" + Status
						+ "</font></b></td>");
			} else if (Status.toLowerCase().equals("passed")) {
				bw1.write("<td align='Center' width='10%' bgcolor='Yellow'><b><font color='Green' >" + Status
						+ "</font></b></td>");

			}
			bw1.write("<td align='Left' width='15%' bgcolor='Yellow'><font color='Black' >" + Comments + "</font></td>");
		} else {
			bw1.write("<td align='Center' width='5%'><font color='Black' >" + TestId + "</font></td>");
			bw1.write("<td align='Left' width='35%'><font color='Black' >" + StepName + "</font></td>");
			bw1.write("<td align='Left' width='35%'><font color='Black' >" + Actual + "</font></td>");
			if ((Status).toLowerCase().equals("failed")) {
				bw1.write("<td align='Center' width='10%'><b><font color='Red' >" + Status + "</font></b></td>");
			} else if (Status.toLowerCase().equals("passed")) {
				bw1.write("<td align='Center' width='10%'><b><font color='Green' >" + Status + "</font></b></td>");
			}
			bw1.write("<td align='Left' width='15%'><font color='Black' >" + Comments + "</font></td>");
		}

		bw1.write("</tr>");
		bw1.flush();
		bw1.close();

	}
	
	public void  DeleteCustomReportFile()
	{
	

	File file = new File(resultFile);
	 if (file.exists())
	 {
		 file.delete();
	 }	
	 
	//CreateCaseTest ccase = new CreateCaseTest();
	}

}

/*
 * file_exist =
 * CreateObject("Scripting.FileSystemObject").FileExists(reportPath) ' If Not
 * file_exist Then ' Set fso = CreateObject("Scripting.FileSystemObject") ' Set
 * tf = fso.CreatetextFile(reportPath, False,True) ' filenum = filenum + 1
 * ''Create a new text file for writing ' tf.writeline
 * ("<meta charset=""utf-8""> ") ' tf.writeline
 * ("<h2 align=""CENTER""><font color=""#003399"">UNICEF QA Test Report</font></h2>"
 * ) ' tf.writeline
 * ("<h3 align=""CENTER""><font color=""#003399"">Test Name :  "&Environment(
 * "TestName")&"</font></h3>") ' tf.writeline
 * ("<table border=""1"" bordercolor=""#E6E6E6"" bgcolor=""#CCCCCC"" cellpadding=""2"" cellspacing=""0"" width=""90%"" align=""Center"" borderwidth=""1px"" >"
 * ) ' tf.writeline ("<tr><font color=""#003399"">Executed on ::   " & Now &
 * " </font></tr>") ' tf.writeline "<tr>" ''Add Table Headers ' tf.WriteLine
 * "<th style=color:white;background-color:""#0099FF"";>Test ID</th>" '
 * tf.WriteLine
 * "<th style=color:white;background-color:""#0099FF"";>StepName</th>" '
 * tf.WriteLine
 * "<th style=color:white;background-color:""#0099FF"";>Actual Result</th>" '
 * tf.WriteLine
 * "<th style=color:white;background-color:""#0099FF"";>Status</th>" '
 * tf.WriteLine
 * "<th style=color:white;background-color:""#0099FF"";>Comments</th>" '
 * tf.writeline "</tr>" ' Else ' Set fso =
 * CreateObject("Scripting.FileSystemObject") ' Set tf =
 * fso.OpentextFile(reportPath, 8, 3) ' End If ' tf.writeline "<tr>" ' ' Add
 * table data ' If NestedColor ="Yellow" Then ' tf.writeline
 * "<td align=""Center"" width=""5%"" bgcolor=""Yellow""><font color=""Black"" >"
 * & Environment.Value("TestId") & "</font></td>" ' tf.writeline
 * "<td align=""Left"" width=""35%"" bgcolor=""Yellow""><font color=""Black"" >"
 * & StepName & "</font></td>" ' tf.writeline
 * "<td align=""Left"" width=""35%"" bgcolor=""Yellow""><font color=""Black"" >"
 * & Actual & "</font></td>" ' If Lcase(Status) = "failed" Then ' tf.writeline
 * "<td align=""Center""width=""10%"" bgcolor=""Yellow""><b><font color=""Red"" >"
 * & Status & "</font></b></td>" ' ElseIf Lcase(Status)="passed" Then '
 * tf.writeline
 * "<td align=""Center""width=""10%"" bgcolor=""Yellow""><b><font color=""Green"" >"
 * & Status & "</font></b></td>" ' End If ' tf.writeline
 * "<td align=""Left"" width=""15%"" bgcolor=""Yellow""><font color=""Black"" >"
 * & Comments & "</font></td>" ' Else ' tf.writeline
 * "<td align=""Center"" width=""5%""><font color=""Black"" >" &
 * Environment.Value("TestId") & "</font></td>" ' tf.writeline
 * "<td align=""Left"" width=""35%""><font color=""Black"" >" & StepName &
 * "</font></td>" ' tf.writeline
 * "<td align=""Left"" width=""35%""><font color=""Black"" >" & Actual &
 * "</font></td>" ' If Lcase(Status) = "failed" Then ' tf.writeline
 * "<td align=""Center""width=""10%""><b><font color=""Red"" >" & Status &
 * "</font></b></td>" ' ElseIf Lcase(Status)="passed" Then ' tf.writeline
 * "<td align=""Center""width=""10%""><b><font color=""Green"" >" & Status &
 * "</font></b></td>" ' End If ' tf.writeline
 * "<td align=""Left"" width=""15%""><font color=""Black"" >" & Comments &
 * "</font></td>" ' ' End If ' ' tf.writeline "</tr>" ' tf.Close 'Close the
 * document ' tf = nothing ' fso = nothing
 */