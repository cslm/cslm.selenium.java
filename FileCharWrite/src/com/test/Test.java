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
			n = fr.read();
			
			while(n != -1)
			{
				fw.write(n);
				n = fr.read();
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