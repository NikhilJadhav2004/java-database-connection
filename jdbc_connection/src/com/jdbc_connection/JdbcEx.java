package com.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.xdevapi.Statement;

public class JdbcEx {

	public static void main(String[] args) {
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Admin@123");
			
			java.sql.Statement st= con.createStatement();
			
			
			
			//st.execute("create database jspm");
			//System.out.println("done");
			/*
			 * st.execute("use jspm");
			 * st.execute("create table entc(id int,name varchar(20))");
			 * st.execute("insert into entc values(1,'nikhil'),(2,'om'),(3,'pratik')");
			 * st.execute("select *from entc"); System.out.println("done");
			 */
			st.execute("update entc set name='ram' where id=3");
			System.out.println("done");
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
