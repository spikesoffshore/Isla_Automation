package testCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Tumblr extends Base {

	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Tumblr");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.tumblr.com";
			driver.navigate().to(baseurl+siteURL);
			}
		
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Tumblr";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//1	Verify Navigation to Tumblr.com
				ReportGenerator.verifyNavigation(this.driver, "Tumblr", parentTest,testCaseName,"Yes");
				
				//2	Verify Tumblr favicon
				SikuliUtil.verifyObjectAndHighlight("Tumblr_Favicon", screen, parentTest,"Verify Tumblr favicon",this.driver,testCaseName,"Yes");
				
				//3	Verify Login
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Login_Button", screen, parentTest, "Click on Login Button", driver, testCaseName, "No");
				
				Sleep(5000);
				
				//3-a	Enter UserName
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Email_Textbox", screen, parentTest, "Click on Email textbox", driver, testCaseName, "No");
				
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.ENTER);
				
				Sleep(4000);
				
				//3-b	Enter Password
				SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				
				Sleep(5000);
				
				//3-c	Verify Landing
				SikuliUtil.verifyObjectAndHighlight("Tumblr_HomeIcon_Landing", screen, parentTest, "Verify Landing after Login", driver, testCaseName, "Yes");
				
				
				//4	Post a new blog
				//4-a	Click on Make Post Button
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Create_Post", screen, parentTest, "Creating a new Post", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//4-b	Click on Text Blog
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Text_Blog", screen, parentTest, "Creating a text Blog", driver, testCaseName, "No");
				
				//4-c	Type text in the Test Blog
				SikuliUtil.typeScreen(screen, "This is a fun post for my first post posting on tumblr");
				
				/*SikuliUtil.comboKeyPress(robot, Key.C_CTRL, KeyEvent.VK_A);
				
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Make_Bold_Text", screen, parentTest, "Making the text bold", driver, testCaseName, "No");*/
				
				//4-d	Click inside the Title textbox
				SikuliUtil.verifyObjectAndClickOn("Tumblr_New_Post_Title", screen, parentTest, "Putting in the title for the post", driver, testCaseName, "No");
				
				//4-e	Type in the Title for the test post
				SikuliUtil.typeScreen(screen, "TestPost");
				
				//4-f	Click on Post button
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Post_New_Post", screen, parentTest, "Clicking on Post", driver, testCaseName, "No");
				
				Sleep(3000);
				
				/*SikuliUtil.typeScreen(screen, Key.F5);
				
				Sleep(000);*/
				
				//4-g	Verify that the Post has been Created 
				SikuliUtil.verifyObjectAndHighlight("Tumblr_Test_Post", screen, parentTest, "Verify new post", driver, testCaseName, "Yes");
				
				//5	Delete the test Post
				//5-a	Click on Settings for test post
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Settings_Icon", screen, parentTest, "Clicking on settings for test post", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//5-b	Click on Delete
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Delete_Post", screen, parentTest, "Click on Delete", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//5-c	Click on Ok
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Delete_Ok", screen, parentTest, "Post Deleted", driver, testCaseName, "Yes");
				
				Sleep(5000);
				
				//6	Posting a new Link
				//6-a	Click on post Link
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Post_Link", screen, parentTest, "Creating New Link", driver, testCaseName, "No");
				
				Sleep(1000);
				
				//6-b	Type in the Link
				SikuliUtil.typeScreen(screen, "http://www.iamgreeeeast.com");
				
				Sleep(5000);
				
				//6-c	Click on Post button
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Post_New_Post", screen, parentTest, "Post a link", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//6-d	Verify Link Posted Successfully
				SikuliUtil.verifyObjectAndHighlight("Tumblr_Link_Com", screen, parentTest, "Verifying New Link", driver, testCaseName, "Yes");
				
				//7	Delete the new Link 
				//7-a	Click on Settings of the test link
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Settings_Icon", screen, parentTest, "Clicking on settings for test Link", driver, testCaseName, "No");
				
				//7-b	Click on Delete
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Delete_Post", screen, parentTest, "Deleting Test Post", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//7-c	Click on Ok
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Delete_Ok", screen, parentTest, "Post Deleted", driver, testCaseName, "Yes");
				
				Sleep(2000);
				
				//8	Verify Search Functionality
				//8-a	Click inside the Search box
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Search_Box", screen, parentTest, "Clicking on Search", driver, testCaseName, "No");
				
				//8-b	Enter the Search text
				SikuliUtil.typeScreen(screen, "spikessecurity"+Key.ENTER);
				
				Sleep(4000);
				
				//8-c	Verify Search Results
				SikuliUtil.verifyObjectAndHighlight("Tumblr_Spikes_Search", screen, parentTest, "Verifying Search results", driver, testCaseName, "Yes");
				
				//9	Verify Logout Functionality
				//9-a	Click on profile Icon
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Profile_Icon", screen, parentTest, "Clicking on the Profile icon", driver, testCaseName, "No");
				
				Sleep(1000);
				
				//9-b	Click on Logout
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Logout", screen, parentTest, "Click Logout", driver, testCaseName, "No");
				
				//9-c	Click on OK
				SikuliUtil.verifyObjectAndClickOn("Tumblr_Delete_Ok", screen, parentTest, "Click on Logout OK", driver, testCaseName, "No");
				
				Sleep(4000);
				
				//9-d	Verify Signup Label
				SikuliUtil.verifyObjectAndHighlight("Tumblr_SignUp", screen, parentTest, "Verifying Logout", driver, testCaseName, "Yes");
				
				
				
				
			}catch(Exception e){
				
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Live.com TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				
				
			}
			finally{
				path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}	
	
}
		

}
