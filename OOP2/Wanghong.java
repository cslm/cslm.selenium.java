class Wanghong
{
	String name;
	int age;
	String hobby;
	
	public void writing() //无返回值无参数方法
	{
		System.out.println("今晚写文章");
	}
	
	public int countGuai() //不带参数的countGuai方法
	{
		int total = 0;
		for(int i = 0; i <= 5;i++)
		{
			total += 10;
		}
		return total;
	}
	
	//带一个参数的countGuai方法，没有返回值
	public void countGuai(int numOfEach) 
	{
		System.out.println("该countGuai方法虽然带一个参数，但没有返回值");
	}
	
	//带两个参数的countGuai方法
	public int countGuai(int numOfEach, int n) 
	{
		int total = 0;
		for(int i = 0; i <= n;i++)
		{
			total += numOfEach;
		}
		return total;
	}
	
	//带三个参数的countGuai方法，参数顺序为numOfEach，n，str
	public int countGuai(int numOfEach, int n, String str) 
	{
		System.out.print(str);
		int total = 0;
		for(int i = 0; i <= n;i++)
		{
			total += numOfEach;
		}
		return total;
	}
	
	//带三个参数的countGuai方法，参数顺序为str，numOfEach，n
	public int countGuai(String str, int numOfEach, int n) 
	{
		System.out.print(str);
		int total = 0;
		for(int i = 0; i <= n;i++)
		{
			total += numOfEach;
		}
		return total;
	}
	
	public static void main(String[] args)
	{
		Wanghong wsc = new Wanghong();
		Wanghong mm = new Wanghong();
		
		wsc.age = 30; 
		mm.age = 18; 
		wsc.name = "王思聪"; 
		mm.name = "咪蒙";
		wsc.hobby = "打游戏"; 
		mm.hobby = "写文章";
		
		System.out.println(wsc.name);
		System.out.println(wsc.age);
		System.out.println(wsc.hobby);
		
		System.out.println(mm.name);
		System.out.println(mm.age);
		System.out.println(mm.hobby);
		
		mm.writing();
		//System.out.println("调用不带参数的countGuai方法，打怪数目为： " + wsc.countGuai());
		wsc.countGuai(20);
		System.out.println("调用带两个参数有返回值的countGuai方法，打怪数目为： " + wsc.countGuai(20,5));
		System.out.print("调用带三个参数的countGuai方法，参数顺序为numOfEach，n，str，打怪数目为： ");
		System.out.println(wsc.countGuai(20,5,"(参数顺序为numOfEach n str)"));
		System.out.print("调用带三个参数的countGuai方法，参数顺序为str numOfEach n，打怪数目为： ");
		System.out.println(wsc.countGuai("(参数顺序为str numOfEach n)",20,5);
	}
}