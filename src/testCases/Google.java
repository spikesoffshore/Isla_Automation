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

public class Google extends Base {
	
	private WebDriver driver;
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Google");
	private String testCaseName=getClass().getName().substring(10); 
	
	//Function to navigate to Site url Specific to site ; will be written in every test class	
	public void navigateToURL(WebDriver driver){
			
		siteURL="https://www.google.com/";
		Sleep(5000);
		driver.navigate().to(baseurl+siteURL);
		}
		
	
	@Test	
	public void executeScript() throws IOException {
		
		// To assign author to report
				ReportGenerator.assignAuthor(this.parentTest,"Doraemon");
				
				//Driver instantiate, Spikes login and folder path setup for current script
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Google";
				Sleep(5000);
				navigateToURL(this.driver);
				
				Sleep(8000);
				
		try{
					// Starting test.. 
					Loggers.startCurrentTestCaseExecution(this.driver);
						
					//Home page verification based on the title
					ReportGenerator.verifyNavigation(this.driver, "Google", parentTest,testCaseName, "Yes");
								
					//Favicon verification
					SikuliUtil.verifyObjectAndHighlight("Google_Favicon", screen, parentTest,"Verify Google favicon",this.driver,testCaseName,"Yes");
					
					//To write in Google search box
					
					if(SikuliUtil.isPresent(screen, "Different_Google_SearchBox")){
            		
					SikuliUtil.verifyObjectAndType("Different_Google_SearchBox", screen, parentTest,"Google serach box", this.driver, testCaseName, "No", "cyberinc.com"+Key.ENTER) ;
					
					}else if(SikuliUtil.isPresent(screen, "Google_Searchbox")){
						
						SikuliUtil.verifyObjectAndType("Google_Searchbox", screen, parentTest,"Google serach box", this.driver, testCaseName, "No", "cyberinc.com"+Key.ENTER) ;
					
					}else{
						
						SikuliUtil.verifyObjectAndType("Right_Left_Google_SearchBox", screen, parentTest,"Google serach box", this.driver, testCaseName, "No", "cyberinc.com"+Key.ENTER) ;
					}
	            	
					Sleep(5000);
			
					//Navigation and Favicon verification
					ReportGenerator.verifyNavigation(this.driver, "cyberinc.com", parentTest,testCaseName, "Yes");
					SikuliUtil.verifyObjectAndHighlight("Google_Favicon", screen, parentTest,"Verify Google favicon",this.driver,testCaseName,"No");
					
					//Verify Google options
					SikuliUtil.verifyObjectAndHighlight("GoogleOptions", screen, parentTest, "Google options", this.driver, testCaseName, "Yes");
					
					//Click Isla Link
					SikuliUtil.verifyObjectAndClickOn("IslaSite", screen, parentTest, "Cyberinc.com site check", this.driver, testCaseName, "No");
					
					Sleep(6000);
					
					//Navigation and Favicon verification
					ReportGenerator.verifyNavigation(this.driver, "Cyberinc", parentTest,testCaseName, "Yes");
					SikuliUtil.verifyObjectAndHighlight("CyberInc_Favicon", screen, parentTest,"Verify Cyberinc favicon",this.driver,testCaseName,"Yes");
					
					// Navigation to Isla 
					SikuliUtil.verifyObjectAndHighlight("CyberSecurity", screen, parentTest, "Verify Cyber Security tab", this.driver, testCaseName, "No");
					Sleep(2000);
					SikuliUtil.verifyObjectAndClickOn("IslaAppliance", screen, parentTest, "Click Isla Appliance under Cyber Security", this.driver, testCaseName, "Yes");
					
					Sleep(3000);
					// Navigation and Favicon verification
					ReportGenerator.verifyNavigation(this.driver, "Isla", parentTest,testCaseName, "Yes");
					SikuliUtil.verifyObjectAndHighlight("CyberInc_Favicon", screen, parentTest,"Verify Cyberinc favicon",this.driver,testCaseName,"No");
					
					//Isla appliance image zoom
					SikuliUtil.verifyObjectAndHighlight("Isla_Image", screen, parentTest,"Verify Cyberinc favicon",this.driver,testCaseName,"No");
					SikuliUtil.screenClick(screen);
					Sleep(1000);
					SikuliUtil.verifyObjectAndHighlight("Isla_Image_Zoom_text", screen, parentTest,"Verify Isla appliance zoomed image",this.driver,testCaseName,"Yes");
													
					//Back to Isla home page
					SikuliUtil.keyPress(robot, KeyEvent.VK_ESCAPE);
					Sleep(2000);
					SikuliUtil.verifyObjectAndHighlight("Isla_Image", screen, parentTest, "Verify navigation back to Isla page", this.driver, testCaseName, "Yes");
																
					//End key press
					SikuliUtil.keyPress(robot, KeyEvent.VK_END);
					Sleep(5000);
					SikuliUtil.verifyObjectAndClickOn("Home_Support", screen, parentTest, "Click Support link after END keypress", this.driver, testCaseName, "Yes");
					
					//Verify Navigation to Support page
					ReportGenerator.verifyNavigation(this.driver, "Support", parentTest,testCaseName, "Yes");
					SikuliUtil.verifyObjectAndHighlight("CyberInc_Favicon", screen, parentTest,"Verify Cyberinc favicon",this.driver,testCaseName,"No");
					
					//Going back to Google search result page 
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
					Sleep(3000);
					
					//First back check
					ReportGenerator.verifyNavigation(this.driver, "Isla", parentTest,testCaseName, "No");
					SikuliUtil.verifyObjectAndHighlight("CyberInc_Favicon", screen, parentTest,"Verify Cyberinc favicon post ALT+Left",this.driver,testCaseName,"No");
					
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
					Sleep(3000);
					
					//Second back check
					ReportGenerator.verifyNavigation(this.driver, "Cyberinc", parentTest,testCaseName, "No");
					SikuliUtil.verifyObjectAndHighlight("CyberInc_Favicon", screen, parentTest,"Verify Cyberinc favicon post second ALT+Left",this.driver,testCaseName,"No");
					
					SikuliUtil.comboKeyPress(robot, KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
					Sleep(3000);
					
					//Final back check
					ReportGenerator.verifyNavigation(this.driver, "cyberinc.com", parentTest,testCaseName, "Yes");
					SikuliUtil.verifyObjectAndHighlight("Google_Favicon", screen, parentTest,"Verify Google favicon( back to google search page)",this.driver,testCaseName,"Yes");
					
					//Google Options - Image click
					SikuliUtil.verifyObjectAndClickOn("GoogleOptions_Image", screen, parentTest, "Click Image link", driver, testCaseName, "Yes");
					Sleep(3000);
					
					//Verify Google Image page verification
					ReportGenerator.verifyNavigation(this.driver, "Search", parentTest,testCaseName, "Yes");
					SikuliUtil.verifyObjectAndHighlight("Google_Favicon", screen, parentTest,"Verify Google favicon for Google Image page",this.driver,testCaseName,"No");
					
					//Navigate to hardcoded url
					String Url =baseurl+"https://www.google.co.in/search?q=cyberinc.com&biw=1366&bih=638&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjM9MqC9YfRAhXHNpQKHVZ3AYgQ_AUICCgD&dpr=1&gws_rd=cr&ei=D3NzWLbBEci00gTsxJOYDg#gws_rd=cr&imgrc=LIVBZMPZ9HBbSM%3A";
					driver.navigate().to(Url);
					Sleep(7000);
					
					//Click View Image button
					SikuliUtil.verifyObjectAndClickOn("ViewImage", screen, parentTest, "View image button click", this.driver, testCaseName, "Yes");
					Sleep(7000);
					
					//Bookmark addition
					if(flag==1){
						
						SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_D);			
						}
						else{
							SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_D);				
						}
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					
					SikuliUtil.verifyObjectAndClickOn("BookMarkAdded", screen, parentTest, "Verify bookmark added", this.driver, testCaseName, "Yes");
					
					//Bookmark remove
						if(flag==1){
						
						SikuliUtil.comboKeyPress(robot, KeyEvent.VK_META, KeyEvent.VK_D);			
						}
						else{
							SikuliUtil.comboKeyPress(robot, KeyEvent.VK_CONTROL, KeyEvent.VK_D);				
						}
						Sleep(2000);
						SikuliUtil.keyPress(robot, KeyEvent.VK_TAB);
						SikuliUtil.keyPress(robot, KeyEvent.VK_TAB);
						SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
						Sleep(2000);
						SikuliUtil.verifyObjectAndHighlight("BookMarkRemovedStar", screen, parentTest, "Bookmark removed successfully", this.driver, testCaseName, "Yes");
										
					//Final Site Run status
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The Google TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
						
				}catch(Exception e){
					
					//In case of failure, mention the same in logs and Report
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Google TestCase Failed,Please see logs and error screenshots", this.driver);
				}
					finally{
						quitDriver(this.driver);
						path=currentSitePath;
						ReportGenerator.flushReportToDisk(parentTest);
					}
				
		}
}
