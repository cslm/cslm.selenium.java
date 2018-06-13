class Document
{
	// 国家目标
	public String countryGoal = "犯我强汉者，虽远必诛";
	
	// 国家计划
	public void countryPlan()
	{
		System.out.println("国家百年大计:");
		System.out.println("1. 10年内全国实现0贫穷");
		System.out.println("2. 20年内全面赶美超英赢小日本");
		System.out.println("3. 50年内打败一切试图分裂中国的力量，讨叛逆，灭恐袭");
		System.out.println("4. 100年内我大中华四夷宾服，统治世界");
	}
}
class Test
{
	public static void main(String[] args)
	{
		Document p1 = new Document();
		System.out.println("国家目标: " + p1.countryGoal);
		p1.countryPlan();
	}
}