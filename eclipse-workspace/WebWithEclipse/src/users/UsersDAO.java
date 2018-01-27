package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DatabaseUtils;

public class UsersDAO {
	public boolean checkLogin(String username, String password)
			throws SQLException, ClassNotFoundException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		pre = conn.prepareStatement(sql);
		pre.setString(1, username);
		pre.setString(2, password);
		res = pre.executeQuery();
		if (res.next()) {
			return true;
		}
		return false;
	}
	
	private List<UsersDTO> userslist;
	
	public List<UsersDTO> getUserslist() {
		return userslist;
	}
	
	public void searchUsers(String searchvalue)
			throws ClassNotFoundException, SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pre = conn.prepareStatement("SELECT * FROM users WHERE fullname LIKE ?");
		pre.setString(1, "%" + searchvalue + "%");
		ResultSet res = pre.executeQuery();
		while (res.next()) {
			String username = res.getString(1);
			String password = res.getString(2);
			String fullname = res.getString(3);
			boolean is_admin = res.getBoolean(4);
			UsersDTO dto = new UsersDTO(username, password, fullname, is_admin);
			if (userslist == null) {
				userslist = new ArrayList<UsersDTO>();
			}
			userslist.add(dto);
		}
	}
}
