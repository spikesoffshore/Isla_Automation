package testCases;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Uptodown extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Uptodown");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.uptodown.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Uptodown";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "Uptodown", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Uptodown_Favicon", screen, parentTest,"Verify Uptodown favicon",driver,testCaseName,"Yes");
			
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Uptodown Home Logo",driver,testCaseName,"No");
				
				//TestCase#3-Verifying Mac tab on Uptodown page
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Mac", screen, parentTest, "Verify Mac tab link on Uptodown", driver, testCaseName, "No");
				
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "App Downloads for Mac", parentTest,testCaseName,"No");
			
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Uptodown_Favicon", screen, parentTest,"Mac tab on Uptodown page loaded",driver,testCaseName,"Yes");
				Sleep(2000);
				//TestCase#4-Verifying Itunes sub tab on Mac tab page
				SikuliUtil.verifyObjectAndClickOn("Itunes", screen, parentTest, "Verify Itunes sub tab link on Mac page", driver, testCaseName, "No");
				
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Download itunes", parentTest,testCaseName,"No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("AppleItunes", screen, parentTest, "Itunes Sub tab link page loaded on Uptodown", driver, testCaseName, "Yes");
				
				Sleep(4000);
				
				//TestCase#5-Verifying Itunes sub tab on Mac tab page
				ReportGenerator.verifyNavigation(this.driver, "Download", parentTest,testCaseName,"No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Uptodown_Favicon", screen, parentTest,"Itunes software download page loaded on Uptodown",driver,testCaseName,"Yes");
				Sleep(2000);
				//TestCase#6-Scan and Download Isla message on  Itunes Software page
				SikuliUtil.verifyObjectAndClickOn("Download", screen, parentTest, "Download link of itunes software clicked on Uptodown", driver, testCaseName, "No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("IslaDownloadScan", screen, parentTest,"ISLA scan and downloaded message appears",driver,testCaseName,"Yes");
				Sleep(4000);
				//TestCase#7-Downloading Itunes Software
				ReportGenerator.verifyNavigation(this.driver, "download itunes free", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("ItunesDownloading", screen, parentTest,"Itunes software downloading started",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#8-Verifying search functionality	
				SikuliUtil.verifyObjectAndType("Search", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "Chrome");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Download chrome", parentTest,testCaseName,"No");
				
				
				SikuliUtil.verifyObjectAndHighlight("GoogleChrome", screen, parentTest,"Resultset related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				
				screen.wheel(1, 15);			
				Sleep(4000);
				//TestCase#9-Home page redirection
				SikuliUtil.verifyObjectAndClickOn("HomeLogo", screen, parentTest, "Home page logo clicked", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Uptodown", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Uptodown_Favicon", screen, parentTest,"Home page redirected successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Uptodown TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Uptodown TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		