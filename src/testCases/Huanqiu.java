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

	public class Huanqiu extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Huanqiu");
				
				public void navigateToURL(WebDriver driver){
					siteURL="http://www.huanqiu.com";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Huanqiu";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					//Test case 1 - verify navigation to Huanqiu
					SikuliUtil.verifyObjectAndHighlight("huanqiu_logo", screen, parentTest, "Verify navigation to Huanqiu", driver, testCaseName, "Yes");
					
					//Test case 2 - Verify scrolling on page
					
					 SikuliUtil.moveWheel(screen, 1, 20);
					 Sleep(15000);
					 SikuliUtil.verifyObjectAndClickOn("pageUp_button", screen, parentTest, "Verify scrolling on the page", driver, testCaseName, "Yes");
					 Sleep(5000);
					 
					 //Test case 3 - Verify All tab is selected By Default on Scroll News page
					 SikuliUtil.verifyObjectAndClickOn("ScrollNews_button", screen, parentTest, "Verify navigating to Scroll news tab", driver, testCaseName, "No");
					 Sleep(5000);
					 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					 driver.switchTo().window(tabs2.get(1));
					 Sleep(10000);
					 SikuliUtil.verifyObjectAndHighlight("selectedAll_tab", screen, parentTest, "Verify All tab is selected By Default on Scroll News page", driver, testCaseName, "Yes");
					 
					 //Test case 4 - Verify visiting Domestic news
					 SikuliUtil.verifyObjectAndHighlight("domestic_tab", screen, parentTest, "Hover on domestic tab", driver, testCaseName, "No");
					 Sleep(10000);
					 SikuliUtil.verifyObjectAndHighlight("selected_domesticTab", screen, parentTest, "Verify visiting Domestic news", driver, testCaseName, "Yes");
					 
					 //Test case 5 - Verify visiting World news
					 SikuliUtil.verifyObjectAndHighlight("world_tab", screen, parentTest, "Hover on World tab", driver, testCaseName, "No");
					 Sleep(10000);
					 SikuliUtil.verifyObjectAndHighlight("selected_worldTab", screen, parentTest, "Verify visiting World news", driver, testCaseName, "Yes");
					 
					
					 
					 Sleep(5000);
					 driver.close();
					 driver.switchTo().window(tabs2.get(0));
					 Sleep(4000);
					 
					
					 //Test case 6 - Verify navigating International tab
					 	SikuliUtil.verifyObjectAndClickOn("International_tab", screen, parentTest, "Click on International tab", driver, testCaseName, "No");
					    Sleep(5000);
					    ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs4.get(1));
					    Sleep(10000);
					    SikuliUtil.verifyObjectAndHighlight("InternationalNews_title", screen, parentTest, "Verify navigating International tab", driver, testCaseName, "Yes");
					    Sleep(5000);
						driver.close();
					    driver.switchTo().window(tabs4.get(0));
					    Sleep(4000);
					 
					    //Test case 7 - Verify favicon of Huanqiu
					    SikuliUtil.verifyObjectAndClickOn("huanqiu_favicon", screen, parentTest, "Verify favicon of Huanqiu", driver, testCaseName, "Yes");
					    
					

						
					    
					    //Test case 8 - Verify searching China news
					    SikuliUtil.verifyObjectAndHighlight("huanqiu_logo", screen, parentTest, "Hover on Logo", driver, testCaseName, "No");
					    SikuliUtil.moveWheel(screen, 1, 30);
						Sleep(15000);
						if(SikuliUtil.isPresent(screen, "searchbox")){
						SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Verify searching China news", driver, testCaseName, "No");
						Sleep(3000);
						screen.paste("中国");
						Sleep(3000);
						SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
						Sleep(5000);
						 ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
						 driver.switchTo().window(tabs3.get(1));
						 Sleep(10000);
						SikuliUtil.verifyObjectAndHighlight("china_word", screen, parentTest, "China news get searched", driver, testCaseName, "Yes");
						 Sleep(5000);
							driver.close();
						    driver.switchTo().window(tabs3.get(0));
						    Sleep(4000);
						}
						
						Sleep(4000);
						ReportGenerator.logStatusPass(parentTest, testCaseName, "The Huanqiu TestCase is working as expected");
						Loggers.stopCurrentTestCaseExecution(testCaseName);
								
						}catch(Exception e){
							
					
							
							//In case of failure, mention the same in logs and Report
							Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
							System.out.println(e);
							ReportGenerator.logStatusFail(parentTest,testCaseName, "The Huanqiu TestCase Failed,Please see logs and error screenshots", this.driver);
						}
							finally{
								quitDriver(this.driver);
								path=currentSitePath;
								ReportGenerator.flushReportToDisk(parentTest);
							}
			}

	}			

					 