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

public class Indeed extends Base{
	
	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Indeed");
	private String testCaseName=getClass().getName().substring(10); 
	
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
		
		siteURL="https://www.indeed.com/";
		driver.navigate().to(baseurl+siteURL);
		}
	

		@Test	
		public void executeScript() throws IOException {
			
			// To assign author to report
			ReportGenerator.assignAuthor(this.parentTest,"Mogli");
			
			// Driver instantiate, Spikes login and folder path setup for current script
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Indeed";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//Home page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "Job Search", parentTest,testCaseName, "Yes");
				
				//Favicon verification - Favicon is not getting displayed. http://jira.spikes.prod:8080/browse/RC-141
				//SikuliUtil.verifyObjectAndHighlight("Pinterest_favicon", screen, parentTest,"Verify Pinterest favicon",this.driver,testCaseName,"Yes");
				
				//If connected from India appliance 
					if(SikuliUtil.isPresent(screen, "IndeedUSLink")){
            		
					SikuliUtil.verifyObjectAndClickOn("IndeedUSLink", screen, parentTest,"Click Indeed US link", this.driver, testCaseName, "No") ;
					}		
						
				
				//indeed Logo verification
				SikuliUtil.verifyObjectAndHighlight("IndeedLogo", screen, parentTest, "Indeed logo verification", this.driver, testCaseName, "Yes");
				
				//Click Find Jobs
				SikuliUtil.verifyObjectAndClickOn("IndeedFindJobs", screen, parentTest, "Click Find Jobs", this.driver, testCaseName, "No");
				
				//What click and entry
				SikuliUtil.verifyObjectAndType("IndeedWhatSkill", screen, parentTest, "Enter automation tester", this.driver, testCaseName, "No", "Automation tester");
				
				//Where Click
				SikuliUtil.verifyObjectAndClickOn("IndeedWhereSkill", screen, parentTest, "Click where", this.driver, testCaseName, "No");
				Sleep(3000);
				
				//Clear text
				if(flag==1){
					
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_A);			
					}
					else{
						SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);				
					}
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_DELETE);
				Sleep(2000);
				
				//Where entry
				SikuliUtil.typeScreen(screen, "San Ramon,CA"+Key.ENTER);
				Sleep(3000);
				
				//Home page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "Automation Tester Jobs", parentTest,testCaseName, "Yes");
								
				//Select Job Type as Full time
				SikuliUtil.verifyObjectAndClickOn("FindJobJobType", screen, parentTest, "Click Full Time", this.driver, testCaseName, "No");
				Sleep(2000);
				
				//Job Type filter validation
				SikuliUtil.verifyObjectAndHighlight("JobTypeFilterValidation", screen, parentTest, "Job type filter as Full Time validation", this.driver, testCaseName, "Yes");
				
				//Click Find resumes	
				SikuliUtil.verifyObjectAndClickOn("FindResumes", screen, parentTest, "Click Find Resume link", this.driver, testCaseName, "No");
				Sleep(3000);
				
				//Find Resumes page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "Indeed Resume Search", parentTest,testCaseName, "Yes");
				
				//What click and entry
				SikuliUtil.verifyObjectAndType("IndeedWhatSkill", screen, parentTest, "Enter automation tester", this.driver, testCaseName, "No", "Automation tester");
				
				//Where Click
				SikuliUtil.verifyObjectAndClickOn("IndeedWhereSkill", screen, parentTest, "Click where", this.driver, testCaseName, "No");
				Sleep(3000);
				
				//Clear text
				if(flag==1){
					
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_A);			
					}
					else{
						SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);				
					}
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_DELETE);
				Sleep(2000);
				
				//Where entry
				SikuliUtil.typeScreen(screen, "San Ramon,CA"+Key.ENTER);
				Sleep(3000);
				
				//Resume search verification
				SikuliUtil.verifyObjectAndHighlight("ResumeSearchVerification", screen, parentTest, "Automation Tester- San Ramon resume search verification", this.driver, testCaseName, "Yes");
				
				//Employer Link Click
				SikuliUtil.verifyObjectAndClickOn("LinkEmployers", screen, parentTest, "Click Employers", this.driver, testCaseName, "No");
				
				//Employer page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "Post a Job", parentTest,testCaseName, "Yes");
				
				
				//Final Site Run status
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Indeed TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
				
						
				}catch(Exception e){
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Indeed TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
		}
}



