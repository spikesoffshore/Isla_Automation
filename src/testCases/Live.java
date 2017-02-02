package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.DriverUtil;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Live extends Base{


	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Live");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.live.com";
			driver.navigate().to(baseurl+siteURL);
			}
		

	
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Live";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//1	Verify Navigation to Live.com
				ReportGenerator.verifyNavigation(this.driver, "Sign", parentTest,testCaseName,"Yes");
				
				//2	Verify Live favicon
				SikuliUtil.verifyObjectAndHighlight("Live_Favicon", screen, parentTest,"Verify Live favicon",this.driver,testCaseName,"Yes");
				
				//3	Verify Login for Live.com
				//3-a	Enter UserName-Hit Enter
				SikuliUtil.verifyObjectAndClickOn("Live_UserName_textBox", screen, parentTest, "Entering User Name", this.driver, testCaseName, "No");
				
				
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.ENTER);
				
				Sleep(2000);
				
				//3-b	Enter Password-Hit Enter
				SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				
				Sleep(5000);
				
				//3-c	Verify Home Page for Successful Login
				SikuliUtil.verifyObjectAndHighlight("Live_Inbox_Label", screen, parentTest, "Verify Landing page for Live.com", this.driver, testCaseName, "Yes");
				
				//4	Send a email and Verify
				//4-a	Click on New
				SikuliUtil.verifyObjectAndClickOn("Live_New_Email_Button", screen, parentTest, "Click on New for composing a message", this.driver, testCaseName, "No");
				
				Sleep(3000);
				//4-b	Write To Email
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
				
				Sleep(1000);
				
				
				SikuliUtil.typeScreen(screen, Key.TAB);
				
				//4-c	Write Test Subject
				SikuliUtil.typeScreen(screen, "Test Mail"+Key.TAB);
				
				//4-d	Write test body
				SikuliUtil.typeScreen(screen, "Test mail");
				
				//4-e	Click on Send
				SikuliUtil.verifyObjectAndClickOn("Live_Send_Button", screen, parentTest, "Sending test mail", this.driver, testCaseName, "No");
				
				Sleep(4000);
				//4-f	Click on Sent Items
				SikuliUtil.verifyObjectAndClickOn("Live_Sent_Items_Label", screen, parentTest, "Clicking Sent items", this.driver, testCaseName, "No");
				
				Sleep(3000);
				
				//4-g	Verify Sent mail
				SikuliUtil.verifyObjectAndHighlight("Live_Test_Mail_Label", screen, parentTest, "Verifying Sending mail", this.driver, testCaseName, "Yes");
				
				//4-h	Delete Mail
				SikuliUtil.verifyObjectAndClickOn("Live_Delete_Mail", screen, parentTest, "Deleting test Mail", this.driver, testCaseName, "Yes");
				
				//5	Verify Main Menu items				
				SikuliUtil.verifyObjectAndClickOn("Live_Main_Menu", screen, parentTest, "Verifying Main menu", this.driver, testCaseName, "No");
			    
				//5-a	Verify Calendar Logo
				SikuliUtil.verifyObjectAndHighlight("Live_Calendar_Logo", screen, parentTest, "Verifying Calender label", this.driver, testCaseName, "No");
				
				//5-b	Verify Office Logo
				SikuliUtil.verifyObjectAndHighlight("Live_Office_Logo", screen, parentTest, "Verifying Main menu", this.driver, testCaseName, "Yes");
				
				Sleep(3000);
				
				//6	Navigate to office site
				//6-a	Click on office logo from main menu
				SikuliUtil.verifyObjectAndClickOn("Live_Office_Logo", screen, parentTest, "Navigation to Office", this.driver, testCaseName, "No");
				
				//6-b	Verify navigation to Office
				SikuliUtil.verifyObjectAndHighlight("Live_Office_Site_Logo", screen, parentTest, "Verify Successfull Navigation to Office.com", this.driver, testCaseName, "Yes");
				
				Sleep(3000);
				
				//6-c	Navigate Back to Live.com
				DriverUtil.navigateBack(this.driver);
				
				Sleep(2000);
				
				//7	Create a new Word document and verify 				
				SikuliUtil.verifyObjectAndClickOn("Live_Main_Menu", screen, parentTest, "Clicking on Main menu", this.driver, testCaseName, "No");
				
				//7-a	Click on word Online from main menu
				SikuliUtil.verifyObjectAndClickOn("Live_Word_Logo", screen, parentTest, "Going to create a new Test document....wheeeeee", this.driver, testCaseName, "No");
				
				Sleep(2000);
				
				//7-b	Click on New Blank Document and Verify
				SikuliUtil.verifyObjectAndClickOn("Live_New_Blank_Document", screen, parentTest, "Creating new blank document", this.driver, testCaseName, "No");
				
				Sleep(5000);
				
				SikuliUtil.verifyObjectAndHighlight("Live_Word_Online", screen, parentTest, "Verifying successfull Opening of blank document", this.driver, testCaseName, "Yes");
				
				Sleep(11000);
				
				//7-c	Type in the New Blank Document
				SikuliUtil.typeScreen(screen, "Writing in the test document for fun...");
				
				
				
				Sleep(5000);
				
				//7-d	Verify the Document Saved to OneDrive Label
				SikuliUtil.verifyObjectAndHighlight("Live_Document_Saved", screen, parentTest, "Verifying Saved Document on One Drive", this.driver, testCaseName, "Yes");
				
				Sleep(3000);
				
				//7-d	Close the tab
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL,KeyEvent.VK_W );
				
				Sleep(1000);
				
				//8	Verify Logout
				//8-a	Click on Profile Icon
				SikuliUtil.verifyObjectAndClickOn("Live_Profile_Icon", screen, parentTest, "Clicking on Profile Icon", this.driver, testCaseName, "No");
				
				//8-b	Click on Logout
				SikuliUtil.verifyObjectAndClickOn("Live_Sign_Out", screen, parentTest, "Clicking On Sign-Out", this.driver, testCaseName, "No");
				
				Sleep(3000);
				
				//8-c	Verify Logout Landing-MSN Home
				SikuliUtil.verifyObjectAndHighlight("Live_Sign_Out_MSN", screen, parentTest, "Logging out of Live", this.driver, testCaseName, "Yes");
				
				
				//Rest to be looked at home....maybe have to write a function to switch tabs and also a way to give the test document a name that we can verify on One Drive
				
			}catch(Exception e){
				
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The Live.com TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				
				
			}
			finally{
			quitDriver(this.driver);
				path=currentSitePath;
			ReportGenerator.flushReportToDisk(parentTest);
			}	
		}
}