package com.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test 
{
	public static void main(String[] args) throws IOException
	{
		File f_old = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\FileOperations\\files\\text.txt");
		File f_new = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\FileOperations\\files\\text1.txt");
		FileReader fr = null;
		FileWriter fw = null;
		
		try 
		{
			fr = new FileReader(f_old);
			fw = new FileWriter(f_new);
			
			int n = 0;
			char[] arr_c = new char[200];
			n = fr.read(arr_c);
			
			while(n != -1)
			{
				String line = new String(arr_c, 0, n);
				fw.write(line);
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
			fw.close();
		}
	
	}
}
