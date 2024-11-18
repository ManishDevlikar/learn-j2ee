package com.ty.feachApp;
// wjdbc c to fetch the records where id = placehoder
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentPlaceholder {
	public static void main(String[] args) {
		String qry="insert into studentinfo.student values(?,?,?)";
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		Scanner sc=new Scanner(System.in);
		System.out.println("id");
		int id= sc.nextInt();
		System.out.println("name");
		String name=sc.next();
		System.out.println("age");
		int age=sc.nextInt();

		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt =con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
