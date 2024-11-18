package com.ty.feachApp; 
// To Fetch Data from DataBase
import java.sql.*;
public class DQLOperation {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from studentinfo.student");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3) );
		}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
