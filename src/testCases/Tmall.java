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

	public class Tmall extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Tmall");
				
				public void navigateToURL(WebDriver driver){
					siteURL="https://www.tmall.com";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Tmall";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					//Test case 1 - verify navigation to Tmall
					ReportGenerator.verifyNavigation(this.driver, "tmall.com", parentTest,testCaseName,"Yes");
					
					
					
					//Test case 2 - Verify searching shirts
					Sleep(5000);
					screen.paste("衬衫");
					Sleep(5000);
					SikuliUtil.verifyObjectAndClickOn("search_button", screen, parentTest, "Verify clicking search button", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("Shirt_word", screen, parentTest, "Verify Shirts get searched", driver, testCaseName, "Yes");
					
					//Test case 3 - Verify sorting shirts by prize
					SikuliUtil.verifyObjectAndClickOn("prize_tab", screen, parentTest, "Verify clicking prize tab", driver, testCaseName, "No");
					Sleep(5000);
					SikuliUtil.verifyObjectAndHighlight("Selected_prizeTab", screen, parentTest, "Verify Shirts get sorted by prize", driver, testCaseName, "Yes");
					
					//Test case 4 -  Verify navigating back to home page using logo
					driver.navigate().back();
					Sleep(3000);
					SikuliUtil.verifyObjectAndClickOn("tmall_logo", screen, parentTest, "Verify clicking logo", driver, testCaseName, "No");
					Sleep(4000);
					SikuliUtil.verifyObjectAndHighlight("tmall_homelogo", screen, parentTest, "Verify navigating back to home page", driver, testCaseName, "Yes");
					
					//Test case 5 - Verify initial cart value 0
					SikuliUtil.verifyObjectAndHighlight("Initial_Cart", screen, parentTest, "Verify initial cart value is zero", driver, testCaseName, "Yes");
					
					//Test case 6 - Verify hovering button shows their name
					SikuliUtil.verifyObjectAndHighlight("asset_button", screen, parentTest, "Verify hovering My asset button", driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.verifyObjectAndHighlight("MyAsset_name", screen, parentTest, "Verify My asset name pops up on hovering button", driver, testCaseName, "Yes");
					
					//Test case 7 - Verify navigating women category
					SikuliUtil.verifyObjectAndClickOn("Women_category", screen, parentTest, "Verify navigating women category", driver, testCaseName, "Yes");
				    Sleep(10000);
				    ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(tabs4.get(1));
				    Sleep(10000);
				    SikuliUtil.verifyObjectAndHighlight("Women_word", screen, parentTest, "Women home page navigated", driver, testCaseName, "No");
				   
				    //Test case 8 - verify reloading new tab page
				    SikuliUtil.mouseRightClick("Women_word", screen);

					Sleep(2000);
					SikuliUtil.verifyObjectAndClickOn("Reload_button", screen, parentTest, "Verify reloading the page", driver, testCaseName, "No");
					Sleep(10000);
					SikuliUtil.verifyObjectAndHighlight("Women_word", screen, parentTest, "Page reloaded successfully", driver, testCaseName, "Yes");
				    Sleep(5000);
					driver.close();
				    driver.switchTo().window(tabs4.get(0));
				    Sleep(4000);
				    
				    //Test case 9 - Verify scrolling on page
					
					SikuliUtil.moveWheel(screen, 1, 50);
					Sleep(15000);
					Loggers.writeInfoLog("Scrolling done");
				    
				  //Test case 10 - verify Tmall favicon
					SikuliUtil.verifyObjectAndHighlight("tmall_favicon", screen, parentTest, "Verify Tmall favicon", driver, testCaseName, "Yes");
					
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The Tmall TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				
					
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The Tmall TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}

}			


	

