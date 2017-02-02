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

public class Reddit extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Reddit");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.reddit.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Reddit";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "reddit", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Reddit_Favicon", screen, parentTest,"Verify Reddit favicon",driver,testCaseName,"Yes");
			
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Reddit Home Logo",driver,testCaseName,"No");
				
				//TestCase#3-Verifying Trending subreddits page
				
				pattern1=new org.sikuli.script.Pattern(patternpath("/Trending.PNG"));
				SikuliUtil.verifyObjectAndHighlight("Trending", screen, parentTest,"Verify Trending subreddits",driver,testCaseName,"Yes");
				
				SikuliUtil.clickBelow("Trending", screen, parentTest, "Clicking Trending subreddits", driver, testCaseName, "No", 100);
				
				Sleep(7000);
				Loggers.writeInfoLog("Trending news link page loaded");
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("Reddit_Favicon", screen, parentTest,"Verify Reddit Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Reddit Home Logo",driver,testCaseName,"No");				
							
				//TestCase#5-Verifying Login functionality	
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				
				Sleep(8000);
				
				screen.type("spikesqa");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(10000);
				
				SikuliUtil.verifyObjectAndHighlight("Reddit_Favicon", screen, parentTest,"Verify Reddit favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				
				//TestCase#6-Verifying New subreddits page
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("New", screen, parentTest, "Verify New Reddit tab link", driver, testCaseName, "No");
				
				Sleep(4000);
				
				ReportGenerator.verifyNavigation(this.driver, "newest", parentTest,testCaseName,"No");
			
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Reddit_Favicon", screen, parentTest,"New news Reddit page loaded",driver,testCaseName,"Yes");
				
				screen.wheel(1, 15);			
				Sleep(4000);
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				//TestCase#7-Verifying Pic subreddits page
				
				SikuliUtil.verifyObjectAndClickOn("Pic", screen, parentTest, "Reddit Pic link", driver, testCaseName, "No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("PicLogo", screen, parentTest,"Verified Reddit Pic Page load",driver,testCaseName,"Yes");
				
				
				
				Sleep(5000);
				
				//TestCase#8-Verifying Signout Functionality
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Logout Button", driver, testCaseName, "No");
				
				Sleep(8000);
				SikuliUtil.verifyObjectAndHighlight("Reddit_Favicon", screen, parentTest,"Verify Reddit favicon",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("LoginLink", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Reddit TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Reddit TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		