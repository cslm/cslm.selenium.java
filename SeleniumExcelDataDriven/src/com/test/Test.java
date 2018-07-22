package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("http://cslm-test.com/hrsystem/index.php");
		driver.manage().window().maximize();
		
		//制作数据源		
		//String[][] arr_testdata = {{"1001","123"},{"1002","456"},{"1003","789"}};
		
		File f = new File("C://Users//marcoc//Dropbox//cslm sourcecode//cslm.selenium.java"
					+ "//SeleniumExcelDataDriven//files//Login.xlsx");
		FileInputStream fis = null;
		Workbook wb = null;
		int rowCount;
		String[][] arr_testdata = null;
		
		try 
		{
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
			
		    Sheet sheet = wb.getSheet("LoginDetails");

		    //计算Excel中有多少数据行
		    rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum(); 
			
			//通过行数来初始化二维数组
			arr_testdata = new String[rowCount][2];
		    
			//通过for循环从文件中把数据一行一行读到arr_testdata[][]中
		    for (int i = 1; i <= rowCount; i++) 
		    {
		        Row row = sheet.getRow(i);
		        
		        for(int j = 0; j < 2; j++)
		        {
		        	arr_testdata[i-1][j] = row.getCell(j).getStringCellValue();
		        }       
		    }
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
		
		//读取测试源，执行test case并断言
	    System.out.println("开始执行" + Thread.currentThread() .getStackTrace()[1].getClassName() 
	    			+ "模块中" + Thread.currentThread() .getStackTrace()[1].getMethodName() + ":");
		
	    for(int i = 1; i <= arr_testdata.length; i++)
		{
			//执行结果，初始值为Test Fail，如果最后执行完毕是Pass则改成Test Pass
			String TEST_RESULT = "Test Fail";

			// arr_testdata[0]取出的是用户名，arr_testdata[1]取出的是密码
			String empCode = arr_testdata[i-1][0];
			String password = arr_testdata[i-1][1];
			System.out.println("第" + i + "次执行： " + "员工代号: " + empCode + ", 密码: " + password);
			driver.findElement(By.id("usercode")).sendKeys(empCode);
			driver.findElement(By.id("password")).sendKeys(password);
			WebElement btn_login = driver.findElement(By.cssSelector(".btn-primary"));
			btn_login.click();
			
			//断言1： Home菜单的文本是否是"Home"
			//为防止异常抛出，先判断首页Home菜单存在不存在
			List<WebElement> menuitems_home_list = driver.findElements(By.xpath("//ul/li[1]/a"));
			//大于0证明存在
			if(menuitems_home_list.size() > 0)
			{
				WebElement menuitem_home = driver.findElement(By.xpath("//ul/li[1]/a"));
				if(menuitem_home.getText().equals("Home"))
				{
					driver.findElement(By.linkText("Log Off")).click();
					//断言2： 登录按钮出现在登录页
					//同样，先判断登录页登录按钮存在不存在
					List<WebElement> btn_login_list = driver.findElements(By.cssSelector(".btn-primary"));
					if(btn_login_list.size() > 0)
					{
						btn_login = driver.findElement(By.cssSelector(".btn-primary"));
						if(btn_login.isDisplayed())
						{
							//断言正确
							TEST_RESULT = "Test Pass";
						}
					}
				}
			}
			System.out.println("执行结果: " + TEST_RESULT);
		}
	    driver.quit();
	}
}
