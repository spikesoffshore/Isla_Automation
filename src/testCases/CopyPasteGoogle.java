package testCases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class CopyPasteGoogle extends Base {
	
private WebDriver driver;
private String currentSitePath;
ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Local to RAC and RAC to Local Copy Paste");
private String testCaseName=getClass().getName().substring(10); 
	
//Function to navigate to Site url Specific to site ; will be written in every test class	
public void navigateToURL(WebDriver driver){
		
	siteURL="https://www.google.com/";
	
	driver.navigate().to(baseurl+siteURL);
	}
	
	//Function to copy Text from file 
	  public static String copyTextFromFile(String filePath,int numberOfLinesToRead) throws IOException{
          FileReader fr = new FileReader(filePath);
          BufferedReader br = new BufferedReader(fr);
          String[ ] textData = new String[numberOfLinesToRead+1];
          String copiedTextFromFile = "";
          for(int i=0;i<=numberOfLinesToRead-1;i++){
                
                textData[i]= br.readLine();
                copiedTextFromFile = copiedTextFromFile + textData[i];
          }
          
          br.close();
          
          return copiedTextFromFile;
    }
    
    //Function to copy a text from a file and paste it to a text box on the WebPage
    //Takes input Parameters as:
    //1) filePath: String :Complete path of the file from which the text is to be copied
    //2) textBox : By locator of the textbox
    //3) driver: Current WebDriver instance
    /*public static void pasteTextToTextbox(String filePath,By textBox,WebDriver driver) throws IOException{
          
          String copiedText = copyTextFromFile(filePath,1);
          driver.findElement(textBox).sendKeys(copiedText);
          
          
    }*/
	  
	  //Function to write to file from Screen
    public static void writeToFileFromTextbox(String filePath,String copiedText) throws IOException{
                 
          FileWriter fw = new FileWriter(filePath);
          BufferedWriter bw = new BufferedWriter(fw);
          bw.write(copiedText);
          bw.flush();
          bw.close();
         
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
			ReportGenerator.verifyNavigation(this.driver, copyTextFromFile(path+"/TestData.txt",1), parentTest,testCaseName, "Yes");
			SikuliUtil.verifyObjectAndHighlight("Google_Favicon", screen, parentTest,"Verify Google favicon",this.driver,testCaseName,"No");
			
			//Verify Google options
		SikuliUtil.verifyObjectAndHighlight("GoogleOptions", screen, parentTest, "Google options", this.driver, testCaseName, "Yes");
	
		//Get text from Google options pattern
		String copiedFromTextBox= SikuliUtil.getRegionText(screen, "GoogleOptions");
		
		//Function to write pattern text in text file
		writeToFileFromTextbox(path+"/Paste.txt",copiedFromTextBox);
		Sleep(2000);
		
		//Final Site Run status
		ReportGenerator.logStatusPass(parentTest, testCaseName, "The Local to RAC and RAC to Local TestCase is working as expected");
		Loggers.stopCurrentTestCaseExecution(testCaseName);
			
	}catch(Exception e){
		
		//In case of failure, mention the same in logs and Report
		Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
		System.out.println(e);
		ReportGenerator.logStatusFail(parentTest,testCaseName, "The Local to RAC and RAC to Local TestCase Failed,Please see logs and error screenshots", this.driver);
	}
		finally{
			quitDriver(this.driver);
			path=currentSitePath;
			ReportGenerator.flushReportToDisk(parentTest);
			
			
		}
	
	}
}
