package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailedResponse;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.CommonUtil;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Slack extends Base{
	
	private static final Exception InterruptedException = null;
	private WebDriver driver;
	private String messageToBeSend;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Slack");
	private String testCaseName=getClass().getName().substring(10); 
	
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
		
		siteURL="https://slack.com/";
		driver.navigate().to(baseurl+siteURL);
		}
	

		@Test	
		public void executeScript() throws IOException {
			
			// To assign author to report
			ReportGenerator.assignAuthor(this.parentTest,"Bagira");
			
			// Driver instantiate, Spikes login and folder path setup for current script
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Slack";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//Home page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "Slack", parentTest,testCaseName, "Yes");
				
				//Favicon verification
				SikuliUtil.verifyObjectAndHighlight("Slack_favicon", screen, parentTest,"Verify Slack favicon",this.driver,testCaseName,"Yes");
				
				//Slack logo	
				SikuliUtil.verifyObjectAndHighlight("SlackLogo", screen, parentTest, "Slack logo on home page verification", this.driver, testCaseName, "No");
				
				//Slack Signin
				SikuliUtil.verifyObjectAndClickOn("SignIn", screen, parentTest, "Click Sign In link", this.driver, testCaseName, "No");
				Sleep(3000);
				
				//enter slackdomain
				SikuliUtil.typeScreen(screen, "spikestalk"+Key.ENTER);
				Sleep(2000);
				
				//Sign in spikes
				SikuliUtil.verifyObjectAndType("SlackUserName", screen, parentTest, "Enter Username", this.driver, testCaseName, "No", "spikesqa@gmail.com"+Key.TAB);
				Sleep(200);
				
				//Enter password	
				SikuliUtil.typeScreen(screen, "QAqa4321!");
				
				//Uncheck keep me signed in checkbox
				SikuliUtil.verifyObjectAndClickOn("AlwaysSignedInCheckBox", screen, parentTest, "Unckeck keep me signed in", this.driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("SignInButton", screen, parentTest, "Click Sign in button", this.driver, testCaseName, "No");
				Sleep(4000);
				
				//Home page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "Spikes Slack", parentTest,testCaseName, "Yes");
				
				//Click Direct messages link
				SikuliUtil.verifyObjectAndClickOn("SlackDirectMessages", screen, parentTest, "Click Direct messages", driver, testCaseName, "No");
				
				//Select user 
				SikuliUtil.verifyObjectAndClickOn("spikesQAUserName", screen, parentTest, "Select spikesQA", this.driver, testCaseName, "No");
				
				Sleep(2000);
				
				//SpikesQA message popup
				ReportGenerator.verifyNavigation(this.driver, "spikesqa", parentTest,testCaseName, "No");
				
				//SpikesQA window verification
				SikuliUtil.verifyObjectAndHighlight("spikesQAverification", screen, parentTest, "spikesQA message window verification" , this.driver, testCaseName, "Yes");
				
				//type Message yourself
				messageToBeSend="Automation Testing "+CommonUtil.getCurrentTimeTillMinute().toString();
				SikuliUtil.typeScreen(screen, messageToBeSend+Key.ENTER);
				Sleep(2000);
				
				if(screen.findText("Automation") != null)
				{
					ReportGenerator.logStatusPass(parentTest, testCaseName, "Message entered successfully");
				}
				else{
					ReportGenerator.logStatusFail(parentTest, testCaseName, "Message not entered successfully" , this.driver);
					throw InterruptedException;
				}
				
				//Message Delete
				SikuliUtil.verifyObjectAndHighlight("spikesQAForMessageDeletion", screen, parentTest, "Mouse hover spikesQA", this.driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndClickOn("DeleteMessageOptionMenu", screen, parentTest, "Options menu click", this.driver, testCaseName, "No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("DeleteMessage", screen, parentTest, "Delete message click", this.driver, testCaseName, "No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("DeleteMessageConfirmation", screen, parentTest, "Delete confirmation popup", this.driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("DeleteConfirmationButton", screen, parentTest, "Delete message confirmation button click", this.driver, testCaseName, "No");
				
				//Delete verification
				//FindFailedResponse val = screen.getFindFailedResponse();
				
				/* Sikuli catch :)  
				 * If deletion is successful, when Sikuli will try to find text Automation it will throw FindFail exception. 
				 * So first we mentioned FindFailedResponse as Skip(means skip error and continue with script)
				 * and after if Abort( means if FindFail then stop the script)
				*/
				screen.setFindFailedResponse(FindFailedResponse.SKIP);
				if(screen.findText("Automation") == null)
				{
					ReportGenerator.logStatusPass(parentTest, testCaseName, "Message deleted successfully");
									
				}
				else{
					ReportGenerator.logStatusFail(parentTest, testCaseName, "There is some issue while message deletion" , this.driver);
					throw InterruptedException;	
				}
				screen.setFindFailedResponse(FindFailedResponse.ABORT);
				
				//LogOut
				SikuliUtil.verifyObjectAndClickOn("SpikesMenu", screen, parentTest, "Click Spikes Menu", this.driver, testCaseName, "No");
				Sleep(1000);
				SikuliUtil.verifyObjectAndClickOn("SignOut", screen, parentTest, "Click Sign Out option", this.driver, testCaseName, "No");
				
				//SignOut page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "Signed Out", parentTest,testCaseName, "Yes");
				
				//SignOut confirmation
				SikuliUtil.verifyObjectAndHighlight("SignedOutConfirmation", screen, parentTest, "Signed Out Slack confirmation", this.driver, testCaseName, "Yes");
				
				//Final Site Run status
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Slack TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Slack TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
		}
}
