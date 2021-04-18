package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	//creating one constructer
	//this const will we load the excel as son as we create
	//obj to that class,so we dont jave to provide path again and again
	//now we have to chk depancies apache POI
	//if we r workking with excel we need third party library apache POI
	//& this cost. call the obj as soon as u created its means u dont have to lode the file very time
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
	
		File src = new File("./TestData/Data.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			 wb=new XSSFWorkbook(fis);
		
		} catch (Exception e) {
			
			System.out.println("Unanble ot read Excel file"+e.getMessage());
		}
				
	}
     //now we have to crate a method to read the data
	//& this is also a method overloading
	public String getStringData(int sheetIndex,int row,int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNewmericData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		
	}
	
	
}
