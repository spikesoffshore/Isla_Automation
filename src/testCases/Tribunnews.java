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

public class Tribunnews extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Tribunnews");
			
			public void navigateToURL(WebDriver driver){
				siteURL="http://www.tribunnews.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Tribunnews";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
	
				//Test Case 1 - Verify navigation to Tribunnews
				ReportGenerator.verifyNavigation(this.driver, "Tribunnews.com", parentTest,testCaseName,"Yes");
				
				
				//Test case 2 - Verify navigating to News tab
				Sleep(4000);
				if(SikuliUtil.isPresent(screen, "close_button")){
					SikuliUtil.verifyObjectAndClickOn("close_button", screen, parentTest, "Verify closing Ad", driver, testCaseName, "No");
				}
				SikuliUtil.verifyObjectAndClickOn("news_tab", screen, parentTest, "Verify cliking News tab", driver, testCaseName, "No");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "News", parentTest,testCaseName,"Yes");
				
				//Test case 3 -  Verify searching world news
				SikuliUtil.verifyObjectAndHighlight("search_button", screen, parentTest, "Hover on search button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Click inside searchbox", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.typeScreen(screen, "Dunia");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("Dunia_word", screen, parentTest, "Verify World results get searched", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("tribunnews_logo", screen, parentTest, "Verify navigating to home page", driver, testCaseName, "No");
				
				//Test case 4 - Verify navigating to Popular news page
				Sleep(4000);
				if(SikuliUtil.isPresent(screen, "close_button")){
					SikuliUtil.verifyObjectAndClickOn("close_button", screen, parentTest, "Verify closing Ad", driver, testCaseName, "No");
				}
				Sleep(3000);
				SikuliUtil.moveWheel(screen, 1, 10);
				Sleep(10000);
				SikuliUtil.verifyObjectAndClickOn("popularNews_link", screen, parentTest, "Verify navigating to Popular news page", driver, testCaseName, "Yes");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Terpopuler", parentTest,testCaseName,"No");
				
				//Test case 5 - Verify scrolling on Page
				SikuliUtil.clickLeft("tribunnews_logo", screen, parentTest, "Click left", driver, testCaseName, "No", 1);
				SikuliUtil.moveWheel(screen, 1, 30);
				Sleep(15000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("news_tab", screen, parentTest, "Verify scrolling on page", driver, testCaseName, "Yes");
				
				//Test case 6 - Verify navigating to 2017 Popular news page
				SikuliUtil.verifyObjectAndClickOn("2017_link", screen, parentTest, "Verify navigating to 2017 Popular news page", driver, testCaseName, "Yes");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "2017", parentTest,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndClickOn("tribunnews_logo", screen, parentTest, "Verify navigating to home page", driver, testCaseName, "No");
				Sleep(4000);
				
				if(SikuliUtil.isPresent(screen, "close_button")){
					SikuliUtil.verifyObjectAndClickOn("close_button", screen, parentTest, "Verify closing Ad", driver, testCaseName, "No");
				}
				//Test case 7 - Verify login
				SikuliUtil.verifyObjectAndClickOn("login_link", screen, parentTest, "click logi link", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("email_textbox", screen, parentTest, "click inside email textbox", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_TAB);
				Sleep(4000);
				SikuliUtil.typeScreen(screen, "QAqa4321!");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(7000);
				SikuliUtil.verifyObjectAndHighlight("username_button", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				
				//Test case 8 - Verify logout
				Sleep(3000);
			    SikuliUtil.verifyObjectAndClickOn("logout_link", screen, parentTest, "Click logout link", driver, testCaseName, "No");
			    Sleep(3000);
			    SikuliUtil.verifyObjectAndHighlight("login_link", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				
				//Test case 9 - Verify favicon of Tribunnews
				SikuliUtil.verifyObjectAndHighlight("tribunnews_favicon", screen, parentTest, "Verify favicon of Tribunnews", driver, testCaseName, "Yes");
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Tribunnews TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Tribunnews TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}	

				