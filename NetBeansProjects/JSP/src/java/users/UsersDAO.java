/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class UsersDAO implements Serializable {
    public boolean checkLogin(String username, String password) 
        throws SQLException, ClassNotFoundException {
        // 1. Mo connection
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                // 2. Tao cau lenh truy van
                String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
                
                // 3. Tao statement
                stm = con.prepareStatement(sql);
                
                // 4. Truyen tham so
                stm.setString(1, username);
                stm.setString(2, password);
                
                // 5. Thuc thi cau lenh truy van
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs !=null ) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
