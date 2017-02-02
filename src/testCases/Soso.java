package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Soso extends Base {
	
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing soso");

//Function to navigate to the SiteURL: Specific to site ; will be written in every test class
public void navigateToURL(WebDriver driver){
		siteURL="https://www.sogou.com/?rfrom=soso";
		Sleep(8000);
		driver.navigate().to(baseurl+siteURL);
}

//Main test method to test the WebSite
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
		ReportGenerator.assignAuthor(parentTest,"Thakur");
		
		//Driver instantiate, Spikes login and folder path setup to Amazon
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Soso";
		Sleep(5000);
		
		//navigating to the site URL
		navigateToURL(this.driver);
		
		Sleep(10000);
		
		try{
			
			// Starting test.. 
			Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("soso_favicon", screen, parentTest,"soso favicon verification",this.driver,testCaseName,"Yes");
			
			//Footer verification
			SikuliUtil.verifyObjectAndHighlight("soso_footer", screen, parentTest, "soso home page footer verification", this.driver, testCaseName, "Yes");
			
			//Searching results for software testing
			SikuliUtil.verifyObjectAndPaste("soss_homeSearch", screen, parentTest, "Search for software testing webpages", this.driver, testCaseName, "No", "软件测试");
			SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
			Sleep(5000);
			
			//Search result verification
			SikuliUtil.verifyObjectAndHighlight("soso_searchResultVerification", screen, parentTest, "Search result page verification", this.driver, testCaseName, "Yes");
			
			//Click login link - 登录
			SikuliUtil.verifyObjectAndClickOn("soso_searchResultPageLogin", screen, parentTest, "Click login", this.driver, testCaseName, "No");
			Sleep(4000);
			
			//Login page verification
			SikuliUtil.verifyObjectAndHighlight("soso_loginLogoCheck", screen, parentTest, "Login logo verification", driver, testCaseName, "Yes");
			
			//Click Mobile account login link - 手机账号登录>>
			SikuliUtil.verifyObjectAndClickOn("soso_loginMobileAccountLogin", screen, parentTest, "Click Mobile account login link", this.driver, testCaseName, "No");
			Sleep(4000);
			
			//Mobile account login page verification
			SikuliUtil.verifyObjectAndHighlight("soso_login_mobileAccount_popUpLogo", screen, parentTest, "Mobile account login popup logo verification", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndType("soso_login_mobileAccount_enterMobileNumber", screen, parentTest, "Enter mobile number", this.driver, testCaseName, "No", "915553453");
			SikuliUtil.keyPress(robot, KeyEvent.VK_TAB);
			
			SikuliUtil.verifyObjectAndHighlight("soso_login_mobileAccount_enterPassword", screen, parentTest, "Mobile number entry", this.driver, testCaseName, "Yes");
			
			//Browser back navigation using ALT+Left key
			SikuliUtil.comboKeyPress(robot, KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
			Sleep(5000);
			
			//Search result page verification post back navigation
			SikuliUtil.verifyObjectAndHighlight("soso_searchResultVerification", screen, parentTest, "Search result page verification post ALT+Left", this.driver, testCaseName, "Yes");
			SikuliUtil.verifyObjectAndClickOn("soso_SearchResultClick", screen, parentTest, "Randon click on screen", this.driver, testCaseName, "No");
			
			//Key end press and footer verification
			SikuliUtil.keyPress(robot, KeyEvent.VK_END);
			Sleep(8000);
			SikuliUtil.verifyObjectAndHighlight("Footer", screen, parentTest, "Verify footer", this.driver, testCaseName, "Yes");
						
			//Home page navigation
			SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
			Sleep(4000);
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("soso_favicon", screen, parentTest,"soso favicon verification",this.driver,testCaseName,"No");
						
			//Home page verification
			SikuliUtil.verifyObjectAndHighlight("soso_searchResultOptions", screen, parentTest, "soso logo with search options verification", this.driver, testCaseName, "Yes");
			
			//Translate in English- (英文)
			if(SikuliUtil.isPresent(screen, "soso_searchResultOptionsEnglishFromIndiaAppliance")){
				SikuliUtil.verifyObjectAndClickOn("soso_searchResultOptionsEnglishFromIndiaAppliance", screen, parentTest, "Click English for translation", this.driver, testCaseName, "No");
			}
			else{
				SikuliUtil.verifyObjectAndClickOn("soso_searchResultOptionsEnglish", screen, parentTest, "Click English for translation", this.driver, testCaseName, "No");
			}
			
			Sleep(5000);
			
			//English translated page verification
			SikuliUtil.verifyObjectAndHighlight("soso_englishTranslationPageVerification", screen, parentTest, "Software Testing- english translated search result page verification", this.driver, testCaseName, "Yes");
			
			//Mouse rightclick
			SikuliUtil.mouseRightClick("soso_englishTranslationPageVerification", screen);
			Sleep(300);
			
			//Back option selection
			SikuliUtil.keyPress(robot, KeyEvent.VK_DOWN);
			SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
			
			Sleep(3000);
			
			//Home page verification - Chinese language again
			SikuliUtil.verifyObjectAndHighlight("soso_searchResultOptions", screen, parentTest, "soso logo with search options verification post mouse right click", this.driver, testCaseName, "Yes");
			
			//New options 新闻 selection
			SikuliUtil.verifyObjectAndClickOn("soso_searchResultOptionsNews", screen, parentTest, "Click News", this.driver, testCaseName, "No");
			Sleep(5000);
			
			//Favicon verification
			SikuliUtil.verifyObjectAndHighlight("soso_favicon", screen, parentTest,"soso favicon verification",this.driver,testCaseName,"No");
			
			//News page load verification- -找到相关新闻约
			SikuliUtil.verifyObjectAndHighlight("soso_news_Article", screen, parentTest, "Search results for news article" , this.driver, testCaseName, "Yes");
			
			//Final Site Run status
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The soso TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
					
			}catch(Exception e){
						
				//In case of failure, mention the same in logs and Report
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
				System.out.println(e);
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The soso TestCase Failed,Please see logs and error screenshots", this.driver);
			}
				finally{
					quitDriver(this.driver);
					path=currentSitePath;
					ReportGenerator.flushReportToDisk(parentTest);
				}
	}

}
