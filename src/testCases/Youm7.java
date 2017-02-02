package testCases;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Youm7 extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Youm7");
			
			public void navigateToURL(WebDriver driver){
				siteURL="http://www.youm7.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Youm7";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
				
				//Test Case 1 - Verify navigating to Youm7
				
				SikuliUtil.verifyObjectAndHighlight("youm7HomePage_title", screen, parentTest,"Verify navigation to Youm7", driver, testCaseName, "Yes");
				   
				//Test case 3 - Verify TV sub tab under more tab
				SikuliUtil.verifyObjectAndHighlight("more_tab", screen, parentTest,"Hover on more tab", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("tv_subTab", screen, parentTest,"Verify TV sub tab under more tab", driver, testCaseName, "Yes");
				
				//Test case 3 - Verify scrolling on Page
				SikuliUtil.moveWheel(screen, 1, 25);
				Sleep(15000);
				SikuliUtil.verifyObjectAndHighlight("PageUp_button", screen, parentTest,"Verify scrolling on Page", driver, testCaseName, "Yes");
				Sleep(5000);
				
				//Test case 4 -  Verify navigating to sport page
				SikuliUtil.verifyObjectAndClickOn("sport_tab", screen, parentTest, "Click on sport tab", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("SportPage_heading", screen, parentTest, "Verify navigating to sport page", driver, testCaseName, "Yes");
				
				//Test case 5 -  Verify navigating to Home page by clicking home button
				SikuliUtil.verifyObjectAndClickOn("home_button", screen, parentTest, "Click on Home button", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("youm7HomePage_title", screen, parentTest, "Verify navigating to Home page by clicking home button", driver, testCaseName, "Yes");
				
				
				//Test case 6 - Verify searching  Barcelona news
				
				SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Click inside searchbox", driver, testCaseName, "No");
				Sleep(4000);
				screen.paste("برشلونة");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("DetailSearch_Button", screen, parentTest, "Verify navigation to search page", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("Barcelona_inSearchbox", screen, parentTest, "Verify searching  Barcelona news", driver, testCaseName, "Yes");
				
				//Test case 7 - Verify searching Barcelona news in Detail
				SikuliUtil.verifyObjectAndClickOn("DetailSearch_Button", screen, parentTest, "Verify clicking Detail_Search button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("Options", screen, parentTest, "Verify clicking on option dropdown", driver, testCaseName, "No");
				Sleep(4000);
				if(SikuliUtil.isPresent(screen, "news_option")){
					SikuliUtil.verifyObjectAndClickOn("news_option", screen, parentTest, "Verify clicking on news option", driver, testCaseName, "No");
				}else{
					SikuliUtil.verifyObjectAndClickOn("BreakingNews_option", screen, parentTest, "Verify clicking on  Breaking news option", driver, testCaseName, "No");
				}
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("search_button", screen, parentTest, "Verify clicking on search button", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("DetailSearch_Button", screen, parentTest, "Verify navigation to search page", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("Barcelona_inSearchbox", screen, parentTest, "Verify searching Barcelona news in Detail", driver, testCaseName, "Yes");
				
				//Test case 8 - verify displayed search results are of 1st page
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("selected_1Page", screen, parentTest, "verify displayed search results are of 1st page", driver, testCaseName, "Yes");
				
				
				
				//Test case 9 - To do -- Verify favicon of Youm7 as issue
				
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Youm7 TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Youm7 TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
	}
}			
