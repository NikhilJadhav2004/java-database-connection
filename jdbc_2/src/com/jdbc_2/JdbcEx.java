package com.jdbc_2;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "Admin@123");

			con.setAutoCommit(false);	

			Statement st = con.createStatement();
			st.execute("create table rscoe5(id int,name varchar(20))");

			String insert = "insert into rscoe5 (id,name) values(?,?)";

			PreparedStatement prst = con.prepareStatement(insert);

			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			String name = sc.next();
			prst.setInt(1, a);
			prst.setString(2, name);
			prst.addBatch();
			prst.executeBatch();

			String s = "Select *from rscoe5";
			ResultSet sr = st.executeQuery(s);

		

				while (sr.next()) {

					System.out.println(sr.getInt(1) + " " + sr.getString(2));
				}
			
			con.commit();
			con.rollback();
			

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
