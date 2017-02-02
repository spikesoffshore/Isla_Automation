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

public class DaumKR extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing DaumKR");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="www.daum.net";
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
		path=path+"/DaumKR";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			
			// Starting test.. 
		   Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			//TestCase#1-Verifying Navigation to home page			
			ReportGenerator.verifyNavigation(this.driver, "Daum", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 
			SikuliUtil.verifyObjectAndHighlight("DaumKR_favicon", screen, parentTest,"Daum Korean favicon verification",this.driver,testCaseName,"Yes");
			//TestCase#3-Verifying Search Functionality
					
			screen.type("Shah Rukh Khan");
			Sleep(2000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(5000);
			
			ReportGenerator.verifyNavigation(this.driver, "Shah Rukh Khan â€“ Daum í†µí•© ê²€ìƒ‰", parentTest,testCaseName,"No");
			screen.wheel(1,40);			
			Sleep(6000);
			SikuliUtil.verifyObjectAndHighlight("HomeLogo1", screen, parentTest,"Searching functionality for Daum verified Sucessfully",driver,testCaseName,"Yes");
			Sleep(3000);
			//TestCase#4-Verifying Alt+Left Key press functionality
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			Sleep(6000);
			ReportGenerator.verifyNavigation(this.driver, "Daum", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("DaumKR_favicon", screen, parentTest,"Verify redirection after Alt+Left keys",driver,testCaseName,"Yes");
			Sleep(3000);
			
			
			//TestCase#5-Verifying Daum Cafe page - ì¹´íŽ˜
			
			
			SikuliUtil.verifyObjectAndClickOn("Cafe", screen, parentTest, "Daum Cafe link clicked", driver, testCaseName, "No");
			
			Sleep(7000);
			ReportGenerator.verifyNavigation(this.driver, "Daum ì¹´íŽ˜", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("CafePage", screen, parentTest,"Daum Korean Cafe page loaded",this.driver,testCaseName,"Yes");
			Sleep(2000);
		
			
			screen.wheel(1,40);			
			Sleep(6000);
			//TestCase#6-Verifying HomePage	navigation
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
			Sleep(4000);
			
			SikuliUtil.verifyObjectAndClickOn("HomeLogo", screen, parentTest, "Clicking on home logo to redirect to home page", driver, testCaseName, "No");
			Sleep(4000);
			ReportGenerator.verifyNavigation(this.driver, "Daum", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("DaumKR_favicon", screen, parentTest,"Daum Home page navigated successfully",driver,testCaseName,"Yes");
			//TestCase#7-Verifying Daum Stock page -ê¸ˆìœµ
			
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("Stock", screen, parentTest, "Daum Stock link clicked", driver, testCaseName, "No");
			
			Sleep(7000);
			ReportGenerator.verifyNavigation(this.driver, "Daum ê¸ˆìœµ", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("RightClickRegion", screen, parentTest,"Daum Korean Stock page loaded",this.driver,testCaseName,"Yes");
			Sleep(2000);
			screen.wheel(1,40);			
			Sleep(6000);
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
			Sleep(4000);
			
			
			//TestCase#8-Verifying Daum Mail page 			
			
			SikuliUtil.verifyObjectAndClickOn("Mail", screen, parentTest, "Daum Mail link clicked", driver, testCaseName, "No");
			
			Sleep(7000);
			ReportGenerator.verifyNavigation(this.driver, "Daum Mail", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndClickOn("SignInLink", screen, parentTest,"Daum Mail Page loaded",this.driver,testCaseName,"Yes");
			Sleep(6000);
			//TestCase#9-Verifying Daum Login page
			ReportGenerator.verifyNavigation(this.driver, "Daum ë¡œê·¸ì�¸", parentTest,testCaseName,"No");
			
			screen.type("spikesqa@gmail.com");
			
			SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
			Sleep(2000);
		
			screen.type("QAqa4321!"+Key.ENTER);
			Sleep(6000);
			SikuliUtil.verifyObjectAndHighlight("DaumSignInError", screen, parentTest,"Daum Login Error message validated",driver,testCaseName,"Yes");
			Sleep(4000);
			
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The DaumKR TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The DaumKR TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}