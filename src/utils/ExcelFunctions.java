package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctions {

	public static XSSFWorkbook Book1;
	public static XSSFSheet Sheet;
	public static XSSFRow row;
	
	public static String getSpecificCellValueWithSheetNumber(String excelPath,int sheetNum,int rowNum,int colNum) throws IOException{
		
		String cellValue=null;
		
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		Book1 = new XSSFWorkbook(fis);
		Sheet = Book1.getSheetAt(sheetNum);
		cellValue = Sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellValue;
	}
	
	
public static String getSpecificCellValue(String excelPath,String sheetName,int rowNum,int colNum) throws IOException{
		
		String cellValue=null;
		
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		Book1 = new XSSFWorkbook(fis);
		Sheet = Book1.getSheet(sheetName);
		cellValue = Sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellValue;
	}
	
	public static void writeStringToSpecificCellwithSheetNumber(String excelPath,int sheetNum,int rowNum,int colNum,String data) throws IOException{
		
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		Book1 = new XSSFWorkbook(fis);
		Sheet = Book1.getSheetAt(sheetNum);
		Sheet.createRow(rowNum);
		Sheet.getRow(rowNum).createCell(colNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(excelPath);
		Book1.write(fos);
		fos.flush();
		fos.close();
		
	}
	
public static void writeStringToSpecificCell(String excelPath,String sheetName,int rowNum,int colNum,String data) throws IOException{
		
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		Book1 = new XSSFWorkbook(fis);
		Sheet = Book1.getSheet(sheetName);
		Sheet.createRow(rowNum);
		Sheet.getRow(rowNum).createCell(colNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(excelPath);
		Book1.write(fos);
		fos.flush();
		fos.close();
		
	}

public static boolean writeStringToSpecificCellandVerify(String excelPath,String sheetName,int rowNum,int colNum,String data) throws IOException{
	
	String cellValue=null;
	
	File file = new File(excelPath);
	FileInputStream fis = new FileInputStream(file);
	Book1 = new XSSFWorkbook(fis);
	Sheet = Book1.getSheet(sheetName);
	Sheet.createRow(rowNum);
	Sheet.getRow(rowNum).createCell(colNum).setCellValue(data);
	FileOutputStream fos = new FileOutputStream(excelPath);
	Book1.write(fos);
	fos.flush();
	fos.close();
	
	cellValue = Sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	if(cellValue.contains(data)){
		return true;
	}
	else{
		return false;
	}
}
	
	
}
