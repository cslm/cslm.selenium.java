package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/elements/webelements.html");
		driver.manage().window().maximize();
		
		WebElement textArea = driver.findElement(By.xpath("//div")); //用xpath定位普通文本
		System.out.println(textArea.getText()); //取文本值并打印
		
		System.out.println(textArea.isDisplayed()); //检查该文本在不在当前页面显示
		
		//返回false
		WebElement invisibleBtn = driver.findElement(By.name("invisible"));
		System.out.println(invisibleBtn.isDisplayed());
		
		//使用findElements返回当前页面所有匹配的tag，并存到一个List的接口对象中
		List<WebElement> elements = driver.findElements(By.tagName("input")); 
		
		for(int i = 0; i < elements.size(); i++)
		{
			WebElement element = elements.get(i);
			System.out.println("tag: " + element.getTagName() + " | value: " + element.getAttribute("value"));
		}
		
		//使用findElements解决异常
		elements = driver.findElements(By.xpath("//div1"));
		int num_elements = elements.size();
		if(num_elements != 0)
		{
			textArea = driver.findElement(By.xpath("//div1")); //用xpath定位普通文本
			System.out.println(textArea.isDisplayed()); //检查该文本在不在当前页面显示
			System.out.println(textArea.getText()); //取文本值并打印
		}
		else
		{
			System.out.println("xpath是//div1的textArea不存在");
		}
		driver.quit();
	}
}
