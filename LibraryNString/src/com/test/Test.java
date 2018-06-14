package com.test;

public class Test 
{
	public static void main(String[] args) 
	{
		String str = new String("you are a tester, me too");
		System.out.println("打印出来的结果是：" + str);
		
		char c = str.charAt(2);
		System.out.println(c);
		
		String str1 = str.concat(". Nice to meet you.");
		System.out.println(str1);
		
		if(str1.contains(str))
		{
			System.out.println("str1包含str");
		}
		else
		{
			System.out.println("str1不包含str");
		}
		
		int lengthOfStr = str.length();
		System.out.println(lengthOfStr);
		
		String str2 = str.replace("tester", "developer");
		System.out.println(str2);
		
		String str3 = str.substring(5);
		System.out.println(str3);
		
		String str4 = new String("abc");
		String str5 = "abc";
		System.out.println(str4.equals(str5));
		System.out.println(str4 == str5);
	}
}