package com.webshop.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
    XSSFWorkbook excel;
	
	// this constructor loads the excel sheet
	public ExcelUtil(String path) 
	{
		try
		{
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			excel = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("unable to load the excel sheet : "
					+ ""+e.getLocalizedMessage());
		}
	}
	
	// this method returns the active row count
	public int getRowCount(int sheetNum)
	{
		return excel.getSheetAt(sheetNum).getLastRowNum()+1;
	}
	
	// this method returns the cell data
    public String getCellData(int sheetnum, int row, int cell)
    {
    	return excel.getSheetAt(sheetnum).getRow(row).getCell(cell).toString();
    }

}
