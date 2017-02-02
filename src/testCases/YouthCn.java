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

public class YouthCn extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing YouthCn");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="www.Youth.cn";
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
		path=path+"/YouthCn";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			
			
			// Starting test.. 
		  Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			//TestCase#1-Verifying Navigation to home page			
		  
			ReportGenerator.verifyNavigation(this.driver, "中国青年网_青年温度、青春靓度、青网态度", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Youth.cn Home Logo verified",driver,testCaseName,"No");
			Sleep(4000);
			//TestCase#3-Verify Finance related news page
			SikuliUtil.verifyObjectAndClickOn("Business", screen, parentTest,"Youth.cn Business tab clicked",driver,testCaseName,"No");
			Sleep(9000);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Sleep(2000);
            ReportGenerator.verifyNavigation(this.driver, "财经频道_中国青年网", parentTest,testCaseName,"No");
            SikuliUtil.verifyObjectAndHighlight("YouthCn_favicon", screen, parentTest,"Youth.cn favicon verification",this.driver,testCaseName,"No");
            Sleep(2000);
            SikuliUtil.verifyObjectAndHighlight("FinanceLogo", screen, parentTest,"Youth.cn Business page loaded successfully",this.driver,testCaseName,"Yes");
            screen.wheel(1, 40);			
			Sleep(4000);
			//TestCase#4-Verifying Browser Tab navigation
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs2.get(0));
			Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver, "中国青年网_青年温度、青春靓度、青网态度", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Youth.cn Home page navigated successfully after switching tab",driver,testCaseName,"Yes");
			Sleep(2000);
			//TestCase#5-Verify Finance related news page
			SikuliUtil.verifyObjectAndClickOn("Entertainment", screen, parentTest,"Youth.cn Entertainment tab clicked",driver,testCaseName,"No");
			Sleep(9000);
			ArrayList<String> tabs5 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs5.get(1));
            Sleep(2000);
            ReportGenerator.verifyNavigation(this.driver, "中国青年网-娱乐频道", parentTest,testCaseName,"No");
            SikuliUtil.verifyObjectAndHighlight("YouthCn_favicon", screen, parentTest,"Youth.cn favicon verification",this.driver,testCaseName,"No");
            Sleep(2000);
            SikuliUtil.verifyObjectAndHighlight("EntertainmentLogo", screen, parentTest,"Youth.cn Entertainment page loaded successfully",this.driver,testCaseName,"Yes");
            screen.wheel(1, 40);			
			Sleep(4000);
			
			driver.close();
			Sleep(2000);
			driver.switchTo().window(tabs5.get(0));
			Sleep(2000);
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Youth.cn Home page navigated successfully after switching tab",driver,testCaseName,"Yes");
			Sleep(2000);
			
			//TestCase#6-Verifying Youth.cn English Version page			
			Sleep(5000); 
			SikuliUtil.verifyObjectAndClickOn("English", screen, parentTest, "Youth.cn English link clicked", driver, testCaseName, "No");
			
			Sleep(8000);
			ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs4.get(1));
            Sleep(2000);
			ReportGenerator.verifyNavigation(this.driver, "英文频道-中国青年网", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("EnglishLogo", screen, parentTest,"Youth.cn English version page loaded successfully",driver,testCaseName,"Yes");
			Sleep(3000);
			driver.switchTo().window(tabs4.get(0));
			Sleep(2000);
			driver.close();
			driver.switchTo().window(tabs4.get(1));
			Sleep(2000);
			
			
			//TestCase#7-Trending news page
			SikuliUtil.clickBelow("EnglishLogo", screen, parentTest, "Clicking on trending news", driver, testCaseName, "No", 400);
			Sleep(8000);
			ArrayList<String> tabs6 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs6.get(1));
            Sleep(2000);
			
			
			SikuliUtil.verifyObjectAndHighlight("EnglishNewsLogo", screen, parentTest,"YouthCn Trending news page loaded",this.driver,testCaseName,"Yes");
			Sleep(2000);
			screen.wheel(1,40);			
			Sleep(6000);	
			driver.close();
			driver.switchTo().window(tabs6.get(0));
            Sleep(4000);
            
          //TestCase#8-Right Click Reload English news page
            
            pattern1=new org.sikuli.script.Pattern(patternpath("/EnglishLogo.PNG"));
            reg=screen.exists(pattern1);
			reg.highlight(2);
			Sleep(2000);
			r=reg.right(150);
			Sleep(3000);
			r.rightClick();
			Sleep(3000);
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
			
			Sleep(7000);
			
			ReportGenerator.verifyNavigation(this.driver, "英文频道-中国青年网", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("EnglishLogo", screen, parentTest,"Right Click and reloading page validated",driver,testCaseName,"Yes");
			
			Sleep(2000);
			
			
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The YouthCn TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The YouthCn TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}