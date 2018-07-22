package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pageobjects.LoginPage;

public class Test 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("http://cslm-test.com/hrsystem/index.php");
		driver.manage().window().maximize();
		
		File f; 
		FileReader fr = null;
		BufferedReader br = null;
		LoginPage lp = null;
		ArrayList<String[]> al = null;
		
		try 
		{
			//读取数据源
			f = new File("C:/Users/marcoc/Dropbox/cslm sourcecode/cslm.selenium.java/"
					+ "SeleniumCsvDataDrivenPOM/files/Login.csv");
			al = new ArrayList<String[]>();
			
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String line = null;
			//用arr_testdata来存用逗号分开的字符串
			String[] arr_loginDetails;
			
			while((line = br.readLine()) != null)
			{
				//split分字符串
				arr_loginDetails = line.split(",");
				
				//用ArrayList al来存每一次循环完的字符串数组
				al.add(arr_loginDetails);	
			}	
		    
		    //读取page object
		    lp = new LoginPage(driver);
		    lp.getPageObjects();
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
				br.close();
				fr.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		//读取测试源，执行test case并断言
	    System.out.println("开始执行" + Thread.currentThread() .getStackTrace()[1].getClassName() 
	    			+ "模块中" + Thread.currentThread() .getStackTrace()[1].getMethodName() + ":");
		
	    for(int i = 1; i < al.size(); i++)
		{
			//执行结果，初始值为Test Fail，如果最后执行完毕是Pass则改成Test Pass
			String TEST_RESULT = "Test Fail";
			String[] arr_testdata = al.get(i);
			// arr_testdata[0]取出的是用户名，arr_testdata[1]取出的是密码
			String empCode = arr_testdata[0];
			String password = arr_testdata[1];
			System.out.println("第" + i + "次执行： " + "员工代号: " + empCode + ", 密码: " + password);
			
			//登录
			lp.login(empCode, password);
			
			//断言1： Home菜单的文本是否是"Home"
			if(lp.verifyMenuHomeText())
			{
				lp.clickLogout();
				//断言2： 登录按钮出现在登录页
				if(lp.verifyLoginBtnExist())
				{
					TEST_RESULT = "Test Pass";
				}
			}
			System.out.println("执行结果: " + TEST_RESULT);
		}
	    driver.quit();
	}
}
