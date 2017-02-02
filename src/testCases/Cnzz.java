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

	public class Cnzz extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Cnzz");
				
				public void navigateToURL(WebDriver driver){
					siteURL="www.umeng.com";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Cnzz";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					//Test case 1 - verify navigation to Cnzz
					SikuliUtil.verifyObjectAndHighlight("cnzz_logo", screen, parentTest, "Verify navigation to Cnzz", driver, testCaseName, "Yes");
					
					//Test case 2 - verify scrolling
					Sleep(2000);
					SikuliUtil.moveWheel(screen, 1, 30);
					Sleep(15000);
					
					SikuliUtil.verifyObjectAndClickOn("pageUp_button", screen, parentTest, "Verify scrolling on the page", driver, testCaseName, "Yes");
					Sleep(4000);
					
					//Test case 3 - Verify closing introduction window
					SikuliUtil.verifyObjectAndClickOn("Close_button", screen, parentTest, "Verify closing introduction window", driver, testCaseName, "Yes");
					
					//Test case 4 - Verify list of cnzz products
					SikuliUtil.verifyObjectAndHighlight("product_tab", screen, parentTest, "Verify list of cnzz products", driver, testCaseName, "No");
					Sleep(2000);
					SikuliUtil.verifyObjectAndHighlight("U-app_link", screen, parentTest, "Verify cnzz products presents in product tab", driver, testCaseName, "Yes");
					SikuliUtil.verifyObjectAndHighlight("U-web_lonk", screen, parentTest, "Highlight U-web product", driver, testCaseName, "No");

					
					//Test case 5 - View iOS Demo App
					SikuliUtil.verifyObjectAndClickOn("U-app_link", screen, parentTest, "Verify clicking on U-app link", driver, testCaseName, "No");
					Sleep(4000);
					SikuliUtil.verifyObjectAndClickOn("viewDemo_buton", screen, parentTest, "Verify navigating iOS demo app", driver, testCaseName, "No");
					Sleep(5000);
					ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(tabs2.get(1));
					Sleep(10000);
					ReportGenerator.verifyNavigation(driver, "iOS Demo App", parentTest, testCaseName, "Yes");
					
					//test case 6 - Verify switching to Android Demo App
					SikuliUtil.verifyObjectAndClickOn("iosDemo_dropdown", screen, parentTest, "Verify opening drop down", driver, testCaseName, "No");
					Sleep(2000);
					SikuliUtil.verifyObjectAndClickOn("androidDemo_link", screen, parentTest, "Verify switching to Android Demo App", driver, testCaseName, "Yes");
					Sleep(4000);
					ReportGenerator.verifyNavigation(driver, "Android Demo App", parentTest, testCaseName, "No");
					Sleep(5000);
					driver.close();
					driver.switchTo().window(tabs2.get(0));
					Sleep(4000);
					
					//Test case  7 - Verify navigating Home page clicking logo
					SikuliUtil.verifyObjectAndClickOn("cnzz_logo", screen, parentTest, "Verify clicking logo", driver, testCaseName, "No");
					Sleep(4000);
					SikuliUtil.verifyObjectAndHighlight("IntroductionWindow_button", screen, parentTest, "Verify cnzz products presents in product tab", driver, testCaseName, "Yes");
					
					//Test case 8 - Verify navigating reports tab
					SikuliUtil.verifyObjectAndClickOn("reports_tab", screen, parentTest, "Verify navigating reports tab", driver, testCaseName, "No");
					Sleep(4000);
					SikuliUtil.moveWheel(screen, 1, 15);
					Sleep(10000);
					SikuliUtil.verifyObjectAndHighlight("pdf_button", screen, parentTest, "Verify navigation to reports tab", driver, testCaseName, "Yes");
					
					//Test case 9 - Verify opening report in pdf
					  SikuliUtil.verifyObjectAndClickOn("pdf_button", screen, parentTest, "Verify opening report in pdf file", driver, testCaseName, "Yes");
					    Sleep(5000);
					    ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs4.get(1));
					    Sleep(10000);
					    ReportGenerator.verifyNavigation(driver, "pdf", parentTest, testCaseName, "No");
					    Sleep(5000);
						driver.close();
					    driver.switchTo().window(tabs4.get(0));
					    Sleep(4000);
					    
					    
					//Test case 10 - Verify Gmw favicon
						SikuliUtil.verifyObjectAndHighlight("cnzz_favicon", screen, parentTest, "Verify Cnzz favicon", driver, testCaseName, "Yes"); 
					    
					    
					
					
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The Xinhuanet TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
							
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The Cnzz TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}

}			
