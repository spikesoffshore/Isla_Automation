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

public class Microsoft extends Base {
	
		private WebDriver driver;
		private String currentSitePath;
		private String testCaseName=getClass().getName().substring(10); 
		ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Microsoft");
			
			public void navigateToURL(WebDriver driver){
				siteURL="https://www.microsoft.com";
				driver.navigate().to(baseurl+siteURL);
				}
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Microsoft";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//Test Case 1 - Verify navigation to Microsoft
				ReportGenerator.verifyNavigation(this.driver, "Microsoft", parentTest,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndHighlight("microsoft_logo", screen, parentTest, "Verify logo of Microsoft", driver, testCaseName, "No");
               
				//Test Case 2 - Verify Sign In
				SikuliUtil.verifyObjectAndHighlight("SignIn_link", screen, parentTest, "Sign in link is present", driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("SignIn_link", screen, parentTest, "Verify clicking SignIn link", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.typeScreen(screen,"spikesqa@gmail.com");
			    Sleep(2000);
			    SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(2000);
				SikuliUtil.typeScreen(screen,"QAqa4321!");
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("username", screen, parentTest, "User logged in successfully", driver, testCaseName, "Yes");
				
				//Test Case 3 - Verify navigating to Support tab
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Support_tab", screen, parentTest, "Verify clicking Support tab", driver, testCaseName, "No");
				ReportGenerator.verifyNavigation(this.driver, "Microsoft Support", parentTest,testCaseName,"Yes");
				
				//Test Case 4 - Navigating back to home page
				SikuliUtil.verifyObjectAndClickOn("microsoft_logo", screen, parentTest, "Verify navigating back to home page", driver, testCaseName, "Yes");
				ReportGenerator.verifyNavigation(this.driver, "Official Home", parentTest,testCaseName,"No");
		
		
				//Test Case 5- Verify navigating to Store Home sub tab
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("Store_tab", screen, parentTest, "Verify clicking Storet tab", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("StoreHome_subtab", screen, parentTest, "Verify clicking Store Home sub tab", driver, testCaseName, "No");
				Sleep(2000);
				ReportGenerator.verifyNavigation(this.driver, "Microsoft Store", parentTest,testCaseName,"Yes");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("microsoft_logo", screen, parentTest, "Verify navigating back to home page", driver, testCaseName, "No");
				
				//Test Case 6 - Searching Windows update
				SikuliUtil.verifyObjectAndType("Searchbox", screen, parentTest, "Searching Windows update", driver, testCaseName, "No", "Windows update");
				Sleep(3000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(3000);
				ReportGenerator.verifyNavigation(this.driver, "Search results page", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("WindowsUpdate_heading", screen, parentTest, "Windows update searched successfully", driver, testCaseName, "Yes");
			
				//Test Case 7 & 8- Verify adding and removing product from cart if available
				
				siteURL="https://www.microsoftstore.com/store/msusa/en_US/pdp/Microsoft-Surface-Book--128GB-Intel-Core-i5/productID.5072642200/?vid=5072761400";
				driver.navigate().to(baseurl+siteURL);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Microsoft Surface Book",parentTest,testCaseName,"No");
				SikuliUtil.moveWheel(screen, 1, 15);
				Loggers.writeInfoLog("Scrolling done successfully....");
				Sleep(15000);
				if(SikuliUtil.isPresent(screen, "AddToCart_button")){
				SikuliUtil.verifyObjectAndClickOn("AddToCart_button", screen, parentTest, "Verify clicking on add to cart button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("NoThanks button", screen, parentTest, "verify clicking on no thanks links", driver, testCaseName, "No");
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("added_product_count", screen, parentTest,"Verify item count in cart is 1",driver,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("added_product_count", screen, parentTest, "verify clicking on cart button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Product_name", screen, parentTest,"Verify product added in cart",driver,testCaseName,"Yes");
				SikuliUtil.verifyObjectAndClickOn("remove_button", screen, parentTest, "verify clicking on remove button", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndClickOn("Continue_shopping_button", screen, parentTest, "verify clicking on continue shopping button", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Initial_cart", screen, parentTest,"Verify product removed from cart",driver,testCaseName,"Yes");
				
				Sleep(2000);
				}
				else{
					SikuliUtil.verifyObjectAndHighlight("OutOfStock_button", screen, parentTest,"Item is out of stock",driver,testCaseName,"Yes");
				}
				
				
				
				//Test Case 9 - Verify Logout
				SikuliUtil.verifyObjectAndClickOn("username", screen, parentTest, "Verify clicking username link", driver, testCaseName, "No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndClickOn("signout_link", screen, parentTest, "Verify clicking username link", driver, testCaseName, "No");
				SikuliUtil.verifyObjectAndHighlight("SignIn_link", screen, parentTest, "User logged out successfully", driver, testCaseName, "Yes");
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Microsoft TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
			
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Microsoft TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
			}
}