package testcases;


import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ExcelConfig(String excelpath)
	{
		try {
			File src=new File(excelpath);
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheetAt(0);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String getData(int sheetno,int rowno,int colno)
	{
		sheet=wb.getSheetAt(sheetno);
		String data=sheet.getRow(rowno).getCell(colno).getStringCellValue();
		return data;
		
	}
	public int getRowCount(int sheetno)
	{
		int row=wb.getSheetAt(sheetno).getLastRowNum();
		int rows=row+1;
		return rows;
		
	}
}
