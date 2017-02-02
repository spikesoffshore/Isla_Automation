package testCases;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.DriverUtil;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Google_Domains extends Base {

	
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Multiple Google Domains");
	
	//Variables for only this test class
	public File file;
	public FileInputStream fis;
    public XSSFWorkbook wb;
    public XSSFSheet sh;
    
		public void navigateToURL(WebDriver driver){
			siteURL="https://www.google.co.jp";
			driver.navigate().to(baseurl+siteURL);
			}
		

			@Test	
			public void executeScript() throws IOException {
				
				ReportGenerator.assignAuthor(parentTest,"Doraemon");
				
				this.driver=driverIns();
				spikeLogin();
				currentSitePath=path;
				path=path+"/GoogleDomains";
				System.out.println(path);
				navigateToURL(this.driver);
				
				Sleep(25000);
				try{
					
					Loggers.startCurrentTestCaseExecution(this.driver);
					
					file= new File(path+"/GoogleDomains.xlsx");
					fis = new FileInputStream(file);
		            wb = new XSSFWorkbook(fis);
		            sh = wb.getSheet("Sheet1");
		            
		            for(int i=1;i<=sh.getLastRowNum();i++){
		            	
		            	DriverUtil.navigateToURL(driver,"https://"+getServer()+".spikes.eng/client.html#www."+sh.getRow(i).getCell(0).getStringCellValue());
		            	
		            	Sleep(10000);
		            	
		            	SikuliUtil.verifyObjectAndHighlight("Google_Favicon", screen, parentTest, "Verification of Google Favicon After Navigating to "+sh.getRow(i).getCell(0).getStringCellValue(), driver, testCaseName, "Yes");
						
		            	System.out.println(sh.getRow(i).getCell(1).getStringCellValue());
						
		            	//SikuliUtil.verifyObjectAndHighlight(sh.getRow(i).getCell(1).getStringCellValue()+"_Home", screen, parentTest, "Verification of Google Home on "+sh.getRow(i).getCell(0).getStringCellValue(), driver, testCaseName, "Yes");
		            	
		            	SikuliUtil.verifyObjectAndHighlight(sh.getRow(i).getCell(1).getStringCellValue()+"_SearchButton", screen, parentTest, "Verification of Google Home on "+sh.getRow(i).getCell(0).getStringCellValue(), driver, testCaseName, "Yes");
						
		            	
		            	SikuliUtil.verifyObjectAndPaste(sh.getRow(i).getCell(1).getStringCellValue()+"_SearchBox1", screen, parentTest, "Verification of Search Box and entering text", driver, testCaseName, "No",sh.getRow(i).getCell(2).getStringCellValue() );
		            	
		            	/*if(SikuliUtil.isPresent(screen, "Different_Google_SearchBox")){
		            		
						SikuliUtil.verifyObjectAndPaste("Different_Google_SearchBox", screen, parentTest,"Clicking inside google search box and pasting search text", driver, testCaseName, "No",sh.getRow(i).getCell(2).getStringCellValue()) ;
						
						}else if(SikuliUtil.isPresent(screen, "Google_Searchbox")){
							
							SikuliUtil.verifyObjectAndPaste("Google_Searchbox", screen, parentTest,"Clicking inside google search box and pasting search text", driver, testCaseName, "No",sh.getRow(i).getCell(2).getStringCellValue()) ;
						
						}else{
							
							SikuliUtil.verifyObjectAndPaste("Right_Left_Google_SearchBox", screen, parentTest,"Clicking inside google search box and pasting search text", driver, testCaseName, "No",sh.getRow(i).getCell(2).getStringCellValue()) ;
						}
		            	*/
						
						Sleep(3000);
						
						SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
						
						Sleep(2000);
						
						SikuliUtil.verifyObjectAndHighlight(sh.getRow(i).getCell(1).getStringCellValue()+"_All", screen, parentTest, "Verification of All Logo on "+sh.getRow(i).getCell(0).getStringCellValue(), driver, testCaseName, "Yes");
						
						SikuliUtil.verifyObjectAndHighlight(sh.getRow(i).getCell(1).getStringCellValue()+"_SearchBox", screen, parentTest, "Verification of Search Box after Search on "+sh.getRow(i).getCell(0).getStringCellValue(), driver, testCaseName, "Yes");
						
						
						
		            }
					
		            	
		            
				
					
					
				}catch(Exception e){
					Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
					System.out.println(e);
					ReportGenerator.logStatusFail(parentTest,testCaseName, "The Google_Domains TestCase has failed,Please see logs and error screenshots", this.driver);
				}
				finally{
				//quitDriver(this.driver);
					path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
				}
				
			}
	
	
}
