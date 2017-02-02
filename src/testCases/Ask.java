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

public class Ask extends Base{

	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Ask");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.ask.com";
			driver.navigate().to(baseurl+siteURL);
			}
		

	
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Ask";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//1	Verify Navigation to ask.com
				ReportGenerator.verifyNavigation(this.driver, "Ask", parentTest,testCaseName,"Yes");
				
				//2	Verify ASk favicon
				SikuliUtil.verifyObjectAndHighlight("Ask_Favicon", screen, parentTest,"Verify Ask favicon",this.driver,testCaseName,"Yes");
				
				Sleep(3000);
				
				//3	Verify Search Functionality
				//3-a Click inside the Search box
				SikuliUtil.verifyObjectAndClickOn("Ask_Search_Box", screen, parentTest, "Clicking inside search box", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//3-b	Type in the Search text
				SikuliUtil.typeScreen(screen, "cyberinc.com"+Key.ENTER);
				
				Sleep(3000);
				
				//3-c	Verify the search results
				SikuliUtil.verifyObjectAndClickOn("Ask_Verify_Search", screen, parentTest, "Verify Successfull Search", driver, testCaseName, "Yes");
				
				SikuliUtil.moveWheel(screen, 1, 10);
				
				Sleep(3000);
				
				//4	Open a search result from Ask.com
				//4-a	Click on the Search Result
				SikuliUtil.verifyObjectAndClickOn("Ask_CyberInc_Result", screen, parentTest, "Verifying Search Results", driver, testCaseName, "No");
				
				Sleep(5000);
				
				//4-b	Verify cyberinc logo
				SikuliUtil.verifyObjectAndHighlight("Ask_CyberInc_Logo", screen, parentTest, "Verifying Successfull Navigation to a Search Result", driver, testCaseName, "Yes");
				
				Sleep(3000);
				
				//5	Verify Scroll Down on Ask.com
				//5-a Close the tab
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL,KeyEvent.VK_W );
				
				Sleep(2000);
				
				
				SikuliUtil.verifyObjectAndClickOn("Ask_Focus_Page", screen, parentTest, "Focussing on the result page", driver, testCaseName, "No");
				
				Sleep(2000);
				//5-b	Press End
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				
				Sleep(3000);
				
				//5-c Verify Footer
				SikuliUtil.verifyObjectAndHighlight("Ask_Footer", screen, parentTest, "Verifying Scroll down on Ask.com", driver, testCaseName, "Yes");
				
				Sleep(3000);
				
				//6	Verify Navigation to Next Search result page
				//6-a	Click on Next
				SikuliUtil.verifyObjectAndClickOn("Ask_Next", screen, parentTest, "Navigating to next search result page", driver, testCaseName, "No");
				
				Sleep(3000);
				
				//6-b Verify Search result on next Page
				SikuliUtil.verifyObjectAndHighlight("Ask_Next_Search_Page", screen, parentTest, "Verifying navigation to next search result page ", driver, testCaseName, "Yes");
				
				//7	Verifying Scroll up
				//7-a Press End
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				
				Sleep(3000);
				
				//7-b Press Home
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				
				Sleep(3000);
				
				//7-c Verify Scroll up
				SikuliUtil.verifyObjectAndHighlight("Ask_Scroll_Up", screen, parentTest, "Verifying Scroll Up on Ask.com ", driver, testCaseName, "Yes");
				
				
								
			}catch(Exception e){
				
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The Ask.com TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				
				
			}
			finally{
			quitDriver(this.driver);
				path=currentSitePath;
			ReportGenerator.flushReportToDisk(parentTest);
			}	
		}
}
