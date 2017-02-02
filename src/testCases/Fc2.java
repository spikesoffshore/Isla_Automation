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

public class Fc2 extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Fc2");
		
		public void navigateToURL(WebDriver driver){
			siteURL="www.fc2.com";
			driver.navigate().to(baseurl+siteURL);
			driver.manage().window().maximize();
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
		this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Fc2";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "FC2", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon
				SikuliUtil.verifyObjectAndHighlight("Fc2_Favicon", screen, parentTest,"Verify Fc2 favicon",driver,testCaseName,"Yes");
			
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Fc2 Home Logo",driver,testCaseName,"No");
				
				//TestCase#3-Verifying Live link page
				SikuliUtil.verifyObjectAndClickOn("Live", screen, parentTest, "Clicking FC2 Live link", driver, testCaseName, "No");
				
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Broadcast", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Fc2_Favicon", screen, parentTest,"Verify Fc2 favicon",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("LiveValidation", screen, parentTest,"Fc2 Live Broadcasting page loaded",driver,testCaseName,"Yes");				
				Sleep(2000);
				
				screen.wheel(1, 15);			
				Sleep(4000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("Fc2_Favicon", screen, parentTest,"Verify Fc2 favicon",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Verify FC2 Home page redirection after Alt+Left keys",driver,testCaseName,"Yes");
				//TestCase#5-Verifying Login functionality				
				
				SikuliUtil.verifyObjectAndClickOn("LoginLink", screen, parentTest, "Clicking of Login Button", driver, testCaseName, "No");
				
				Sleep(8000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				screen.type("spikesqa@gmail.com");
				
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
			
				screen.type("QAqa4321"+Key.ENTER);
							
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "FC2ID", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Fc2_Favicon", screen, parentTest,"Verify Fc2 favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#6-Verifying Videos link page
				SikuliUtil.verifyObjectAndClickOn("Videos", screen, parentTest, "Clicking Videos Link", driver, testCaseName, "No");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "FC2 Video", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Fc2VideoLogo", screen, parentTest,"FC2 Video page loaded successfully",driver,testCaseName,"Yes");
				
				//TestCase#7-Verifying FC2 Specific Video play functionality
				SikuliUtil.clickBelow("Fc2VideoLogo", screen, parentTest, "Clicking FC2 Specific video", driver, testCaseName, "No", 450);
				
				Sleep(6000);
				SikuliUtil.verifyObjectAndHighlight("Fc2VideoLogo", screen, parentTest,"FC2 Video logo validated",driver,testCaseName,"Yes");
				Sleep(2000);
				screen.wheel(1, 15);			
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Fc2_Favicon", screen, parentTest,"FC2 Specific Video page loaded to play",driver,testCaseName,"Yes");
				Sleep(4000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(4000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(4000);
				
				
				
				//TestCase#8-Verifying Adding Service to the logged in user functionality
				
				SikuliUtil.verifyObjectAndClickOn("AddService", screen, parentTest, "Clicking Add Service Link", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndClickOn("AddServiceButton", screen, parentTest, "Adding a Service Button Clicked", driver, testCaseName, "No");
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "FC2 Blog", parentTest,testCaseName,"No");
				Sleep(2000);
				pattern1=new org.sikuli.script.Pattern(patternpath("/Fc2BlogPage.PNG"));
				
				SikuliUtil.verifyObjectAndHighlight("Fc2BlogPage", screen, parentTest,"Adding Service to the logged in user functionality working fine",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				//TestCase#9-Verifying Right Click and Back Functionality
				reg=screen.exists(pattern1);
				r=reg.right(350);
				Sleep(3000);
				r.rightClick();
				Sleep(3000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
				
				Sleep(7000);
				
				ReportGenerator.verifyNavigation(this.driver, "FC2ID", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Imdb Home Logo",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Fc2_Favicon", screen, parentTest,"Right Click and Going to previous page functionality validated",driver,testCaseName,"Yes");
				Sleep(2000);
				
				
				//TestCase#10-Verifying Signout Functionality
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Logout Link Clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "Log out", parentTest,testCaseName,"No");
				
				
				SikuliUtil.verifyObjectAndHighlight("Fc2_Favicon", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Fc2 TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Fc2 TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		