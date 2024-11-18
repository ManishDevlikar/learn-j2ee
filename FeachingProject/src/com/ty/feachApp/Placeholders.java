package com.ty.feachApp;
import java.sql.*;
import java.util.Scanner;
public class Placeholders {
	public static void main(String[] args) {
		String qry="insert into productinfo.product values(?,?,?,?,?)";
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		Scanner sc=new Scanner(System.in);
		System.out.println("id");
		int id= sc.nextInt();
		System.out.println("name");
		String name=sc.next();
		System.out.println("brand");
		String brand=sc.next();
		System.out.println("price");
		String price=sc.next();
		System.out.println("quantity");
		String quant=sc.next();
		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt =con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, brand);
			pstmt.setString(4, price);
			pstmt.setString(5, quant);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
