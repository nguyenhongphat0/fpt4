/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import phatnh.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class UserDAO implements Serializable {
    public boolean checkLogin(String userId, int password) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_User WHERE userId = ? AND password = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, userId);
            pre.setInt(2, password);
            res = pre.executeQuery();
            if (res.next()) {
                return true;
            }
        } finally {
            if (res != null) {
                res.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
