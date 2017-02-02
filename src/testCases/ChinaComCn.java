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

public class ChinaComCn extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing ChinaComCn");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="www.china.com.cn";
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
		path=path+"/ChinaComCn";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			
			
			// Starting test.. 
		  Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			//TestCase#1-Verifying Navigation to home page			
			ReportGenerator.verifyNavigation(this.driver, "中国网--网上中国", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"China.com.cn Home Logo verified",driver,testCaseName,"No");
			Sleep(4000);
			SikuliUtil.verifyObjectAndHighlight("ChinaComCn_favicon", screen, parentTest,"China.com.cn favicon verification",this.driver,testCaseName,"Yes");
			//TestCase#3-Verify Finance related news page
			SikuliUtil.verifyObjectAndClickOn("Finance", screen, parentTest,"China.com.cn Finance tab clicked",driver,testCaseName,"No");
			Sleep(9000);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Sleep(2000);
            ReportGenerator.verifyNavigation(this.driver, "财经中心_中国网", parentTest,testCaseName,"No");
            SikuliUtil.verifyObjectAndHighlight("ChinaComCn_favicon", screen, parentTest,"China.com.cn favicon verification",this.driver,testCaseName,"No");
            Sleep(2000);
            SikuliUtil.verifyObjectAndHighlight("FinanceLogo", screen, parentTest,"China.com.cn Finance page loaded successfully",this.driver,testCaseName,"Yes");
            screen.wheel(1, 40);			
			Sleep(4000);
			//TestCase#4-Verifying Browser Tab navigation
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs2.get(0));
			Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver, "中国网--网上中国", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"China.com.cn Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("ChinaComCn_favicon", screen, parentTest,"China.com.cn Home page navigated successfully after switching tab",this.driver,testCaseName,"Yes");
			Sleep(2000);
			//TestCase#5-Verifying Search Functionality
			
			SikuliUtil.verifyObjectAndClickOn("Search", screen, parentTest,"China.com.cn search textbox clicked",driver,testCaseName,"No");
			Sleep(5000);
			screen.paste("Jackie Chan");
			Sleep(2000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(8000);
			ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs3.get(1));
            Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver,"中国网中文站内检索", parentTest,testCaseName,"No");
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("HomeLogo1", screen, parentTest,"China.com.cn search functionality validated",driver,testCaseName,"Yes");
			Sleep(3000);
			screen.wheel(1, 40);			
			Sleep(4000);
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs3.get(0));
			Sleep(2000);

			
			//TestCase#6-Verifying China.com.cn English Version page			
			Sleep(5000);
			SikuliUtil.verifyObjectAndClickOn("English", screen, parentTest, "China.com.cn English link clicked", driver, testCaseName, "No");
			
			Sleep(8000);
			ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs4.get(1));
            Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver, "China.org.cn - China news, weather, business, travel & language courses", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("ChinaComCn_favicon", screen, parentTest,"ChinaComCn Favicon Highlighted",this.driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("EnglishLogo", screen, parentTest,"China.com.cn English version page loaded successfully",driver,testCaseName,"Yes");
			Sleep(3000);
			
			//TestCase#7-Trending news page
			SikuliUtil.clickBelow("EnglishLogo", screen, parentTest, "Clicking on trending news", driver, testCaseName, "No", 220);
			Sleep(8000);
			ReportGenerator.verifyNavigation(this.driver, "China.org.cn", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("ChinaComCn_favicon", screen, parentTest,"ChinaComCn Favicon Highlighted",this.driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("TrendingNewsNavigation", screen, parentTest,"ChinaComCn Trending news page loaded",this.driver,testCaseName,"Yes");
			Sleep(2000);
			screen.wheel(1,40);			
			Sleep(6000);	
			
			
			//TestCase#8-Verifying Right Click and Back Functionality
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			
			Sleep(7000);
			ReportGenerator.verifyNavigation(this.driver, "China.org.cn - China news, weather, business, travel & language courses", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("EnglishLogo", screen, parentTest,"China.org.cn English version Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("ChinaComCn_favicon", screen, parentTest,"Home page redirection after Alt+Left keys ",this.driver,testCaseName,"Yes");
			
			Sleep(2000);
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The ChinaComCn TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The ChinaComCn TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}