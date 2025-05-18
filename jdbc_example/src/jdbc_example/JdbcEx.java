package jdbc_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
		
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.mysql.cj.xdevapi.PreparableStatement;

public class JdbcEx {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "Admin@123");

			Statement st = con.createStatement();

			st.executeUpdate("create table rscoe2(id int,name varchar(20))");

			String insert = "insert into rscoe2 values(?,?)";

			PreparedStatement prst = con.prepareStatement(insert);

			// method to use insert the values in data base
			/*
			 * prst.setInt(1, 100); prst.setString(2, "nikhil");
			 * 
			 * prst.executeUpdate();
			 */

			Scanner sc = new Scanner(System.in);

			System.out.println("how many entry we have to insert");
			int p = sc.nextInt();
			for (int i = 0; i < p; i++) {

				System.out.println("enter the rollno");
				int r = sc.nextInt();
				System.out.println("enter the name");
				String s = sc.next();

				prst.setInt(1, r);
				prst.setString(2, s);

				prst.executeUpdate();

			}

			String select = "select *from rscoe2";

			ResultSet rs = prst.executeQuery(select);

			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			System.out.println(rsmd.getColumnName(1) + " " + rsmd.getCatalogName(2));

			while (rs.next()) {

				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
