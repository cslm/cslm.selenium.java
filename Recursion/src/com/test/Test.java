package com.test;

public class Test 
{
	public static void main(String[] args)
	{
		Test t = new Test();
		t.countDown(100,0);
	}
	
	public void countDown(int i, int j)
	{
		j++;
		System.out.print("第" + j + "次递归,");
		i -= 10;
		System.out.println(" 此时的i值为" + i);
		if(i > 0)
		{
			countDown(i, j);
		}
		System.out.println("第" + j + "次递归结束后的i值为" + i);
	}
}


