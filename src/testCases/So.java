package testCases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class So extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing So");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="https://www.so.com/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Pokemon");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/So";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(10000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("So_favicon", screen, parentTest,"So favicon verification",this.driver,testCaseName,"Yes");
			
			//Home footer verification
			SikuliUtil.verifyObjectAndHighlight("So_footer", screen, parentTest, "Footer verification", this.driver, testCaseName, "Yes");
			
			//Click Wikipedia option- 维基百科
			SikuliUtil.verifyObjectAndClickOn("optionsWikipedia", screen, parentTest, "Click Wikipedia option", this.driver, testCaseName, "No");
			Sleep(3000);
			
			//Verify Wikipedia page by highlighting Help option	
			SikuliUtil.verifyObjectAndHighlight("Wikipedia_Helps", screen, parentTest, "Wikipedia option click", this.driver, testCaseName, "Yes");
			
			//Click Web option
			SikuliUtil.verifyObjectAndClickOn("optionsWeb", screen, parentTest, "Click Web option", this.driver, testCaseName, "No");
			Sleep(3000);
			
			//Verify Web page by highlighting 360 navigation
			SikuliUtil.verifyObjectAndHighlight("Web_360Navigation", screen, parentTest, "Web - 360 navigation", this.driver, testCaseName, "Yes");
			
			//Click News options
			SikuliUtil.verifyObjectAndClickOn("optionsNews", screen, parentTest, "Click News", this.driver, testCaseName, "No");
			Sleep(3000);
			
			//News logo highlight
			SikuliUtil.verifyObjectAndHighlight("News_logo", screen, parentTest, "News logo", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The So TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The So TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}

