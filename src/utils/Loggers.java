package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Loggers {

	static Logger logger=Logger.getLogger(Loggers.class);
	/*public static void main(String[] args) {
		writeErrorLog("This is an error message");
		writeInfoLog("This is an info message");
		

	}*/
public static  Logger getLogger(String loggerName){
	
	
	
	
	
	switch (loggerName){
	
	case "DEBUG":
		
		logger = Logger.getLogger(loggerName);
			
	case "INFO":
		logger = Logger.getLogger(loggerName);
		
	case "ERROR":
		logger = Logger.getLogger(loggerName); 
	
	
	}
	
	return logger;
}
public static void writeInfoLog(String message){
	
	getLogger("INFO").info(message);
	
}
public static void writeErrorLog(String message){
	
	getLogger("ERROR").error(message);
	
}
public static void writeDebugLog(String message){
	
	getLogger("DEBUG").debug(message);
	
}
public static void stopCurrentTestCaseExecution(String testCaseTitle){
	
	getLogger("INFO").info("****Execution for the current Test Case: "+testCaseTitle+" Completed****");
	
	
}
public static void startCurrentTestCaseExecution(WebDriver driver){
	
	getLogger("INFO").info("****Execution for "+driver.getTitle()+" started****");
	
}

public static void startCurrentTestCaseExecutionOtherThanUFT8(String testCaseTitle){
	
	getLogger("INFO").info("****Execution for "+testCaseTitle+" started****");
	
}
}
