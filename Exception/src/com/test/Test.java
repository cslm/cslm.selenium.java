package com.test;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test 
{
	public static void main(String[] args)
	{
		//"try catch finally"捕获异常的几个例子
		
		/*File f = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\Exceptions\\files\\text.txt");
		FileReader fr = null;
		try 
		{
			fr = new FileReader(f);			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			System.exit(0);
			System.out.println("会打印我吗？");	
		}*/

		
		File f = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\Exceptions\\files\\text.txt");
		FileReader fr = null;
		
		try 
		{
			fr = new FileReader(f);			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				fr.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	
		//int i = 5/0;
		//System.out.println(i);
		//int[] arr = {1,2,3};
		//System.out.println(arr[3]);	
	}

}
