package com.pageobj;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{	
	WebDriver driver;
	Properties prop;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void getPageObjects()
	{
		try
		{
			//读取page object
		    File f = new File("C:/Users/marcoc/Dropbox/cslm sourcecode\\"
		    		+ "cslm.selenium.java\\SeleniumExcelKeywordDrivenPOM\\src"
		    		+ "\\com\\objrepository\\loginPage.properties");
		    FileInputStream fis = new FileInputStream(f);
		    prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//定位器判断
	public By getObject(String locator, String objString)
	{
		By obj = null;
		if(locator.equals("id"))
			obj = By.id(prop.getProperty(objString));
		else if(locator.equals("name"))
			obj = By.name(prop.getProperty(objString));
		else if(locator.equals("className"))
			obj = By.className(prop.getProperty(objString));
		else if(locator.equals("tagName"))
			obj = By.tagName(prop.getProperty(objString));
		else if(locator.equals("linkText"))
			obj = By.linkText(prop.getProperty(objString));
		else if(locator.equals("partialLinkText"))
			obj = By.partialLinkText(prop.getProperty(objString));
		else if(locator.equals("cssSelector"))
			obj = By.cssSelector(prop.getProperty(objString));
		else if(locator.equals("xpath"))
			obj = By.xpath(prop.getProperty(objString));
		
		return obj;
	}
	
	//操作方法
	public void openBrowser()
	{
		driver.get("http://cslm-test.com/hrsystem/index.php");
	}
	
	public void maximizeBrowserWindow()
	{
		driver.manage().window().maximize();
	}
	
	public void enter(String locator, String objString, String value) 
	{
		By obj = this.getObject(locator, objString);
		driver.findElement(obj).sendKeys(value);
	}
	
	public void click(String locator, String objString)
	{
		By obj = this.getObject(locator, objString);
		driver.findElement(obj).click();
	}

	public boolean verifyEqualString(String locator, String objString, String value)
	{
		boolean b = false;
		int count = driver.findElements(this.getObject(locator, objString)).size();
		if(count > 0)
		{
			By obj = this.getObject(locator, objString);
			WebElement element = driver.findElement(obj);
			if(element.getText().equals(value))
				b = true;
		}
		return b;
	}
	
	public boolean verifyElementDisplay(String locator, String objString)
	{
		boolean b = false;
		int count = driver.findElements(this.getObject(locator, objString)).size();
		if(count > 0)
		{
			By obj = this.getObject(locator, objString);
			WebElement element = driver.findElement(obj);
			if(element.isDisplayed())
				b = true;
		}
		return b;
	}
}
