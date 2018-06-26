package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/elements/webelements.html");
		driver.manage().window().maximize();
		
		WebElement hobbyDropDownList = driver.findElement(By.name("hobby"));
		Select hobbyOptions = new Select(hobbyDropDownList);
		hobbyOptions.selectByIndex(0);
		hobbyOptions.selectByVisibleText("看电影");	
		
		hobbyOptions.deselectByIndex(0); //去掉"足球"
		hobbyOptions.selectByValue("swimming");
		
		hobbyOptions.deselectAll(); //去掉全部选择
		System.out.println(hobbyOptions.isMultiple());
	}
}
