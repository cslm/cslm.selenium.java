package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test 
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\FileOperations\\files\\picByte.jpg");
		FileInputStream fis = null;
		
		try 
		{
			fis = new FileInputStream(f);
			
			int n = 0;
			n = fis.read();
			while(n != -1)
			{
				char c = (char)n;
				System.out.print(c);
				n = fis.read();
			}			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			fis.close();
		}	
	}
}