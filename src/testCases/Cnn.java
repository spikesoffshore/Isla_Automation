package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Cnn extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Cnn");
			
			public void navigateToURL(WebDriver driver){
				siteURL="http://edition.cnn.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Cnn";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//Test Case 1 - Verify navigating to Cnn
				ReportGenerator.verifyNavigation(this.driver, "CNN - Breaking News", parentTest,testCaseName,"Yes");

				//Test Case 2 - Verify Cnn Favicon
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("cnn_favicon", screen, parentTest, "Verify Cnn Favicon", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndHighlight("cnn_logo", screen, parentTest, "Verify Cnn Logo", driver, testCaseName, "No");
				SikuliUtil.moveWheel(screen, 1, 20);
				Loggers.writeInfoLog("Scrolling done successfully....");
				Sleep(20000);
				
				//Test Case 3 - Verify opened Cnn edition is International
				SikuliUtil.verifyObjectAndHighlight("International_Edition", screen, parentTest, "Verify opened Cnn edition is International", driver, testCaseName, "Yes");
				
				//Test Case 4 - Verify navigating to money tab
				SikuliUtil.verifyObjectAndClickOn("Money_tab", screen, parentTest, "Verify navigating to money tab", driver, testCaseName, "No");
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "CNNMoney", parentTest,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("back_button", screen, parentTest, "Verify navigating back to Cnn main page", driver, testCaseName, "No");
			
				//Test Case 5 - Verify opening US edition Cnn
				SikuliUtil.verifyObjectAndClickOn("cnn_menu", screen, parentTest, "Verify opening Cnn menu", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Cnn_US", screen, parentTest, "Verify opening US edition Cnn", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("US_edition", screen, parentTest, "Verify International edition changed to US edtion Cnn", driver, testCaseName, "Yes");
				
				//Test Case 6 -	Verify opening Arabic edition Cnn
				
				SikuliUtil.verifyObjectAndClickOn("US_edition", screen, parentTest, "Verify clicking on US edition button", driver, testCaseName, "No");
			
				Sleep(3000);
				if(SikuliUtil.isPresent(screen, "Arabic_link")){
				SikuliUtil.verifyObjectAndClickOn("Arabic_link", screen, parentTest, "Verify opening Arabic edition Cnn", driver, testCaseName, "No");
				}
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "CNN Arabic", parentTest,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndHighlight("ArabicCnn_logo", screen, parentTest, "Verify Arabic Cnn logo", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("back_button", screen, parentTest, "Verify cicking back button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("US_edition", screen, parentTest, "Verify navigating back to US Cnn", driver, testCaseName, "No");
				
				//Test Case 7 - Verify opening Espanol edtion cnn
				SikuliUtil.verifyObjectAndClickOn("US_edition", screen, parentTest, "Verify clicking on US edition button", driver, testCaseName, "No");
				Sleep(5000);
				if(SikuliUtil.isPresent(screen, "Espanol_link")){
				SikuliUtil.verifyObjectAndClickOn("Espanol_link", screen, parentTest, "Verify clicking on Espanol link", driver, testCaseName, "No");
				}
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "CNN en Español", parentTest,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndHighlight("EspanolCnn_logo", screen, parentTest, "Verify Espanol Cnn logo", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Espanol_edition", screen, parentTest, "Verify opening Espanol edtion cnn", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("Internacional_link", screen, parentTest, "Verify clicking on Internacional link", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("International_Edition", screen, parentTest, "Verify navigating back to International Cnn", driver, testCaseName, "No");
				
				//Test Case 8 - Verify searching football news
				SikuliUtil.verifyObjectAndClickOn("Search_button", screen, parentTest, "Verify search functionality", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.typeScreen(screen, "football");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(3000);
				ReportGenerator.verifyNavigation(this.driver, "Search CNN", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("football_heading", screen, parentTest, "Verify football news searched", driver, testCaseName, "Yes");
				
				//Test Case 9 - Verify selecting another radio button
				SikuliUtil.verifyObjectAndHighlight("AllCnn_selected", screen, parentTest, "Verify All CNN radiobutton is selected", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("style_notSelected", screen, parentTest, "Verify selecting another radio button", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("style_selected", screen, parentTest, "Another radio button STYLE get selected", driver, testCaseName, "Yes");
				
				//Test Case 10 - Verify navigating to video tab
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("video_tab", screen, parentTest, "Verify navigating to video tab", driver, testCaseName, "No");
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Video News", parentTest,testCaseName,"Yes");
				
				
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Cnn TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Cnn TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
	}
}			
