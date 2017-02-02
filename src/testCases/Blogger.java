package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Blogger extends Base {

	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Blogger.com");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.blogger.com";
			driver.navigate().to(baseurl+siteURL);
			}
		

			@Test	
			public void executeScript() throws IOException {
				
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Blogger";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					Loggers.startCurrentTestCaseExecution(this.driver);
					
					//1	Verify Navigation to blogger.com
					ReportGenerator.verifyNavigation(this.driver, "Blogger", parentTest,testCaseName,"Yes");
					
					//2	Verify Blogger Favicon
					SikuliUtil.verifyObjectAndHighlight("Blogger_Favicon", screen, parentTest,"Verify Blogger favicon",this.driver,testCaseName,"Yes");
				
					//3	Verify Blogger Home Logo
					SikuliUtil.verifyObjectAndHighlight("Blogger_Logo", screen, parentTest, "Verify Blogger Logo", this.driver, testCaseName, "No");
					
					
					
					//4	Verify Blogger login
					//4-a	Click on Login
					SikuliUtil.verifyObjectAndClickOn("Blogger_Login_Link", screen, parentTest, "Click on Sign-In Link", this.driver, testCaseName, "No");
					
					//4-b	Verify If the User is already logged in
					 if((SikuliUtil.isPresent(screen,"Blogger_Already_Sign_In")))
					    {
						 SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
					    }
					    
					
					SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.ENTER);
					
					Sleep(1000);
					//4-c	Type Password
					SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
					
					Sleep(8000);
					
					//4-d	Verify Successful Login-All Post Highlight
					SikuliUtil.verifyObjectAndHighlight("Blogger_All_Posts", screen, parentTest, "Logged in Successfully", this.driver, testCaseName, "Yes");
					
					Sleep(2000);
					
					//5	Verify User information
					//5-a	Click on profile icon
					SikuliUtil.verifyObjectAndClickOn("Blogger_User_Icon", screen, parentTest, "Verifying User Information", this.driver, testCaseName, "No");
					
					//5-b	Verify User Email
					SikuliUtil.verifyObjectAndHighlight("Blogger_User_Email", screen, parentTest, "User information verified Successfully", this.driver, testCaseName, "Yes");
					
					Sleep(3000);
					
					//6	Create new Post
					//6-a	Click on New Post button
					SikuliUtil.verifyObjectAndClickOn("Blogger_New_Post_Button", screen, parentTest, "Clicking on New post Button", this.driver, testCaseName, "No");
					
					Sleep(3000);
					
					//6-b	Click inside the Title Textbox
					SikuliUtil.verifyObjectAndClickOn("Blogger_New_Post_Title", screen, parentTest, "Cliking in the Post title textbox", driver, testCaseName, "No");
					
					//6-c	Insert Title
					SikuliUtil.typeScreen(screen, "TestPost");
					
					//6-d	Click Below the Font Icon to take the cursor to writing position
					SikuliUtil.verifyObjectAndHighlight("Blogger_Font_Icon", screen, parentTest, "Highlighting Font Icon", driver, testCaseName, "No");
					
					SikuliUtil.clickBelow("Blogger_Font_Icon", screen, parentTest, "click text area", driver, testCaseName, "No",50);
					
					//6-e	Type in test data
					SikuliUtil.typeScreen(screen, "This is the first test post on Blogger");
					
					Sleep(2000);
					
					//SikuliUtil.verifyObjectAndClickOn("Wordpress_Write_Link", screen, parentTest, "Creating a New Post, Clicking on Write", this.driver, testCaseName, "No", 30);

					//6-f	Click on Publish
					SikuliUtil.verifyObjectAndClickOn("Blogger_Publish_Post", screen, parentTest, "Click on Publish Post", driver, testCaseName, "No");
					
					Sleep(3000);
									
					//6-g	Verify That the post was published
					SikuliUtil.verifyObjectAndHighlight("Blogger_Sucessfull_Post", screen, parentTest, "Post Published Sucessfully on Blogger", this.driver, testCaseName, "Yes");
					
					//7	View Test post
					//7-a	Click on View Post
					SikuliUtil.verifyObjectAndClickOn("Blogger_View_Post", screen, parentTest, "click on view", driver, testCaseName, "No");
					
					Sleep(15000);
					
					//7-b	Verify successful View 
					SikuliUtil.verifyObjectAndHighlight("Blogger_View_Success", screen, parentTest, "Verify View for post", driver, testCaseName, "Yes");
					
					//7-c	Close the Tab
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL,KeyEvent.VK_W );
					
					Sleep(2000);
					
										
					SikuliUtil.verifyObjectAndHighlight("Blogger_Sucessfull_Post", screen, parentTest, "Coming back to delete post", this.driver, testCaseName, "No");
					
					//8	Delete Post on Blogger
					//8-a	Click on Delete post
					SikuliUtil.verifyObjectAndClickOn("Blogger_Delete_Post", screen, parentTest, "Deleting Test Post", this.driver, testCaseName, "No");
					
					//8-b	Click on OK
					SikuliUtil.verifyObjectAndClickOn("Blogger_Delete_OK", screen, parentTest, "Delete confirmation", driver, testCaseName, "No");
					
					Sleep(3000);
					
					//8-c	Confirm Delete
					SikuliUtil.verifyObjectAndHighlight("Blogger_Delete_Confirmation", screen, parentTest, "Post Deletion", driver, testCaseName, "Yes");
					
					//9	Verify Signout
					//9-a	Click on User Icon
					SikuliUtil.verifyObjectAndClickOn("Blogger_User_Icon", screen, parentTest, "Clickin on profile Icon to sign out", this.driver, testCaseName, "No");
					
					Sleep(1000);
					
					//9-b	Click on Sign Out
					SikuliUtil.verifyObjectAndClickOn("Blogger_Sign_Out", screen, parentTest, "Clicking on Sign_Out", this.driver, testCaseName, "No");
					
					Sleep(5000);
					
					//9-c Verify Signout Landing
					SikuliUtil.verifyObjectAndHighlight("Blogger_Already_Sign_In", screen, parentTest, "User Log Out", this.driver, testCaseName, "Yes");
					
					Loggers.stopCurrentTestCaseExecution(testCaseName);
				
					
					
				}catch(Exception e){
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Blogger TestCase has failed,Please see logs and error screenshots", this.driver);
				}
				finally{
				quitDriver(this.driver);
					path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
				}
				
			}
}
