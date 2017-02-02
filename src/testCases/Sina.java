package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Sina extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Sina");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="http://www.sina.com.cn/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Gabbar");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Sina";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(10000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			
			//Favicon verification
			//SikuliUtil.verifyObjectAndHighlight("Sina_favicon", screen, parentTest,"Sina favicon verification",this.driver,testCaseName,"Yes");
			
			//Logo verification
			SikuliUtil.verifyObjectAndHighlight("Sina_Logo", screen, parentTest, "Sina home page logo verification", this.driver, testCaseName, "Yes");
			
			//site Navigation - Click - 网站导航
			SikuliUtil.verifyObjectAndClickOn("Sina_SiteNavigation", screen, parentTest, "Click Site Navigation", this.driver, testCaseName, "No");
			Sleep(4000);
			
			//Driver switch
			 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			 driver.switchTo().window(tabs2.get(1));
			    
			//Site Navigation 
			SikuliUtil.verifyObjectAndHighlight("Sina_Logo_withoutSite", screen, parentTest, "Sina logo check after Site Navigation link click", this.driver, testCaseName, "Yes");
			Sleep(3000);
			
			//NBA link click
			SikuliUtil.verifyObjectAndClickOn("Sina_siteNavigation_NBA", screen, parentTest, "Click NBA", this.driver, testCaseName, "No");
			Sleep(7000);
			
			//NBA page load verification
			SikuliUtil.verifyObjectAndHighlight("Sina_NBA_options", screen, parentTest, "NBA options verification", this.driver, testCaseName, "Yes");
			
			//Click Car- 汽车
			SikuliUtil.verifyObjectAndClickOn("Sina_NBA_Car", screen, parentTest, "Click Car", this.driver, testCaseName, "No");
			Sleep(7000);
			
			//Car page load verification
			SikuliUtil.verifyObjectAndHighlight("Sina_NBA_Car_Options", screen, parentTest, "Car options verification", this.driver, testCaseName, "Yes");
			
			//Browser back navigation
			for(int i=0;i<2;i++) {
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
			}
			Sleep(6000);
			
			//Browser back navigation verification
			SikuliUtil.verifyObjectAndHighlight("Sina_Site_latestRecommended", screen, parentTest, "Site navigation page verification post ALT+Left keypress", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The Sina TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Sina TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					//quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}
