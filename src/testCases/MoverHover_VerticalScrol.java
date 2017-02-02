package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;


public class MoverHover_VerticalScrol {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		
		System.setProperty("webdriver.chrome.driver", "./Win/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org");
		
		Screen screen=new Screen();
		String path=System.getProperty("user.dir");
		path=path+"/Win/Wikipedia";
		Pattern pattern=new Pattern("/Eng.PNG");
		Pattern p=new Pattern("/MouseHover.png");
		Region r=screen.exists(pattern);
		
		screen.hover(pattern);
			Thread.sleep(1000);	
			
		if(screen.exists(p)!=null){
			System.out.println("tooltip present");
		}
		else{
			System.out.println("tooltip not present");
		}
		
		r.highlight(2);
		r.click();
		Thread.sleep(5000);
		
		screen.wheel(1, 10);
		Thread.sleep(2000);
		screen.wheel(-1,5);
		
		String str="Wiki";
		utils.CommonUtil.Screenshot(str, path, driver);
		
		
	}

}
