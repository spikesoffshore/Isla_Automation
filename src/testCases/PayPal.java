package testCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;

public class PayPal extends Base{
	
	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing PayPal");
	private String testCaseName=getClass().getName().substring(10); 
	
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
		
		siteURL="https://www.paypal.com";
		driver.navigate().to(baseurl+siteURL);
		}
	

		@Test	
		public void executeScript() throws IOException {
			
			// To assign author to report
			ReportGenerator.assignAuthor(this.parentTest,"Doraemon");
			
			// Driver instantiate, Spikes login and folder path setup for current script
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/PayPal";
			
			navigateToURL(this.driver);
			
			Sleep(15000);
			
			try{
				
				// Starting test.. 
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				//Home page verification based on the title
				ReportGenerator.verifyNavigation(this.driver, "Send Money, Pay Online or Set Up a Merchant Account - PayPal", parentTest,testCaseName, "Yes");
				
				//Favicon verification
				SikuliUtil.verifyObjectAndHighlight("PayPal_Favicon", screen, parentTest,"Verify PayPal favicon",this.driver,testCaseName,"Yes");
				
				//if connected to India Appliance, then need to first go to USA site
				if(SikuliUtil.isPresent(screen, "Individual"))
				{
					SikuliUtil.verifyObjectAndClickOn("Individual", screen, parentTest, "Click Individual", this.driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.keyPress(robot, KeyEvent.VK_END);
					Sleep(5000);
					SikuliUtil.verifyObjectAndClickOn("IndiaFlag", screen, parentTest, "Click Indian flag", this.driver, testCaseName, "No");
					Sleep(3000);
					
					//Location page verification based on the title
					ReportGenerator.verifyNavigation(this.driver, "All countries and markets - PayPal", parentTest,testCaseName, "Yes");
					SikuliUtil.moveWheel(screen, 1, 40);
					SikuliUtil.verifyObjectAndClickOn("USFlag", screen, parentTest, "Click US Flag", this.driver, testCaseName, "No");
					Sleep(3000);
				}
				
				
				//Click Personal
				SikuliUtil.verifyObjectAndClickOn("Personal", screen, parentTest, "Click Personal", this.driver, testCaseName, "No");
				Sleep(15000);
					
				//Click How to use PayPal
				SikuliUtil.verifyObjectAndClickOn("How_Use", screen, parentTest, "Click How to Use Paypal", this.driver, testCaseName, "No");
				Sleep(15000);
				
				//Verify navigation and favicon
				ReportGenerator.verifyNavigation(this.driver, "How to Use PayPal", parentTest,testCaseName, "Yes");
				SikuliUtil.verifyObjectAndHighlight("PayPal_Favicon", screen, parentTest,"Verify PayPal favicon",this.driver,testCaseName,"No");
			
				//Click Signup
				SikuliUtil.verifyObjectAndClickOn("SignUp", screen, parentTest, "Click SignUp", this.driver, testCaseName, "No");
				Sleep(15000);
				
				//Signup- page load
				SikuliUtil.verifyObjectAndHighlight("AccoutTypeChoose", screen, parentTest, "SignUp button click", this.driver, testCaseName, "Yes");
				
				//Personal account selection
				SikuliUtil.verifyObjectAndClickOn("PersonalAccountSignUp", screen, parentTest, "Click Sign Up- Personal account", this.driver, testCaseName, "No");
				
				//Personal signup-email and password entry
				SikuliUtil.screenFindTextandType(screen, "Your email", "test_spikes_security@gmail.com");
				Sleep(2000);
				SikuliUtil.screenFindTextandType(screen, "Create", "Welcome@12");
				Sleep(2000);
				
				//Personal signup-Confirm Password
				SikuliUtil.verifyObjectAndType("Confirm", screen, parentTest, "Set confirm Password", this.driver, testCaseName, "No", "Welcome@1");
								
				//Personal Signup-Confirm Password error
				SikuliUtil.verifyObjectAndType("ConfirmPassowrd_Error", screen, parentTest, "Reenter confrim password", this.driver, testCaseName, "No", "2");
				Sleep(4000);
				
				//Personal sign up-Next button
				SikuliUtil.verifyObjectAndClickOn("SignUp_Next", screen, parentTest, "Click Sign up Next", this.driver, testCaseName, "No");
				Sleep(8000);
				
				SikuliUtil.verifyObjectAndHighlight("PersonalAccountNextText", screen, parentTest, "Personal Signup initial details", this.driver, testCaseName, "Yes");
								
				for(i=0;i<2;i++){
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
					Sleep(5000);
				}
				
				
				//Business signup Step 1- Click Business signup button
				SikuliUtil.verifyObjectAndHighlight("Business", screen, parentTest, "Personal Sign up- Page rendering and browser back navigation using ALT+Left", this.driver, testCaseName, "Yes");
				SikuliUtil.verifyObjectAndClickOn("BusinessAccountSignUp", screen, parentTest, "Click Sign Up- Personal account", this.driver, testCaseName, "No");
				Sleep(2000);
				
				//Business signup Step2- Click 
				SikuliUtil.verifyObjectAndHighlight("Business_details", screen, parentTest, "Business Sign up button Click", this.driver, testCaseName, "Yes");
				
				//Page Down key press
				SikuliUtil.keyPress(robot, KeyEvent.VK_PAGE_DOWN);
				Sleep(4000);
				
				//Page Down key press verification
				SikuliUtil.verifyObjectAndHighlight("ContactDetails", screen, parentTest, "Page Down key press verification", this.driver, testCaseName, "Yes");
				
				//Mouse -Right Click event and Back option selected
				SikuliUtil.mouseRightClick("ContactDetails", screen);
				Sleep(2000);
				SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				
				Sleep(12000);   
				//Verification
				SikuliUtil.verifyObjectAndHighlight("Business", screen, parentTest, "Business Sign up- Page rendering and browser back navigation by selecting Right-Click Back option", this.driver, testCaseName, "Yes");
				
				//To change browser url using keyboard keys					
				if(flag==1){
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_L);
				}
				else{
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_L);
				}
				
				String str=baseurl+"https://www.paypal.com/signin?returnUri=https://www.paypal.com/myaccount/transfer&state=/request";
				System.out.println(str);
				SikuliUtil.typeScreen(screen, str);
				SikuliUtil.typeScreen(screen, Key.ENTER);
				Sleep(8000);
				
				SikuliUtil.verifyObjectAndHighlight("PayPal_Favicon", screen, parentTest,"Verify PayPal favicon after url change",this.driver,testCaseName,"Yes");
				
				//Verify navigation
				ReportGenerator.verifyNavigation(this.driver, "Log in to your PayPal", parentTest,testCaseName, "Yes");
				
				//PayPal logo check
				SikuliUtil.verifyObjectAndHighlight("PayPal_Logo", screen, parentTest, "PayPal logo check on Login page", this.driver, testCaseName, "Yes");
				
				//Final Site Run status
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The PayPal TestCase is working as expected");
				Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The PayPal TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
					//	quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
		}
}
