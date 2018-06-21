package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test 
{
	public static void main(String[] args) throws IOException 
	{
		File f_old = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\FileOperations\\files\\picByte.jpg");
		File f_new = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\FileOperations\\files\\picByte1.jpg");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try 
		{
			fis = new FileInputStream(f_old);
			fos = new FileOutputStream(f_new);
			
			int n = 0;
			byte b[] = new byte[200];
			n = fis.read(b);
			
			while(n != -1)
			{
				fos.write(b, 0, n); //把当前读入b数组的所有字节进行写入
				n = fis.read(b);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			fis.close();
			fos.close();
		}
	}
}
