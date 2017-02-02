package testCases;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Indiatimes extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Indiatimes");
		
		public void navigateToURL(WebDriver driver){
			siteURL="www.indiatimes.com";
			driver.navigate().to(baseurl+siteURL);
			driver.manage().window().maximize();
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Indiatimes";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page			
				ReportGenerator.verifyNavigation(this.driver, "Indiatimes.com", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Indiatimes Home Logo",driver,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Indiatimes_Favicon", screen, parentTest,"Verify Indiatimes favicon",driver,testCaseName,"Yes");
			
				
				//TestCase#3-Verifying Trending News 
				SikuliUtil.clickBelow("HomeLogo", screen, parentTest, "Clicking Trending news link", driver, testCaseName, "No", 700);
				
				Sleep(7000);
				
				SikuliUtil.verifyObjectAndHighlight("Indiatimes_Favicon", screen, parentTest,"Verify Indiatimes favicon",driver,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("News", screen, parentTest,"Trending news link page loaded",driver,testCaseName,"Yes");
				
				screen.wheel(1, 15);			
				Sleep(6000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Indiatimes.com", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Indiatimes Home Logo",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Indiatimes_Favicon", screen, parentTest,"Verify Indiatimes Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
				Sleep(2000);				
							
								
				//TestCase#5-Verifying Sports news page
				
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Sports", screen, parentTest, "Sport news link clicked on Indiatimes", driver, testCaseName, "No");
				
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "sports", parentTest,testCaseName,"No");
			
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Indiatimes_Favicon", screen, parentTest,"Sport news on Indiatimes page loaded",driver,testCaseName,"Yes");
				Sleep(2000);
				screen.wheel(1,25);			
				Sleep(6000);
				
				//TestCase#6-Verifying Right Click and Back Functionality
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				Sleep(4000);
				r=reg.right(250);
				Sleep(3000);
				r.rightClick();
				Sleep(3000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
				
				Sleep(7000);
				
				ReportGenerator.verifyNavigation(this.driver, "Indiatimes.com", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Indiatimes_Favicon", screen, parentTest,"Right Click and going back to previous page functionality validated",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#7-Verifying Search functionality	
				SikuliUtil.verifyObjectAndType("Search", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "Cyber Security");
				
				Sleep(6000);
				SikuliUtil.verifyObjectAndHighlight("Close", screen, parentTest,"News page related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				
				screen.wheel(1, 15);			
				Sleep(6000);
				SikuliUtil.verifyObjectAndClickOn("Close", screen, parentTest,"Searched popup closed",driver,testCaseName,"No");
				
				Sleep(4000);
				//TestCase#8-Verifying Login functionality	
				
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				
				Sleep(8000);
				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs2.get(1));

				ReportGenerator.verifyNavigation(this.driver, "Sign in", parentTest,testCaseName,"No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndType("LoginDetails", screen, parentTest, "Entering Login credentials", driver, testCaseName, "No", "spikesqa@gmail.com");
				
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(4000);			
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(10000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ESCAPE);
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Indiatimes_Favicon", screen, parentTest,"Verify Indiatimes favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				//TestCase#9-Verifying ForYou news page
				SikuliUtil.verifyObjectAndClickOn("ForYou", screen, parentTest, "Indiatimes For you menu clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Indiatimes.com", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("ForYouResult", screen, parentTest,"Recommended for you News page loaded successfully",driver,testCaseName,"Yes");
				
				screen.wheel(1,25);			
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				Sleep(6000);
				
				//TestCase#10-Verifying Signout Functionality
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest, "Logged in users account link clicked", driver, testCaseName, "No");
				
				
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Signout", screen, parentTest, "Logout Link Clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("LoginLink", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Indiatimes TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Indiatimes TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		