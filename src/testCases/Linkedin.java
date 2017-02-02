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

public class Linkedin extends Base {
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing LinkedIn");
	
	public void navigateToURL(WebDriver driver){
		siteURL="https://www.linkedin.com";
		driver.navigate().to(baseurl+siteURL);
		}
	

		@Test	
		public void executeScript() throws IOException {
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Linkedin";
		
		navigateToURL(this.driver);
		
		Sleep(25000);
						
		try{
			
			Loggers.startCurrentTestCaseExecution(this.driver);
			
			//TestCase#1-Verifying Navigation to home page
			
			ReportGenerator.verifyNavigation(this.driver, "LinkedIn", parentTest,testCaseName,"Yes");
	
			//TestCase#2-Verifying Favicon 
			SikuliUtil.verifyObjectAndHighlight("Linkedin_Favicon", screen, parentTest,"Verify LinkedIn favicon",this.driver,testCaseName,"Yes");
			
			Sleep(3000);
			
			//TestCase#3-Verifying Login functionality	
		
			SikuliUtil.verifyObjectAndType("UserId", screen, parentTest, "Linked username field", driver, testCaseName, "No","spikesqa@gmail.com"+Key.TAB );
						
			Sleep(3000);			
			screen.type("QAqa4321!"+Key.ENTER);		
			Sleep(7000);
			
			SikuliUtil.verifyObjectAndHighlight("Linkedin_Favicon", screen, parentTest,"Verify LinkedIn favicon",this.driver,testCaseName,"No");
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("SpikesqaLogin", screen, parentTest,"spikesqa login",this.driver,testCaseName,"Yes");
			Sleep(3000);
			//TestCase#4-Verifying Search functionality	
			
			SikuliUtil.verifyObjectAndType("SearchTextBox", screen, parentTest, "Verify Search textbox", driver, testCaseName, "No", "Shah Rukh Khan");
			
			Sleep(3000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			
		
			Sleep(5000);	
			
			ReportGenerator.verifyNavigation(this.driver,"Search",parentTest,testCaseName,"No");
							
		 	SikuliUtil.verifyObjectAndHighlight("Linkedin_Favicon", screen, parentTest,"Verify LinkedIn favicon",this.driver,testCaseName,"No");
			
			
			SikuliUtil.verifyObjectAndHighlight("SearchResult", screen, parentTest,"Search Functionality working fine",driver,testCaseName,"Yes");
			
			Sleep(3000);
			
			SikuliUtil.moveWheel(screen, 1, 15);
			
			Loggers.writeInfoLog("Wheel movement Done");
			
			Sleep(6000);
			
			//TestCase#5-Verifying Home page navigation	
			
			SikuliUtil.verifyObjectAndClickOn("HomeRedirectIcon", screen, parentTest, "Home page navigation", driver, testCaseName, "No");
						
			Sleep(8000);
			
			ReportGenerator.verifyNavigation(this.driver, "LinkedIn", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest,"Profile Icon Highlighted",driver,testCaseName,"Yes");
			
			Sleep(3000);		
			
			SikuliUtil.verifyObjectAndHighlight("SpikesqaLogin", screen, parentTest,"spikesqa Profile",this.driver,testCaseName,"No");
			
			
			//TestCase#6-Verifying Isla Upload message validation
			SikuliUtil.verifyObjectAndClickOn("UploadProfilePic", screen, parentTest, "Uploading profile pic", driver, testCaseName, "No");
			
			Sleep(3000);
			
			SikuliUtil.verifyObjectAndClickOn("AddProfilePicFile", screen, parentTest, "Choose profile pic", driver, testCaseName, "No");
									
			Sleep(8000);
			
						
			SikuliUtil.verifyObjectAndClickOn("BrowseFile", screen, parentTest, "Isla upload message appearance", driver, testCaseName, "Yes");
			
			Sleep(5000);
			//TestCase#7-Verifying Profile Pic upload Functionality
			SikuliUtil.typeScreen(screen,path+"\\ProfilePic.jpg"+Key.ENTER);
			
			Loggers.writeInfoLog("Profile pic selection is done successfully....continuing test");
			
			Sleep(10000);
			
			SikuliUtil.verifyObjectAndClickOn("ApplyProfilePic", screen, parentTest, "Apply selected Profile Pic", driver, testCaseName, "No");
			
			SikuliUtil.verifyObjectAndClickOn("SavePic", screen, parentTest, "Saving Profile Pic selected", driver, testCaseName, "No");
			
					
			Sleep(10000);			
			
			SikuliUtil.verifyObjectAndHighlight("ProfilePhotoAdded", screen, parentTest,"Profile Pic uploaded",driver,testCaseName,"Yes");
			
			Loggers.writeInfoLog("Profile pic upload is done successfully....continuing test");
			
			Sleep(4000);
			
			//TestCase#8-Verifying Profile Pic Remove Functionality
			
			SikuliUtil.verifyObjectAndClickOn("ProfilePhotoAdded", screen, parentTest, "Remove Profile Pic Link", driver, testCaseName, "No");
			
			Sleep(8000);
			
			SikuliUtil.verifyObjectAndClickOn("DeletePic", screen, parentTest, "Delete Link", driver, testCaseName, "No");
			
			Sleep(4000);
							
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
		
						
			Sleep(8000);
			SikuliUtil.verifyObjectAndClickOn("SavePic", screen, parentTest, " Deleting Profile Pic added", driver, testCaseName, "No");
			
			Sleep(5000);
			SikuliUtil.verifyObjectAndClickOn("ProfileIcon", screen, parentTest, " Deleting Profile Pic added", driver, testCaseName, "Yes");
						
			Sleep(5000);			
			
			//TestCase#9-Verifying Signout Functionality	
			
			SikuliUtil.verifyObjectAndClickOn("SignOut", screen, parentTest, "Signout Functionality", driver, testCaseName, "No");
			
			Sleep(8000);
			
			SikuliUtil.verifyObjectAndHighlight("Linkedin_Favicon", screen, parentTest,"Verify LinkedIn favicon",this.driver,testCaseName,"No");
			
			
			SikuliUtil.verifyObjectAndHighlight("UserId", screen, parentTest,"User logout functionality",this.driver,testCaseName,"Yes");
			Sleep(5000);
			
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The LinkedIn TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
			
		}catch(Exception e){
			Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Linkedin TestCase Failed,Please see logs and error screenshots", driver);
		}
		finally{
		path=currentSitePath;
		quitDriver(this.driver);
		ReportGenerator.flushReportToDisk(parentTest);
		}
}}
