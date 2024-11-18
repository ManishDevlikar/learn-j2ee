package com.ty.feachApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// write a program to insert record in multiple table using PreparedStatement
public class InsertData {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			PreparedStatement pstmt1=con.prepareStatement("insert into studentinfo.student values(12,'speed',90)");
			PreparedStatement pstmt2=con.prepareStatement("insert into productinfo.product values(9,'iphone 13','Apple',80000,1)");
			PreparedStatement pstmt3=con.prepareStatement("insert into empinfo.emp values(2,'sunny',90000,'Devloper')");
			pstmt1.execute();
			pstmt2.execute();
			pstmt3.execute();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
