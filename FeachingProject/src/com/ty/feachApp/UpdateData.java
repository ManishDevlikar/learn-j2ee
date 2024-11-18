package com.ty.feachApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// write the code to update the records in multiple table using preparedStatement
public class UpdateData {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			PreparedStatement pstmt1=con.prepareStatement("update studentinfo.student set name='raj' where id=1");
			PreparedStatement pstmt2=con.prepareStatement("update productinfo.product set pname='apple se 1' where pno=44");
			PreparedStatement pstmt3=con.prepareStatement("update empinfo.emp set name='eren' where id=1");
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
