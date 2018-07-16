package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Test 
{
	public static void main(String[] args)
	{
		try
		{
			Properties prop = new Properties();
			File f = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode"
					+ "\\cslm.selenium.java\\PropertiesFile\\src\\Files\\file.properties");
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
			System.out.println(prop.getProperty("name"));
			System.out.println(prop.getProperty("gender"));
			System.out.println(prop.getProperty("age"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
