package com.testalliance.hrsystem.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Utility 
{
	//读取测试模块
	public ArrayList<String[]> getModules(String filePath)
	{
		ArrayList<String[]> al = new ArrayList<String[]>();
		File f = new File(filePath);
		FileReader fr = null;
		BufferedReader br = null;
		
		try 
		{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String line = null;
			//用arr_loginDetails数组来存用逗号分开的字符串
			String[] arr_testdata;
			
			while((line = br.readLine()) != null)
			{
				//split分字符串
				arr_testdata = line.split(",");
				
				//用al_loginDetailsGroup数组来存每一次循环完的字符串数组
				al.add(arr_testdata);	
			}	
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//关闭文件
			try
			{
				br.close();
				fr.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return al;
	}

}
