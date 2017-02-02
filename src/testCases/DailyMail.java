package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class DailyMail extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing DailyMail");
			
			public void navigateToURL(WebDriver driver){
				siteURL="dailymail.co.uk";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/DailyMail";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				
				//Test Case 1 - Verify Navigation to DailyMail
				ReportGenerator.verifyNavigation(this.driver, "Daily Mail", parentTest,testCaseName,"Yes");
			
			
				//Test case 2 - Verify favicon of DailyMail
				while(!SikuliUtil.isPresent(screen, "dailymail_favicon")){
					Sleep(1000);
				}
				SikuliUtil.verifyObjectAndHighlight("dailymail_favicon", screen, parentTest, "Verify favicon of DailyMail", driver, testCaseName, "Yes");
		  
				//Test case 3 - verify navigating on Sports tab
				
				if(SikuliUtil.isPresent(screen, "sports_tab")){
					Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("sports_tab", screen, parentTest, "verify navigating on Sports tab", driver, testCaseName, "Yes");
				}
				Sleep(3000);
				ReportGenerator.verifyNavigation(this.driver, "Sport", parentTest,testCaseName,"No");
				
				
				//Test case 4 - verify navigating back to home page by home button
				Sleep(4000);
				if(SikuliUtil.isPresent(screen, "home_button"))
					Sleep(3000);
					SikuliUtil.verifyObjectAndClickOn("home_button", screen, parentTest, "verify navigating back to home page by home button", driver, testCaseName, "Yes");
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "Home", parentTest,testCaseName,"No");
				Sleep(4000);
			
				//Test case 5 - Verify page scrolled down and up 
				SikuliUtil.keyPress(robot,KeyEvent.VK_END);
				Sleep(10000);
				SikuliUtil.verifyObjectAndClickOn("top_button", screen, parentTest, "verify navigating to top of page", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("LatestHeadlines_subtab", screen, parentTest, "Page scrolled down and up successfully", driver, testCaseName, "Yes");
				
				
				//Test case 6 - verify navigating on Latest Headlines sub tab
				
				SikuliUtil.verifyObjectAndClickOn("LatestHeadlines_subtab", screen, parentTest, "verify navigating on Latest Headlines sub tab", driver, testCaseName, "Yes");
				
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "Latest Headlines", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndClickOn("home_button", screen, parentTest, "verify navigating back to home page by home button", driver, testCaseName, "No");
			
				
		
				//Test case 7 - Verify Login 
				SikuliUtil.verifyObjectAndClickOn("login_link", screen, parentTest, "verify clicking login link", driver, testCaseName,"No" );
				Sleep(4000);
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.typeScreen(screen, "QAqa4321!");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("dailymail_favicon", screen, parentTest, "Verify favicon of DailyMail", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("MyProfile_link", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				
				//Test case 8 - Verify searching Neymar news
				SikuliUtil.verifyObjectAndClickOn("MyProfile_link", screen, parentTest, "verify clicking my profile link", driver, testCaseName,"No" );
				Sleep(3000);
				SikuliUtil.verifyObjectAndType("searchbox", screen, parentTest, "Verify searching Neymar news", driver, testCaseName, "Yes", "Neymar");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Neymar", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndClickOn("home_button", screen, parentTest, "verify navigating back to home page by home button", driver, testCaseName, "No");
				Sleep(3000);
				
				//test case 9 - Verify Logout
				SikuliUtil.verifyObjectAndClickOn("logout_link", screen, parentTest, "verify clicking on logout link", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("login_link", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The DailyMail TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The DailyMail TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}
