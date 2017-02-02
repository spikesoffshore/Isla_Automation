package testCases;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Vice extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Vice");
			
			public void navigateToURL(WebDriver driver){
				siteURL="https://www.vice.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Vice";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
	
				//Test Case 1 - Verify navigation to Vice
				ReportGenerator.verifyNavigation(this.driver, "VICE", parentTest,testCaseName,"Yes");
			
			
				//Test case 2 - Verify favicon of Vice
				SikuliUtil.verifyObjectAndHighlight("Vice_favicon", screen, parentTest, "Verify favicon of Vice", driver, testCaseName, "Yes");
				
				//Test case 3 - Verify opening and closing Vice menu
				SikuliUtil.verifyObjectAndClickOn("vice_menu", screen, parentTest, "Verify cliking Vice menu button", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("close_button", screen, parentTest, "Vice menu opened", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("close_button", screen, parentTest, "Verify closing Vice menu", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("vice_menu", screen, parentTest, "Vice menu opened and closed successfully", driver, testCaseName, "Yes");
				Sleep(3000);
				
				//Test case 4 - Verify navigating to Read page
				SikuliUtil.verifyObjectAndClickOn("vice_menu", screen, parentTest, "Verify cliking Vice menu button", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("read_tab", screen, parentTest, "Verify cliking read tab", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("read_word", screen, parentTest, "Verify navigating to Read page", driver, testCaseName, "Yes");
				
				//Test case 5 - Verify 1st page of Read tab is open
				SikuliUtil.clickLeft("vice_logo", screen, parentTest, "Click left", driver, testCaseName, "No", 1);
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("first_page", screen, parentTest, "Verify 1st page of read tab is open", driver, testCaseName, "Yes");
				
				//Test case 6 - Verify navigating 2nd page of Read tab
				SikuliUtil.verifyObjectAndClickOn("nextPage_button", screen, parentTest, "Verify cliking next button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("2_page", screen, parentTest, "Verify navigating 2nd page of Read tab", driver, testCaseName, "Yes");
				
				//Test case 7 - Verify searching US results
				SikuliUtil.verifyObjectAndClickOn("vice_menu", screen, parentTest, "Verify cliking Vice menu button", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "VClick inside searchbox", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.typeScreen(screen, "US");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Search Results", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("us_word", screen, parentTest, "Verify US results get searched", driver, testCaseName, "Yes");
				
				//Test case 8- Verify scrolling
				SikuliUtil.clickLeft("vice_logo", screen, parentTest, "Click left", driver, testCaseName, "No", 1);
				SikuliUtil.moveWheel(screen, 1, 20);
				Sleep(10000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("us_word", screen, parentTest, "Verify scrolling on page", driver, testCaseName, "Yes");
				
				//Test case 9 - Reloading page
				SikuliUtil.mouseRightClick("vice_logo", screen);

				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Reload_button", screen, parentTest, "Verify reloading the page", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("vice_logo", screen, parentTest, "Page reloaded successfuly", driver, testCaseName, "Yes");
				
				//Test case 10 - Verify scrolling inside menu
				SikuliUtil.verifyObjectAndClickOn("vice_menu", screen, parentTest, "Verify cliking Vice menu button", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("read_tab", screen, parentTest, "Highlight read tab", driver, testCaseName, "No");
				SikuliUtil.moveWheel(screen, 1, 25);
				Sleep(20000);
				SikuliUtil.verifyObjectAndHighlight("Magazine_word", screen, parentTest, "Verify scrolling inside menu", driver, testCaseName, "Yes");
				
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Vice TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Vice TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}	
