package com.ty.feachApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//wjdbc c to fetch the records where id = placeholder
public class ResultSetPlaceholders {
	public static void main(String[] args) {
		String fqcn = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";

		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		String query = "select * from studentinfo.student where id =?";

		try {
			Connection con = DriverManager.getConnection(url);
			Class.forName(fqcn);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + rs.getString(2) + rs.getInt(3));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
