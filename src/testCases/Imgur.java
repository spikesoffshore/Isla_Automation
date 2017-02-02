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

public class Imgur extends Base {
	private WebDriver driver;
	private String currentSitePath;
	
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Imgur");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.imgur.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Imgur";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page			
				ReportGenerator.verifyNavigation(this.driver, "Imgur", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Imgur Home Logo",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Imgur_Favicon", screen, parentTest,"Verify Imgur favicon",driver,testCaseName,"Yes");
				Sleep(2000);
			
				//TestCase#3-Verifying Most Viral image page
				SikuliUtil.clickBelow("MostViral", screen, parentTest, "Clicking Most Viral image", driver, testCaseName, "No", 250);
				
				
				Sleep(7000);
				Loggers.writeInfoLog("Most Viral image loaded");
				SikuliUtil.verifyObjectAndHighlight("Imgur_Favicon", screen, parentTest,"Most Viral image loaded",driver,testCaseName,"Yes");
				
				//TestCase#4-Verifying Next Most Viral image page
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("NextPost", screen, parentTest, "Next Viral Post page link clicked", driver, testCaseName, "No");
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndHighlight("Imgur_Favicon", screen, parentTest,"Next Viral Post page loaded",driver,testCaseName,"Yes");
				Sleep(3000);		
							
				//TestCase#5-Verifying Login functionality	
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				
				Sleep(6000);
			
				screen.type("spikesqa");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("Imgur_Favicon", screen, parentTest,"Verify Imgur favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				//TestCase#6-Verifying Spikes QA account image page
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest, "Hovering profile icon", driver, testCaseName, "No");
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("ImageLink", screen, parentTest, "Clicking Account image link", driver, testCaseName, "No");
				Sleep(4000);
								
				ReportGenerator.verifyNavigation(this.driver, "spikesqa's uploaded images", parentTest,testCaseName,"No");
			
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Imgur_Favicon", screen, parentTest,"Spikes QA account image page loaded",driver,testCaseName,"Yes");
				Sleep(2000);
				//TestCase#7-Verifying Adding image on logged in user
				SikuliUtil.verifyObjectAndClickOn("AddImage", screen, parentTest, "Clicking Add image link", driver, testCaseName, "No");
				Sleep(4000);
								
				SikuliUtil.verifyObjectAndClickOn("AddPicFile", screen, parentTest, "Choose profile pic", driver, testCaseName, "No");
										
				Sleep(4000);				
							
				SikuliUtil.verifyObjectAndClickOn("BrowseFile", screen, parentTest, "Isla upload message appearance", driver, testCaseName, "No");
				
				Sleep(5000);
				
				SikuliUtil.typeScreen(screen,path+"\\ProfilePic.jpg"+Key.ENTER);
				
				Loggers.writeInfoLog("Profile pic selection is done successfully....continuing test");
				
				Sleep(10000);
				SikuliUtil.verifyObjectAndHighlight("PhotoAdded", screen, parentTest,"Image uploaded to the account",driver,testCaseName,"Yes");
				Sleep(2000);
				//TestCase#8-Verifying Deleting image on logged in user
				
				SikuliUtil.verifyObjectAndClickOn("DeletePic", screen, parentTest, "Delete icon clicked", driver, testCaseName, "No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("DeletePicButton", screen, parentTest, "Delete icon clicked", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("PhotoRemoved", screen, parentTest,"Image removed from Spikesqa account",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#9-Verifying Search functionality	
				
				SikuliUtil.verifyObjectAndType("SearchTextBox", screen, parentTest, "Verify Search textbox", driver, testCaseName, "No", "Shah Rukh Khan");
				
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				
			
				Sleep(5000);	
				
								
				SikuliUtil.verifyObjectAndHighlight("Imgur_Favicon", screen, parentTest,"Imgur favicon highlighted",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("SearchResult", screen, parentTest,"Search Functionality working fine",driver,testCaseName,"Yes");
				
				Sleep(3000);
				
				//TestCase#10-Verifying Signout Functionality
				
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest, "Hovering Profile icon", driver, testCaseName, "No");
				
				Sleep(2000);
							
				
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Logout Link Clicked", driver, testCaseName, "No");
				
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("Imgur_Favicon", screen, parentTest,"Verify Imgur favicon",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("LogoutText", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Imgur TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Imgur TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
				path=currentSitePath;
				quitDriver(this.driver);
				ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		