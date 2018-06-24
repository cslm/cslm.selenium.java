package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.baidu.com");//打开网页，确保有一页
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.navigate().to("http://cslm-test.com/webapps/elements/webelements.html"); //转到某一页
		Thread.sleep(3000);
		driver.navigate().back(); //回到前一页
		Thread.sleep(3000);
		driver.navigate().forward(); //基于back
		Thread.sleep(3000);
		driver.navigate().refresh(); //刷新
		Thread.sleep(3000);
		driver.quit();
		
	}
}
