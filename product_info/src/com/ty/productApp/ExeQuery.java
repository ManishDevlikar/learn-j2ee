package com.ty.productApp;
import java.sql.*;
public class ExeQuery {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String path="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try{
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(path);
			Statement stmt=con.createStatement();
			
		ResultSet rs=stmt.executeQuery("select * from studentinfo.student");
		while(rs.next()) {
			System.out.println(rs.getString(2));
		}
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
