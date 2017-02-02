package utils;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class CopyPasteFunctions {

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
	  
	  //To get text into Clipboard from notepad
	  public static void getTextInClipboard(String FileName){
		  java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    String text="";
			try {
				//File to be placed under CopyPasteTestData folder
				text = copyTextFromFile("./CopyPasteTestData/"+FileName+".txt",1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		  StringSelection selection = new StringSelection(text);
		    clipboard.setContents(selection, null);
	  }
	  
	  public static void getTextInClipboardFromExcel(String excelPath,String SheetName,int rowNum,int colNum){
		  java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    String text="";
			try {
				//File to be placed under CopyPasteTestData folder
				text = ExcelFunctions.getSpecificCellValue(excelPath, SheetName, rowNum, colNum);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		  StringSelection selection = new StringSelection(text);
		    clipboard.setContents(selection, null);
	  }
	  
	  //To paste text from Clipboard
	  public static void pasteClipboardText(String excelPath,String SheetName,int rowNum,int colNum){
		  java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  DataFlavor flavor = DataFlavor.stringFlavor;
		    if (clipboard.isDataFlavorAvailable(flavor)) {
		      try {
		        String text1 = (String) clipboard.getData(flavor);
		        ExcelFunctions.writeStringToSpecificCell(excelPath, SheetName, rowNum, colNum, text1);
		      } catch (UnsupportedFlavorException e) {
		        System.out.println(e);
		      } catch (IOException e) {
		        System.out.println(e);
		      }
		    }
		  
	  }
	  
	  
	  public static void pasteClipboardTextandVerify(String excelPath,String SheetName,int rowNum,int colNum,ExtentTest parentTest,String testStep,String testCaseName,WebDriver driver) throws InterruptedException{
		  java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  DataFlavor flavor = DataFlavor.stringFlavor;
		    if (clipboard.isDataFlavorAvailable(flavor)) {
		      try {
		        String text1 = (String) clipboard.getData(flavor);
		       Boolean flag= ExcelFunctions.writeStringToSpecificCellandVerify(excelPath, SheetName, rowNum, colNum, text1);
		       if(flag)
		       {
		    	   ReportGenerator.logStatusPass(parentTest,testStep,testStep+" is done successfully");
				    Loggers.writeInfoLog(testStep+" is done successfully....continuing test");
				}
		        else{
		    	   File makeErrorFolder= new File((System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/"+testCaseName+"_errorScreenshots"));
					makeErrorFolder.mkdir();
					
					    ReportGenerator.logStatusFail(parentTest, testCaseName, testStep+" is failed",driver);
					    Loggers.writeErrorLog(testStep+" failed....stopping test");
					   throw new InterruptedException();  
					 
		    	   
		    	   
		       }
		       
		        //ExcelFunctions.writeStringToSpecificCell(excelPath, SheetName, rowNum, colNum, text1);
		      } catch (UnsupportedFlavorException e) {
		        System.out.println(e);
		      } catch (IOException e) {
		        System.out.println(e);
		      }
		    }
		  
	  }
	  
	
	
	
}
