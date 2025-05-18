package jdbc_conccept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class JdbcEx {
public static void main(String[] args) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/collage";
		String user="root";
		String pasward="Admin@123";
	   Connection con=DriverManager.getConnection(url, user, pasward);
	   
	   Statement st=con.createStatement();
	   
	   String s="create table abcd(id int,name varchar(20))";
	   
	   st.execute(s);
	   
	   String a="insert into abcd (id,name) values(?,?)";
	   
	   PreparedStatement prst=con.prepareStatement(s);
	   
	   Scanner sc=new  Scanner(System.in);
	   
	
		   System.out.println("enter the id");
		  int p=sc.nextInt();
		  System.out.println("enter the name");
		  String q=sc.next();
		  
		 prst.setInt(1, p);
		 prst.setString(2, q);
		  java.sql.ResultSetMetaData rsmd=(java.sql.ResultSetMetaData) con.getMetaData();
		  
		  System.out.println(rsmd.getColumnName(1)+" "+rsmd.getColumnName(2));
		  
		  String b="select *form abcd";
		  
		  ResultSet rs=st.executeQuery(b);
		  
		  while(rs.next()) {
			  System.out.println(rs.getInt(1)+" "+rs.getString(2));
		  }
	
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	
	
}
