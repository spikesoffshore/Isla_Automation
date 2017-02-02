package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class PixnetTW extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing PixnetTW");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="www.pixnet.net";
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
		path=path+"/PixnetTW";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(25000);
		
		try{
			
			
			// Starting test.. 
		   Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			//TestCase#1-Verifying Navigation to home page			
			ReportGenerator.verifyNavigation(this.driver, "痞客邦 PIXNET", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 
			
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Pixnet Taiwan Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("PixnetTW_favicon", screen, parentTest,"Pixnet Taiwan favicon verification",this.driver,testCaseName,"Yes");
			//TestCase#3-Verifying Login functionality	
			screen.type("spikesqa@gmail.com");
			Sleep(2000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
			Sleep(2000);			
			screen.type("QAqa4321!"+Key.ENTER);
						
			Sleep(10000);
			SikuliUtil.verifyObjectAndHighlight("PixnetTW_favicon", screen, parentTest,"Pixnet Taiwan favicon verification",this.driver,testCaseName,"No");
			
			Sleep(2000);
			
			SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"Pixnet Taiwan user logged in Functionality",driver,testCaseName,"Yes");
			Sleep(2000);
			
			//TestCase#4-Verifying Search Functionality
			
			SikuliUtil.verifyObjectAndClickOn("Search", screen, parentTest,"Pixnet Taiwan search textbox clicked",driver,testCaseName,"No");
			Sleep(5000);
			screen.paste("周渝民");
			Sleep(2000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(8000);
			ReportGenerator.verifyNavigation(this.driver, "搜尋結果", parentTest,testCaseName,"No");
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("PixnetTW_favicon", screen, parentTest,"Searching functionality for Pixnet Taiwan Sucessfully",driver,testCaseName,"Yes");
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Pixnet Taiwan Home Logo verified",driver,testCaseName,"No");
			Sleep(3000);
			
			
			screen.wheel(1, 40);			
			Sleep(4000);
			

			//TestCase#5-Verifying Alt+Left Key press functionality
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
						
			Sleep(6000);
			ReportGenerator.verifyNavigation(this.driver, "痞客邦 PIXNET", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("PixnetTW_favicon", screen, parentTest,"Pixnet Taiwan Home page redirection after Alt+Left keys",this.driver,testCaseName,"Yes");
			
			//TestCase#6-Verifying Pixnet 3C page			
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("3CTab", screen, parentTest, "Pixnet Taiwan SubMenu 3C link clicked", driver, testCaseName, "No");
			
			Sleep(6000);
			
			ReportGenerator.verifyNavigation(this.driver, "痞客邦3C", parentTest,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("PixnetTW_favicon", screen, parentTest,"PixnetTW 3C page loaded successfully",this.driver,testCaseName,"Yes");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"Pixnet 3C page logged in user hovered",driver,testCaseName,"No");
			Sleep(3000);
			
			screen.wheel(1,40);			
			Sleep(6000);	
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_HOME);
			Sleep(4000);
			
			//TestCase#7-Verifying Right Click and Back Functionality
			pattern1=new org.sikuli.script.Pattern(patternpath("/SpikesLoggedIn.PNG"));
			reg=screen.exists(pattern1);
			Sleep(2000);
			r=reg.left(150);
			Sleep(3000);
			r.rightClick();
			Sleep(3000);
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
			
			Sleep(7000);
			SikuliUtil.verifyObjectAndHighlight("HomeLogo", screen, parentTest,"Pixnet Taiwan Home Logo verified",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("PixnetTW_favicon", screen, parentTest,"Right Click and going back to previos page functionality validated ",this.driver,testCaseName,"Yes");
			
			
			//TestCase#8-Verifying Signout Functionality	
			
			SikuliUtil.verifyObjectAndClickOn("SpikesLoggedIn", screen, parentTest, "Users Profile Icon clicked Functionality", driver, testCaseName, "No");
			Sleep(4000);
			SikuliUtil.verifyObjectAndClickOn("SignOut", screen, parentTest, "Signout Link Clicked", driver, testCaseName, "No");
			Sleep(8000);
			SikuliUtil.verifyObjectAndHighlight("SignIn", screen, parentTest,"User logout functionality verified",driver,testCaseName,"Yes");
			Sleep(2000);
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The PixnetTW TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The PixnetTW TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}