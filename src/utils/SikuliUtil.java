package utils;

import java.awt.Robot;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;

import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import testCases.Base;

public class SikuliUtil extends Base{
	
	//Function to get the 'patternpath' for the Sikuli Patterns
		public static String patternpath(String pic){
			patternpath=path+pic;
			return patternpath;
		}

	public static void verifyObjectAndClickOn(String imageName, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag){
		
		Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
		try {
			ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Region testObjectImage = screen.exists(pattern);
		testObjectImage.highlight(2);
		testObjectImage.hover();
		Sleep(4000);
		testObjectImage.click();
		
		Sleep(2000);
		
	}
	public static void verifyObjectAndHighlight(String imageName, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag){
		Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
		try {
			ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Region testObjectImage = screen.exists(pattern);
		testObjectImage.highlight(2);
		testObjectImage.hover();
		
	}
	
public static void verifyObjectAndType(String imageName, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag,String text){
		
		Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
		try {
			ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Region testObjectImage = screen.exists(pattern);
		testObjectImage.highlight(2);
		testObjectImage.hover();
		Sleep(4000);
		testObjectImage.click();
		Sleep(4000);
		testObjectImage.type(text);
		Sleep(2000);
		
	}

public static void verifyObjectAndPaste(String imageName, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag,String text){
	
	Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
	try {
		ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	Region testObjectImage = screen.exists(pattern);
	testObjectImage.highlight(2);
	testObjectImage.hover();
	Sleep(4000);
	testObjectImage.click();
	Sleep(4000);
	testObjectImage.paste(text);
	Sleep(2000);
	
}

public static void typeScreen(Screen screen,String text){
	
	screen.type(text);
	
}

public static void pasteScreen(Screen screen,String text){
	
	screen.paste(text);
	
}

public static void keyPress(Robot robot,int keyEvent){
	
	robot.keyPress(keyEvent);
	robot.keyRelease(keyEvent);
}

public static void moveWheel(Screen screen,int direction,int count){
	
	screen.wheel(direction,count);
	
}
public static void comboKeyPress(Robot robot,int keyEvent1,int keyEvent2){
	robot.keyPress(keyEvent1);
	robot.keyPress(keyEvent2);
	robot.keyRelease(keyEvent1);
	robot.keyRelease(keyEvent2);
	
	
}

public static void verifyTooltip(String imageName, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag){
	Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
	try {
		ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	Region testObjectImage = screen.exists(pattern);
	testObjectImage.highlight(2);
}

@SuppressWarnings("deprecation")
public static void setCordinatesAndType(String imageName, int xOrdinate,int yOrdinate, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag,String text){
	Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
	try {
		ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	Region testObjectImage=screen.exists(pattern);
	testObjectImage.moveTo(new Location(xOrdinate,yOrdinate));
	//testObjectImage.highlight(2);
	testObjectImage.type(text);

}

public static String getRegionText(Screen screen,String imageName){
	Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
	Region testObjetName=screen.exists(pattern);
	String text=testObjetName.text();
	return text;
	}

public static void screenClick(Screen screen){
	screen.click();
}

public static void screenFindTextandType(Screen screen, String textToBeSearched,String textToBeTyped){
	try {
		Region region=screen.findText(textToBeSearched);
		region.click();
		Sleep(2000);
		region.type(textToBeTyped);
	} catch (FindFailed e) {
		System.out.println(e.getMessage());
		
		e.printStackTrace();
	}
}

public static void mouseRightClick(String imageName, Screen screen){
	Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
	Region region=screen.exists(pattern);
	region.highlight(2);
	//screen.rightClick();
	region.hover();
	Sleep(2000);
	region.rightClick();
	Sleep(3000);
	
	
}


public static boolean isPresent(Screen screen,String imageName){
      
      Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
        //Region testObjectName=screen.exists(pattern);
      //testObjectName.highlight();
      if((screen.exists(pattern))!=null){
            
             return true;
      }else{return false;}

}
public static void clickBelow(String imageName, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag,int ordinate){
	
	//verifyObjectAndHighlight(imageName,screen,parentTest,testStep,driver,testCaseName,reportFlag);
	Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
	try {
		ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Region testObjectImage = screen.exists(pattern);
	testObjectImage.highlight(2);
	testObjectImage.hover();
	
	testObjectImage.below(ordinate).click();
}

public static void clickAbove(String imageName, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag,int ordinate){
	
	//verifyObjectAndHighlight(imageName,screen,parentTest,testStep,driver,testCaseName,reportFlag);
	Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
	try {
		ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Region testObjectImage = screen.exists(pattern);
	testObjectImage.highlight(2);
	testObjectImage.hover();
	
	testObjectImage.above(ordinate).click();
}

public static void clickRight(String imageName, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag,int ordinate){
	
	//verifyObjectAndHighlight(imageName,screen,parentTest,testStep,driver,testCaseName,reportFlag);
	Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
	try {
		ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Region testObjectImage = screen.exists(pattern);
	testObjectImage.highlight(2);
	testObjectImage.hover();
	
	testObjectImage.right(ordinate).click();
}

public static void clickLeft(String imageName, Screen screen,ExtentTest parentTest,String testStep,WebDriver driver,String testCaseName,String reportFlag,int ordinate){
	
	//verifyObjectAndHighlight(imageName,screen,parentTest,testStep,driver,testCaseName,reportFlag);
	Pattern pattern  =new Pattern(patternpath("/"+imageName+".PNG"));
	try {
		ReportGenerator.verifyPattern(screen, pattern, parentTest, testStep, driver, testCaseName,reportFlag);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Region testObjectImage = screen.exists(pattern);
	testObjectImage.highlight(2);
	testObjectImage.hover();
	
	testObjectImage.left(ordinate).click();
}
public static void selectTextFromRAC(Screen screen,int xOrdinate,int yOrdinate){
	
	screen.mouseDown(Button.LEFT);
	screen.mouseMove(xOrdinate, yOrdinate);
	screen.mouseUp(Button.LEFT);
	
}
}