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

	public class Bilibili extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Bilibili");
				
				public void navigateToURL(WebDriver driver){
					siteURL="http://www.Bilibili.com";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Bilibili";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					
					//Test case 1 - verify navigation to QQ
					ReportGenerator.verifyNavigation(driver, "bilibili", parentTest, testCaseName, "Yes");
					
					//Test case 2 - Verify Bilibili favicon
					  SikuliUtil.verifyObjectAndHighlight("bilibili_favicon", screen, parentTest, "Verify Bilibili favicon", driver, testCaseName, "Yes");
					
					  //Test case 3 - Verify searching games
						 SikuliUtil.clickLeft("searchbox", screen, parentTest, "Click inside searchbox", driver, testCaseName, "No", 2);
							Sleep(4000);
							screen.paste("游戏");
							Sleep(4000);
							SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
							Sleep(5000);
							 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
							 driver.switchTo().window(tabs2.get(1));
							 Sleep(10000);
							SikuliUtil.verifyObjectAndHighlight("games_word", screen, parentTest, "Verify searching games", driver, testCaseName, "Yes");
							 Sleep(5000);
								driver.close();
							    driver.switchTo().window(tabs2.get(0));
							    Sleep(4000);
					  
					 //Test case 4 - Verify scrolling on page
					
					 SikuliUtil.moveWheel(screen, 1, 20);
					 Sleep(15000);
					 SikuliUtil.verifyObjectAndClickOn("pageUp_button", screen, parentTest, "Verify scrolling on the page", driver, testCaseName, "Yes");
					 Sleep(5000);
					 
					 //Test case 5 - Verify visiting GMV sub-tab under Games Tab
					 SikuliUtil.verifyObjectAndHighlight("games_tab", screen, parentTest, "Hover on games tab", driver, testCaseName, "No");
   					 Sleep(2000);
   					SikuliUtil.verifyObjectAndHighlight("GMV_subtab", screen, parentTest, "Verify visiting GMV sub-tab under Games Tab", driver, testCaseName, "Yes");
   					
   					 //Test case 6 - Verify navigating to games Tab
   					SikuliUtil.verifyObjectAndClickOn("games_tab", screen, parentTest, "Click on games tab", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("games_title", screen, parentTest, "Verify navigating to games Tab", driver, testCaseName, "Yes");
					
					//Test case 7 -  Verify sharing the video using Weibo
					if(SikuliUtil.isPresent(screen, "Play_button")){
						SikuliUtil.verifyObjectAndClickOn("Play_button", screen, parentTest, "Click on Play button", driver, testCaseName, "No");
					}else{
						SikuliUtil.moveWheel(screen, 1, 25);
						Sleep(10000);
						SikuliUtil.verifyObjectAndClickOn("Play_button", screen, parentTest, "Click on Play button", driver, testCaseName, "No");
					}
					
					Sleep(5000);
					 ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
					 Sleep(2000);
					 driver.close();
					 Sleep(2000);
					 driver.switchTo().window(tabs3.get(1));
					 Sleep(10000);
					 
					 SikuliUtil.moveWheel(screen, 1, 30);
					 Sleep(10000);
					 
					 SikuliUtil.verifyObjectAndHighlight("Share_button", screen, parentTest, "Highlight share button", driver, testCaseName, "No");
					 Sleep(2000);
					 SikuliUtil.verifyObjectAndClickOn("weibo_button", screen, parentTest, "Click on Weibo button", driver, testCaseName, "No");
					 Sleep(5000);
					 ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
					 driver.switchTo().window(tabs4.get(1));
					 Sleep(10000);
					 if(SikuliUtil.isPresent(screen, "close_button")){
					 SikuliUtil.verifyObjectAndClickOn("close_button", screen, parentTest, "Click on close button", driver, testCaseName, "No");
					 }
					 SikuliUtil.verifyObjectAndHighlight("Weibo_logo", screen, parentTest, "Highlight Weibo logo", driver, testCaseName, "No");
					 SikuliUtil.verifyObjectAndHighlight("ShareIt_button", screen, parentTest, "Verify sharing the video using Weibo", driver, testCaseName, "Yes");
					 Sleep(5000);
					 driver.close();
					 driver.switchTo().window(tabs4.get(0));
					 Sleep(5000);
					 
					 //Test case 8 - Verify seeing latest comments related to video
					 SikuliUtil.moveWheel(screen, 1, 40);
					 Sleep(10000);
					 SikuliUtil.verifyObjectAndHighlight("Selected_LatestComments", screen, parentTest, "Verify seeing latest comments related to video", driver, testCaseName, "Yes");
					 
					 //Test case 9 - Verify seeing top comments related to video 
					 SikuliUtil.verifyObjectAndClickOn("TopComments_tab", screen, parentTest, "click on top comments tab", driver, testCaseName, "No");
					 Sleep(5000);
					  SikuliUtil.verifyObjectAndHighlight("Selected_TopComments", screen, parentTest, "Verify seeing top comments related to video", driver, testCaseName, "Yes");
					 
								Sleep(4000);
								ReportGenerator.logStatusPass(parentTest, testCaseName, "The Bilibili TestCase is working as expected");
								Loggers.stopCurrentTestCaseExecution(testCaseName);
										
								}catch(Exception e){
									
							
									
									//In case of failure, mention the same in logs and Report
									Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
									System.out.println(e);
									ReportGenerator.logStatusFail(parentTest,testCaseName, "The Bilibili TestCase Failed,Please see logs and error screenshots", this.driver);
								}
									finally{
										quitDriver(this.driver);
										path=currentSitePath;
										ReportGenerator.flushReportToDisk(parentTest);
									}
					}

			}			
