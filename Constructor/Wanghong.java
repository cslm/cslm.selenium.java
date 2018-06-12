class Wanghong
{
	String name;
	int age; 
	String hobby;
	
	public Wanghong(String name, int age, String hobby)
	{
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
}
class Test
{
	public static void main(String[] args)
	{
		Wanghong wsc = new Wanghong("王思聪", 30, "打游戏");
		Wanghong mm = new Wanghong("咪蒙", 18, "写文章");
		
		// 打印王思聪个人信息
		System.out.println("王思聪个人信息: ");
		System.out.println("姓名: " + wsc.name);
		System.out.println("年龄: " + wsc.age);
		System.out.println("爱好: " + wsc.hobby);
		
		System.out.println();
		
		// 打印咪蒙个人信息
		System.out.println("咪蒙个人信息: ");
		System.out.println("姓名: " + mm.name);
		System.out.println("年龄: " + mm.age);
		System.out.println("爱好: " + mm.hobby);
	}
}