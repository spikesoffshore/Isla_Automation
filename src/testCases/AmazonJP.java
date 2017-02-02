package testCases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class AmazonJP extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Amazon-Japan");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="https://www.amazon.co.jp";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}
	
public void Site_Signout(){
	pattern=new org.sikuli.script.Pattern(patternpath("/Your_Acc.PNG"));
	//ReportGenerator.verifyPatternandLog(screen, pattern, "Your Account Menu",testCaseName);
	r=screen.exists(pattern);
	r.hover();
	Sleep(5000);
					
	pattern1=new org.sikuli.script.Pattern(patternpath("/Sign_Out.PNG"));
	r=screen.exists(pattern1);
	r.highlight(2);
	r.click();
	Sleep(8000);

}

//Main test method to test the WebSite
@Test	
public void executeScript() throws IOException {
	
	// To assign author to report
	ReportGenerator.assignAuthor(parentTest,"Doraemon");
	
	//Driver instantiate, Spikes login and folder path setup to Amazon
	this.driver=driverIns();
	spikeLogin();
	currentSitePath=path;
	path=path+"/AmazonJP";
	Sleep(5000);
	
	//navigating to the site URL
	navigateToURL(this.driver);
	
	Sleep(15000);
	
	try{
		
		// Starting test.. 
		Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
		
		//Home page verification based on the title
		ReportGenerator.verifyNavigation(this.driver, "Amazon", parentTest,testCaseName,"Yes");
		
		//Favicon verification
		SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Amazon favicon verification",this.driver,testCaseName,"Yes");
		
		//Amazon logo verification
		SikuliUtil.verifyObjectAndHighlight("Amazon_logo", screen, parentTest,"Amazon logo verification", driver, testCaseName, "Yes");
		
		//Amazon language select-option mouse hover
		SikuliUtil.verifyObjectAndHighlight("Amazon_langSelect", screen, parentTest, "Mouse hover language select option", this.driver, testCaseName, "No");
		Sleep(300);
		
		//Amazon language select-options verification
		SikuliUtil.verifyObjectAndHighlight("Amazon_langSelect_Options", screen, parentTest, "Mouse hover language select options verification", this.driver, testCaseName, "Yes");
		
		//Amazon category selection click
		SikuliUtil.verifyObjectAndClickOn("Amazon_Category_Selection", screen, parentTest, "Click select category", this.driver, testCaseName, "No");
		Sleep(4000);
		
		//Amazon select Beauty category
		SikuliUtil.verifyObjectAndClickOn("Amazon_Category_Beauty", screen, parentTest, "Beauty category selection", this.driver, testCaseName, "No");
		Sleep(300);
		
		//Amazon Beauty category verification
		SikuliUtil.verifyObjectAndHighlight("Amazon_Category_Beauty_Verification", screen, parentTest, "Beauty category verification", this.driver, testCaseName, "Yes");
		
		//Item search
		SikuliUtil.verifyObjectAndType("SearchBar", screen, parentTest, "Enter the desired item- Face cream", this.driver, testCaseName, "No", "Face Cream"+Key.ENTER);
		Sleep(4000);
		
		//Search product verification
		SikuliUtil.verifyObjectAndHighlight("SearchResultVerification", screen, parentTest, "Searched product- Face cream results verification", this.driver, testCaseName, "Yes");
		
		//
		
		//Final Site Run status
		ReportGenerator.logStatusPass(parentTest, testCaseName, "The Amazon TestCase is working as expected");
		Loggers.stopCurrentTestCaseExecution(testCaseName);
				
		}catch(Exception e){
			
			//In case of failure, mention the same in logs and Report
			Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The Amazon TestCase Failed,Please see logs and error screenshots", this.driver);
		}
			finally{
			//	quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}
}

}
