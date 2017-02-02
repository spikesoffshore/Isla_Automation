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

public class Office extends Base{

	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Office.com");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.office.com";
			driver.navigate().to(baseurl+siteURL);
			}
		

			@Test	
			public void executeScript() throws IOException {
				
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Office";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					Loggers.startCurrentTestCaseExecution(this.driver);
					
					//1	Verify Navigation to office.com
					ReportGenerator.verifyNavigation(this.driver, "Office", parentTest,testCaseName,"Yes");
					
					//2	Verify Office Favicon
					SikuliUtil.verifyObjectAndHighlight("Office_Favicon", screen, parentTest, "Verifying Office Favicon", driver, testCaseName, "Yes");
					
					//3	Verify Office Home Logo
					SikuliUtil.verifyObjectAndHighlight("Office_Home_Logo", screen, parentTest, "Verifying Office home logo", driver, testCaseName, "No");
					
					//4	Verify Navigation to Office Try
					//4-a	Click on Products Menu
					SikuliUtil.verifyObjectAndClickOn("Office_Products_Menu", screen, parentTest, "Clicking on Products Menu", driver, testCaseName, "No");
					
					Sleep(2000);
					
					//4-c	Click on products Try
					SikuliUtil.verifyObjectAndClickOn("Office_Products_Try", screen, parentTest, "Trying new products", driver, testCaseName, "No");
					
					Sleep(3000);
					
					//4-d	Verify Navigation to Office Try
					SikuliUtil.verifyObjectAndHighlight("Office_Try_Office_Free", screen, parentTest, "Verifying Navigation to Office Try", driver, testCaseName, "Yes");
					
					//5	Verify Naviagtion to Office For Individuals
					//5-a	Click on Individuals link
					SikuliUtil.verifyObjectAndClickOn("Office_Individuals", screen, parentTest, "Navigating to Office for Individuals Page", driver, testCaseName, "No");
					
					//5-b	Verify Navigation 
					ReportGenerator.verifyNavigation(this.driver, "Office", parentTest,testCaseName,"personal");
					
					//6	Verify Sign-In Functionality
					//6-a	Click on Office Home Logo
					SikuliUtil.verifyObjectAndClickOn("Office_Home_Logo", screen, parentTest, "Navigating back to Office Home Page", driver, testCaseName, "No");
					
					Sleep(4000);
					
					//6-b	Click on Sign in
					SikuliUtil.verifyObjectAndClickOn("Office_Sign_In", screen, parentTest, "Clicking on Sign-In Link", driver, testCaseName, "No");
					
					Sleep(4000);
					
					//6-c	Enter Username
					SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.ENTER);
					
					Sleep(1000);
					//6-d	Enter Password
					SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
					
					Sleep(4000);
					
					//6-e	Verify Sign IN Landing
					SikuliUtil.verifyObjectAndHighlight("Office_Office_After_Sign_In", screen, parentTest, "Verifying Login", driver, testCaseName, "Yes");
					
					//7	Creating a new word document
					//7-a	Click on Office Word
					SikuliUtil.verifyObjectAndClickOn("Office_Word_Icon", screen, parentTest, "Click on Word Icon", driver, testCaseName, "Yes");
					
					Sleep(5000);
					
					//7-b	Click on New Blank Document
					SikuliUtil.verifyObjectAndClickOn("Office_New_Blank_Document", screen, parentTest, "Creating new blank document", this.driver, testCaseName, "No");
					
					Sleep(11000);
					
					//7-c	Verifying Opening of new blank document
					SikuliUtil.verifyObjectAndHighlight("Office_Word_Online", screen, parentTest, "Verifying successfull Opening of blank document", this.driver, testCaseName, "Yes");
					
					//7-d	Type in the Document
					SikuliUtil.typeScreen(screen, "Writing in the test document for fun...");
					
					
					
					Sleep(5000);
					
					//7-e	Verify that the Document is saved
					SikuliUtil.verifyObjectAndHighlight("Office_Document_Saved", screen, parentTest, "Verifying Saved Document on One Drive", this.driver, testCaseName, "Yes");
					
					Sleep(3000);
					
					//7-f	Close the tab
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL,KeyEvent.VK_W );
					
					Sleep(2000);
					
					//8	Verify Navigation to Onedrive
					//8-a	Click on Onedrive icon
					SikuliUtil.verifyObjectAndClickOn("Office_OneDrive_Logo", screen, parentTest, "Opening One Drive", driver, testCaseName, "No");
					
					Sleep(10000);
					
					//8-b	Verify Navigation to Onedrive
					SikuliUtil.verifyObjectAndClickOn("Office_One_Drive_Home", screen, parentTest, "Verifying Navigation to One Drive", driver, testCaseName, "Yes");
					
					//8-c	Close the tab
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL,KeyEvent.VK_W );
					
					Sleep(2000);
					
					//9	Verify Signout
					//9-a	Click on profile icon
					SikuliUtil.verifyObjectAndClickOn("Office_Profile_Icon", screen, parentTest, "Clicking on Profile Icon", driver, testCaseName, "No");
					
					Sleep(2000);
					
					//9-b	Click on Signout
					SikuliUtil.verifyObjectAndClickOn("Office_Sign_Out", screen, parentTest, "Clicking on Sign Out", driver, testCaseName, "No");
					
					Sleep(8000);
					
					//9-c	Verify Office Home Logo
					SikuliUtil.verifyObjectAndHighlight("Office_Home_Logo", screen, parentTest, "Verifying Sign Out", driver, testCaseName, "Yes");
					
				}catch(Exception e){
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Office TestCase has failed,Please see logs and error screenshots", this.driver);
				}
				finally{
				quitDriver(this.driver);
					path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
				}
				
}
}
