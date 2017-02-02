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

public class RakutenJP extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing RakutenJP");
		
		public void navigateToURL(WebDriver driver){
			siteURL="www.rakuten.co.jp";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Thakur");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/RakutenJP";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				
				//TestCase#1-Verifying Navigation to home page
				ReportGenerator.verifyNavigation(this.driver,"ã€�æ¥½å¤©å¸‚å ´ã€‘Shopping", parentTest,testCaseName,"Yes");
						
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("RakutenJP_favicon", screen, parentTest,"Verify Rakuten Japnese site favicon",driver,testCaseName,"Yes");
				
					
				Sleep(3000);
				
				
				//TestCase#3-Verifying Mobile Category page
				
				SikuliUtil.verifyObjectAndClickOn("Mobile", screen, parentTest, "Verify Mobile Category page on RakutenJP", driver, testCaseName, "No");
					
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "æ¥½å¤©ãƒ¢ãƒ�ã‚¤ãƒ«ï¼šå®‰å¿ƒãƒ»ã�Šå¾—ã�ªæ ¼å®‰ã‚¹ãƒžãƒ›(ã‚¹ãƒžãƒ¼ãƒˆãƒ•ã‚©ãƒ³)/æ ¼å®‰SIM", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("RakutenJP_favicon", screen, parentTest,"Verify RakutenJP favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("MobilePage", screen, parentTest,"Mobile Category page loaded on RakutenJP successfully",driver,testCaseName,"Yes");
				
				Sleep(3000);
				screen.wheel(1, 40);			
				Sleep(4000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "ã€�æ¥½å¤©å¸‚å ´ã€‘Shopping", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("RakutenJP_favicon", screen, parentTest,"Verify Rakuten Japan Home page redirection after Alt+Left keys",driver,testCaseName,"No");
				Sleep(3000);
				
				
				//TestCase#5-Verifying Login functionality		
				
				
				
				SikuliUtil.verifyObjectAndClickOn("SignInLink", screen, parentTest, "Sign in link clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				
				screen.type("spikesqa@gmail.com");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);			
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(10000);
				
				SikuliUtil.verifyObjectAndHighlight("RakutenJP_favicon", screen, parentTest,"Verify RakutenJP favicon",driver,testCaseName,"No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"RakutenJP user logged in Functionality",driver,testCaseName,"Yes");
				
				Sleep(2000);
				//TestCase#6-Verifying Books Category page
						
				SikuliUtil.verifyObjectAndClickOn("Books", screen, parentTest, "Verify Books Category page on RakutenJP", driver, testCaseName, "No");
				
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "æ¥½å¤©ãƒ–ãƒƒã‚¯ã‚¹: æœ¬ãƒ»DVDãƒ»CDãƒ»ã‚²ãƒ¼ãƒ ã�®é€šè²©ã€€ã‚ªãƒ³ãƒ©ã‚¤ãƒ³æ›¸åº—", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("RakutenJP_favicon", screen, parentTest,"Books Category page loaded on RakutenJP successfully",driver,testCaseName,"Yes");
				Sleep(3000);
				screen.wheel(1, 40);			
				Sleep(4000);
				
				
				//TestCase#7-Verifying Product page navigation
				siteURL="http://books.rakuten.co.jp/rk/e2af1aa53e373ed8832b3b9232cb4a81";
				driver.navigate().to(baseurl+siteURL);
				Loggers.writeInfoLog("Navigated to Product Page");
				Sleep(4000);
				
				ReportGenerator.verifyNavigation(this.driver, "æ¥½å¤©Koboé›»å­�æ›¸ç±�ã‚¹ãƒˆã‚¢: ï¼³ã�®ç¶™æ‰¿ï¼ˆä¸Šï¼‰ - å ‚å ´çž¬ä¸€", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("RakutenJP_favicon", screen, parentTest,"Product page navigated successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#8-Verifying AddToBag functionality
				
				SikuliUtil.verifyObjectAndClickOn("AddToBag", screen, parentTest, "Verify Add to bag Link on RakutenJP Product page", driver, testCaseName, "No");
				
				Sleep(5000);
				
				SikuliUtil.verifyObjectAndHighlight("RemoveFrombag", screen, parentTest,"Product is added to Bag on RakutenJP successfully",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				//TestCase#9-Verifying RemoveFrombag functionality
				
				SikuliUtil.verifyObjectAndClickOn("RemoveFrombag", screen, parentTest, "Product removal from bag link clicked", driver, testCaseName, "No");
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndHighlight("NoItemInBag", screen, parentTest,"Deleted Item from Bag functionality",driver,testCaseName,"Yes");
				
				Sleep(4000);
				
				
				
				siteURL="www.rakuten.co.jp";
				driver.navigate().to(baseurl+siteURL);
				Sleep(9000);
				
				//TestCase#10-Verifying Signout Functionality
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"RakutenJP user page link hovered",driver,testCaseName,"No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest,"RakutenJP user page link clicked",driver,testCaseName,"No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("SignOutLink", screen, parentTest, "Log out button clicked ", driver, testCaseName, "No");
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndHighlight("LogOutResult", screen, parentTest, "RakutenJP user Log out functionality working fine", driver, testCaseName, "Yes");
			
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The RakutenJP TestCase is working as expected");
			
				Loggers.stopCurrentTestCaseExecution(testCaseName);
				
			}catch(Exception e){
			
			
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The RakutenJP TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}}	