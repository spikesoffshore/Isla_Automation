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

public class Imdb extends Base {
	private WebDriver driver;
	private String currentSitePath;
	
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Imdb");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.imdb.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Imdb";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page			
				ReportGenerator.verifyNavigation(this.driver, "IMDb", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Imdb Home Logo",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Imdb_Favicon", screen, parentTest,"Verify Imdb favicon",driver,testCaseName,"Yes");
				Sleep(3000);
			
				//TestCase#3-Verifying NewRelease page 
			
				SikuliUtil.verifyObjectAndClickOn("NewRelease", screen, parentTest, "Showtime link clicked", driver, testCaseName, "No");
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Showtimes", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Imdb_Favicon", screen, parentTest,"Movies Opening this weekend page loaded successfully",driver,testCaseName,"Yes");
				Sleep(3000);
				
				SikuliUtil.moveWheel(screen, 1, 15);
				
				Loggers.writeInfoLog("Wheel movement Done.....Continuing Test");
				
				Sleep(6000);
							
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Loggers.writeInfoLog("Navigated back to home page");
				Sleep(5000);
				
				ReportGenerator.verifyNavigation(this.driver, "IMDb", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Imdb_Favicon", screen, parentTest,"Verify navigating back to home page after Alt+Left key press",driver,testCaseName,"Yes");
				
				//TestCase#5-Verifying Login functionality
				
				SikuliUtil.verifyObjectAndClickOn("OtherSignInLink", screen, parentTest, "Clicking Other SignIn Link", driver, testCaseName, "No");
				Sleep(5000);
				
				ReportGenerator.verifyNavigation(this.driver, "Sign in", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Clicking sign in link", driver, testCaseName, "No");
				Sleep(5000);
				
				screen.type("spikesqa@gmail.com");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				screen.type("QAqa4321"+Key.ENTER);
							
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("Imdb_Favicon", screen, parentTest,"Verify Imdb favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				//TestCase#6-Verifying Celebrity News page 
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("CelebsTab", screen, parentTest,"Hovering on Celebs Tab",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("CelebrityNews", screen, parentTest, "Celebrity news page link clicked", driver, testCaseName, "No");
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Celebrity News", parentTest,testCaseName,"No");
				
				pattern1=new org.sikuli.script.Pattern(patternpath("/CelebrityNewsIcon.PNG"));
				SikuliUtil.verifyObjectAndHighlight("CelebrityNewsIcon", screen, parentTest,"Celebrity news page loaded successfully",driver,testCaseName,"Yes");
				
				//TestCase#7-Right Click functionality validation
				
				reg=screen.exists(pattern1);
				reg.highlight(2);
				Sleep(2000);
				r=reg.right(250);
				Sleep(3000);
				r.rightClick();
				Sleep(3000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
				
				Sleep(7000);
				
				ReportGenerator.verifyNavigation(this.driver, "IMDb", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Imdb Home Logo",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Imdb_Favicon", screen, parentTest,"Right Click and Going back to Home page validated",driver,testCaseName,"Yes");
				Sleep(2000);
				
				
				//TestCase#8-Verifying Search functionality	
				
				SikuliUtil.verifyObjectAndType("SearchTextBox", screen, parentTest, "Verify Search textbox", driver, testCaseName, "No", "Bajirao Mastani");
				
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
							
				Sleep(5000);	
				ReportGenerator.verifyNavigation(this.driver, "Find", parentTest,testCaseName,"No");
								
				SikuliUtil.verifyObjectAndHighlight("Imdb_Favicon", screen, parentTest,"Imdb favicon highlighted",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndClickOn("SearchResult", screen, parentTest,"Search Functionality working fine",driver,testCaseName,"Yes");
				
				Sleep(5000);
				
				
				ReportGenerator.verifyNavigation(this.driver, "Bajirao Mastani", parentTest,testCaseName,"No");
				Sleep(3000);
				
				
				//TestCase#9-Verifying Signout Functionality
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest, "Hovering Profile icon", driver, testCaseName, "No");
				
				Sleep(2000);
							
				
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Logout Link Clicked", driver, testCaseName, "No");
				
				Sleep(7000);
				SikuliUtil.verifyObjectAndHighlight("Imdb_Favicon", screen, parentTest,"Verify Imdb favicon",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("OtherSignInLink", screen, parentTest,"User logout functionality validated",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Imdb TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Imdb TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
				path=currentSitePath;
				quitDriver(this.driver);
				ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		