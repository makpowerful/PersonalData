package com.testing.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	static Workbook book;
	static Sheet sheet;

	public static String TESTDATA_FILE_PATH = "/Users/shusam01/Documents/SeleniumCertTraining/MavenTestNGDemo/src/main/java/testdata/Login.xlsx";

	public static Object[][] getTestDataFromExcel(String sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_FILE_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		try {
			try {
				book = WorkbookFactory.create(file);
			} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;

	}

}
