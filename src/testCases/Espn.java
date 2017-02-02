package testCases;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Espn extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Espn");
			
			public void navigateToURL(WebDriver driver){
				siteURL="http://www.espn.in";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Espn";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//test case 1 Verify navigation to Espn
				ReportGenerator.verifyNavigation(driver, "ESPN", parentTest, testCaseName, "Yes");

				
				//test case 2 Verify ESPN Favicon
				while(!SikuliUtil.isPresent(screen, "Espn_favicon")){
				Sleep(1000);
				}
				SikuliUtil.verifyObjectAndHighlight("Espn_favicon", screen, parentTest, "Verify ESPN Favicon", driver, testCaseName, "Yes");
				
				//test case 3 verify scrolling Top events
				
				SikuliUtil.verifyObjectAndClickOn("right_arrow", screen, parentTest, "scrolling Top Events to left", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("left_arrow", screen, parentTest, "Verify Top events scrolled to left", driver, testCaseName, "Yes");
				
				//test case 4 Verify Top headline section
				SikuliUtil.verifyObjectAndHighlight("TopHeadline_Section", screen, parentTest, "Verify Top headline section", driver, testCaseName, "Yes");
				Sleep(2000);
				SikuliUtil.moveWheel(screen, 1, 30);
				Sleep(10000);
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_HOME);
				Sleep(2000);
				
				//test case 5 Verify seaching news of Neymar Jr.
				SikuliUtil.verifyObjectAndClickOn("search_button", screen, parentTest, "Verify seaching news of Neymar Jr.", driver, testCaseName, "Yes");
				Sleep(2000);
				SikuliUtil.typeScreen(screen,"Neymar");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(5000);
				ReportGenerator.verifyNavigation(driver, "Neymar News", parentTest, testCaseName, "No");
				
				//test case 6 - Verify navigating to footabll tab
				SikuliUtil.verifyObjectAndClickOn("football_tab", screen, parentTest, "Verify navigating to footabll tab ", driver, testCaseName, "Yes");
				Sleep(3000);
				ReportGenerator.verifyNavigation(driver, "Football", parentTest, testCaseName, "No");
				Sleep(2000);
				siteURL="http://www.espn.in";
				driver.navigate().to(baseurl+siteURL);
		
				
				//test case 7 - verify Login
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("logIn_link", screen, parentTest, "Verify clicking LogIn link", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.typeScreen(screen,"spikesqa@gmail.com");
			    Sleep(2000);
			    SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.typeScreen(screen,"QAqa4321!");
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(7000);
				
				
				//test case 8 - Verify added favorite page is present
				SikuliUtil.verifyObjectAndHighlight("ganada_link", screen, parentTest, "verify added Granada page is present under favorites", driver, testCaseName, "Yes");
				
				//test case 9 - Verify navigating to favorite page
				SikuliUtil.verifyObjectAndHighlight("ganada_link", screen, parentTest, "Highlight Granada", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("ganada_link", screen, parentTest, "Verify visiting favorite Granada page", driver, testCaseName, "Yes");
				Sleep(2000);
				ReportGenerator.verifyNavigation(driver, "Granada", parentTest, testCaseName, "No");
				
				//test case 10 - Verify logout
				//SikuliUtil.verifyObjectAndHighlight("profile_icon", screen, parentTest, "hover on profile icon", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("profile_icon", screen, parentTest, "Verify clicking on profile icon ", driver, testCaseName, "No");
				SikuliUtil.clickBelow("profile_icon", screen, parentTest, "Verify clicking below profile icon", driver, testCaseName, "No", 6);
				SikuliUtil.verifyObjectAndClickOn("logout_link", screen, parentTest, "Verify clicking Logout link", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("logIn_link", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Espn TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Espn TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}