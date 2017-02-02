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

public class Three60 extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing 360");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="360.cn";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Kancha");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/360";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(10000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			
			//Home page verification based on the title
			ReportGenerator.verifyNavigation(this.driver, "360", parentTest,testCaseName,"Yes");
			
			//Home page verification
			SikuliUtil.verifyObjectAndHighlight("360_homeLogo", screen, parentTest, "Verify 360 home page load", this.driver, testCaseName, "Yes");
			
			//mouse over mobile application
			SikuliUtil.verifyObjectAndHighlight("360_homeMobileApplications", screen, parentTest, "Mouse hover mobile applications", this.driver, testCaseName, "No");
			Sleep(200);
			SikuliUtil.verifyObjectAndHighlight("360_homeMobileAppsOptions", screen, parentTest, "Verify mobile applications options", this.driver, testCaseName, "Yes");
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("360_favicon", screen, parentTest,"Verify 360 favicon",this.driver,testCaseName,"Yes");
			
			
			//click 360 mall
			SikuliUtil.verifyObjectAndClickOn("360mall", screen, parentTest, "Click 360 mall", this.driver, testCaseName, "No");
			Sleep(8000);
			
			//Driver switch
			 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(1));
			
			//360 mall page load verification
			SikuliUtil.verifyObjectAndClickOn("360mall_homeLogo", screen, parentTest, "360 mall logo verification", this.driver, testCaseName, "Yes");
			Sleep(4000);			
			//Key end press and footer verification
			SikuliUtil.keyPress(robot, KeyEvent.VK_END);
			Sleep(8000);
			SikuliUtil.verifyObjectAndHighlight("Footer", screen, parentTest, "Verify footer", this.driver, testCaseName, "Yes");
						
			//Home page navigation
			SikuliUtil.verifyObjectAndClickOn("360mall_backToTop", screen, parentTest, "Click Top", this.driver, testCaseName, "No");
			Sleep(4000);
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("360mall_favicon", screen, parentTest,"Verify 360 mall favicon",this.driver,testCaseName,"Yes");
						
			//Home page verification
			SikuliUtil.verifyObjectAndHighlight("360mall_cart", screen, parentTest, "Cart display on home page", this.driver, testCaseName, "Yes");
			
			//360 mall tab close
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    Sleep(2000);	
			
		    //360 home page verification
		    SikuliUtil.verifyObjectAndHighlight("360_home_global", screen, parentTest, "Navigation back to 360", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The 360 TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The 360 TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
				//	quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}


