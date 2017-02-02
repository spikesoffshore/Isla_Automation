package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Amazon extends Base {
		
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Amazon");
	
//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
	public void navigateToURL(WebDriver driver){
			siteURL="https://www.amazon.com";
			Sleep(8000);
			driver.navigate().to(baseurl+siteURL);
	}
		
	public void Site_Signout(){
		pattern=new org.sikuli.script.Pattern(patternpath("/Your_Acc.PNG"));
		//ReportGenerator.verifyPatternandLog(screen, pattern, "Your Account Menu",testCaseName);
		r=screen.exists(pattern);
		r.hover();
		Sleep(5000);
						
		pattern1=new org.sikuli.script.Pattern(patternpath("/Sign_Out.PNG"));
		r=screen.exists(pattern1);
		r.highlight(2);
		r.click();
		Sleep(8000);

	}
	
	//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Doraemon");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Amazon";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(15000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecution(this.driver);
			
			//Home page verification based on the title
			ReportGenerator.verifyNavigation(this.driver, "Amazon", parentTest,testCaseName,"Yes");
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Verify Amazon favicon",this.driver,testCaseName,"Yes");
			
			//Localization based on connected server
			if(SikuliUtil.isPresent(screen, "Amazon_USBtn"))
			{
				SikuliUtil.verifyObjectAndClickOn("Amazon_USBtn", screen, parentTest, "Click Stay on Amazon.com", this.driver, testCaseName, "No");
			}
			
					
			//Is user already logged in 
			SikuliUtil.verifyObjectAndClickOn("SignIn", screen, parentTest, "Verify if user already logged in", this.driver, testCaseName, "Yes");
			Sleep(8000);
			
			//Navigation and Favicon verification
			ReportGenerator.verifyNavigation(this.driver, "Amazon Sign In", parentTest,testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Verify Amazon favicon",this.driver,testCaseName,"No");
			
			//Verify and Click Forgot Your Password
			SikuliUtil.verifyObjectAndClickOn("Sign_Forgot", screen, parentTest, "Click Forgot Password Link", this.driver, testCaseName, "Yes");
			Sleep(5000);
			
			ReportGenerator.verifyNavigation(this.driver, "Password", parentTest,testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Verify Forgot favicon",this.driver,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndType("Sign_Email", screen, parentTest, "Enter Userid for Forgot Password", this.driver, testCaseName, "No", "spikesqa@gmail.com");		
			
			// --Back button
			SikuliUtil.comboKeyPress(robot, KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
			Sleep(5000);
			
			Loggers.writeInfoLog("Keypress event related to last page(Alt+Left) navigation to Amazon Sign in page done successfully....continuing test");
			
			//Navigation and Favicon verification
			ReportGenerator.verifyNavigation(this.driver, "Amazon Sign In", parentTest,testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Verify Amazon favicon",this.driver,testCaseName,"No");
			
			//User login
			SikuliUtil.verifyObjectAndType("Sign_Email", screen, parentTest, "Enter user email id", this.driver, testCaseName, "No", "spikesqa@gmail.com");
			SikuliUtil.verifyObjectAndType("Sign_Password", screen, parentTest, "Enter user email id", this.driver, testCaseName, "No", "QAqa4321!");
			SikuliUtil.verifyObjectAndClickOn("Sign_Btn", screen, parentTest, "Click Sign in button", this.driver, testCaseName, "No");			
			Sleep(8000);
			
			navigateToURL(this.driver);
			
			//User login verification
			ReportGenerator.verifyNavigation(this.driver, "Amazon", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("LoggedinUserName", screen, parentTest, "Verify user log-in functionality", this.driver, testCaseName, "Yes");
			
			//Desired item entry - Learning mats under Baby category
			SikuliUtil.verifyObjectAndClickOn("Search_Menu", screen, parentTest, "Select Baby as category", this.driver, testCaseName, "No");
			
			for(i=1;i<9;i++){
				SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
				}
			
			SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
			Sleep(5000);
			
			SikuliUtil.verifyObjectAndType("SearchBar", screen, parentTest, "Enter Learning Mats in Search bar", this.driver, testCaseName, "No", "Learning Mats");
			SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					
			Sleep(15000);
			
			ReportGenerator.verifyNavigation(this.driver, "Baby", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Category selection and item entry",this.driver,testCaseName,"Yes");
						
			//Hard Coded item URL and navigation to same
			imgUrl=baseurl+"https://www.amazon.com/Kiddie-Play-Learning-Musical-Animal/dp/B01M5GWOW5/ref=sr_1_1_s_it?s=baby-products&ie=UTF8&qid=1479120455&sr=1-1&keywords=Learning+Mats";
			driver.navigate().to(imgUrl);
			
			Sleep(25000);
			
			ReportGenerator.verifyNavigation(this.driver, "Baby", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Verify Amazon favicon",this.driver,testCaseName,"No");
			Sleep(5000);
			
			//Product page load
			SikuliUtil.verifyObjectAndHighlight("Piano", screen, parentTest,"Verify Piano image",this.driver,testCaseName,"Yes");
			
			//Product addition in cart
			SikuliUtil.verifyObjectAndClickOn("Add_Cart", screen, parentTest, "Adding product in cart",this.driver, testCaseName, "No");			
			Sleep(8000);
			
			//Product addition in cart verification
			ReportGenerator.verifyNavigation(this.driver, "Shopping", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Product addition in cart",this.driver,testCaseName,"Yes");
			Sleep(5000);	
			
			//Click Cart
			SikuliUtil.verifyObjectAndClickOn("Btn_Cart", screen, parentTest, "Click Cart", this.driver, testCaseName, "No");
			Sleep(8000);
			
			//Navigation to Cart
			ReportGenerator.verifyNavigation(this.driver, "Shopping", parentTest,testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Navigation to cart",this.driver,testCaseName,"Yes");
			
			//Delete Cart
			SikuliUtil.verifyObjectAndClickOn("Delete_from_Cart", screen, parentTest, "Delete added product from Cart", this.driver, testCaseName, "No");
			Sleep(8000);
			
			//Verify Successful deletion
			ReportGenerator.verifyNavigation(this.driver, "Shopping", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Product delete from Cart",this.driver,testCaseName,"Yes");
			
			SikuliUtil.verifyObjectAndHighlight("Succesful_Deletion", screen, parentTest, "Product deletion", this.driver, testCaseName, "Yes");
			Sleep(8000);
			
			SikuliUtil.moveWheel(screen, 1, 15);
			//Amazon Site Sign out
			Site_Signout();
				
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The Amazon TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
				
				//Amazon Site Sign out
				Site_Signout();
				
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Amazon TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					//quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}
