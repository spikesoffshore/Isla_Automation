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

public class PeopleComCn extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing PeopleComCn");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="www.People.com.cn";
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
		path=path+"/PeopleComCn";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			
			
			// Starting test.. 
		  Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			//TestCase#1-Verifying Navigation to home page			
			ReportGenerator.verifyNavigation(this.driver, "人民网", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"People.com.cn Home Logo verified",driver,testCaseName,"No");
			Sleep(4000);
			SikuliUtil.verifyObjectAndHighlight("PeopleComCn_favicon", screen, parentTest,"People.com.cn favicon verification",this.driver,testCaseName,"Yes");
			//TestCase#3-Verify Politics related news page
			SikuliUtil.verifyObjectAndClickOn("Politics", screen, parentTest,"People.com.cn Politics tab clicked",driver,testCaseName,"No");
			Sleep(9000);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Sleep(2000);
            ReportGenerator.verifyNavigation(this.driver, "时政--人民网", parentTest,testCaseName,"No");
            SikuliUtil.verifyObjectAndHighlight("PeopleComCn_favicon", screen, parentTest,"People.com.cn favicon verification",this.driver,testCaseName,"No");
            Sleep(2000);
            SikuliUtil.verifyObjectAndHighlight("PoliticsLogo", screen, parentTest,"People.com.cn Politics page loaded successfully",this.driver,testCaseName,"Yes");
            screen.wheel(1, 40);			
			Sleep(6000);
			//TestCase#4-Verifying Browser navigation
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs2.get(0));
			Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver, "人民网", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"People.com.cn Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("PeopleComCn_favicon", screen, parentTest,"People.com.cn Home page navigated successfully after switching tab",this.driver,testCaseName,"Yes");
			Sleep(2000);
			//TestCase#5-Verifying Finance related news page
			SikuliUtil.verifyObjectAndClickOn("Finance", screen, parentTest,"People.com.cn Finance tab clicked",driver,testCaseName,"No");
			Sleep(9000);
			ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs3.get(1));
            Sleep(2000);
            ReportGenerator.verifyNavigation(this.driver, "财经--人民网", parentTest,testCaseName,"No");
            SikuliUtil.verifyObjectAndHighlight("PeopleComCn_favicon", screen, parentTest,"People.com.cn favicon verification",this.driver,testCaseName,"No");
            Sleep(2000);
            SikuliUtil.verifyObjectAndHighlight("FinanceLogo", screen, parentTest,"People.com.cn Finance page loaded successfully",this.driver,testCaseName,"Yes");
            screen.wheel(1, 40);			
			Sleep(6000);
			
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs3.get(0));
			Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver, "人民网", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"People.com.cn Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("PeopleComCn_favicon", screen, parentTest,"People.com.cn Home page navigated successfully after switching tab",this.driver,testCaseName,"Yes");
			Sleep(2000);
			

			
			//TestCase#6-Verifying People.com.cn English Version page			
			Sleep(5000);
			SikuliUtil.verifyObjectAndClickOn("English", screen, parentTest, "People.com.cn English link clicked", driver, testCaseName, "No");
			
			Sleep(8000);
			ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs4.get(1));
            Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver, "English--People's Daily Online", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("PeopleComCn_favicon", screen, parentTest,"PeopleComCn Favicon Highlighted",this.driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("EnglishLogo", screen, parentTest,"People.com.cn English version page loaded successfully",driver,testCaseName,"Yes");
			Sleep(3000);
			driver.switchTo().window(tabs4.get(0));
			Sleep(2000);
			driver.close();
			driver.switchTo().window(tabs4.get(1));
			Sleep(2000);
			//TestCase#7-Trending news page
			SikuliUtil.clickBelow("EnglishLogo", screen, parentTest, "Clicking on trending news", driver, testCaseName, "No", 180);
			Sleep(8000);
			ArrayList<String> tabs5 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs5.get(1));
            Sleep(4000);
			
			ReportGenerator.verifyNavigation(this.driver, "People's Daily Online", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("PeopleComCn_favicon", screen, parentTest,"PeopleComCn Favicon Highlighted",this.driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("EnglishLogo", screen, parentTest,"PeopleComCn Trending news page loaded",this.driver,testCaseName,"Yes");
			Sleep(2000);
			screen.wheel(1,40);			
			Sleep(6000);	
			
			
			//TestCase#8-Right Click Reload English news page
			 driver.switchTo().window(tabs5.get(0));
			 Sleep(2000);
			pattern1=new org.sikuli.script.Pattern(patternpath("/EnglishLogo.PNG"));
            reg=screen.exists(pattern1);
			reg.highlight(2);
			Sleep(2000);
			r=reg.left(150);
			Sleep(3000);
			r.rightClick();
			Sleep(3000);
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
			
			Sleep(7000);
			
			ReportGenerator.verifyNavigation(this.driver, "English--People's Daily Online", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("EnglishLogo", screen, parentTest,"Right Click and reloading page validated",driver,testCaseName,"Yes");
			
			Sleep(2000);
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The PeopleComCn TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The PeopleComCn TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}