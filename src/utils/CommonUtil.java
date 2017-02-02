package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil {
	//Function to take screenshot
	/*This function takes an string for the qualified path name , the path from the base class and a WebDriver instance
	 * The function checks for an existing file with the same name and delete it. 
	 * Also, saves the screenshot with the filename having the current timestamp*/
	
	public static void Screenshot(String qualifiedFileName,String path,WebDriver driver){
		
		File existingFile = new File(qualifiedFileName);
	    if (existingFile.exists()) {
	    	existingFile.delete();     
	    }
				
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    
	qualifiedFileName =qualifiedFileName+getCurrentTime()+".PNG";
	qualifiedFileName = createValidFileName(qualifiedFileName);
	path=path+"\\Execution_Screenshots\\"+qualifiedFileName;
	try {
		org.apache.commons.io.FileUtils.copyFile(scrFile, new File(path));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
//Function to get current timestamp
	public static String getCurrentTime(){
	
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date currentTime = new Date();
	
	return df.format(currentTime);
	
} 

	//Function to get current timestamp
		public static String getCurrentTimeTillMinute(){
		
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");
			Date currentTime = new Date();
		
		return df.format(currentTime);
		
	} 
	
//Function to replace invalid characters from a file Name
	public static String createValidFileName(String fileName){
	
		String validFileName = fileName.replaceAll("[!@#$%^&?*(),{}+`~:/]", "_");
	
	return validFileName;
}
public static void getDyanamicWait(WebDriver driver,String toBeVerified){
        
        (new WebDriverWait(driver, 10))
          .until(ExpectedConditions.titleContains(toBeVerified));
        
    }
}

