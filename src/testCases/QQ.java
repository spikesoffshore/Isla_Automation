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

	public class QQ extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing QQ");
				
				public void navigateToURL(WebDriver driver){
					siteURL="http://www.qq.com";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/QQ";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					//Test case 1 - verify navigation to QQ
					SikuliUtil.verifyObjectAndHighlight("qq_logo", screen, parentTest, "Verify navigation to QQ", driver, testCaseName, "Yes");
					
					
					//Test case 2 - Verify scrolling on page
					 
					 SikuliUtil.moveWheel(screen, 1, 30);
					 Sleep(15000);
					 SikuliUtil.verifyObjectAndClickOn("pageUp_button", screen, parentTest, "Verify scrolling on the page", driver, testCaseName, "Yes");
					
					 Sleep(5000);
					 
					 
					 //Test case 3 - Verify searching china
					 SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Verify searching china news", driver, testCaseName, "No");
						Sleep(3000);
						screen.paste("中国");
						Sleep(3000);
						SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
						Sleep(5000);
					    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs2.get(1));
					    Sleep(10000);
					    SikuliUtil.verifyObjectAndHighlight("china_word", screen, parentTest, "China news get searched", driver, testCaseName, "Yes");
						
					  //Test case  4 - Verify refreshing new tab page 
					    Sleep(2000);
					    SikuliUtil.keyPress(robot, KeyEvent.VK_F5);
					    Sleep(10000);
					    SikuliUtil.verifyObjectAndHighlight("china_word", screen, parentTest, "Verify refreshing page", driver, testCaseName, "Yes");
					    
					    Sleep(5000);
						driver.close();
					    driver.switchTo().window(tabs2.get(0));
					    Sleep(4000);
					    
					    //Test case 5 -  Verify search text is still present in searchbox
					    SikuliUtil.verifyObjectAndHighlight("chinaIn_searchbox", screen, parentTest, "Verify china word still there in searcbox", driver, testCaseName, "Yes");
					    
					   //Test case  6 - Verify searching image category
					    SikuliUtil.verifyObjectAndHighlight("web_link", screen, parentTest, "Verify searching news with image category", driver, testCaseName, "Yes");
					    SikuliUtil.verifyObjectAndClickOn("image_link", screen, parentTest, "Verify selecting picture category", driver, testCaseName, "No");
					    SikuliUtil.verifyObjectAndClickOn("chinaIn_searchbox", screen, parentTest, "Verify selecting china word in searchbox", driver, testCaseName, "No");
					    Sleep(3000);
					    SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);
					    Sleep(2000);
					    SikuliUtil.keyPress(robot, KeyEvent.VK_BACK_SPACE);
					    Sleep(3000);
						screen.paste("FRIENDS");
						Sleep(4000);
						SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
						Sleep(5000);
					    ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs3.get(1));
					    Sleep(10000);
					    ReportGenerator.verifyNavigation(this.driver, "FRIENDS", parentTest,testCaseName,"No");
					    Sleep(5000);
						driver.close();
					    driver.switchTo().window(tabs3.get(0));
					    Sleep(4000);
					    
					 //Test case 7- verify navigating to NBA tab
					    SikuliUtil.verifyObjectAndClickOn("NBA_tab", screen, parentTest, "Verify navigating to NBA tab", driver, testCaseName, "Yes");
					    Sleep(5000);
					    ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs4.get(1));
					    Sleep(10000);
					    ReportGenerator.verifyNavigation(this.driver, "NBA", parentTest,testCaseName,"No");
					    Sleep(5000);
						driver.close();
					    driver.switchTo().window(tabs4.get(0));
					    Sleep(4000);
					    
					   //Test case 8 - Verify QQ favicon
					    SikuliUtil.verifyObjectAndHighlight("qq_favicon", screen, parentTest, "Verify QQ favicon", driver, testCaseName, "Yes");
					
					    //test case 9 -  Verify reloading the page
					    SikuliUtil.mouseRightClick("qq_logo", screen);

						Sleep(2000);
						SikuliUtil.verifyObjectAndClickOn("Reload_button", screen, parentTest, "Verify reloading the page", driver, testCaseName, "No");
						Sleep(10000);
						SikuliUtil.verifyObjectAndHighlight("qq_logo", screen, parentTest, "Verify QQ page reloaded", driver, testCaseName, "Yes");
					    
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The Xinhuanet TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
							
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The QQ TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}

}			
