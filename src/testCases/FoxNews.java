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

public class FoxNews extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing FoxNews");
			
			public void navigateToURL(WebDriver driver){
				siteURL="http://www.foxnews.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/FoxNews";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
	
				//Test Case 1 - Verify navigation to Fox News
				ReportGenerator.verifyNavigation(this.driver, "Fox News", parentTest,testCaseName,"Yes");
			
			
				//Test case 2 - Verify favicon of Fox News
				SikuliUtil.verifyObjectAndHighlight("foxnews_favicon", screen, parentTest, "Verify favicon of Fox News", driver, testCaseName, "Yes");
				
				//Test case 3 -  Verify Scrolling
				SikuliUtil.clickLeft("foxnews_logo", screen, parentTest, "Click left", driver, testCaseName, "No", 1);
				SikuliUtil.moveWheel(screen, 1, 20);
				Sleep(10000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("foxnews_logo", screen, parentTest, "Verify scrolling on page", driver, testCaseName, "Yes");
				
				//Test case 4 - Verify searching US news
				SikuliUtil.verifyObjectAndClickOn("searchbutton", screen, parentTest, "click search button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "click inside searchbox", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.typeScreen(screen, "US");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Search", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("us_word", screen, parentTest, "Verify searching US news", driver, testCaseName, "Yes");
				
				//Test case 5 -  Verify sorting news by date
				SikuliUtil.verifyObjectAndClickOn("date_button", screen, parentTest, "click date button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("selected_date", screen, parentTest, "Verify sorting news by date", driver, testCaseName, "Yes");
				
				//Test case 6 - Verify navigating home by home button
				SikuliUtil.verifyObjectAndClickOn("home_button", screen, parentTest, "click home button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("selected_homeTab", screen, parentTest, "Verify navigating home by home button", driver, testCaseName, "Yes");
				
				//Test case 7 - Verify Login
				SikuliUtil.verifyObjectAndClickOn("login_link", screen, parentTest, "click login link", driver, testCaseName, "No");
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
				Sleep(5000);
				SikuliUtil.verifyObjectAndClickOn("username_button", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				
				//Test case 8 - checking and unchecking check-boxes on user profile
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("profile_link", screen, parentTest, "Click profile link", driver, testCaseName, "No");
				  Sleep(5000);
				    ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(tabs4.get(1));
				    Sleep(10000);
					SikuliUtil.clickLeft("username", screen, parentTest, "Click left", driver, testCaseName, "No", 1);
					SikuliUtil.keyPress(robot, KeyEvent.VK_END);
					Sleep(5000);
					SikuliUtil.verifyObjectAndClickOn("checkbox", screen, parentTest, "Verify cliking check box", driver, testCaseName, "No");
					SikuliUtil.verifyObjectAndHighlight("selected_checkbox", screen, parentTest, "Check box checked", driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.verifyObjectAndClickOn("selected_checkbox", screen, parentTest, "Verify unchecking check box", driver, testCaseName, "No");
					SikuliUtil.verifyObjectAndHighlight("checkbox", screen, parentTest, "Check box checked and unchecked", driver, testCaseName, "Yes");
				    Sleep(5000);
					driver.close();
				    driver.switchTo().window(tabs4.get(0));
				    Sleep(6000);
				    
				    //Test case 9 - Verify logout
				    SikuliUtil.verifyObjectAndClickOn("username_button", screen, parentTest, "click username button", driver, testCaseName, "No");
				    SikuliUtil.verifyObjectAndClickOn("logout_link", screen, parentTest, "Click logout link", driver, testCaseName, "No");
				    Sleep(4000);
				    SikuliUtil.verifyObjectAndHighlight("login_link", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				    
				    //Test case 10 - Verify navigating to Fox Business
				    SikuliUtil.verifyObjectAndClickOn("fox_business", screen, parentTest, "Click Fox Business link", driver, testCaseName, "No");
				    Sleep(5000);
				    ReportGenerator.verifyNavigation(this.driver, "Fox Business", parentTest,testCaseName,"Yes");
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The FoxNews TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The FoxNews TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}	

			