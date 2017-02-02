package testCases;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class PopAds extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing PopAds");
			
			public void navigateToURL(WebDriver driver){
				siteURL="https://www.popads.net";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/PopAds";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//Test Case 1 - Verify navigation to PopAds
				ReportGenerator.verifyNavigation(this.driver, "PopAds - Home", parentTest,testCaseName,"Yes");
				

				//Test Case 2 - Verify PopAds Favicon
				SikuliUtil.verifyObjectAndHighlight("popads_favicon", screen, parentTest, "Verify PopAds Favicon", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndHighlight("popads_logo", screen, parentTest, "Verify PopAds Logo", driver, testCaseName, "No");
				
				//Testcase 3 - Verify Login
				SikuliUtil.verifyObjectAndClickOn("Username_textbox", screen, parentTest, "Verify Username textbox is editable", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.typeScreen(screen, "spikesqa");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.typeScreen(screen, "QAqa4321");
				
				Sleep(4000);
				while(SikuliUtil.isPresent(screen, "SignIn_button")){
					SikuliUtil.verifyObjectAndClickOn("SignIn_button", screen, parentTest, "Verify clicking signin button", driver, testCaseName, "No");
				}
				
				
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "PopAds - Dashboard", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Username", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				Sleep(4000);
				

				// Testcase 5 - Verify current balance of user is visible
				SikuliUtil.verifyObjectAndHighlight("Current_Balance", screen, parentTest, "Verify current balance of user is visible", driver, testCaseName, "Yes");
				
				//Testcase 4 - Verify user has referred 0 user yet
				SikuliUtil.moveWheel(screen, 1, 30);
				Loggers.writeInfoLog("Scrolling done successfully....");
				Sleep(20000);
				SikuliUtil.verifyObjectAndHighlight("Reffered_count", screen, parentTest, "Verify user has referred 0 user yet", driver, testCaseName, "Yes");
				
				
				//Testcase 5 - Verify referral link of user is present
				
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("RefferralCenter_button", screen, parentTest, "Verify clicking Referal Center button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Referral_url", screen, parentTest, "Verify referral link of user is present", driver, testCaseName, "Yes");
				
				
				
				
				//Testcase 6 - Verify adding web site

			
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("AddWebsite_tab", screen, parentTest, "Verify add websiteb tab", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("SiteName_textbox", screen, parentTest, "Verify SiteName textbox is editable", driver, testCaseName, "No");
				SikuliUtil.typeScreen(screen, "bluefrog");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.typeScreen(screen, "www.bluefrog.co.in");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.typeScreen(screen, "hi");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("DownArrow", screen, parentTest, "Verify clicking category dropdown", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Ecommerce_category", screen, parentTest, "Verify selecting Ecommerece category", driver, testCaseName, "No");
				
				SikuliUtil.moveWheel(screen, 1, 15);
				Sleep(15000);
				
				SikuliUtil.verifyObjectAndClickOn("AddWebsite_button", screen, parentTest, "Verify clicking AddWebsite_button", driver, testCaseName, "No");
				
				Sleep(30000);
				if(SikuliUtil.isPresent(screen, "Checkbox1")){
					SikuliUtil.verifyObjectAndClickOn("Checkbox1", screen, parentTest, "Verify clicking checkbox 1", driver, testCaseName, "No");
					SikuliUtil.verifyObjectAndClickOn("Checkbox2", screen, parentTest, "Verify clicking checkbox 2", driver, testCaseName, "No");
					SikuliUtil.verifyObjectAndClickOn("AddWebsite_button", screen, parentTest, "Verify clicking AddWebsite_button", driver, testCaseName, "No");
				    if(SikuliUtil.isPresent(screen, "ok_button")){
					  SikuliUtil.verifyObjectAndClickOn("ok_button", screen, parentTest, "Verify clicking ok button", driver, testCaseName, "No");
				    }
				} 
				
				SikuliUtil.verifyObjectAndClickOn("Website_tab", screen, parentTest, "Verify clicking on website tab", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("bluefrog_link", screen, parentTest, "Verify website added", driver, testCaseName, "Yes");
				
				//Testcase 7 - Verify removing web site
				SikuliUtil.verifyObjectAndClickOn("bluefrog_link", screen, parentTest, "Verify clicking on blue frog link", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Remove_button", screen, parentTest, "Verify clicking on remove button", driver, testCaseName, "No");
				 if(SikuliUtil.isPresent(screen, "ok_button")){
					  SikuliUtil.verifyObjectAndClickOn("ok_button", screen, parentTest, "Verify clicking ok button", driver, testCaseName, "No");
				    }
				 Sleep(5000);
				 SikuliUtil.verifyObjectAndHighlight("Website_removed_message", screen, parentTest, "Verify website removed", driver, testCaseName, "Yes");
			
				
				//Testcase 8 - Verify Logout
				SikuliUtil.verifyObjectAndClickOn("logout_button", screen, parentTest, "Verify clicking logout button", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("logout_link", screen, parentTest, "Verify clicking logout link", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("SignIn_button", screen, parentTest, "User logged out succesfully", driver, testCaseName, "Yes");
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The PopAds TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The PopAds TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
}}
