package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test 
{
	public static void main(String[] args)
	{
		/***********************Chrome***********************************/
		System.setProperty("webdriver.chrome.driver", "D:/tools/chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();		
		
		chromeDriver.get("http://cslm-test.com/webapps/elements/webelements.html");	
		chromeDriver.manage().window().maximize();
		
		String title = chromeDriver.getTitle();
		System.out.println(title);
		
		String currentUrl = chromeDriver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String pageSource = chromeDriver.getPageSource();
		System.out.println(pageSource);
		
		chromeDriver.quit();
		
		/***********************IE***********************************/
		System.setProperty("webdriver.ie.driver", "C:/tools/IEDriverServer.exe");
		WebDriver ieDriver = new InternetExplorerDriver();
		
		ieDriver.get("http://cslm-test.com/webapps/elements/webelements.html");
		ieDriver.manage().window().maximize();
		
		System.out.println(ieDriver.getTitle()); //打印网页标题
		System.out.println(ieDriver.getCurrentUrl()); //打印网址
		System.out.println(ieDriver.getPageSource()); //打印网页源代码

		ieDriver.quit();
		
		
		/***********************FireFox***********************************/
		System.setProperty("webdriver.firefox.marionette", "D:/tools/geckodriver.exe");
		WebDriver ffDriver = new FirefoxDriver();
		
		ffDriver.get("http://cslm-test.com/webapps/elements/webelements.html");
		ffDriver.manage().window().maximize();
		
		System.out.println(ffDriver.getTitle());
		System.out.println(ffDriver.getCurrentUrl());
		System.out.println(ffDriver.getPageSource());
		
		ffDriver.quit();	
	}
}