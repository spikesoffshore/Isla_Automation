package testCases;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Taobao extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Taobao");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="https://world.taobao.com/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Jackie");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Taobao";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(10000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			
			//Home page verification based on the title
			//ReportGenerator.verifyNavigation(this.driver, "GitHub", parentTest,testCaseName,"Yes");
			
			//Home page verification
			SikuliUtil.verifyObjectAndHighlight("Taobao_HomeLogo", screen, parentTest, "Verify home page", this.driver, testCaseName, "Yes");
			
			//Dresses click
			SikuliUtil.verifyObjectAndClickOn("Dresses", screen, parentTest, "Click Dresses", this.driver, testCaseName, "No");
			Sleep(8000);
			
			//Driver switch
			 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(1));
			   
			//Dresses page load verification
			SikuliUtil.verifyObjectAndHighlight("dresses_PageNavigator", screen, parentTest, "Verify page navigation to dresses page", this.driver, testCaseName, "Yes");
			
			//Language selector
			SikuliUtil.verifyObjectAndClickOn("languageSelectorMenu", screen, parentTest, "Click language selector", this.driver, testCaseName, "No");
			Sleep(1000);
			SikuliUtil.verifyObjectAndClickOn("selectLanguage", screen, parentTest, "Select language", this.driver, testCaseName, "No");
			Sleep(300);
			SikuliUtil.verifyObjectAndHighlight("langDisplay", screen, parentTest, "Language options", this.driver, testCaseName, "Yes");
			Sleep(1000);
			SikuliUtil.verifyObjectAndClickOn("selectLanguage", screen, parentTest, "Select language", this.driver, testCaseName, "No");
			
			SikuliUtil.verifyObjectAndClickOn("Taobao_HomeLogo", screen, parentTest, "Verify home page", this.driver, testCaseName, "No");
			Sleep(2000);
			//Page end key press
			screen.type(Key.END);
			//SikuliUtil.keyPress(robot, KeyEvent.VK_END);
			Sleep(8000);
			SikuliUtil.verifyObjectAndHighlight("Footer", screen, parentTest, "Verify footer", this.driver, testCaseName, "Yes");
						
			//Home page navigation
			screen.type(Key.HOME);
			Sleep(4000);
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("Taobao_favicon", screen, parentTest,"Verify Taobao favicon",this.driver,testCaseName,"Yes");
						
			//Home page verification
			SikuliUtil.verifyObjectAndHighlight("Taobao_HomeLogo", screen, parentTest, "Verify home page", this.driver, testCaseName, "Yes");
					
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    Sleep(2000);	
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The Taobao TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Taobao TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					//quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}

			
			


