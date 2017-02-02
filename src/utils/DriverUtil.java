package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import testCases.Base;

public class DriverUtil extends Base {

	
	public static void verifyURLContains(WebDriver driver,String stringInURL,ExtentTest parent,String testCaseName,String message){
		
		if(driver.getCurrentUrl().contains(stringInURL)){
			
			ReportGenerator.logStatusPass(parent, testCaseName, message);
		}
		
	}
	
	public static void navigateBack(WebDriver driver){
		
		driver.navigate().back();
	}
	
	public static void navigateToNextTab(WebDriver driver){
		
		Set <String> browserTabs = driver.getWindowHandles();
		
		driver.switchTo().window(browserTabs.toArray()[1].toString());
		
	}
	
	public static void navigateToURL(WebDriver driver,String url){
		
		driver.navigate().to(url);
	}
}
