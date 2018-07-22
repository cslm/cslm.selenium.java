package com.testalliance.hrsystem.test;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import com.testalliance.hrsystem.pageobj.Page;

public class Test 
{
	File f = null;
	FileInputStream fis = null;
	Workbook wb = null;
	String[][] arr_testdata = null;
	Sheet sheet = null;
	boolean b = false;
	Page p;
	int testDataRow;
	int result = 1; //result为1代表pass, 为0代表fail
	
	public void getTestData(String filePath) throws Exception
	{
		//读取测试数据
		f = new File(filePath);
		fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
	    sheet = wb.getSheet("LoginDetails");

	    //计算Excel中有多少测试数据行
	    testDataRow = sheet.getLastRowNum() - sheet.getFirstRowNum(); 

		//通过行数初始化二维数组
		arr_testdata = new String[testDataRow][2];
	    
		//通过for循环从文件中把数组一行一行读到arr_testdata[][]中
	    for (int i = 1; i <= testDataRow; i++) 
	    {
	        Row row = sheet.getRow(i);
	        
	        for(int j = 0; j < 2; j++)
	        {
	        	arr_testdata[i-1][j] = row.getCell(j).getStringCellValue();
	        }       
	    }
	    wb.close();
		fis.close();
	}
	
	public int executeTest(WebDriver driver, String filePath, String sheetName, String module) 
			throws Exception
	{
		//read page objects
		p = new Page(driver);
		p.getPageObjects(System.getProperty("user.dir") + "//src//com//testalliance//hrsystem"
						+ "//objrepository//" + module + "Page.properties");

		//get test data
		this.getTestData(filePath);
		
		for(testDataRow = 1; testDataRow <= arr_testdata.length; testDataRow++)
		{
			System.out.println("第" + testDataRow + "次执行： ");
			stepThrough(driver, filePath, sheetName);
		}	
		return result;
	}
	
	public void stepThrough(WebDriver driver, String filePath, String sheetName) throws Exception
	{
		f = new File(filePath);
		fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
		
	    Sheet sheet = wb.getSheet(sheetName);
    	int testDataCell = 0;
    	int testSteps = sheet.getLastRowNum() - sheet.getFirstRowNum(); 
    	
    	for (int j = 1; j <= testSteps; j++) 
		{
    		Row row = sheet.getRow(j);
    		String keyword = row.getCell(0).toString();
    		
    		if(keyword.equals("Open Browser"))
            {
            	System.out.println("正在执行" + keyword);
            	p.openBrowser(row.getCell(3).toString());
            }
            else if(keyword.equals("Maximize Browser Window"))
            {	
            	System.out.println("正在执行" + keyword);
            	p.maximizeBrowserWindow();
        	}
            else if(keyword.equals("Input Text"))
            {
            	if(arr_testdata[testDataRow-1][testDataCell].equals("null"))
            	{
	            	System.out.println("正在执行" + keyword + ", 正在操作" + 
	            						row.getCell(2).toString() + 
	            						", 不输入任何值");
            	}
            	else
            	{
            		System.out.println("正在执行" + keyword + ", 正在操作" + 
    						row.getCell(2).toString() + 
    						", 输入" + arr_testdata[testDataRow-1][testDataCell]);
            		p.enter(row.getCell(1).toString(), row.getCell(2).toString(), 
            				arr_testdata[testDataRow-1][testDataCell]);
            	}
            	
            	testDataCell++;
            }
            else if(keyword.equals("Click Element"))
            {
            	System.out.println("正在执行" + keyword + ", 正在点击" + row.getCell(2).toString());
            	p.click(row.getCell(1).toString(), row.getCell(2).toString());
            }
            else if(keyword.equals("Verify Element Text"))
            {
	            b = p.verifyElementText(row.getCell(1).toString(), row.getCell(2).toString(), 
	            				row.getCell(3).toString());
	            System.out.println("正在执行" + keyword + ", 正在验证" + row.getCell(2).toString() 
	            						+ "的字符串是否与期望结果相等： " + b);
	            if(!b)
	            {
	            	result = 0;
	            }
            }
            else if(keyword.equals("Verify Alert"))
            {
            	b = p.verifyAlert(row.getCell(3).toString());
            	System.out.println("正在执行" + keyword + ", 正在验证alert的字符串是否与期望结果相等： " + b);
            	
            }
            else if(keyword.equals("Verify Element Display"))
            {
        		b = p.verifyElementDisplay(row.getCell(1).toString(), 
        				row.getCell(2).toString());
        		System.out.println("正在执行" + keyword + ", 正在验证元素" + row.getCell(2).toString() 
        				+ "是否显示： " + b);
        		if(!b)
            	{
        			result = 0;
            	}
            }
            else
            {
            	String module = row.getCell(4).toString();
            	p.getPageObjects(System.getProperty("user.dir") + "//src//com//testalliance//hrsystem"
            						+ "//objrepository//" + module + "Page.properties");
        		stepThrough(driver, System.getProperty("user.dir") + "//testdata.functions//" + module 
        					+ ".xlsx", keyword);
            }
		}
		wb.close();
		fis.close();			
	}
}

