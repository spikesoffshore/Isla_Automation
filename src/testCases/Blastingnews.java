package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Blastingnews extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Blastingnews");
			
			public void navigateToURL(WebDriver driver){
				siteURL="www.blastingnews.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Blastingnews";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
	
				//Test Case 1 - Verify navigation to Blasting News
				ReportGenerator.verifyNavigation(this.driver, "Blasting News", parentTest,testCaseName,"Yes");
			
			
				//Test case 2 - Verify favicon of Blasting News
				SikuliUtil.verifyObjectAndHighlight("blastingnews_favicon", screen, parentTest, "Verify favicon of Blasting News", driver, testCaseName, "Yes");
				
				//Test case 3 - Verify scrolling on page is working fine
				SikuliUtil.verifyObjectAndClickOn("ALL_button", screen, parentTest, "Verify scrolling down on page", driver, testCaseName, "No");
				Sleep(8000);
				if(!SikuliUtil.isPresent(screen, "WriteandEarn_button")){
					Loggers.writeInfoLog("Page scrolled down successfuly");
				}
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("WriteandEarn_button", screen, parentTest, "Verify scrolling on page is working fine", driver, testCaseName, "Yes");
				
				//Test case 4 - Verify navigating to US news page
				SikuliUtil.verifyObjectAndClickOn("NewsUS_tab", screen, parentTest, "Verify navigating to US news page", driver, testCaseName, "No");
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "Blasting News United States", parentTest,testCaseName,"Yes");
				
				//Test case 5 - Verify searching Kobe Bryant news
				SikuliUtil.verifyObjectAndType("Searchbox", screen, parentTest, "Verify searching Kobe Bryant news", driver, testCaseName, "No", "Kobe Bryant");
				Sleep(3000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Search", parentTest,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndHighlight("kobeBryant_word", screen, parentTest, "Verify Kobe Bryant news searched", driver, testCaseName, "Yes");
				Sleep(2000);
				siteURL="www.blastingnews.com";
				driver.navigate().to(baseurl+siteURL);
				Sleep(4000);
		
				//Test case 6 - Verify Log In
				SikuliUtil.verifyObjectAndClickOn("login_button", screen, parentTest, "Verify clicking on login button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndType("email_textbox", screen, parentTest, "Clicking inside textbox", driver, testCaseName, "No", "spikesqa@yahoo.com");
				Sleep(2000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.typeScreen(screen, "QAqa4321");
				Sleep(2000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("blastingnews_favicon", screen, parentTest, "Verify favicon of Blastingnews", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("username", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				
				//Test case 7 - Verify user has not posted any news
				SikuliUtil.verifyObjectAndClickOn("username", screen, parentTest, "Verify clicking on username button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("YourPage_link", screen, parentTest, "Verify clicking on your page link", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("0_news", screen, parentTest, "User has not posted any news", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("back_button", screen, parentTest, "Verify clicking on back button", driver, testCaseName, "No");
				Sleep(2000);
				
				//Test case  8  - Verify article saved by user is present
				SikuliUtil.verifyObjectAndClickOn("username", screen, parentTest, "Verify clicking on username button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("WriteNewsArticle_button", screen, parentTest, "Verify clicking on Write a News Article button", driver, testCaseName, "No");
				Sleep(2000);
				if(SikuliUtil.isPresent(screen, "Close_button"))
				{
					SikuliUtil.verifyObjectAndClickOn("Close_button", screen, parentTest, "Verify clicking on close button", driver, testCaseName, "No");
				}
				SikuliUtil.verifyObjectAndClickOn("History_tab", screen, parentTest, "Verify clicking on Write a News Article button", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("ListAudioVideo_button", screen, parentTest, "Verify clicking on Write a News Article button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("MyBusiness_article", screen, parentTest, "Verify article saved by user is present", driver, testCaseName, "Yes");
				
				//Test case 9 - Verify Logout
				Sleep(2000);
				siteURL="www.blastingnews.com";
				driver.navigate().to(baseurl+siteURL);
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("username", screen, parentTest, "Verify clicking on username button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("logout_link", screen, parentTest, "Verify clicking on logout link", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("login_button", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				
			
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Blastingnews TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Blastingnews TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}	
