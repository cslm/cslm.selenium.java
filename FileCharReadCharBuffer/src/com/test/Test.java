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
			char[] arr_c = new char[200];
			
			n = fr.read(arr_c);
			
			while(n != -1)
			{
				String line = new String(arr_c, 0, n);
				System.out.print(line);
				n = fr.read(arr_c);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			fr.close();
		}
	}
}
