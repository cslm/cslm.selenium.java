package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test 
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode"
				+ "\\cslm.selenium.java\\ExcelWrite\\files\\test.xlsx");
		FileInputStream fis = null; 
		FileOutputStream fos = null;
		Workbook wb = null;
		String[] str = {"1004", "101112"};
				 
		try
		{
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("login");

			//创建一行
			Row row = sheet.createRow(0);
				
			//把值加到每列中
			for (int j = 0; j < 2; j++)
			{
				Cell cell = row.createCell(j);
				cell.setCellValue(str[j]);
			}
			
			//初始化输出流
			fos = new FileOutputStream(f);
			//把数据写到文件中
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			wb.close();
			fis.close();
		}		
	}
}