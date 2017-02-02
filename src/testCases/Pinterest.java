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

public class Pinterest extends Base{
	
	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Pinterest");
	private String testCaseName=getClass().getName().substring(10); 
	
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
		
		siteURL="https://www.pinterest.com";
		driver.navigate().to(baseurl+siteURL);
		}
	

		@Test	
		public void executeScript() throws IOException {
			
			// To assign author to report
			ReportGenerator.assignAuthor(this.parentTest,"Minnie");
			
			// Driver instantiate, Spikes login and folder path setup for current script
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Pinterest";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//Home page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "Pinterest", parentTest,testCaseName, "Yes");
				
				//Favicon verification
				SikuliUtil.verifyObjectAndHighlight("Pinterest_favicon", screen, parentTest,"Verify Pinterest favicon",this.driver,testCaseName,"Yes");
				
				//Pinterest page load
				SikuliUtil.verifyObjectAndHighlight("Login_Page", screen, parentTest, "Pinterest initial page load", this.driver, testCaseName, "Yes");
				
				//Login- Step1 - Username entry
				SikuliUtil.verifyObjectAndType("Login_Email", screen, parentTest, "Enter Username", this.driver, testCaseName, "No", "spikesqa@gmail.com");
				
				//Login- Step2 - password entry
				SikuliUtil.verifyObjectAndType("Login_Password", screen, parentTest, "Enter Password", this.driver, testCaseName, "No", "QAqa4321!");
				
				//Login- Final step - Click Continue entry
				SikuliUtil.verifyObjectAndClickOn("Login_Continue", screen, parentTest, "Click Continue", this.driver, testCaseName, "No");
				Sleep(5000);
				//Home page verification
				ReportGenerator.verifyNavigation(this.driver, "Pinterest", parentTest,testCaseName, "Yes");
				SikuliUtil.verifyObjectAndHighlight("Pinterest_favicon", screen, parentTest,"Verify Pinterest favicon",this.driver,testCaseName,"No");
				SikuliUtil.verifyObjectAndClickOn("Home_Search", screen, parentTest, "Login Pinterest", this.driver, testCaseName, "Yes");
				
				// Search Doraemon
				SikuliUtil.typeScreen(screen, "Doraemon");
				SikuliUtil.typeScreen(screen, Key.ENTER);
				Sleep(5000);
				//Select option Wallpapers
				SikuliUtil.verifyObjectAndHighlight("Options_Wallpaper", screen, parentTest, "Doraemon search", this.driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("Options_Wallpaper", screen, parentTest, "Click Wallpapers", this.driver, testCaseName, "No");
				Sleep(2000);
				
				//Search check
				SikuliUtil.verifyObjectAndHighlight("Search_check", screen, parentTest, "Verify Doraemon wallpapers search", this.driver, testCaseName, "Yes");
				
				// Navigate to hard coded URL
				String navigatedUrl=baseurl+"https://www.pinterest.com/pin/540220917778749610/";
				driver.navigate().to(navigatedUrl);
				Sleep(6000);
				
				//Verify navigated URL
				SikuliUtil.verifyObjectAndHighlight("Pinterest_favicon", screen, parentTest,"Verify Pinterest favicon",this.driver,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Image_Doraemon", screen, parentTest, "Verify navigated URL image", this.driver, testCaseName, "Yes");
				
				//Zoom Image
				SikuliUtil.verifyObjectAndClickOn("Image_Zoom", screen, parentTest, "Click Zoom", this.driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("Image_Zoom_page", screen, parentTest, "Verify Doraemon zoomed image", this.driver, testCaseName, "Yes");
				
				//Escape zoomed image page
				SikuliUtil.keyPress(robot, KeyEvent.VK_ESCAPE);
				Sleep(2000);
				
				//back to hardcoded url page
				SikuliUtil.verifyObjectAndHighlight("Pin_Logo", screen, parentTest, "Verify zoom in", this.driver, testCaseName, "Yes");
				
				//Save the image
				SikuliUtil.verifyObjectAndClickOn("Image_Save", screen, parentTest, "Click Save button to pin the image", this.driver, testCaseName, "No");
				
				//Click Choose/Create Board
				SikuliUtil.verifyObjectAndHighlight("Image_Choose_Board", screen, parentTest, "Image Save/pin click", this.driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("Image_Create_Board", screen, parentTest, "Create a board", this.driver, testCaseName, "No");
				
				//Create Board - Verify and create
				SikuliUtil.verifyObjectAndHighlight("Board_Create_Header", screen, parentTest, "Verify create board popup", this.driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndType("Board_Create_Title", screen, parentTest, "Enter Board title", this.driver, testCaseName, "No", "Automation"+Key.ENTER);
				Sleep(5000);
				
				//Back to Doaemon page and Click User Icon
				SikuliUtil.verifyObjectAndHighlight("Pin_Logo", screen, parentTest, "Verify Doraemon page", this.driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("User_Icon", screen, parentTest, "Click User profile icon", this.driver, testCaseName, "No");
				Sleep(3000);
				
				//Verify User profile page
				ReportGenerator.verifyNavigation(this.driver, "Pinterest", parentTest,testCaseName, "Yes");
				SikuliUtil.verifyObjectAndHighlight("User_Profile_Name", screen, parentTest, "Verify user profile", this.driver, testCaseName, "Yes");
				Sleep(3000);
				SikuliUtil.moveWheel(screen, 1, 5);
				Sleep(3000);
				//Verify created Automation Board	
				SikuliUtil.verifyObjectAndHighlight("Board_Automation", screen, parentTest, "Verify mover hover on Automation Board", this.driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Board_Edit", screen, parentTest, "Verify hover and Click Edit", this.driver, testCaseName, "Yes" );
				Sleep(2000);
				
				//Board details and delete
				SikuliUtil.verifyObjectAndHighlight("Board_details", screen, parentTest, "Verify Automation board details", this.driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("Board_Delete", screen, parentTest, "Click Delete", this.driver, testCaseName,"No");
				Sleep(2000);
				
				//Delete Board-Confirmation
				SikuliUtil.verifyObjectAndHighlight("Delete_Confirmation", screen, parentTest, "Verify Delete click", this.driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("Delete_Final", screen, parentTest, "Click Delete Board", this.driver, testCaseName, "No");
				Sleep(2000);
				//Verify Successful delete
				SikuliUtil.verifyObjectAndHighlight("Pin_Logo", screen, parentTest, "Verify successful board deletion", this.driver, testCaseName, "Yes");
				
				//User Logout
				SikuliUtil.verifyObjectAndClickOn("User_Options", screen, parentTest, "Click User options", this.driver, testCaseName, "No");
				Sleep(200);
				SikuliUtil.verifyObjectAndClickOn("User_LogOut", screen, parentTest, "User options - LogOut click", this.driver, testCaseName, "Yes");
				Sleep(3000);
				
				//LogOut successful verification
				SikuliUtil.verifyObjectAndHighlight("Pinterest_favicon", screen, parentTest,"Verify Pinterest favicon",this.driver,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndHighlight("Login_Page", screen, parentTest, "Pinterest initial page load", this.driver, testCaseName, "Yes");
			
				//Final Site Run status
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Pinterest TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
				
						
				}catch(Exception e){
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Pinterest TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
		}
}
