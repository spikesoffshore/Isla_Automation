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

public class YahooJP extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing YahooJP");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="www.yahoo.co.jp";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Thakur");
		
		
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/YahooJP";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			
			// Starting test.. 

			// Starting test.. 
		   Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			//TestCase#1-Verifying Navigation to home page			
			ReportGenerator.verifyNavigation(this.driver, "Yahoo! JAPAN", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 
			SikuliUtil.verifyObjectAndHighlight("YahooJP_favicon", screen, parentTest,"YahooJapnese favicon verification",this.driver,testCaseName,"Yes");
			
			//TestCase#3-Verifying Yahoo Travel page - 'ヘルプ'			
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("YahooTravel", screen, parentTest, "Yahoo travel link clicked", driver, testCaseName, "No");
			
			Sleep(7000);
			SikuliUtil.verifyObjectAndHighlight("YahooJP_favicon", screen, parentTest,"YahooJP favicon verification",this.driver,testCaseName,"No");
			Sleep(2000);
		
			SikuliUtil.verifyObjectAndHighlight("YahooTravelPage", screen, parentTest,"Yahoo travel news page loaded",driver,testCaseName,"Yes");
			Sleep(2000);
			screen.wheel(1,40);			
			Sleep(6000);
			

			//TestCase#4-Verifying Alt+Left Key press functionality
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
						
			Sleep(6000);
			ReportGenerator.verifyNavigation(this.driver, "Yahoo! JAPAN", parentTest,testCaseName,"No");
			
			
			SikuliUtil.verifyObjectAndHighlight("YahooJP_favicon", screen, parentTest,"Verify Yahoo Japan Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
			Sleep(2000);				
						
			
			//TestCase#5-Verifying Yahoo Finance page - 'ヘルプ'			
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("YahooFinance", screen, parentTest, "Yahoo Finance news link clicked", driver, testCaseName, "No");
			
			Sleep(7000);
			SikuliUtil.verifyObjectAndHighlight("YahooJP_favicon", screen, parentTest,"YahooJP favicon verification",this.driver,testCaseName,"No");
			Sleep(2000);
		
			SikuliUtil.verifyObjectAndHighlight("YahooFinancePage", screen, parentTest,"Yahoo Finance news page loaded",driver,testCaseName,"Yes");
			Sleep(2000);
			screen.wheel(1,40);			
			Sleep(6000);	
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
			Sleep(4000);
			
			//TestCase#6-Verifying Yahoo Login page - 'ログイン'	
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("LogInLink", screen, parentTest, "Yahoo login link clicked", driver, testCaseName, "No");
			Sleep(7000);
			ReportGenerator.verifyNavigation(this.driver, "ログイン - Yahoo! JAPAN", parentTest,testCaseName,"No");
			
			screen.type("spikesqa@gmail.com");
			
			SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
			Sleep(2000);
		
			screen.type("QAqa4321"+Key.ENTER);
			Sleep(6000);
			SikuliUtil.verifyObjectAndHighlight("YahooSignInError", screen, parentTest,"Yahoo Login Error message validated",driver,testCaseName,"Yes");
			Sleep(2000);
			
			//TestCase#7-Verifying HomePage	navigation
			Sleep(4000);
			SikuliUtil.verifyObjectAndClickOn("HomeLogo", screen, parentTest, "Clicking on home logo to redirect to home page", driver, testCaseName, "No");
			Sleep(7000);
			ReportGenerator.verifyNavigation(this.driver, "Yahoo! JAPAN", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("YahooJP_favicon", screen, parentTest,"Yahoo japan Home page navigated successfully",driver,testCaseName,"Yes");
			
			Sleep(4000);
			//TestCase#8-Verifying Search Functionality
			screen.type("Shah Rukh Khan");
			Sleep(2000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(5000);
			
			ReportGenerator.verifyNavigation(this.driver, "Shah Rukh Khan", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("YahooJP_favicon", screen, parentTest,"Searching functionality for Yahoo verified Sucessfully",driver,testCaseName,"Yes");
			Sleep(3000);
			screen.wheel(1, 40);			
			Sleep(4000);
			
			//TestCase#9-Right Click functionality validation
			pattern1=new org.sikuli.script.Pattern(patternpath("/RightClick.PNG"));
			reg=screen.exists(pattern1);
			reg.highlight(2);
			Sleep(2000);
			r=reg.right(150);
			Sleep(3000);
			r.rightClick();
			Sleep(3000);
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
			
			Sleep(7000);
			
			ReportGenerator.verifyNavigation(this.driver, "Yahoo! JAPAN", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("YahooJP_favicon", screen, parentTest,"Right Click and Going back to Home page validated",driver,testCaseName,"Yes");
			Sleep(2000);
			
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The YahooJP TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The YahooJP TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}