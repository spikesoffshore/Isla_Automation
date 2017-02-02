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

	public class UOL extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing UOL");
				
				public void navigateToURL(WebDriver driver){
					siteURL="https://www.uol.com.br";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/UOL";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					
					//Test case 1 - verify navigation to UOL
					ReportGenerator.verifyNavigation(driver, "UOL", parentTest, testCaseName, "Yes");
					
					
					
					//Test case 2 - Verify scrolling on Page
					SikuliUtil.verifyObjectAndClickOn("minimized_orangeButton", screen, parentTest, "Click on minimized orange button", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("maximized_redButton", screen, parentTest, "Verify scrolling on Page", driver, testCaseName, "Yes");
					
					//Test case 3 - Verify navigating to Product tab
					SikuliUtil.verifyObjectAndClickOn("Product_tab", screen, parentTest,"Click on Product tab", driver, testCaseName, "No");
					Sleep(5000);
					ReportGenerator.verifyNavigation(driver, "Produtos", parentTest, testCaseName, "Yes");
					SikuliUtil.verifyObjectAndClickOn("back_button", screen, parentTest,"Verify clicking back button", driver, testCaseName, "No");
					Sleep(5000);
					
					//Test case 4 - Verify navigating to International sub tab
					SikuliUtil.verifyObjectAndHighlight("News_tab", screen, parentTest,"Hover on News tab", driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.verifyObjectAndClickOn("International_subtab", screen, parentTest,"Click on International sub tab", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("Internaional_word", screen, parentTest,"Verify navigating to International sub tab", driver, testCaseName, "Yes");
					
					//Test case 5 - Verify navigating to home page clicking logo
					SikuliUtil.verifyObjectAndClickOn("uol_logo", screen, parentTest,"Verify navigating to home page clicking logo", driver, testCaseName, "Yes");
					Sleep(5000);
					ReportGenerator.verifyNavigation(driver, "UOL", parentTest, testCaseName, "NO");
					
					//Test case 6 - Verify login
					
					SikuliUtil.verifyObjectAndClickOn("Guest_ProfileButton", screen, parentTest, "click login link", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndClickOn("email_textbox", screen, parentTest, "click inside email textbox", driver, testCaseName, "No");
					Sleep(4000);
					SikuliUtil.typeScreen(screen, "spikesqa@gmail.com");
					Sleep(4000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_TAB);
					Sleep(4000);
					SikuliUtil.typeScreen(screen, "QAqa4321!");
					Sleep(4000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					Sleep(10000);
					SikuliUtil.verifyObjectAndHighlight("Username_button", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
					
					//Test case 7 -  Verify logout
					SikuliUtil.verifyObjectAndClickOn("Username_button", screen, parentTest, "Hover User profile", driver, testCaseName, "No");
					SikuliUtil.verifyObjectAndClickOn("logout_link", screen, parentTest, "click on logout button", driver, testCaseName, "No");
					Sleep(20000);
					SikuliUtil.verifyObjectAndHighlight("Guest_ProfileButton", screen, parentTest, "User logged out successfully", driver, testCaseName, "No");
					
					//Test case 8 - Verify searching Brasil info
					SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Click inside searchbox", driver, testCaseName, "No");
					Sleep(4000);
					screen.paste("Brasil");
					Sleep(4000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("Brasil_word", screen, parentTest, "Verify searching Brasil info", driver, testCaseName, "Yes");
					
					//Test case 9 - Verify UOL favicon
					
					SikuliUtil.verifyObjectAndHighlight("uol_favicon", screen, parentTest,"Verify UOL favicon", driver, testCaseName, "Yes");
					
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The UOL TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
							
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The UOL TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}

}			
