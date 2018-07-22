package com.testalliance.hrsystem.managers;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.testalliance.hrsystem.test.Utility;

public class TestRunner 
{
	public static void main(String[] args)
	{
		WebDriver driver = null;
		String filePath = System.getProperty("user.dir") + "/config/config.csv";
		Utility util = new Utility();
		ArrayList<String[]> al = util.getModules(filePath);
		int result = 0;
		String TEST_RESULT;
		
		for(int i = 1; i < al.size(); i++)
		{
			String[] arr_config = al.get(i);
			String driverBrowser = arr_config[0];
			String driverPath = arr_config[1];
			String browser = arr_config[2];
			
			//读取测试模块
			String modules = arr_config[3];
			modules = modules.replace("{", "").replace("}", "");
			String[] arr_modules = modules.split("\\|");
			for(int j = 0; j < arr_modules.length; j++)
			{
				File dir = new File(System.getProperty("user.dir") + "//testdata."
																+ arr_modules[j]);
				File[] fileList = dir.listFiles();
				for(File file : fileList)
				{
					String tcName = file.getName();
					int ch = tcName.indexOf(".");
					tcName = tcName.substring(0,ch);
					//System.out.println(tcName);
					System.out.println("开始执行" + arr_modules[j] + "模块中" 
														+ file.getName() + ":");
					DriverManager dm = null;
					try
					{
						//测试准备
						dm = new DriverManager(driverBrowser, driverPath, browser);
						driver = dm.preTest();
						
						//执行测试方法
						//获取Class对象
						Class c = Class.forName("com.testalliance.hrsystem.tests." 
						+ arr_modules[j] + "." + tcName);
						//通过成员方法获取方法对象
						Method m = c.getMethod("test", WebDriver.class);
						//通过构造方法实例化测试类
						Object classObj = c.getConstructor().newInstance(); 
						//用方法对象调用方法，传入driver作为参数
						result = (int)m.invoke(classObj, driver);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						TakesScreenshot screenShot = ((TakesScreenshot)driver);
						util.takeScreenshot(screenShot, driver);
					}
					finally 
					{
						if(result == 0)
							TEST_RESULT = "Test Fail";
						else
							TEST_RESULT = "Test Pass";
						System.out.println("执行结果： " + TEST_RESULT);
						System.out.println("");
						
						//测试扫尾
						dm.cleanUp();
					}
				}
			}
		}
	}
}
