package com.ty.feachApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class FetchData {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			PreparedStatement pstmt1 = con.prepareStatement("select * from studentinfo.student");
			ResultSet rs=pstmt1.executeQuery();
			PreparedStatement pstmt2=con.prepareStatement("select * from productinfo.product");
			ResultSet rs2=pstmt2.executeQuery();
			PreparedStatement pstmt3=con.prepareStatement("select * from empinfo.emp");
			ResultSet rs3=pstmt3.executeQuery();
			System.out.println("-----------Students-------------");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			System.out.println("-----------PRODUCTS-------------");
			while(rs2.next()) {
				System.out.println(rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+rs2.getString(4)+rs2.getInt(5));
			}
			System.out.println("-----------EMPLOYEES-------------");
			while(rs3.next()) {
				System.out.println(rs3.getInt(1)+" "+rs3.getString(2)+" "+rs3.getString(3)+" "+rs3.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
