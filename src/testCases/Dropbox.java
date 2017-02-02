package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Dropbox extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Dropbox");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="https://www.dropbox.com/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Jasmine");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Dropbox";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(8000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecution(this.driver);
			
			//Home page verification based on the title
			ReportGenerator.verifyNavigation(this.driver, "Dropbox", parentTest,testCaseName,"Yes");
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("Dropbox_favicon", screen, parentTest,"Verify DropBox favicon",this.driver,testCaseName,"Yes");
			
			//DropBox initial page verification
			SikuliUtil.verifyObjectAndHighlight("DropBox_Logo", screen, parentTest, "Verify Dropbox initial page load", this.driver, testCaseName, "Yes");
			
			//Login
			SikuliUtil.verifyObjectAndClickOn("Dropbox_SignIn", screen, parentTest, "Click Signin", this.driver, testCaseName, "No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("Dropbox_SignIn_RememberMe", screen, parentTest, "Uncheck Remember Me", this.driver, testCaseName, "No");
			Sleep(200);
			SikuliUtil.verifyObjectAndType("Dropbox_SignIn_Email", screen, parentTest, "Enter Username", this.driver, testCaseName, "No", "spikesqa@gmail.com"+Key.TAB);
			SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
			Sleep(5000);
			
			//Successful login verification
			ReportGenerator.verifyNavigation(this.driver, "Home", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("User_name", screen, parentTest, "Verify username after login", this.driver, testCaseName, "Yes");
			
			//Upload functionality
			SikuliUtil.verifyObjectAndClickOn("Upload_Icon", screen, parentTest,"Click Upload icon",this.driver, testCaseName, "No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("Upload_Dialogbox", screen, parentTest, "Upload dialog box", this.driver, testCaseName, "No");
			SikuliUtil.verifyObjectAndClickOn("Upload_ChooseFile", screen, parentTest, "Upload button click done. Now, Click choose file", this.driver, testCaseName, "Yes");
			Sleep(100);
			//Isla ribbon message
			SikuliUtil.verifyObjectAndClickOn("Isla_Upload", screen, parentTest, "Click Isla upload", this.driver, testCaseName, "No");
			Sleep(200);
			//File Selection
			SikuliUtil.typeScreen(screen,path+"\\Image_Doraemon.PNG"+Key.ENTER);
			Sleep(3000);
			
			//File upload successful verification
			SikuliUtil.verifyObjectAndHighlight("Upload_Successful", screen, parentTest, "Verify File Upload Status",this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("Upload_Done", screen, parentTest, "Click Done", this.driver, testCaseName, "No");
			Sleep(2000);
			//File Download
			ReportGenerator.verifyNavigation(this.driver, "Home", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("FileList", screen, parentTest, "Click file Image_Doraemon.PNG", this.driver, testCaseName, "No");
			Sleep(1000);
			SikuliUtil.verifyObjectAndClickOn("DownLoad", screen, parentTest, "Download Image_Doraemon.PNG", this.driver, testCaseName, "No");
			Sleep(1000);
			SikuliUtil.verifyObjectAndHighlight("Isla_Download_Ribbon", screen, parentTest, "Isla download ribbon", this.driver, testCaseName, "Yes");
						
			//Uploaded file deletion
			Sleep(500);
			SikuliUtil.verifyObjectAndClickOn("Delete", screen, parentTest, "Delete selected file" , this.driver, testCaseName, "No");
			Sleep(3000);
			
			//Delete popup and file verification
			SikuliUtil.verifyObjectAndHighlight("Delete_PopUP", screen, parentTest, "Delete confirmation PopUp", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Delete_FileNameCheck", screen, parentTest, "File to be deleted", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("Delete_Delete", screen, parentTest, "Click Delete", this.driver, testCaseName, "No");
			Sleep(2000);
			
			//Delete successful validation
			SikuliUtil.verifyObjectAndHighlight("Delete_Successful", screen, parentTest, "Deletion of file", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("DeletedFile", screen, parentTest, "Click Recycle bin", this.driver, testCaseName, "No");
			
			//Recycle bin page load and deleted file verification
			ReportGenerator.verifyNavigation(this.driver, "Deleted Files", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("DeletedFile_PageLoad", screen, parentTest, "Deleted File page load",this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("DeletedFileNameCheck", screen, parentTest, "Deleted file name check in recycle bin", this.driver, testCaseName, "Yes");
			
			//SignOut
			SikuliUtil.verifyObjectAndClickOn("User_name", screen, parentTest, "Click User", this.driver, testCaseName, "No");
			Sleep(1000);
			SikuliUtil.verifyObjectAndHighlight("User_id", screen, parentTest, "User click", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("User_SignOut", screen, parentTest, "Click User Signout", this.driver, testCaseName, "No");
			
			//Signout verification
			ReportGenerator.verifyNavigation(this.driver, "Login", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("DropBox_Logo", screen, parentTest, "Logout is done", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The DropBox TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
			
			}catch(Exception e){
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Dropbox TestCase Failed,Please see logs and error screenshots", this.driver);
	}
		finally{
			quitDriver(this.driver);
			path=currentSitePath;
			ReportGenerator.flushReportToDisk(parentTest);
		}
}

}



