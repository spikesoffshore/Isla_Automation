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

public class Steampowered extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Steampowered");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://store.steampowered.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Steampowered";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "Welcome to Steam", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Steampowered Home Logo",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Steampowered_Favicon", screen, parentTest,"Verify Steampowered favicon",driver,testCaseName,"Yes");
			
			
				//TestCase#3-Verifying Top seller page on Steampowered
				
				SikuliUtil.verifyObjectAndClickOn("TopSeller", screen, parentTest, "Clicking Top Seller link on Steampowered", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Steam Search", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Steampowered_Favicon", screen, parentTest,"Verify Steampowered favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Steampowered Top Seller page loaded successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Welcome to Steam", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Steampowered Home Logo",driver,testCaseName,"No");				
				
				SikuliUtil.verifyObjectAndHighlight("Steampowered_Favicon", screen, parentTest,"Verify Steampowered Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
						
				
				//TestCase#5-Verifying Login functionality	
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Login", parentTest,testCaseName,"No");
				Sleep(2000);
				
				screen.type("spikesqa");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(8000);
				
							
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				
				//TestCase#6-Verifying search functionality	
				SikuliUtil.verifyObjectAndType("Search", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "Resident Evil");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Steam Search", parentTest,testCaseName,"No");
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("SearchResult", screen, parentTest,"Resultset related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				//TestCase#7-Verifying SpikesQA profile page on Steampowered
				
				SikuliUtil.verifyObjectAndClickOn("SpikesQAProfile", screen, parentTest, "Clicking SpikesQAProfile link on Steampowered", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Welcome spikesqa", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Steampowered_Favicon", screen, parentTest,"SpikesQA Profile page loaded on Steampowered",driver,testCaseName,"Yes");
				
				
				//TestCase#8-Home page redirection
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("HomeLogo", screen, parentTest, "Home page logo clicked", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Welcome to Steam", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Steampowered_Favicon", screen, parentTest,"Home page redirected successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
				
				//TestCase#9-Verifying Signout Functionality
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest,"Spikes Logged In user link clicked",driver,testCaseName,"No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Logout Button clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("LoginLink", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Steampowered TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Steampowered TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		