package com.feature.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook workBook;
	XSSFSheet sheet;

	public ExcelDataProvider() {
		try {
			FileInputStream fis = new FileInputStream("D:\\Work\\Work\\EK12Docs\\EC\\com.selenium-fw.2023\\Test Data\\Data.xlsx");
			workBook = new XSSFWorkbook(fis);
			sheet = workBook.getSheet("TestData");
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public String getStringValue(int row, int cell) {
		return sheet.getRow(row).getCell(cell).getStringCellValue();
	}
	
	public double getIntegerValue(int row, int cell) {
		return sheet.getRow(row).getCell(cell).getNumericCellValue();
	}
}
