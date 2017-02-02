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

	public class Babytree extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Babytree");
				
				public void navigateToURL(WebDriver driver){
					siteURL="http://www.babytree.com";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
					
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Babytree";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					//Test Case 1 - Verify navigating to Babytree
					
					SikuliUtil.verifyObjectAndHighlight("babytree_title", screen, parentTest,"Verify navigation to Babytree", driver, testCaseName, "Yes");
					
					//Test case 2 - Verify scrolling on Page
					SikuliUtil.clickRight("searchbox", screen, parentTest, "Click right of the element", driver, testCaseName, "No", 5);
					SikuliUtil.moveWheel(screen, 1, 25);
					Sleep(15000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("babytree_logo", screen, parentTest,"Verify scrolling on Page", driver, testCaseName, "Yes");
					
					//Test case 3 - Verify navigating to 0-1 year Tab
					SikuliUtil.verifyObjectAndClickOn("0-1_Year_Tab", screen, parentTest,"Click on 0-1 year Tab", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("selected_0-1Year", screen, parentTest,"Verify navigating to 0-1 year Tab", driver, testCaseName, "Yes");
					
					//Test case 4 -  Verify navigating to Home page by clicking logo
					SikuliUtil.verifyObjectAndClickOn("babytree_logo", screen, parentTest, "Click on logo", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("babytree_title", screen, parentTest, "Verify navigating to Home page by clicking logo", driver, testCaseName, "Yes");
					
					//Test case 5 -  Verify navigating to Question & Answer tab
					SikuliUtil.verifyObjectAndClickOn("Q&A_Tab", screen, parentTest, "Click on Question&Answer Tab", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("question_button", screen, parentTest, "Verify navigating to Question & Answer tab", driver, testCaseName, "Yes");
					
					//Test case 6 -  Verify selecting category of question
					SikuliUtil.verifyObjectAndClickOn("category_dropdown", screen, parentTest, "Click on category dropdown", driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.verifyObjectAndClickOn("Pregnancy_option", screen, parentTest, "Click on pregnancy option", driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.verifyObjectAndHighlight("Selected_pragnancy", screen, parentTest, "Verify selecting category of question", driver, testCaseName, "Yes");
					
					//Test case 7 - Verify writing question to ask
					SikuliUtil.verifyObjectAndClickOn("editbox", screen, parentTest, "Click on editbox", driver, testCaseName, "No");
					Sleep(3000);
					screen.paste("如何照顾怀孕的女士？");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("my_question", screen, parentTest, "Verify writing question to ask", driver, testCaseName, "Yes");
					SikuliUtil.verifyObjectAndClickOn("babytree_logo", screen, parentTest, "Click on logo", driver, testCaseName, "No");
					
					//Test case 8 - Verify searching pregnancy
					SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Click inside searchbox", driver, testCaseName, "No");
					Sleep(4000);
					screen.paste("怀孕");
					Sleep(4000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("pregnancy_word", screen, parentTest, "Verify searching  prgnancy info", driver, testCaseName, "Yes");
					
					//Test case 9 - Verify Babytree favicon
					SikuliUtil.verifyObjectAndHighlight("babytree_favicon", screen, parentTest, "Verify favicon of Babytree", driver, testCaseName, "Yes");
					
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The Babytree TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
							
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The Babytree TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}
	}			

