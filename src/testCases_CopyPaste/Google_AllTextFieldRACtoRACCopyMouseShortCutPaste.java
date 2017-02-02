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


public class Google_AllTextFieldRACtoRACCopyMouseShortCutPaste extends testCases.Base {
	
	
	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing All Text Field from RAC to RAC Copy Paste for Google using Mouse shortCut");
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
			System.out.println(System.getProperty("user.dir"));
			
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

			//Copy text from searchbox
			
				
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);
					
					Sleep(15000);
					
					SikuliUtil.mouseRightClick("SelectedTextInSearchbox", screen);		
					
					Sleep(3000);
					
					//Copy option selection
					SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
					SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
					SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					
					
					Sleep(3000);
			
				
				//Pasting the text in Yandex.ru
				
				siteURL="https://www.yandex.ru";
				driver.navigate().to(baseurl+siteURL);
				Sleep(6000);
				
				SikuliUtil.verifyObjectAndHighlight("Yandex_searchbox", screen, parentTest, "highlight yandex searchbox", driver, testCaseName, "No");
				SikuliUtil.mouseRightClick("Yandex_searchbox", screen);		
				
				Sleep(3000);
				
				//Copy option selection
				SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
				SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
			
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				
				SikuliUtil.verifyObjectAndHighlight("yandex_favicon", screen, parentTest,"Verify navigation to Yandex", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("TextInSearchbox", screen, parentTest, "Text get pasted in searchbox", driver, testCaseName, "Yes");
				 
			
			Sleep(4000);
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "Testing All Text Field from RAC to RAC Copy Paste for Google using Mouse shortcut testcase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
				
		}catch(Exception e){
			
			//In case of failure, mention the same in logs and Report
			Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "Testing All Text Field from RAC to RAC Copy Paste for Google using Mouse shortcut testcase Failed,Please see logs and error screenshots", this.driver);
		}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
				
			}
		
		}
			
			
}

	

