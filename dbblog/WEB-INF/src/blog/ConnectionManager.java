package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	static String DRIVER = "com.mysql.jdbc.Driver";

	static String URL = "jdbc:mysql://localhost/mydb";

	static String USER ="root";

	static String PASS = "password";

	public static Connection getConnection() throws SQLException{
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		return conn;
	}

	public static void main(String[]args)throws SQLException{
		Connection conn = getConnection();
		Statement smt = conn.createStatement();
		ResultSet rs = smt.executeQuery("select * from account");

		while (rs.next()) {
			String s = "NAME=" +rs.getString("NAME") +", MONEY="+rs.getString("MONEY");
			System.out.println(s);
		}
		smt.close();
		conn.close();
		System.out.println("END");
	}


}
