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

public class LivedoorJP extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Livedoor");
			
			public void navigateToURL(WebDriver driver){
				siteURL="http://www.livedoor.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/LivedoorJP";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
				
				//Test Case 1 - Verify navigating to Livedoor
				
				ReportGenerator.verifyNavigation(driver, "livedoor", parentTest, testCaseName, "Yes");
		
				//Test case 2 - Verify Livedoor favicon
	
				SikuliUtil.verifyObjectAndHighlight("livedoor_favicon", screen, parentTest,"Verify Livedoor favicon", driver, testCaseName, "Yes");
				
				//Test case 3 -  Verify Mejor news tab is opened By Default
				
				SikuliUtil.clickLeft("selected_mejorTab", screen, parentTest, "Verify Mejor news tab is", driver, testCaseName, "Yes", 1);
				
				//Test case 4 - Verify scrolling on page
				SikuliUtil.moveWheel(screen, 1, 25);
				Sleep(15000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("selected_mejorTab", screen, parentTest, "Verify scrolling on page", driver, testCaseName, "Yes");
				
				//Test case 5 - Verify opening list of Sub tabs under All Drop Down
				SikuliUtil.verifyObjectAndClickOn("all_tab", screen, parentTest, "Click on All Dropdown", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("opened_allTab", screen, parentTest,"Verify opening list of Sub tabs under All Drop Down", driver, testCaseName, "Yes");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("opened_allTab", screen, parentTest,"Close Drop Down", driver, testCaseName, "No");
				
				//Test case 6 - Verify opening Sports Tab
				SikuliUtil.verifyObjectAndClickOn("sports_Tab", screen, parentTest, "Click on Sports tab", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("selected_sportsTab", screen, parentTest,"Verify opening Sports Tab", driver, testCaseName, "Yes");
				
				//Test case 7 - Verify navigating to news page
				SikuliUtil.verifyObjectAndClickOn("news_tab", screen, parentTest, "Click on News tab", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("NewsPage_logo", screen, parentTest,"Verify navigating to news page", driver, testCaseName, "Yes");
				
				//Test case 8 - Verify navigating to Today's News page
				SikuliUtil.verifyObjectAndClickOn("Today'sNews_tab", screen, parentTest, "Click on Today's News tab", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("Today'sNews_heading", screen, parentTest,"Verify navigating to Today's News page", driver, testCaseName, "Yes");
				
				//Test case 9 - Verify navigating back to Livedoor main page
				SikuliUtil.verifyObjectAndClickOn("livedoor_link", screen, parentTest, "Click on livedoor link", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("livedoor_logo", screen, parentTest,"Verify navigating back to Livedoor main page", driver, testCaseName, "Yes");
				

				//Test case 10 - Reloading the page
				Sleep(2000);
		
				SikuliUtil.mouseRightClick("livedoor_logo", screen);

				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Reload_button", screen, parentTest, "Verify reloading the page", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("livedoor_logo", screen, parentTest, "Page reloaded successfuly", driver, testCaseName, "Yes");
				
				
						Sleep(4000);
						ReportGenerator.logStatusPass(parentTest, testCaseName, "The Livedoor TestCase is working as expected");
						Loggers.stopCurrentTestCaseExecution(testCaseName);
								
						}catch(Exception e){
							
					
							
							//In case of failure, mention the same in logs and Report
							Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
							System.out.println(e);
							ReportGenerator.logStatusFail(parentTest,testCaseName, "The Livedoor TestCase Failed,Please see logs and error screenshots", this.driver);
						}
							finally{
								quitDriver(this.driver);
								path=currentSitePath;
								ReportGenerator.flushReportToDisk(parentTest);
							}
			}
		}			
