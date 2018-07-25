package com.test;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageobj.LoginPage;

public class Test 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		File f = null;
		FileInputStream fis = null;
		Workbook wb = null;
		LoginPage lp = null;
		int rowCount;
		boolean b = false;
		
		try 
		{
			String TEST_RESULT = "Test Fail";
			System.out.println("开始执行" + Thread.currentThread() .getStackTrace()[1].getClassName() 
	    			+ "模块中" + Thread.currentThread() .getStackTrace()[1].getMethodName() + ":");
			
			//读取page object
		    lp = new LoginPage(driver);
		    lp.getPageObjects();
		    
			//读取test case
			f = new File("C://Users//marcoc//Dropbox//cslm sourcecode//cslm.selenium.java"
					+ "//SeleniumExcelKeywordDrivenPOM//files//Login.xlsx");
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
			
		    Sheet sheet = wb.getSheet("LoginDetails");

		    //计算Excel中有多少数据行
		    rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum(); 
		    System.out.println(rowCount);
			//通过for循环执行test case
		    for (int i = 1; i <= rowCount; i++) 
		    {
		        Row row = sheet.getRow(i);
		        
		        String keyword = row.getCell(0).toString();
		        
		        switch(keyword)
		        {
		        	case "Open Browser":
		        		lp.openBrowser();
		        		break;
		        	case "Maximize Browser Window":
		        		lp.maximizeBrowserWindow();
		        		break;
		        	case "Input Text": 
		        		System.out.println("正在操作" + row.getCell(2).toString() 
		        				+ ", 输入" + row.getCell(3).toString());
		        		lp.enter(row.getCell(1).toString(), row.getCell(2).toString(), 
		        				row.getCell(3).toString());
		        		break;
		        	case "Click Element":
		        		System.out.println("正在点击" + row.getCell(2).toString());
		        		lp.click(row.getCell(1).toString(), row.getCell(2).toString());
		        		break;
		        	case "Verify Equal String":
		        		b = lp.verifyEqualString(row.getCell(1).toString(), 
		        				row.getCell(2).toString(), row.getCell(3).toString());
		        		System.out.println("正在验证" + row.getCell(2).toString() 
		        				+ "的字符串是否与期望结果相等： " + b);
		        		break;
		        	case "Verify Element Display":
		        		b = lp.verifyElementDisplay(row.getCell(1).toString(), 
		        				row.getCell(2).toString());
		        		System.out.println("正在验证元素" + row.getCell(2).toString() 
		        				+ "是否显示： " + b);
		        		break;
		        	case "login":
		        		//...
		        		break;
		        	case "logout":
		        		//...
		        		break;
		        	//...
		        }
		    }
		    if(b)
		    {
		    	TEST_RESULT = "Test Pass";
		    }
		    System.out.println("执行结果: " + TEST_RESULT);
		    
		    driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//关闭文件流
			try
			{
				wb.close();
				fis.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
