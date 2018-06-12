class Setup
{
	String website;
	String browser;
	int waitTime;
	
	public Setup(String website, String browser, int waitTime)
	{
		this.website = website;
		this.browser = browser;
		this.waitTime = waitTime;
	}
} 
class Test
{
	public static void main(String[] args)
	{
		Setup s1 = new Setup("www.baidu.com", "chrome", 5);
		Setup s2 = new Setup("www.taobao.com", "firefox", 5);
		
		// 打印第一组设置信息
		System.out.println("第一组设置信息: ");
		System.out.println("网址: " + s1.website);
		System.out.println("浏览器: " + s1.browser);
		System.out.println("等待时间: " + s1.waitTime);
		
		System.out.println();
		
		// 打印第二组设置信息
		System.out.println("第二组设置信息: ");
		System.out.println("网址: " + s2.website);
		System.out.println("浏览器: " + s2.browser);
		System.out.println("等待时间: " + s2.waitTime);
	}
}