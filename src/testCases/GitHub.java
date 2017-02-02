package testCases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class GitHub extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing GitHub");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="https://github.com/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Mickey");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/GitHub";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(8000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecution(this.driver);
			
			//Home page verification based on the title
			ReportGenerator.verifyNavigation(this.driver, "GitHub", parentTest,testCaseName,"Yes");
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("GitHub_favicon", screen, parentTest,"Verify GitHub favicon",this.driver,testCaseName,"Yes");
			
			//GitLogin 
			SikuliUtil.verifyObjectAndClickOn("GitHub_SignIn", screen, parentTest, "Click Signin", this.driver, testCaseName, "No");
			Sleep(3000);
			SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
			SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
			Sleep(5000);
			//GitHome page check
			SikuliUtil.verifyObjectAndHighlight("Home_text", screen, parentTest, "Verify Login", this.driver, testCaseName, "Yes");
			
			//GitSearch 
			SikuliUtil.verifyObjectAndClickOn("Home_Search", screen, parentTest, "Search Selenium", this.driver, testCaseName, "No");
			SikuliUtil.verifyObjectAndType("Home_Search", screen, parentTest, "Search Selenium", this.driver, testCaseName, "No", "selenium"+Key.ENTER);
			Sleep(3000);
			
			//verify search
			SikuliUtil.verifyObjectAndHighlight("Selenium_search_result", screen, parentTest, "Verify selenium search result page", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("Selenium_SearchResult_Link", screen, parentTest, "Click Selenium", this.driver, testCaseName, "No");
			Sleep(3000);
			
			//verify Selenium page
			SikuliUtil.verifyObjectAndHighlight("Selenium_title", screen, parentTest, "Verify selenium link click", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("Selenium_Issues", screen, parentTest, "Click Issues", this.driver, testCaseName, "No");
			Sleep(3000);
			
			//Selenium issue search
			SikuliUtil.verifyObjectAndType("Issue_Filter", screen, parentTest, "Selenium issue tab navigation", this.driver, testCaseName, "Yes", "3299"+Key.ENTER);
			SikuliUtil.verifyObjectAndClickOn("Issue_Link", screen, parentTest, "Click Issue Link", this.driver, testCaseName, "No");
			
			//Issue page load
			ReportGenerator.verifyNavigation(this.driver, "3299", parentTest,testCaseName,"Yes");
			SikuliUtil.verifyObjectAndHighlight("GitHub_favicon", screen, parentTest,"Verify GitHub favicon",this.driver,testCaseName,"No");
			
			//LogOut
			SikuliUtil.verifyObjectAndClickOn("User_icon", screen, parentTest, "Click User icon", this.driver, testCaseName, "No");
			Sleep(200);
			SikuliUtil.verifyObjectAndClickOn("User_SignOut", screen, parentTest, "Click SignOut", driver, testCaseName, "Yes");
			Sleep(4000);
			
			//LogOut verification
			ReportGenerator.verifyNavigation(this.driver, "How people build software", parentTest,testCaseName,"Yes");
			SikuliUtil.verifyObjectAndHighlight("GitHub_Logo", screen, parentTest, "Verify GitHub logo on Home page", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The GitHub TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The GitHub TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
				    quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}
