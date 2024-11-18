package com.carwaleApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Car {
	static Connection con = null;
	static Scanner sc = new Scanner(System.in);

	public static void sellCar() {
		try {
			System.out.println("Enter Id");
			int id = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter modal");
			String modal = sc.next();
			System.out.println("Enter price");
			String price = sc.next();
			PreparedStatement pstmt = con.prepareStatement("insert into carwale.car values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, modal);
			pstmt.setString(4, price);
			pstmt.execute();
			repeat();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void buyCar() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from carwale.car");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
			System.out.println("Enter Id to buy car");
			int cno = sc.nextInt();
			PreparedStatement pstmt2 = con.prepareStatement("delete from carwale.car where cno = ? ");
			pstmt2.setInt(1, cno);
			pstmt2.executeUpdate();
			repeat();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void seeCar() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from carwale.car");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
			repeat();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void seeLatestCar() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from carwale.latestcar");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
			repeat();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void repeat() {
		System.out.println("Choose option 1:sell  2:buy 3:see 4:see latest 5:exit");
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			sellCar();
		}
			break;
		case 2: {
			buyCar();
		}
			break;
		case 3: {
			seeCar();
		}
			break;
		case 4: {
			seeLatestCar();
		}
			break;
		case 5: {
			System.out.println("Do You Want To Exit");
			String yesOrNo = sc.next();
			if (yesOrNo.equalsIgnoreCase("yes")) {
				System.out.println("Thanks for using our services");
				break;
			} else {
				repeat();
				break;
			}
		}
		default:
			System.out.println("invalid input");
			repeat();
		}
	}

	public static void main(String[] args) {

		String fqcn = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";

		try {
			Class.forName(fqcn);
			con = DriverManager.getConnection(url);
			repeat();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
