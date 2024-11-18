package com.ty.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DMLOperation {
	public static void main(String[] args) {
		String fqcn = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";

		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			System.out.println(con);
			Statement stmt = con.createStatement();
			System.out.println(stmt);
			stmt.executeUpdate("dml");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
