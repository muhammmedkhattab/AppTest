package com.khattab.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	//check this class i implemented it but i didn't know how to use it
	
	static FileInputStream fis = null;

	public FileInputStream getFileInputStream() {
		//ask about dir
		String filePath = System.getProperty("user.dir") + "/srsTest/Testdata.xlsx";
		File srcFile = new File(filePath);

		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found...Terminating Process!! Check File Path ");
			System.exit(0);
		}
		return fis;
	}

	public Object[][] getExcelData() throws IOException

	{
		fis = getFileInputStream();

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// sheet name or index so 0 will be the first one
		XSSFSheet sheet = wb.getSheetAt(0);

		int TotalNumberOfRows = (sheet.getLastRowNum());
		//number of coulums in excel 
		int TotalNumberofCols = 4;
	String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberofCols];
	
	for (int i = 0; i < TotalNumberOfRows; i++) 
	{
		for (int j =0; j< TotalNumberofCols; j++) {
			XSSFRow row = sheet.getRow(i);
			arrayExcelData[i][j] = row.getCell(j).toString();
		}
		
	}
	//close didn't work ;(
	//wb.close();
	return arrayExcelData;
}
	
}