package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/elements/webelements.html");
		driver.manage().window().maximize();
		
		WebElement textBox = driver.findElement(By.name("textfield"));
		textBox.sendKeys("marco"); //输入文本
		Thread.sleep(5000);
		System.out.println(textBox.getAttribute("value")); //取得文本框里的值 
		textBox.clear(); // 清除文本框中值
		System.out.println(textBox.isEnabled()); //查看是否启用
		driver.quit();
	}

}
