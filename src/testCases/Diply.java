package testCases;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Diply extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Diply");
			
			public void navigateToURL(WebDriver driver){
				siteURL="https://www.diply.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Diply";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				
				//Test Case 1 - Navigation to Diply
				ReportGenerator.verifyNavigation(this.driver, "Diply", parentTest,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndHighlight("Diply_logo", screen, parentTest, "Verify Diply logo", driver, testCaseName, "No");
				
				//Test case 2 - Verify Diply favicon
				SikuliUtil.verifyObjectAndHighlight("Diply_favicon", screen, parentTest, "Verify favicon of Diply", driver, testCaseName, "Yes");
				
				//Test case 3 - Verify Trending tab is opened By default
				SikuliUtil.verifyObjectAndHighlight("Opened_trendingTab", screen, parentTest, "Verify Trending tab opened Bydefault", driver, testCaseName, "Yes");
				
				
				//Test case 4 - Verify navigating Video tab
			
				SikuliUtil.verifyObjectAndClickOn("Videos_tab", screen, parentTest, "Verify navigating to Videos tab", driver, testCaseName, "Yes");
		
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "Videos", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Diply_favicon", screen, parentTest, "Verify favicon of Diply", driver, testCaseName, "No");
				
				//Test case 5 - Verify navigating back to home page
				SikuliUtil.verifyObjectAndClickOn("Diply_logo", screen, parentTest, "Verify navigating back to Home by clicking logo", driver, testCaseName, "Yes");
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "Diply", parentTest,testCaseName,"No");
				
				//Test case 6 - Verify opening and closing Diply menu
				SikuliUtil.verifyObjectAndClickOn("Diply_menu", screen, parentTest, "Verify cliking diply menu button", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("menu_close_button", screen, parentTest, "Diply menu opened", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("menu_close_button", screen, parentTest, "Verify closing diply menu", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("Diply_menu", screen, parentTest, "Diply menu opened and closed successfully", driver, testCaseName, "Yes");
				Sleep(2000);
				
				//Test case 7 - Verify navigating Style tab from menu
				SikuliUtil.verifyObjectAndClickOn("Diply_menu", screen, parentTest, "Verify cliking diply menu button", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Style_tab", screen, parentTest, "Verify navigating to Style tab from Diply menu", driver, testCaseName, "Yes");
				Sleep(1000);
				ReportGenerator.verifyNavigation(this.driver, "Style", parentTest,testCaseName,"No");
				
				//Test case 8 - Verify scrolling on Page
				SikuliUtil.verifyObjectAndClickOn("Diply_menu", screen, parentTest, "Verify cliking diply menu button", driver, testCaseName, "No");
				Sleep(1000);
				SikuliUtil.verifyObjectAndClickOn("AboutUs_tab", screen, parentTest, "Verify navigating to About Us tab from Diply menu", driver, testCaseName, "No");
				Sleep(1000);
				SikuliUtil.moveWheel(screen, 1, 90);
				Sleep(15000);
				if(SikuliUtil.isPresent(screen, "contactUs_section")){
				SikuliUtil.verifyObjectAndHighlight("contactUs_section", screen, parentTest, "page scrolled down successfully", driver, testCaseName, "No");
				}
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_HOME);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("aboutUs_section", screen, parentTest, "Scrolling is working fine", driver, testCaseName, "Yes");
				
				//Test case 9 - Reloading the page
				Sleep(2000);
		
				SikuliUtil.mouseRightClick("aboutUs_section", screen);

				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Reload_button", screen, parentTest, "Verify reloading the page", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("aboutUs_section", screen, parentTest, "Page reloaded successfuly", driver, testCaseName, "Yes");
				
			
			   
				
				
				
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Diply TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Diply TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}	