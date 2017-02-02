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

public class Bbc extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Bbc");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.bbc.com";
			driver.navigate().to(baseurl+siteURL);
			driver.manage().window().maximize();
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Bbc";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page			
				ReportGenerator.verifyNavigation(this.driver, "BBC", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Bbc_Favicon", screen, parentTest,"Verify Bbc favicon",driver,testCaseName,"Yes");
			
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Bbc Home Logo",driver,testCaseName,"No");
				
				//TestCase#3
				SikuliUtil.clickBelow("HomeLogo", screen, parentTest, "Trending news link clicked", driver, testCaseName, "No", 300);
				
				Sleep(7000);
				SikuliUtil.verifyObjectAndHighlight("Bbc_Favicon", screen, parentTest,"Verify Bbc favicon",driver,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("News", screen, parentTest,"Trending news link page loaded",driver,testCaseName,"Yes");
				
				screen.wheel(1, 15);			
				Sleep(6000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "BBC", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Bbc Home Logo",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Bbc_Favicon", screen, parentTest,"Verify Bbc Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
				Sleep(2000);				
														
				//TestCase#5-Verifying Sport news page
							
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Sport", screen, parentTest, "Sport news link clicked on Bbc", driver, testCaseName, "No");
				
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "BBC Sport", parentTest,testCaseName,"No");
			
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Bbc_Favicon", screen, parentTest,"Sport news on BBC page loaded",driver,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("HomeLogo1", screen, parentTest,"Bbc Home Logo",driver,testCaseName,"No");
				Sleep(4000);
				screen.wheel(1, 40);			
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				Sleep(4000);
				
				//TestCase#6-Verifying Right Click and Back Functionality
				pattern1=new org.sikuli.script.Pattern(patternpath("/HomeLogo1.PNG"));
				Sleep(2000);
				reg=screen.exists(pattern1);
				r=reg.left(100);
				Sleep(3000);
				r.rightClick();
				Sleep(3000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
				
				Sleep(7000);
				
				ReportGenerator.verifyNavigation(this.driver, "Homepage", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Bbc_Favicon", screen, parentTest,"Right Click and going back to previous page functionality validated",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#7-Verifying Search functionality	
				
				SikuliUtil.verifyObjectAndClickOn("Search", screen, parentTest, "Bbc search link clicked", driver, testCaseName, "No");				
				Sleep(7000);
				screen.type("Cyber Security");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(7000);
				ReportGenerator.verifyNavigation(this.driver, "Cyber Security", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Bbc_Favicon", screen, parentTest,"News page related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				screen.wheel(1, 15);			
				Sleep(6000);
				SikuliUtil.verifyObjectAndClickOn("HomeLogo1", screen, parentTest,"Clicking Bbc Home Logo",driver,testCaseName,"No");
				Sleep(6000);
				
				//TestCase#8-Verifying Login functionality	
				
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				
				Sleep(8000);
				ReportGenerator.verifyNavigation(this.driver, "Sign in", parentTest,testCaseName,"No");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				
				screen.type("spikesqa@gmail.com");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);			
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(10000);
				
				SikuliUtil.verifyObjectAndHighlight("Bbc_Favicon", screen, parentTest,"Verify Bbc favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				//TestCase#9-Verifying TV news page
				SikuliUtil.verifyObjectAndClickOn("MoreMenu", screen, parentTest, "Bbc More Menu icon clicked", driver, testCaseName, "No");
				
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Tv", screen, parentTest, "TV news link clicked on Bbc", driver, testCaseName, "No");
				Sleep(7000);
				ReportGenerator.verifyNavigation(this.driver, "TV", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Bbc_Favicon", screen, parentTest,"TV News page loaded successfully",driver,testCaseName,"Yes");
				
				screen.wheel(1, 15);			
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(6000);
				
				//TestCase#10-Verifying Signout Functionality
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest, "Logged in users account link clicked", driver, testCaseName, "No");
				
				Sleep(8000);
				ReportGenerator.verifyNavigation(this.driver, "account", parentTest,testCaseName,"No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Signout", screen, parentTest, "Logout Link Clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "signed out", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Bbc_Favicon", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Bbc TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Bbc TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		