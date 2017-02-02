package testCases;


	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;

	import org.openqa.selenium.WebDriver;
	import org.sikuli.script.Screen;
	import org.testng.annotations.Test;

	import com.relevantcodes.extentreports.ExtentTest;

	import utils.Loggers;
	import utils.ReportGenerator;
	import utils.SikuliUtil;

	public class Globo extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Globo");
				
				public void navigateToURL(WebDriver driver){
					siteURL="http://www.globo.com";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Globo";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					
					//Test case 1 - verify navigation to Globo
					ReportGenerator.verifyNavigation(driver, "globo", parentTest, testCaseName, "Yes");
					
					//Test case 2 - Verify Globo favicon
					
					SikuliUtil.verifyObjectAndHighlight("globo_favicon", screen, parentTest,"Verify Globo favicon", driver, testCaseName, "Yes");
					
					//Test case 3 - Verify top pages under g1 tab
					SikuliUtil.verifyObjectAndHighlight("g1_tab", screen, parentTest,"Hover on G1 tab", driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.verifyObjectAndHighlight("topPages_word", screen, parentTest,"Verify top pages under G1 tab", driver, testCaseName, "Yes");
					
					//Test case 4 - Verify navigating to g1 tab
					SikuliUtil.verifyObjectAndClickOn("g1_tab", screen, parentTest,"Click on G1 tab", driver, testCaseName, "No");
					Sleep(5000);
					ReportGenerator.verifyNavigation(driver, "G1", parentTest, testCaseName, "Yes");
					
					//Test case 5 - Verify back to Globo using back button
					SikuliUtil.verifyObjectAndClickOn("back_button", screen, parentTest,"Verify back to Globo using back button", driver, testCaseName, "Yes");
					Sleep(5000);
					ReportGenerator.verifyNavigation(driver, "globo", parentTest, testCaseName, "No");
					
					//Test case 6 - Verify login
					
					SikuliUtil.verifyObjectAndClickOn("Guest_ProfileButton", screen, parentTest, "click login link", driver, testCaseName, "No");
					Sleep(10000);
					SikuliUtil.verifyObjectAndClickOn("email_textbox", screen, parentTest, "click inside email textbox", driver, testCaseName, "No");
					Sleep(4000);
					SikuliUtil.typeScreen(screen, "spikesqa@gmail.com");
					Sleep(4000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_TAB);
					Sleep(4000);
					SikuliUtil.typeScreen(screen, "QAqa4321!");
					Sleep(4000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("User_Profile", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
					
					//Test case 7 -  Verify logout
					SikuliUtil.verifyObjectAndHighlight("User_Profile", screen, parentTest, "Hover User profile", driver, testCaseName, "No");
					SikuliUtil.verifyObjectAndClickOn("logout_button", screen, parentTest, "click on logout button", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("Guest_ProfileButton", screen, parentTest, "User logged out successfully", driver, testCaseName, "No");
					
					//Test case 8 - Verify searching Brasil info
					SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Click inside searchbox", driver, testCaseName, "No");
					Sleep(4000);
					screen.paste("Brasil");
					Sleep(4000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("Brasil_word", screen, parentTest, "Verify searching Brasil info", driver, testCaseName, "Yes");
					
					//Test case 9 - Verify searching Brasil info in Photos
					SikuliUtil.verifyObjectAndClickOn("photos_tab", screen, parentTest, "Click on Photos tab", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("Brasil_word", screen, parentTest, "Verify searching Brasil info in Photos", driver, testCaseName, "Yes");
					
					//Test case 10 - Verify scrolling on Page
					SikuliUtil.moveWheel(screen, 1, 30);
					Sleep(15000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("globo_logo", screen, parentTest, "Verify scrolling on page", driver, testCaseName, "Yes");
					
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The Globo TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
							
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The Globo TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}

}			
