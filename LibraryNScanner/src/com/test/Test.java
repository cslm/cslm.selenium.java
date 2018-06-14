package com.test;

import java.util.Scanner;
public class Test 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入一个字符串：");
		scan.useDelimiter("\n");
		String str = scan.next();
		System.out.println("输入的字符串是：" + str);
	}
}