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

public class YnetCoIlHB extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing YnetCoIlHB");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="www.ynet.co.il";
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
		path=path+"/YnetCoIlHB";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			// Starting test.. 
		  Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			//TestCase#1-Verifying Navigation to home page			
			ReportGenerator.verifyNavigation(this.driver, "ynet - חדשות, כלכלה, ספורט, בריאות", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"ynet.co.il Home Logo verified",driver,testCaseName,"No");
			Sleep(4000);
			//SikuliUtil.verifyObjectAndHighlight("YnetCoIlHB_favicon", screen, parentTest,"ynet.co.il favicon verification",this.driver,testCaseName,"Yes");
			
		
			//TestCase#3-Verify Weather related news page
			SikuliUtil.verifyObjectAndClickOn("Weather", screen, parentTest,"ynet.co.il weather tab clicked",driver,testCaseName,"No");
			Sleep(9000);
			
            ReportGenerator.verifyNavigation(this.driver, "ynet - מזג האוויר", parentTest,testCaseName,"No");
            SikuliUtil.verifyObjectAndHighlight("Weather_Favicon", screen, parentTest,"ynet.co.il weather favicon verification",this.driver,testCaseName,"No");
            Sleep(2000);
            SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"ynet.co.il Weather page loaded successfully",this.driver,testCaseName,"Yes");
            //TestCase#4-Home page redirection after clicking Home Logo
            Sleep(2000);
            SikuliUtil.verifyObjectAndClickOn("HomeLogo", screen, parentTest,"ynet.co.il Home Logo Clicked",driver,testCaseName,"No");
			
			Sleep(14000);
			//TestCase#5- Verify Browser handling
			 
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs2.get(1));
			
			ReportGenerator.verifyNavigation(this.driver, "ynet - חדשות, כלכלה, ספורט, בריאות", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Browser Tab handled successfully",driver,testCaseName,"Yes");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("YnetCoIlHB_favicon", screen, parentTest,"Home page redirection after clicking Home Logo",this.driver,testCaseName,"Yes");
			Sleep(2000);
			
			//TestCase#6-Trending news page
		  	
			SikuliUtil.clickBelow("English", screen, parentTest, "Clicking on trending news", driver, testCaseName, "No", 100);
			Sleep(8000);
			
			ReportGenerator.verifyNavigation(this.driver,"ynet", parentTest,testCaseName,"No");
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"ynet.co.il Home Logo verified",driver,testCaseName,"No");
			
			SikuliUtil.moveWheel(screen, 1, 40);
			
			Sleep(6000);
			SikuliUtil.verifyObjectAndHighlight("YnetCoIlHB_favicon", screen, parentTest,"ynet.co.il Trending news page loaded successfully",driver,testCaseName,"Yes");
			Sleep(3000);
			
			
			//TestCase#7-Verifying Alt+Tab keyword functionality
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			
			Sleep(7000);
			
			ReportGenerator.verifyNavigation(this.driver, "ynet - חדשות, כלכלה, ספורט, בריאות", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"ynet.co.il Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("YnetCoIlHB_favicon", screen, parentTest,"ynet.co.il Home page navigated successfully after switching tab",this.driver,testCaseName,"Yes");
			Sleep(2000);
			
			
			//TestCase#8-Verifying ynet.co.il English Version page			
			Sleep(5000);
			SikuliUtil.verifyObjectAndClickOn("English", screen, parentTest, "ynet.co.il English link clicked", driver, testCaseName, "No");
			
			Sleep(8000);
			ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs4.get(1));
            Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver, "Ynetnews - Homepage", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("HomeLogo1", screen, parentTest,"ynet.co.il English version page loaded successfully",driver,testCaseName,"Yes");
			Sleep(3000);
			
			//TestCase#9-Verifying Business Tab
			SikuliUtil.verifyObjectAndClickOn("Business", screen, parentTest, "ynet.co.il English Business tab link clicked", driver, testCaseName, "No");
			
			Sleep(7000);
			ReportGenerator.verifyNavigation(this.driver, "Ynetnews - Business", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("HomeLogo1", screen, parentTest,"ynet.co.il English Business tab loaded",driver,testCaseName,"Yes");
			Sleep(2000);
			SikuliUtil.moveWheel(screen, 1, 40);
			
			Sleep(6000);
			
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
			Sleep(2000);
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The YnetCoIlHB TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The YnetCoIlHB TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}