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

public class Cnet extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Cnet");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.cnet.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Cnet";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "CNET", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Cnet Home Logo",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Cnet_Favicon", screen, parentTest,"Verify Cnet favicon",driver,testCaseName,"Yes");
			
			
				//TestCase#3-Verifying BestProducts page on Cnet
				SikuliUtil.verifyObjectAndHighlight("Reviews", screen, parentTest,"Hovering Reviews Tab",driver,testCaseName,"No");
							
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("BestProducts", screen, parentTest, "Clicking best Products link under reviews tab", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Best Products", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Cnet_Favicon", screen, parentTest,"Verify Cnet favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Cnet Best Products page loaded successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				//TestCase#4-Verifying Login functionality	
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest,"Hovering Profile icon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("Username", screen, parentTest, "Verify availability of Username textbox", driver, testCaseName, "No");
				Sleep(4000);
				
				screen.type("spikesqa@gmail.com");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(8000);
				
				SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest,"Hovering Profile icon",driver,testCaseName,"No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				
				//TestCase#5-Verifying search functionality	
				SikuliUtil.verifyObjectAndType("Search", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "Iphone7");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Iphone7 search results - CNET", parentTest,testCaseName,"No");
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("Iphone7", screen, parentTest,"Resultset related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				
				//TestCase#6-Home page redirection
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("HomeLogo", screen, parentTest, "Home page logo clicked", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "CNET", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Cnet_Favicon", screen, parentTest,"Home page redirected successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
				//TestCase#7-Verifying CNET Downalod page
				
				SikuliUtil.verifyObjectAndClickOn("Download", screen, parentTest, "Clicking Download Tab link", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "CNET Download", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("CnetDownloadPage", screen, parentTest,"Cnet Download page loaded successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				
				
				
				//TestCase#8-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Cnet Home Logo",driver,testCaseName,"No");				
				
				SikuliUtil.verifyObjectAndHighlight("Cnet_Favicon", screen, parentTest,"Verify Cnet Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
						
				
				
				//TestCase#9-Verifying Signout Functionality
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest,"Hovering Profile icon",driver,testCaseName,"No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Signout Button", driver, testCaseName, "No");
				
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndHighlight("LoginLink", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Cnet TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Cnet TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		