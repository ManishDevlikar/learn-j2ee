package com.ty.productApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetriveUsingPlaceholder {

	public static void main(String[] args) {

//wajc to fetch the records where id=placeholder
		// TODO Auto-generated method stub
		String fqcn = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";
		String resQuery = "select * from ProductInfo.Product where pno =?";
		Scanner sc = new Scanner(System.in);
		System.out.println("id number");
		int pid = sc.nextInt();
		try {
			Class.forName(fqcn);

			Connection con = DriverManager.getConnection(url);

			PreparedStatement pstmt = con.prepareStatement(resQuery);
			pstmt.setInt(1, pid);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getInt(4));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
}