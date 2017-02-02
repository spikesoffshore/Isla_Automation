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

public class Salesforce extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Salesforce");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.salesforce.com";
			driver.navigate().to(baseurl+siteURL);
			driver.manage().window().maximize();
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Salesforce";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "Salesforce.com", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Salesforce_Favicon", screen, parentTest,"Verify Salesforce favicon",driver,testCaseName,"Yes");
			
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Salesforce Home Logo",driver,testCaseName,"No");
				
				//TestCase#3-Verify Products category page
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Products", screen, parentTest,"Verify Products category",driver,testCaseName,"No");
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Salesforce Products", parentTest,testCaseName,"No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Salesforce_Favicon", screen, parentTest,"Salesforce Products category page loaded",driver,testCaseName,"Yes");
				
				screen.wheel(1, 15);			
				Sleep(4000);
				
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
							
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Salesforce.com", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Salesforce Home Logo",driver,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Salesforce_Favicon", screen, parentTest,"Verify Salesforce Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
								
				//TestCase#5-Verifying Salesforce Services sub menu category page
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("Services", screen, parentTest,"Hovering Salesforce Services category",driver,testCaseName,"No");
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("ServicesSubMenu", screen, parentTest,"Clicking Services sub menu category",driver,testCaseName,"No");
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Salesforce Success", parentTest,testCaseName,"No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Salesforce_Favicon", screen, parentTest,"Salesforce Services sub menu category page loaded",driver,testCaseName,"Yes");
				Sleep(4000);
					
				
				//TestCase#6-Verifying Login functionality	
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				
				Sleep(8000);
				
				screen.type("spikesqa@gmail.com");
				
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(14000);
				ReportGenerator.verifyNavigation(this.driver, "Home", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Salesforce_Favicon", screen, parentTest,"Verify Salesforce favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				
				//TestCase#7-Verify Dashboard tab page
				
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Dashboards", screen, parentTest, "Verify Dashboard tab link on Salesforce", driver, testCaseName, "No");
				
				Sleep(4000);
				
				ReportGenerator.verifyNavigation(this.driver, "Dashboards", parentTest,testCaseName,"No");
			
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Salesforce_Favicon", screen, parentTest,"Dashboard tab page loaded",driver,testCaseName,"Yes");
				
						
				Sleep(2000);
				//TestCase#8-Verifying Search functionality	
				SikuliUtil.verifyObjectAndType("SearchTextBox", screen, parentTest, "Verify Search Textbox", driver, testCaseName, "No", "spikes qa");
				
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				
				Sleep(10000);	
				ReportGenerator.verifyNavigation(this.driver, "Search Results", parentTest,testCaseName,"No");
				
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Salesforce_Favicon", screen, parentTest,"Salesforce Favicon Highlighted",driver,testCaseName,"No");
				
				
				SikuliUtil.verifyObjectAndClickOn("SearchResult", screen, parentTest, "Search Functionality working fine", driver, testCaseName, "Yes");
				//TestCase#9-Verify Salesforce User datails page
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "spikes qa", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("UserDetails", screen, parentTest,"Verified Salesforce User details page",driver,testCaseName,"Yes");
				
				
				
				Sleep(3000);
				screen.wheel(1, 15);			
				Sleep(4000);
				
				//TestCase#10-Verifying Signout Functionality
				
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest, "Spikes user profile icon clicked", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Logout Button", driver, testCaseName, "No");
				
				Sleep(8000);
				ReportGenerator.verifyNavigation(this.driver, "Login", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Salesforce_Favicon", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				
				
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Salesforce TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Salesforce TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		