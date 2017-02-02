package utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class VideoUtil {
	
	public static void videoFullScreen(Robot robot){
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
	}

	public static void videoScreenRestore(Robot robot){
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	public static void videoForward(Robot robot,int counter){
		for(int i=0;i<counter;i++){
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
		}
	}

	public static void videoBack(Robot robot,int counter){
		for(int i=0;i<counter;i++){
			robot.keyPress(KeyEvent.VK_LEFT);
			robot.keyRelease(KeyEvent.VK_LEFT);
		}
	}
	
	public static void videoTogglePausePlay(Robot robot){
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
	}
	
	public static void videoMuteUnMute(Robot robot){
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
	}
	
	public static void videoBeginning(Robot robot){
		robot.keyPress(KeyEvent.VK_HOME);
		robot.keyRelease(KeyEvent.VK_HOME);
	}
	
	public static void videoEnd(Robot robot){
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
	}
	
	
	
}
