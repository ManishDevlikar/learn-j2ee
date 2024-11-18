package com.ty.fetchApp.practice;
import java.sql.*;
public class FetchDataUsingPreparedStatementInteface {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt=con.prepareStatement("select * from studentinfo.student where id=3");
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
