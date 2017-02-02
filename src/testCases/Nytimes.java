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

public class Nytimes extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Nytimes");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.nytimes.com";
			driver.navigate().to(baseurl+siteURL);
			driver.manage().window().maximize();
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Nytimes";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page			
				ReportGenerator.verifyNavigation(this.driver, "The New York Times", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Nytimes_Favicon", screen, parentTest,"Verify Nytimes favicon",driver,testCaseName,"Yes");
			
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Nytimes Home Logo",driver,testCaseName,"No");
				
				//TestCase#3-Verifying Business news page
				Sleep(6000);
				SikuliUtil.verifyObjectAndClickOn("Business", screen, parentTest, "Business news link clicked on Nytimes", driver, testCaseName, "No");
				
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "Business", parentTest,testCaseName,"No");
			
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Nytimes_Favicon", screen, parentTest,"Business news on Nytimes page loaded",driver,testCaseName,"Yes");
				Sleep(4000);
				screen.wheel(1, 15);			
				Sleep(6000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "The New York Times", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Nytimes Home Logo",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Nytimes_Favicon", screen, parentTest,"Verify Nytimes Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
				Sleep(2000);				
							
								
				//TestCase#5-Verifying Todays news paper page
				
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("TodaysPaper", screen, parentTest, "Today's paper link clicked on Nytimes", driver, testCaseName, "No");
				
				Sleep(10000);
				
				SikuliUtil.verifyObjectAndHighlight("Nytimes_Favicon", screen, parentTest,"Verify Nytimes favicon",driver,testCaseName,"No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("TodaysPaperLogo", screen, parentTest,"Today's Paper on Nytimes page loaded",driver,testCaseName,"Yes");
				
				Sleep(2000);
				screen.wheel(1, 15);			
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				Sleep(6000);
				
				//TestCase#6-Verifying Login functionality	
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in Button", driver, testCaseName, "No");
				
				Sleep(8000); 
				SikuliUtil.verifyObjectAndHighlight("Nytimes_Favicon", screen, parentTest,"Verify Nytimes favicon",driver,testCaseName,"No");
				
				ReportGenerator.verifyNavigation(this.driver, "Log In", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndClickOn("Email", screen, parentTest, "Email Text box area clicked on Login page", driver, testCaseName, "No");
				
				Sleep(2000);
				
				screen.type("spikesqa@gmail.com");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);			
				screen.type("QAqa4321"+Key.ENTER);
							
				Sleep(10000);
				
				SikuliUtil.verifyObjectAndHighlight("Nytimes_Favicon", screen, parentTest,"Verify Nytimes favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				Sleep(2000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				
				Sleep(4000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				
				Sleep(6000);
				//TestCase#7-Verifying Search functionality	
				
				SikuliUtil.verifyObjectAndClickOn("Search", screen, parentTest, "Nytimes search link clicked", driver, testCaseName, "No");
				
				Sleep(4000);
				screen.type("Cyber Security"+Key.ENTER);
				Sleep(8000);
				ReportGenerator.verifyNavigation(this.driver, "Search", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Nytimes_Favicon", screen, parentTest,"News page related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(2000);
				screen.wheel(1, 15);			
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				
				Sleep(6000);
				
				
				//TestCase#8-Verifying Nytimes Video page
				SikuliUtil.verifyObjectAndClickOn("Video", screen, parentTest, "Nytimes Video link clicked", driver, testCaseName, "No");
				
				Sleep(7000);
				ReportGenerator.verifyNavigation(this.driver, "Times Video", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Nytimes_Favicon", screen, parentTest,"Times Video Page loaded successfully",driver,testCaseName,"Yes");
				
				screen.wheel(1, 15);			
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				Sleep(6000);
				
				//TestCase#9-Verifying Signout Functionality
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest, "Logged in users account link clicked", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("Signout", screen, parentTest, "Logout Link Clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "Logoff", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Nytimes_Favicon", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Nytimes TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Nytimes TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		