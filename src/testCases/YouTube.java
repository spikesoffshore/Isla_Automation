package testCases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class YouTube extends Base{

	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Youtube");
	private String testCaseName=getClass().getName().substring(10); 
	
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
			
		siteURL="https://www.youtube.com/";
		Sleep(9000);
		driver.navigate().to(baseurl+siteURL);
		}
	
		@Test	
		public void executeScript() throws IOException {
			// To assign author to report
			ReportGenerator.assignAuthor(this.parentTest,"Doraemon");
			
			//Driver instantiate, Spikes login and folder path setup for current script
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/YouTube";
			navigateToURL(this.driver);
		
		Sleep(15000);			
					
			try{				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
					
				//Home page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "YouTube", parentTest,testCaseName, "Yes");
							
				//Favicon verification
				SikuliUtil.verifyObjectAndHighlight("YouTube_Favicon", screen, parentTest,"Verify Google favicon",this.driver,testCaseName,"Yes");
				
				driver.navigate().to(baseurl+"https://www.youtube.com/watch?v=AEIVhBS6baE");
				Sleep(6000);		
						
				//Navigation and Favicon verification
				ReportGenerator.verifyNavigation(this.driver, "Gerua", parentTest,testCaseName, "Yes");
				SikuliUtil.verifyObjectAndHighlight("YouTube_Favicon", screen, parentTest,"Verify YouTube favicon",this.driver,testCaseName,"No");
				
				//Ad display check 
				pattern=new org.sikuli.script.Pattern(patternpath("/SongDuration.PNG"));
				if(screen.exists(pattern) != null){
						ReportGenerator.logStatusInfo(parentTest, testCaseName, "No ad is playing");
					}
				else{
						ReportGenerator.logStatusInfo(parentTest, testCaseName, "Some ad is getting played");
					}
				
				//Song Title check
				SikuliUtil.verifyObjectAndHighlight("SongTitle", screen, parentTest, "Verify Gerua song title", this.driver, testCaseName, "Yes");

				//Final Site Run status
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The YouTube TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
				
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The YouTube TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
			
			
		}
}
