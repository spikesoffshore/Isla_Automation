package testCases;

	import java.awt.event.KeyEvent;
	import java.io.IOException;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.Test;
	import com.relevantcodes.extentreports.ExtentTest;
	import utils.Loggers;
	import utils.ReportGenerator;
	import utils.SikuliUtil;

	public class Avito extends Base {
		
			private WebDriver driver;
			private String currentSitePath;
			private String testCaseName=getClass().getName().substring(10); 
			ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Avito");
				
				public void navigateToURL(WebDriver driver){
					siteURL="https://www.avito.ru";
					driver.navigate().to(baseurl+siteURL);
					}
				@Test	
				public void executeScript() throws IOException {
					ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/Avito";
				
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					// Starting test.. 
					Loggers.startCurrentTestCaseExecutionOtherThanUFT8(testCaseName);
					
					//Test Case 1 - Verify navigating to Avito
					ReportGenerator.verifyNavigation(this.driver, "Avito", parentTest,testCaseName,"Yes");
			
					//Test case 2 - Verify navigating to Property tab
					SikuliUtil.verifyObjectAndClickOn("property_tab", screen, parentTest, "Verify navigating Property tab", driver, testCaseName, "Yes");
					Sleep(3000);
					SikuliUtil.verifyObjectAndHighlight("property_word", screen, parentTest, "Verify Property tab navigated successfully", driver, testCaseName, "No");
					
					
					//Test case 3 - Verify All tab is open By default
					SikuliUtil.moveWheel(screen, 1, 20);
					Sleep(10000);
					SikuliUtil.verifyObjectAndHighlight("all_tab", screen, parentTest, "Verify All tab is open By default", driver, testCaseName, "Yes");
					SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
					Sleep(5000);
					
					//Test case 4 - Verify checking and unchecking Search by Title checkbox
					SikuliUtil.verifyObjectAndClickOn("SearchByTitle_checkbox", screen, parentTest, "Verify checking Search By titile checkbox", driver, testCaseName, "No");
					Sleep(2000);
					SikuliUtil.verifyObjectAndHighlight("SearchByTitle_checkboxSelected", screen, parentTest, "Verify Search By titile checked", driver, testCaseName, "No");
					SikuliUtil.verifyObjectAndClickOn("SearchByTitle_checkboxSelected", screen, parentTest, "Verify unchecking Search By titile checkbox", driver, testCaseName, "No");
					Sleep(2000);
					SikuliUtil.verifyObjectAndHighlight("SearchByTitle_checkbox", screen, parentTest, "Search By Title checked and Unchecked", driver, testCaseName, "Yes");
					
					//Test case 5 - Verify Searching 2-к Apartments
					SikuliUtil.verifyObjectAndClickOn("Searchbox", screen, parentTest, "Verify searching 2-к Appartments ", driver, testCaseName, "Yes");
					Sleep(2000);
					screen.paste("2-к квартира");
					Sleep(3000);	
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					Sleep(3000);
					
					SikuliUtil.moveWheel(screen, 1, 35);
					Sleep(15000);
					
					//Test case 6 - Verify Navigating detail page of 2-к квартира result
					if(SikuliUtil.isPresent(screen, "2-k_word")){
						SikuliUtil.verifyObjectAndClickOn("2-k_word", screen, parentTest, "Verify Navigating to 2-к квартира detail page", driver, testCaseName, "No");
						Sleep(4000);
						}
						else{
							SikuliUtil.moveWheel(screen, 1, 15);
							Sleep(10000);
							SikuliUtil.verifyObjectAndClickOn("2-k_word", screen, parentTest, "Verify Navigating to 2-к квартира detail page", driver, testCaseName, "No");
							Sleep(4000);
						}
						
						SikuliUtil.verifyObjectAndHighlight("2-k_title", screen, parentTest, "Verify navigation to 2-к квартира detail page", driver, testCaseName, "Yes");
						SikuliUtil.moveWheel(screen, 1, 15);
						Sleep(10000);
					
					SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
					Sleep(5000);
					
					
					//Test case 7 - Verify navigating home page clicking logo
					SikuliUtil.verifyObjectAndClickOn("Avito_logo", screen, parentTest, "Verify clicking on logo", driver, testCaseName, "No");
					Sleep(3000);
					SikuliUtil.verifyObjectAndHighlight("avito_homelogo", screen, parentTest, "Verify navigation to home page by clicking logo", driver, testCaseName, "Yes");
					
					//Test case 8 - Verify navigating to Auto tab
					SikuliUtil.verifyObjectAndClickOn("Auto_tab", screen, parentTest, "Verify navigating Auto tab", driver, testCaseName, "Yes");
					Sleep(3000);
					SikuliUtil.verifyObjectAndHighlight("transport_word", screen, parentTest, "Auot tab navigated successfully", driver, testCaseName, "No");
					
					//Test case 9 - Verify searching Honda accord
					SikuliUtil.verifyObjectAndClickOn("Searchbox", screen, parentTest, "Verify searching Honda Accord ", driver, testCaseName, "Yes");
					Sleep(2000);
					screen.paste("Honda");
					Sleep(3000);	
					SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
					Sleep(3000);
					ReportGenerator.verifyNavigation(this.driver, "Honda", parentTest,testCaseName,"No");
					SikuliUtil.moveWheel(screen, 1, 25);
					Sleep(15000);
					
					
				
					
				
					
					Sleep(4000);
					ReportGenerator.logStatusPass(parentTest, testCaseName, "The Avito TestCase is working as expected");
					Loggers.stopCurrentTestCaseExecution(testCaseName);
							
					}catch(Exception e){
						
				
						
						//In case of failure, mention the same in logs and Report
						Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
						System.out.println(e);
						ReportGenerator.logStatusFail(parentTest,testCaseName, "The Avito TestCase Failed,Please see logs and error screenshots", this.driver);
					}
						finally{
							quitDriver(this.driver);
							path=currentSitePath;
							ReportGenerator.flushReportToDisk(parentTest);
						}
		}

}			


