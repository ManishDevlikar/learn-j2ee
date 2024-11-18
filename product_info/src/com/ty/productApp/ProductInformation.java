package com.ty.productApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class ProductInformation {
	public static void main(String[] args) {
		String fqcn="com.mysql.jdbc.Driver";
		String path="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(path);
			Statement stmt=con.createStatement();
//			stmt.execute("insert into productinfo.product values(6,'Nothing 2','Nothing',35000,1)"); // to insert data
//			stmt.executeUpdate("update productinfo.product set pname='Oppo' where pno=1");           // to update data
			stmt.executeUpdate("delete from studentinfo.student where name='manish'");				 // to delete data
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
