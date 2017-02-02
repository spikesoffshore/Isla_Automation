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

	public class Xinhuanet extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Xinhuanet");
				
				public void navigateToURL(WebDriver driver){
					siteURL="http://www.xinhuanet.com";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Xinhuanet";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					//Test case 1 - verify navigation to xinhuanet
					SikuliUtil.verifyObjectAndHighlight("xinhua_logo", screen, parentTest, "Verify navigation to Xinhuanet", driver, testCaseName, "Yes");
					
					//Test case 2 - verify xinhuanet favicon
					SikuliUtil.verifyObjectAndHighlight("xinhua_favicon", screen, parentTest, "Verify Xinhuanet favicon", driver, testCaseName, "Yes");
					
					//Test case 3 - Verify searching china news
					SikuliUtil.verifyObjectAndClickOn("searchbox", screen, parentTest, "Verify searching china news", driver, testCaseName, "No");
					Sleep(3000);
					screen.paste("中国");
					Sleep(3000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					Sleep(10000);
				    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(tabs2.get(1));
				    SikuliUtil.verifyObjectAndHighlight("china_word", screen, parentTest, "China news get searched", driver, testCaseName, "Yes");
					Sleep(5000);
					driver.close();
				    driver.switchTo().window(tabs2.get(0));
				    Sleep(2000);
				    
				    //Test case 4 - verify navigating to mailbox tab
				    SikuliUtil.verifyObjectAndClickOn("mailbox_tab", screen, parentTest, "Verify navigating mailbox tab", driver, testCaseName, "No");
				    Sleep(10000);
				    ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(tabs3.get(1));
				    SikuliUtil.verifyObjectAndHighlight("mailbox_logo", screen, parentTest, "Mailbox tab navigated", driver, testCaseName, "Yes");
					Sleep(5000);
					driver.close();
				    driver.switchTo().window(tabs3.get(0));
				    Sleep(4000);
		    
				    //Test case 5 - Verify languages supported by site
				   SikuliUtil.verifyObjectAndHighlight("English_tab", screen, parentTest, "Verify opening list of languages supported", driver, testCaseName, "Yes");
				   Sleep(4000);
				   SikuliUtil.verifyObjectAndHighlight("chinese_language", screen, parentTest, "Verify highlighing one of the language", driver, testCaseName, "No");
				   SikuliUtil.verifyObjectAndHighlight("Portugese_language", screen, parentTest, "Verify highlighing another language", driver, testCaseName, "No");
				   SikuliUtil.verifyObjectAndHighlight("xinhua_logo", screen, parentTest, "Verify navigation to Xinhuanet", driver, testCaseName, "No");
				   
				   //Test case 6 - Verify navigating Xinhuanet daily paper
				   SikuliUtil.verifyObjectAndHighlight("Newspaper_tab", screen, parentTest, "Verify hovering newspaper tab", driver, testCaseName, "No");
				   SikuliUtil.verifyObjectAndClickOn("Xinhuanet_dailymail_link", screen, parentTest, "Verify clicking daily telegraph link", driver, testCaseName, "No");
				    Sleep(10000);
				    ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(tabs4.get(1));
				    SikuliUtil.verifyObjectAndHighlight("dailytelegraph_logo", screen, parentTest, "Daily telegraph navigated", driver, testCaseName, "Yes");
				    
				    //Test case  7 - Verify refreshing new tab page
				    Sleep(2000);
				    SikuliUtil.keyPress(robot, KeyEvent.VK_F5);
				    Sleep(10000);
				    SikuliUtil.verifyObjectAndHighlight("dailytelegraph_logo", screen, parentTest, "New tab page refeshed", driver, testCaseName, "Yes");
				    
					Sleep(5000);
					driver.close();
				    driver.switchTo().window(tabs4.get(0));
				    Sleep(4000);
				   
				    //Test case 8 - Minimize & maximize Breaking news list on Site navigation page
				    SikuliUtil.verifyObjectAndClickOn("SiteNavigation_Tab", screen, parentTest, "Verify navigating Site navigation tab", driver, testCaseName, "No");
				    Sleep(10000);
				    ArrayList<String> tabs5 = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(tabs5.get(1));
				    SikuliUtil.verifyObjectAndClickOn("down_arrow", screen, parentTest, "Verify minimizing breaking news list", driver, testCaseName, "No");
				    Sleep(3000);
				    SikuliUtil.verifyObjectAndHighlight("Up_arrow", screen, parentTest, "breaking news list minimized", driver, testCaseName, "Yes");
				    SikuliUtil.verifyObjectAndClickOn("Up_arrow", screen, parentTest, "Verify maximizing breaking news list", driver, testCaseName, "No");
				    Sleep(3000);
				    SikuliUtil.verifyObjectAndHighlight("down_arrow", screen, parentTest, "breaking news list maximized", driver, testCaseName, "Yes");
				    
					Sleep(5000);
					driver.close();
				    driver.switchTo().window(tabs5.get(0));
				    Sleep(4000);
				    
				    //Test case 9 - verify scrolling
					  
					SikuliUtil.moveWheel(screen, 1, 30);
				   Sleep(10000);

				    if(SikuliUtil.isPresent(screen, "hotWord_link")){
					   SikuliUtil.verifyObjectAndHighlight("hotWord_link", screen, parentTest, "Verify page scrolled successfully", driver, testCaseName, "Yes");
				   }else{
					   SikuliUtil.moveWheel(screen, 1, 30);
					   Sleep(10000);
					   SikuliUtil.verifyObjectAndHighlight("hotWord_link", screen, parentTest, "Verify page scrolled successfully", driver, testCaseName, "Yes");
				   }
				 
				   
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The Xinhuanet TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
							
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The Xinhuanet TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}

}			


	
