package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args)
	{
		try 
		{
			System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
			WebDriver driver = new ChromeDriver();		
			driver.get("http://cslm-test.com/webapps/elements/webelements.html");	
			
			//浏览器全屏
			driver.manage().window().maximize();
			
			//得到当前网页标题
			String title = driver.getTitle();
			System.out.println(title);
			
			//得到当前网址
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			
			//得到当前网页源代码
			String pageSource = driver.getPageSource();
			System.out.println(pageSource);
			
			//点击一个链接，并且链接内容在新窗口
			driver.findElement(By.id("hyperlink")).click();
			Thread.sleep(5000);

			//关闭浏览器
			//driver.close();
			driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
