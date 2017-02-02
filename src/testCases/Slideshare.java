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

public class Slideshare extends Base {

	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Slideshare");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.slideshare.net";
			driver.navigate().to(baseurl+siteURL);
			}
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Slideshare";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//1	Verify Navigation to slideshare.net				
				ReportGenerator.verifyNavigation(this.driver, "SlideShare", parentTest,testCaseName,"Yes");
				
				//2	Verify Slideshare favicon
				SikuliUtil.verifyObjectAndHighlight("Slideshare_Favicon", screen, parentTest, "Verifying Slideshare Favicon", driver, testCaseName, "Yes");
				
				//3	Verify Slideshare Home logo
				SikuliUtil.verifyObjectAndHighlight("Slideshare_Home_Logo", screen, parentTest, "Verifying Slideshare Home Logo", driver, testCaseName, "Yes");
				
				//4	Verify Slideshare login
				//4-a	Click on Login
				SikuliUtil.verifyObjectAndClickOn("Slideshare_Login", screen, parentTest, "Clicking on signin", driver, testCaseName, "No");
				
				Sleep(3000);
				
				//4-b	Click inside username textbox
				SikuliUtil.verifyObjectAndClickOn("Slideshare_Username", screen, parentTest, "Click on username textbox", driver, testCaseName, "No");
				
				//4-c	Enter Username
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
				
				Sleep(2000);
				
				//4-d	Enter Password
				SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				
				Sleep(4000);
				
				//4-e	Press End
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				
				Sleep(2000);
				
				//4-f	Verify footer and Landing
				SikuliUtil.verifyObjectAndHighlight("Slideshare_Footer", screen, parentTest, "Verifying Scroll Down on Slideshare", driver, testCaseName, "Yes");
				
				//5	Verify Scroll Up
				//5-a	Press Home
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				
				Sleep(2000);
				
				//5-b	Verify Header
				SikuliUtil.verifyObjectAndHighlight("Slideshare_Header", screen, parentTest, "Verifying Scroll up on Slideshare", driver, testCaseName, "Yes");
				
				//6	Verify Slideshare Search
				//6-a	Click  inside Search 
				SikuliUtil.verifyObjectAndClickOn("Slideshare_Search", screen, parentTest, "Clicking inside search box", driver, testCaseName, "No");
				
				//6-b	Enter text
				SikuliUtil.typeScreen(screen, "spikes security"+Key.ENTER);
				
				Sleep(4000);
				
				//6-c	Click on First search result
				SikuliUtil.verifyObjectAndClickOn("Slideshare_Spikes_Slide", screen, parentTest, "Click on Slide to Open", driver, testCaseName, "No");
				
				Sleep(4000);
				
				//6-d	Verify Opening of slide
				SikuliUtil.verifyObjectAndHighlight("Slideshare_Spikes_Securtiy_Logo", screen, parentTest, "Verifying Slide Opened", driver, testCaseName, "Yes");
				
				//7	Verify Slide Clipping
				//7-b	Click on Clip Slide
				SikuliUtil.verifyObjectAndClickOn("Slideshare_Clip_Slide", screen, parentTest, "Click on Clip Slide", driver, testCaseName, "No");
				
				Sleep(3000);
				
				//7-c	Enter Clipboard name
				SikuliUtil.typeScreen(screen, "Test Clipboard"+Key.TAB);
				
				Sleep(1000);
				
				//7-d	Enter Clipboard description
				SikuliUtil.typeScreen(screen, "Clipboard for testing");
				
				//7-e	Click on Save
				SikuliUtil.verifyObjectAndClickOn("Slideshare_Save", screen, parentTest, "Saving Clipboard", driver, testCaseName, "No");
				
				//7-f	Navigate to My Clipboards
				SikuliUtil.verifyObjectAndClickOn("Slideshare_My_Clipboards", screen, parentTest, "Clicking on My Clipboards", driver, testCaseName, "No");
				
				Sleep(3000);
				
				//7-g	Verify Successful Clipping 
				SikuliUtil.verifyObjectAndHighlight("Slideshare_Test_Clipboard", screen, parentTest, "Verifying Clipboard Creation", driver, testCaseName, "Yes");
				
				Sleep(2000);
				
				//8	Verify Deleting Clipboard
				//8-a	Click on Delete
				SikuliUtil.verifyObjectAndClickOn("Slideshare_Delete", screen, parentTest, "Deleting the Clipboard", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//8-b	Click on Confirm Delete
				SikuliUtil.verifyObjectAndClickOn("Slideshare_Confirm_Delete", screen, parentTest, "Confirming deletion of Clipboard", driver, testCaseName, "No");

				Sleep(2000);
				
				//9	Verify Logout
				//9-a	Highlight Profile Icon
				SikuliUtil.verifyObjectAndHighlight("Slideshare_Profile_Icon", screen, parentTest, "Going for the SignOut", driver, testCaseName, "No");
				
				//9-b	Click on Logout
				SikuliUtil.verifyObjectAndClickOn("Slideshare_Logout", screen, parentTest, "Clicking on Sign Out", driver, testCaseName, "No");
				
				Sleep(4000);
				
				//9-c	Verify Login Label
				SikuliUtil.verifyObjectAndHighlight("Slideshare_Login", screen, parentTest, "verify Sign out on Slideshare", driver, testCaseName, "Yes");	

				
				
			}catch(Exception e){
				
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Slideshare TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				
			
			}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}	
		}
	
}
