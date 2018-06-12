public class Variables
{
	public static void main(String[] args)
	{
		int a = 5, b = 5;
		
		if(a == b && a < 6)
		{
			System.out.println("我是条件1");
		}
		if(a > b || b ==5)
		{
			System.out.println("我是条件2");
		}
		if(!(a>=b))
		{
			System.out.println("我是条件3");
		}
	}
}