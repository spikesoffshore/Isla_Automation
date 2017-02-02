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

public class Msn extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Msn");
	
	public void navigateToURL(WebDriver driver){
		siteURL="https://www.msn.com";
		driver.navigate().to(baseurl+siteURL);
		}
	

		@Test	
		public void executeScript() throws IOException {
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Msn";
		
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		//ReportGenerator.logStatusInfo(parentTest,"Verify Navigation to Msn ", "Navigated successfully to the Msn");
						
		try{
			
			Loggers.startCurrentTestCaseExecution(this.driver);
		
			//TestCase#1-Verifying Navigation to home page
			ReportGenerator.verifyNavigation(this.driver, "MSN.com", parentTest,testCaseName,"Yes");
			//TestCase#2-Verifying Favicon 
			SikuliUtil.verifyObjectAndHighlight("Msn_Favicon", screen, parentTest,"Verify Msn favicon",driver,testCaseName,"Yes");
			//TestCase#3-Verify Trending Now page								
			SikuliUtil.verifyObjectAndClickOn("TrendingNowlink", screen, parentTest, "Verify Trending Now page", driver, testCaseName, "No");
			
			
						
			ReportGenerator.verifyNavigation(this.driver, "News",parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("Msn_Favicon", screen, parentTest,"Msn Trending now news page navigated successfully",driver,testCaseName,"Yes");
									
			Sleep(2000);
			SikuliUtil.moveWheel(screen, 1, 15);
			Sleep(5000);
			Loggers.writeInfoLog("Wheel movement Done");
			
			
			//TestCase#4-Verifying Alt+Left Key press functionality
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			Loggers.writeInfoLog("Navigated back to home page");
			Sleep(3000);
			
			ReportGenerator.verifyNavigation(this.driver, "MSN.com", parentTest,testCaseName,"No");
			SikuliUtil.verifyObjectAndHighlight("Msn_Favicon", screen, parentTest,"Verify navigating back to home page",driver,testCaseName,"Yes");
			
						
			//TestCase#5-Verifying Login functionality	
			SikuliUtil.verifyObjectAndClickOn("SignIn", screen, parentTest, "Verify Sign In link", driver, testCaseName, "No");
			
			Sleep(3000);
			
			screen.type("spikesqa@gmail.com");
			Sleep(4000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(4000);
			screen.type("QAqa4321!"+Key.ENTER);
			Sleep(7000);
			Loggers.writeInfoLog("Username and password for MSN login added");
			
			SikuliUtil.verifyObjectAndHighlight("Msn_Favicon", screen, parentTest,"Verify Msn favicon",this.driver,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("LoggedIn", screen, parentTest,"Msn user logged in Functionality",driver,testCaseName,"Yes");
			
			//TestCase#6-Verify Money Tab
			SikuliUtil.verifyObjectAndClickOn("Money", screen, parentTest, "Verify Clicking on Money Tab", driver, testCaseName, "No");
			
			Sleep(4000);
			
			SikuliUtil.verifyObjectAndHighlight("Msn_Favicon", screen, parentTest,"Verify Msn favicon",driver,testCaseName,"No");
			
			ReportGenerator.verifyNavigation(this.driver, "Stock quotes",parentTest,testCaseName,"No");
			SikuliUtil.verifyObjectAndHighlight("Msn_Favicon", screen, parentTest,"Money Tab navigated validation done",driver,testCaseName,"Yes");
			
						
			Sleep(3000);
			SikuliUtil.moveWheel(screen, 1, 15);
			Loggers.writeInfoLog("Wheel movement Done");
			Sleep(7000);
			//TestCase#7-Verifying Search functionality	
			
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			
			Sleep(4000);
			
			SikuliUtil.verifyObjectAndType("SearchTextBox", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "Shah Rukh Khan");
			
			Sleep(3000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
		
			Sleep(10000);	
			
			SikuliUtil.verifyObjectAndHighlight("SearchResult",screen, parentTest,"Search Functionality working fine",driver,testCaseName,"Yes");
			
			Sleep(3000);
			
			SikuliUtil.moveWheel(screen, 1, 15);
			
			Loggers.writeInfoLog("Wheel movement Done");
			
			Sleep(6000);
			
			//TestCase#8-Web Browser tab shift functionality
			
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_TAB);
			
						
			SikuliUtil.verifyObjectAndHighlight("Msn_Favicon", screen, parentTest,"Verify Msn favicon",driver,testCaseName,"No");
			
			ReportGenerator.verifyNavigation(this.driver, "MSN.com",parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("Msn_Favicon", screen, parentTest,"Web Browser tab shift functionality working fine",driver,testCaseName,"Yes");
			
			Sleep(3000);
			
			//TestCase#9-Verifying Signout Functionality
			
			SikuliUtil.verifyObjectAndClickOn("LoggedIn", screen, parentTest, "Msn user logged in link clicked", driver, testCaseName, "No");
			
			
			Sleep(4000);
			
			SikuliUtil.verifyObjectAndClickOn("LogoutText", screen, parentTest, "Signout link", driver, testCaseName, "No");
			
			Sleep(6000);
			SikuliUtil.verifyObjectAndHighlight("Msn_Favicon", screen, parentTest,"Verify Msn favicon",this.driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("SignIn", screen, parentTest,"Msn user logout Functionality",this.driver,testCaseName,"Yes");
		
			Sleep(4000);
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The MSN TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
			
		}catch(Exception e){
		Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The Msn TestCase Failed,Please see logs and error screenshots", driver);
		}
		finally{
		path=currentSitePath;
		quitDriver(this.driver);
		ReportGenerator.flushReportToDisk(parentTest);
		}
	
	
	
		}
		
	
}
