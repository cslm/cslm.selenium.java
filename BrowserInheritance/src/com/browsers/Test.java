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
			//父类没有初始化，只有一个对象引用b，此时b里是空的，没存任何地址
			Browser b = null; 
			switch(i)
			{
				case 0:
					//父类对象b初始化子类IE
					b = new IE(); 
					b.setName("IE");
					b.setManufacturer("Microsoft");
					//用IE打开某个网站的期望时间为5秒
					b.setExpectedResponseTime("5"); 
					break;
				case 1:
					//父类对象b初始化子类Chrome
					b = new Chrome(); 
					b.setName("Chrome");
					b.setManufacturer("Google");
					//用Chrome打开某个网站的期望时间为2秒
					b.setExpectedResponseTime("2"); 
					break;
				case 2:
					//父类对象b初始化子类FireFox
					b = new Firefox(); 
					b.setName("Firefox");
					b.setManufacturer("Mozilla");
					//用Firefox打开某个网站的期望时间为3秒
					b.setExpectedResponseTime("3"); 
					break;
			}
			
			// 取值
			String browser_name = b.getName(); 
			String browser_manufacturer = b.getManufacturer();
			String browser_expectedResponseTime = b.getExpectedResponseTime();
			
			//取到的期望时间是字符串类型，但getActualResponseTime方法需要整型当参数，
			//所以要进行转换 
			int browser_expectedResponseTime_int = Integer.
					parseInt(browser_expectedResponseTime);
			// 调用方法后返回实际时间
			browser_actualReponseTime = b.
					getActualResponseTime(browser_expectedResponseTime_int); 
			
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
