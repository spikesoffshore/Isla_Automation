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

public class Savefrom extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Savefrom");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="http://en.savefrom.net/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Ginnie");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Savefrom";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(8000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecution(this.driver);
			
			//Home page verification based on the title
			ReportGenerator.verifyNavigation(this.driver, "Free Online YouTube Downloader", parentTest,testCaseName,"Yes");
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("Savefrom_favicon", screen, parentTest,"Verify Savefrom favicon",this.driver,testCaseName,"Yes");
			
			//home page verification
			SikuliUtil.verifyObjectAndHighlight("savefrom_home_logo", screen, parentTest, "Verify home page site logo", this.driver, testCaseName, "No");
			
			//Link insert
			SikuliUtil.verifyObjectAndType("Savefrom_typeLink", screen, parentTest, "Enter Gerua link", this.driver, testCaseName, "No", "https://www.youtube.com/watch?v=AEIVhBS6baE"+Key.ENTER);
			Sleep(2000);
			//Verify Gerua link downloader message
			SikuliUtil.verifyObjectAndHighlight("Gerua_error", screen, parentTest, "Verify Gerua error", this.driver, testCaseName, "Yes");
			
			//Clear inserted link
			SikuliUtil.verifyObjectAndClickOn("clearLink", screen, parentTest, "Click to clear inserted link", driver, testCaseName, "No");
			Sleep(200);
			//Not supporting error message verification
			SikuliUtil.verifyObjectAndHighlight("Savefrom_typeLink", screen, parentTest, "Enter new link", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndType("Savefrom_typeLink", screen, parentTest, "Enter corrupted link", this.driver, testCaseName, "No", "http://SikuliUtil.verifyObjectAndType"+Key.ENTER);
			Sleep(2000);
			//Verify error message 
			SikuliUtil.verifyObjectAndHighlight("Savefrom_notSupportedErrorMessage", screen, parentTest, "Verify not supported error message", this.driver, testCaseName, "Yes");
						
			//Link not found
			if(flag==1) SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_A);			
				else SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);				
			SikuliUtil.keyPress(robot, KeyEvent.VK_DELETE);
			Sleep(200);
			SikuliUtil.verifyObjectAndType("Savefrom_typeLink", screen, parentTest, "Enter Gerua link", this.driver, testCaseName, "No", "http://www.dailymotion.com/video"+Key.ENTER);
			Sleep(2000);
			
			//Verify link not found error message 
			SikuliUtil.verifyObjectAndHighlight("downloadLinkNotFound", screen, parentTest, "Verify download link not found error message", this.driver, testCaseName, "Yes");
			
			//Download verification
			SikuliUtil.verifyObjectAndClickOn("clearLink", screen, parentTest, "Click to clear inserted link", this.driver, testCaseName, "No");
			Sleep(200);
			SikuliUtil.verifyObjectAndHighlight("Savefrom_typeLink", screen, parentTest, "Enter new link", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndType("Savefrom_typeLink", screen, parentTest, "Enter corrupted link", this.driver, testCaseName, "No", "http://www.dailymotion.com/video/x11hp64_2112-birth-of-doraemon-in-hindi-toonsinhindi-blogspot-in-part-1-2_videogames"+Key.ENTER);
			Sleep(2000);
			//Verify download and click
			SikuliUtil.verifyObjectAndHighlight("toBeDownloadedVideoTitle", screen, parentTest, "Verify to be downloaded video title", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("videoSnapshot", screen, parentTest, "Verify to be downloaded video snapshot", this.driver, testCaseName, "Yes");
						
			//Click download button
			SikuliUtil.verifyObjectAndClickOn("videoDownloadButton", screen, parentTest, "Click video download", this.driver, testCaseName, "No");
			Sleep(2000);
			
			//Isla download message
			SikuliUtil.verifyObjectAndHighlight("IslaDownloadMessage", screen, parentTest, "Verify Isla download message", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The Savefrom TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Savefrom TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}



}
