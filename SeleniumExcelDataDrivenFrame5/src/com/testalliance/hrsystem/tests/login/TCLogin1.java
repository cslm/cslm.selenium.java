package com.testalliance.hrsystem.tests.login;

import org.openqa.selenium.WebDriver;
import com.testalliance.hrsystem.pageobj.LoginPage;
import com.testalliance.hrsystem.test.Test;

public class TCLogin1 
{
	public int test(WebDriver driver)
	{
		LoginPage lp = null;
		String[][] arr_testdata = null;
		Test t;
		//执行结果，初始值为0，如果最后执行完毕是Pass则改成1
		int result = 0;
		
		try 
		{
			//得到测试数据
			t = new Test();
			arr_testdata = t.getTestData(System.getProperty("user.dir") + 
										"//testdata.login//TCLogin1.xlsx", 
										"LoginDetails");
		    //读取page object
		    lp = new LoginPage(driver);
		    lp.getPageObjects();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int i = 1; i <= arr_testdata.length; i++)
		{
			// arr_testdata[0]取出的是用户代号，arr_testdata[1]取出的是密码
			String empCode = arr_testdata[i-1][0];
			String password = arr_testdata[i-1][1];
			System.out.println("第" + i + "次执行： " + "员工代号: " 
									+ empCode + ", 密码: " + password);
			
			//登录
			lp.openBrowser();
			lp.maximizeBrowserWindow();
			System.out.println("正在执行登录操作： ");
			lp.login(empCode, password);
			
			//断言1： Home菜单的文本是否是"Home"
			System.out.println("正在检查Home菜单的文本是否是\"Home\"");
			if(lp.verifyMenuHomeText())
			{
				lp.clickLogout();
				//断言2： 登录按钮出现在登录页
				System.out.println("正在检查登录按钮是否出现在登录页： " 
				                               + lp.verifyLoginBtnExist());
				if(lp.verifyLoginBtnExist())
				{
					result = 1;
				}
			}
		}
		return result;
	}
}
