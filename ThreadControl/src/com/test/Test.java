package com.test;

class A extends Thread
{
	int i = 1;
	public void run()
	{
		while(i <= 10)
		{
			System.out.println(Thread.currentThread().getName() 
					+ "正在执行第" + i + "个任务");
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			i++;
		}
	}
}
public class Test 
{
	public static void main(String[] args)
	{
		A a = new A();
		a.start();
	}
}