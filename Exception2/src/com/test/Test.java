package com.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class ExceptionTest
{
	public void readFile() throws IOException 
	{
		File f = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\Exceptions\\files\\text.txt");
		FileReader fr = new FileReader(f);	
		int n = 0;
		n = fr.read();
		while(n != -1)
		{
			char c = (char)n;
			System.out.print(c);
			n = fr.read();
		}
		fr.close();
	}
}

public class Test 
{
	public static void main(String[] args) throws IOException
	{
		ExceptionTest et = new ExceptionTest();
		et.readFile();
	}

}
