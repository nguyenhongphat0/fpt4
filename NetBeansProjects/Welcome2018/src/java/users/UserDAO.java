/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.QueryBuilder;

/**
 *
 * @author nguyenhongphat0
 */
public class UserDAO {
    public boolean checkLogin(String userId, int password) throws SQLException, NamingException {
        return new QueryBuilder()
                .connect()
                .prepare("SELECT * FROM tbl_User WHERE userId = ? AND password = ?")
                .setString(userId)
                .setInt(password)
                .execute()
                .res.next();
    }
    
    public List<UserDTO> searchFullname(String s) throws SQLException, NamingException {
        List<UserDTO> list = new ArrayList();
        new QueryBuilder()
                .connect()
                .prepare("SELECT * FROM tbl_User WHERE fullname LIKE ?")
                .setString("%" + s + "%")
                .execute()
                .each(((res) -> {
                    String userId = res.getString("userId");
                    int password = res.getInt("password");
                    String fullName = res.getString("fullName");
                    int role = res.getInt("role");
                    list.add(new UserDTO(userId, password, fullName, role));
                }));
        return list;
    }
    
}
