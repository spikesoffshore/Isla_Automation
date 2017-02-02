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

	public class Gmw extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Gmw");
				
				public void navigateToURL(WebDriver driver){
					siteURL="http://www.gmw.cn";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Gmw";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					//Test case 1 - verify navigation to Gmw
					SikuliUtil.verifyObjectAndHighlight("gmw_logo", screen, parentTest, "Verify navigation to Gmw", driver, testCaseName, "Yes");
					
					//Test case 2 - Verify navigation to headlines
					SikuliUtil.verifyObjectAndClickOn("headlines_button", screen, parentTest, "Verify navigating to headlines", driver, testCaseName, "No");
					Sleep(5000);  
					ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(tabs3.get(1));
					Sleep(10000);
					SikuliUtil.verifyObjectAndHighlight("headlines_word", screen, parentTest, "Verify headlines navigated", driver, testCaseName, "Yes");
					SikuliUtil.clickRight("headlines_word", screen, parentTest, "Click for scroll", driver, testCaseName, "No", 20);
					//Test case 3 - Verify headlines displayed are of page 1
					Sleep(3000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_END);
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("selected_page1", screen, parentTest, "Verify headlines displayed are of page 1", driver, testCaseName, "Yes");
					
					//Test case 4 - Verify navigating headlines of page 2
					SikuliUtil.verifyObjectAndClickOn("page_2", screen, parentTest, "Verify clicking on page 2 button", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("headlines_word", screen, parentTest, "Verify headlines navigated", driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_END);
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("selected_page2", screen, parentTest, "Verify navigating headlines of page 2", driver, testCaseName, "Yes");
					
					Sleep(3000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
					
					//Test case 5 - Verify navigating to home page by clicking headline page logo
				
					SikuliUtil.verifyObjectAndClickOn("headlinepage_logo", screen, parentTest, "Verify clicking headline page logo", driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.verifyObjectAndHighlight("gmw_logo", screen, parentTest, "Verify navigating to home page", driver, testCaseName, "Yes");
					Sleep(5000);
					driver.close();
					driver.switchTo().window(tabs3.get(0));
					Sleep(4000);
					
					//Test case 6 - Verify searching china news
					 SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Verify searching china news", driver, testCaseName, "No");
						Sleep(3000);
						screen.paste("中国");
						Sleep(3000);
						SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
						Sleep(5000);
					    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs2.get(1));
					    Sleep(10000);
					    if(SikuliUtil.isPresent(screen, "error")){
					    	SikuliUtil.keyPress(robot, KeyEvent.VK_F5);
						    Sleep(10000);
					    }
					    SikuliUtil.verifyObjectAndHighlight("china_word", screen, parentTest, "China news get searched", driver, testCaseName, "Yes");
						
					  //Test case  7 - Verify refreshing new tab page 
					    Sleep(2000);
					    SikuliUtil.keyPress(robot, KeyEvent.VK_F5);
					    Sleep(10000);
					    SikuliUtil.verifyObjectAndHighlight("china_word", screen, parentTest, "Verify refreshing page", driver, testCaseName, "Yes");
					    
					    Sleep(5000);
						driver.close();
					    driver.switchTo().window(tabs2.get(0));
					    Sleep(4000);
					    
					    //Test case 8 - Verify navigating to digital news paper
					    SikuliUtil.verifyObjectAndClickOn("digital_paper_button", screen, parentTest, "Verify navigating to digital news paper", driver, testCaseName, "No");
					    Sleep(5000);
					    ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs4.get(1));
					    Sleep(10000);
					    SikuliUtil.verifyObjectAndHighlight("epaper_url", screen, parentTest, "Verify Digital news paper navigated", driver, testCaseName, "Yes");
					    Sleep(5000);
						driver.close();
					    driver.switchTo().window(tabs4.get(0));
					    Sleep(4000);
					    
					    
					  //Test case 9 - Verify Gmw favicon
					    SikuliUtil.verifyObjectAndHighlight("gmw_favicon", screen, parentTest, "Verify gmw favicon", driver, testCaseName, "Yes");
					    
					  //test case 10 -  Verify reloading the page
					    SikuliUtil.mouseRightClick("headlines_button", screen);

						Sleep(2000);
						SikuliUtil.verifyObjectAndClickOn("Reload_button", screen, parentTest, "Verify reloading the page", driver, testCaseName, "No");
						Sleep(10000);
						SikuliUtil.verifyObjectAndHighlight("gmw_logo", screen, parentTest, "Verify Gmw logo", driver, testCaseName, "No");
						SikuliUtil.verifyObjectAndHighlight("digital_paper_button", screen, parentTest, "Verify Digital newspaper button", driver, testCaseName, "No");
						SikuliUtil.verifyObjectAndHighlight("headlines_button", screen, parentTest, "Verify Page reloaded successfully", driver, testCaseName, "Yes");
						
					    
					   
				    
								Sleep(4000);
								ReportGenerator.logStatusPass(parentTest, testCaseName, "The Xinhuanet TestCase is working as expected");
								Loggers.stopCurrentTestCaseExecution(testCaseName);
										
								}catch(Exception e){
									
							
									
									//In case of failure, mention the same in logs and Report
									Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
									System.out.println(e);
									ReportGenerator.logStatusFail(parentTest,testCaseName, "The Gmw TestCase Failed,Please see logs and error screenshots", this.driver);
								}
									finally{
										quitDriver(this.driver);
										path=currentSitePath;
										ReportGenerator.flushReportToDisk(parentTest);
									}
					}

			}			
