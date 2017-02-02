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

public class Huffingtonpost extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Huffingtonpost");
		
		public void navigateToURL(WebDriver driver){
			siteURL="www.huffingtonpost.com";
			driver.navigate().to(baseurl+siteURL);
			driver.manage().window().maximize();
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Huffingtonpost";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "The Huffington Post", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Huffingtonpost_Favicon", screen, parentTest,"Verify Huffingtonpost favicon",driver,testCaseName,"Yes");
			
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Huffingtonpost Home Logo",driver,testCaseName,"No");
				
				//TestCase#3-Verifying Trending Huffington post
				SikuliUtil.clickBelow("HomeLogo", screen, parentTest, "Clicking Trending Huffington post", driver, testCaseName, "No", 1500);
				
				
				Sleep(7000);
				
				ReportGenerator.verifyNavigation(this.driver, "The Huffington Post", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Huffingtonpost_Favicon", screen, parentTest,"Verify Huffingtonpost favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Trending Huffington post page loaded successfully",driver,testCaseName,"Yes");
				
				screen.wheel(1, 40);			
				Sleep(6000);
				
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "The Huffington Post", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Huffingtonpost Home Logo",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Huffingtonpost_Favicon", screen, parentTest,"Verify Huffingtonpost Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
				Sleep(2000);				
							
								
				//TestCase#5-Verifying Politics news page
				
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Politics", screen, parentTest, "Politics Tab link clicked on Huffingtonpost", driver, testCaseName, "No");
				
				Sleep(10000);
				
				SikuliUtil.verifyObjectAndHighlight("Huffingtonpost_Favicon", screen, parentTest,"Verify Huffingtonpost favicon",driver,testCaseName,"No");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Political", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("PoliticsLogo", screen, parentTest,"Politics news on Huffingtonpost page loaded",driver,testCaseName,"Yes");
				
				Sleep(2000);
				screen.wheel(1, 40);			
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				Sleep(6000);
				
				//TestCase#6-Verifying Right Click and Back Functionality
				pattern1=new org.sikuli.script.Pattern(patternpath("/PoliticsLogo.PNG"));
				reg=screen.exists(pattern1);
				Sleep(2000);
				r=reg.left(100);
				Sleep(3000);
				r.rightClick();
				Sleep(3000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
				
				Sleep(7000);
				
				ReportGenerator.verifyNavigation(this.driver, "The Huffington Post", parentTest,testCaseName,"No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("Huffingtonpost_Favicon", screen, parentTest,"Right Click and going back to previos page functionality validated",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				//TestCase#7-Verifying Country specific news page
				
				SikuliUtil.verifyObjectAndClickOn("CountryLogo", screen, parentTest, "Clicking Country Edition logo", driver, testCaseName, "No");
				
				Sleep(6000); 
				SikuliUtil.verifyObjectAndClickOn("CountryIndia", screen, parentTest,"Clicking Country India Edition Link",driver,testCaseName,"No");
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "The Huffington Post India", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Huffingtonpost_Favicon", screen, parentTest,"The Huffington Post India page loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(2000);
				screen.wheel(1, 40);			
				Sleep(6000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
				Sleep(6000);
				
				
				//TestCase#8-Verifying Search functionality	
				
				SikuliUtil.verifyObjectAndClickOn("Search", screen, parentTest, "Huffingtonpost search icon clicked", driver, testCaseName, "No");
				
				Sleep(4000);
				screen.type("Shah Rukh Khan"+Key.ENTER);
				Sleep(8000);
				ReportGenerator.verifyNavigation(this.driver, "Huffington Post India", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SearchResult", screen, parentTest,"News page related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(2000);
				SikuliUtil.clickBelow("SearchResult", screen, parentTest, "Clicking Search Result link navigation", driver, testCaseName, "No", 150);
				
				
				Sleep(7000);
				
				//TestCase#9-Verifying Search Result navigation	
				ReportGenerator.verifyNavigation(this.driver, "Shah Rukh Khan", parentTest,testCaseName,"No");
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Huffingtonpost_Favicon", screen, parentTest,"Searched Text Navigated from Huffingtonpost Sucessfully",driver,testCaseName,"Yes");
				
				Sleep(2000);
				screen.wheel(1, 40);			
				Sleep(6000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Huffingtonpost TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Huffingtonpost TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		