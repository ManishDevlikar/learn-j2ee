package com.ty.feachApp;
//To Fetch Specific Data from DataBase
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DQLOperationPerticular {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from studentinfo.student where id=1");
		if(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3) );
		}else {
			System.out.println("not found");
		}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
