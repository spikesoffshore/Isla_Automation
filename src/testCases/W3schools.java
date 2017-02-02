package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class W3schools extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing W3schools");
	
	public void navigateToURL(WebDriver driver){
		siteURL="www.w3schools.com";
		driver.navigate().to(baseurl+siteURL);
		driver.manage().window().maximize();
		}
	

		@Test	
		public void executeScript() throws IOException {
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/W3schools";
		
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			
			Loggers.startCurrentTestCaseExecution(this.driver);
		
			//TestCase#1-Verifying Navigation to home page
			ReportGenerator.verifyNavigation(this.driver, "W3Schools", parentTest,testCaseName,"Yes");
			//TestCase#2-Verifying Favicon
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Verify W3Schools Home page logo",driver,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("W3schools_Favicon", screen, parentTest,"Verify W3schools favicon",driver,testCaseName,"Yes");
			//TestCase#3-Verifying Html learning page								
			SikuliUtil.verifyObjectAndClickOn("HtmlLink", screen, parentTest, "Verify Html learning page", driver, testCaseName, "No");
			
			Sleep(5000);
						
			ReportGenerator.verifyNavigation(this.driver, "HTML Tutorial",parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("W3schools_Favicon", screen, parentTest,"W3schools Html learning page navigated successfully",driver,testCaseName,"Yes");
									
			Sleep(2000);
			SikuliUtil.moveWheel(screen, 1, 30);
			Sleep(5000);
			Loggers.writeInfoLog("Wheel movement Done");
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
			Sleep(4000);
			//TestCase#4-Verifying Next page navigation	
			SikuliUtil.verifyObjectAndClickOn("Next", screen, parentTest, "Verify navigating to next page", driver, testCaseName, "No");
			Sleep(4000);
			ReportGenerator.verifyNavigation(this.driver, "Introduction to HTML",parentTest,testCaseName,"No");
			SikuliUtil.verifyObjectAndHighlight("W3schools_Favicon", screen, parentTest,"W3schools next page button functionality vworking fine",driver,testCaseName,"Yes");
			//TestCase#5-Verifying HomePage	navigation
			Sleep(4000);
			SikuliUtil.verifyObjectAndClickOn("HomeLogo", screen, parentTest, "Clicking on home logo to redirect to home page", driver, testCaseName, "No");
			Sleep(4000);
			ReportGenerator.verifyNavigation(this.driver, "W3Schools", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Verify W3Schools Home page logo",driver,testCaseName,"No");
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("W3schools_Favicon", screen, parentTest,"W3schools Home page navigated successfully",driver,testCaseName,"Yes");
			//TestCase#6-Verifying SQL learning page	
			Sleep(3000);
			SikuliUtil.verifyObjectAndClickOn("Tutorials", screen, parentTest, "Clicking on Tutorials menu on W3Schools", driver, testCaseName, "No");
			Sleep(3000);
			SikuliUtil.verifyObjectAndClickOn("SqlLink", screen, parentTest, "Verify SQL learning page", driver, testCaseName, "No");
			
			Sleep(5000);
			ReportGenerator.verifyNavigation(this.driver, "SQL Tutorial",parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("W3schools_Favicon", screen, parentTest,"W3schools SQL learning page navigated successfully",driver,testCaseName,"Yes");
									
			Sleep(2000);
			SikuliUtil.moveWheel(screen, 1, 30);
			Sleep(5000);
			Loggers.writeInfoLog("Wheel movement Done");
			
			
			//TestCase#7-Verifying Alt+Left Key press functionality
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			Loggers.writeInfoLog("Navigated back to home page");
			Sleep(5000);
			
			ReportGenerator.verifyNavigation(this.driver, "W3Schools", parentTest,testCaseName,"No");
			SikuliUtil.verifyObjectAndHighlight("W3schools_Favicon", screen, parentTest,"Verify navigating back to home page by pressing Alt+Left button",driver,testCaseName,"Yes");
			
						
			//TestCase#8-Verifying Search functionality
			SikuliUtil.verifyObjectAndType("Search", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "JavaScript");
			Sleep(3000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("Close", screen, parentTest,"Resultset related to searched Text loaded successfully",driver,testCaseName,"Yes");
			
			Sleep(4000);
			
			screen.wheel(1, 15);			
			Sleep(4000);
			SikuliUtil.verifyObjectAndClickOn("Close", screen, parentTest,"Searched popup closed",driver,testCaseName,"No");
			
			Sleep(4000);
			
			SikuliUtil.verifyObjectAndHighlight("W3schools_Favicon", screen, parentTest,"Verify W3schools favicon",this.driver,testCaseName,"No");
			Sleep(4000);
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The W3schools TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
			
		}catch(Exception e){
		Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The W3schools TestCase Failed,Please see logs and error screenshots", driver);
		}
		finally{
		path=currentSitePath;
		quitDriver(this.driver);
		ReportGenerator.flushReportToDisk(parentTest);
		}
	
	
	
		}
		
	
}
