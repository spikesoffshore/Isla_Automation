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

public class Yandex extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Yandex");
			
			public void navigateToURL(WebDriver driver){
				siteURL="https://www.yandex.ru";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Yandex";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
				
				//Test Case 1 - Verify navigating to Yandex
				
				SikuliUtil.verifyObjectAndHighlight("yandex_MainPageTab", screen, parentTest,"Verify navigation to Yandex", driver, testCaseName, "Yes");
		
				//Test case 2 - Verify Yandex favicon
	
				SikuliUtil.verifyObjectAndHighlight("yandex_favicon", screen, parentTest,"Verify Yandex favicon", driver, testCaseName, "Yes");
			
				
				//Test case 3 - Verify navigating news tab
				SikuliUtil.verifyObjectAndClickOn("news_tab", screen, parentTest, "Verify navigating News tab", driver, testCaseName, "Yes");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("News_word", screen, parentTest,"News tab navigated", driver, testCaseName, "No");
				
				//Test case 4 - Verify navigating back to home page
				SikuliUtil.verifyObjectAndClickOn("back_button", screen, parentTest, "Verify navigating back to home page", driver, testCaseName, "Yes");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("yandex_MainPageTab", screen, parentTest,"Verify yandex main page Tab", driver, testCaseName, "No");
			
				
			
				//Test case 5  - Verify searching India
				
				Sleep(2000);
				screen.paste("Индия");
				Sleep(2000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(5000);
				
				SikuliUtil.verifyObjectAndHighlight("India_word", screen, parentTest,"Verify India get searched", driver, testCaseName, "Yes");

				//Test case 6 - Verify results displayed are of Page 1
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("SelectedPage1_button", screen, parentTest,"Verify results displayed are of Page 1", driver, testCaseName, "Yes");
				
				//Test case 7 - Verify navigating to results of Page 2
				SikuliUtil.verifyObjectAndClickOn("Page2_button", screen, parentTest, "Verify clicking Page 2 button", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("India_word", screen, parentTest,"Verify searched results of India", driver, testCaseName, "No");
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("SelectedPage2_button", screen, parentTest,"Verify navigating to results of Page 2", driver, testCaseName, "Yes");
				
				//Test case 8 - Verify Searching Russia
				Sleep(2000);
			
				
				SikuliUtil.verifyObjectAndClickOn("IndiaInSearchbox", screen, parentTest, "Verify clearing search text", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);
				Sleep(2000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_BACK_SPACE);
				Sleep(2000);
				screen.paste("Россия");
				Sleep(2000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				Sleep(5000);
				
				SikuliUtil.verifyObjectAndHighlight("russia_word", screen, parentTest,"Verify Russia get searched", driver, testCaseName, "Yes");
				
				
				//Test case 9 - Verify searching Russia related images
				SikuliUtil.verifyObjectAndHighlight("image_tab", screen, parentTest,"Highlight Image tab", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("image_tab", screen, parentTest, "Verify searching Russia related images", driver, testCaseName, "Yes");
				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(1));
			    Sleep(10000);
			    SikuliUtil.verifyObjectAndHighlight("russia_inSearch", screen, parentTest, "Verify russia word is in searchbox", driver, testCaseName, "No");
			    SikuliUtil.verifyObjectAndHighlight("Selected_imageTab", screen, parentTest, "Verify image tab is enabled", driver, testCaseName, "No");
				Sleep(5000);
				driver.close();
			    driver.switchTo().window(tabs2.get(0));
			    Sleep(2000);
	
			    
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Yandex TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Yandex TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
	}
}			
