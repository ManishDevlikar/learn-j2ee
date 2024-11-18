package com.ty.dmlOP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//import java.sql.*;
public class Query1 {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into studentinfo.student values(45,'monu',89)");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
