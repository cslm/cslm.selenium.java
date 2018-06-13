class Wanghong
{
	String name;
	int age;
	String hobby;
	static int total = 0;
	
	public Wanghong(String name, int age, String hobby)
	{
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	public static int jointAccount(int money)
	{
		total += money;
		
		return total;
	}  
}
class Test
{
	public static void main(String[] args)
	{
		Wanghong wsc = new Wanghong("王思聪", 30, "打游戏");
		Wanghong mm = new Wanghong("咪蒙", 18, "吃小龙虾");
		//使用类名调用静态方法
		System.out.println(wsc.name 
							+ "充完钱后账户余额: " 
							+ Wanghong.jointAccount(600)); 
		//使用类名调用静态方法	
		System.out.println(mm.name 
							+ "充完钱后账户余额: " 
							+ Wanghong.jointAccount(300)); 

		//使用类名调用静态变量	
		System.out.println("当前联合账户的余额是：" + Wanghong.total);
	}
}