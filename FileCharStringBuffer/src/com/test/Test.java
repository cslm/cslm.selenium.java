package com.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test 
{
	public static void main(String[] args) throws IOException 
	{
		//准备test.txt和test1.txt文件对象
		File f_old = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\FileOperations\\files\\text.txt");
		File f_new = new File("C:\\Users\\marcoc\\Dropbox\\cslm sourcecode\\cslm.selenium.java\\FileOperations\\files\\text1.txt");
		
		FileReader fr = null;
		
		//声明缓冲字符流(读)
		BufferedReader br = null;
		
		FileWriter fw = null;
		
		//声明缓冲字符流(写)
		BufferedWriter bw = null;
	
		try 
		{
			fr = new FileReader(f_old);
			fw = new FileWriter(f_new);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			String line = br.readLine();
			
			while(line != null) //当这个字符串存在时则写到文件里
			{
				bw.write(line + "\n"); //写完一行不会默认换行，我们需要加上"\n"强制换行
				line = br.readLine(); //每次读取一行
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			br.close();
			bw.close();
			fr.close();
			fw.close();
		}
	}
}
