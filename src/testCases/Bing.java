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

public class Bing extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Bing");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.bing.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Bing";
			
			navigateToURL(this.driver);
			
			Sleep(15000);
						
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				

				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "Bing", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Bing_Favicon", screen, parentTest,"Verify Bing favicon",driver,testCaseName,"Yes");
			
				Sleep(4000);
			
				//TestCase#3-Verifying Bing Image tab
				
				SikuliUtil.verifyObjectAndClickOn("BingImages", screen, parentTest, "Verify and click Bing Image tab", driver, testCaseName, "No");
				Sleep(4000);
				
				ReportGenerator.verifyNavigation(this.driver, "Bing Image", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Bing_Favicon", screen, parentTest,"Bing Image Tab validation done",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				screen.wheel(1, 15);
				
				Sleep(4000);
				Loggers.writeInfoLog("Wheel Movement Done successfully ..... Continuing Test");
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(4000);
				
				
				
				SikuliUtil.verifyObjectAndClickOn("ProfileIcon", screen, parentTest, "Alt+Left Key press functionality working fine on Bing ", driver, testCaseName, "Yes");
				
				Sleep(4000);
				//TestCase#5-Verifying Login functionality	
				
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(1000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(3000);
				
				screen.type("spikesqa@gmail.com");
				Sleep(4000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);				
				Sleep(4000);
				screen.type("QAqa4321!"+Key.ENTER);
				Sleep(7000);
				
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"Sign in functionality for bing user working fine",driver,testCaseName,"Yes");
				Sleep(3000);
				
				
				
				
				//TestCase#6-Verifying Search functionality
				
				screen.type("ISLA Cyberinc");
				Sleep(4000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "ISLA Cyberinc", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndClickOn("SearchedText", screen, parentTest, "Searching functionality for Bing verified Sucessfully", driver, testCaseName, "Yes");
				
				//TestCase#7-Verifying Search Result navigation functionality
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Isla", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("SearchedLinkFavicon", screen, parentTest,"Searched Text Navigated from Bing Sucessfully",driver,testCaseName,"Yes");
				
				
				screen.wheel(1, 15);			
				Sleep(4000);
				Loggers.writeInfoLog("Wheel Movement Done successfully ..... Continuing Test");
				
				//TestCase#8-Verifying Search History
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				
				Sleep(2000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				
				Sleep(4000);
				Loggers.writeInfoLog("navigated back to bing home page successfully");
				SikuliUtil.verifyObjectAndHighlight("Bing_Favicon", screen, parentTest,"Verify Bing favicon",driver,testCaseName,"No");
				Sleep(1000);
				
				SikuliUtil.verifyObjectAndClickOn("SettingIcon", screen, parentTest, "Mypreference Icon clicked successfully", driver, testCaseName, "No");
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("SearchHistory", screen, parentTest, "Search History Link clicked successfully", driver, testCaseName, "No");
				Sleep(3000);
				ReportGenerator.verifyNavigation(this.driver, "Search History", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("SearchHistoryResultValidation", screen, parentTest,"Searched History validated for logged in user for Bing Sucessfully",driver,testCaseName,"Yes");
				
				Sleep(2000);
				screen.wheel(1, 15);			
				Sleep(4000);
				Loggers.writeInfoLog("Wheel Movement Done successfully ..... Continuing Test");
				
				//TestCase#9-Verifying Signout Functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndClickOn("ProfileIcon", screen, parentTest, "Clicking profile icon click", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("SignOut", screen, parentTest,"Clicking signout button",driver,testCaseName,"No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Bing_Favicon", screen, parentTest,"Verify Bing favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("ProfileIcon", screen, parentTest, "Verify profile icon click for validating Logout functionality", driver, testCaseName, "No");
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("ConnectLink", screen, parentTest,"User logout functionality working fine",driver,testCaseName,"Yes");
					
				Sleep(2000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Bing TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
				
			}catch(Exception e){
			
			
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Bing TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}}	
