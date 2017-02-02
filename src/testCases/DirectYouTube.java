package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class DirectYouTube {
	
	public static void main(String [] args) throws InterruptedException, AWTException{
		
		Settings.OcrTextRead=true;
		Settings.OcrTextSearch=true;
		
		System.setProperty("webdriver.chrome.driver", "./Win/Drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com/watch?v=6spx5pFyPYo&feature=youtu.be");
		Thread.sleep(4000);
		
		Screen screen=new Screen();
		String path=System.getProperty("user.dir")+"/Win/YouTube";
		Pattern pattern=new Pattern(path+"/Songduration.PNG");
		Region region=screen.exists(pattern);
		region.highlight(2);
		Thread.sleep(100);
		region.hover();
		
		pattern=new Pattern(path+"/IconPause.PNG");
		region=screen.exists(pattern);
		region.highlight(2);
		region.click();
		
		pattern=new Pattern(path+"/VideoProgressBar.PNG");
		region=screen.exists(pattern);
		region.click();
		Thread.sleep(100);
		
		pattern=new Pattern(path+"/SongDurationStart.PNG");
		region=screen.exists(pattern);
		region.highlight();
		region.click();
		
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
		Thread.sleep(100);
		
		pattern=new Pattern(path+"/FullScreenPatternAtZero.PNG");
		region=screen.exists(pattern);
		region.highlight(2);
		
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
		
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		
		pattern=new Pattern(path+"/FullScreenPatternAtEleven.PNG").exact();
		region=screen.exists(pattern);
		region.highlight();
		region.click();
		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	
	
	
	

}
