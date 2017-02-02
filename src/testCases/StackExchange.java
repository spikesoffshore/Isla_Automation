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

public class StackExchange extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing StackExchange");
			
			public void navigateToURL(WebDriver driver){
				siteURL="http://stackexchange.com/";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/StackExchange";
			
			navigateToURL(this.driver);
			
			Sleep(25000);

			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				//Test Case 1 - Verify navigation to Stack Exchange
				ReportGenerator.verifyNavigation(this.driver, "Stack Exchange", parentTest,testCaseName,"Yes");
				
				//Test Case 2 - Verify StackExchange Favicon
				SikuliUtil.verifyObjectAndHighlight("StackExchange_favicon", screen, parentTest, "Verify StackExchange Favicon", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndHighlight("StackExchange_logo", screen, parentTest, "Verify StackExchange Logo", driver, testCaseName, "No");
				
				//Test Case 3 - Verify LogIn
				
				SikuliUtil.verifyObjectAndClickOn("LogIn_link", screen, parentTest, "Verify clicking on LogIn link", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("StackExchange_login_button", screen, parentTest, "Verify clicking on login button", driver, testCaseName, "No");
				Sleep(3000);
				if(SikuliUtil.isPresent(screen, "username_textbox")){
					SikuliUtil.verifyObjectAndClickOn("username_textbox", screen, parentTest, "Verify username is editable", driver, testCaseName, "No");
					SikuliUtil.typeScreen(screen, "spikesqa@gmail.com");
					Sleep(2000);
					SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
					Sleep(1000);
					SikuliUtil.typeScreen(screen, "QAqa4321");
					Sleep(2000);
					SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
					
				}
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("StackExchange_favicon", screen, parentTest, "Verify StackExchange Favicon", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("StackExchange_user", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				
				//testcase 4 Verify viewing filtered questions using created filter
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("FilteredQuestions_tab", screen, parentTest, "Verify clicking Filtered Quetion tab", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Java_filter", screen, parentTest, "Verify viewing filtered questions using created filter", driver, testCaseName, "Yes");
				
				//testcase 5 - Verify navigating All Sites tab
				SikuliUtil.verifyObjectAndClickOn("allSites_tab", screen, parentTest, "Verify clicking All Sites tab", driver, testCaseName, "No");
				ReportGenerator.verifyNavigation(this.driver, "All Sites", parentTest,testCaseName,"Yes");
				SikuliUtil.moveWheel(screen, 1, 15);
				Sleep(12000);
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_HOME);
				Sleep(7000);
				
				//testcase 6 - Verify nevigating on Home page by clicking Home button
				SikuliUtil.verifyObjectAndClickOn("StackExchange_Logo", screen, parentTest, "Verify nevigating on Home page by clicking Home button", driver, testCaseName, "Yes");
				ReportGenerator.verifyNavigation(this.driver, "Stack Exchange", parentTest,testCaseName,"No");
				
				
			
				//Testcase 7- Verify searching Stack Overflow site
				Sleep(2000);
				SikuliUtil.verifyObjectAndType("searchbox", screen, parentTest, "Verify searching Stack Overflow site", driver, testCaseName, "No", "Stack Overflow");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(3000);
				ReportGenerator.verifyNavigation(this.driver, "Search the Stack Exchange", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("StackOverflow_title", screen, parentTest, "Verify Stack overflow searched", driver, testCaseName, "Yes");
				
				
			   // Testcase 8 - Verify User also found logged in on Stack Exhange network site - Stack overflow
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("StackOverflow_title", screen, parentTest, "Verify nevigating to Stack overflow", driver, testCaseName, "No");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Stack Overflow", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Username_button", screen, parentTest, "User also found logged in on Stack Exhange network site - Stack overflow", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("back_button", screen, parentTest, "Verify nevigating back to Stack Exchange", driver, testCaseName, "No");
				Sleep(3000);
				
				//Testcase 9 - Verify questions and answers given by user
				SikuliUtil.verifyObjectAndClickOn("StackExchange_user", screen, parentTest, "Verify nevigating on User Info page", driver, testCaseName, "No");
				ReportGenerator.verifyNavigation(this.driver, "user7344786", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndClickOn("user_account", screen, parentTest, "Verify nevigating to accounts tab on User info. page", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("0_question", screen, parentTest, "Verify user has not asked any question", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("0_answer", screen, parentTest, "Verify user has neither asked any question nor given any answer", driver, testCaseName, "Yes");
					
				//Testcase 10 - Verify logout
				SikuliUtil.verifyObjectAndClickOn("StackExchange_link", screen, parentTest, "Verify clicking on StackExchange link", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Logout_link", screen, parentTest, "Verify clicking on Logout link", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("logout_checkbox", screen, parentTest, "Verify clicking on Logout checkbox", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("logout_button", screen, parentTest, "Verify clicking on Logout buttton", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("LogIn_link", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The StackExchange TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
			}catch(Exception e){
				
				
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The StackExchange TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			quitDriver(this.driver);
			path=currentSitePath;
			ReportGenerator.flushReportToDisk(parentTest);
			}


			
}}

