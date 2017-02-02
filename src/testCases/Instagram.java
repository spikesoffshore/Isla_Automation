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

public class Instagram extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Instagram");
	
	public void navigateToURL(WebDriver driver){
		siteURL="https://www.instagram.com";
		driver.navigate().to(baseurl+siteURL);
		}
	

		@Test	
		public void executeScript() throws IOException {
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Instagram";
		
		navigateToURL(this.driver);
		
		Sleep(25000);
		
					
		try{
			
			Loggers.startCurrentTestCaseExecution(this.driver);
			//TestCase#1-Verifying Navigation to home page
			ReportGenerator.verifyNavigation(this.driver, "Instagram", parentTest,testCaseName,"Yes");
			//TestCase#2-Verifying Favicon 
			
			SikuliUtil.verifyObjectAndHighlight("Insta_favicon", screen, parentTest,"Verify Instagram favicon",this.driver,testCaseName,"Yes");
			//TestCase#3-Verifying Login functionality	
						
			SikuliUtil.verifyObjectAndClickOn("Log_in", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
						
			ReportGenerator.verifyNavigation(this.driver, "Instagram",parentTest,testCaseName,"No");
								
			SikuliUtil.verifyObjectAndHighlight("Insta_favicon", screen, parentTest,"Verify Instagram favicon",this.driver,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndType("UserName", screen, parentTest, "Instagram username field", driver, testCaseName, "No","spikesqa"+Key.TAB );
			
			SikuliUtil.typeScreen(screen,"QAqa54321!"+Key.ENTER );
					
			Sleep(10000);
			
			SikuliUtil.verifyObjectAndHighlight("Insta_favicon", screen, parentTest,"Verify Instagram favicon",this.driver,testCaseName,"No");;
			
			SikuliUtil.keyPress(robot,KeyEvent.VK_ESCAPE);		
			
			Sleep(5000);
			//TestCase#4-Verifying Search functionality
			
			SikuliUtil.verifyObjectAndType("Search", screen, parentTest, "spikesqa login", driver, testCaseName, "Yes", "Shah Rukh Khan");
			
			
			Sleep(5000);	
			SikuliUtil.typeScreen(screen, Key.ENTER);
			Sleep(10000);
			
			ReportGenerator.verifyNavigation(this.driver, "Shah Rukh Khan", parentTest,testCaseName,"No");
				
				
			SikuliUtil.verifyObjectAndHighlight("Insta_favicon", screen, parentTest,"Verify Instagram favicon",this.driver,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("SearchResult", screen, parentTest, "Page load to searched text", driver, testCaseName, "Yes");
			//TestCase#5-Verifying Follow Functionality
			
			SikuliUtil.verifyObjectAndClickOn("Unfollowing", screen, parentTest, "Click Follow", driver, testCaseName, "No");
			
			Sleep(8000);
			
			SikuliUtil.verifyObjectAndClickOn("Following", screen, parentTest, "Follow functionality in Instagram", driver, testCaseName, "Yes");
			//TestCase#6-Verifying UnFollow Functionality
			Sleep(8000);
			SikuliUtil.verifyObjectAndHighlight("Unfollowing", screen, parentTest, "Unfollow functionality in Instagram", driver, testCaseName, "Yes");
			
			
			SikuliUtil.moveWheel(screen, 1, 15);			
			Sleep(10000);
			
			
			//TestCase#7-Verifying Isla Upload message validation
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			
			
			Sleep(8000);
			
			ReportGenerator.verifyNavigation(this.driver, "Instagram",parentTest, testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("Search", screen, parentTest, "Home page navigation", driver, testCaseName, "No");
			
			SikuliUtil.verifyObjectAndClickOn("UploadProfilePic", screen, parentTest, "Uploading profile pic", driver, testCaseName, "No");
			
			
			
			Sleep(5000);
			
			SikuliUtil.verifyObjectAndClickOn("BrowseFile", screen, parentTest, "Isla upload message appearance", driver, testCaseName, "Yes");
			
			Sleep(5000);
			//TestCase#8-Verifying Profile Pic upload Functionality
			SikuliUtil.typeScreen(screen,path+"\\ProfilePic.jpg"+Key.ENTER);
			
			Loggers.writeInfoLog("Profile pic selection is done successfully....continuing test");
			
			Sleep(10000);
			
			SikuliUtil.verifyObjectAndHighlight("ProfilePhotoAdded", screen, parentTest,  "Profile Pic upload", driver, testCaseName, "Yes");
			
			
			Loggers.writeInfoLog("Profile pic upload is done successfully....continuing test");
						
			Sleep(5000);
			
			SikuliUtil.verifyObjectAndClickOn("ProfileIcon", screen, parentTest, "User profile icon", driver, testCaseName, "No");
			
			
			Sleep(8000);
			
			SikuliUtil.verifyObjectAndClickOn("ProfilePicIcon", screen, parentTest, "User selected pic", driver, testCaseName, "No");
			
			Sleep(8000);
			//TestCase#9-Verifying Profile Pic Remove Functionality
			
			SikuliUtil.verifyObjectAndClickOn("RemovePhoto", screen, parentTest,  "Remove uploaded profile pic link", driver, testCaseName, "No");
			
			Sleep(8000);
			
			SikuliUtil.verifyObjectAndHighlight("NoPic", screen, parentTest, "Removal of uploaded profile pic", driver, testCaseName, "Yes");
			
			Sleep(5000);
			//TestCase#10-Verifying Signout Functionality	
			SikuliUtil.verifyObjectAndClickOn("LogoutIcon", screen, parentTest,  "Profile more options link", driver, testCaseName, "No");		
			
			Sleep(8000);
			
			SikuliUtil.verifyObjectAndClickOn("LogoutText", screen, parentTest, "Logout option link", driver, testCaseName, "No");
			
			Sleep(8000);
			
			SikuliUtil.verifyObjectAndHighlight("Log_in", screen, parentTest, testCaseName+"User logout functionality", driver, testCaseName, "Yes");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
			
		}catch(Exception e){
		Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The Instagram TestCase Failed,Please see logs and error screenshots", driver);
		}
		finally{
		path=currentSitePath;
		quitDriver(this.driver);
		ReportGenerator.flushReportToDisk(parentTest);
		}
	
	
	
		}
		
	
}
