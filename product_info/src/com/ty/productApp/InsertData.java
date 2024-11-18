package com.ty.productApp;
//write a jdbc code to insert the records in employee t, student t and product table at ones
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
public class InsertData {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String path="jdbc:mysql://localhost:3306?user=root&password=root5003";
		                        
		String std="insert into studentinfo.student values(90,'maxiiie',23)";
		String emp="insert into empinfo.emp values(1,'manish',10000,'SDE')";
		String prod="insert into productinfo.product values(44,'xiaomi 13','xiaomi',30000,1)";
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(path);
			Statement stmt=con.createStatement();
			stmt.execute(std);
			stmt.execute(emp);
			stmt.execute(prod);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}