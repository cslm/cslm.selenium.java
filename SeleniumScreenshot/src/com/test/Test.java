package com.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	//把截屏过程封装在一个takeScreenshot方法里
	public void takeScreenshot(TakesScreenshot screenShot, WebDriver driver)
	{
		try
		{
			//定义当前日期时间的字符串格式
			Date now = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
			String str = f.format(now);
			
			//截屏并设置图片名称
			File tempFile = screenShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("C://backup//" + driver.getTitle() 
										+ "_" + str + ".jpg");
			FileUtils.copyFile(tempFile, destFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		Test t = null;
		WebDriver driver = null;
		TakesScreenshot screenShot = null;
		
		try 
		{
			System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
			driver = new ChromeDriver();		
			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			driver.get("http://cslm-test.com/hrsystem/index.php");
			driver.manage().window().maximize();
		
			//声明截屏接口对象screenShot
			screenShot = ((TakesScreenshot)driver);
			t = new Test();
			
			//登录过程
			driver.findElement(By.id("usercode")).sendKeys("1001");
			driver.findElement(By.id("password")).sendKeys("124");
			WebElement btn_login = driver.findElement(By.cssSelector(".btn-primary"));
			btn_login.click();
			Thread.sleep(3000);
			
			driver.quit();
		} 
		catch (Exception e) 
		{
			t.takeScreenshot(screenShot,driver); //截屏过程放到catch语句块中
			e.printStackTrace();
		}
	}
}