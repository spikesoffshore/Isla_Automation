package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.AssertJUnit;

public class ImageCheck {

	public static void main(String[] args) throws FindFailed, InterruptedException {

		System.setProperty("webdriver.chrome.driver","./Win/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Settings.OcrTextRead=true;
		Settings.OcrTextSearch=true;
		driver.get("https://www.google.com");
		Screen screen=new Screen();
		Region r,reg;
		
		
		driver.navigate().to("https://qaperfcc.spikes.eng//client.html#https://www.amazon.com");
		
		r=screen.findText("Google Search");

		r.highlight(5);
		int i=r.getY();
		r.setY(i-70);
		r.highlight(4);
		r.click();
		Thread.sleep(6000);
		
		r.type("Isla Security"+Key.ENTER);
		
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);	
		
		AssertJUnit.assertEquals(driver.getTitle(), "Isla Security - Google Search");
		//Loggers.writeLog("Search is done successfully....continuing test");
		
		org.sikuli.script.Pattern pattern=new org.sikuli.script.Pattern(("C://Garima//ISLA//Testing//automation//Isla_Automation//Isla//Win//Google//GoogleOptions.PNG")).exact();
		
		reg=screen.exists(pattern);
		reg=screen.find(pattern);

		Match match=new Match((Match) reg);
		System.out.println(match.getScore());
		reg.highlight(2);
		
		driver.quit();
		
		
	}

}
