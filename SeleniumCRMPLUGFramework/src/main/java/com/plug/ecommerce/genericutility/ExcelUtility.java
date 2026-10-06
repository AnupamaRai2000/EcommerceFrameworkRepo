package com.plug.ecommerce.genericutility;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	

	String excelPath = "‪C:\\Project\\Test_case.xlsx";

	
	public String readDataFromExcel(
			String sheetName,
			int rowNum,
			int cellNum) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		String data =
				wb.getSheet(sheetName)
				  .getRow(rowNum)
				  .getCell(cellNum)
				  .toString();

		wb.close();
		fis.close();

		return data;
	}

	

	public String getFormattedData(
			String sheetName,
			int rowNum,
			int cellNum) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		DataFormatter df =
				new DataFormatter();

		String data =
				df.formatCellValue(
						wb.getSheet(sheetName)
						  .getRow(rowNum)
						  .getCell(cellNum));

		wb.close();
		fis.close();

		return data;
	}

	
	public int getRowCount(
			String sheetName) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		int rowCount =
				wb.getSheet(sheetName)
				  .getPhysicalNumberOfRows();

		wb.close();
		fis.close();

		return rowCount;
	}

	

	public int getCellCount(
			String sheetName) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		int cellCount =
				wb.getSheet(sheetName)
				  .getRow(0)
				  .getPhysicalNumberOfCells();

		wb.close();
		fis.close();

		return cellCount;
	}

	

	public void writeDataInExistingCell(
			String sheetName,
			int rowNum,
			int cellNum,
			String value) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		wb.getSheet(sheetName)
		  .getRow(rowNum)
		  .getCell(cellNum)
		  .setCellValue(value);

		FileOutputStream fos =
				new FileOutputStream(excelPath);

		wb.write(fos);

		wb.close();
		fos.close();
		fis.close();
	}

	

	public void writeDataInNewCell(
			String sheetName,
			int rowNum,
			int cellNum,
			String value) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		wb.getSheet(sheetName)
		  .getRow(rowNum)
		  .createCell(cellNum)
		  .setCellValue(value);

		FileOutputStream fos =
				new FileOutputStream(excelPath);

		wb.write(fos);

		wb.close();
		fos.close();
		fis.close();
	}

	

	public void createSheet(
			String sheetName) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		wb.createSheet(sheetName);

		FileOutputStream fos =
				new FileOutputStream(excelPath);

		wb.write(fos);

		wb.close();
		fos.close();
		fis.close();
	}

	
	public void deleteSheet(
			String sheetName) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		int sheetIndex =
				wb.getSheetIndex(sheetName);

		if (sheetIndex != -1) {
			wb.removeSheetAt(sheetIndex);
		}

		FileOutputStream fos =
				new FileOutputStream(excelPath);

		wb.write(fos);

		wb.close();
		fos.close();
		fis.close();
	}

	

	public boolean isSheetExist(
			String sheetName) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		boolean status =
				wb.getSheet(sheetName) != null;

		wb.close();
		fis.close();

		return status;
	}

	

	public Sheet getSheet(
			String sheetName) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		Sheet sheet =
				wb.getSheet(sheetName);

		// Workbook remains open while returned sheet is used.
		// Prefer read methods above for normal framework usage.
		return sheet;
	}

	

	public void printAllSheetNames() throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		for (int i = 0; i < wb.getNumberOfSheets(); i++) {

			System.out.println(
					wb.getSheetName(i));
		}

		wb.close();
		fis.close();
	}

	
	public String[] getRowData(
			String sheetName,
			int rowNum) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		Row row =
				wb.getSheet(sheetName)
				  .getRow(rowNum);

		int cellCount =
				row.getPhysicalNumberOfCells();

		String[] data =
				new String[cellCount];

		DataFormatter df =
				new DataFormatter();

		for (int i = 0; i < cellCount; i++) {

			data[i] =
					df.formatCellValue(
							row.getCell(i));
		}

		wb.close();
		fis.close();

		return data;
	}

	
	public String[][] getSheetData(
			String sheetName) throws Exception {

		FileInputStream fis =
				new FileInputStream(excelPath);

		Workbook wb =
				WorkbookFactory.create(fis);

		Sheet sheet =
				wb.getSheet(sheetName);

		int rowCount =
				sheet.getPhysicalNumberOfRows();

		int cellCount =
				sheet.getRow(0)
				     .getPhysicalNumberOfCells();

		String[][] data =
				new String[rowCount][cellCount];

		DataFormatter df =
				new DataFormatter();

		for (int i = 0; i < rowCount; i++) {

			Row row =
					sheet.getRow(i);

			for (int j = 0; j < cellCount; j++) {

				data[i][j] =
						df.formatCellValue(
								row.getCell(j));
			}
		}

		wb.close();
		fis.close();

		return data;
	}
}
