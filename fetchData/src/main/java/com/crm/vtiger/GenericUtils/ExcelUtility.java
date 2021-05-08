package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains methods for reading data in excel sheet
 * @author vinay
 *
 */
public class ExcelUtility {
	
	/**
	 * To extract data by using Row cell and sheetname
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return String
	 * @throws Throwable
	 */
	
	public String getExcelData(String sheetname,int row,int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
	
	/**
	 * To extract data by using Row cell and sheetname
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return integer
	 * @throws Throwable
	 */
	
	public int getExcelDataInteger(String sheetname,int row,int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		return (int)(workbook.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue());
	}
	
	/**
	 * This method will return all the data present
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	
	public String[][] getExcelData(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(1).getPhysicalNumberOfCells();
		String[][] data = new String[rowcount][cellcount];
		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	/**
	 * This method will return value according to test case ID and title
	 * @param sheetname
	 * @param tcID
	 * @param headervalue
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetname,String tcID,String headervalue) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		int lastRow = sheet.getLastRowNum();
		int expectedRow = 0;
		for (int i = 0; i < lastRow; i++) {
			String testcaseID=sheet.getRow(i).getCell(0).getStringCellValue();
			if(testcaseID.equalsIgnoreCase(tcID)) {
				expectedRow = i;
				break;
			}
		}
		expectedRow--;
		int expectedcolumn = 0;
		int lastCell=sheet.getRow(expectedRow).getLastCellNum();
		for (int j = 0; j < lastCell; j++) {
			String value = sheet.getRow(expectedRow).getCell(j).getStringCellValue();
			if (value.equalsIgnoreCase(headervalue)) {
				expectedcolumn = j;
				break;
			}
		}
		return sheet.getRow(expectedRow+1).getCell(expectedcolumn).getStringCellValue();
	}
	
	/**
	 * This method will return value according to test case ID and title
	 * @param sheetname
	 * @param tcID
	 * @param headervalue
	 * @return
	 * @throws Throwable
	 */
	public int getExcelDataInteger(String sheetname,String tcID,String headervalue) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		int lastRow = sheet.getLastRowNum();
		int expectedRow = 0;
		for (int i = 0; i < lastRow; i++) {
			String testcaseID=sheet.getRow(i).getCell(0).getStringCellValue();
			if(testcaseID.equalsIgnoreCase(tcID)) {
				expectedRow = i;
				break;
			}
		}
		expectedRow--;
		int expectedcolumn = 0;
		int lastCell=sheet.getRow(expectedRow).getLastCellNum();
		for (int j = 0; j < lastCell; j++) {
			String value = sheet.getRow(expectedRow).getCell(j).getStringCellValue();
			if (value.equalsIgnoreCase(headervalue)) {
				expectedcolumn = j;
				break;
			}
		}
		return (int)sheet.getRow(expectedRow+1).getCell(expectedcolumn).getNumericCellValue();
	}
	
	/**
	 * This method to write the data
	 * @param sheetname
	 * @param rownum
	 * @param column
	 * @param value
	 * @throws Throwable
	 */
	
	public void writeExcelData(String sheetname,int rownum, int column,String value) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream writefile= new FileOutputStream(IPathConstant.EXCEL_FILEPATH);
		workbook.write(writefile);
	}
}
