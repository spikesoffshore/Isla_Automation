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

	public class Hao123 extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Hao123");
				
				public void navigateToURL(WebDriver driver){
					siteURL="https://www.hao123.com/";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Hao123";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					//Test case 1 - verify navigation to Hao123
					ReportGenerator.verifyNavigation(this.driver, "hao123", parentTest,testCaseName,"Yes");
					
					Sleep(6000);
					
					//Test case 2- Navigating to News page
					SikuliUtil.verifyObjectAndHighlight("news_tab", screen, parentTest, "Highlight news tab", driver, testCaseName, "No");
					 SikuliUtil.verifyObjectAndClickOn("news_tab", screen, parentTest, "Verify navigating news page", driver, testCaseName, "Yes");
					 Sleep(3000);
					 SikuliUtil.verifyObjectAndHighlight("openedNews_tab", screen, parentTest, "News page navigated", driver, testCaseName, "No");
					 
					 //Test case 3 - Navigating back to home page
					 SikuliUtil.verifyObjectAndHighlight("home_tab", screen, parentTest, "Highlight home tab", driver, testCaseName, "No");
					 SikuliUtil.verifyObjectAndClickOn("home_tab", screen, parentTest, "Verify navigating back to home page", driver, testCaseName, "Yes");
					 Sleep(3000);
					 SikuliUtil.verifyObjectAndHighlight("openedHome_tab", screen, parentTest, "Home page navigated", driver, testCaseName, "No");
			
					 //Test case 4 - Verify scrolling on page
					 
					 SikuliUtil.moveWheel(screen, 1, 30);
					 Sleep(20000);
					 SikuliUtil.verifyObjectAndHighlight("Scroll_proof", screen, parentTest, "Page scrolled successfully", driver, testCaseName, "Yes");
					
					 Sleep(5000);
					 
					 //Test case 5 - Verify searching china
					 SikuliUtil.verifyObjectAndClickOn("searchbox1", screen, parentTest, "Verify searching china news", driver, testCaseName, "No");
						Sleep(5000);
						screen.paste("中国");
						Sleep(5000);
						SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
						Sleep(5000);
					    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs2.get(1));
					    Sleep(10000);
					    SikuliUtil.verifyObjectAndHighlight("china_word", screen, parentTest, "China news get searched", driver, testCaseName, "Yes");
						
					  //Test case  6 - Verify refreshing new tab page 
					    Sleep(2000);
					    SikuliUtil.keyPress(robot, KeyEvent.VK_F5);
					    Sleep(10000);
					    SikuliUtil.verifyObjectAndHighlight("china_word", screen, parentTest, "Verify refreshing page", driver, testCaseName, "Yes");
					    
					    Sleep(5000);
						driver.close();
					    driver.switchTo().window(tabs2.get(0));
					    Sleep(2000);
					    
					   //Test case  7 - Verify searching image category
					    SikuliUtil.verifyObjectAndClickOn("page_link", screen, parentTest, "Verify searching by image category", driver, testCaseName, "Yes");
					    SikuliUtil.verifyObjectAndClickOn("pictures_link", screen, parentTest, "Verify selecting picture category", driver, testCaseName, "No");
					    Sleep(3000);
						screen.paste("XXX");
						Sleep(4000);
						SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
						Sleep(10000);
					    ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs3.get(1));
					    Sleep(10000);
					    ReportGenerator.verifyNavigation(this.driver, "XXX", parentTest,testCaseName,"No");
					    Sleep(5000);
						driver.close();
					    driver.switchTo().window(tabs3.get(0));
					    Sleep(4000);
					    
						
						//Test case 8 - verify Hao123 favicon
					    
					    
						SikuliUtil.verifyObjectAndHighlight("hao_favicon", screen, parentTest, "Verify Hao123 favicon", driver, testCaseName, "Yes");
					
					    
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The Xinhuanet TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
							
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The Hao123 TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}

}			

