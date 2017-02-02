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

public class Apple extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Apple");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.apple.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Apple";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				
				//TestCase#1-Verifying Navigation to home page
				ReportGenerator.verifyNavigation(this.driver,"Apple", parentTest,testCaseName,"Yes");
						
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Apple_favicon", screen, parentTest,"Verify Apple favicon",driver,testCaseName,"Yes");
				
				SikuliUtil.verifyObjectAndHighlight("AppleLogo", screen, parentTest,"Apple Home Logo",driver,testCaseName,"No");
								
				Sleep(3000);
				
				
				//TestCase#3-Verifying Iphone Category page
				
				SikuliUtil.verifyObjectAndClickOn("IphoneCategory", screen, parentTest, "Verify Iphone Category page on Apple", driver, testCaseName, "No");
					
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Apple_favicon", screen, parentTest,"Verify Apple favicon",driver,testCaseName,"No");
				ReportGenerator.verifyNavigation(this.driver, "iPhone", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("IphoneValidation", screen, parentTest,"Iphone Category page loaded on Apple successfully",driver,testCaseName,"Yes");
				
				Sleep(3000);
				screen.wheel(1, 15);			
				Sleep(4000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Apple_favicon", screen, parentTest,"Verify Apple favicon",driver,testCaseName,"No");
				
				ReportGenerator.verifyNavigation(this.driver, "Apple", parentTest,testCaseName,"No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("AppleLogo", screen, parentTest,"Alt+Left Key press functionality working fine on Apple",driver,testCaseName,"Yes");
				
				//TestCase#5-Verifying Login functionality		
				
				SikuliUtil.verifyObjectAndClickOn("ProfileIcon", screen, parentTest, "Profile button clicked ", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("SignInLink", screen, parentTest, "Sign in link clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				SikuliUtil.verifyObjectAndType("UserName", screen, parentTest, "Apple username field", driver, testCaseName, "No","spikesqa@gmail.com"+Key.TAB );
				Sleep(2000);
				SikuliUtil.typeScreen(screen,"QAqa4321!"+Key.ENTER );
						
				Sleep(7000);
				
				SikuliUtil.verifyObjectAndHighlight("Apple_favicon", screen, parentTest,"Verify Apple favicon",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndClickOn("ProfileIcon", screen, parentTest, "Profile button clicked ", driver, testCaseName, "No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"Apple user logged in Functionality",driver,testCaseName,"Yes");
				
				Sleep(2000);
				//TestCase#6-Verifying Iphone Accesories page
						
				SikuliUtil.verifyObjectAndClickOn("IphoneCategory", screen, parentTest, "Verify Iphone Category page on Apple", driver, testCaseName, "No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("IphoneAccesories", screen, parentTest, "Iphone Accessories page on Apple", driver, testCaseName, "No");
				
				Sleep(4000);
				screen.wheel(1, 15);			
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "accessories", parentTest,testCaseName,"Yes");
				
				Sleep(2000);
				
				//TestCase#7-Verifying Product page navigation
				siteURL="http://www.apple.com/shop/product/MMEF2AM/A/airpods";
				driver.navigate().to(baseurl+siteURL);
				Loggers.writeInfoLog("Navigated to Product Page");
				Sleep(4000);
				
				ReportGenerator.verifyNavigation(this.driver, "AirPods", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Apple_favicon", screen, parentTest,"Verify Apple favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("AirPods", screen, parentTest,"Product page navigated successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#8-Verifying AddToBag functionality
				
				SikuliUtil.verifyObjectAndClickOn("AddToBag", screen, parentTest, "Verify Add to bag Link on Apple Product page", driver, testCaseName, "No");
				
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Bag", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("RemoveFrombag", screen, parentTest,"Product is added to Bag on Apple successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				
				//TestCase#9-Verifying RemoveFrombag functionality
				
				SikuliUtil.verifyObjectAndClickOn("RemoveFrombag", screen, parentTest, "Product removal from bag link clicked", driver, testCaseName, "No");
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndHighlight("NoItemInBag", screen, parentTest,"Deleted Item from Bag functionality",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				
				//TestCase#10-Verifying ContinueShopping functionality
				SikuliUtil.verifyObjectAndClickOn("ContinueShopping", screen, parentTest, "Continuing Shopping functionality", driver, testCaseName, "No");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Apple", parentTest,testCaseName,"No");
				Sleep(2000);	
				SikuliUtil.verifyObjectAndHighlight("Apple_favicon", screen, parentTest,"Verify Apple favicon",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#11-Verifying Signout Functionality
				SikuliUtil.verifyObjectAndClickOn("ProfileIcon", screen, parentTest, "Profile button clicked ", driver, testCaseName, "No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest,"Apple user logg out link clicked",driver,testCaseName,"No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("ProfileIcon", screen, parentTest, "Profile button clicked ", driver, testCaseName, "No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("SignInLink", screen, parentTest, "Apple user sign out functionality working fine", driver, testCaseName, "Yes");
				
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Apple TestCase is working as expected");
			
				Loggers.stopCurrentTestCaseExecution(testCaseName);
				
			}catch(Exception e){
			
			
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Apple TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}}	