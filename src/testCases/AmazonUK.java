package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class AmazonUK extends Base {
		
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Amazon");
	
//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
	public void navigateToURL(WebDriver driver){
			siteURL="https://www.amazon.co.uk";
			Sleep(8000);
			driver.navigate().to(baseurl+siteURL);
	}
		
	public void Site_Signout(){
		
		SikuliUtil.verifyObjectAndHighlight("Your_Acc", screen, parentTest, "Verify clicking username button", driver, testCaseName, "No");
		SikuliUtil.verifyObjectAndClickOn("Sign_Out", screen, parentTest, "Verify clicking signout link", driver, testCaseName, "No");
	
		SikuliUtil.moveWheel(screen, 1, 10);
		Sleep(7500);
		SikuliUtil.verifyObjectAndHighlight("Sign_Btn", screen, parentTest, "User Signed Out successfully", driver, testCaseName, "Yes");
	
		
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
		path=path+"\\AmazonUK";
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
			
			//Is user not logged in 
			SikuliUtil.verifyObjectAndClickOn("SignIn", screen, parentTest, "Verify if user already logged in", this.driver, testCaseName, "Yes");
			Sleep(8000);
			
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
			
			Sleep(3000);
			SikuliUtil.verifyObjectAndClickOn("baby_category", screen, parentTest, "Select Baby as category", this.driver, testCaseName, "No");
			Sleep(5000);
			
			SikuliUtil.verifyObjectAndType("SearchBar", screen, parentTest, "Enter Learning Mats in Search bar", this.driver, testCaseName, "No", "Learning Mats");
			Sleep(3000);
			SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					
			Sleep(15000);
			
			ReportGenerator.verifyNavigation(this.driver, "Baby", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Category selection and item entry",this.driver,testCaseName,"Yes");
						
			//Hard Coded item URL and navigation to same
			imgUrl=baseurl+"https://www.amazon.co.uk/Motorola-Moto-SIM-Free-Smartphone-Single/dp/B01GZZK95O/ref=sr_1_3?ie=UTF8&qid=1484566069&sr=8-3&keywords=moto";
			driver.navigate().to(imgUrl);
			
			Sleep(25000);
			
			ReportGenerator.verifyNavigation(this.driver, "Moto G4 Plus", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Verify Amazon favicon",this.driver,testCaseName,"No");
			Sleep(5000);
			
			//Product page load
			
			
			SikuliUtil.verifyObjectAndHighlight("MotoGPlus", screen, parentTest,"Verify Moto G Plus image",this.driver,testCaseName,"Yes");
			
			
			//Verify adding product in cart
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("Add_Basket", screen, parentTest, "Adding product in cart",this.driver, testCaseName, "Yes");			
			Sleep(8000);
		
			//Navigation to Cart
			ReportGenerator.verifyNavigation(this.driver, "Basket", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"verify favicon",this.driver,testCaseName,"No");
			Sleep(5000);	
			
			// Verify product added in cart
			SikuliUtil.verifyObjectAndClickOn("Btn_Cart", screen, parentTest, "Click Cart", this.driver, testCaseName, "No");
			Sleep(8000);
			
			
			ReportGenerator.verifyNavigation(this.driver, "Basket", parentTest,testCaseName, "No");
			SikuliUtil.verifyObjectAndHighlight("Product_Name", screen, parentTest,"Verify product added in cart",this.driver,testCaseName,"Yes");
			
			//Delete Cart
			SikuliUtil.verifyObjectAndClickOn("Delete_from_Cart", screen, parentTest, "Delete added product from Cart", this.driver, testCaseName, "No");
			Sleep(8000);
			
			//Verify Successful deletion
			ReportGenerator.verifyNavigation(this.driver, "Basket", parentTest, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Amazon_Favicon", screen, parentTest,"Product delete from Cart",this.driver,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("NoProduct_inBasket", screen, parentTest, "Product deleted from cart", this.driver, testCaseName, "Yes");
			
			
		
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
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}
