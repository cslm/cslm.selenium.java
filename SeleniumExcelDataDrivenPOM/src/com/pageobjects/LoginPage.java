package com.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	private By id_usercode;
	private By id_password;
	private By css_login;
	private By xpath_menuHome;
	private By link_logout;
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
		    File f = new File("C://Users//marcoc//Dropbox//cslm sourcecode//cslm.selenium.java"
		    		+ "//SeleniumExcelDataDrivenPOM//src//com//objrepository//loginPage.properties");
		    FileInputStream fis = new FileInputStream(f);
		    Properties prop = new Properties();
			prop.load(fis);
			
			id_usercode = By.id(prop.getProperty("textbox_usercode"));
			id_password = By.id(prop.getProperty("textbox_password"));
			css_login = By.cssSelector(prop.getProperty("btn_login"));
			xpath_menuHome = By.xpath(prop.getProperty("link_menu_home"));
			link_logout = By.linkText(prop.getProperty("btn_logout"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
		this.enterUserName(usercode);
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
}
