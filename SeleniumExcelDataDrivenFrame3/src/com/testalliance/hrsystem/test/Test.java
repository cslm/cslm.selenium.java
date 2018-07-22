package com.testalliance.hrsystem.test;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test 
{
	File f = null;
	FileInputStream fis = null;
	Workbook wb;
	String[][] arr_testdata = null;
	Sheet sheet = null;
	boolean b = false;
	int testDataRow;
	int result = 1; //result为1代表pass, 为0代表fail
	
	public String[][] getTestData(String filePath, String sheetName) throws Exception
	{
		//读取测试数据
		f = new File(filePath);
		fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
	    sheet = wb.getSheet(sheetName);

	    //计算Excel中有多少测试数据行
	    testDataRow = sheet.getLastRowNum() - sheet.getFirstRowNum(); 
	    if(testDataRow != 0)
	    {
	    	int testDataCell = sheet.getRow(0).getLastCellNum();
			//通过行数初始化二维数组
			arr_testdata = new String[testDataRow][testDataCell];
		    
			//通过for循环从文件中把数组一行一行读到arr_testdata[][]中
		    for (int i = 1; i <= testDataRow; i++) 
		    {
		        Row row = sheet.getRow(i);
		        
		        for(int j = 0; j < testDataCell; j++)
		        {
		        	arr_testdata[i-1][j] = row.getCell(j).getStringCellValue();
		        }    
		        
		    }
	    }
	    wb.close();
		fis.close();
		
		return arr_testdata;
	}

}
