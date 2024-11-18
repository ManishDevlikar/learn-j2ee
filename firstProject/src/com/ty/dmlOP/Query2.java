package com.ty.dmlOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Query2 {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement();
//			stmt.executeUpdate("insert into studentinfo.student values(3,'rohan',22)");
//			stmt.execute("update studentinfo.student set name='sunny' where name='monu'");
			stmt.execute("delete from studentinfo.student where age=89");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
