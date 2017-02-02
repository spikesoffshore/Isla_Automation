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

public class Wikihow extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Wikihow");
			
			public void navigateToURL(WebDriver driver){
				siteURL="http://www.wikihow.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Wikihow";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
	
				//Test Case 1 - Verify navigation to Wikihow
				ReportGenerator.verifyNavigation(this.driver, "wikiHow", parentTest,testCaseName,"Yes");
				
				//Test case 2 - Verify favicon of Wikihow
				SikuliUtil.verifyObjectAndHighlight("wikihow_favicon", screen, parentTest, "Verify favicon of Wikihow", driver, testCaseName, "Yes");
				
				//Test case 3 -  Veify searching blog
				SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Click inside searchbox", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.typeScreen(screen, "Blog");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Blog", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("blog_link", screen, parentTest, "Verify Blog results get searched", driver, testCaseName, "Yes");
				
				//Test case 4 - Verify navigating to blog page
				SikuliUtil.verifyObjectAndClickOn("blog_link", screen, parentTest, "Click any Blog link", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("blog_heading", screen, parentTest, "Verify navigating to Blog page", driver, testCaseName, "Yes");
				
				//Test case 5 - Verify scrolling on page
				SikuliUtil.clickRight("blog_heading", screen, parentTest, "Click left", driver, testCaseName, "No", 1);
				SikuliUtil.moveWheel(screen, 1, 25);
				Sleep(15000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("blog_heading", screen, parentTest, "Verify scrolling on page", driver, testCaseName, "Yes");
				
				//Test case 6 - Verify voting for the blog
				SikuliUtil.verifyObjectAndClickOn("rate_star", screen, parentTest, "Click on any star for rating", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("Thanks_message", screen, parentTest, "Verify voting for the blog", driver, testCaseName, "Yes");
				
				//Test case 7 - Verify navigating to home page clicking logo
				SikuliUtil.verifyObjectAndClickOn("wikihow_logo", screen, parentTest, "Click on logo", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("MainPage_url", screen, parentTest, "Verify navigating to home page by clicking logo", driver, testCaseName, "Yes");
				
				//Test case 8 - Verify login
				SikuliUtil.clickLeft("wikihow_logo", screen, parentTest, "Click left", driver, testCaseName, "No", 1);
				SikuliUtil.moveWheel(screen, 1, 10);
				Sleep(10000);
				SikuliUtil.verifyObjectAndHighlight("login_button", screen, parentTest, "Hover on login button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("Email_button", screen, parentTest, "click on email button", driver, testCaseName, "No");
				if(SikuliUtil.isPresent(screen, "username")){
					SikuliUtil.verifyObjectAndClickOn("username", screen, parentTest, "click inside username textbox", driver, testCaseName, "No");
					Sleep(2000);
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);
					Sleep(2000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_BACK_SPACE);
				}
				Sleep(4000);
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_TAB);
				Sleep(4000);
				SikuliUtil.typeScreen(screen, "QAqa4321!");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(7000);
				SikuliUtil.verifyObjectAndHighlight("myProfile_button", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				
				//Test case 9 - Verify logout
				Sleep(3000);
			    SikuliUtil.verifyObjectAndClickOn("logout_link", screen, parentTest, "Click logout link", driver, testCaseName, "No");
			    Sleep(4000);
			    SikuliUtil.verifyObjectAndHighlight("login_button", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				
				//Test case 10 -  Verify Re-loading the page

				SikuliUtil.mouseRightClick("wikihow_logo", screen);

				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Reload_button", screen, parentTest, "Verify reloading the page", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("wikihow_logo", screen, parentTest, "Page reloaded successfuly", driver, testCaseName, "Yes");
			    
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Wikihow TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Wikihow TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}	
