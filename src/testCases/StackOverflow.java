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

public class StackOverflow extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing StackOverflow");
			
			public void navigateToURL(WebDriver driver){
				siteURL="https://www.stackoverflow.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/StackOverflow";
			
			navigateToURL(this.driver);
			
			Sleep(25000);

			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				//Test Case 1 -  Verify navigation to Stack Overflow
				ReportGenerator.verifyNavigation(this.driver, "Stack Overflow", parentTest,testCaseName,"Yes");
				
				//Test Case 2 - Verify StackOverflow Favicon
				SikuliUtil.verifyObjectAndHighlight("Stackoverflow_Favicon", screen, parentTest, "Verify StackOverflow Favicon", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndHighlight("Stackoverflow_Logo", screen, parentTest, "Verify StackOverflow Logo", driver, testCaseName, "No");
				SikuliUtil.moveWheel(screen, 1, 15);
				Sleep(15000);
				//Loggers.writeInfoLog("Scrolling done successfully....");
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_HOME);
				Sleep(5000);
				
				//Test Case 3 - Verify Login
				
				if(SikuliUtil.isPresent(screen, "Username_button")){
					SikuliUtil.verifyObjectAndClickOn("StackExchange_link", screen, parentTest, "Verify clicking on StackExchange link", driver, testCaseName, "No");
					SikuliUtil.verifyObjectAndClickOn("Logout_link", screen, parentTest, "Verify clicking on Logout link", driver, testCaseName, "No");
					SikuliUtil.verifyObjectAndClickOn("Logout_button", screen, parentTest, "Verify clicking on Logout buttton", driver, testCaseName, "No");
				}
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("LogIn_link", screen, parentTest, "Verify clicking on LogIn link", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Email_Textbox", screen, parentTest, "Verify Email textbox is editable", driver, testCaseName, "No");
				
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(1000);
				SikuliUtil.typeScreen(screen, "QAqa4321");
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(5000);
				
				SikuliUtil.verifyObjectAndHighlight("Username_button", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndHighlight("Stackoverflow_Favicon", screen, parentTest, "Verify StackOverflow Favicon", driver, testCaseName, "No");
				
				//Testcase 4 - Verify navigating on Questions tab
				SikuliUtil.verifyObjectAndClickOn("Questions_tab", screen, parentTest, "Verify navigating on Questions page", driver, testCaseName, "Yes");
				ReportGenerator.verifyNavigation(this.driver, "Newest Questions", parentTest,testCaseName,"No");
				
				//Testcase 5 - Verify searching Java specific questions
				Sleep(2000);
				SikuliUtil.verifyObjectAndType("SarchBox", screen, parentTest, "Verify searching Java specific questions", driver, testCaseName, "Yes", "java");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(3000);
				ReportGenerator.verifyNavigation(this.driver, "Newest 'java' Questions", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Java_In_Searchbox", screen, parentTest, "Verify [java] text visible in searchbox", driver, testCaseName, "No");
				
				
				//Testcase 6 - Verify navigating on Home page by clicking Home button
				SikuliUtil.verifyObjectAndClickOn("Stackoverflow_Logo", screen, parentTest, "Verify navigating on Home page by clicking Home button", driver, testCaseName, "Yes");
				ReportGenerator.verifyNavigation(this.driver, "Stack Overflow", parentTest,testCaseName,"No");
				
				//Testcase 7 - Verify navigating on Favorite Question Badge page
				SikuliUtil.verifyObjectAndClickOn("Badges_tab", screen, parentTest, "Verify navigating on Badges page", driver, testCaseName, "No");
				ReportGenerator.verifyNavigation(this.driver, "Badges", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndClickOn("FavoriteQuestion_badge", screen, parentTest, "Verify navigating on Favorite Question Badge page", driver, testCaseName, "No");
				Sleep(3000);
				ReportGenerator.verifyNavigation(this.driver, "Favorite Question - Badge", parentTest,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndHighlight("FavoriteQuestion_rule", screen, parentTest, "Verify rule of favorite question", driver, testCaseName, "No");
				
				//Testcase 8 - Verify answer given by user
				SikuliUtil.verifyObjectAndClickOn("Username_button", screen, parentTest, "Verify navigating on User Activity page", driver, testCaseName, "No");
				ReportGenerator.verifyNavigation(this.driver, "user7344786", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndClickOn("Profile_answers_tab", screen, parentTest, "Verify navigating to answers tab on User Activity page", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("AnswersBy_user", screen, parentTest, "Verify user has not given any answer", driver, testCaseName, "Yes");
				
				//Testcase 9 - Verify questions asked by user
				SikuliUtil.verifyObjectAndClickOn("Profile_questions_tab", screen, parentTest, "Verify navigating to questions tab on User Activity page", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("QuestionsBy_user", screen, parentTest, "Verify user has not asked any question", driver, testCaseName, "Yes");
		
				//Testcase 10 - Verify Initial reputaion of user
				SikuliUtil.verifyObjectAndClickOn("Profile_reputation_tab", screen, parentTest, "Verify navigating to reputaion tab on User Activity page", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("Initial_reputaion", screen, parentTest, "Verify initial reputation of user is 1", driver, testCaseName, "Yes");
				
				//Testcase 11 - Verify logout
				SikuliUtil.verifyObjectAndClickOn("StackExchange_link", screen, parentTest, "Verify clicking on StackExchange link", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Logout_link", screen, parentTest, "Verify clicking on Logout link", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Logout_button", screen, parentTest, "Verify clicking on Logout buttton", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("LogIn_link", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				
			    
				
				
				
				
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The StackOverflow TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
			}catch(Exception e){
				
				
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The StackOverflow TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			quitDriver(this.driver);
			path=currentSitePath;
			ReportGenerator.flushReportToDisk(parentTest);
			}


			
}}

