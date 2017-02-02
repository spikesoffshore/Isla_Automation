package testCases_CopyPaste;

import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.CopyPasteFunctions;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Ynet_RACtoLocalCopyMouseShortCutPaste extends testCases.Base {
	
	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing RAC to Local Copy Paste for Ynet using Mouse ShortCut");
	private String testCaseName=getClass().getName().substring(10); 
		
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
			
		siteURL="www.ynet.co.il/";
		Sleep(15000);
		driver.navigate().to(baseurl+siteURL);
		}
	
	@Test
	public void executeScript(){
		
		ReportGenerator.assignAuthor(this.parentTest,"Pandeyji");
		
		//Driver instantiate, Spikes login and folder path setup for current script
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Ynet";
		Sleep(5000);
		navigateToURL(this.driver);
		
		Sleep(15000);
		
		try{
			// Starting test.. 
			Loggers.startCurrentTestCaseExecution(this.driver);
				
			//Home page verification based on the title
			ReportGenerator.verifyNavigation(this.driver, "ynet - חדשות, כלכלה, ספורט, בריאות", parentTest,testCaseName, "Yes");
						
			//Favicon verification
		//	SikuliUtil.verifyObjectAndHighlight("YnetCoIlHB_favicon", screen, parentTest,"Verify Ynet favicon",this.driver,testCaseName,"Yes");
			
			//Clicking the start of select region
			SikuliUtil.clickLeft("RACTOLocal_Text", screen, parentTest, "CLicking on left to the Search Result", driver, testCaseName, "No", 8);
			Sleep(5000);
			//To select text			
			SikuliUtil.selectTextFromRAC(screen,800,8);
			
			Sleep(5000);
			
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
			CopyPasteFunctions.pasteClipboardTextandVerify(System.getProperty("user.dir")+"/CopyPasteTestData/TestData.xlsx", "CopyFromExcelPasteInYnetAndVi", 1, 1, parentTest, "Write in Excel", testCaseName, this.driver);
			
			
			//CopyPasteFunctions.pasteClipboardText(System.getProperty("user.dir")+"/CopyPasteTestData/TestData.xlsx", "CopyFromExcelPasteInYnetAndVi", 1, 1);
			
			//Get text from Ynet options pattern
			//String copiedFromTextBox= SikuliUtil.getRegionText(screen, "YnetOptions");
		
			//Function to write pattern text in text file
			//writeToFileFromTextbox(path+"/Paste.txt",copiedFromTextBox);
			Sleep(2000);
			 
			
			
		//Final Site Run status
		ReportGenerator.logStatusPass(parentTest, testCaseName, "RAC to Local Copy Paste for Ynet using Mouse Right Click testcase is working as expected");
		Loggers.stopCurrentTestCaseExecution(testCaseName);
			
	}catch(Exception e){
		
		//In case of failure, mention the same in logs and Report
		Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
		System.out.println(e);
		ReportGenerator.logStatusFail(parentTest,testCaseName, "RAC to Local Copy Paste for Ynet using Mouse Right Click testcase Failed,Please see logs and error screenshots", this.driver);
	}
		finally{
			//quitDriver(this.driver);
			path=currentSitePath;
			ReportGenerator.flushReportToDisk(parentTest);
			
		}
	
	}
		
		
	}




