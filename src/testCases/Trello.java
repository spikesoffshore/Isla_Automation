package testCases;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Trello extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Trello");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.trello.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Trello";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "Trello", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Trello Home Logo",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Trello_Favicon", screen, parentTest,"Verify Trello favicon",driver,testCaseName,"Yes");
			
			
				
				//TestCase#3-Verifying Login functionality	
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				Sleep(5000);
				
				
				screen.type("spikesqa@gmail.com");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(8000);
				
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				
				//TestCase#4-Verifying search functionality	
				Sleep(4000);
				SikuliUtil.verifyObjectAndType("Search", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "@spikesqa");
				
				
				Sleep(7000);
				
				
				SikuliUtil.verifyObjectAndHighlight("SearchResult", screen, parentTest,"Resultset related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				
				//TestCase#5-Test Board page 
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Test", screen, parentTest, "Test Board clicked", driver, testCaseName, "No");
				
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "test | Trello", parentTest,testCaseName,"No");
				Sleep(2000);
				//SikuliUtil.verifyObjectAndHighlight("Trello_Favicon", screen, parentTest,"Test Board page loaded successfully",driver,testCaseName,"Yes");
				
				//TestCase#6-Adding list to Test Board page 
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("AddList", screen, parentTest, "Add List clicked", driver, testCaseName, "No");
				
				Sleep(5000);
				screen.type("spikes"+Key.ENTER);
				
				Sleep(5000);
				
				SikuliUtil.verifyObjectAndHighlight("ListAdded", screen, parentTest,"List Added successfully",driver,testCaseName,"Yes");
				//TestCase#7-Archive Added list to Test Board page 
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("ArchiveIcon", screen, parentTest, "Archive Icon clicked", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Archive", screen, parentTest, "Archive List Link clicked", driver, testCaseName, "No");
				
				
				Sleep(5000);
				
				SikuliUtil.verifyObjectAndHighlight("AddList1", screen, parentTest,"List Archived successfully",driver,testCaseName,"Yes");
			
				//TestCase#8-Verifying Signout Functionality
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest,"Clciking Profile icon",driver,testCaseName,"No");
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Clicking Logout Link", driver, testCaseName, "No");
				
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Logged out of Trello", parentTest,testCaseName,"No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("Trello_Favicon", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Trello TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Trello TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		