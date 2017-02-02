package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class AliExpress extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing AliExpress");
		
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.aliexpress.com";
			driver.navigate().to(baseurl+siteURL);
			}
		@Test	
		public void executeScript() throws IOException {
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/AliExpress";
		
		navigateToURL(this.driver);
		
		Sleep(25000);
		try{
			
			Loggers.startCurrentTestCaseExecution(this.driver);
		
			
			//Test case 1 - Navigation to AliExpress 
			
			ReportGenerator.verifyNavigation(this.driver, "AliExpress.com", parentTest,testCaseName,"Yes");
			SikuliUtil.verifyObjectAndHighlight("AliExpress_GuestLogin_CartValue", screen, parentTest,"Verify Initial Cart Value",driver,testCaseName,"No");		
			
			//Test Case 2 - Verify AliExpress favicon 
			SikuliUtil.verifyObjectAndHighlight("AliExpress_Favicon", screen, parentTest,"Verify AliExpress favicon",driver,testCaseName,"Yes");
			
			
			SikuliUtil.verifyObjectAndClickOn("AliExpressLogo", screen, parentTest,"Verify ALiExpress Home Logo",driver,testCaseName,"No");
			
			//Test Case 3 - Verify Scrolling on ALiExpress
			
			Sleep(5000);
			SikuliUtil.keyPress(robot, KeyEvent.VK_PAGE_DOWN);
			Sleep(4000);
			SikuliUtil.verifyObjectAndHighlight("PageUp_Plus_buttons", screen, parentTest,"Verify Scrolling on ALiExpress",driver,testCaseName,"Yes");
			
			SikuliUtil.verifyObjectAndClickOn("PageUp_button", screen, parentTest, "Verify Clicking on PageUp button", driver, testCaseName, "No");
			Sleep(5000);
			
			//TestCase 4 - Verify navigating to Dresses sub category page on AliExpress
			
			SikuliUtil.verifyObjectAndClickOn("Category_women's Clothing", screen, parentTest, "Verify nevigating to Women's Clothing Category page on AliExpress", driver, testCaseName, "No");
			Sleep(4000);
			ReportGenerator.verifyNavigation(this.driver, "Women's Clothing", parentTest,testCaseName,"Yes");
			Sleep(4000);
			SikuliUtil.verifyObjectAndClickOn("SubCategory_Dresses", screen, parentTest, "Verify navigating to Dresses sub category page on AliExpress", driver, testCaseName, "Yes");
			Sleep(20000);
			
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    ReportGenerator.verifyNavigation(this.driver, "Dresses", parentTest,testCaseName,"No");
			Sleep(5000);
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    Sleep(2000);
		    
		    //Test Case 5 - verify Sign In
		    
		    SikuliUtil.verifyObjectAndClickOn("SignIn", screen, parentTest, "Verify clicking on SignIn link", driver, testCaseName, "No");
		    Sleep(5000);
		    
		    if(!(SikuliUtil.isPresent(screen,"Login_Prefilled")))
		    {
		    	
		    SikuliUtil.verifyObjectAndClickOn("Login_ID", screen, parentTest, "Verify Men's Clothing Category page on AliExpress", driver, testCaseName, "No");
		    }
		    else {
		    	SikuliUtil.verifyObjectAndClickOn("Login_Prefilled", screen, parentTest, "Selecting Username Values", driver, testCaseName, "No");
		    	
		    	SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_A);
			    Sleep(1000);
			}
		    
		    SikuliUtil.typeScreen(screen,"spikesqa@gmail.com");
			Sleep(2000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
			Sleep(1000);
			SikuliUtil.typeScreen(screen,"QAqa4321");
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(7000);
			SikuliUtil.verifyObjectAndHighlight("AliExpress_Favicon", screen, parentTest,"Verify AliExpress favicon",driver,testCaseName,"No");
			Sleep(1000);
			SikuliUtil.verifyObjectAndHighlight("User_Name", screen, parentTest,"User logged in successfully",driver,testCaseName,"Yes");
			
			//Test case - 7 Verify product get added in cart
			Sleep(2000);
			siteURL="https://www.aliexpress.com/item/PARTAKER-M5-19-5-TOUCH-All-IN-ONE-PC-with-Intel-Ivy-bridge-BayTrail-D-optional/32701417352.html";
			driver.navigate().to(baseurl+siteURL);
			Sleep(4000);
			ReportGenerator.verifyNavigation(this.driver, "PARTAKER", parentTest,"PARTAKER M5 19.5 TOUCH All IN ONE PC product page on AliExpress navigation","No");
			SikuliUtil.verifyObjectAndClickOn("AliExpress_AddCart", screen, parentTest, "Verify clicking on add to cart button", driver, testCaseName, "No");
			SikuliUtil.verifyObjectAndClickOn("View_Shopping_Cart", screen, parentTest, "navigating to cart", driver, testCaseName, "No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("CartValue_havingItem", screen, parentTest,"Verify item count in cart",driver,testCaseName,"No");
			SikuliUtil.verifyObjectAndHighlight("ProductInCart", screen, parentTest,"Verify product get added in cart",driver,testCaseName,"Yes");
			
			//Test case - 7 Verify product get removed from cart
			SikuliUtil.verifyObjectAndClickOn("RemoveItemFromCart", screen, parentTest, "Verify clicking on remove button", driver, testCaseName, "No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("AliExpress_GuestLogin_CartValue", screen, parentTest,"Verify product get removed from cart",driver,testCaseName,"Yes");
			
			//Test case - 8 Verify Sign Out
			SikuliUtil.verifyObjectAndClickOn("User_Name", screen, parentTest, "Verify clicking on username button", driver, testCaseName, "No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("SignOut", screen, parentTest, "Verify clicking on Signout button", driver, testCaseName, "No");
			SikuliUtil.verifyObjectAndClickOn("Sign_out_link", screen, parentTest, "Verify clicking on Signout link", driver, testCaseName, "No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("SignIn", screen, parentTest,"User Signed out successfuly",driver,testCaseName,"Yes");
			
			Sleep(4000);
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The AliExpress TestCase is working as expected");
		
			Loggers.stopCurrentTestCaseExecution(testCaseName);
		}catch(Exception e){
			
			
			Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The AliExpress TestCase Failed,Please see logs and error screenshots", driver);
		}
		finally{
		quitDriver(this.driver);
		path=currentSitePath;
		ReportGenerator.flushReportToDisk(parentTest);
		}

}}
