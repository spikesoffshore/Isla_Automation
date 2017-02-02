package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class CCTV extends Base{
	
	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing CCTV");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.cctv.com";
			driver.navigate().to(baseurl+siteURL);
			}
		

	
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/CCTV";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//1	Verify Navigation to CCTV English
				//1-a	Click on English button
				SikuliUtil.verifyObjectAndClickOn("CCTV_English", screen, parentTest, "Clicking on English link for the site", driver, testCaseName, "No");
				
				Sleep(5000);
				
				//1-b	Verify English Home Logo
				SikuliUtil.verifyObjectAndHighlight("CCTV_English_Logo", screen, parentTest, "Verifying navigation to CCTV English", driver, testCaseName, "Yes");
				
				//Verify Navigation to CCTV English
				ReportGenerator.verifyNavigation(this.driver, "CCTV", parentTest,testCaseName,"Yes");
				
				//2	Verify CCTV English Favicon
				SikuliUtil.verifyObjectAndHighlight("CCTV_Favicon", screen, parentTest, "Verifying CCTV Favicon", driver, testCaseName, "Yes");
				
				//3	Verify CCTV Chinese Logo
				SikuliUtil.verifyObjectAndHighlight("CCTV_Chinese_Logo", screen, parentTest, "Verifying CCTV Chinese Home Logo", driver, testCaseName, "Yes");
				
				//4	Verify CCTV Language Strip
				SikuliUtil.verifyObjectAndHighlight("CCTV_Language_Strip", screen, parentTest, "Verifying CCTV Language Strip", driver, testCaseName, "Yes");
				
				//5	Verify Scroll Down
				//5-a	Press End
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				
				Sleep(4000);
				
				//5-b	Verify Footer
				SikuliUtil.verifyObjectAndHighlight("CCTV_Footer", screen, parentTest, "Verifying scroll down on CCTV.com", driver, testCaseName, "Yes");
				
				//6	Verify Scroll up
				//6-a	Press home
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				
				Sleep(4000);
				
				//6-b	Verify English logo
				SikuliUtil.verifyObjectAndHighlight("CCTV_English_Logo", screen, parentTest, "Verifying ScrollUp on CCTV.com", driver, testCaseName, "Yes");
				
				//7	Verify Navigation to CCTV Arabic
				//7-a	Click on Arabic Logo
				SikuliUtil.verifyObjectAndClickOn("CCTV_Arabic", screen, parentTest, "Verifying navigation using a link in a different language", driver, testCaseName, "No");
				
				Sleep(5000);
				
				//7-b	Verify navigation to Arabic
				ReportGenerator.verifyNavigation(this.driver, "Arabic", parentTest,testCaseName,"Yes");
				
				//7-c	Highlight Arabic Home logo
				SikuliUtil.verifyObjectAndHighlight("CCTV_Arabic_Home_Logo", screen, parentTest, "Verifying navigation to CCTV Arabic", driver, testCaseName, "Yes");

			}catch(Exception e){
	
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The CCTV TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
	
	
			}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}	
		}
	}
