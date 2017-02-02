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

public class WashingtonPost extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing WashingtonPost");
			
			public void navigateToURL(WebDriver driver){
				siteURL="https://www.washingtonpost.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/WashingtonPost";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
	
				//Test Case 1 - Verify navigation to WashingtonPost
				ReportGenerator.verifyNavigation(this.driver, "The Washington Post", parentTest,testCaseName,"Yes");
				
				//Test case 2 - Verify scrolling
				SikuliUtil.clickLeft("washington_HomeLogo", screen, parentTest, "Click left", driver, testCaseName, "No", 1);
				SikuliUtil.moveWheel(screen, 1, 25);
				Sleep(15000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("selected_US&world", screen, parentTest, "Verify scrolling on page", driver, testCaseName, "Yes");
				
				//Test case 3 - Verify opening the Sections menu
				SikuliUtil.verifyObjectAndClickOn("Section_menu", screen, parentTest, "Verify cliking Sections menu button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("politics_Inmenu", screen, parentTest, "Verify opening the Sections menu", driver, testCaseName, "Yes");
			
				//Test case 4 - Verify scrolling inside menu
				SikuliUtil.moveWheel(screen, 1, 50);
				Sleep(20000);
				SikuliUtil.verifyObjectAndHighlight("privacy_policy", screen, parentTest, "Verify scrolling inside menu", driver, testCaseName, "Yes");
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				Sleep(5000);
				//Test case 5 - Verify changing editions
				SikuliUtil.verifyObjectAndClickOn("regional_link", screen, parentTest, "Verify cliking Regional link", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("selected_regional", screen, parentTest, "Verify edition changed to Regional", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("US&world_link", screen, parentTest, "Verify cliking Sections menu button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("selected_US&world", screen, parentTest, "Verify editions are changing successfully", driver, testCaseName, "Yes");
				
				//Test case 6 - Verify navigating to Sports tab
				SikuliUtil.verifyObjectAndClickOn("sports_tab", screen, parentTest, "Verify cliking Sports tab", driver, testCaseName, "No");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Sports", parentTest,testCaseName,"Yes");
				
				//Test case 7 - Verify seaching US news
				
				SikuliUtil.verifyObjectAndClickOn("search_button", screen, parentTest, "Click Search button", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.typeScreen(screen, "US");
				Sleep(4000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Search", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("us_word", screen, parentTest, "Verify US results get searched", driver, testCaseName, "Yes");
				
				//Test case 8 - Verify login
				SikuliUtil.verifyObjectAndClickOn("signIn_button", screen, parentTest, "click signIn button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("SignInwithEmail_button", screen, parentTest, "click signIn with Email button", driver, testCaseName, "No");
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
				SikuliUtil.verifyObjectAndHighlight("username_button", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				
				//Test case 9 - Verify logout
			    SikuliUtil.verifyObjectAndClickOn("username_button", screen, parentTest, "click username button", driver, testCaseName, "No");
			    SikuliUtil.verifyObjectAndClickOn("logout_link", screen, parentTest, "Click logout link", driver, testCaseName, "No");
			    Sleep(3000);
			    SikuliUtil.verifyObjectAndHighlight("SignOut_message", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				
				//Test case last - Verify favicon of WashingtonPost
				SikuliUtil.verifyObjectAndHighlight("washington_favicon", screen, parentTest, "Verify favicon of WashingtonPost", driver, testCaseName, "Yes");
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The WashingtonPost TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The WashingtonPost TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}	
