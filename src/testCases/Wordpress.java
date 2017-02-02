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

public class Wordpress extends Base{

	
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Wordpress");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.wordpress.com";
			driver.navigate().to(baseurl+siteURL);
			}
		

			@Test	
			public void executeScript() throws IOException {
				
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Wordpress";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					Loggers.startCurrentTestCaseExecution(this.driver);
					
					//1	Verify Navigation to Wordpress.com
					ReportGenerator.verifyNavigation(this.driver, "WordPress", parentTest,testCaseName,"Yes");
					
					//2	Verify Wordpress favicon
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Favicon", screen, parentTest,"Verification of Wordpress favicon",this.driver,testCaseName,"Yes");
				
					//3	Verify Logo of Wordpress
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Logo", screen, parentTest, "Verify Wordpress Logo", this.driver, testCaseName, "No");
					
					//4	Verified WordPress user login
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Login_Link", screen, parentTest, "Click on Login Link", this.driver, testCaseName, "No");
					
					//Type Username
					SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
					
					Sleep(1000);
					
					//Type Password
					SikuliUtil.typeScreen(screen, "QAqa4321!");
					
					Sleep(1000);
					
					//Click Login
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Login_Button", screen, parentTest, "Logging into Wordpress", this.driver, testCaseName, "No");
					
					Sleep(2000);
					
					//6	Verify Successful navigation to Wordpress_Reader- Verify Followed Sites
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Followed_Sites_Label", screen, parentTest, "Logging into Wordpress", this.driver, testCaseName, "Yes");
					
					Sleep(2000);
					
					//Click on Wordpress profile icon
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Profile_Logo", screen, parentTest, "Verifying User Information", this.driver, testCaseName, "No");
					
					//verify User information
					SikuliUtil.verifyObjectAndHighlight("Wordpress_MyProfile_Icon", screen, parentTest, "Verification of user information", this.driver, testCaseName, "Yes");
					
					Sleep(3000);
					
					//Click on Reader link
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Reader_Link", screen, parentTest, "Naviating Back to Wordpress Reader", this.driver, testCaseName, "No");
					
					Sleep(2000);
					
					//Verify navigation to Wordpress reader
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Followed_Sites_Label", screen, parentTest, "Successfully navigated back to Wordpress Reader", this.driver, testCaseName, "No");
					
					//7	Create a new post on Wordpress
					//7-a	Click on Write
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Write_Link", screen, parentTest, "Creating a New Post, Clicking on Write", this.driver, testCaseName, "No");

					Sleep(3000);
					
					//7-b	Write the title as -Test Post
					SikuliUtil.typeScreen(screen, "Test Post"+Key.TAB);
					
					Sleep(1000);
					
					//7-c	Write the body as Test Post
					SikuliUtil.typeScreen(screen, "Test Post");
					
					//7-d	Click on Publish
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Publish_Button", screen, parentTest, "Publishing the Post", this.driver, testCaseName, "No");
					
					Sleep(2000);
					
					//7-e	Verify Success Message
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Post_Published_Label", screen, parentTest, "Verification of successfull post", this.driver, testCaseName, "Yes");
					
					//8	View the new Post
					//8-a	Click on the My Site
					SikuliUtil.verifyObjectAndClickOn("Wordpress_My_Site_Link", screen, parentTest, "Click on My Site and navigate to My_Site", this.driver, testCaseName, "No");
					
					//8-b	Verify that the site has navigated to the Stats Page
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Stats_Label", screen, parentTest, "Navigation to My_Site_Stats", this.driver, testCaseName, "Yes");
					
					//8-c	Click on Blog Posts to view the Posts
					SikuliUtil.verifyObjectAndClickOn("Wordpress_BlogPosts_Label", screen, parentTest, "Click On Blog Post", this.driver, testCaseName, "No");
					
					//8-d	Verify the presence of new Post 'Test Post'
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Test_Blog_Post", screen, parentTest, "Verification of Post correctly posted in Blog Posts", this.driver, testCaseName, "Yes");
					
					//9	Verify the post on the WebSite
					//9-a	Click on View My Site
					SikuliUtil.verifyObjectAndClickOn("Wordpress_My_Site_Home_Label", screen, parentTest, "Verifying Post on My_Site", this.driver, testCaseName, "No");
					
					//9-b	Scroll Down
					SikuliUtil.moveWheel(screen, 1, 50);
					
					Sleep(2000);
					
					//9-c	Verify label of test post
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Test_Post_On_Site", screen, parentTest, "Verifcatio of post posted on Site", this.driver, testCaseName, "Yes");
					
					//9-d	Close the Site Popup
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Site_Close_Button", screen, parentTest, "CLosing Site Popup", this.driver, testCaseName, "No");
					
					//10	Delete the Test Post
					//10-a Click on trash label
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Trash_Label", screen, parentTest, "Deleting Test Post", this.driver, testCaseName, "No");
					
					Sleep(5000);
					//10-b Verify that the Post has been successfully deleted
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Moved_To_Trash_Message", screen, parentTest, "Verification of Post deletion", this.driver, testCaseName, "Yes");
					
					//11	Verify Creating a New Site
					//11-a	Click on Add new Site
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Add_New_Site_button", screen, parentTest, "Click on Add New Site", this.driver, testCaseName, "No");
					
					//11-b	Click on technology
					//SikuliUtil.verifyObjectAndClickOn("Wordpress_Technology_Site", screen, parentTest, "Select Technology", this.driver, testCaseName, "No");
					
					//11-c	Select Theme 1
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Select_Theme_1", screen, parentTest, "Selecting Theme 1", this.driver, testCaseName, "No");
					
					//Press End
					SikuliUtil.keyPress(robot, KeyEvent.VK_END);
					
					Sleep(1000);
					
					//11-d	Skip Theme 2
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Skip_Theme", screen, parentTest, "Skipping Theme 2", this.driver, testCaseName, "No");
					
					//11-e	Find a domain : type:spikesyabadabadoo.wordpress.com
					SikuliUtil.typeScreen(screen, "spikesyabadabadoo.wordpress.com");
					
					Sleep(5000);
					
					//11-f	Select the Domain
					SikuliUtil.verifyObjectAndClickOn("Wordpress_FreeDomain", screen, parentTest, "Selecting Domain for new Site", this.driver, testCaseName, "No");
					
					//11-g	Select the Plan
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Select_Plan", screen, parentTest, "Selecting Test plan", this.driver, testCaseName, "No");
					
					Sleep(3000);
					
					//11-h	Continue to New Site
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Continue_To_New_Site", screen, parentTest, "Continue to New Site", this.driver, testCaseName, "No");
					
					Sleep(2000);
					
					//11-i	Verify Site Success Creation-Verify the Site title label
					SikuliUtil.verifyObjectAndHighlight("Wordpress_New_Site_Title", screen, parentTest, "Verification of new site creation", this.driver, testCaseName, "Yes");
					
					//12	Delete the New Site
					//12-a	 Click on My_Sites;scroll down
					SikuliUtil.verifyObjectAndClickOn("Wordpress_My_Sites", screen, parentTest, "Navigating to My Sites", this.driver, testCaseName, "No");
					
					SikuliUtil.verifyObjectAndHighlight("Wordpress_BlogPosts_Label", screen, parentTest, "Highlight Blog Post Label", this.driver, testCaseName, "No");
					
					SikuliUtil.moveWheel(screen, 1, 10);
					
					//12-b	Click on Settings
					SikuliUtil.verifyObjectAndClickOn("Wordpress_My_Sites_Settings", screen, parentTest, "Click on Site Settings", this.driver, testCaseName, "No");
					
					Sleep(3000);
					
					//12-c	Go To the Bottom of the Settings page
					SikuliUtil.keyPress(robot,KeyEvent.VK_END);
					
					//12-d	Click on Delete Site
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Delete_Site", screen, parentTest, "Deleting Test Site", this.driver, testCaseName, "No");
					
					//12-e	Go to the End of the Page Again
					SikuliUtil.keyPress(robot,KeyEvent.VK_END);
					
					//12-f	Click on Delete Site
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Final_Site_Delete", screen, parentTest, "Click on Delete Site Red", this.driver, testCaseName, "No");
					
					Sleep(2000);
					
					//Click inside the delete text box
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Delete_Site_Text_Box", screen, parentTest, "Confirming Delete Text", this.driver, testCaseName, "No");
					
					//12-g	Type in site name
					SikuliUtil.typeScreen(screen, driver.getCurrentUrl().split("-site/")[1]);
					
					//12-h	Click on Pakka Delete
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Pakka_Delete", screen, parentTest, "Clicking on Pakka Delete", this.driver, testCaseName, "No");
					
					Sleep(2000);
					//12-i	Verify Site Delete
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Delete_Success_Message", screen, parentTest, "Verification of site deletion", this.driver, testCaseName, "Yes");
					
					//13	Verify Logout
					//13-a	Click on Profile Icon
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Profile_Logo", screen, parentTest, "Clickin on profile Icon", this.driver, testCaseName, "No");
					
					Sleep(1000);
					
					//13-b	Click on Sign Out
					SikuliUtil.verifyObjectAndClickOn("Wordpress_Sign_Out", screen, parentTest, "Clicking on Sign_Out", this.driver, testCaseName, "No");
					
					Sleep(3000);
					
					//13-c	Verify Wordpress Home
					SikuliUtil.verifyObjectAndHighlight("Wordpress_Logo", screen, parentTest, "Logout from Wordpress", this.driver, testCaseName, "Yes");
					
					Loggers.stopCurrentTestCaseExecution(testCaseName);
				
					
					
				}catch(Exception e){
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Wordpress TestCase has failed,Please see logs and error screenshots", this.driver);
				}
				finally{
				quitDriver(this.driver);
					path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
				}
				
			}
}
