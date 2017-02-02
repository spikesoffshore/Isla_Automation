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

public class Alibaba extends Base {
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Alibaba");
		
		public void navigateToURL(WebDriver driver){
			siteURL="www.alibaba.com";
			driver.navigate().to(baseurl+siteURL);
			driver.manage().window().maximize();
			}
			
			@Test	
			public void executeScript() throws IOException {
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Alibaba";
			
			navigateToURL(this.driver);
			
			Sleep(25000);
						
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
			
				
				//TestCase#1-Verifying Navigation to home page
				ReportGenerator.verifyNavigation(this.driver,"Alibaba", parentTest,testCaseName,"Yes");
						
				//TestCase#2-Verifying Favicon 
				SikuliUtil.verifyObjectAndHighlight("Alibaba_favicon", screen, parentTest,"Verify Alibaba favicon",driver,testCaseName,"Yes");
				
				SikuliUtil.verifyObjectAndHighlight("AlibabaLogo", screen, parentTest,"Alibaba Home Logo",driver,testCaseName,"No");
								
				Sleep(3000);
				
				
				//TestCase#3-Verifying Health and Beauty Category page
				
				SikuliUtil.verifyObjectAndHighlight("Category", screen, parentTest, "Hovering Category page on Alibaba", driver, testCaseName, "No");
					
				Sleep(3000);
				SikuliUtil.verifyObjectAndClickOn("HealthCategory", screen, parentTest, "Health and Beauty Category page link clicked", driver, testCaseName, "No");
				Sleep(5000);
				ReportGenerator.verifyNavigation(this.driver, "Health", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Alibaba_favicon", screen, parentTest,"Health and Beauty Category page loaded on Alibaba successfully",driver,testCaseName,"Yes");
				
				Sleep(3000);
				screen.wheel(1, 15);			
				Sleep(4000);
				
				//TestCase#4-Verifying Alt+Left Key press functionality
				
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
				Sleep(4000);
				SikuliUtil.verifyObjectAndHighlight("Alibaba_favicon", screen, parentTest,"Verify Alibaba favicon",driver,testCaseName,"No");
				
				ReportGenerator.verifyNavigation(this.driver, "Alibaba", parentTest,testCaseName,"No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("AlibabaLogo", screen, parentTest,"Alt+Left Key press functionality working fine on Alibaba",driver,testCaseName,"Yes");
				
				//TestCase#5-Verifying Login functionality	
				
				SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest, "Profile button hovered ", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("SignInLink", screen, parentTest, "Sign in link clicked", driver, testCaseName, "No");
				
				Sleep(6000);
				/*SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(4000);	*/
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_CONTROL,KeyEvent.VK_A);
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_DELETE);
				Sleep(2000);
				SikuliUtil.typeScreen(screen,"spikesqa@gmail.com");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
				Sleep(2000);
				SikuliUtil.typeScreen(screen,"QAqa4321"+Key.ENTER );
						
				Sleep(7000);
				
				SikuliUtil.verifyObjectAndHighlight("Alibaba_favicon", screen, parentTest,"Verify Alibaba favicon",driver,testCaseName,"No");
				
				SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest, "Profile button hovered", driver, testCaseName, "No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("SpikesLoggedIn", screen, parentTest,"Alibaba user logged in Functionality",driver,testCaseName,"Yes");
				
				Sleep(2000);
				//TestCase#6-Verifying Search functionality	
				
				SikuliUtil.clickRight("Category", screen, parentTest, "Clicking search text box", driver, testCaseName, "No", 550);
				
				Sleep(4000);
				SikuliUtil.typeScreen(screen,"Xiaomi Redmi 3s Prime");
				Sleep(2000);
				SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
				Sleep(4000);
				ReportGenerator.verifyNavigation(this.driver, "Xiaomi Redmi 3s Prime", parentTest,testCaseName,"No");
				SikuliUtil.verifyObjectAndHighlight("Alibaba_favicon", screen, parentTest,"Page loaded to searched text on Alibaba successfully",driver,testCaseName,"Yes");
				Sleep(2000);
				screen.wheel(1, 15);			
				Sleep(4000);
								
					siteURL="www.alibaba.com/product-detail/Xiaomi-Redmi-Red-Mi-3S-Prime_60560906030.html";
				driver.navigate().to(baseurl+siteURL);
				Loggers.writeInfoLog("Navigated to Product Page");
				Sleep(6000);
				
				ReportGenerator.verifyNavigation(this.driver, "Xiaomi Redmi", parentTest,testCaseName,"No");
				Sleep(2000);
				SikuliUtil.verifyObjectAndHighlight("Alibaba_favicon", screen, parentTest,"Product page navigated successfully",driver,testCaseName,"No");
				Sleep(2000);
				
				
				//TestCase#7-Verifying AddToBag functionality
				
				SikuliUtil.verifyObjectAndClickOn("AddToBag", screen, parentTest, "Verify Add to bag Link on Alibaba Product page", driver, testCaseName, "No");
				
				Sleep(5000);
				SikuliUtil.verifyObjectAndClickOn("RemoveCheckBox", screen, parentTest, "Product added successfully to cart for logged in user", driver, testCaseName, "Yes");
				Sleep(2000);
				
				//TestCase#8-Verifying RemoveFrombag functionality
				
				SikuliUtil.verifyObjectAndClickOn("RemoveFrombag", screen, parentTest,"Remove link clicked for product on cart page",driver,testCaseName,"No");
				
				Sleep(3000);
				
				//TestCase#9-Verifying Empty Bag
				
				SikuliUtil.verifyObjectAndHighlight("NoItemInBag", screen, parentTest,"Deleted Item from Bag functionality",driver,testCaseName,"Yes");
				
				Sleep(2000);
				
				
				//TestCase#10-Verifying Right Click and Back Functionality
				pattern1=new org.sikuli.script.Pattern(patternpath("/NoItemInBag.PNG"));
				Sleep(2000);
				reg=screen.exists(pattern1);
				reg.rightClick();
				Sleep(3000);
				SikuliUtil.comboKeyPress(robot,KeyEvent.VK_DOWN,KeyEvent.VK_ENTER);
				
				Sleep(7000);
				
				ReportGenerator.verifyNavigation(this.driver, "Xiaomi Redmi 3s Prime", parentTest,testCaseName,"No");
					
				SikuliUtil.verifyObjectAndHighlight("Alibaba_favicon", screen, parentTest,"Right Click and Going to previous page functionality validated",driver,testCaseName,"Yes");
				Sleep(2000);
				
				//TestCase#11-Verifying Signout Functionality
				SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest, "Profile button clicked ", driver, testCaseName, "No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("Signout", screen, parentTest,"Alibaba user log out link clicked",driver,testCaseName,"No");
				
				Sleep(5000);
				SikuliUtil.verifyObjectAndHighlight("ProfileIcon", screen, parentTest, "Profile button clicked ", driver, testCaseName, "No");
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("SignInLink1", screen, parentTest, "Alibaba user sign out functionality working fine", driver, testCaseName, "Yes");
				
				
				Sleep(4000);
				ReportGenerator.logStatusPass(parentTest, testCaseName, "The Alibaba TestCase is working as expected");
			
				Loggers.stopCurrentTestCaseExecution(testCaseName);
				
			}catch(Exception e){
			
			
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				//ReportGenerator.logStatusFail(parentTest,testCaseName, "The Alibaba TestCase Failed,Please see logs and error screenshots", driver);
			}
			finally{
			path=currentSitePath;
			quitDriver(this.driver);
			ReportGenerator.flushReportToDisk(parentTest);
			}
		
			}}	