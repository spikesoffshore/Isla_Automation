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

public class Popcash extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Popcash");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.popcash.net";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Popcash";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "PopCash.Net - The Popunder Network", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Popcash Home Logo",driver,testCaseName,"No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("Popcash_Favicon", screen, parentTest,"Verify Popcash favicon",driver,testCaseName,"Yes");
			
				//TestCase#3-Verifying Advertisers page	
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Advertisers", screen, parentTest, "Advertisers tab clicked", driver, testCaseName, "No");
				
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Advertisers", parentTest,testCaseName,"No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("Popcash_Favicon", screen, parentTest,"Advertisers page loaded successfully",driver,testCaseName,"Yes");
				
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("Popcash_Favicon", screen, parentTest,"Verify Popcash favicon",driver,testCaseName,"No");
				
				ReportGenerator.verifyNavigation(this.driver, "PopCash.Net - The Popunder Network", parentTest,testCaseName,"No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Alt+Left Key press functionality working fine on Popcash",driver,testCaseName,"Yes");
				//TestCase#5-Verifying Publishers page	
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Publishers", screen, parentTest, "Publishers tab clicked", driver, testCaseName, "No");
				
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Publishers", parentTest,testCaseName,"No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("Popcash_Favicon", screen, parentTest,"Publishers page loaded successfully",driver,testCaseName,"Yes");
				
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				
				
				
				
				//TestCase#6-Verifying Login functionality	
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndClickOn("Username", screen, parentTest, "Username field clicked", driver, testCaseName, "No");
				Sleep(2000);
				
				
				screen.type("spikesqa@gmail.com");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(8000);
				
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
								
				//TestCase#7-Website tab page
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Website", screen, parentTest, "Website tab clicked", driver, testCaseName, "No");
				
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Websites", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Popcash_Favicon", screen, parentTest,"Website page loaded successfully",driver,testCaseName,"Yes");
				
				
				//TestCase#8-Verifying Signout Functionality
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"Clicking Profile icon",driver,testCaseName,"No");
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Clicking Logout Link", driver, testCaseName, "No");
				
				Sleep(6000);
			
				SikuliUtil.verifyObjectAndHighlight("LoginLink", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Popcash TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Popcash TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		