package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
	private static String username = "root";
	private static String password = "hongphat";
	private static String database = "javaweb";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/" + database;
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
}
