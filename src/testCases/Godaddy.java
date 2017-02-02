package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Godaddy extends Base{

	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Godaddy");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.godaddy.com";
			driver.navigate().to(baseurl+siteURL);
			}
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Godaddy";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//1	Verify Navigation to goddady.com
				ReportGenerator.verifyNavigation(this.driver, "GoDaddy", parentTest,testCaseName,"Yes");
				
				//2	Verify Godaddy favicon
				SikuliUtil.verifyObjectAndHighlight("Godaddy_Favicon", screen, parentTest, "Verifying Godaddy Favicon", driver, testCaseName, "Yes");
				
				//3	Search Domain Availibility
				//3-a	Click inside Search box
				SikuliUtil.verifyObjectAndClickOn("Godaddy_Search_Domain", screen, parentTest, "Clicking inside the Serch Box on Home Page", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//3-b	Enter the domain name to be searched
				SikuliUtil.typeScreen(screen, "www.spikesqa.com"+Key.ENTER);
				
				Sleep(4000);
				
				//3-c	Verify Domain Availibility
				SikuliUtil.verifyObjectAndHighlight("Godaddy_Domain_Available", screen, parentTest,"Verifying Domain Availability", driver, testCaseName, "Yes");
				
				//4	Verifying Purchase of Domain and Login
				//4-a	Click on Continue to Cart
				SikuliUtil.verifyObjectAndClickOn("Godaddy_Continue_To_Cart", screen, parentTest, "Adding the domain to the Cart", driver, testCaseName, "No");
				
				Sleep(4000);
				
				//4-b	Click on Scroll Down
				SikuliUtil.verifyObjectAndClickOn("Godaddy_Scroll_Down", screen, parentTest, "Scrol Down to the Cart", driver, testCaseName, "No");
				
				Sleep(3000);
				//4-c	Click on Continue 
				SikuliUtil.verifyObjectAndClickOn("Godaddy_Cart_Continue", screen, parentTest, "Finalizing cart", driver, testCaseName, "No");
				
				Sleep(4000);
				
				
				//4-d	Click on Proceed To Checkout
				SikuliUtil.verifyObjectAndClickOn("Godaddy_Proceed_To_Checkout", screen, parentTest, "Clicking on Proceed to checkout", driver, testCaseName, "No");
				
				Sleep(5000);
				
				//4-e	Verify Already logged in
				if(!(SikuliUtil.isPresent(screen, "Godaddy_Already_Login"))){
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
				}
				
				Sleep(2000);
				//4-f	Enter password
				SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				
				Sleep(3000);
				
				//4-g	Verify  Successful Login
				SikuliUtil.verifyObjectAndHighlight("Godaddy_Billing_Information", screen, parentTest, "Verifying Successfull Login", driver, testCaseName, "Yes");
				
				//4-h	Verify Billing Information
				SikuliUtil.verifyObjectAndHighlight("Godaddy_Billing_Information", screen, parentTest, "Verifying Successfull Billing Info", driver, testCaseName, "Yes");
				
				Sleep(2000);
				//5	Verify empty cart 
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				
				Sleep(2000);
				
				//5-a	Click on Go Back to Cart
				SikuliUtil.verifyObjectAndClickOn("Godaddy_Back_To_Cart", screen, parentTest, "Verifying Navigation to Cart", driver, testCaseName, "No");
				
				//5-b	Click on Empty Cart button
				SikuliUtil.verifyObjectAndClickOn("Godaddy_Empty_Cart", screen, parentTest, "Removing items from cart", driver, testCaseName, "No");
				
				Sleep(3000);
				
				//5-c	Verify the cart is empty				
				SikuliUtil.verifyObjectAndHighlight("Godaddy_Cart_Empty", screen, parentTest, "Verifying Empty Cart functionality", driver, testCaseName, "Yes");
				
				//6	Verify Signout functionality
				//6-a	Click on Profile Icon
				SikuliUtil.verifyObjectAndClickOn("Godaddy_Profile_Icon", screen, parentTest, "Clicking on Profile Icon", driver, testCaseName, "No");
				
				Sleep(1000);
				
				//6-b	Click on Signout
				SikuliUtil.verifyObjectAndClickOn("Godaddy_Logout", screen, parentTest, "Clicking on Logout", driver, testCaseName, "No");
				
				//6-c	Verify Signout Landing
				SikuliUtil.verifyObjectAndHighlight("Godaddy_SignIn", screen, parentTest, "Verifying Logout on Godaddy", driver, testCaseName, "Yes");
				
			}catch(Exception e){
				
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Godaddy TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			
			}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}	
		}
	
}
