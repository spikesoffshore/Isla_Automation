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

public class EttodayTW extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing EttodayTW");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="www.ettoday.net";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Thakur");
		
		
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/EttodayTW";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			
			// Starting test.. 

			// Starting test.. 
		   Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			//TestCase#1-Verifying Navigation to home page			
			ReportGenerator.verifyNavigation(this.driver, "ETtoday 東森新聞雲 | 樂在分享‧愛上雲端", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"ETtoday Taiwan Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("EttodayTW_favicon", screen, parentTest,"ETtoday Taiwan favicon verification",this.driver,testCaseName,"Yes");
			
			
			//TestCase#3-Verifying ETtoday Trending news page 			
			Sleep(2000);
			SikuliUtil.clickBelow("HomeLogo", screen, parentTest, "Verify Trending News", driver, testCaseName, "No", 450);
			
			Sleep(10000);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
           
            
            Sleep(4000);
            ReportGenerator.verifyNavigation(this.driver, "ETtoday", parentTest,testCaseName,"No");
            Sleep(4000);
			SikuliUtil.verifyObjectAndHighlight("EttodayTW_favicon", screen, parentTest,"Verification of Trending news page done successfully",this.driver,testCaseName,"Yes");
			Sleep(2000);
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs2.get(0));
			Sleep(2000);
			
			//TestCase#4-Verifying Browser Tab navigation
			
			ReportGenerator.verifyNavigation(this.driver, "ETtoday 東森新聞雲 | 樂在分享‧愛上雲端", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("EttodayTW_favicon", screen, parentTest,"ETtoday Taiwan Home page navigated successfully after switching tab",this.driver,testCaseName,"Yes");
			
			
			//TestCase#5-Verifying Search Functionality
			
			SikuliUtil.verifyObjectAndClickOn("Search", screen, parentTest,"ETtoday Taiwan search textbox clicked",driver,testCaseName,"No");
			Sleep(5000);
			screen.paste("周渝民");
			Sleep(2000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(8000);
			ReportGenerator.verifyNavigation(this.driver, "周渝民熱門搜尋 | 新聞搜尋 | ETtoday 新聞雲", parentTest,testCaseName,"No");
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("EttodayTW_favicon", screen, parentTest,"Searching functionality for ETtoday Taiwan Sucessfully",driver,testCaseName,"Yes");
			Sleep(3000);
			screen.wheel(1, 40);			
			Sleep(4000);
			

			//TestCase#6-Verifying Alt+Left Key press functionality
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
						
			Sleep(6000);
			ReportGenerator.verifyNavigation(this.driver, "ETtoday 東森新聞雲 | 樂在分享‧愛上雲端", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("EttodayTW_favicon", screen, parentTest,"ETtoday Taiwan Home page redirection after Alt+Left keys",this.driver,testCaseName,"Yes");
			
			//TestCase#7-Verifying Ettoday 3C page			
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("Menu", screen, parentTest, "ETtoday Taiwan Menu link clicked", driver, testCaseName, "No");
			
			Sleep(4000);
			SikuliUtil.verifyObjectAndClickOn("SubMenu", screen, parentTest, "ETtoday Taiwan SubMenu 3C link clicked", driver, testCaseName, "No");
			
			Sleep(4000);
			ReportGenerator.verifyNavigation(this.driver, "ETtoday3C科技新聞 | ETtoday 新聞雲", parentTest,testCaseName,"No");
			Sleep(2000);
			
			
			SikuliUtil.verifyObjectAndHighlight("EttodayTW_favicon", screen, parentTest,"EttodayTW 3C News page loaded successfully",this.driver,testCaseName,"Yes");
			Sleep(2000);
		
			screen.wheel(1,40);			
			Sleep(6000);	
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
			Sleep(4000);
			
			//TestCase#8-Verifying Ettoday Facebook Link page	
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("Facebook", screen, parentTest, "ETtoday Taiwan Facebook link clicked", driver, testCaseName, "No");
			Sleep(9000);
			ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs3.get(1));
			
            Sleep(5000);
			
			ReportGenerator.verifyNavigation(this.driver, "ETtoday新聞雲", parentTest,testCaseName,"No");
			Sleep(4000);
			SikuliUtil.verifyObjectAndHighlight("Facebook_Favicon", screen, parentTest,"ETToday Taiwan Facebook Linked page loaded successfully",driver,testCaseName,"Yes");
			Sleep(4000);
			
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The EttodayTW TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The EttodayTW TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
				//	quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}