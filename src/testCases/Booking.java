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

public class Booking extends Base {

	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Booking.com");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.booking.com";
			driver.navigate().to(baseurl+siteURL);
			}
		
		
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Booking";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//1	Verify Navigation to booking.com
				ReportGenerator.verifyNavigation(this.driver, "Booking", parentTest,testCaseName,"Yes");
				
				//2	Verify Booking favicon
				SikuliUtil.verifyObjectAndHighlight("Booking_Favicon", screen, parentTest, "Verifying Booking Favicon", driver, testCaseName, "Yes");
				
				
				//3	Verify Signin 
				//3-a	Click on Signin
				SikuliUtil.verifyObjectAndClickOn("Booking_Sign_In", screen, parentTest, "Clicing on Signin", driver, testCaseName, "No");
				
				Sleep(5000);
				
				//3-b	Click inside Email Textbox
				SikuliUtil.verifyObjectAndClickOn("Booking_Email", screen, parentTest,"Click on Email Textbox" , driver, testCaseName, "No");
				
				
				
				//3-c	Enter username
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
				
				Sleep(2000);
				
				//3-d	Enter password
				SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				
				Sleep(5000);
				
				//3-e	Verify Successful landing
				SikuliUtil.verifyObjectAndHighlight("Booing_Home_Logo", screen, parentTest, "Verifying booking.com Sign In Functionality", driver, testCaseName, "Yes");
				
				//4	Verify navigation to existing bookings
				//4-a	Click on bookings
				SikuliUtil.verifyObjectAndClickOn("Booking_Bookings", screen, parentTest, "Clicking on My bookings", driver, testCaseName, "No");
				
				Sleep(3000);
				
				//4-b	Verify Landing to existing bookings
				SikuliUtil.verifyObjectAndHighlight("Booking_Bookings_Logo", screen, parentTest, "Verifying Browsing on Booking.com", driver, testCaseName, "Yes");
				
				//5	Make a Booking
				//5-a	Click on Booking home Logo
				SikuliUtil.verifyObjectAndClickOn("Booing_Home_Logo", screen, parentTest, "Navigating back to make bookings", driver, testCaseName, "No");
				
				Sleep(4000);
				
				//5-b	Click on Find Deals
				SikuliUtil.verifyObjectAndClickOn("Booking_Find_Deals", screen, parentTest, "Cliking on Find Deals", driver, testCaseName, "No");
				
				Sleep(8000);
				
				//5-c	Verify Booking deals
				SikuliUtil.verifyObjectAndHighlight("Booking_Deals", screen, parentTest, "Verifying Deals on Booking.com", driver, testCaseName, "Yes");
				
				//6	Search for a Destination booking
				//6-a	Click on Booking home logo
				SikuliUtil.verifyObjectAndClickOn("Booing_Home_Logo", screen, parentTest, "Navigating back to make bookings", driver, testCaseName, "No");
				
				Sleep(7000);
				
				//6-b	Search for Las Vegas
				SikuliUtil.typeScreen(screen, "Las vegas");
				
				//6-c	Select Las Vegas suggestion
				SikuliUtil.verifyObjectAndClickOn("Booking_Popular", screen, parentTest, "Selecting the Las Vegas Location", driver, testCaseName, "No");
				
				Sleep(2000);
				
				//6-d	Click on from date
				SikuliUtil.verifyObjectAndClickOn("Booking_From_Date", screen, parentTest, "Selecting From Date", driver, testCaseName, "No");
				
				//6-d	Click on Search
				SikuliUtil.verifyObjectAndClickOn("Booking_Search", screen, parentTest, "Searching for deals by clicking on Search", driver, testCaseName, "No");
				
				Sleep(8000);
				
				//6-e	Verify Search result
				SikuliUtil.verifyObjectAndHighlight("Booking_Search_Results", screen, parentTest, "Verifying Search On Booking.com", driver, testCaseName, "Yes");
				
				//7	View Deal from search result
				//7-a	Click on See Property
				SikuliUtil.verifyObjectAndClickOn("Booking_See", screen, parentTest, "Click on See to View first Search Result", driver, testCaseName, "No");
				
				Sleep(5000);
				//7-b	Click and verify Reserve
				SikuliUtil.verifyObjectAndHighlight("Booking_Reserve", screen, parentTest, "Verifying Reserve property", driver, testCaseName, "Yes");
				
				//7-c	Close Tab
				SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_W);
				
				Sleep(2000);
				
				//8	Verify logout
				//8-a	Click on profile icon
				SikuliUtil.verifyObjectAndClickOn("Booking_Profile_Icon", screen, parentTest, "Clicking on Profile Icon", driver, testCaseName, "No");
				
				//8-b	Click on Signout
				SikuliUtil.verifyObjectAndClickOn("Booking_Sign_Out", screen, parentTest, "Clicking on SignOut", driver, testCaseName, "No");
				
				Sleep(5000);
				
				//8-c	Verify Signout Landing
				SikuliUtil.verifyObjectAndHighlight("Booking_Sign_In", screen, parentTest, "Verifying Sign_Out functionality on Booking.com", driver, testCaseName, "Yes");
				
				
				
				
			}catch(Exception e){
				
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Booking.com TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			
			}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}	
		}
}
