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

public class Gmail_Txt_RACtoLocalCopyMouseRightClickPaste extends testCases.Base {
	
	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing RAC to Local Copy Paste for Gmail using KeyBoard shortCut");
	private String testCaseName=getClass().getName().substring(10); 
		
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
			
		siteURL="www.gmail.com";
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
		path=path+"/Gmail";
		Sleep(5000);
		navigateToURL(this.driver);
		
		Sleep(12000);
		
		try{
			// Starting test.. 
			Loggers.startCurrentTestCaseExecution(this.driver);
				
			//Home page verification based on the title
			ReportGenerator.verifyNavigation(this.driver, "Gmail", parentTest,testCaseName, "Yes");
						
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("Gmail_Favicon", screen, parentTest,"Verify Gmail favicon",this.driver,testCaseName,"Yes");
			
			//Sign in to Gmail account
			SikuliUtil.verifyObjectAndClickOn("SignIn", screen, parentTest, "SignIn link clicked", driver, testCaseName, "No");
			Sleep(8000);
			
			screen.type("spikesqa");
			Sleep(3000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);	
			Sleep(3000);
			screen.type("QAqa4321!");
			Sleep(3000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(8000);
			
			ReportGenerator.verifyNavigation(this.driver, "spikesqa", parentTest,testCaseName,"No");
			Sleep(3000);
			SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest,"Sign in functionality validation done",this.driver,testCaseName,"Yes");
			
		
			
			//To write in Gmail search box
			SikuliUtil.verifyObjectAndType("SearchBox", screen, parentTest, "Gmail search box", this.driver, testCaseName, "Yes", "testing.txt"+Key.ENTER);
				
			Sleep(5000);
			
			//Open the Text attachment from a Inbox mail
			SikuliUtil.verifyObjectAndClickOn("InboxMail", screen, parentTest, "Inbox mail with Txt file attachment clicked", driver, testCaseName, "No");
			Sleep(6000);
			SikuliUtil.clickLeft("EmailTextAttachment", screen, parentTest, "Attached Txt file searched successfully", driver, testCaseName, "Yes", 20);
			Sleep(8000);
	
			//Navigation verification
			
			SikuliUtil.clickLeft("RACTOLocal_Text", screen, parentTest, "Clicking on left to the Search Result", driver, testCaseName, "No", 2);
			
			//To select text			
			SikuliUtil.selectTextFromRAC(screen,600,2);
			
			Sleep(14000);
			
			//Mouse Right Click paste option
			SikuliUtil.mouseRightClick("RACTOLocal_TextHighlighted", screen);
			Sleep(3000);
			
			//Copy option selection
			SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
			SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
			SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
			SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
			Sleep(3000);
			
			//Pasting the text in Excel
			CopyPasteFunctions.pasteClipboardTextandVerify(System.getProperty("user.dir")+"/CopyPasteTestData/TestData.xlsx", "CopyfromGmailTxt", 1, 1, parentTest, "Write in Excel", testCaseName, this.driver);
			
			
			//CopyPasteFunctions.pasteClipboardText(System.getProperty("user.dir")+"/CopyPasteTestData/TestData.xlsx", "CopyFromExcelPasteInGoogleAndVi", 1, 1);
			
			//Get text from Google options pattern
			//String copiedFromTextBox= SikuliUtil.getRegionText(screen, "GoogleOptions");
		
			//Function to write pattern text in text file
			//writeToFileFromTextbox(path+"/Paste.txt",copiedFromTextBox);
			Sleep(2000);
			 
			
			
		//Final Site Run status
		ReportGenerator.logStatusPass(parentTest, testCaseName, "RAC to Local Copy Paste for Gmail Txt attachment using Mouse Right Click testcase is working as expected");
		Loggers.stopCurrentTestCaseExecution(testCaseName);
	}catch(Exception e){
		
		//In case of failure, mention the same in logs and Report
		Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
		System.out.println(e);
		ReportGenerator.logStatusFail(parentTest,testCaseName, "RAC to Local Copy Paste for Gmail using keyboard shortcut testcase Failed,Please see logs and error screenshots", this.driver);
	}
		finally{
			//quitDriver(this.driver);
			path=currentSitePath;
			ReportGenerator.flushReportToDisk(parentTest);
			
		}
	
	}
		
		
	}



