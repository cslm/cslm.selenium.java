package com.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test 
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\FileOperations\\files\\text.txt");
		FileReader fr = null;
		
		try 
		{
			fr = new FileReader(f);
			int n = 0;
			n = fr.read();
			while(n != -1)
			{
				char c = (char)n;
				System.out.print(c);
				n = fr.read();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			fr.close(); // 关闭文件流对象
		}
	}
}
