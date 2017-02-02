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

public class Craigslist extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Craigslist");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="https://sfbay.craigslist.org/";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Alladin");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Craigslist";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(8000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecution(this.driver);
			
			//Home page verification based on the title
			ReportGenerator.verifyNavigation(this.driver, "craigslist", parentTest,testCaseName,"Yes");
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("craigslist_favicon", screen, parentTest,"Verify craigslist favicon",this.driver,testCaseName,"Yes");
			
			//home page verification
			SikuliUtil.verifyObjectAndHighlight("craigslist_home_logo", screen, parentTest, "Home page load verification", this.driver, testCaseName, "Yes");
			
			//sign in
			SikuliUtil.verifyObjectAndClickOn("Home_myaccount", screen, parentTest, "Click my account", this.driver, testCaseName, "No");
			Sleep(200);
			SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
			Sleep(200);
			SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
			Sleep(3000);
			
			//sign in verification
			ReportGenerator.verifyNavigation(this.driver, "craigslist account", parentTest,testCaseName,"Yes");
			SikuliUtil.verifyObjectAndHighlight("Login_Verification", screen, parentTest, "Verify login", this.driver, testCaseName, "Yes");
			
			//User current post verification
			SikuliUtil.verifyObjectAndHighlight("User_SelfPost", screen, parentTest,"Verify number of posts done by user", this.driver, testCaseName, "Yes");
			
			//New post
			SikuliUtil.verifyObjectAndClickOn("User_newPost", screen, parentTest, "Click Go for new post", this.driver, testCaseName, "No");
			Sleep(2000);
			
			//New post- page 1
			ReportGenerator.verifyNavigation(this.driver, "choose type", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("NewPost_landing", screen, parentTest, "New post- Select type of post", this.driver, testCaseName, "No");
			SikuliUtil.verifyObjectAndClickOn("New_Post_Type", screen, parentTest, "Click post type- for sale by owner", this.driver, testCaseName, "No");
			 Sleep(200);
			 
			 //New post - page 2
			 ReportGenerator.verifyNavigation(this.driver, "choose category", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("NewPost_categoryPostVerification", screen, parentTest, "Verify category page", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("Category_antiques", screen, parentTest, "Click antiques", this.driver, testCaseName, "No");
			Sleep(300);
			
			//New post - page 3
			ReportGenerator.verifyNavigation(this.driver, "choose nearest area", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("NearestArea_optionSelect", screen, parentTest, "Select nearest area", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("NearestArea_option", screen, parentTest, "Select nearest area- city of san francisco", this.driver, testCaseName, "No");
			
			//New post- page 4 - neighborhood
			ReportGenerator.verifyNavigation(this.driver, "choose neighborhood", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Page4_landing", screen, parentTest, "Verify neighborhood page", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("Neighborhood_selection", screen, parentTest, "Select neighborhood", this.driver, testCaseName, "No");
			
			//New post- page 5- Create post 
			ReportGenerator.verifyNavigation(this.driver, "create posting", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Post_Contact details", screen, parentTest, "Create post page verification", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("Navigation_Home", screen, parentTest, "Click logo to navigate to Home page", this.driver, testCaseName, "No");
			Sleep(3000);
			
			//home page verification
			ReportGenerator.verifyNavigation(this.driver, "craigslist: SF bay area", parentTest, testCaseName, "Yes");
			
			SikuliUtil.verifyObjectAndHighlight("craigslist_favicon", screen, parentTest,"Verify craigslist favicon",this.driver,testCaseName,"No");
			SikuliUtil.verifyObjectAndHighlight("craigslist_home_logo", screen, parentTest, "Home page load verification", this.driver, testCaseName, "Yes");
			
			//Post view
			SikuliUtil.verifyObjectAndHighlight("ViewPost_Type", screen, parentTest, "View posts for Sale", this.driver, testCaseName, "No");
			SikuliUtil.verifyObjectAndClickOn("ViewPost_Category", screen, parentTest, "Click farm+garden category", this.driver, testCaseName, "No");
			
			//View post - page verification
			ReportGenerator.verifyNavigation(this.driver, "SF bay area farm & garden - craigslist", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("ViewPost_PageTitle", screen, parentTest, "Verify Farm + Garden page header" , this.driver, testCaseName, "Yes");
			
			//End key navigation
			SikuliUtil.keyPress(robot, KeyEvent.VK_END);
			Sleep(2000);
			
			//Page end navigation check and back to top navigation
			SikuliUtil.verifyObjectAndHighlight("craigslist_footer", screen, parentTest, "Verify craigslist footer", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("BacktoTop", screen, parentTest, "Go back to page top", this.driver, testCaseName, "No");
			Sleep(2000);
			
			//Back to top page verification
			SikuliUtil.verifyObjectAndHighlight("ViewPost_PageTitle", screen, parentTest, "Verify Farm + Garden page header" , this.driver, testCaseName, "Yes");
			
			//Logout
			SikuliUtil.verifyObjectAndClickOn("Link_account", screen, parentTest, "Click account", driver, testCaseName, "No");
			Sleep(1000);
			SikuliUtil.verifyObjectAndHighlight("Login_Verification", screen, parentTest, "Verify user home page", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("User_logout", screen, parentTest, "Click logout", this.driver, testCaseName, "No");
			Sleep(1000);
			
			//Successful logout verification
			ReportGenerator.verifyNavigation(this.driver, "account log in", parentTest,testCaseName,"No");
			SikuliUtil.verifyObjectAndHighlight("craigslist_favicon", screen, parentTest,"Verify craigslist favicon",this.driver,testCaseName,"Yes");
			SikuliUtil.verifyObjectAndHighlight("Account_Log_In", screen, parentTest, "verify logout", this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The craigslist TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The craigslist TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}



}

