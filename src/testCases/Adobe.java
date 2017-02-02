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

public class Adobe extends Base{
	
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Adobe.com");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.adobe.com";
			driver.navigate().to(baseurl+siteURL);
			}
		

			@Test	
			public void executeScript() throws IOException {
				
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Adobe";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					Loggers.startCurrentTestCaseExecution(this.driver);
					
					//1	Verify Navigation to adobe.com
					ReportGenerator.verifyNavigation(this.driver, "Adobe", parentTest,testCaseName,"Yes");
					
					//2	Verify Adobe favicon
					SikuliUtil.verifyObjectAndHighlight("Adobe_Favicon", screen, parentTest, "Verifying Adobe Favicon", driver, testCaseName, "Yes");
					
					//3	Verify Adobe Home Logo
					SikuliUtil.verifyObjectAndHighlight("Adobe_Home_Logo", screen, parentTest, "Verifying Adobe home logo", driver, testCaseName, "No");
					
					//4	Verify Sign-In
					//4-a Click on Signin
					SikuliUtil.verifyObjectAndClickOn("Adobe_Sign_In", screen, parentTest, "Clicking on Sign-In Link", driver, testCaseName, "No");
					
					Sleep(4000);
					
					//4-b Verify if already sign-in

					if(!(SikuliUtil.isPresent(screen,"Adobe_Already_Sign_In")))
				    {
					 SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				    }
				    
					//4-c Enter username
					SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
					
					Sleep(2000);
					
					//4-d Enter password					
					SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
					
					Sleep(4000);
					
					//4-e Verify Profile Icon
					SikuliUtil.verifyObjectAndHighlight("Adobe_Spikes_Profile_Icon", screen, parentTest, "Verifying Login", driver, testCaseName, "Yes");
					
					//5	Verify Adobe Products menu
					//5-a Click on Products Menu
					SikuliUtil.verifyObjectAndClickOn("Adobe_Menu", screen, parentTest, "Clicking on Menu", driver, testCaseName, "No");
					
					Sleep(3000);
					
					//5-b Verify Menu
					SikuliUtil.verifyObjectAndHighlight("Adobe_Products_Menu", screen, parentTest, "Verifying Adobe Menu", driver, testCaseName, "Yes");
					
					//6	Verify Navigation to Adobe Photoshop
					//6-a Click on Photoshop Link
					SikuliUtil.verifyObjectAndClickOn("Adobe_Photoshop_Link", screen, parentTest, "Click on Adobe Photoshop Link", driver, testCaseName, "No");
					
					Sleep(6000);
					
					//6-b Verify navigation to photoshop home
					SikuliUtil.verifyObjectAndHighlight("Adobe_Buy_Now", screen, parentTest, "Verifying Navigation to Photoshop", driver, testCaseName, "Yes");
					
					Sleep(2000);
					
					//7	Verify Scroll Down on Adobe.com
					//7-a Press End
					SikuliUtil.keyPress(robot, KeyEvent.VK_END);
					
					Sleep(3000);
					
					//7-b Verify Footer
					SikuliUtil.verifyObjectAndHighlight("Adobe_Footer", screen, parentTest, "Verifying Navigation to Page Footer", driver, testCaseName, "Yes");
					
					//8	Verify Scroll Up
					//8-a Press home
					SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
					
					Sleep(3000);
					
					//8-b Verify Scroll up
					//9	Verify Navigation to Adobe Acrobat
					//9-a Click on Adobe Logo	
					SikuliUtil.verifyObjectAndClickOn("Adobe_Adobe", screen, parentTest, "Navigating Back to Adobe Home", driver, testCaseName, "Yes");
					
					Sleep(5000);
					
					//9-b Click on Menu				
					SikuliUtil.verifyObjectAndClickOn("Adobe_Menu", screen, parentTest, "Clicking on Menu", driver, testCaseName, "No");
					
					Sleep(3000);
					
					//9-c Click on Acrobat icon
					SikuliUtil.verifyObjectAndClickOn("Adobe_Acrobat", screen, parentTest, "Verifying Navigation to Acrobat", driver, testCaseName, "No");
					
					Sleep(5000);
					
					//9-d Verify Navigation to Acrobat home
					SikuliUtil.verifyObjectAndHighlight("Adobe_Acrobat_Logo", screen, parentTest, "Verifying Navigation Adobe Acrobat", driver, testCaseName, "Yes");
					
					Sleep(2000);
					
					//10 Verify Logout
					//10-a Click on Adobe Logo
					SikuliUtil.verifyObjectAndClickOn("Adobe_Adobe_2", screen, parentTest, "Navigating Back to Adobe Home", driver, testCaseName, "No");
					
					Sleep(5000);
					
					//10-b Click on Spikes Profile Icon					
					SikuliUtil.verifyObjectAndClickOn("Adobe_Spikes_Profile_Icon", screen, parentTest, "Clicking on Spikes Profile Icon", driver, testCaseName, "No");
					
					Sleep(3000);
					
					//10-c Click on Signout
					SikuliUtil.verifyObjectAndClickOn("Adobe_Sign_Out", screen, parentTest, "Clicking on Sign_Out", driver, testCaseName, "No");
					
					Sleep(4000);
					
					//10-d	Verify Signout landing
					SikuliUtil.verifyObjectAndHighlight("Adobe_Logged_Out", screen, parentTest, "Verification of LogOut functionality", driver, testCaseName, "Yes");
					
					
				}catch(Exception e){
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Adobe TestCase has failed,Please see logs and error screenshots", this.driver);
				}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
				}
				
}
}
