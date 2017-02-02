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

public class CsdnNetCn extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing CsdnNetCn");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="http://www.csdn.net";
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
		path=path+"/CsdnNetCn";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			
			
			// Starting test.. 
		  Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			//TestCase#1-Verifying Navigation to home page			
			ReportGenerator.verifyNavigation(this.driver, "CSDN.NET - 全球最大中文IT社区，为IT专业技术人员提供最全面的信息传播和服务平台", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Csdn.net Home Logo verified",driver,testCaseName,"No");
			Sleep(7000);
			SikuliUtil.verifyObjectAndHighlight("CsdnNetCn_favicon", screen, parentTest,"Csdn.net favicon verification",this.driver,testCaseName,"Yes");
			//TestCase#3-Verify Geek Headlines related news page
			SikuliUtil.verifyObjectAndClickOn("GeekHeadlines", screen, parentTest,"Csdn.net Geek News tab clicked",driver,testCaseName,"No");
			Sleep(9000);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Sleep(5000);
            ReportGenerator.verifyNavigation(this.driver, "最新最热", parentTest,testCaseName,"No");
            SikuliUtil.verifyObjectAndHighlight("CsdnNetCn_favicon", screen, parentTest,"Csdn.net favicon verification",this.driver,testCaseName,"No");
            Sleep(2000);
            SikuliUtil.verifyObjectAndHighlight("GeekPage", screen, parentTest,"Csdn.net Geek News page loaded successfully",this.driver,testCaseName,"Yes");
            screen.wheel(1, 40);			
			Sleep(4000);
			//TestCase#4-Verifying Browser Tab navigation
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs2.get(0));
			Sleep(4000);
			ReportGenerator.verifyNavigation(this.driver, "CSDN.NET - 全球最大中文IT社区，为IT专业技术人员提供最全面的信息传播和服务平台", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Csdn.net Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("CsdnNetCn_favicon", screen, parentTest,"Csdn.net Home page navigated successfully after switching tab",this.driver,testCaseName,"Yes");
			Sleep(2000);
			//TestCase#5-Verifying Search Functionality
			
			SikuliUtil.verifyObjectAndClickOn("Search", screen, parentTest,"Csdn.net search textbox clicked",driver,testCaseName,"No");
			Sleep(5000);
			screen.paste("Cyber Security");
			Sleep(2000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(8000);
			ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs3.get(1));
            Sleep(6000);
			ReportGenerator.verifyNavigation(this.driver,"CSDN搜索", parentTest,testCaseName,"No");
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("SearchLogo", screen, parentTest,"Csdn.net search functionality validated",driver,testCaseName,"Yes");
			Sleep(3000);
			screen.wheel(1, 40);			
			Sleep(4000);
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs3.get(0));
			Sleep(2000);

			
			//TestCase#6-Verify Azure related news page		
			Sleep(5000);
			SikuliUtil.verifyObjectAndClickOn("Azure", screen, parentTest, "Csdn.net Azure link clicked", driver, testCaseName, "No");
			
			Sleep(8000);
			ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs4.get(1));
            Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver, "微软Azure中文技术社区-首页", parentTest,testCaseName,"No");
			Sleep(2000);
		
			SikuliUtil.verifyObjectAndHighlight("AzureLogo", screen, parentTest,"Csdn.net Azure related news page loaded successfully",driver,testCaseName,"Yes");
			Sleep(3000);
			screen.wheel(1,40);			
			Sleep(6000);
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs4.get(0));
			Sleep(2000);
			//TestCase#7-Registration page and SignIn Error message validation
			
			
			SikuliUtil.verifyObjectAndClickOn("Register", screen, parentTest, "Csdn.net Registration link clicked", driver, testCaseName, "No");
			Sleep(8000);
			ReportGenerator.verifyNavigation(this.driver, "注册帐号", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("SignIn", screen, parentTest,"CsdnNetCn SignIn Link Clicked",this.driver,testCaseName,"No");
			Sleep(4000);
			SikuliUtil.verifyObjectAndHighlight("ErrorMessage", screen, parentTest,"CsdnNetCn SignIn Error message validated",this.driver,testCaseName,"Yes");
			Sleep(2000);
				
			
			
			//TestCase#8-Verifying Alt+Left and Back Functionality
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			Sleep(2000);
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			Sleep(7000);
			ReportGenerator.verifyNavigation(this.driver, "CSDN.NET - 全球最大中文IT社区，为IT专业技术人员提供最全面的信息传播和服务平台", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Csdn.net Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("CsdnNetCn_favicon", screen, parentTest,"Home page redirection after Alt+Left keys ",this.driver,testCaseName,"Yes");
			
			Sleep(2000);
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The CsdnNetCn TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The CsdnNetCn TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}