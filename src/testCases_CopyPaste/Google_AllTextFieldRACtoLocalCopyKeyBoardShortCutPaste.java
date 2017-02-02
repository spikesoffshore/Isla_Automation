package testCases_CopyPaste;

import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.CopyPasteFunctions;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;


public class Google_AllTextFieldRACtoLocalCopyKeyBoardShortCutPaste extends testCases.Base {
	
	
	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing All Text Field from RAC to Local Copy Paste for Google using KeyBoard shortCut");
	private String testCaseName=getClass().getName().substring(10); 
		
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
			
		siteURL="https://www.google.com/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
		}
	
	@Test
	public void executeScript(){
		
		ReportGenerator.assignAuthor(this.parentTest,"Pandeyji");
		
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
			
			//To write in Google search box
			SikuliUtil.verifyObjectAndClickOn("SearchBox", screen, parentTest, "Type in searchbox", driver, testCaseName, "No");

			Sleep(4000);
			SikuliUtil.typeScreen(screen, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce consectetur ipsum ac ex fringilla commodo.");
			
			Sleep(15000);
			
			//Verify text get typed in searchbox
			SikuliUtil.verifyObjectAndClickOn("TextInSearchbox", screen, parentTest, "Text get typed in searchbox", driver, testCaseName, "Yes");
		
				
			Sleep(2000);
			
			//Ctrl+C
			if(flag==1){
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_A);
				
				Sleep(5000);
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_C);			
				}
				else{
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);
					
					Sleep(5000);
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_C);				
				}
			
				Sleep(2000);
			//Pasting the text in Excel
				CopyPasteFunctions.pasteClipboardTextandVerify(System.getProperty("user.dir")+"/CopyPasteTestData/TestData.xlsx", "AllTextFieldFromRACtoLocal", 1, 0, parentTest, "Write in Excel", testCaseName, this.driver);
				 
			
			Sleep(4000);
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "Testing All Text Field from RAC to Local Copy Paste for Google using Keyboard shortcut testcase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
				
		}catch(Exception e){
			
			//In case of failure, mention the same in logs and Report
			Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "Testing All Text Field from RAC to Local Copy Paste for Google using keyboard shortcut testcase Failed,Please see logs and error screenshots", this.driver);
		}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
				
			}
		
		}
			
			
}

	

