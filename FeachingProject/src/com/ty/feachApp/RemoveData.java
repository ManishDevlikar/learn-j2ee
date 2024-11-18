package com.ty.feachApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RemoveData {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			PreparedStatement pstmt1=con.prepareStatement("delete from studentinfo.student where id=1");
			pstmt1.executeUpdate();
			PreparedStatement pstmt2=con.prepareStatement("delete from productinfo.product where pno=2");
			pstmt2.executeUpdate();
			PreparedStatement pstmt3=con.prepareStatement("delete from empinfo.emp where id=1");
			pstmt3.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
