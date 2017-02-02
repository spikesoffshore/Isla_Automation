package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.CommonUtil;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Yahoo extends Base {

public String S;
private WebDriver driver;
private String currentSitePath;
private String testCaseName=getClass().getName().substring(10); 
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Yahoo");
	
	public void navigateToURL(WebDriver driver){
		
	siteURL="https://www.yahoo.com";
	Sleep(8000);
	driver.navigate().to(baseurl+siteURL);
	}
	
	@Test	
	public void executeScript() throws IOException, FindFailed {
		
		ReportGenerator.assignAuthor(parentTest,"Doraemon");
		
		this.driver=driverIns();
		spikeLogin();
		currentSitePath=path;
		path=path+"/Yahoo";
		Sleep(5000);
		
		
		navigateToURL(this.driver);
		Sleep(25000);
		
		try{
			
			Loggers.startCurrentTestCaseExecution(this.driver);
			
			//TestCase#1-Verifying Navigation to home page
			ReportGenerator.verifyNavigation(this.driver, "Yahoo", parentTest,testCaseName,"Yes");
			
			//TestCase#2-Verifying Favicon 		
			SikuliUtil.verifyObjectAndHighlight("Yahoo_Favicon", screen, parentTest,"Verify Yahoo favicon",driver,testCaseName,"Yes");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("Yahoo_logo", screen, parentTest,"Yahoo Home Logo",driver,testCaseName,"No");
					
			//TestCase#3-Verifying Yahoo news page	
			Sleep(2000);
			r=screen.findText("News");
			r.highlight(2);
			r.hover();
			Sleep(3000);
			r.click();
			
			Sleep(8000);
			ReportGenerator.verifyNavigation(this.driver, "News", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("Yahoo_Favicon", screen, parentTest,"Verify Yahoo favicon",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("Yahoo_News", screen, parentTest,"Verify Yahoo News Page",driver,testCaseName,"Yes");
			Sleep(2000);			
		
			r1=screen.findText("News Home");
			r1.highlight(2);
			Loggers.writeInfoLog("Yahoo News page load verification is done successfully....continuing test");
			screen.wheel(1, 15);			
			Sleep(10000);
			Loggers.writeInfoLog("Wheel movement is done successfully....continuing test");
			
			//TestCase#3-Verifying Search functionality		
					
			screen.type("Shah Rukh Khan");
			Sleep(3000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(12000);
			ReportGenerator.verifyNavigation(this.driver, "Shah Rukh Khan", parentTest,testCaseName,"No");
			SikuliUtil.verifyObjectAndHighlight("Yahoo_Favicon", screen, parentTest,"Verify Yahoo favicon",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("SRK_News", screen, parentTest,"Verify Page load to searched text",driver,testCaseName,"Yes");
			Sleep(2000);	
			
			
			//TestCase#4-Verifying HomePage	navigation
			
			SikuliUtil.verifyObjectAndClickOn("Menu_Options", screen, parentTest, "Yahoo Menu option", driver, testCaseName, "No");
			
			Sleep(3000);
			SikuliUtil.verifyObjectAndClickOn("Home", screen, parentTest, "Home page navigation done successfully from yahoo menu options", driver, testCaseName, "Yes");
			
			Sleep(10000);
			//TestCase#5-Verifying Yahoo Finance page	
			SikuliUtil.verifyObjectAndHighlight("Yahoo_Favicon", screen, parentTest,"Verify Yahoo favicon",driver,testCaseName,"No");
						
			r=screen.findText("Finance");
			r.highlight(2);
			r.hover();
			Sleep(3000);
			r.click();
			Sleep(8000);
			ReportGenerator.verifyNavigation(this.driver, "Finance", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("Yahoo_Favicon", screen, parentTest,"Verify Yahoo favicon",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("Yahoo_Finance", screen, parentTest,"Verify Yahoo Finance Page",driver,testCaseName,"Yes");
			Sleep(2000);			
		
			r1=screen.findText("Finance Home");
			r1.highlight(2);
			Loggers.writeInfoLog("Navigated successfully to Yahoo Finance page....continuing test");	
			screen.wheel(1, 15);			
			Sleep(10000);
			Loggers.writeInfoLog("Wheel movement is done successfully....continuing test");
			
			//TestCase#6-Verifying Alt+Left Key press functionality
			
			SikuliUtil.comboKeyPress(robot,KeyEvent.VK_ALT,KeyEvent.VK_LEFT);
			
			
			Sleep(8000);
			ReportGenerator.verifyNavigation(this.driver, "Yahoo", parentTest,testCaseName,"No");
			
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("Yahoo_Favicon", screen, parentTest,"Alt+Left Key press functionality working fine on Yahoo for Home page redirection",driver,testCaseName,"Yes");
			Sleep(2000);
			//TestCase#7-Verifying Yahoo mail login functionality
			
			r=screen.findText("Mail");			
			r.highlight(2);
			r.hover();
			Sleep(3000);
			r.click();
			
			Sleep(8000);
			ReportGenerator.verifyNavigation(this.driver, "login", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("Yahoo_Favicon", screen, parentTest,"Verify Yahoo favicon",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("Yahoo_MailIcon", screen, parentTest,"Verify availability of Yahoo Mail Icon",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndClickOn("UserId", screen, parentTest, "Yahoo username field", driver, testCaseName, "No");
			Sleep(8000);
			
			screen.type("spikesqa");
			Sleep(5000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);	
			Sleep(5000);
			Loggers.writeInfoLog("Navigated Yahoo Password page Successfully....continuing test");	
			screen.type("password4321!");
			Sleep(5000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_ENTER);
			Sleep(8000);
			
			ReportGenerator.verifyNavigation(this.driver, "spikesqa", parentTest,testCaseName,"No");
		
			SikuliUtil.verifyObjectAndHighlight("Spikesqa_LoginIcon", screen, parentTest,"spikesqa login validation done",driver,testCaseName,"Yes");
			
			Sleep(3000);
			
			//TestCase#8-Verifying Sending Yahoo mail login functionality
			SikuliUtil.keyPress(robot,KeyEvent.VK_N);
			
			Sleep(4000);
			
			screen.type("spikesqa@yahoo.com");
			Sleep(3000);
			SikuliUtil.verifyObjectAndClickOn("SubjectMail", screen, parentTest, "Yahoo mail subject line click", driver, testCaseName, "No");
			Sleep(3000);
			S=CommonUtil.getCurrentTime();		
			screen.type(S);
			Sleep(6000);
			SikuliUtil.keyPress(robot,KeyEvent.VK_TAB);
			Sleep(6000);
			screen.type(S);
			Sleep(6000);
			SikuliUtil.verifyObjectAndClickOn("SendMail", screen, parentTest, "Send Mail Button clicked", driver, testCaseName, "No");
			Sleep(1000);
			SikuliUtil.verifyObjectAndHighlight("MailSent", screen, parentTest,"Mail Sent Successfully Validated",driver,testCaseName,"Yes");
			Sleep(3000);
			
			//TestCase#9-Verifying Signout Functionality
			SikuliUtil.verifyObjectAndHighlight("Spikesqa_LoginIcon", screen, parentTest,"spikesqa login validation done",driver,testCaseName,"No");
			SikuliUtil.verifyObjectAndClickOn("SignoutIcon", screen, parentTest, "Logout option link", driver, testCaseName, "No");
			Sleep(8000);
					
			ReportGenerator.verifyNavigation(this.driver, "Yahoo", parentTest,testCaseName,"No");
			
			SikuliUtil.verifyObjectAndHighlight("Yahoo_Favicon", screen, parentTest,"Verify Yahoo favicon",driver,testCaseName,"No");
			Sleep(2000);
			SikuliUtil.verifyObjectAndHighlight("Yahoo_logo", screen, parentTest,"User Logout Functionality working fine",driver,testCaseName,"Yes");
			Sleep(2000);
			
			
			
			
			ReportGenerator.logStatusPass(parentTest, testCaseName, "The Yahoo TestCase is working as expected");
			Loggers.stopCurrentTestCaseExecution(testCaseName);
		
			
		}catch(Exception e){
			
			System.out.println(e);
			
			Sleep(20000);
			pattern1=new org.sikuli.script.Pattern(patternpath("/Network.PNG"));
			reg=screen.exists(pattern1);
			reg.highlight(2);
			System.out.println("network failure issue");
						
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The Yahoo TestCase Failed,Please see logs and error screenshots", driver);
		}
			finally{
				path=currentSitePath;
				quitDriver(this.driver);
				ReportGenerator.flushReportToDisk(parentTest);
			}		
	}

}
