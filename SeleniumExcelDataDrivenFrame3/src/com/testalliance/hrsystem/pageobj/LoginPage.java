package com.testalliance.hrsystem.pageobj;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	private String url;
	private By id_usercode;
	private By id_password;
	private By css_login;
	private By xpath_menuHome;
	private By link_logout;
	private By xpath_errmsg;
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void getPageObjects()
	{
		try
		{
			//读取page object
		    File f = new File(System.getProperty("user.dir") + 
		    				"//src//com//testalliance//hrsystem//objrepository"
		    				+ "//loginPage.properties");
		    FileInputStream fis = new FileInputStream(f);
		    Properties prop = new Properties();
			prop.load(fis);
			
			url = prop.getProperty("url");
			id_usercode = By.id(prop.getProperty("textbox_usercode"));
			id_password = By.id(prop.getProperty("textbox_password"));
			css_login = By.cssSelector(prop.getProperty("btn_login"));
			xpath_menuHome = By.xpath(prop.getProperty("link_menu_home"));
			link_logout = By.linkText(prop.getProperty("btn_logout"));
			xpath_errmsg = By.xpath(prop.getProperty("textarea_errmsg"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void openBrowser()
	{
		driver.get(url);
	}
	
	public void maximizeBrowserWindow()
	{
		driver.manage().window().maximize();
	}
	
	public void enterUserName(String usercode) 
	{
		driver.findElement(id_usercode).sendKeys(usercode);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(id_password).sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(css_login).click();
	}
	
	public void login(String usercode, String password)
	{
		if(!usercode.equals("null"))
			this.enterUserName(usercode);
		if(!password.equals("null"))
			this.enterPassword(password);
		this.clickLogin();
	}
	
	public void clickLogout()
	{
		driver.findElement(link_logout).click();
	}
	
	public boolean verifyMenuHomeText()
	{
		boolean b = false;
		int numOfMenuHome = driver.findElements(xpath_menuHome).size();
		if(numOfMenuHome > 0)
		{
			WebElement menu_home = driver.findElement(xpath_menuHome);
			if(menu_home.getText().equals("Home"))
				b = true;
		}
		return b;
	}
	
	public boolean verifyLoginBtnExist()
	{
		boolean b = false;
		int numOfLoginBtn = driver.findElements(css_login).size();
		if(numOfLoginBtn > 0)
		{
			WebElement btn_login = driver.findElement(css_login);
			if(btn_login.isDisplayed())
				b = true;
		}
		return b;
	}
	
	public boolean verifyErrMsgDisplay()
	{
		int count = driver.findElements(xpath_errmsg).size();
		if(count > 0)
		{
			WebElement textarea_errmsg = driver.findElement(xpath_errmsg);
			if(textarea_errmsg.isDisplayed())
				return true;
		}
		return false;
	}
	
	public boolean verifyErrAlertDisplay()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean verifyErrAlertMsg(String value)
	{
		boolean b = false;
		if(this.verifyErrAlertDisplay())
		{
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			if(alertMsg.equals(value))
				b = true;
			alert.accept();
		}
		return b;
	}
}
