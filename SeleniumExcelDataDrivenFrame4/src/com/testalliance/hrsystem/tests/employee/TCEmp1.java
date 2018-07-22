package com.testalliance.hrsystem.tests.employee;

import org.openqa.selenium.WebDriver;
import com.testalliance.hrsystem.pageobj.EmpPage;
import com.testalliance.hrsystem.pageobj.LoginPage;
import com.testalliance.hrsystem.test.Test;

public class TCEmp1 
{
	public void test(WebDriver driver)
	{
		LoginPage lp = null;
		String[][] arr_testdata = null;
		Test t;
		EmpPage ep = null; 
		
		try 
		{
			//得到测试数据
			t = new Test();
			arr_testdata = t.getTestData(System.getProperty("user.dir") + 
										"//testdata.employee//TCEmp1.xlsx", 
										"LoginDetails");
		    //读取page object
		    lp = new LoginPage(driver);
		    lp.getPageObjects();

		
			for(int i = 1; i <= arr_testdata.length; i++)
			{
				//执行结果，起始值为Test Fail，如果最终执行完毕是Pass则改为Test Pass
				String TEST_RESULT = "Test Fail";
				
				// arr_testdata[0]取出的是用户代号，arr_testdata[1]取出的是密码
				String empCode = arr_testdata[i-1][0];
				String password = arr_testdata[i-1][1];
				System.out.println("第" + i + "次执行： " + "员工代号: " 
										+ empCode + ", 密码: " + password);
				
				//打开浏览器
				lp.openBrowser();
				//最大化浏览器
				lp.maximizeBrowserWindow();
				//登录
				System.out.println("正在执行登录操作： ");
				lp.login(empCode, password);
				
				System.out.println("正在检查Home菜单的文本是否是Home");
				if(lp.verifyMenuHomeText())
				{
					ep = new EmpPage(driver);
					ep.getPageObjects();
					//点击Employee
					ep.navToEmployee();
					//验证日期
					System.out.println("正在验证登陆日期是否和系统日期一致");
					if(ep.verifyLoginDate(empCode))
					{
						TEST_RESULT = "Test Pass";
					}
				}
				System.out.println("执行结果: " + TEST_RESULT);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
