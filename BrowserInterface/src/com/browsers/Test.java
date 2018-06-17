package com.browsers;

public class Test 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		float browser_actualReponseTime;
		
		System.out.println("=======浏览器响应时间测试结果=======");
		for(int i = 0; i < 3; i++)
		{
			Browser b = null;
			switch(i)
			{
				case 0:
					b = new IE();
					b.setName("IE");
					b.setManufacturer("Microsoft");
					b.setExpectedResponseTime("6");
					break;
				case 1:
					b = new Chrome();
					b.setName("Chrome");
					b.setManufacturer("Google");
					b.setExpectedResponseTime("3");
					break;
				case 2:
					b = new Firefox();
					b.setName("Firefox");
					b.setManufacturer("Mozilla");
					b.setExpectedResponseTime("4");
					break;
			}
			
			// 取值
			String browser_name = b.getName();
			String browser_manufacturer = b.getManufacturer();
			String browser_expectedResponseTime = b.getExpectedResponseTime();
			int browser_expectedResponseTime_int = Integer.parseInt(browser_expectedResponseTime);
			browser_actualReponseTime = b.getActualResponseTime(browser_expectedResponseTime_int);
			
			//打印浏览器名称
			System.out.println("浏览器名称：" + browser_name); 
			//打印制造商名称
			System.out.println("制造商：" + browser_manufacturer);
			//打印期望响应时间
			System.out.println("期望响应时间：" 
							+ (float)browser_expectedResponseTime_int + "s"); 
			//打印期望响应时间
			System.out.println("实际相应时间：" 
							+ browser_actualReponseTime + "s"); 
			//打印空格
			System.out.println(); 
		}
	}
}