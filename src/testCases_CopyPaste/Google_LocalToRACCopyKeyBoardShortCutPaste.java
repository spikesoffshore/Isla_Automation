package testCases_CopyPaste;

import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.CopyPasteFunctions;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Google_LocalToRACCopyKeyBoardShortCutPaste extends testCases.Base {
	
	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Local to RAC Copy Paste for Google using KeyBoard ShortCut");
	private String testCaseName=getClass().getName().substring(10); 
		
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
			
		siteURL="https://www.google.com/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
		}
	
	@Test
	public void executeScript(){
		
		ReportGenerator.assignAuthor(this.parentTest,"Don");
		
		//Driver instantiate, Spikes login and folder path setup for current script
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Google";
		Sleep(5000);
		navigateToURL(this.driver);
		
		Sleep(8000);
		
		try{
			// Starting test.. 
			Loggers.startCurrentTestCaseExecution(this.driver);
				
			//Home page verification based on the title
			ReportGenerator.verifyNavigation(this.driver, "Google", parentTest,testCaseName, "Yes");
						
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("Google_Favicon", screen, parentTest,"Verify Google favicon",this.driver,testCaseName,"Yes");
			
			//CopyPasteFunctions.getTextInClipboard("TestData");
			CopyPasteFunctions.getTextInClipboardFromExcel(System.getProperty("user.dir")+"/CopyPasteTestData/TestData.xlsx", "CopyFromExcelPasteInGoogleAndVi", 1, 0);
			//Ctrl+V
			if(flag==1){
				
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_V);			
				}
				else{
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_V);				
				}
			
			SikuliUtil.verifyObjectAndClickOn("GoogleSearch_Btn", screen, parentTest, "Click Google Search button", driver, testCaseName, "No");
			
			
			Sleep(3000);

			//SikuliUtil.typeScreen(screen, Key.ENTER);
			
				Sleep(5000);
		//Navigation and Favicon verification
			
			SikuliUtil.verifyObjectAndHighlight("Google_Favicon", screen, parentTest,"Verify Google favicon",this.driver,testCaseName,"No");
			
			//Verify Google options
			/*	SikuliUtil.verifyObjectAndHighlight("GoogleOptions", screen, parentTest, "Google options", this.driver, testCaseName, "Yes");
	
			//Get text from Google options pattern
			//String copiedFromTextBox= SikuliUtil.getRegionText(screen, "GoogleOptions");
		
			//Function to write pattern text in text file
			//writeToFileFromTextbox(path+"/Paste.txt",copiedFromTextBox);
			Sleep(2000);
			 */
			
		//Final Site Run status
		ReportGenerator.logStatusPass(parentTest, testCaseName, "The Local to RAC Copy-Paste for Google(using mouse right click option) TestCase is working as expected");
		Loggers.stopCurrentTestCaseExecution(testCaseName);
			
	}catch(Exception e){
		
		//In case of failure, mention the same in logs and Report
		Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
		System.out.println(e);
		ReportGenerator.logStatusFail(parentTest,testCaseName, "The Local to RAC Copy-Paste for Google(using mouse right click) option TestCase Failed,Please see logs and error screenshots", this.driver);
	}
		finally{
			//quitDriver(this.driver);
			path=currentSitePath;
			ReportGenerator.flushReportToDisk(parentTest);
			
		}
	
	}
		
		
	}



