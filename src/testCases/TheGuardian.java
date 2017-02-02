package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class TheGuardian extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing TheGuardian");
			
			public void navigateToURL(WebDriver driver){
				siteURL="https://www.theguardian.com/us";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/TheGuardian";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				
				//Test Case 1 - Verify navigation to The Guardian
				ReportGenerator.verifyNavigation(this.driver, "The Guardian", parentTest,testCaseName,"Yes");
			
				
				//Test case 2 - Verify favicon of The Guardian
				SikuliUtil.verifyObjectAndHighlight("guardian_favicon", screen, parentTest, "Verify favicon of The Guardian", driver, testCaseName, "Yes");
			
				//Test case 3 - verify navigating on sports tab
				SikuliUtil.verifyObjectAndHighlight("sports_tab", screen, parentTest, "Highlight Sports tab", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("sports_tab", screen, parentTest, "verify navigating on sports tab", driver, testCaseName, "Yes");
			
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Sports news", parentTest,testCaseName,"No");
				
				//Test case 4 - verify navigating back to home page by home button
				SikuliUtil.verifyObjectAndHighlight("home_button", screen, parentTest, "Highlight Home button", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("home_button", screen, parentTest, "verify navigating back to home page by home button", driver, testCaseName, "Yes");
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "News", parentTest,testCaseName,"No");
				Sleep(4000);
				
				//Test case 5 - Verify editions are changing successfully
				SikuliUtil.verifyObjectAndClickOn("USedition_button", screen, parentTest, "verify clicking on US edition button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("international_link", screen, parentTest, "verify clicking on International link", driver, testCaseName, "No");
				Sleep(1000);
				SikuliUtil.verifyObjectAndHighlight("Internationaledition_button", screen, parentTest, "Verify edition changed to Internatioonal", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Internationaledition_button", screen, parentTest, "verify clicking on International edition button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("USedition_link", screen, parentTest, "verify clicking on US Edition link", driver, testCaseName, "No");
				Sleep(1000);
				SikuliUtil.verifyObjectAndHighlight("USedition_button", screen, parentTest, "Verify editions are changing successfully", driver, testCaseName, "Yes");
				
				//Test case 6 - verify searching India news
				SikuliUtil.verifyObjectAndClickOn("Search_button", screen, parentTest, "verify searching India news", driver, testCaseName, "No");
				Sleep(4000);
				SikuliUtil.typeScreen(screen, "India");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("india_word", screen, parentTest, "News related to India seached", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("Search_button", screen, parentTest, "verify closing search window", driver, testCaseName, "No");
				
				//Test case 7 - Verify browse all sections window opened and closed
				SikuliUtil.verifyObjectAndClickOn("guardian_menu", screen, parentTest, "Verify cliking browse all sections button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("menu_close_button", screen, parentTest, "browse all sections window opened", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("menu_close_button", screen, parentTest, "Verify closing guadian menu", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("guardian_menu", screen, parentTest, "Verify browse all sections window opened and closed successfully", driver, testCaseName, "Yes");
				Sleep(2000);
				
				//Test case 8 - Verify login
				SikuliUtil.verifyObjectAndClickOn("signIn_link", screen, parentTest, "verify clicking on sign in link", driver, testCaseName, "No");
				Sleep(1000);
				if(SikuliUtil.isPresent(screen, "email_font")){
					SikuliUtil.verifyObjectAndClickOn("email_font", screen, parentTest, "verify clicking inside email textbox", driver, testCaseName, "No");
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);
					SikuliUtil.keyPress(robot,KeyEvent.VK_BACK_SPACE);
					Sleep(2000);
					SikuliUtil.typeScreen(screen, "spikesqa@gmail.com");
					Sleep(2000);
					SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
					Sleep(1000);
					SikuliUtil.typeScreen(screen, "QAqa4321!");
					Sleep(2000);
					SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				}else{
					SikuliUtil.verifyObjectAndClickOn("email_address_link", screen, parentTest, "verify clicking inside email textbox", driver, testCaseName, "No");
					Sleep(2000);
					SikuliUtil.typeScreen(screen, "spikesqa@gmail.com");
					Sleep(2000);
					SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
					Sleep(1000);
					SikuliUtil.typeScreen(screen, "QAqa4321!");
					Sleep(2000);
					SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				}
				SikuliUtil.verifyObjectAndHighlight("guardian_favicon", screen, parentTest, "Verify favicon of TheGuardian", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("guardian_username", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				
				//test case 9 - Verify Logout
				SikuliUtil.verifyObjectAndClickOn("guardian_username", screen, parentTest, "verify clicking on username link", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("signout_link", screen, parentTest, "verify clicking on username link", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("signIn_link", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
	
					
				//test case 10 - Verify Scroll down and up on page
		
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("PageUp_button", screen, parentTest, "verify scrolling page to top", driver, testCaseName, "No");
				Sleep(3000);
				SikuliUtil.verifyObjectAndHighlight("home_button", screen, parentTest, "User scrolled down and up successfully", driver, testCaseName, "Yes");
				
				
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The TheGuardian TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The TheGuardian TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}	
