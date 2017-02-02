package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Sohu extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Sohu");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="http://www.sohu.com/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Thakur");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Sohu";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(10000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("Sohu_favicon", screen, parentTest,"Sohu favicon verification",this.driver,testCaseName,"Yes");
			
			//Site logo verification
			SikuliUtil.verifyObjectAndHighlight("Sohu_logo", screen, parentTest, "Sohu logo verification", this.driver, testCaseName, "Yes");
			Sleep(2000);
			
			//Click Tourism- 旅游
			SikuliUtil.verifyObjectAndClickOn("Sohu_Home_tourismOption", screen, parentTest, "Click tourism", this.driver, testCaseName, "No");
			Sleep(4000);
			
			//Travel page load verification
			SikuliUtil.verifyObjectAndHighlight("Sohu_Tourism_favicon", screen, parentTest, "Sohu-tourism site favicon verifiation", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("Sohu_Tourism_logo", screen, parentTest, "Sohu-tourism logo verification", this.driver, testCaseName, "Yes");
			Sleep(5000);
			
			//Key end press and footer verification
			SikuliUtil.keyPress(robot, KeyEvent.VK_END);
			Sleep(8000);
			SikuliUtil.verifyObjectAndHighlight("Travel_Footer", screen, parentTest, "Footer verification", this.driver, testCaseName, "Yes");
						
			//Home page navigation
			SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
			Sleep(4000);
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("Sohu_Tourism_favicon", screen, parentTest,"Sohu-tourism site favicon verifiation",this.driver,testCaseName,"No");
						
			//Home page verification
			SikuliUtil.verifyObjectAndHighlight("Sohu_Tourism_page", screen, parentTest, "Sohu tourism home page verification", this.driver, testCaseName, "Yes");
			
			////Mouse rightclick
			SikuliUtil.mouseRightClick("Sohu_Tourism_page", screen);
			Sleep(300);
			
			//Back option selection
			SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
			SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
			
			Sleep(3000);
			
			//Sohu home page verifcation post Browser back
			SikuliUtil.verifyObjectAndHighlight("Sohu_favicon", screen, parentTest,"Sohu favicon verification",this.driver,testCaseName,"No");
			
			//Site logo verification
			SikuliUtil.verifyObjectAndHighlight("Sohu_logo", screen, parentTest, "Navigation back to Sohu home page verification", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The Sohu TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Sohu TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}
