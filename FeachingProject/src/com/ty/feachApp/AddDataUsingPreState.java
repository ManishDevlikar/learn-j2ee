package com.ty.feachApp;
import java.sql.*;
import java.sql.DriverManager;

// write a jdbc code to insert the record in student table using PreparedStatement Interface
public class AddDataUsingPreState {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			PreparedStatement pstmt=con.prepareStatement("insert into studentinfo.student values(11,'sunny',19)");
			pstmt.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
