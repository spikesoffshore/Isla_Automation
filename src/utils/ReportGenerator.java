package utils;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

//import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGenerator extends testCases.Base{

public static ReportGenerator getReportObject(){
		
		return new ReportGenerator();
	}

	//Function to initialize the Parent test for the Current Test Class
	public static ExtentTest initializeParentTest(String testName,String description){
		
		
		return report.startTest(testName, description);
	}
	//Function to assign author to the Parent Test
	public static void assignAuthor(ExtentTest parentTest,String authorName){
		
		parentTest.assignAuthor(authorName);
	}
		
	//Function to Log an Info message*** Takes a parent test as a parameter, the test case name as a string and the Log message 
		public static void logStatusInfo(ExtentTest parent,String testCaseName,String message){
			
			//ExtentTest childTest = parent.createNode(testCaseName);
			ExtentTest childTest = report.startTest(testCaseName);
			
			childTest.log(LogStatus.INFO, message);
			parent.appendChild(childTest);		
		}
		
	//Function to log a Pass message*** Takes a parent test as a parameter, the test case name as a string and the Log message
	public static void logStatusPass(ExtentTest parent,String testCaseName,String message){
			
		//ExtentTest childTest = parent.createNode(testCaseName);
		
		ExtentTest childTest = report.startTest(testCaseName);
		parent.appendChild(childTest);
		childTest.log(LogStatus.PASS, message);
		
		
		}
	//Function to log a failure message and capture a screenshot*** Takes a parent test as a parameter, the test case name as a string,the Log message and the WebDriver instance 
	//Also takes a screenshot and places it in the Execution Reports Folder and also attaches the screenshot to the test step
	public static  void logStatusFail(ExtentTest parent,String testCaseName,String message,WebDriver driver){
		
		//ExtentTest childTest = parent.createNode(testCaseName);
		ExtentTest childTest = report.startTest(testCaseName);
		parent.appendChild(childTest);		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		File destFile = new File(System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/"+testCaseName+"_errorScreenshots"+"/"+message+"_error.jpg");
		try {
			FileUtils.copyFile(scrFile,destFile );
		} catch (IOException e) {
			System.out.println("Not able to take an error screenshot for:"+driver.getTitle());
		}
		
		
		try {
			childTest.log(LogStatus.FAIL, message+childTest.addScreenCapture(destFile.getPath()));
		}
		finally{
			Loggers.writeErrorLog("Screenshot added for the failure of the Test Step");
		}
		
}
	//Not really sure how to use below methods
	/*public void logStatusFatal(String testCaseName,String message){
		
		reportStartTest(testCaseName).log(LogStatus.FATAL,message);
	}*/
	//Function to log an error message and capture a screenshot*** Takes a parent test as a parameter, the test case name as a string,the Log message and the WebDriver instance 
	//Also takes a screenshot and places it in the Execution Reports Folder and also attaches the screenshot to the test step
	public static void logStatusError(ExtentTest parent,String testCaseName,String message,WebDriver driver){
		
		// parent.createNode(testCaseName);
		ExtentTest childTest = report.startTest(testCaseName);
		parent.appendChild(childTest);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		File destFile = new File(System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/"+testCaseName+"_errorScreenshots"+"/"+message+"_error.jpg");
		try {
			FileUtils.copyFile(scrFile,destFile );
		} catch (IOException e) {
		
			System.out.println("Not able to take an error screenshot for:"+driver.getTitle());
		}
		
		
		try {
			childTest.log(LogStatus.ERROR, message+childTest.addScreenCapture(destFile.getPath()));

		}
		finally{
			Loggers.writeErrorLog("Screenshot added for the failure of the Test Step");
		}
		}
	
	/*//Function to Add the Description for a TestCase
	public static void addTestDescription(ExtentTest parentTest,String description){
		
		parentTest.pass(description);
		
	}*/
	//Function to add Favicon to TestCase
	/*public static void addFaviconToTestCase(ExtentTest parentTest,String faviconPath){
		try {
			parentTest.addScreenCaptureFromPath(faviconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	
	//Function to flush all the report logs to the Disk in the ExecutionReport folder**Takes the parent test as an argument 
	public static void flushReportToDisk(ExtentTest parentTest){
		
			/*parentTest.getModel().
			report.flush();*/
		report.endTest(parentTest);
		report.flush();
		
		
		
	}
/*//Function to return ReportGenerator Object	***Not using it anywhere though till now
public static ReportGenerator getReportObject(){
	
	return new ReportGenerator();
}

//Function to initialize the Parent test for the Current Test Class
public static ExtentTest initializeParentTest(String testName,String description){
	
	
	return report.createTest(testName,description);
}
//Function to assign author to the Parent Test
public static void assignAuthor(ExtentTest parentTest,String authorName){
	
	parentTest.assignAuthor(authorName);
}
	
//Function to Log an Info message*** Takes a parent test as a parameter, the test case name as a string and the Log message 
	public static void logStatusInfo(ExtentTest parent,String testCaseName,String message){
		
		ExtentTest childTest = parent.createNode(testCaseName);
		childTest.log(Status.INFO, message);

		
	}
	
//Function to log a Pass message*** Takes a parent test as a parameter, the test case name as a string and the Log message
public static void logStatusPass(ExtentTest parent,String testCaseName,String message){
		
	ExtentTest childTest = parent.createNode(testCaseName);
	childTest.log(Status.PASS, message);
	}
//Function to log a failure message and capture a screenshot*** Takes a parent test as a parameter, the test case name as a string,the Log message and the WebDriver instance 
//Also takes a screenshot and places it in the Execution Reports Folder and also attaches the screenshot to the test step
public static  void logStatusFail(ExtentTest parent,String testCaseName,String message,WebDriver driver){
	
	ExtentTest childTest = parent.createNode(testCaseName);
	childTest.log(Status.FAIL, message);
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
	File destFile = new File(System.getProperty("user.dir")+"\\ExecutionReports\\"+message+"_error.jpg");
	try {
		FileUtils.copyFile(scrFile,destFile );
	} catch (IOException e) {
		System.out.println("Not able to take an error screenshot for:"+driver.getTitle());
	}
	finally {
		System.out.println(destFile.getPath());
	try {
		childTest.addScreenCaptureFromPath(destFile.getPath());
	} catch (IOException e) {
		e.printStackTrace();
	}
			};
}
//Not really sure how to use below methods
public void logStatusFatal(String testCaseName,String message){
	
	reportStartTest(testCaseName).log(LogStatus.FATAL,message);
}
//Function to log an error message and capture a screenshot*** Takes a parent test as a parameter, the test case name as a string,the Log message and the WebDriver instance 
//Also takes a screenshot and places it in the Execution Reports Folder and also attaches the screenshot to the test step
public static void logStatusError(ExtentTest parent,String testCaseName,String message,WebDriver driver){
	
	ExtentTest childTest = parent.createNode(testCaseName);
	childTest.log(Status.ERROR, message);
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
	File destFile = new File(System.getProperty("user.dir")+"\\ExecutionReports\\"+message+"_error.jpg");
	try {
		FileUtils.copyFile(scrFile, destFile);
	} catch (IOException e) {
		
		System.out.println("Not able to take an error screenshot for:"+driver.getTitle());
	} 
	finally{
		System.out.println(destFile.getPath());
		try {
			childTest.addScreenCaptureFromPath(destFile.getAbsolutePath());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
//Function to Add the Description for a TestCase
public static void addTestDescription(ExtentTest parentTest,String description){
	
	parentTest.pass(description);
	
}
//Function to add Favicon to TestCase
public static void addFaviconToTestCase(ExtentTest parentTest,String faviconPath){
	try {
		parentTest.addScreenCaptureFromPath(faviconPath);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
//Function to flush all the report logs to the Disk in the ExecutionReport folder**Takes the parent test as an argument 
public static void flushReportToDisk(){
	
		report.flush();
	
}*/
	
//Function to verify Navigation and report the result in both Logs and Test execution file
	public static void verifyNavigation(WebDriver driver,String titleContent,ExtentTest parentTest,String testCaseName, String reportFlag) throws InterruptedException{
		if((driver.getTitle().contains(titleContent)))
		   {
			if(reportFlag.equals("Yes"))
			{
		    ReportGenerator.logStatusPass(parentTest,"Verify Navigation to "+titleContent, "Navigated successfully to "+titleContent);
		    Loggers.writeInfoLog(titleContent+" navigation is done successfully....continuing test");
			}
			else{ Loggers.writeInfoLog(titleContent+" navigation is done successfully....continuing test");}
		   }
		   else{File makeErrorFolder= new File((System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/"+testCaseName+"_errorScreenshots"));
			makeErrorFolder.mkdir();
			 
			  ReportGenerator.logStatusFail(parentTest, testCaseName, "Navigation failed to the "+titleContent, driver);
		   	   Loggers.writeErrorLog(titleContent+" navigation is failed....stoping test");
		   	   throw new InterruptedException(); 
		    
			  }
	}
	
	//Function to verify Pattern displayed on screen and report result in both Logs and Execution Report
	public static void verifyPattern(Screen screen,Pattern pattern,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag) throws InterruptedException{
		
		 if(screen.exists(pattern) != null){
			    if(reportFlag.equals("Yes")){
			 ReportGenerator.logStatusPass(parentTest,testStep,testStep+" is done successfully");
			    Loggers.writeInfoLog(testStep+" is done successfully....continuing test");}
			   else{Loggers.writeInfoLog(testStep+" is done successfully....continuing test");}
		 }
		 else{File makeErrorFolder= new File((System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/"+testCaseName+"_errorScreenshots"));
			makeErrorFolder.mkdir();
			
			    ReportGenerator.logStatusFail(parentTest, testCaseName, testStep+" is failed",driver);
			    Loggers.writeErrorLog(testStep+" failed....stopping test");
			   throw new InterruptedException();   }
			 
			   }		
	}
	
	//Function to verify Screen pattern and report the result in Logs only
	/*public static void verifyPatternandLog(Screen screen,Pattern pattern,String testStep,String testCaseName) throws InterruptedException{
		//verifyNetworkavailability();
	if(screen.exists(pattern) != null){
		Loggers.writeInfoLog(testStep+" verification is done successfully....continuing test");
	}
	else{
		 
		Loggers.writeErrorLog(testCaseName+" not found....stopping test");
		throw new InterruptedException();				
	}
	}
	*/
	//Function to verify navigation and report the result in Logs only
		/*public static void verifyNavigationandLog(WebDriver driver,String titleContent,String testStep,String testCaseName) throws InterruptedException{
			if((driver.getTitle().contains(titleContent))){
			Loggers.writeInfoLog(testStep+" verification is done successfully....continuing test");
		}
		else{
			 
			Loggers.writeErrorLog(testCaseName+" not found....stopping test");
			throw new InterruptedException();				
		}
		}
		*/
	//public static boolean verifyNetworkavailability(){}
	

