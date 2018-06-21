package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test 
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode"
				+ "\\cslm.selenium.java\\ExcelOperations\\files\\test.xlsx");
		FileInputStream fis = null; 
		Workbook wb = null;
				 
		try
		{
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("login");
			//计算行数
			int rowCount = sheet.getLastRowNum() + 1;
			//循环从0到总行数
			for (int i = 0; i < rowCount; i++) 
			{
				//取得每一行
				Row row = sheet.getRow(i);
				
				//取得每一列的值
				for (int j = 0; j < row.getLastCellNum(); j++)
				{
					String value= row.getCell(j).getStringCellValue();
					System.out.print(value + " ");
				}
				System.out.println();
			}
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