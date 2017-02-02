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

public class Twitter extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Twitter");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.twitter.com";
			driver.navigate().to(baseurl+siteURL);
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Twitter";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "Twitter", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
			
				SikuliUtil.verifyObjectAndHighlight("Twitter_Favicon", screen, parentTest,"Verify Twitter favicon",driver,testCaseName,"Yes");
				//TestCase#3-Verifying search functionality	
				Sleep(5000);
				SikuliUtil.verifyObjectAndClickOn("Search", screen, parentTest, "Verify Search Icon", driver, testCaseName, "No");
				
				Sleep(3000);
				SikuliUtil.verifyObjectAndType("SearchTextbox", screen, parentTest, "Clicking Search Textbox", driver, testCaseName, "No", "#mygang");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "#mygang", parentTest,testCaseName,"No");
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("SearchResult", screen, parentTest,"Resultset related to searched Text loaded successfully",driver,testCaseName,"Yes");
				
				Sleep(4000);
				SikuliUtil.moveWheel(screen, 1, 40);
				
				Sleep(6000);
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
			
				
				//TestCase#4-Verifying Login functionality	
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Verify availability of Log in link", driver, testCaseName, "No");
				Sleep(4000);
				
				
				screen.type("spikesqa@gmail.com");
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				
				screen.type("QAqa4321!"+Key.ENTER);
							
				Sleep(8000);
				
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				
				//TestCase#5-Verifying Trending Tweets page	
				SikuliUtil.clickBelow("Trending", screen, parentTest, "Clicking on trending Tweets", driver, testCaseName, "No", 35);
				Sleep(8000);
				
				SikuliUtil.verifyObjectAndHighlight("TrendingResult", screen, parentTest,"Twiteer Trending tweets page loaded",this.driver,testCaseName,"Yes");
				Sleep(2000);
				screen.wheel(1,40);			
				Sleep(6000);	
				
				
				
				//TestCase#6-Logged In user profile page
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest, "Logged in users Profile Icon link clicked", driver, testCaseName, "No");
				
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_DOWN);
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(8000);
				ReportGenerator.verifyNavigation(this.driver, "Spokes", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Twitter_Favicon", screen, parentTest,"Logged In users profile page loaded successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
				//TestCase#7-Creating New Tweet from logged in user
				SikuliUtil.keyPress(robot,KeyEvent.VK_N);
				Sleep(4000);
				screen.type("Test#Cyberinc");
				SikuliUtil.verifyObjectAndClickOn("NewTweet", screen, parentTest, "New Tweet Button Clicked", driver, testCaseName, "No");
				
				
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("TweetResult", screen, parentTest,"Logged In user Tweeted successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
				//TestCase#8-Like Tweet
				
				SikuliUtil.verifyObjectAndClickOn("Dislike", screen, parentTest, "Tweet like button clicked by User", driver, testCaseName, "No");
				
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndHighlight("Like", screen, parentTest,"Tweet liked successfully by User",driver,testCaseName,"Yes");
				Sleep(4000);
				//TestCase#9-DisLike Tweet
				
				SikuliUtil.verifyObjectAndClickOn("Like", screen, parentTest, "Tweet Dislike button clicked by User", driver, testCaseName, "No");
				
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndHighlight("Dislike", screen, parentTest,"Tweet Disliked successfully by User",driver,testCaseName,"Yes");
				Sleep(4000);
				//TestCase#10-Delete Tweet
				
				SikuliUtil.verifyObjectAndClickOn("DeleteMenu", screen, parentTest, "More button clicked", driver, testCaseName, "No");
				
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Delete", screen, parentTest, "Delete Tweet button clicked", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(5000);
				
				SikuliUtil.verifyObjectAndHighlight("Twitter_Favicon", screen, parentTest,"Tweet Deleted successfully",driver,testCaseName,"Yes");
				Sleep(4000);
				
								
				//TestCase#10-Verifying Signout Functionality
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest,"Clciking Profile icon",driver,testCaseName,"No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Clicking Logout Link", driver, testCaseName, "No");
				
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("LoginLink", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Twitter TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Twitter TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		
