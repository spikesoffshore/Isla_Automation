package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Coccoc extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Coccoc");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="https://coccoc.com/";
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
		path=path+"/Coccoc";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(10000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("Coccoc_favicon", screen, parentTest,"Coccoc favicon verification",this.driver,testCaseName,"Yes");
			
			//Home page logo verification
			SikuliUtil.verifyObjectAndClickOn("Coccoc_logo", screen, parentTest, "Coccoc logo verification", this.driver, testCaseName, "Yes");
			Sleep(3000);
			
			//Page end 
			SikuliUtil.keyPress(robot, KeyEvent.VK_END);
			Sleep(5000);
			
			//Footer verification
			SikuliUtil.verifyObjectAndHighlight("Coccoc_footer", screen, parentTest, "Footer verification", this.driver, testCaseName, "Yes");
			
			//Introduction link click
			SikuliUtil.verifyObjectAndClickOn("Coccoc_Footer_Introduction", screen, parentTest, "Click Introduction link", this.driver, testCaseName, "No");
			Sleep(4000);
			
			//Introduction page verification
			SikuliUtil.verifyObjectAndHighlight("Coccoc_Introduction_logo", screen, parentTest, "Introduction page verification", this.driver, testCaseName, "Yes");
			
			//Home page click
			SikuliUtil.verifyObjectAndClickOn("Introduction_Back_Home", screen, parentTest, "Click home page", this.driver, testCaseName, "No");
			Sleep(4000);
			
			//Home page logo verification
			SikuliUtil.verifyObjectAndClickOn("Coccoc_logo", screen, parentTest, "Coccoc home page link click verification", this.driver, testCaseName, "Yes");
			Sleep(3000);
			
			//Page end 
			SikuliUtil.keyPress(robot, KeyEvent.VK_END);
			Sleep(5000);
			
			//Footer verification
			SikuliUtil.verifyObjectAndHighlight("Coccoc_footer", screen, parentTest, "Footer verification", this.driver, testCaseName, "No");
			SikuliUtil.verifyObjectAndClickOn("Footer_postAnAd", screen, parentTest, "Click post an Ad link", this.driver, testCaseName, "No");
			Sleep(3000);
			
			//Verify post an ad page logo verification
			SikuliUtil.verifyObjectAndHighlight("PostAnAd_Logo", screen, parentTest, "Post an ad page logo verification", this.driver, testCaseName, "Yes");
			
			//Click Cost and Payment link
			SikuliUtil.verifyObjectAndClickOn("PostAnAd_CostAndPayment", screen, parentTest, "Click Cost and payment link", this.driver, testCaseName, "No");
			Sleep(3000);
			
			//Verify cash and payment method page
			SikuliUtil.verifyObjectAndHighlight("PostAnAd_CostAndPayment_PageHeader", screen, parentTest, "Cash and payment method page verification", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The Coccoc TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Coccoc TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}
			
