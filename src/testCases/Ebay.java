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

public class Ebay extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Ebay");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.ebay.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
					this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Ebay";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
							
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				
				//TestCase#1-Verifying Navigation to home page
				ReportGenerator.verifyNavigation(this.driver, "eBay", parentTest,testCaseName,"Yes");
						
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Ebay_favicon", screen, parentTest,"Verify ebay favicon",driver,testCaseName,"Yes");
				
				SikuliUtil.verifyObjectAndHighlight("EbayLogo", screen, parentTest,"Ebay Home Logo",driver,testCaseName,"No");
								
				Sleep(3000);
				//TestCase#3-Verifying Login functionality	
				SikuliUtil.verifyObjectAndClickOn("SignInLink", screen, parentTest, "Verify availability of Sign in link", driver, testCaseName, "No");
				
				Sleep(8000);
				
				screen.type("spikesqa@gmail.com");
				Sleep(2000);
				
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("Ebay_favicon", screen, parentTest,"Verify ebay favicon",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"eBay user logged in Functionality",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				//TestCase#4-Verifying Electronics Category page
				
				SikuliUtil.verifyObjectAndClickOn("ElectronicsCategory", screen, parentTest, "Verify Electronics Category page on Ebay", driver, testCaseName, "No");
					
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Ebay_favicon", screen, parentTest,"Verify ebay favicon",driver,testCaseName,"No");
				ReportGenerator.verifyNavigation(this.driver, "Electronics", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("ElectronicsPageVerify", screen, parentTest,"Electronics Category page loaded on Ebay successfully",driver,testCaseName,"Yes");
				
				Sleep(3000);
				screen.wheel(1, 15);			
				Sleep(4000);
				
				//TestCase#5-Verifying Product page navigation
								
				siteURL="http://www.ebay.com/itm/Motorola-Moto-X-Pure-4G-with-32GB-Memory-Cell-Phone-Unlocked-Bamboo-/322334213051?hash=item4b0c9dc3bb:g:opEAAOSwmLlX4dzZ";
				driver.navigate().to(baseurl+siteURL);
				Loggers.writeInfoLog("Navigated to Product Page");
				Sleep(3000);
				
				ReportGenerator.verifyNavigation(this.driver, "Motorola", parentTest,testCaseName,"Yes");
				
				//TestCase#6-Verifying AddToWatchlist functionality
				
				SikuliUtil.verifyObjectAndClickOn("WatchlistAdditionLink", screen, parentTest, "Verify Add to Watchlist Link on Ebay Product page", driver, testCaseName, "No");
				
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("AddedToWatchlist", screen, parentTest,"Product is added to watchlist on Ebay successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				
				//TestCase#7-Verifying BuyNow functionality
				
				SikuliUtil.verifyObjectAndHighlight("MyEbay", screen, parentTest,"Verify My Ebay Link on Ebay Product page",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndClickOn("MyEbayWatchlist", screen, parentTest, "My Watchlist Link", driver, testCaseName, "No");
				Sleep(2000);
				
				ReportGenerator.verifyNavigation(this.driver, "My eBay", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("BuyNow", screen, parentTest,"Verify BuyNow Functionality on my watchlist page",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				//TestCase#8-Verifying DeleteItem from watchlist functionality
				
				
				SikuliUtil.verifyObjectAndClickOn("DeleteItem", screen, parentTest, "Delete item from Cart page", driver, testCaseName, "No");
				Sleep(2000);
							
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("NoItemInWatchlist", screen, parentTest,"Delete Item from Cart page functionality",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				
				//TestCase#9-Verifying Signout Functionality
				
				SikuliUtil.verifyObjectAndHighlight("Ebay_favicon", screen, parentTest,"Verify ebay favicon",driver,testCaseName,"No");
				
				Sleep(2000);				
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"Verify spikesqa account link",this.driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("SignOut", screen, parentTest, "SignOut link on ebay page", driver, testCaseName, "No");
			
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "You've signed out", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Ebay_favicon", screen, parentTest,"Signout successfully from ebay",driver,testCaseName,"Yes");
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The eBay TestCase is working as expected");
			
				Loggers.stopCurrentTestCaseExecution(testCaseName);
				
			}catch(Exception e){
			
			
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Ebay TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{

			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}}	