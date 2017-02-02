package testCases;

import java.io.File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;

public class ChromeExtensionCheck extends Base {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Garima/ISLA/Testing/automation/Isla_Automation/Isla/Win/Drivers/chromedriver.exe");

	    ChromeOptions options = new ChromeOptions();
	    options.addExtensions(new File("C:/Garima/ISLA/Testing/automation/Isla_Automation/Isla/Extensions/extension_1_0_10.crx"));

	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    ChromeDriver driver = new ChromeDriver(capabilities);
	   
	    driver.manage().window().maximize();
	    org.sikuli.script.Screen screen=new org.sikuli.script.Screen();
	    Pattern p =new Pattern("C:/Garima/ISLA/Testing/automation/Isla_Automation/Isla/Extensions/Patterns/btnCancel.PNG");
	    Region r=screen.exists(p);
	    r.click();
	    	    
	    p=new Pattern("C:/Garima/ISLA/Testing/automation/Isla_Automation/Isla/Extensions/Patterns/IslaExtension.PNG");
	    r=screen.exists(p);
	    r.click();
	    
	    p=new Pattern("C:/Garima/ISLA/Testing/automation/Isla_Automation/Isla/Extensions/Patterns/IslaServerAddition.PNG");
	    r=screen.exists(p);
	    r.click();
	    r.type("https://qaengcc.spikes.eng/client.html"+Key.ENTER);
	    Sleep(2000);
	    
	  driver.navigate().to("https://www.amazon.com");
	    
	    
	}

}
