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

public class Etsy extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Etsy");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.etsy.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Etsy";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "Etsy.com", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Etsy Home Logo",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Etsy_Favicon", screen, parentTest,"Verify Etsy favicon",driver,testCaseName,"Yes");
			
			
				//TestCase#3-Verifying Painting page on Etsy
				SikuliUtil.verifyObjectAndHighlight("HomeLiving", screen, parentTest,"Hovering HomeLiving Tab",driver,testCaseName,"No");
							
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Painting", screen, parentTest, "Clicking Painting link under HomeLiving tab", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Painting", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Etsy_Favicon", screen, parentTest,"Verify Etsy favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Etsy Painting page loaded successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				//TestCase#4-Verifying Login functionality	
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				Sleep(4000);
				
				
				screen.type("spikesqa@gmail.com");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(8000);
				
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				
				//TestCase#5-Verifying search functionality	
				SikuliUtil.verifyObjectAndType("Search", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "artgifto");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Artgifto", parentTest,testCaseName,"No");
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("SearchResult", screen, parentTest,"Resultset related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				
				
				//TestCase#6-Home page redirection
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("HomeLogo", screen, parentTest, "Home page logo clicked", driver, testCaseName, "No");
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Etsy.com", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Etsy_Favicon", screen, parentTest,"Home page redirected successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
				//TestCase#7-Verifying Product page navigation
				
				siteURL="https://www.etsy.com/listing/114858392/14mm-flexible-cupcake-base-mold";
				driver.navigate().to(baseurl+siteURL);
				Loggers.writeInfoLog("Navigated to Product Page");
				Sleep(5000);
				
				ReportGenerator.verifyNavigation(this.driver, "14mm Flexible Cupcake Base Mold by christyheartsyou on Etsy", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Etsy_Favicon", screen, parentTest,"Redirected to Product page successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#8-Add to cart page navigation
				
				SikuliUtil.verifyObjectAndClickOn("AddToCart", screen, parentTest, "Add to cart page button clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Shopping Cart", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Etsy_Favicon", screen, parentTest,"Product added to cart successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
				//TestCase#9-Remove from cart page navigation
				
				SikuliUtil.verifyObjectAndClickOn("Remove", screen, parentTest, "Remove from cart button clicked", driver, testCaseName, "No");
				
				Sleep(7000);
				ReportGenerator.verifyNavigation(this.driver, "Shopping Cart", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("EmptyCart", screen, parentTest,"Product removed from cart successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
								
				//TestCase#10-Verifying Signout Functionality
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest,"Clciking Profile icon",driver,testCaseName,"No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Clicking Signout Link", driver, testCaseName, "No");
				
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("LoginLink", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Etsy TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Etsy TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		