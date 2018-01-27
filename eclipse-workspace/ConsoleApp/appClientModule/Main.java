import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "root", "hongphat");
		ResultSet res = conn.createStatement().executeQuery("SELECT * FROM users WHERE username = 'nguyenhongphat0' AND password = 'hongphat'");
		while (res.next()) {
			System.out.println("Hello " + res.getString("fullname"));
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
}