package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/frames/frames3.html");
		driver.manage().window().maximize();
		
		//转到第二层：f2(第二层1号frame)
		driver.switchTo().frame(1);
		//转到第三层：f5(f2里的1号frame)
		driver.switchTo().frame(0);
		//转到第四层：f7(f5里的1号frame)
		driver.switchTo().frame(0);
		
		/*******************用List对象方法**************************/
		/*List<WebElement> iframes;
		WebElement iframe;
		//转到第二层：f2(第二层1号frame)
		driver.switchTo().frame(1);
		//转到第三层：f5(f2里的1号frame)
		iframes = driver.findElements(By.tagName("iframe"));
		iframe = iframes.get(0);
		driver.switchTo().frame(iframe);
		//转到第四层：f7(f5里的1号frame)
		iframes = driver.findElements(By.tagName("iframe"));
		iframe = iframes.get(0);
		driver.switchTo().frame(iframe);*/
		
		driver.findElement(By.name("button1")).click();
	}
}