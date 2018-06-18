package com.test;

public class Test 
{
	public static void main(String[] args)
	{
		int arr[][] = new int[2][3];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3; 
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		
		//循环行, arr.length返回的是总行数
		for(int i = 0; i < arr.length; i++)
		{
			//循环列, arr[i].length返回的是每一行的总列数
			for(int j = 0; j < arr[i].length; j++)
			{
				System.out.println(arr[i][j]);
			}
		}
	}
}
