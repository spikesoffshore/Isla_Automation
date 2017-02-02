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

public class Buzzfeed extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Buzzfeed");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.buzzfeed.com/";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Buzzfeed";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "BuzzFeed", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Buzzfeed Home Logo",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Buzzfeed_Favicon", screen, parentTest,"Verify Buzzfeed favicon",driver,testCaseName,"Yes");
			
			
				//TestCase#3-Verifying Top seller page on Buzzfeed
				
				SikuliUtil.verifyObjectAndClickOn("Omg", screen, parentTest, "Clicking OMG link on Buzzfeed", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "OMG Feed", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Buzzfeed_Favicon", screen, parentTest,"Verify Buzzfeed favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("HomeLogo1", screen, parentTest,"OMG Buzzfeed page loaded successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "BuzzFeed", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Buzzfeed Home Logo",driver,testCaseName,"No");				
				
				SikuliUtil.verifyObjectAndHighlight("Buzzfeed_Favicon", screen, parentTest,"Verify Buzzfeed Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
						
				
				//TestCase#5-Verifying Login functionality	
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("More", screen, parentTest,"More Buzz menu hovered",driver,testCaseName,"No");				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "BuzzFeed Sign In", parentTest,testCaseName,"No");
				Sleep(4000);
				
				screen.type("spikesqa");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(8000);
				
							
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				
				//TestCase#6-Verifying search functionality	
				Sleep(3000);
				SikuliUtil.verifyObjectAndType("Search", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "Hilarious");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "BuzzFeed Search", parentTest,testCaseName,"No");
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("SearchResult", screen, parentTest,"Resultset related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
								
				//TestCase#7-Home page redirection
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("HomeLogo1", screen, parentTest, "Home page logo clicked", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "BuzzFeed", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Buzzfeed_Favicon", screen, parentTest,"Home page redirected successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
				//TestCase#8-Verifying Trending page on Buzzfeed
				
				SikuliUtil.verifyObjectAndClickOn("Trending", screen, parentTest, "Clicking Trending Icon on Buzzfeed", driver, testCaseName, "No");
				
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Trending On BuzzFeed", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Buzzfeed_Favicon", screen, parentTest,"Verify Buzzfeed favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("HomeLogo1", screen, parentTest,"Trending Buzzfeed page loaded successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				
				//TestCase#9-Verifying Signout Functionality
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest,"Spikes Logged In user link clicked",driver,testCaseName,"No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Logout Button clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("ProfileIcon1", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Buzzfeed TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Buzzfeed TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		