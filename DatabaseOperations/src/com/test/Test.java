package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver"); //声明jdbc driver
		Connection ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/humanresources",
													"root", "123.com"); //连接数据库
		Statement stmt = ct.createStatement(); //准备数据库指令发送器
		
		//更新员工
		int d = stmt.executeUpdate("update Employee set isDeleted = 1 where employeeCode = '1004'");
		if(d == 1)
			System.out.println("更新成功");
		else
			System.out.println("更新失败");
	}
}