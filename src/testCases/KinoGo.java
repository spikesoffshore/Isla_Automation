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

	public class KinoGo extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing KinoGo");
				
				public void navigateToURL(WebDriver driver){
					siteURL="http://kinogo.club";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/KinoGo";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					
					//Test case 1 - verify navigation to KinoGo
					ReportGenerator.verifyNavigation(driver, "KinoGo", parentTest, testCaseName, "Yes");
					
					//Test case 2 - Verify navigating to Order Table tab
					 SikuliUtil.verifyObjectAndClickOn("OrderTable_tab", screen, parentTest, "click on order table tab", driver, testCaseName, "No");
					 Sleep(5000);
					 SikuliUtil.moveWheel(screen, 1, 20);
					 Sleep(15000);
					  SikuliUtil.verifyObjectAndHighlight("Enabled_OrderDate", screen, parentTest, "Verify navigating to Order Table tab", driver, testCaseName, "Yes");
					
					 //Test case 3 - Verify browsing movies by Comedy category
					  SikuliUtil.verifyObjectAndClickOn("comedy_link", screen, parentTest, "click on comedy link", driver, testCaseName, "No");
						 Sleep(5000);
						 SikuliUtil.verifyObjectAndClickOn("comedy_word", screen, parentTest, "VVerify browsing movies by Comedy category", driver, testCaseName, "Yes");
						 SikuliUtil.moveWheel(screen, 1, 50);
						 Sleep(15000);
						 SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
						 Sleep(5000);
					
					 //Test case 4 - Verify browsing movies by 2017
						 SikuliUtil.verifyObjectAndClickOn("2017_link", screen, parentTest, "Verify browsing movies by 2017", driver, testCaseName, "Yes");
						 Sleep(5000);
						 ReportGenerator.verifyNavigation(driver, "2017", parentTest, testCaseName, "No");
						 SikuliUtil.moveWheel(screen, 1, 50);
						 Sleep(15000);
						 SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
						 Sleep(5000);
						 
						//Test case 5 - Verify searching Iron Man movie
				
						 SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Verify searching china news", driver, testCaseName, "No");
							Sleep(3000);
							screen.paste("Железный человек");
							Sleep(3000);
							SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
							Sleep(5000);
							 SikuliUtil.moveWheel(screen, 1, 20);
							 Sleep(15000);
							 SikuliUtil.verifyObjectAndClickOn("ironMan_link", screen, parentTest, "Verify searching Iron Man movie", driver, testCaseName, "Yes"); 
							 Sleep(5000);
							
						//Test case 6 - Verify navigating to Iron Man detail page	 
							 SikuliUtil.moveWheel(screen, 1, 20);
							 Sleep(15000);
							 SikuliUtil.verifyObjectAndHighlight("ironMan_heading", screen, parentTest, "Verify navigating to Iron Man detail page", driver, testCaseName, "Yes");  
							 
							 
							//Test case 7 - Verify viewing rating of movie 
							 SikuliUtil.verifyObjectAndHighlight("filled_star", screen, parentTest, "Verify viewing rating of movie ", driver, testCaseName, "Yes");  
							 
							 //Test case 8 - Verify scrolling on page
							 SikuliUtil.moveWheel(screen, 1, 100);
							 Sleep(25000);
							 SikuliUtil.verifyObjectAndHighlight("comment_word", screen, parentTest, "Verify scrolling on page", driver, testCaseName, "Yes");  
							 
							 //Test case 9 - Verify comments on movie
							 SikuliUtil.verifyObjectAndHighlight("comment_word", screen, parentTest, "Verify viewing comments on movie", driver, testCaseName, "Yes");  
							 
							 
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The KinoGo TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
							
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The KinoGo TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}

}			
