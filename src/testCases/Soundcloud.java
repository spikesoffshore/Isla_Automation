package testCases;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Soundcloud extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Soundcloud");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.soundcloud.com";
			driver.navigate().to(baseurl+siteURL);
			driver.manage().window().maximize();
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Soundcloud";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
				
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				//TestCase#1-Verifying Navigation to home page		
				ReportGenerator.verifyNavigation(this.driver, "SoundCloud", parentTest,testCaseName,"Yes");
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Soundcloud_Favicon", screen, parentTest,"Verify Soundcloud favicon",driver,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("ClosePolicy", screen, parentTest, "Closing the cookie policy", driver, testCaseName, "No");
				
				//TestCase#3-Verifying Trending SoundCloud audio page
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("Trending", screen, parentTest,"Verify Trending Soundcloud audio",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.clickBelow("Trending", screen, parentTest, "Clicking Trending soundlcoud audio", driver, testCaseName, "No", 80);
				
				Sleep(7000);
				
				ReportGenerator.verifyNavigation(this.driver, "SoundCloud", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndClickOn("Play", screen, parentTest, "Trending Soundcloud audio page loaded successfully", driver, testCaseName, "Yes");
				Sleep(5000);
				//TestCase#4-Verifying Play functionality	
				SikuliUtil.verifyObjectAndHighlight("Pause", screen, parentTest,"Trending Soundcloud audio is been playing",driver,testCaseName,"Yes");
				Sleep(2000);
				//TestCase#5-Verifying Pause functionality	
				SikuliUtil.verifyObjectAndClickOn("Pause", screen, parentTest, "Trending Soundcloud audio is been paused", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("Play", screen, parentTest, "Trending Soundcloud audio is been paused successfully", driver, testCaseName, "Yes");
				Sleep(2000);
				//TestCase#6-Verifying Login functionality	
				SikuliUtil.verifyObjectAndClickOn("Like", screen, parentTest, "Trending Soundcloud audio like link is been clicked", driver, testCaseName, "No");
				Sleep(6000);
				
				screen.type("spikesqa@gmail.com");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);		
				Sleep(5000);
				screen.type("QAqa4321!");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(8000);
				
				SikuliUtil.verifyObjectAndHighlight("Soundcloud_Favicon", screen, parentTest,"Verify Soundcloud favicon",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"login functionality working fine",driver,testCaseName,"Yes");
				
				
				//TestCase#7-Verifying Like functionality
				
				
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("Liked", screen, parentTest, "Trending Soundcloud audio liked successfully", driver, testCaseName, "Yes");
				//TestCase#8-Verifying Like page of logged in user
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest,"Profile icon clicked",driver,testCaseName,"No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndClickOn("LikesPage", screen, parentTest,"Loggedin user Likes page link clicked",driver,testCaseName,"No");
				Sleep(6000);
				ReportGenerator.verifyNavigation(this.driver, "liked", parentTest,testCaseName,"No");
			
				pattern1=new org.sikuli.script.Pattern(patternpath("/LikeTrackPage.PNG"));
				SikuliUtil.verifyObjectAndHighlight("LikeTrackPage", screen, parentTest,"Logged in users likes page on Soundcloud loaded successfully",driver,testCaseName,"Yes");
				//TestCase#9-Verifying Alt+Left Key press functionality
				SikuliUtil.clickBelow("LikeTrackPage", screen, parentTest, "Clicking Unlike of liked soundcloud audio", driver, testCaseName, "No", 100);
				
				
				
				Sleep(7000);
				SikuliUtil.verifyObjectAndClickOn("Liked", screen, parentTest, "Trending Soundcloud audio unliking link clicked", driver, testCaseName, "No");
				Sleep(7000);
				
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "liked", parentTest,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("Soundcloud_Favicon", screen, parentTest,"Verify Soundcloud logged in user's liked page redirection after Alt+Left keys",driver,testCaseName,"Yes");
				
				//TestCase#10-Verifying UnLike functionality
				SikuliUtil.verifyObjectAndHighlight("Nolikes", screen, parentTest,"Logged in users unliking of liked track done successfully",driver,testCaseName,"Yes");
				Sleep(3000);
				
				//TestCase#11-Verifying Signout Functionality
				
				SikuliUtil.verifyObjectAndClickOn("LogoutIcon", screen, parentTest, "Profile icon clicked", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Logout", screen, parentTest, "Sign out link clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				SikuliUtil.verifyObjectAndHighlight("Soundcloud_Favicon", screen, parentTest,"Verify Soundcloud favicon",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("SignedOut", screen, parentTest,"User logout functionality",driver,testCaseName,"Yes");
				Sleep(3000);
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Soundcloud TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
			
				
			}catch(Exception e){
					
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Soundcloud TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}
			
}	
		