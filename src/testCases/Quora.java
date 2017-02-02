package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Quora extends Base{

	
	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Quora");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.quora.com";
			driver.navigate().to(baseurl+siteURL);
			}
		

	
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Quora";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//1	Verify Navigation to quora.com
				ReportGenerator.verifyNavigation(this.driver, "Quora", parentTest,testCaseName,"Yes");
				
				//2	Verify Quora favicon
				SikuliUtil.verifyObjectAndHighlight("Quora_Favicon", screen, parentTest, "Verification of Quora Favicon", driver, testCaseName, "Yes");
				
				
				//3	Verify Sign-in
				//3-a	Verify Already Logged in
				if(SikuliUtil.isPresent(screen, "Quora_Already_Logged_In")){
					
					SikuliUtil.verifyObjectAndClickOn("Quora_Already_Logged_In", screen, parentTest,"Clickin on Spikes Logo to login", driver, testCaseName, "No");
				}else{
					SikuliUtil.verifyObjectAndClickOn("Quora_UserName_Textbox", screen, parentTest, "Clicking on username Textbox" , driver, testCaseName, "No");
				
					
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
				
				Sleep(2000);
				
				//3-b	Enter Password
				SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				
				Sleep(6000);}
				
				Sleep(6000);
				
				//3-c	Verify Sign in landing
				SikuliUtil.verifyObjectAndHighlight("Quora_Home_Logo", screen, parentTest, "Logging into Quora", driver, testCaseName, "Yes");
				
				//4	Verify Post new Question
				//4-a	Click on Ask Question Textbox
				SikuliUtil.verifyObjectAndClickOn("Quora_Ask_Question_TextBox", screen, parentTest, "Clicking to ask Question", driver, testCaseName, "No");
				
				Sleep(3000);
				
				//4-b	Type in the question
				SikuliUtil.typeScreen(screen, "What is the weather at "+new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date())+" in WonderlandQA");
				
				Sleep(4000);
				//4-c	Click on Ask Question Button
				SikuliUtil.verifyObjectAndClickOn("Quora_Ask_Question_Button", screen, parentTest, "Submitting Question by clicking on Ask Question Button ", driver, testCaseName, "No");
				
				Sleep(4000);
				
				//4-d	Verify Question Asked Successfully
				SikuliUtil.verifyObjectAndHighlight("Quora_Successfully_Asked", screen, parentTest, "Verification of successfull post of a question on Quora", driver, testCaseName, "Yes");
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_PAGE_DOWN);
				
				Sleep(3000);
				//5	Verify View Question functionality
				//5-a	Click on More on a question in Feed
				SikuliUtil.verifyObjectAndClickOn("Quora_View_More", screen, parentTest, "Viewing Answer", driver, testCaseName, "No");
				
				Sleep(3000);
				
				//5-b	Verify Successful opening of question
				SikuliUtil.verifyObjectAndHighlight("Quora_Successfull_Open_Question", screen, parentTest, "Verification of Question-view ", driver, testCaseName, "Yes");
				
				//6	Verify navigation to Answer Page
				//6-a	Click on Close Answer
				SikuliUtil.verifyObjectAndClickOn("Quora_Close_Answer", screen, parentTest, "Closing Answer Textbox", driver, testCaseName, "No");
				
				//6-b	Verify Navigation to Answer Page
				SikuliUtil.verifyObjectAndClickOn("Quora_Answer_Button_Home", screen, parentTest, "Click on Answer to Find Questions for Answers", driver, testCaseName, "No");
				
				Sleep(4000);
				
				//7	Verify  Answer functionality
				//7-a	Click on Answer Button
				SikuliUtil.verifyObjectAndHighlight("Quora_Answer_Page", screen, parentTest, "Navigation to Answer-Home page", driver, testCaseName, "Yes");
				
				//7-b	Higlight Answer textbox
				SikuliUtil.verifyObjectAndClickOn("Quora_Answer_Question", screen, parentTest, "Clicking on Answer to Answer a question", driver, testCaseName, "No");
				
				Sleep(3000);
				
				//8	Verify Signout
				SikuliUtil.verifyObjectAndHighlight("Quora_Write_Answer", screen, parentTest, "Verificatio of Answer Functionality on Quora", driver, testCaseName, "Yes");
				
				//8-a	Close Answer
				SikuliUtil.verifyObjectAndClickOn("Quora_Close_Answer", screen, parentTest, "Closing Answer Textbox", driver, testCaseName, "No");
				
				//8-b	Click on Profile icon
				SikuliUtil.verifyObjectAndClickOn("Quora_Profile_Icon", screen, parentTest, "Clicking on Profile Icon", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//8-c	Click on Logout
				SikuliUtil.verifyObjectAndClickOn("Quora_Logout", screen, parentTest, "Clickin on Logout", driver, testCaseName, "No");
				
				//8-d	Verify Signout Landing
				SikuliUtil.verifyObjectAndHighlight("Quora_Already_Logged_In", screen, parentTest, "Logout from Quora", driver, testCaseName, "Yes");
				
				
			}catch(Exception e){
				
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Quora TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				
			
			}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}	
		}
}
