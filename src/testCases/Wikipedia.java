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

public class Wikipedia extends Base {

private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Wikipedia");

//Function to navigate to Site url Specific to site ; will be written in every test class
	public void navigateToURL(WebDriver driver){
		
		siteURL="https://www.wikipedia.org";
		
		driver.navigate().to(baseurl+siteURL);
				}
		
		@Test	
		public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Doraemon");
		
		//Driver instantiate, Spikes login and folder path setup to Wikipedia
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Wikipedia";
		navigateToURL(this.driver);
		
		Sleep(15000);
								
		try{
			// Starting test.. 
			Loggers.startCurrentTestCaseExecution(this.driver);

			//TestCase#1
			ReportGenerator.verifyNavigation(this.driver, "Wikipedia", parentTest,testCaseName,"Yes");
			
			//TestCase#2 
			SikuliUtil.verifyObjectAndHighlight("Wiki_favicon", screen, parentTest,"Verify Wikipedia favicon",this.driver,testCaseName,"Yes");
			
			//TestCase#3
			SikuliUtil.verifyObjectAndHighlight("Wikipedia_Logo", screen, parentTest,"Verify Wikipedia home page landing",this.driver,testCaseName,"Yes");
			
			//TestStep 4.A
			SikuliUtil.verifyObjectAndHighlight("Lang_select", screen, parentTest,"Wikipedia Language Selection found successfully",this.driver,testCaseName,"No");
			
			//TestCase 4.B
			SikuliUtil.verifyTooltip("Polski_MouseHover", screen, parentTest, "Verify tooltip appearance", this.driver, testCaseName, "Yes");
	
			//TestCase 4.C			
			SikuliUtil.verifyObjectAndClickOn("Lang_select", screen, parentTest, "Polski language selected", this.driver, testCaseName, "Yes");
						
			Sleep(6000);
			
			//TestStep 5.A
			SikuliUtil.verifyObjectAndHighlight("Wiki_favicon", screen, parentTest,"Verify Wikipedia favicon",this.driver,testCaseName,"No");
			
			//Test Case 5.B
			ReportGenerator.verifyNavigation(this.driver, "wolna", parentTest,testCaseName,"Yes");
			
			//TestStep 6.A
			SikuliUtil.moveWheel(screen, 1, 20);
			
			Sleep(4000);
			
			//TestStep 6.B
			driver.navigate().back();
				
			Sleep(8000);
			//ReportGenerator.logStatusPass(parentTest, "Mouse and keyboard movement", "Mouse and keyboard movement working as expected");
			
			Sleep(5000);
			//Teststep 7.A
			SikuliUtil.verifyObjectAndHighlight("Wiki_favicon", screen, parentTest,"Verify Wikipedia favicon",this.driver,testCaseName,"No");
			
			//TestCase 7.B
			SikuliUtil.verifyObjectAndType("SearchBox", screen, parentTest, "Text typed", this.driver, testCaseName, "Yes", "Shah Rukh Khan"+Key.ENTER);
						
			Sleep(8000);
			
			//TestCase 8
			SikuliUtil.verifyObjectAndHighlight("Wiki_favicon", screen, parentTest,"Verify Wikipedia favicon",this.driver,testCaseName,"Yes");
			
			
			//Testcase 9
			if(flag==1){
			SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_A);							
					}
					else{	
						
						SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);
						
					}
					Sleep(4000);
			//TestCase 10			
			SikuliUtil.verifyObjectAndHighlight("SelectedText", screen, parentTest, "Select all", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The Wikipedia TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
				
		}catch(Exception e){
			
			//In case of failure, mention the same in logs and Report
			Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The Instagram TestCase Failed,Please see logs and error screenshots", this.driver);
		}finally{
			
			//Finals steps that need to be taken care 
			quitDriver(this.driver);
			path=currentSitePath;
			//Report flush
			ReportGenerator.flushReportToDisk(parentTest);
		}

}
}
