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

public class WallaCoIlHB extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing WallaCoIlHB");
		
		public void navigateToURL(WebDriver driver){
			siteURL="www.walla.co.il";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Thakur");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/WallaCoIlHB";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				
				//TestCase#1-Verifying Navigation to home page
				ReportGenerator.verifyNavigation(this.driver,"וואלה!", parentTest,testCaseName,"Yes");
						
				//TestCase#2-Verifying Favicon 
				
				SikuliUtil.verifyObjectAndHighlight("WallaHB_favicon", screen, parentTest,"Verify walla Hebrew site favicon",driver,testCaseName,"Yes");
					
				Sleep(3000);
				
				//TestCase#3-Verifying Mobile Category page
				
				SikuliUtil.verifyObjectAndClickOn("Tv", screen, parentTest, "Verify TV Category page on WallaHB", driver, testCaseName, "No");
					
				Sleep(8000);
				
				ReportGenerator.verifyNavigation(this.driver, "וואלה! TV", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Tv_favicon", screen, parentTest,"Verify WallaHB TV News page favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("TvNewsLogo", screen, parentTest,"TV News page loaded on WallaHB successfully",driver,testCaseName,"Yes");
				
				Sleep(3000);
				screen.wheel(1, 40);			
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				Sleep(2000);
				
				//TestCase#4-Home page redirection after clicking Home Logo
	            Sleep(2000);
	            SikuliUtil.verifyObjectAndClickOn("TvNewsLogo", screen, parentTest,"Walla.co.il Home Logo Clicked",driver,testCaseName,"No");
	            Sleep(9000);
	            ReportGenerator.verifyNavigation(this.driver,"וואלה!", parentTest,testCaseName,"No");
	            
	            SikuliUtil.verifyObjectAndHighlight("WallaHB_favicon", screen, parentTest,"Home page redirection after clicking Home Logo",driver,testCaseName,"Yes");
	            //TestCase#5-Verifying Search Functionality
	            Sleep(2000);
	          	screen.paste("בִּנְיָמִין בִּיבִּי נְתַנְיָהוּ‎");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(8000);
				
				ReportGenerator.verifyNavigation(this.driver,"וואלה! חיפוש", parentTest,testCaseName,"No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("WallaHB_favicon", screen, parentTest,"Walla.co.il search functionality validated",driver,testCaseName,"Yes");
				Sleep(3000);
				
				
				//TestCase#6-Verifying Login functionality		
				SikuliUtil.verifyObjectAndClickOn("SignInLink", screen, parentTest, "Sign in link clicked", driver, testCaseName, "No");
				
				Sleep(7000);
				
				ReportGenerator.verifyNavigation(this.driver,"התחברות - וואלה!", parentTest,testCaseName,"No");
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("Username", screen, parentTest, "Username text box clicked", driver, testCaseName, "No");
				Sleep(3000);
				screen.type("spikesqa");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);			
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(10000);
				
				ReportGenerator.verifyNavigation(this.driver,"וואלה! דואר", parentTest,testCaseName,"No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("WallaHB_favicon", screen, parentTest,"Verify WallaHB favicon",driver,testCaseName,"No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"WallaHB user logged in Functionality",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				
				//TestCase#7-Verifying Signout Functionality
				
				
				SikuliUtil.verifyObjectAndClickOn("SignOutLink", screen, parentTest, "Log out button clicked ", driver, testCaseName, "No");
				Sleep(7000);
				ReportGenerator.verifyNavigation(this.driver,"וואלה!", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("LogOutResult", screen, parentTest, "WallaHB user Log out functionality working fine", driver, testCaseName, "Yes");
			
				Sleep(4000);
				
				//TestCase#8-Verify Yes Page
				SikuliUtil.verifyObjectAndClickOn("Yes", screen, parentTest, "Yes tab link clicked ", driver, testCaseName, "No");
				Sleep(7000);
				ReportGenerator.verifyNavigation(this.driver,"VOD", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("WallaHB_favicon", screen, parentTest,"Yes page loaded successfully on WallaHB",driver,testCaseName,"Yes");
			
				Sleep(4000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The WallaHB TestCase is working as expected");
			
				Loggers.stopCurrentTestCaseExecution(testCaseName);
				
			}catch(Exception e){
			
			
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The WallaHB TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}}	
